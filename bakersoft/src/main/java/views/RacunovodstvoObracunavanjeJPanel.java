package views;

import controllers.RacunovodstvoObracunavanjeController;
import entities.Dostava;
import entities.Klijent;
import entities.Korisnik;
import entities.PecivoUDostavi;
import utilities.Baza;
import utilities.GuiUtilities;
import utilities.JComboBoxItem;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.*;
import java.util.List;

public class RacunovodstvoObracunavanjeJPanel extends JPanel {
    private JTable dostaveJTable;
    private JComboBox obracunZaJComboBox;
    private JLabel zaradaIspisJLabel;
    private JButton napraviObracunJButton;
    private JButton filtrirajDostaveJButton;
    private JTable pecivaDostaveJTable;
    private JSpinner doDatumaJSpinner;
    private JSpinner odDatumaJSpinner;
    private JLabel krajnjiRokIsplateJLabel;
    private JLabel poetniRokIsplateJLabel;
    private JSpinner krajnjiRokIsplateJSpinner;
    private JSpinner pocetniRokIsplateJSpinner;

    /**
     * Create the panel.
     */
    public RacunovodstvoObracunavanjeJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Obračunavanje:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JPanel obracunZaJPanel = new JPanel();
        GridBagConstraints gbc_obracunZaJPanel = new GridBagConstraints();
        gbc_obracunZaJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_obracunZaJPanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_obracunZaJPanel.gridx = 0;
        gbc_obracunZaJPanel.gridy = 0;
        add(obracunZaJPanel, gbc_obracunZaJPanel);
        GridBagLayout gbl_obracunZaJPanel = new GridBagLayout();
        gbl_obracunZaJPanel.columnWidths = new int[]{46, 392, 0};
        gbl_obracunZaJPanel.rowHeights = new int[]{141, 0};
        gbl_obracunZaJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_obracunZaJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        obracunZaJPanel.setLayout(gbl_obracunZaJPanel);

        JLabel obracunZaJLabel = new JLabel("Obračun za:");
        obracunZaJLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        GridBagConstraints gbc_obracunZaJLabel = new GridBagConstraints();
        gbc_obracunZaJLabel.fill = GridBagConstraints.BOTH;
        gbc_obracunZaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_obracunZaJLabel.gridx = 0;
        gbc_obracunZaJLabel.gridy = 0;
        obracunZaJPanel.add(obracunZaJLabel, gbc_obracunZaJLabel);

        obracunZaJComboBox = new JComboBox();
        GridBagConstraints gbc_obracunZaJComboBox = new GridBagConstraints();
        gbc_obracunZaJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_obracunZaJComboBox.gridx = 1;
        gbc_obracunZaJComboBox.gridy = 0;
        obracunZaJPanel.add(obracunZaJComboBox, gbc_obracunZaJComboBox);

        JPanel podaciZaObracunJPanel = new JPanel();
        podaciZaObracunJPanel.setBorder(null);
        GridBagConstraints gbc_podaciZaObracunJPanel = new GridBagConstraints();
        gbc_podaciZaObracunJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_podaciZaObracunJPanel.fill = GridBagConstraints.BOTH;
        gbc_podaciZaObracunJPanel.gridx = 0;
        gbc_podaciZaObracunJPanel.gridy = 1;
        add(podaciZaObracunJPanel, gbc_podaciZaObracunJPanel);
        GridBagLayout gbl_podaciZaObracunJPanel = new GridBagLayout();
        gbl_podaciZaObracunJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_podaciZaObracunJPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_podaciZaObracunJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_podaciZaObracunJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        podaciZaObracunJPanel.setLayout(gbl_podaciZaObracunJPanel);

        JLabel odDatumaJLabel = new JLabel("Od datuma:");
        odDatumaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_odDatumaJLabel = new GridBagConstraints();
        gbc_odDatumaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_odDatumaJLabel.anchor = GridBagConstraints.EAST;
        gbc_odDatumaJLabel.gridx = 0;
        gbc_odDatumaJLabel.gridy = 0;
        podaciZaObracunJPanel.add(odDatumaJLabel, gbc_odDatumaJLabel);

        odDatumaJSpinner = new JSpinner();
        odDatumaJSpinner.setModel(new SpinnerDateModel(new Date(1400968800000L), null, null, Calendar.DAY_OF_YEAR));
        GridBagConstraints gbc_odDatumaJSpinner = new GridBagConstraints();
        gbc_odDatumaJSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_odDatumaJSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_odDatumaJSpinner.gridx = 1;
        gbc_odDatumaJSpinner.gridy = 0;
        podaciZaObracunJPanel.add(odDatumaJSpinner, gbc_odDatumaJSpinner);

        JLabel doDatumaJLabel = new JLabel("Do datuma:");
        doDatumaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_doDatumaJLabel = new GridBagConstraints();
        gbc_doDatumaJLabel.anchor = GridBagConstraints.EAST;
        gbc_doDatumaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_doDatumaJLabel.gridx = 0;
        gbc_doDatumaJLabel.gridy = 1;
        podaciZaObracunJPanel.add(doDatumaJLabel, gbc_doDatumaJLabel);

        doDatumaJSpinner = new JSpinner();
        doDatumaJSpinner.setModel(new SpinnerDateModel(new Date(1400968800000L), null, null, Calendar.DAY_OF_YEAR));
        GridBagConstraints gbc_doDatumaJSpinner = new GridBagConstraints();
        gbc_doDatumaJSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_doDatumaJSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_doDatumaJSpinner.gridx = 1;
        gbc_doDatumaJSpinner.gridy = 1;
        podaciZaObracunJPanel.add(doDatumaJSpinner, gbc_doDatumaJSpinner);

        filtrirajDostaveJButton = new JButton("Filtriraj dostave");
        GridBagConstraints gbc_filtrirajDostaveJButton = new GridBagConstraints();
        gbc_filtrirajDostaveJButton.insets = new Insets(0, 0, 5, 0);
        gbc_filtrirajDostaveJButton.gridx = 1;
        gbc_filtrirajDostaveJButton.gridy = 2;
        podaciZaObracunJPanel.add(filtrirajDostaveJButton, gbc_filtrirajDostaveJButton);

        JLabel dostaveJLabel = new JLabel("Dostave:");
        dostaveJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_dostaveJLabel = new GridBagConstraints();
        gbc_dostaveJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_dostaveJLabel.anchor = GridBagConstraints.EAST;
        gbc_dostaveJLabel.gridx = 0;
        gbc_dostaveJLabel.gridy = 3;
        podaciZaObracunJPanel.add(dostaveJLabel, gbc_dostaveJLabel);

        JScrollPane dostaveJScrollPane = new JScrollPane();
        GridBagConstraints gbc_dostaveJScrollPane = new GridBagConstraints();
        gbc_dostaveJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_dostaveJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_dostaveJScrollPane.gridx = 1;
        gbc_dostaveJScrollPane.gridy = 3;
        podaciZaObracunJPanel.add(dostaveJScrollPane, gbc_dostaveJScrollPane);

        dostaveJTable = new JTable();
        dostaveJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Naziv dostave", "Isporučioc", "Datum dostave", "Dostava isporučena"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Object.class, Object.class, Object.class, Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        dostaveJScrollPane.setViewportView(dostaveJTable);

        JLabel pecivaDostaveJLabel = new JLabel("Peciva dostave:");
        GridBagConstraints gbc_pecivaDostaveJLabel = new GridBagConstraints();
        gbc_pecivaDostaveJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_pecivaDostaveJLabel.gridx = 0;
        gbc_pecivaDostaveJLabel.gridy = 4;
        podaciZaObracunJPanel.add(pecivaDostaveJLabel, gbc_pecivaDostaveJLabel);

        JScrollPane pecivaDostaveJScrollPane = new JScrollPane();
        GridBagConstraints gbc_pecivaDostaveJScrollPane = new GridBagConstraints();
        gbc_pecivaDostaveJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_pecivaDostaveJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_pecivaDostaveJScrollPane.gridx = 1;
        gbc_pecivaDostaveJScrollPane.gridy = 4;
        podaciZaObracunJPanel.add(pecivaDostaveJScrollPane, gbc_pecivaDostaveJScrollPane);

        pecivaDostaveJTable = new JTable();
        pecivaDostaveJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Šifra", "Naziv", "Težina", "Cijena", "Količina", "Ukupna cijena"
                }
        ));
        pecivaDostaveJScrollPane.setViewportView(pecivaDostaveJTable);

        poetniRokIsplateJLabel = new JLabel("Po\u010Detni rok isplate:");
        GridBagConstraints gbc_poetniRokIsplateJLabel = new GridBagConstraints();
        gbc_poetniRokIsplateJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_poetniRokIsplateJLabel.gridx = 0;
        gbc_poetniRokIsplateJLabel.gridy = 5;
        podaciZaObracunJPanel.add(poetniRokIsplateJLabel, gbc_poetniRokIsplateJLabel);

        pocetniRokIsplateJSpinner = new JSpinner();
        pocetniRokIsplateJSpinner.setModel(new SpinnerDateModel(new Date(1400968800000L), null, null, Calendar.DAY_OF_YEAR));
        GridBagConstraints gbc_pocetniRokIsplateJSpinner = new GridBagConstraints();
        gbc_pocetniRokIsplateJSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_pocetniRokIsplateJSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_pocetniRokIsplateJSpinner.gridx = 1;
        gbc_pocetniRokIsplateJSpinner.gridy = 5;
        podaciZaObracunJPanel.add(pocetniRokIsplateJSpinner, gbc_pocetniRokIsplateJSpinner);

        krajnjiRokIsplateJLabel = new JLabel("Krajnji rok isplate:");
        GridBagConstraints gbc_krajnjiRokIsplateJLabel = new GridBagConstraints();
        gbc_krajnjiRokIsplateJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_krajnjiRokIsplateJLabel.gridx = 0;
        gbc_krajnjiRokIsplateJLabel.gridy = 6;
        podaciZaObracunJPanel.add(krajnjiRokIsplateJLabel, gbc_krajnjiRokIsplateJLabel);

        krajnjiRokIsplateJSpinner = new JSpinner();
        krajnjiRokIsplateJSpinner.setModel(new SpinnerDateModel(new Date(1400968800000L), null, null, Calendar.DAY_OF_YEAR));
        GridBagConstraints gbc_krajnjiRokIsplateJSpinner = new GridBagConstraints();
        gbc_krajnjiRokIsplateJSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_krajnjiRokIsplateJSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_krajnjiRokIsplateJSpinner.gridx = 1;
        gbc_krajnjiRokIsplateJSpinner.gridy = 6;
        podaciZaObracunJPanel.add(krajnjiRokIsplateJSpinner, gbc_krajnjiRokIsplateJSpinner);

        JLabel zaradaJLabel = new JLabel("Zarada:");
        zaradaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_zaradaJLabel = new GridBagConstraints();
        gbc_zaradaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_zaradaJLabel.anchor = GridBagConstraints.EAST;
        gbc_zaradaJLabel.gridx = 0;
        gbc_zaradaJLabel.gridy = 7;
        podaciZaObracunJPanel.add(zaradaJLabel, gbc_zaradaJLabel);

        zaradaIspisJLabel = new JLabel("");
        GridBagConstraints gbc_zaradaIspisJLabel = new GridBagConstraints();
        gbc_zaradaIspisJLabel.gridx = 1;
        gbc_zaradaIspisJLabel.gridy = 7;
        podaciZaObracunJPanel.add(zaradaIspisJLabel, gbc_zaradaIspisJLabel);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 2;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        napraviObracunJButton = new JButton("Napravi obračun");
        GridBagConstraints gbc_napraviObracunJButton = new GridBagConstraints();
        gbc_napraviObracunJButton.anchor = GridBagConstraints.SOUTH;
        gbc_napraviObracunJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_napraviObracunJButton.gridx = 0;
        gbc_napraviObracunJButton.gridy = 0;
        dugmadJPanel.add(napraviObracunJButton, gbc_napraviObracunJButton);

        dodajListeners();
    }

    public JTable getDostaveJTable() {
        return dostaveJTable;
    }

    public JComboBox getObracunZaJComboBox() {
        return obracunZaJComboBox;
    }

    public JButton getNapraviObracunJButton() {
        return napraviObracunJButton;
    }

    public JButton getFiltrirajDostaveJButton() {
        return filtrirajDostaveJButton;
    }

    public JTable getPecivaDostaveJTable() {
        return pecivaDostaveJTable;
    }

    public JLabel getZaradaIspisJLabel() {
        return zaradaIspisJLabel;
    }

    public JSpinner getDoDatumaJSpinner() {
        return doDatumaJSpinner;
    }

    public JSpinner getOdDatumaJSpinner() {
        return odDatumaJSpinner;
    }

    public JSpinner getKrajnjiRokIsplateJSpinner() {
        return krajnjiRokIsplateJSpinner;
    }

    public JSpinner getPocetniRokIsplateJSpinner() {
        return pocetniRokIsplateJSpinner;
    }

    private void dodajListeners() {
        RacunovodstvoObracunavanjeController racunovodstvoObracunavanjeController = new RacunovodstvoObracunavanjeController(this);

        obracunZaJComboBox.addItemListener(racunovodstvoObracunavanjeController.getObracunavanjeObracunZaJComboBoxItemListener());
        filtrirajDostaveJButton.addActionListener(racunovodstvoObracunavanjeController.getObracunavanjeFiltrirajDostaveJButtonActionListener());
        napraviObracunJButton.addActionListener(racunovodstvoObracunavanjeController.getObracunavanjeNapraviObracunJButtonActionListener());
        dostaveJTable.getSelectionModel().addListSelectionListener(racunovodstvoObracunavanjeController.getObracunavanjeDostaveJTableListSelectionListener());
    }

    public void popuniSaSvimPodacimaIzBaze() {
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
        if (sviKlijentiJComboBoxItemi.size() > 0) {
            GuiUtilities.popuniJComboBoxSa(sviKlijentiJComboBoxItemi, obracunZaJComboBox, sviKlijentiJComboBoxItemi.get(0).getId());
        }

        // Popuni tabelu dostave sa dostavama za trenutnog klijenta
        if (sviKlijenti.size() > 0) {
            Klijent prviKlijentUJComboBoxu = sviKlijenti.get(0);
            popuniDostaveJTableSaPodacimaOKlijentu(prviKlijentUJComboBoxu);
        }

        // Oznaci prvi red u tabeli za dostave
        if (dostaveJTable.getRowCount() > 0) {
            oznaciNtiRedUJTable(dostaveJTable, 0);
        }

        // Uzmi oznacenu dostavu iz tabele Dostave
        if (((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta() != null && dostaveJTable.getSelectedRow() >= 0) {
            Dostava oznacenaDostava = ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta()
                    .get(dostaveJTable.getSelectedRow());
            // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
            PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(oznacenaDostava);
            pecivaDostaveJTable.setModel(pecivaDostaveTableModel);
        } else {
            pecivaDostaveJTable.setModel(new PecivaDostaveTableModel());
        }

        // Izracunati zaradu i upisati ju u zarada labelu
        izracunajZaraduNaStavkeUPecivaDostaveJTable();

        // Refreshati panel
        osvjeziJPanel();
    }

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

    private void izracunajZaraduNaStavkeUPecivaDostaveJTable() {
        double zarada = 0.0;
        for (int i = 0; i < pecivaDostaveJTable.getRowCount(); i++) {
            zarada += (Double) pecivaDostaveJTable.getValueAt(i, 5);
        }
        zaradaIspisJLabel.setText(String.format("%.2f", zarada));
    }

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
        dostaveJTable.setModel(new DostaveTableModel());
        // Isprazni tabelu peciva u dostavi
        pecivaDostaveJTable.setModel(new PecivaDostaveTableModel());

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
        GuiUtilities.popuniJComboBoxSa(sviKlijentiJComboBoxItemi, obracunZaJComboBox, idSelektiranogKlijenta);

        // Popuni tabelu dostave sa dostavama za klijenta koji ima idSelektiranogKlijenta
        Klijent selektiraniKlijent = baza.dajPoId(Klijent.class, idSelektiranogKlijenta);
        popuniDostaveJTableSaPodacimaOKlijentu(selektiraniKlijent);
        // Oznaci prvi red u tabeli za dostave
        if (dostaveJTable.getRowCount() > 0) {
            ListSelectionModel selectionModel = dostaveJTable.getSelectionModel();
            selectionModel.setSelectionInterval(0, 0);

            // Uzmi oznacenu dostavu iz tabele Dostave
            Dostava oznacenaDostava = ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta()
                    .get(dostaveJTable.getSelectedRow());

            // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
            PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(oznacenaDostava);
            pecivaDostaveJTable.setModel(pecivaDostaveTableModel);

            // Izracunati zaradu i upisati ju u zarada labelu
            izracunajZaraduNaStavkeUPecivaDostaveJTable();
        }

        // Refreshati panel
        osvjeziJPanel();
    }

    public void popuniSaPodacima(long idSelektiranogKlijenta, Date pocetniDatum, Date krajnjiDatum) {
        // Isprazni tabelu dostava
        dostaveJTable.setModel(new DostaveTableModel());
        // Isprazni tabelu peciva u dostavi
        pecivaDostaveJTable.setModel(new PecivaDostaveTableModel());

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
        GuiUtilities.popuniJComboBoxSa(sviKlijentiJComboBoxItemi, obracunZaJComboBox, idSelektiranogKlijenta);

        // Popuni tabelu dostave sa dostavama za klijenta koji ima idSelektiranogKlijenta
        Klijent selektiraniKlijent = baza.dajPoId(Klijent.class, idSelektiranogKlijenta);
        popuniDostaveJTableSaPodacimaOKlijentu(selektiraniKlijent);

        // Filtriraj tabelu po datumima
        TableRowSorter<TableModel> dostaveTableModelTableRowSorter = new TableRowSorter<TableModel>(dostaveJTable.getModel());
        dostaveJTable.setRowSorter(dostaveTableModelTableRowSorter);
        int redniBrojKoloneDatum = 2;
        RowFilter<TableModel, Integer> pocetniDatumFilter = RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, pocetniDatum, redniBrojKoloneDatum);
        RowFilter<TableModel, Integer> krajnjiDatumFilter = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, krajnjiDatum, redniBrojKoloneDatum);
        List<RowFilter<TableModel, Integer>> sviFilteri = Arrays.asList(pocetniDatumFilter, krajnjiDatumFilter);
        RowFilter<TableModel, Integer> filter = RowFilter.andFilter(sviFilteri);
        dostaveTableModelTableRowSorter.setRowFilter(filter);

        if (dostaveJTable.getRowCount() > 0) {
            // Oznaci prvi red u tabeli za dostave
            oznaciNtiRedUJTable(dostaveJTable, 0);

            // Uzmi oznacenu dostavu iz tabele Dostave
            Dostava oznacenaDostava = ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta()
                    .get(dostaveJTable.getSelectedRow());

            // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
            PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(oznacenaDostava);
            pecivaDostaveJTable.setModel(pecivaDostaveTableModel);

            // Izracunati zaradu i upisati ju u zarada labelu
            izracunajZaraduNaStavkeUPecivaDostaveJTable();
        }

        // Refreshati panel
        osvjeziJPanel();
    }

    public void popuniSaPodacima(Dostava selektiranaDostava) {
        // Isprazni tabelu peciva u dostavi
        pecivaDostaveJTable.setModel(new PecivaDostaveTableModel());

        // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
        PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(selektiranaDostava);
        pecivaDostaveJTable.setModel(pecivaDostaveTableModel);

        // Izracunati zaradu i upisati ju u zarada labelu
        izracunajZaraduNaStavkeUPecivaDostaveJTable();

        // Refreshati panel
        osvjeziJPanel();
    }

    private void osvjeziJPanel() {
        this.validate();
        this.repaint();
    }

    public Dostava dajSelektiranuDostavu() {
        if (((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta() != null) {
            if (dostaveJTable.getSelectedRow() >= 0 && dostaveJTable.getSelectedRow() < ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta().size()) {
                return ((DostaveTableModel) dostaveJTable.getModel()).getDostaveZaKlijenta().get(dostaveJTable.getSelectedRow());
            }
        }

        return null;
    }
}

class DostaveTableModel extends DefaultTableModel {

    private Klijent klijent;
    private List<Dostava> dostaveZaKlijenta;

    DostaveTableModel() {
    }

    DostaveTableModel(Klijent klijent) {
        if (klijent != null) {
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
                return "Isporučioc";
            case 2:
                return "Datum dostave";
            case 3:
                return "Dostava isporučena";
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
        if (dostaveZaKlijenta != null) {
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

class PecivaDostaveTableModel extends DefaultTableModel {

    private Dostava dostava;
    private List<PecivoUDostavi> pecivaUDostavi;

    PecivaDostaveTableModel() {
    }

    PecivaDostaveTableModel(Dostava dostava) {
        if (dostava != null) {
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
        if (pecivaUDostavi != null) {
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

    }*/
}