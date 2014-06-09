package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controllers.RacunovodstvoEvidencijaPecivaController;
import utilities.Baza;
import utilities.Validator;
import entities.Dostava;
import entities.Klijent;
import entities.Korisnik;
import entities.Pecivo;
import entities.Racun;
import exceptions.PodaciNisuValidniException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class RacunovodstvoEvidencijaPecivaJPanel extends JPanel {
    private JTable pregledPecivaJTable;
    private JButton dodajPecivoJButton;
    private JLabel lblNewLabel;
    private JTextField sifraTextField;
    private JTextField nazivTextField;
    private JLabel lblNewLabel_2;
    
    private static final Validator VALIDATOR = Validator.instancirajValidatora();
    
    public JTextField getSifratextField() {
		return sifraTextField;
	}
    


	public void setSifratextField(JTextField sifratextField) {
		sifraTextField = sifratextField;
	}

	public JTextField getNazivtextField() {
		return nazivTextField;
	}

	public void setNazivtextField(JTextField nazivtextField) {
		nazivTextField = nazivtextField;
	}

	public JTextField getCijenatextField() {
		return cijenaTextField;
	}

	public void setCijenatextField(JTextField cijenatextField) {
		cijenaTextField = cijenatextField;
	}

	public JTextField getTezinatextField() {
		return tezinaTextField;
	}

	public void setTezinatextField(JTextField tezinatextField) {
		tezinaTextField = tezinatextField;
	}
	private JLabel lblNewLabel_3;
    private JTextField cijenaTextField;
    private JLabel lblNewLabel_4;
    private JTextField tezinaTextField;
    
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
        		"\u0160ifra", "Naziv", "Cijena", "Te\u017eina", "U prodaji"
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
        gbl_dugmadJPanel.columnWidths = new int[] {10, 280, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);
        
        lblNewLabel = new JLabel("\u0160ifra");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 1;
        dugmadJPanel.add(lblNewLabel, gbc_lblNewLabel);
        
        sifraTextField = new JTextField();
        GridBagConstraints gbc_SifratextField = new GridBagConstraints();
        gbc_SifratextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_SifratextField.insets = new Insets(0, 0, 5, 0);
        gbc_SifratextField.gridx = 1;
        gbc_SifratextField.gridy = 1;
        dugmadJPanel.add(sifraTextField, gbc_SifratextField);
        sifraTextField.setColumns(10);
        
        lblNewLabel_2 = new JLabel("Naziv");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        dugmadJPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        nazivTextField = new JTextField();
        GridBagConstraints gbc_NazivtextField = new GridBagConstraints();
        gbc_NazivtextField.insets = new Insets(0, 0, 5, 0);
        gbc_NazivtextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_NazivtextField.gridx = 1;
        gbc_NazivtextField.gridy = 2;
        dugmadJPanel.add(nazivTextField, gbc_NazivtextField);
        nazivTextField.setColumns(10);
        
        lblNewLabel_3 = new JLabel("Cijena");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 3;
        dugmadJPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        cijenaTextField = new JTextField();
        GridBagConstraints gbc_CijenatextField = new GridBagConstraints();
        gbc_CijenatextField.insets = new Insets(0, 0, 5, 0);
        gbc_CijenatextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_CijenatextField.gridx = 1;
        gbc_CijenatextField.gridy = 3;
        dugmadJPanel.add(cijenaTextField, gbc_CijenatextField);
        cijenaTextField.setColumns(10);
        
        lblNewLabel_4 = new JLabel("Te\u017eina");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 4;
        dugmadJPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        tezinaTextField = new JTextField();
        GridBagConstraints gbc_TezinatextField = new GridBagConstraints();
        gbc_TezinatextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_TezinatextField.gridx = 1;
        gbc_TezinatextField.gridy = 4;
        dugmadJPanel.add(tezinaTextField, gbc_TezinatextField);
        tezinaTextField.setColumns(10);

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



    public JButton getDodajPecivoJButton() {
        return dodajPecivoJButton;
    }
    

    private void dodajListeners()
    {
    	RacunovodstvoEvidencijaPecivaController racunovodstvoEvidencijaPecivaController = new RacunovodstvoEvidencijaPecivaController(this);
    	
    	dodajPecivoJButton.addActionListener(racunovodstvoEvidencijaPecivaController.getEvidencijaPecivaDodajPecivoJButtonActionListener());
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
    	                return "\u0160ifra";
    	            case 1:
    	                return "Naziv";
    	            case 2:
    	                return "Cijena";
    	            case 3:
    	                return "Te\u017eina";
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
    	     	
    	    public boolean isCellEditable(int row, int column){  
    	          return false;  
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
    	
    	public void dodajPecivo() throws PodaciNisuValidniException
    	{
    		validirajPodatke();
    		Baza baza = Baza.getBaza();
    		Pecivo p = new Pecivo();
    		p.setNaziv(getNazivtextField().getText());
    		p.setSifra(getSifratextField().getText());
    		p.setTezina(Double.parseDouble(getTezinatextField().getText()));
    		p.setCijena(Double.parseDouble(getCijenatextField().getText()));
    		p.setObrisano(false);
    		p.setJeUProdaji(true);
    		
        	if(getNazivtextField().getText().isEmpty()) {
        		throw new IllegalArgumentException("Polje Naziv ne mo\u017ee biti prazno.");
        	}
        	if(getSifratextField().getText().isEmpty()) {
        		throw new IllegalArgumentException("Polje \u0161ifra ne mo\u017ee biti prazno.");
        	}
        	if(getTezinatextField().getText().isEmpty()) {
        		throw new IllegalArgumentException("Polje Te\u017eina ne mo\u017ee biti prazno.");
        	}
        	if(getCijenatextField().getText().isEmpty()) {
        		throw new IllegalArgumentException("Polje Cijena ne mo\u017ee biti prazno.");
        	}
    		if(getTezinatextField().getText().equals("0")) {
        		throw new IllegalArgumentException("Polje Te\u017eina ne mo\u017ee imati vrijednost 0.");
        	}
    			
    		
    		baza.spasiUBazu(p);
    		
    		List<Pecivo> svaPeciva = baza.dajSve(Pecivo.class);
    		PecivoTableModel pecivoTableModel = new PecivoTableModel(svaPeciva);
    		pregledPecivaJTable.setModel(pecivoTableModel);
    	}

		private void validirajPodatke() throws PodaciNisuValidniException {
			String sifra = sifraTextField.getText();
			String naziv = nazivTextField.getText();
			String cijena = cijenaTextField.getText();
			String tezina = tezinaTextField.getText();
			if(sifra != null &&
					naziv != null &&
					cijena != null &&
					tezina != null) {
				if(!VALIDATOR.jeSifraValidna(sifra)) {
					throw new PodaciNisuValidniException("\u0160ifra nije ispravno unesena. (Mora se satojati od velikih, malih slova, brojeva i minusa)");
				}
				
				if(!VALIDATOR.jeNazivValidan(naziv)) {
					throw new PodaciNisuValidniException("Naziv nije ispravno unesen. (Mora se satojati od velikih, malih slova i brojeva)");
				}
				
				if(!VALIDATOR.jeBrojcanaVrijednost(cijena)) {
					throw new PodaciNisuValidniException("Cijena nije ispravno unesena. (Mora se satojati od brojeva)");
				}
				
				if(!VALIDATOR.jeRealnaBrojcanaVrijednost(tezina)) {
					throw new PodaciNisuValidniException("Te\u017eina nije ispravno unesena. (Mora biti u formatu relanog broja)");
				}
			}
		}



		public void osvjeziPanel() {
			getNazivtextField().setText("");
			getSifratextField().setText("");
			getTezinatextField().setText("");
			getCijenatextField().setText("");
		}  
    	
    	/*public void azurirajPecivo()
    	{
    		Baza baza = Baza.getBaza();
    		List<Pecivo> svaPeciva = baza.dajSve(Pecivo.class);
    		
    	}*/
    	
    
}

	

