package views;

import controllers.DostavljacPotvrdaDostaveController;
import entities.Dostava;
import entities.Korisnik;
import entities.PecivoUDostavi;
import utilities.Baza;
import utilities.GuiUtilities;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class DostavljacPotvrdaDostaveJPanel extends JPanel {
    private JTable dostaveJTable;
    private JTable pecivaUDostaviJTable;
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
                                   boolean[] columnEditables = new boolean[]{
                                           false
                                   };

                                   public Class getColumnClass(int columnIndex) {
                                       return columnTypes[columnIndex];
                                   }

                                   public boolean isCellEditable(int row, int column) {
                                       return columnEditables[column];
                                   }

                               }


        );
        dostaveJScrollPane.setViewportView(dostaveJTable);

        JScrollPane pecivaUDostaviJScrollPane = new JScrollPane();
        GridBagConstraints gbc_pecivaUDostaviJScrollPane = new GridBagConstraints();
        gbc_pecivaUDostaviJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_pecivaUDostaviJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_pecivaUDostaviJScrollPane.gridx = 0;
        gbc_pecivaUDostaviJScrollPane.gridy = 1;
        add(pecivaUDostaviJScrollPane, gbc_pecivaUDostaviJScrollPane);

        pecivaUDostaviJTable = new JTable();
        pecivaUDostaviJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Pecivo", "\u0160ifra", "Koli\u010dina dostavljenog peciva"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, false, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        pecivaUDostaviJScrollPane.setViewportView(pecivaUDostaviJTable);

        dostavaIzvrsenaJButton = new JButton("Dostava izvr\u0161ena");
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

    public JTable getDostaveJTable() {
        return dostaveJTable;
    }

    public JButton getDostavaIzvrsenaJButton() {
        return dostavaIzvrsenaJButton;
    }


    public JTable getPecivaUDostaviJTable() {
        return pecivaUDostaviJTable;
    }


    private void dodajListeners() {
        DostavljacPotvrdaDostaveController dostavljacPotvrdaDostaveController = new DostavljacPotvrdaDostaveController(this);

        dostaveJTable.getSelectionModel().addListSelectionListener(dostavljacPotvrdaDostaveController.getDostavljacPotvrdaDostaveDostaveJTableListSelectionListener());
        pecivaUDostaviJTable.getSelectionModel().addListSelectionListener(dostavljacPotvrdaDostaveController.getDostavaljacPotvrdaDostavePecivaUDostaviJTableListSelectionListener());
        dostavaIzvrsenaJButton.addActionListener(dostavljacPotvrdaDostaveController.getDostavljacPotvrdaDostaveDostavaIzvrsenaActionListener());
    }

    public void popuniSaSvimPodacimaIzBaze(int oznaceniRed) {
        // Uzmi sve klijente iz baze
        Baza baza = Baza.getBaza();
        List<Dostava> sveDostave = baza.dajSve(Dostava.class);

        // izfiltriraj one klijente koji su obrisani
        ukloniObrisaneDostaveIz(sveDostave);

        // Izfiltriraj one dostave koje nisu dostave za trenutno ulogovanog korisnika (dostavljaca)
        Korisnik dostavljac = ((DostavljacJFrame) SwingUtilities.getWindowAncestor(this)).getKorisnik();
        ukloniDostaveKojeNeIsporucujeKorisnik(sveDostave, dostavljac);

        // Izfiltriraj one dostave koje su vec dostavljene
        ukloniSveIsporuceneDostaveIz(sveDostave);

        // Popuni tabelu za dostave sa dostavama
        dostaveJTable.setModel(new PotvrdaDostaveDostaveTableModel());

        if (sveDostave.size() > 0) {
            PotvrdaDostaveDostaveTableModel dostaveTableModel = new PotvrdaDostaveDostaveTableModel(sveDostave);
            dostaveJTable.setModel(dostaveTableModel);
        }

        // Oznaci zanadni red, ali ukoliko je izvan opsega oznaci prvi red u tabeli za dostave
        if (dostaveJTable.getRowCount() > 0 && oznaceniRed < dostaveJTable.getRowCount()) {
            GuiUtilities.oznaciNtiRedUJTable(dostaveJTable, oznaceniRed);
        } else if (dostaveJTable.getRowCount() > 0) {
            GuiUtilities.oznaciNtiRedUJTable(dostaveJTable, 0);
        }

        popuniPecivaUDostaviTabeluSaPecivimaUDostaviSelektiraneDostave();


        // Refreshati panel
        osvjeziJPanel();
    }

    private void ukloniSveIsporuceneDostaveIz(List<Dostava> sveDostave) {
        List<Dostava> isporuceneDostave = new ArrayList<Dostava>();
        for (Dostava d : sveDostave) {
            if (d.isJeIsporuceno()) {
                isporuceneDostave.add(d);
            }
        }
        sveDostave.removeAll(isporuceneDostave);
    }

    private void popuniPecivaUDostaviTabeluSaPecivimaUDostaviSelektiraneDostave() {
        /**
         *  Popuni sva peciva u dostavi koja su povezana na trenutno oznacenu dostavu i popuni tabelu koja
         *  cuva detaljne podatke o dostavi
         */
        // Uzmi indeks selektiranog reda u tabeli dostava
        int selektiraniRed = dostaveJTable.getSelectedRow();
        // Iz TableModel-a tabele dostava uzmi Dostavu koja je oznacena
        List<Dostava> dostaveIzDostaveTabele = ((PotvrdaDostaveDostaveTableModel) dostaveJTable.getModel()).getDostave();
        Dostava selektiranaDostava = null;
        if (selektiraniRed >= 0 && dostaveIzDostaveTabele != null) {
            if (selektiraniRed < dostaveIzDostaveTabele.size()) {
                selektiranaDostava = dostaveIzDostaveTabele.get(selektiraniRed);
            }
        }
        // Za uzetu dostavu uzmi sva peciva iz nje
        List<PecivoUDostavi> pecivaUDostavi = null;
        if (selektiranaDostava != null) {
            pecivaUDostavi = (List<PecivoUDostavi>) selektiranaDostava.getPeciva();
            // Izfiltriraj sva obrisana peciva u dostavi
            ukloniObrisanaPecivaUDostavi(pecivaUDostavi);
        }
        // Popuni tabelu koja cuva sva peciva u dostavi sa dobijenom listom
        if (pecivaUDostavi != null) {
            pecivaUDostaviJTable.setModel(new PotvrdaDostavePecivaUDostaviTableModel(selektiranaDostava, pecivaUDostavi));
        } else {
            pecivaUDostaviJTable.setModel(new PotvrdaDostavePecivaUDostaviTableModel());
        }
    }

    private void ukloniObrisanaPecivaUDostavi(List<PecivoUDostavi> pecivaUDostavi) {
        List<PecivoUDostavi> obrisanaPecivaUDostavi = new ArrayList<PecivoUDostavi>();
        for (PecivoUDostavi p : pecivaUDostavi) {
            if (p.isObrisano()) {
                obrisanaPecivaUDostavi.add(p);
            }
        }
        pecivaUDostavi.removeAll(obrisanaPecivaUDostavi);
    }

    private void ukloniDostaveKojeNeIsporucujeKorisnik(List<Dostava> sveDostave, Korisnik dostavljac) {
        List<Dostava> dostaveZaObrisati = new ArrayList<Dostava>();
        for (Dostava d : sveDostave) {
            if (d.getPreuzeo().getId() != dostavljac.getId()) {
                dostaveZaObrisati.add(d);
            }
        }
        sveDostave.removeAll(dostaveZaObrisati);
    }

    private void ukloniObrisaneDostaveIz(List<Dostava> sveDostave) {
        List<Dostava> obrisaneDostave = new ArrayList<Dostava>();
        for (Dostava d : sveDostave) {
            if (d.isObrisano()) {
                obrisaneDostave.add(d);
            }
        }
        sveDostave.removeAll(obrisaneDostave);
    }

    public void popuniSaPodacima(long idSelektiraneDostave) {
        // Popuni sa svim podacima iz baze
        popuniSaSvimPodacimaIzBaze(0);
        // Nadji indeks dostave sa odgovarajucim id-e unutar tabele dostava
        List<Dostava> dostave = ((PotvrdaDostaveDostaveTableModel) dostaveJTable.getModel()).getDostave();
        int indeksDostaveSaId = -1;
        for (int i = 0; i < dostave.size(); i++) {
            if (dostave.get(i).getId() == idSelektiraneDostave) {
                indeksDostaveSaId = i;
                break;
            }
        }
        // Oznaci red sa pronadjenom dostavom u tabeli
        if (indeksDostaveSaId >= 0) {
            GuiUtilities.oznaciNtiRedUJTable(dostaveJTable, indeksDostaveSaId);
        }
        else throw new NullPointerException("Nije dobar index dostave!");

        popuniPecivaUDostaviTabeluSaPecivimaUDostaviSelektiraneDostave();

        // Refreshati panel
        osvjeziJPanel();
    }

    public Dostava dajSelektiranuDostavu() {
        if (((PotvrdaDostaveDostaveTableModel) dostaveJTable.getModel()).getDostave() != null) {
            if (dostaveJTable.getSelectedRow() >= 0 && dostaveJTable.getSelectedRow() < ((PotvrdaDostaveDostaveTableModel) dostaveJTable.getModel()).getDostave().size()) {
                return ((PotvrdaDostaveDostaveTableModel) dostaveJTable.getModel()).getDostave().get(dostaveJTable.getSelectedRow());
            }
        }
        return null;
    }

    public List<Dostava> dajSveDostaveIzTabele() {
        return ((PotvrdaDostaveDostaveTableModel) dostaveJTable.getModel()).getDostave();
    }

    class PotvrdaDostaveDostaveTableModel extends DefaultTableModel {

        private List<Dostava> dostave;

        PotvrdaDostaveDostaveTableModel() {
        }

        PotvrdaDostaveDostaveTableModel(List<Dostava> dostave) {
            if (dostave != null) {
                this.dostave = dostave;
            } else {
                this.dostave = new ArrayList<Dostava>(0);
            }
        }

        public List<Dostava> getDostave() {
            return dostave;
        }

        @Override
        public int getRowCount() {
            if (dostave != null) {
                return dostave.size();
            }

            return 0;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Naziv dostave";
                case 1:
                    return "Klijent";
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
            if (dostave != null) {
                switch (columnIndex) {
                    case 0:
                        return dostave.get(rowIndex).getNaziv();
                    case 1:
                        return dostave.get(rowIndex).getKlijent().getIme();
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

    class PotvrdaDostavePecivaUDostaviTableModel extends DefaultTableModel {

        private Dostava dostava;
        private List<PecivoUDostavi> pecivaUDostavi;

        PotvrdaDostavePecivaUDostaviTableModel() {
            dostava = null;
            pecivaUDostavi = new ArrayList<PecivoUDostavi>(0);
        }

        PotvrdaDostavePecivaUDostaviTableModel(Dostava dostava, List<PecivoUDostavi> pecivaUDostavi) {
            if (dostava != null) {
                this.dostava = dostava;
                this.pecivaUDostavi = pecivaUDostavi;
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
            return 3;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Pecivo";
                case 1:
                    return "\u0160ifra";
                case 2:
                    return "Koli\u010dina dostavljenog peciva";
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
                    return JSpinner.class;
                default:
                    return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (pecivaUDostavi != null && pecivaUDostavi.get(rowIndex).getDostava() == dostava) {
                switch (columnIndex) {
                    case 0:
                        return pecivaUDostavi.get(rowIndex).getPecivo().getNaziv();
                    case 1:
                        return pecivaUDostavi.get(rowIndex).getPecivo().getSifra();
                    case 2:
                        return pecivaUDostavi.get(rowIndex).getKolicinaPreuzetogPeciva();
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

class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
    final JSpinner spinner = new JSpinner();

    public SpinnerEditor() {
        spinner.setModel(new SpinnerNumberModel());
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
                                                 int row, int column) {
        spinner.setValue(value);
        return spinner;
    }

    public boolean isCellEditable(EventObject evt) {
        if (evt instanceof MouseEvent) {
            return ((MouseEvent) evt).getClickCount() >= 2;
        }
        return true;
    }

    public Object getCellEditorValue() {
        return spinner.getValue();
    }
}