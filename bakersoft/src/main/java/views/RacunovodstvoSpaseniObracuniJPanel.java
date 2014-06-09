package views;

import controllers.RacunovodstvoSpaseniObracuniController;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import utilities.Baza;
import utilities.GuiUtilities;
import utilities.JComboBoxItem;
import entities.Dostava;
import entities.Klijent;
import entities.Korisnik;
import entities.Racun;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RacunovodstvoSpaseniObracuniJPanel extends JPanel {
    private JTable obracuniJTable;
    private JComboBox obracunZaJComboBox;
    private JButton obrisiObracunJButton;
    private JButton kreirajPdfJButton;

    /**
     * Create the panel.
     */
    public RacunovodstvoSpaseniObracuniJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Spa\u0161eni obra\u010duni:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

        JLabel obracunZaJLabel = new JLabel("Obra\u010dun za:");
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

        JPanel podaciOObracunimaJPanel = new JPanel();
        podaciOObracunimaJPanel.setBorder(null);
        GridBagConstraints gbc_podaciOObracunimaJPanel = new GridBagConstraints();
        gbc_podaciOObracunimaJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_podaciOObracunimaJPanel.fill = GridBagConstraints.BOTH;
        gbc_podaciOObracunimaJPanel.gridx = 0;
        gbc_podaciOObracunimaJPanel.gridy = 1;
        add(podaciOObracunimaJPanel, gbc_podaciOObracunimaJPanel);
        GridBagLayout gbl_podaciOObracunimaJPanel = new GridBagLayout();
        gbl_podaciOObracunimaJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_podaciOObracunimaJPanel.rowHeights = new int[]{245, 0};
        gbl_podaciOObracunimaJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_podaciOObracunimaJPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        podaciOObracunimaJPanel.setLayout(gbl_podaciOObracunimaJPanel);

        JLabel obracuniJLabel = new JLabel("Obra\u010duni:");
        obracuniJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_obracuniJLabel = new GridBagConstraints();
        gbc_obracuniJLabel.anchor = GridBagConstraints.EAST;
        gbc_obracuniJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_obracuniJLabel.gridx = 0;
        gbc_obracuniJLabel.gridy = 0;
        podaciOObracunimaJPanel.add(obracuniJLabel, gbc_obracuniJLabel);

        JScrollPane obracuniJScrollPane = new JScrollPane();
        GridBagConstraints gbc_obracuniJScrollPane = new GridBagConstraints();
        gbc_obracuniJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_obracuniJScrollPane.gridx = 1;
        gbc_obracuniJScrollPane.gridy = 0;
        podaciOObracunimaJPanel.add(obracuniJScrollPane, gbc_obracuniJScrollPane);

        obracuniJTable = new JTable();
        obracuniJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Datum", "Broj", "Iznos", "Pla\u0107en", "Obra\u010dunao", "Po\u010detak obra\u010duna", "Kraj obra\u010duna"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Object.class, Object.class, Object.class, Boolean.class, Object.class, Object.class, Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        obracuniJScrollPane.setViewportView(obracuniJTable);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 2;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        obrisiObracunJButton = new JButton("Obri\u0161i obra\u010dun");
        GridBagConstraints gbc_obrisiObracunJButton = new GridBagConstraints();
        gbc_obrisiObracunJButton.anchor = GridBagConstraints.SOUTH;
        gbc_obrisiObracunJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_obrisiObracunJButton.insets = new Insets(0, 0, 5, 5);
        gbc_obrisiObracunJButton.gridx = 0;
        gbc_obrisiObracunJButton.gridy = 0;
        dugmadJPanel.add(obrisiObracunJButton, gbc_obrisiObracunJButton);

        kreirajPdfJButton = new JButton("Kreiraj PDF");
        GridBagConstraints gbc_kreirajPdfJButton = new GridBagConstraints();
        gbc_kreirajPdfJButton.insets = new Insets(0, 0, 5, 0);
        gbc_kreirajPdfJButton.anchor = GridBagConstraints.SOUTH;
        gbc_kreirajPdfJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_kreirajPdfJButton.gridx = 1;
        gbc_kreirajPdfJButton.gridy = 0;
        dugmadJPanel.add(kreirajPdfJButton, gbc_kreirajPdfJButton);
        
        dodajListeners();

    }
    
    private void dodajListeners() {
        RacunovodstvoSpaseniObracuniController racunovodstvoSpaseniObracuniController = new RacunovodstvoSpaseniObracuniController(this);

        obracunZaJComboBox.addItemListener(racunovodstvoSpaseniObracuniController.getSpaseniObracuniObracunZaJComboBoxItemListener());
        obrisiObracunJButton.addActionListener(racunovodstvoSpaseniObracuniController.getSpaseniObracuniObrisiJButtonActionListener());
        kreirajPdfJButton.addActionListener(racunovodstvoSpaseniObracuniController.getPDFJButtonActionListener());
    }
    
    class ObracuniTableModel extends DefaultTableModel {

        private Klijent klijent;
        private List<Racun> racuniZaKlijenta;

        ObracuniTableModel() {
        }

        ObracuniTableModel(Klijent klijent) {
            if(klijent != null) {
                this.klijent = klijent;
                this.racuniZaKlijenta = (List<Racun>) klijent.getRacuni();
                List<Racun> obrisaniRacuni = new ArrayList<Racun>();
                for (Racun d : this.racuniZaKlijenta) {
                	if (d.isObrisano()) {
                        obrisaniRacuni.add(d);
                    }
                }
                racuniZaKlijenta.removeAll(obrisaniRacuni);
            }
        }

        public Klijent getKlijent() {
            return klijent;
        }

        public List<Racun> getRacuniZaKlijenta() {
            return racuniZaKlijenta;
        }

        @Override
        public int getRowCount() {
            if (racuniZaKlijenta != null) {
                return racuniZaKlijenta.size();
            }

            return 0;
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Datum";
                case 1:
                    return "Broj";
                case 2:
                    return "Iznos";
                case 3:
                    return "Pla\u0107en";
                case 4:
                    return "Obra\u010dunao";
                case 5:
                    return "Po\u010detak obra\u010duna";
               case 6:
            	   	return "Kraj obra\u010duna";
                default:
                    return null;
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
	            case 0:
	                return Date.class;
	            case 1:
	                return Integer.class;
	            case 2:
	                return Double.class;
	            case 3:
	                return Boolean.class;
	            case 4:
	                return Korisnik.class;
	            case 5:
	                return Date.class;
	           case 6:
	        	   	return Date.class;
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
            if(racuniZaKlijenta != null) {
                switch (columnIndex) {
                    case 0:
                        return racuniZaKlijenta.get(rowIndex).getDatum();
                    case 1:
                    	return racuniZaKlijenta.get(rowIndex).getBroj();
                    case 2:
                        return racuniZaKlijenta.get(rowIndex).getIznos();
                    case 3:
                        return racuniZaKlijenta.get(rowIndex).isJePlacen() ? Boolean.TRUE : Boolean.FALSE;
                    case 4:
                        Korisnik korisnikKojiJeObracunao = racuniZaKlijenta.get(rowIndex).getObracunao();
                        return korisnikKojiJeObracunao.getIme() + " " + korisnikKojiJeObracunao.getPrezime();
                    case 5:
                    	return racuniZaKlijenta.get(rowIndex).getPocetak();
                    case 6:
                    	return racuniZaKlijenta.get(rowIndex).getKraj();
                    default:
                        return null;
                }
            }

            return null;
        }
    }
    
    private void osvjeziJPanel() {
        this.validate();
        this.repaint();
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
    
    public void popuniObracuniJTableSaPodacimaOKlijentu(Klijent selektiraniKlijent) {
        TableModel obracuniTableModel;
        if (selektiraniKlijent != null) {
            obracuniTableModel = new ObracuniTableModel(selektiraniKlijent);
        } else {
            Klijent prazanKlijent = new Klijent();
            prazanKlijent.setRacuni(new ArrayList<Racun>(0));
            obracuniTableModel = new DostaveTableModel(prazanKlijent);
        }
        obracuniJTable.setModel(obracuniTableModel);
    }
    
    public void popuniSaPodacima(long idSelektiranogKlijenta) {
        // Isprazni tabelu dostava
        //obracuniJTable.setModel(new ObracuniTableModel());

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

        // Popuni tabelu obracuni sa obracunima za klijenta koji ima idSelektiranogKlijenta
        Klijent selektiraniKlijent = baza.dajPoId(Klijent.class, idSelektiranogKlijenta);
        popuniObracuniJTableSaPodacimaOKlijentu(selektiraniKlijent);
        // Oznaci prvi red u tabeli za dostave
        if (obracuniJTable.getRowCount() > 0) {
            ListSelectionModel selectionModel = obracuniJTable.getSelectionModel();
            selectionModel.setSelectionInterval(0, 0);

            // Uzmi oznaceni obracun iz tabele Racun
            Racun oznaceniRacun = ((ObracuniTableModel) obracuniJTable.getModel()).getRacuniZaKlijenta()
                    .get(obracuniJTable.getSelectedRow());
        }

        // Refreshati panel
        osvjeziJPanel();
    }
    
    public JTable getObracuniJTable() {
        return obracuniJTable;
    }

    public JComboBox getObracunZaJComboBox() {
        return obracunZaJComboBox;
    }

    public JButton getObrisiObracunJButton() {
        return obrisiObracunJButton;
    }

    public JButton getKreirajPdfJButton() {
        return kreirajPdfJButton;
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
        GuiUtilities.popuniJComboBoxSa(sviKlijentiJComboBoxItemi, obracunZaJComboBox, sviKlijentiJComboBoxItemi.get(0).getId());

        Klijent prviKlijentUJComboBoxu = sviKlijenti.get(0);
        popuniObracuniJTableSaPodacimaOKlijentu(prviKlijentUJComboBoxu);

        osvjeziJPanel();
    }
}
