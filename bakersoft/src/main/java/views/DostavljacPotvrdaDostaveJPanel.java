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
import javax.swing.table.TableModel;

import controllers.DostavljacPotvrdaDostaveController;
import utilities.Baza;
import utilities.GuiUtilities;
import utilities.JComboBoxItem;
import utilities.JTableItem;
import entities.Dostava;
import entities.Klijent;
import exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti;
import entities.PecivoUDostavi;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

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
        		) {
            Class[] columnTypes = new Class[]{
                    Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
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
        GridBagConstraints gbc_dostavaIzvrsenaJButton = new GridBagConstraints();
        gbc_dostavaIzvrsenaJButton.fill = GridBagConstraints.BOTH;
        gbc_dostavaIzvrsenaJButton.gridx = 0;
        gbc_dostavaIzvrsenaJButton.gridy = 2;
        add(dostavaIzvrsenaJButton, gbc_dostavaIzvrsenaJButton);
        
        dodajListeners();
    }

    public JTable getDostaveJTable() {
        return dostaveJTable;
    }

    public JButton getDostavaIzvrsenaJButton() {
        return dostavaIzvrsenaJButton;
    }


    public JTable getPodaciODostaviJTable() {
        return podaciODostaviJTable;
    }

    //    public JLabel getZaradaIspisJLabel() {
    //  return zaradaIspisJLabel;
    //}


    private void dodajListeners() {
        DostavljacPotvrdaDostaveController dostavljacPotvrdaDostaveController = new DostavljacPotvrdaDostaveController(this);

      //  dostavaIzvrsenaJButton.addActionListener(dostavljacPotvrdaDostaveController.getObracunavanjeNapraviObracunJButtonActionListener());
        dostaveJTable.getSelectionModel().addListSelectionListener(dostavljacPotvrdaDostaveController.getDostavljacPotvrdaDostaveZaJTableListSelectionListener());
    }

    public void popuniSaSvimPodacimaIzBaze() {
        // Uzmi sve klijente iz baze
        Baza baza = Baza.getBaza();
        List<Dostava> sveDostave= baza.dajSve(Dostava.class);

        // izfiltriraj one klijente koji su obrisani
  //      ukloniObrisaneKlijenteIz(sveDostave);

     
 
        // Popuni obracunZaJComboBox sa JComboBoxItem-ovima
        if(sveDostave.size() > 0){
           DefaultTableModel dostaveTableModel = (DefaultTableModel)dostaveJTable.getModel();
            dostaveTableModel.addRow(new Object[] {sveDostave});
        }
/*
        // Popuni tabelu dostave sa dostavama za trenutnog klijenta
        if(sveDostave.size() > 0) {
            Dostava prvaDostavaUJComboBoxu = sveDostave.get(0);
            popuniDostaveJTableSaPodacimaOKlijentu(prvaDostava);
        }
*/
        // Oznaci prvi red u tabeli za dostave
        if(dostaveJTable.getRowCount() > 0) {
            oznaciNtiRedUJTable(dostaveJTable, 0);
        }
     //   dostaveJTable.setModel(new DostaveTableModel());
/*
        // Uzmi oznacenu dostavu iz tabele Dostave
        if(((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta() != null) {
            Dostava oznacenaDostava = ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta()
                    .get(dostaveJTable.getSelectedRow());

            // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
            PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(oznacenaDostava);
           	podaciODostaviJTable.setModel(pecivaDostaveTableModel);
        } else {
            podaciODostaviJTable.setModel(new PecivaDostaveTableModel());
        }
*/
        // Izracunati zaradu i upisati ju u zarada labelu
       // izracunajZaraduNaStavkeUPecivaDostaveJTable();

        // Refreshati panel
        osvjeziJPanel();
    }
/*
    private void popuniDostaveJTableSaPodacimaOKlijentu(Klijent selektiraniKlijent) {
        TableModel dostaveTableModel;
        if (selektiraniKlijent != null) {
            dostaveTableModel = new DostaveTableModel(selektiraniKlijent);
        } else {
            Klijent prazanKlijent = new Klijent();
            prazanKlijent.setDostave(new ArrayList<Dostava>(0));
            dostaveTableModel = new DostaveTableModel(prazanKlijent);
        }
        dostaveJTable.setModel(dostaveTableModel);
    }
    */
/*
    private void izracunajZaraduNaStavkeUPecivaDostaveJTable() {
        double zarada = 0.0;
        for (int i = 0; i < pecivaDostaveJTable.getRowCount(); i++) {
            zarada += (Double) pecivaDostaveJTable.getValueAt(i, 5);
        }
        zaradaIspisJLabel.setText(String.format("%.2f", zarada));
    }
*/
    private void ukloniObrisaneKlijenteIz(List<Klijent> sviKlijenti) {
        List<Klijent> obrisaniKlijenti = new ArrayList<Klijent>();
        for (Klijent k : sviKlijenti) {
            if (k.isObrisano()) {
                obrisaniKlijenti.add(k);
            }
        }
        sviKlijenti.removeAll(obrisaniKlijenti);
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

    public void popuniSaPodacima(long idSelektiranogKlijenta) {
        // Isprazni tabelu dostava
        dostaveJTable.setModel(new 
        		DostaveTableModel());
        // Isprazni tabelu peciva u dostavi
       podaciODostaviJTable.setModel(new PecivaDostaveTableModel());

        // Uzmi sve klijente iz baze
        Baza baza = Baza.getBaza();
        List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);
        // izfiltriraj one klijente koji su obrisani
        ukloniObrisaneKlijenteIz(sviKlijenti);

        // Napravi jComboBoxItem-ove sa svim klijentima
        List<JComboBoxItem> sviKlijentiJComboBoxItemi = new ArrayList<JComboBoxItem>();
        for (Klijent k : sviKlijenti) {
            sviKlijentiJComboBoxItemi.add(new JComboBoxItem(k.getId(), k.getIme()));
        }
        // Popuni obracunZaJComboBox sa JComboBoxItem-ovima
        if(sviKlijentiJComboBoxItemi.size() > 0){
            DefaultTableModel dostaveTableModel = (DefaultTableModel)dostaveJTable.getModel();
             dostaveTableModel.addRow(new Object[] {sviKlijenti});
         }
        // Popuni tabelu dostave sa dostavama za klijenta koji ima idSelektiranogKlijenta
        Klijent selektiraniKlijent = baza.dajPoId(Klijent.class, idSelektiranogKlijenta);
   //     popuniDostaveJTableSaPodacimaOKlijentu(selektiraniKlijent);
        // Oznaci prvi red u tabeli za dostave
        if (dostaveJTable.getRowCount() > 0) {
            ListSelectionModel selectionModel = dostaveJTable.getSelectionModel();
            selectionModel.setSelectionInterval(0, 0);

            // Uzmi oznacenu dostavu iz tabele Dostave
            Dostava oznacenaDostava = ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta()
                    .get(dostaveJTable.getSelectedRow());

            // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
            PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(oznacenaDostava);
            podaciODostaviJTable.setModel(pecivaDostaveTableModel);

            // Izracunati zaradu i upisati ju u zarada labelu
      //      izracunajZaraduNaStavkeUPecivaDostaveJTable();
        }

        // Refreshati panel
        osvjeziJPanel();
    }

    public void popuniSaPodacima(long idSelektiranogKlijenta, Date pocetniDatum, Date krajnjiDatum) {
        // Isprazni tabelu dostava
        dostaveJTable.setModel(new DostaveTableModel());
        // Isprazni tabelu peciva u dostavi
        podaciODostaviJTable.setModel(new PecivaDostaveTableModel());

        // Uzmi sve klijente iz baze
        Baza baza = Baza.getBaza();
        List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);

        // izfiltriraj one klijente koji su obrisani
        ukloniObrisaneKlijenteIz(sviKlijenti);

        // Napravi jComboBoxItem-ove sa svim klijentima
        List<JComboBoxItem> sviKlijentiJComboBoxItemi = new ArrayList<JComboBoxItem>();
        for (Klijent k : sviKlijenti) {
            sviKlijentiJComboBoxItemi.add(new JComboBoxItem(k.getId(), k.getIme()));
        }

        // Popuni obracunZaJComboBox sa JComboBoxItem-ovima
        if(sviKlijentiJComboBoxItemi.size() > 0){
            DefaultTableModel dostaveTableModel = (DefaultTableModel)dostaveJTable.getModel();
             dostaveTableModel.addRow(new Object[] {sviKlijenti});
         }

        // Popuni tabelu dostave sa dostavama za klijenta koji ima idSelektiranogKlijenta
        Klijent selektiraniKlijent = baza.dajPoId(Klijent.class, idSelektiranogKlijenta);
   //     popuniDostaveJTableSaPodacimaOKlijentu(selektiraniKlijent);

        
        if (dostaveJTable.getRowCount() > 0) {
            // Oznaci prvi red u tabeli za dostave
            oznaciNtiRedUJTable(dostaveJTable, 0);

            // Uzmi oznacenu dostavu iz tabele Dostave
            Dostava oznacenaDostava = ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta()
                    .get(dostaveJTable.getSelectedRow());

            // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
            PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(oznacenaDostava);
           podaciODostaviJTable.setModel(pecivaDostaveTableModel);

            // Izracunati zaradu i upisati ju u zarada labelu
        //    izracunajZaraduNaStavkeUPecivaDostaveJTable();
        }

        // Refreshati panel
        osvjeziJPanel();
    }

    public void popuniSaPodacima(Dostava selektiranaDostava) {
        // Isprazni tabelu peciva u dostavi
        podaciODostaviJTable.setModel(new PecivaDostaveTableModel());

        // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
        PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(selektiranaDostava);
        podaciODostaviJTable.setModel(pecivaDostaveTableModel);

        // Izracunati zaradu i upisati ju u zarada labelu
     //   izracunajZaraduNaStavkeUPecivaDostaveJTable();

        // Refreshati panel
        osvjeziJPanel();
    }

    private void osvjeziJPanel() {
        this.validate();
        this.repaint();
    }

    public Dostava dajSelektiranuDostavu() {
        if(((DostaveTableModel)dostaveJTable.getModel()).getDostaveZaKlijenta() != null) {
            if(dostaveJTable.getSelectedRow() >= 0 && dostaveJTable.getSelectedRow() < ((DostaveTableModel)dostaveJTable.getModel()).getDostaveZaKlijenta().size()) {
                return ((DostaveTableModel)dostaveJTable.getModel()).getDostaveZaKlijenta().get(dostaveJTable.getSelectedRow());
            }
        }

        return null;

    }


public class DostaveTableModel extends DefaultTableModel {

  
    private List<Dostava> dostaveZaKlijenta;

    DostaveTableModel() {
    	
    }

    DostaveTableModel(List<Dostava> dostaveZaKlijenta) {
        this.dostaveZaKlijenta=dostaveZaKlijenta;
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
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Naziv dostave";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
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
                default:
                    return null;
            }
        }

        return null;
    }

   /* @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
*/

}


class PecivaDostaveTableModel extends DefaultTableModel {

    private Dostava dostava;
    private List<PecivoUDostavi> pecivaUDostavi;

    PecivaDostaveTableModel() {
    }

    PecivaDostaveTableModel(Dostava dostava) {
        if(dostava != null) {
            this.dostava = dostava;
            this.pecivaUDostavi = (List<PecivoUDostavi>) dostava.getPeciva();
            List<PecivoUDostavi> obrisanaPecivaUDostavi = new ArrayList<PecivoUDostavi>();
            for (PecivoUDostavi p : obrisanaPecivaUDostavi) {
                if (p.isObrisano()) {
                    obrisanaPecivaUDostavi.add(p);
                }
            }
            pecivaUDostavi.removeAll(obrisanaPecivaUDostavi);
        }
    }

    public Dostava getDostava() {
        return dostava;
    }

    public List<PecivoUDostavi> getPecivaUDostavi() {
        return pecivaUDostavi;
    }

    @Override
    public int getRowCount() {
        if (pecivaUDostavi != null) {
            return pecivaUDostavi.size();
        }

        return 0;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Šifra";
            case 1:
                return "Naziv";
            case 2:
                return "Težina";
            case 3:
                return "Cijena";
            case 4:
                return "Količina";
            case 5:
                return "Ukupna cijena";
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
                return Double.class;
            case 4:
                return Integer.class;
            case 5:
                return Double.class;
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
        if(pecivaUDostavi != null) {
            switch (columnIndex) {
                case 0:
                    return pecivaUDostavi.get(rowIndex).getPecivo().getSifra();
                case 1:
                    return pecivaUDostavi.get(rowIndex).getPecivo().getNaziv();
                case 2:
                    return pecivaUDostavi.get(rowIndex).getPecivo().getTezina();
                case 3:
                    return pecivaUDostavi.get(rowIndex).getPecivo().getCijena();
                case 4:
                    return pecivaUDostavi.get(rowIndex).getKolicinaPreuzetogPeciva() - pecivaUDostavi.get(rowIndex).getKolicinaVracenogPeciva();
                case 5:
                    double kolicinaDostavljenogPeciva = pecivaUDostavi.get(rowIndex).getKolicinaPreuzetogPeciva() - pecivaUDostavi.get(rowIndex).getKolicinaVracenogPeciva();
                    return kolicinaDostavljenogPeciva * pecivaUDostavi.get(rowIndex).getPecivo().getCijena();
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

    }
*/
}
}