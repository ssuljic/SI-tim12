package views;

import controllers.DostavljacPreuzimanjePecivaController;
import entities.*;
import exceptions.PodaciNisuValidniException;
import utilities.Baza;
import utilities.GuiUtilities;
import utilities.JComboBoxItem;
import utilities.Validator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.*;
import java.util.List;

public class DostavljacPreuzimanjePecivaJPanel extends JPanel {
    private JTextField nazivDostaveJTextField;
	private JTable pecivaJTable;
    private JButton ukloniPecivoJButton;
    private JButton dodajPecivoJButton;
    private JButton preuzmiDostavuJButton;
    private JScrollPane pecivaUDostaviJScrollPane;
	private JTable pecivaUDostaviJTable;
	private JSpinner kolicinaJSpinner;
    private JLabel kolicinaJLabel;
    private JComboBox dostavaZaJComboBox;
    private JLabel dostavaZaJLabel;

    private static final Validator VALIDATOR = Validator.instancirajValidatora();
    
    /**
     * Create the panel.
     */
    public DostavljacPreuzimanjePecivaJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Preuzimanje peciva:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 185, 0, 177, 76, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel nazivDostaveJLabel = new JLabel("Naziv dostave:");
        GridBagConstraints gbc_nazivDostaveJLabel = new GridBagConstraints();
        gbc_nazivDostaveJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nazivDostaveJLabel.anchor = GridBagConstraints.EAST;
        gbc_nazivDostaveJLabel.gridx = 0;
        gbc_nazivDostaveJLabel.gridy = 0;
        add(nazivDostaveJLabel, gbc_nazivDostaveJLabel);

        nazivDostaveJTextField = new JTextField();
        GridBagConstraints gbc_nazivDostaveJTextField = new GridBagConstraints();
        gbc_nazivDostaveJTextField.insets = new Insets(0, 0, 5, 5);
        gbc_nazivDostaveJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nazivDostaveJTextField.gridx = 1;
        gbc_nazivDostaveJTextField.gridy = 0;
        add(nazivDostaveJTextField, gbc_nazivDostaveJTextField);
        nazivDostaveJTextField.setColumns(10);

        dostavaZaJLabel = new JLabel("Dostava za:");
        GridBagConstraints gbc_dostavaZaJLabel = new GridBagConstraints();
        gbc_dostavaZaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_dostavaZaJLabel.anchor = GridBagConstraints.EAST;
        gbc_dostavaZaJLabel.gridx = 0;
        gbc_dostavaZaJLabel.gridy = 1;
        add(dostavaZaJLabel, gbc_dostavaZaJLabel);

        dostavaZaJComboBox = new JComboBox();
        GridBagConstraints gbc_dostavaZaJComboBox = new GridBagConstraints();
        gbc_dostavaZaJComboBox.insets = new Insets(0, 0, 5, 5);
        gbc_dostavaZaJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_dostavaZaJComboBox.gridx = 1;
        gbc_dostavaZaJComboBox.gridy = 1;
        add(dostavaZaJComboBox, gbc_dostavaZaJComboBox);

        JScrollPane dostavaJScrollPane = new JScrollPane();
        GridBagConstraints gbc_dostavaJScrollPane = new GridBagConstraints();
        gbc_dostavaJScrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_dostavaJScrollPane.gridwidth = 2;
        gbc_dostavaJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_dostavaJScrollPane.gridx = 0;
        gbc_dostavaJScrollPane.gridy = 2;
        add(dostavaJScrollPane, gbc_dostavaJScrollPane);

        pecivaJTable = new JTable();
        pecivaJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Pecivo", "\u0160ifra"
                }
        ));
        dostavaJScrollPane.setViewportView(pecivaJTable);

        kolicinaJLabel = new JLabel("Koli\u010dina:");
        kolicinaJLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        GridBagConstraints gbc_kolicinaJLabel = new GridBagConstraints();
        gbc_kolicinaJLabel.anchor = GridBagConstraints.EAST;
        gbc_kolicinaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_kolicinaJLabel.gridx = 0;
        gbc_kolicinaJLabel.gridy = 3;
        add(kolicinaJLabel, gbc_kolicinaJLabel);

        kolicinaJSpinner = new JSpinner();
        GridBagConstraints gbc_kolicinaJSpinner = new GridBagConstraints();
        gbc_kolicinaJSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbc_kolicinaJSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_kolicinaJSpinner.gridx = 1;
        gbc_kolicinaJSpinner.gridy = 3;
        add(kolicinaJSpinner, gbc_kolicinaJSpinner);

        pecivaUDostaviJScrollPane = new JScrollPane();
        GridBagConstraints gbc_pecivaUDostaviJScrollPane = new GridBagConstraints();
        gbc_pecivaUDostaviJScrollPane.gridwidth = 3;
        gbc_pecivaUDostaviJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_pecivaUDostaviJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_pecivaUDostaviJScrollPane.gridx = 0;
        gbc_pecivaUDostaviJScrollPane.gridy = 4;
        add(pecivaUDostaviJScrollPane, gbc_pecivaUDostaviJScrollPane);

        pecivaUDostaviJTable = new JTable();
        pecivaUDostaviJTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Pecivo", "\u0160ifra", "Koli\u010dina"
                }
        ));
        pecivaUDostaviJScrollPane.setViewportView(pecivaUDostaviJTable);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.insets = new Insets(0, 0, 0, 5);
        gbc_dugmadJPanel.gridwidth = 2;
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 5;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        ukloniPecivoJButton = new JButton("Ukloni pecivo");
        GridBagConstraints gbc_ukloniPecivoJButton = new GridBagConstraints();
        gbc_ukloniPecivoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_ukloniPecivoJButton.insets = new Insets(0, 0, 5, 5);
        gbc_ukloniPecivoJButton.gridx = 0;
        gbc_ukloniPecivoJButton.gridy = 0;
        dugmadJPanel.add(ukloniPecivoJButton, gbc_ukloniPecivoJButton);

        dodajPecivoJButton = new JButton("Dodaj pecivo");
        GridBagConstraints gbc_dodajPecivoJButton = new GridBagConstraints();
        gbc_dodajPecivoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_dodajPecivoJButton.insets = new Insets(0, 0, 5, 0);
        gbc_dodajPecivoJButton.gridx = 1;
        gbc_dodajPecivoJButton.gridy = 0;
        dugmadJPanel.add(dodajPecivoJButton, gbc_dodajPecivoJButton);

        preuzmiDostavuJButton = new JButton("Preuzmi dostavu");
        GridBagConstraints gbc_preuzmiDostavuJButton = new GridBagConstraints();
        gbc_preuzmiDostavuJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_preuzmiDostavuJButton.gridwidth = 2;
        gbc_preuzmiDostavuJButton.insets = new Insets(0, 0, 0, 5);
        gbc_preuzmiDostavuJButton.gridx = 0;
        gbc_preuzmiDostavuJButton.gridy = 1;
        dugmadJPanel.add(preuzmiDostavuJButton, gbc_preuzmiDostavuJButton);

        dodajListeners();
    }
    
    public JTable getPecivaUDostaviJTable() {
		return pecivaUDostaviJTable;
	}

	public void setPecivaUDostaviJTable(JTable pecivaUDostaviJTable) {
		this.pecivaUDostaviJTable = pecivaUDostaviJTable;
	}

    public JTextField getNazivDostaveJTextField() {
		return nazivDostaveJTextField;
	}

	public void setNazivDostaveJTextField(JTextField nazivDostaveJTextField) {
		this.nazivDostaveJTextField = nazivDostaveJTextField;
	}

	public JSpinner getKolicinaJSpinner() {
		return kolicinaJSpinner;
	}

	public void setKolicinaJSpinner(JSpinner kolicinaJSpinner) {
		this.kolicinaJSpinner = kolicinaJSpinner;
	}
    
    public JTable getPecivaJTable() {
        return pecivaJTable;
    }

    public JButton getUkloniPecivoJButton() {
        return ukloniPecivoJButton;
    }

    public JButton getDodajPecivoJButton() {
        return dodajPecivoJButton;
    }

    public JButton getPreuzmiDostavuJButton() {
        return preuzmiDostavuJButton;
    }
    
    public JScrollPane getPecivaUDostaviJScrollPane() {
		return pecivaUDostaviJScrollPane;
	}

	public void setPecivaUDostaviJScrollPane(JScrollPane pecivaUDostaviJScrollPane) {
		this.pecivaUDostaviJScrollPane = pecivaUDostaviJScrollPane;
	}

    public void dodajListeners() {
        DostavljacPreuzimanjePecivaController dostavljacPreuzimanjePecivaJPanel = new DostavljacPreuzimanjePecivaController(this);

        dodajPecivoJButton.addActionListener(dostavljacPreuzimanjePecivaJPanel.getDostavljacPreuzimanjePecivaDodajPecivoJButton());
        ukloniPecivoJButton.addActionListener(dostavljacPreuzimanjePecivaJPanel.getDostavljacPreuzimanjePecivaUkloniPecivoJButton());
        preuzmiDostavuJButton.addActionListener(dostavljacPreuzimanjePecivaJPanel.getDostavljacPreuzimanjePecivaPreuzmiDostavuJButton());
    }

    public void popuniSaSvimPodacimaIzBaze(int oznaceniRed) {
        Baza baza = Baza.getBaza();

        // Uzmi sve klijente iz baze
        List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);
        // Izfiltriraj obrisane klijente
        ukloniObrisaneKlijente(sviKlijenti);

        List<JComboBoxItem> sviKlijentiJComboBoxItemi = napraviJComboBoxItemeZa(sviKlijenti);

        if(sviKlijentiJComboBoxItemi != null && oznaceniRed>0 && oznaceniRed<sviKlijentiJComboBoxItemi.size()) {
            GuiUtilities.popuniJComboBoxSa(sviKlijentiJComboBoxItemi, dostavaZaJComboBox, sviKlijentiJComboBoxItemi.get(oznaceniRed).getId());
        } else if(sviKlijentiJComboBoxItemi != null && sviKlijenti.size()>0) {
            GuiUtilities.popuniJComboBoxSa(sviKlijentiJComboBoxItemi, dostavaZaJComboBox, sviKlijentiJComboBoxItemi.get(0).getId());
        }

        // Uzmi sva peciva iz baze
        List<Pecivo> svaPeciva = baza.dajSve(Pecivo.class);

        // izfiltriraj peciva koja su obrisana
        ukloniObrisanaPecivaIz(svaPeciva);

        // Popuni tabelu za pecivaUDostavi sa pecivima
        pecivaJTable.setModel(new PreuzimanjeDostavePecivaJTable());

        if (svaPeciva.size() > 0) {
            PreuzimanjeDostavePecivaJTable dostaveTableModel = new PreuzimanjeDostavePecivaJTable(svaPeciva);
            pecivaJTable.setModel(dostaveTableModel);
        }

        // Oznaci zadani red, ali ukoliko je izvan opsega oznaci prvi red u tabeli za pecivaUDostavi
        if (pecivaJTable.getRowCount() > 0 && oznaceniRed < pecivaJTable.getRowCount()) {
            GuiUtilities.oznaciNtiRedUJTable(pecivaJTable, oznaceniRed);
        } else if (pecivaJTable.getRowCount() > 0) {
            GuiUtilities.oznaciNtiRedUJTable(pecivaJTable, 0);
        }

        // Popuniti tabelu sa pecivima u dostavi sa praznim podacima
        PreuzimanjeDostavePecivaUDostaviTableModel preuzimanjeDostavePecivaUDostaviTableModel = new PreuzimanjeDostavePecivaUDostaviTableModel();
        pecivaUDostaviJTable.setModel(preuzimanjeDostavePecivaUDostaviTableModel);

        // Refreshati panel
        osvjeziJPanel();
    }

    private List<JComboBoxItem> napraviJComboBoxItemeZa(List<Klijent> sviKlijenti) {
        List<JComboBoxItem> jComboBoxItemi = new ArrayList<JComboBoxItem>(sviKlijenti.size());
        for(Klijent k : sviKlijenti) {
            jComboBoxItemi.add(new JComboBoxItem(k.getId(), k.getIme()));
        }

        return jComboBoxItemi;
    }

    private void ukloniObrisaneKlijente(List<Klijent> sviKlijenti) {
        List<Klijent> obrisaniKlijenti = new ArrayList<Klijent>();
        for(Klijent k : sviKlijenti) {
            if(k.isObrisano()) {
                obrisaniKlijenti.add(k);
            }
        }
        sviKlijenti.removeAll(obrisaniKlijenti);
    }

    private void ukloniObrisanaPecivaIz(List<Pecivo> svaPeciva) {
        List<Pecivo> obrisanaPeciva = new ArrayList<Pecivo>();
        for (Pecivo p : svaPeciva) {
            if (p.isObrisano()) {
                obrisanaPeciva.add(p);
            }
        }
        svaPeciva.removeAll(obrisanaPeciva);
    }

    public void osvjeziJPanel() {
        this.validate();
        this.repaint();
    }
    
    public void osvjeziJPanel2() {
        getNazivDostaveJTextField().setText("");
        getKolicinaJSpinner().setValue(0);
        //osvjeziPecivaUDostaviTabelu();
		pecivaUDostaviJTable.setModel(new PreuzimanjeDostavePecivaUDostaviTableModel());
		pecivaUDostaviJTable.validate();
		pecivaUDostaviJTable.repaint();
    }

    public PecivoUDostavi dajSelektiranoPecivoUDostaviIzPecivaDodanihUDostavu() {
        List<PecivoUDostavi> pecivaUDostaviIzTabele = ((PreuzimanjeDostavePecivaUDostaviTableModel)pecivaUDostaviJTable.getModel()).getPecivaUDostavi();
        if(pecivaUDostaviIzTabele != null) {
            int selektiraniRed = pecivaUDostaviJTable.getSelectedRow();
            if(selektiraniRed>=0 && selektiraniRed<pecivaUDostaviIzTabele.size()) {
                return pecivaUDostaviIzTabele.get(selektiraniRed);
            }
        }

        return null;
    }

    public List<PecivoUDostavi> dajSvaDodanaPeciva() {
        return ((PreuzimanjeDostavePecivaUDostaviTableModel)pecivaUDostaviJTable.getModel()).getPecivaUDostavi();
    }

    public void popuniPecivaUDostaviTabeluSaSelektiranimPecivomIUnesenomKolicinom() {
        /**
         *  Popuni sva pecivaUDostavi u dostavi koja su povezana na trenutno oznacenu dostavu i popuni tabelu koja
         *  cuva detaljne podatke o dostavi
         */
        // Uzmi indeks selektiranog reda u tabeli dostava
        int selektiraniRed = pecivaJTable.getSelectedRow();
        // Iz TableModel-a tabele peciva uzmi Pecivo koje je oznaceno
        List<Pecivo> peciva = ((PreuzimanjeDostavePecivaJTable)pecivaJTable.getModel()).getPeciva();
        if(peciva != null && selektiraniRed>=0 && selektiraniRed<pecivaJTable.getRowCount()) {
            Pecivo selektiranoPecivo = peciva.get(selektiraniRed);
            PecivoUDostavi pecivoUDostavi = new PecivoUDostavi();
            pecivoUDostavi.setPecivo(selektiranoPecivo);
            int kolicinaPreuzetogPeciva = (Integer)(kolicinaJSpinner.getValue());
            pecivoUDostavi.setKolicinaPreuzetogPeciva(kolicinaPreuzetogPeciva);
            pecivoUDostavi.setKolicinaVracenogPeciva(0.0);
            pecivoUDostavi.setObrisano(false);

            // Dodaj u tabelu peciva u dostavi
            if(((PreuzimanjeDostavePecivaUDostaviTableModel)pecivaUDostaviJTable.getModel()).getPecivaUDostavi() != null) {
                ((PreuzimanjeDostavePecivaUDostaviTableModel)pecivaUDostaviJTable.getModel()).getPecivaUDostavi().add(pecivoUDostavi);
            } else {
                List<PecivoUDostavi> pecivaUDostavi = new ArrayList<PecivoUDostavi>();
                pecivaUDostavi.add(pecivoUDostavi);
                pecivaUDostaviJTable.setModel(new PreuzimanjeDostavePecivaUDostaviTableModel(pecivaUDostavi));
            }

        }

        osvjeziPecivaUDostaviTabelu();
        osvjeziJPanel();
    }

    private void validirajUnesenePodatke() throws PodaciNisuValidniException {
		String nazivDostave = nazivDostaveJTextField.getText();
		
		if(nazivDostave != null) {
			if(!VALIDATOR.jeNazivValidan(nazivDostave)) {
				throw new PodaciNisuValidniException("Naziv dostave nije ispravno unesen. (Mora se sastojati samo od velikih, malih slova, brojeva i razmacima izme\u0111u rije\u010di, ali ne smije po\u010dinjati praznim mjestom.)");
			}
		}
	}

	public void osvjeziPecivaUDostaviTabelu() {
        ((PreuzimanjeDostavePecivaUDostaviTableModel)pecivaUDostaviJTable.getModel()).fireTableDataChanged();
    }

    public Dostava napraviDostavu() throws PodaciNisuValidniException {
    	validirajUnesenePodatke();
        Baza baza = Baza.getBaza();
        Dostava dostava = new Dostava();
        dostava.setJeIsporuceno(false);
        dostava.setObrisano(false);
        List<PecivoUDostavi> pecivaUDostavi = ((PreuzimanjeDostavePecivaUDostaviTableModel)pecivaUDostaviJTable.getModel()).getPecivaUDostavi();
       
        
        dostava.setPeciva(pecivaUDostavi);
        

        dostava.setNaziv(nazivDostaveJTextField.getText());
        Korisnik dostavljac = ((DostavljacJFrame)SwingUtilities.getWindowAncestor(this)).getKorisnik();
        dostava.setPreuzeo(dostavljac);
        if(dostavljac.getDostave() == null) {
            dostavljac.setDostave(new ArrayList<Dostava>());
        }

        dostavljac.getDostave().add(dostava);

        Klijent narucilac = baza.dajPoId(Klijent.class, ((JComboBoxItem)dostavaZaJComboBox.getSelectedItem()).getId());
        dostava.setKlijent(narucilac);
        if(narucilac.getDostave() == null) {
            narucilac.setDostave(new ArrayList<Dostava>());
        }

        dostava.setDatum(new Date());
        
        /*Iterator<PecivoUDostavi> p = pecivaUDostavi.iterator();
        while(p.hasNext()){
        	if(((PecivoUDostavi)p).getPecivo().getPecivaUDostavi() == null){
                ((PecivoUDostavi)p).getPecivo().setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
            }

            ((PecivoUDostavi) p).getPecivo().getPecivaUDostavi().add((PecivoUDostavi) p);
            ((PecivoUDostavi) p).setDostava(dostava);
            baza.spasiUBazu(p);
            baza.azuriraj(((PecivoUDostavi) p).getPecivo());
            p.next();
        }
        */


        for(int i=0; i<pecivaUDostavi.size(); i++){
        	if(pecivaUDostavi.get(i).getPecivo().getPecivaUDostavi() == null){
        		pecivaUDostavi.get(i).getPecivo().setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
        	}
        	pecivaUDostavi.get(i).getPecivo().getPecivaUDostavi().add(pecivaUDostavi.get(i));
        	pecivaUDostavi.get(i).setDostava(dostava);
        	baza.spasiUBazu(pecivaUDostavi.get(i));
        	baza.azuriraj(pecivaUDostavi.get(i).getPecivo());
        }
        /*
        for(PecivoUDostavi p : pecivaUDostavi) {
            if(p.getPecivo().getPecivaUDostavi() == null){
                p.getPecivo().setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
            }

            p.getPecivo().getPecivaUDostavi().add(p);
            p.setDostava(dostava);
            baza.spasiUBazu(p);
            baza.azuriraj(p.getPecivo());
        }*/

        dostava.setKlijent(narucilac);
        baza.spasiUBazu(dostava);
        baza.azuriraj(dostavljac);
        narucilac.getDostave().add(dostava);
        baza.azuriraj(narucilac);
        return dostava;
    }

	public void validirajPodatke() {
		if(getNazivDostaveJTextField().getText().isEmpty())
			throw new IllegalArgumentException("Polje naziv dostave ne mo\u017ee biti prazno.");
		
        List<PecivoUDostavi> pecivaUDostavi = ((PreuzimanjeDostavePecivaUDostaviTableModel)pecivaUDostaviJTable.getModel()).getPecivaUDostavi();
        if(pecivaUDostavi == null)
			throw new IllegalArgumentException("Morate dodati barem jednu stavku.");

	}
	
	public void validirajPodatke2() {
		if((Integer)getKolicinaJSpinner().getValue() == 0)
			throw new IllegalArgumentException("Koli\u010dina ne mo\u017ee biti 0.");
		if((Integer)getKolicinaJSpinner().getValue() < 0)
			throw new IllegalArgumentException("Koli\u010dina ne mo\u017ee biti negativne vrijednosti.");
	}
}

class PreuzimanjeDostavePecivaJTable extends DefaultTableModel {

    private java.util.List<Pecivo> peciva;

    PreuzimanjeDostavePecivaJTable() {
    }

    PreuzimanjeDostavePecivaJTable(java.util.List<Pecivo> peciva) {
        if (peciva != null) {
            this.peciva = peciva;
        } else {
            this.peciva = new ArrayList<Pecivo>(0);
        }
    }

    public java.util.List<Pecivo> getPeciva() {
        return peciva;
    }

    @Override
    public int getRowCount() {
        if (peciva != null) {
            return peciva.size();
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
                return "Peciva";
            case 1:
                return "\u0160ifra";
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
        if (peciva != null) {
            switch (columnIndex) {
                case 0:
                    return peciva.get(rowIndex).getNaziv();
                case 1:
                    return peciva.get(rowIndex).getSifra();
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

class PreuzimanjeDostavePecivaUDostaviTableModel extends DefaultTableModel {

    private java.util.List<PecivoUDostavi> pecivaUDostavi;

    PreuzimanjeDostavePecivaUDostaviTableModel() {
    }

    PreuzimanjeDostavePecivaUDostaviTableModel(java.util.List<PecivoUDostavi> pecivaUDostavi) {
        if (pecivaUDostavi != null) {
            this.pecivaUDostavi = pecivaUDostavi;
        } else {
            this.pecivaUDostavi = new ArrayList<PecivoUDostavi>(0);
        }
    }

    public java.util.List<PecivoUDostavi> getPecivaUDostavi() {
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
                return "Koli\u010dina";
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
