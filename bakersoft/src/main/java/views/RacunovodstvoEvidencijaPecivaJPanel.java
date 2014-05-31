package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controllers.RacunovodstvoEvidencijaPecivaController;
import utilities.Baza;
import entities.Dostava;
import entities.Klijent;
import entities.Korisnik;
import entities.Pecivo;
import entities.Racun;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class RacunovodstvoEvidencijaPecivaJPanel extends JPanel {
    private JTable pregledPecivaJTable;
    private JButton ukloniPecivoJButton;
    private JButton dodajPecivoJButton;
    private JButton azurirajJButton;    
    
    /**
     * Create the panel.
     */
    public RacunovodstvoEvidencijaPecivaJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Evidencija peciva:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JScrollPane pregledPecivaJScrollPane = new JScrollPane();
        GridBagConstraints gbc_pregledPecivaJScrollPane = new GridBagConstraints();
        gbc_pregledPecivaJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_pregledPecivaJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_pregledPecivaJScrollPane.gridx = 0;
        gbc_pregledPecivaJScrollPane.gridy = 0;
        add(pregledPecivaJScrollPane, gbc_pregledPecivaJScrollPane);

        pregledPecivaJTable = new JTable();
        pregledPecivaJTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"\u0160ifra", "Naziv", "Cijena", "Te\u017Eina", "U prodaji"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Object.class, Object.class, Object.class, Object.class, Boolean.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        pregledPecivaJScrollPane.setViewportView(pregledPecivaJTable);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 1;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        ukloniPecivoJButton = new JButton("Ukloni pecivo");
        GridBagConstraints gbc_ukloniPecivoJButton = new GridBagConstraints();
        gbc_ukloniPecivoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_ukloniPecivoJButton.insets = new Insets(0, 0, 0, 5);
        gbc_ukloniPecivoJButton.gridx = 0;
        gbc_ukloniPecivoJButton.gridy = 0;
        dugmadJPanel.add(ukloniPecivoJButton, gbc_ukloniPecivoJButton);

        azurirajJButton = new JButton("A\u017Euriraj");
        GridBagConstraints gbc_azurirajJButton = new GridBagConstraints();
        gbc_azurirajJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_azurirajJButton.gridx = 1;
        gbc_azurirajJButton.gridy = 0;
        dugmadJPanel.add(azurirajJButton, gbc_azurirajJButton);

        dodajPecivoJButton = new JButton("Dodaj pecivo");
        GridBagConstraints gbc_dodajPecivoJButton = new GridBagConstraints();
        gbc_dodajPecivoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_dodajPecivoJButton.gridx = 0;
        gbc_dodajPecivoJButton.gridy = 2;
        add(dodajPecivoJButton, gbc_dodajPecivoJButton);
        
      
        popuni();
        dodajListeners();

    }

    public JTable getPregledPecivaJTable() {
        return pregledPecivaJTable;
    }


    public JButton getUkloniPecivoJButton() {
        return ukloniPecivoJButton;
    }

    public JButton getDodajPecivoJButton() {
        return dodajPecivoJButton;
    }

    public JButton getAzurirajJButton() {
        return azurirajJButton;
    }
    

    private void dodajListeners()
    {
    	RacunovodstvoEvidencijaPecivaController racunovodstvoEvidencijaPecivaController = new RacunovodstvoEvidencijaPecivaController(this);
    	
    	dodajPecivoJButton.addActionListener(racunovodstvoEvidencijaPecivaController.getEvidencijaPecivaDodajPecivoJButtonActionListener()); 
    	azurirajJButton.addActionListener(racunovodstvoEvidencijaPecivaController.getEvidencijaPecivaAzurirajJButtonActionListener());
    	ukloniPecivoJButton.addActionListener(racunovodstvoEvidencijaPecivaController.getEvidencijaPecivaUkloniPecivoJButtonActionListener());
    }
    
    class PecivoTableModel extends DefaultTableModel
    {
    	private Pecivo pecivo;
    	private List<Pecivo> listaPeciva;
    	
    	PecivoTableModel(){}
    	
    	PecivoTableModel(List<Pecivo> peciva) {
            
                listaPeciva = peciva;
                List<Pecivo> obrisanaPeciva = new ArrayList<Pecivo>();
                for (Pecivo p : this.listaPeciva) {
                	if (p.isObrisano()) {
                        obrisanaPeciva.add(p);
                    }
                }
                listaPeciva.removeAll(obrisanaPeciva);
            }
        
    	
    	public List<Pecivo> getListaPeciva()
    	{
    		return listaPeciva;
    	}
    	
    	@Override
        public int getRowCount() {
            if (listaPeciva != null) {
                return listaPeciva.size();
            }

            return 0;
        }
    	
    	  @Override
    	    public int getColumnCount() {
    	        return 5;
    	    }

    	    @Override
    	    public String getColumnName(int columnIndex) {
    	        switch (columnIndex) {
    	            case 0:
    	                return "Šifra";
    	            case 1:
    	                return "Naziv";
    	            case 2:
    	                return "Cijena";
    	            case 3:
    	                return "Težina";
    	            case 4:
    	            	return "U prodaji";
    	            default:
    	                return null;
    	        }
    	    }
    	    @Override
    	    public Class<?> getColumnClass(int columnIndex) {
    	        switch (columnIndex) {
    	            case 0:
    	                return String.class;
    	            case 1:
    	                return String.class;
    	            case 2:
    	                return String.class;
    	            case 3:
    	                return String.class;
    	            case 4:
    	            	return Boolean.class;
    	            default:
    	                return null;
    	        }
    	    }
    	    
    	    @Override
    	    public Object getValueAt(int rowIndex, int columnIndex) {
    	        if(listaPeciva != null) {
    	            switch (columnIndex) {
    	                case 0:
    	                    return listaPeciva.get(rowIndex).getSifra();
    	                case 1:
    	                    return listaPeciva.get(rowIndex).getNaziv();
    	                case 2:
    	                    return listaPeciva.get(rowIndex).getCijena();
    	                case 3:
    	                    return listaPeciva.get(rowIndex).getTezina();
    	                case 4:
                            return listaPeciva.get(rowIndex).isJeUProdaji() ? Boolean.TRUE : Boolean.FALSE;
    	                default:
    	                    return null;
    	            }
    	        }
    	        return null;
    	    }
    	     	
    	    
    	    /*@Override
    	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    	    }

    	    @Override
    	    public void addTableModelListener(TableModelListener l) {

    	    }

    	    @Override
    	    public void removeTableModelListener(TableModelListener l) {

    	    }*/
    	}
    
    	public void popuniSaSvimPodacimaIzBaze() {
    	
    		// uzmi sve iz baze
    		Baza baza = Baza.getBaza();
    		List<Pecivo> svaPeciva = baza.dajSve(Pecivo.class);
    	
    	}	
    	 
    	public void popuni()
    	{
    		Baza baza = Baza.getBaza();
    		List<Pecivo> svaPeciva = baza.dajSve(Pecivo.class);
    		PecivoTableModel pecivoTableModel = new PecivoTableModel(svaPeciva);
    		pregledPecivaJTable.setModel(pecivoTableModel);
    	}
    	public void dodajPecivo()
    	{
            JOptionPane.showMessageDialog(null, "Unesite podatke o novom pecivu u prazan red u tabeli");
    		Baza baza = Baza.getBaza();
    		List<Pecivo> svaPeciva = baza.dajSve(Pecivo.class);
    		PecivoTableModel pecivoTableModel = new PecivoTableModel(svaPeciva);
    		pregledPecivaJTable.setModel(pecivoTableModel);
//izuzetak  pecivoTableModel.addRow(new Object[]{"","","","",false});
    	}  
    	
    	public void azurirajPecivo()
    	{
    		Baza baza = Baza.getBaza();
    		List<Pecivo> svaPeciva = baza.dajSve(Pecivo.class);
    		
    	}
    	
    
}

	

