package views;

import javax.swing.*;

import entities.Dostava;
import entities.Klijent;
import entities.Korisnik;
import entities.Pecivo;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controllers.DostavljacIzbornikController;
import controllers.DostavljacPotvrdaDostaveController;
import controllers.RacunovodstvoObracunavanjeController;
import utilities.Baza;
import utilities.GuiUtilities;
import utilities.JComboBoxItem;
import entities.Dostava;
import entities.Klijent;
import exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DostavljacPotvrdaDostaveJPanel extends JPanel {
    private JTable dostaveJTable;
    private JTable podaciODostaviJTable;
    private JButton dostavaIzvrsenaJButton;

    /**
     * Create the panel.
     */
    public DostavljacPotvrdaDostaveJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Potvrda dostave:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JScrollPane dostaveJScrollPane = new JScrollPane();
        GridBagConstraints gbc_dostaveJScrollPane = new GridBagConstraints();
        gbc_dostaveJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_dostaveJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_dostaveJScrollPane.gridx = 0;
        gbc_dostaveJScrollPane.gridy = 0;
        add(dostaveJScrollPane, gbc_dostaveJScrollPane);

        dostaveJTable = new JTable();
        dostaveJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Naziv dostave"
                }
        ));
        dostaveJScrollPane.setViewportView(dostaveJTable);

        JScrollPane pecivaUDostaviJScrollPane = new JScrollPane();
        GridBagConstraints gbc_pecivaUDostaviJScrollPane = new GridBagConstraints();
        gbc_pecivaUDostaviJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_pecivaUDostaviJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_pecivaUDostaviJScrollPane.gridx = 0;
        gbc_pecivaUDostaviJScrollPane.gridy = 1;
        add(pecivaUDostaviJScrollPane, gbc_pecivaUDostaviJScrollPane);

        podaciODostaviJTable = new JTable();
        podaciODostaviJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Pecivo", "\u0160ifra", "Koli\u010Dina dostavljenog peciva"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, false, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        pecivaUDostaviJScrollPane.setViewportView(podaciODostaviJTable);

        dostavaIzvrsenaJButton = new JButton("Dostava izvr\u0161ena");
        dostavaIzvrsenaJButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        GridBagConstraints gbc_dostavaIzvrsenaJButton = new GridBagConstraints();
        gbc_dostavaIzvrsenaJButton.fill = GridBagConstraints.BOTH;
        gbc_dostavaIzvrsenaJButton.gridx = 0;
        gbc_dostavaIzvrsenaJButton.gridy = 2;
        add(dostavaIzvrsenaJButton, gbc_dostavaIzvrsenaJButton);
        
        dodajListeners();
        
       
        
       
   
    
     }
    
    private void osvjeziJPanel() {
        this.validate();
        this.repaint();
    }
    
    public void popuniSaPodacima(Dostava dostava) {
        // Isprazni tabelu dostava
        dostaveJTable.setModel(new DostaveTableModel());
        // Isprazni tabelu peciva u dostavi
        podaciODostaviJTable.setModel(new PecivaDostaveTableModel());

        // Uzmi sve klijente iz baze
        Baza baza = Baza.getBaza();
      /*  List<Pecivo> svaPeciva= baza.dajSve(Pecivo.class);

        // Napravi jComboBoxItem-ove sa svim klijentima
        List<JComboBoxItem> sviKlijentiJComboBoxItemi = new ArrayList<JComboBoxItem>();
        for (Klijent k : sviKlijenti) {
            sviKlijentiJComboBoxItemi.add(new JComboBoxItem(k.getId(), k.getIme()));
        }

        // Popuni tabelu dostave sa dostavama za klijenta koji ima idSelektiranogKlijenta
        Klijent selektiraniKlijent = baza.dajPoId(Klijent.class, idSelektiranogKlijenta);
        popuniDostaveJTableSaPodacimaOKlijentu(selektiraniKlijent);
     */ 
        // Oznaci prvi red u tabeli za dostave
        if (dostaveJTable.getRowCount() > 0) {
            ListSelectionModel selectionModel = dostaveJTable.getSelectionModel();
            selectionModel.setSelectionInterval(0, 0);

            // Uzmi oznacenu dostavu iz tabele Dostave
            Dostava oznacenaDostava = ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta()
                    .get(dostaveJTable.getSelectedRow());
/*
            // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
            PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(oznacenaDostava);
            pecivaDostaveJTable.setModel(pecivaDostaveTableModel);

            // Izracunati zaradu i upisati ju u zarada labelu
            izracunajZaraduNaStavkeUPecivaDostaveJTable();
        
*/
        }   // Refreshati panel
        osvjeziJPanel();
    }
    
    private void ocistiPanel() {
    	dostaveJTable.removeAll();
        podaciODostaviJTable.removeAll();

    }
    public JTable getDostaveJTable() {
        return dostaveJTable;
    }

    public JTable getPodaciODostaviJTable() {
        return podaciODostaviJTable;
    }

    public JButton getDostavaIzvrsenaJButton() {
        return dostavaIzvrsenaJButton;
    }
    
   private void dodajListeners() {
    	DostavljacPotvrdaDostaveController dostavljacPotvrdaDostaveController = new DostavljacPotvrdaDostaveController(this);
    	dostaveJTable.getSelectionModel().addListSelectionListener(dostavljacPotvrdaDostaveController.getDostavljacPotvrdaDostaveZaJTableListSelectionListener());
   }
   class DostaveTableModel extends DefaultTableModel {

	    private Klijent klijent;
	    private List<Dostava> dostaveZaKlijenta;

	    DostaveTableModel() {
	    }

	    DostaveTableModel(Klijent klijent) {
	        if(klijent != null) {
	            this.klijent = klijent;
	            this.dostaveZaKlijenta = (List<Dostava>) klijent.getDostave();
	            List<Dostava> obrisaneDostave = new ArrayList<Dostava>();
	            for (Dostava d : obrisaneDostave) {
	                if (d.isObrisano()) {
	                    obrisaneDostave.add(d);
	                }
	            }
	            dostaveZaKlijenta.removeAll(obrisaneDostave);
	        }
	    }

	    public Klijent getKlijent() {
	        return klijent;
	    }

	    public List<Dostava> getDostaveZaKlijenta() {
	        return dostaveZaKlijenta;
	    }

	    @Override
	    public int getRowCount() {
	        if (dostaveZaKlijenta != null) {
	            return dostaveZaKlijenta.size();
	        }

	        return 0;
	    }

	    @Override
	    public int getColumnCount() {
	        return 4;
	    }

	    @Override
	    public String getColumnName(int columnIndex) {
	        switch (columnIndex) {
	            case 0:
	                return "Naziv dostave";
	            case 1:
	                return "Isporucioc";
	            case 2:
	                return "Datum dostave";
	            case 3:
	                return "Dostava isporucena";
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
	                return Date.class;
	            case 3:
	                return Boolean.class;
	            default:
	                return null;
	        }
	    }

	    @Override
	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	        return false;
	    }

	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        if(dostaveZaKlijenta != null) {
	            switch (columnIndex) {
	                case 0:
	                    return dostaveZaKlijenta.get(rowIndex).getNaziv();
	                case 1:
	                    Korisnik korisnikKojiJePreuzeoDostavu = dostaveZaKlijenta.get(rowIndex).getPreuzeo();
	                    return korisnikKojiJePreuzeoDostavu.getIme() + " " + korisnikKojiJePreuzeoDostavu.getPrezime();
	                case 2:
	                    return dostaveZaKlijenta.get(rowIndex).getDatum();
	                case 3:
	                    return dostaveZaKlijenta.get(rowIndex).isJeIsporuceno() ? Boolean.TRUE : Boolean.FALSE;
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
   
   public Dostava dajSelektiranuDostavu() {
       if(((DostaveTableModel)dostaveJTable.getModel()).getDostaveZaKlijenta() != null) {
           if(dostaveJTable.getSelectedRow() >= 0 && dostaveJTable.getSelectedRow() < ((DostaveTableModel)dostaveJTable.getModel()).getDostaveZaKlijenta().size()) {
               return ((DostaveTableModel)dostaveJTable.getModel()).getDostaveZaKlijenta().get(dostaveJTable.getSelectedRow());
           }
       }

       return null;
   }
   private void oznaciNtiRedUJTable(JTable jTable, int rowIndex) {
       ListSelectionModel selectionModel = jTable.getSelectionModel();
       ListSelectionListener[] listeners = ((DefaultListSelectionModel) selectionModel).getListSelectionListeners();
       for (ListSelectionListener l : listeners) {
           selectionModel.removeListSelectionListener(l);
       }
       selectionModel.setSelectionInterval(rowIndex, rowIndex);
       for (ListSelectionListener l : listeners) {
           selectionModel.addListSelectionListener(l);
       }
   }
    public void popuniSaSvimPodacimaIzBaze() {
    	// Uzmi sve klijente iz baze
        Baza baza = Baza.getBaza();
        List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);

     /*

        // Napravi jComboBoxItem-ove sa svim klijentima
        List<JComboBoxItem> sviKlijentiJComboBoxItemi = new ArrayList<JComboBoxItem>();
        for (Klijent k : sviKlijenti) {
            sviKlijentiJComboBoxItemi.add(new JComboBoxItem(k.getId(), k.getIme()));
        }
        // Popuni obracunZaJComboBox sa JComboBoxItem-ovima
        if(sviKlijentiJComboBoxItemi.size() > 0){
            GuiUtilities.popuniJComboBoxSa(sviKlijentiJComboBoxItemi, obracunZaJComboBox, sviKlijentiJComboBoxItemi.get(0).getId());
        }

        // Popuni tabelu dostave sa dostavama za trenutnog klijenta
        if(sviKlijenti.size() > 0) {
            Klijent prviKlijentUJComboBoxu = sviKlijenti.get(0);
            popuniDostaveJTableSaPodacimaOKlijentu(prviKlijentUJComboBoxu);
        }
*/
        // Oznaci prvi red u tabeli za dostave
        if(dostaveJTable.getRowCount() > 0) {
            oznaciNtiRedUJTable(dostaveJTable, 0);
        }

        // Uzmi oznacenu dostavu iz tabele Dostave
        if(((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta() != null) {
            Dostava oznacenaDostava = ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta()
                    .get(dostaveJTable.getSelectedRow());

            // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
      //////   } else {
   //         pecivaDostaveJTable.setModel(new PecivaDostaveTableModel());
        }

        // Izracunati zaradu i upisati ju u zarada labelu
      //  izracunajZaraduNaStavkeUPecivaDostaveJTable();

        // Refreshati panel
        osvjeziJPanel();
    }
}
