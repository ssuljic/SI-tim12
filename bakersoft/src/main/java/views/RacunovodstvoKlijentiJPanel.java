package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import entities.Korisnik;
import entities.Status;
import entities.Tip;
import utilities.Baza;
import utilities.GuiUtilities;
import utilities.JComboBoxItem;
import controllers.RacunovodstvoKlijentiController;
import entities.Klijent;
import exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti;

import java.awt.*;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;

public class RacunovodstvoKlijentiJPanel extends JPanel {
    private JTextField nazivFirmeJTextField;
    private JTextField telefonJTextField;
    private JTextField kontaktPodaciImeJTextField;
    private JTextField kontaktPodaciPrezimeJTextField;
    private JTextField kontaktPodaciTelefonJTextField;
    private JTextField kontaktPodaciEmailJTextField;
    private JComboBox traziJComboBox;
    private JButton obrisiJButton;
    private JButton dodajJButton;
    private JButton prethodnoProdajnoMjestoJButton;
    private JButton iduceProdajnoMjestoJButton;
    private JButton dodajProdajnoMjestoJButton;

    /**
     * Create the panel.
     */
    public RacunovodstvoKlijentiJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Klijenti:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JPanel traziJPanel = new JPanel();
        GridBagConstraints gbc_traziJPanel = new GridBagConstraints();
        gbc_traziJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_traziJPanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_traziJPanel.gridx = 0;
        gbc_traziJPanel.gridy = 0;
        add(traziJPanel, gbc_traziJPanel);
        GridBagLayout gbl_traziJPanel = new GridBagLayout();
        gbl_traziJPanel.columnWidths = new int[]{46, 392, 0};
        gbl_traziJPanel.rowHeights = new int[]{141, 0};
        gbl_traziJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_traziJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        traziJPanel.setLayout(gbl_traziJPanel);

        JLabel traziJLabel = new JLabel("Tra\u017Ei:");
        traziJLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        GridBagConstraints gbc_traziJLabel = new GridBagConstraints();
        gbc_traziJLabel.fill = GridBagConstraints.BOTH;
        gbc_traziJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_traziJLabel.gridx = 0;
        gbc_traziJLabel.gridy = 0;
        traziJPanel.add(traziJLabel, gbc_traziJLabel);

        traziJComboBox = new JComboBox();
        traziJComboBox.setEditable(true);
        GridBagConstraints gbc_traziJComboBox = new GridBagConstraints();
        gbc_traziJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_traziJComboBox.gridx = 1;
        gbc_traziJComboBox.gridy = 0;
        traziJPanel.add(traziJComboBox, gbc_traziJComboBox);

        JPanel podaciOFirmiJPanel = new JPanel();
        podaciOFirmiJPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Podaci o firmi:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagConstraints gbc_podaciOFirmiJPanel = new GridBagConstraints();
        gbc_podaciOFirmiJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_podaciOFirmiJPanel.fill = GridBagConstraints.BOTH;
        gbc_podaciOFirmiJPanel.gridx = 0;
        gbc_podaciOFirmiJPanel.gridy = 1;
        add(podaciOFirmiJPanel, gbc_podaciOFirmiJPanel);
        GridBagLayout gbl_podaciOFirmiJPanel = new GridBagLayout();
        gbl_podaciOFirmiJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_podaciOFirmiJPanel.rowHeights = new int[]{0, 0, 0};
        gbl_podaciOFirmiJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_podaciOFirmiJPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        podaciOFirmiJPanel.setLayout(gbl_podaciOFirmiJPanel);

        JLabel nazivFirmeJLabel = new JLabel("Naziv firme:");
        nazivFirmeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_nazivFirmeJLabel = new GridBagConstraints();
        gbc_nazivFirmeJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nazivFirmeJLabel.anchor = GridBagConstraints.EAST;
        gbc_nazivFirmeJLabel.gridx = 0;
        gbc_nazivFirmeJLabel.gridy = 0;
        podaciOFirmiJPanel.add(nazivFirmeJLabel, gbc_nazivFirmeJLabel);

        nazivFirmeJTextField = new JTextField();
        GridBagConstraints gbc_nazivFirmeJTextField = new GridBagConstraints();
        gbc_nazivFirmeJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nazivFirmeJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nazivFirmeJTextField.gridx = 1;
        gbc_nazivFirmeJTextField.gridy = 0;
        podaciOFirmiJPanel.add(nazivFirmeJTextField, gbc_nazivFirmeJTextField);
        nazivFirmeJTextField.setColumns(10);

        JLabel telefonJLabel = new JLabel("Telefon:");
        telefonJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_telefonJLabel = new GridBagConstraints();
        gbc_telefonJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_telefonJLabel.anchor = GridBagConstraints.EAST;
        gbc_telefonJLabel.gridx = 0;
        gbc_telefonJLabel.gridy = 1;
        podaciOFirmiJPanel.add(telefonJLabel, gbc_telefonJLabel);

        telefonJTextField = new JTextField();
        telefonJTextField.setColumns(10);
        GridBagConstraints gbc_telefonJTextField = new GridBagConstraints();
        gbc_telefonJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_telefonJTextField.gridx = 1;
        gbc_telefonJTextField.gridy = 1;
        podaciOFirmiJPanel.add(telefonJTextField, gbc_telefonJTextField);

        JPanel prodajnoMjestoJPanel = new JPanel();
        prodajnoMjestoJPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Prodajno mjesto:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_prodajnoMjestoJPanel = new GridBagConstraints();
        gbc_prodajnoMjestoJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_prodajnoMjestoJPanel.fill = GridBagConstraints.BOTH;
        gbc_prodajnoMjestoJPanel.gridx = 0;
        gbc_prodajnoMjestoJPanel.gridy = 2;
        add(prodajnoMjestoJPanel, gbc_prodajnoMjestoJPanel);
        GridBagLayout gbl_prodajnoMjestoJPanel = new GridBagLayout();
        gbl_prodajnoMjestoJPanel.columnWidths = new int[]{0, 0, 0, 0};
        gbl_prodajnoMjestoJPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_prodajnoMjestoJPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_prodajnoMjestoJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        prodajnoMjestoJPanel.setLayout(gbl_prodajnoMjestoJPanel);

        prethodnoProdajnoMjestoJButton = new JButton("Prethodno prodajno mjesto");
        GridBagConstraints gbc_prethodnoProdajnoMjestoJButton = new GridBagConstraints();
        gbc_prethodnoProdajnoMjestoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_prethodnoProdajnoMjestoJButton.insets = new Insets(0, 0, 5, 5);
        gbc_prethodnoProdajnoMjestoJButton.gridx = 1;
        gbc_prethodnoProdajnoMjestoJButton.gridy = 0;
        prodajnoMjestoJPanel.add(prethodnoProdajnoMjestoJButton, gbc_prethodnoProdajnoMjestoJButton);

        iduceProdajnoMjestoJButton = new JButton("Idu\u0107e prodajno mjesto");
        GridBagConstraints gbc_iduceProdajnoMjestoJButton = new GridBagConstraints();
        gbc_iduceProdajnoMjestoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_iduceProdajnoMjestoJButton.insets = new Insets(0, 0, 5, 0);
        gbc_iduceProdajnoMjestoJButton.gridx = 2;
        gbc_iduceProdajnoMjestoJButton.gridy = 0;
        prodajnoMjestoJPanel.add(iduceProdajnoMjestoJButton, gbc_iduceProdajnoMjestoJButton);

        JLabel kontaktPodaciImeJLabel = new JLabel("Ime:");
        kontaktPodaciImeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_kontaktPodaciImeJLabel = new GridBagConstraints();
        gbc_kontaktPodaciImeJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_kontaktPodaciImeJLabel.anchor = GridBagConstraints.EAST;
        gbc_kontaktPodaciImeJLabel.gridx = 0;
        gbc_kontaktPodaciImeJLabel.gridy = 1;
        prodajnoMjestoJPanel.add(kontaktPodaciImeJLabel, gbc_kontaktPodaciImeJLabel);

        kontaktPodaciImeJTextField = new JTextField();
        GridBagConstraints gbc_kontaktPodaciImeJTextField = new GridBagConstraints();
        gbc_kontaktPodaciImeJTextField.gridwidth = 2;
        gbc_kontaktPodaciImeJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_kontaktPodaciImeJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_kontaktPodaciImeJTextField.gridx = 1;
        gbc_kontaktPodaciImeJTextField.gridy = 1;
        prodajnoMjestoJPanel.add(kontaktPodaciImeJTextField, gbc_kontaktPodaciImeJTextField);
        kontaktPodaciImeJTextField.setColumns(10);

        JLabel kotaktPodaciPrezimeJLabel = new JLabel("Prezime:");
        kotaktPodaciPrezimeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_kotaktPodaciPrezimeJLabel = new GridBagConstraints();
        gbc_kotaktPodaciPrezimeJLabel.anchor = GridBagConstraints.EAST;
        gbc_kotaktPodaciPrezimeJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_kotaktPodaciPrezimeJLabel.gridx = 0;
        gbc_kotaktPodaciPrezimeJLabel.gridy = 2;
        prodajnoMjestoJPanel.add(kotaktPodaciPrezimeJLabel, gbc_kotaktPodaciPrezimeJLabel);

        kontaktPodaciPrezimeJTextField = new JTextField();
        kontaktPodaciPrezimeJTextField.setColumns(10);
        GridBagConstraints gbc_kontaktPodaciPrezimeJTextField = new GridBagConstraints();
        gbc_kontaktPodaciPrezimeJTextField.gridwidth = 2;
        gbc_kontaktPodaciPrezimeJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_kontaktPodaciPrezimeJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_kontaktPodaciPrezimeJTextField.gridx = 1;
        gbc_kontaktPodaciPrezimeJTextField.gridy = 2;
        prodajnoMjestoJPanel.add(kontaktPodaciPrezimeJTextField, gbc_kontaktPodaciPrezimeJTextField);

        JLabel kontaktPodaciTelefonJLabel = new JLabel("Telefon:");
        kontaktPodaciTelefonJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_kontaktPodaciTelefonJLabel = new GridBagConstraints();
        gbc_kontaktPodaciTelefonJLabel.anchor = GridBagConstraints.EAST;
        gbc_kontaktPodaciTelefonJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_kontaktPodaciTelefonJLabel.gridx = 0;
        gbc_kontaktPodaciTelefonJLabel.gridy = 3;
        prodajnoMjestoJPanel.add(kontaktPodaciTelefonJLabel, gbc_kontaktPodaciTelefonJLabel);

        kontaktPodaciTelefonJTextField = new JTextField();
        kontaktPodaciTelefonJTextField.setColumns(10);
        GridBagConstraints gbc_kontaktPodaciTelefonJTextField = new GridBagConstraints();
        gbc_kontaktPodaciTelefonJTextField.gridwidth = 2;
        gbc_kontaktPodaciTelefonJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_kontaktPodaciTelefonJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_kontaktPodaciTelefonJTextField.gridx = 1;
        gbc_kontaktPodaciTelefonJTextField.gridy = 3;
        prodajnoMjestoJPanel.add(kontaktPodaciTelefonJTextField, gbc_kontaktPodaciTelefonJTextField);

        JLabel kontaktPodaciEmailJLabel = new JLabel("E-mail:");
        kontaktPodaciEmailJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_kontaktPodaciEmailJLabel = new GridBagConstraints();
        gbc_kontaktPodaciEmailJLabel.anchor = GridBagConstraints.EAST;
        gbc_kontaktPodaciEmailJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_kontaktPodaciEmailJLabel.gridx = 0;
        gbc_kontaktPodaciEmailJLabel.gridy = 4;
        prodajnoMjestoJPanel.add(kontaktPodaciEmailJLabel, gbc_kontaktPodaciEmailJLabel);

        kontaktPodaciEmailJTextField = new JTextField();
        kontaktPodaciEmailJTextField.setColumns(10);
        GridBagConstraints gbc_kontaktPodaciEmailJTextField = new GridBagConstraints();
        gbc_kontaktPodaciEmailJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_kontaktPodaciEmailJTextField.gridwidth = 2;
        gbc_kontaktPodaciEmailJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_kontaktPodaciEmailJTextField.gridx = 1;
        gbc_kontaktPodaciEmailJTextField.gridy = 4;
        prodajnoMjestoJPanel.add(kontaktPodaciEmailJTextField, gbc_kontaktPodaciEmailJTextField);

        dodajProdajnoMjestoJButton = new JButton("Dodaj prodajno mjesto");
        GridBagConstraints gbc_dodajProdajnoMjestoJButton = new GridBagConstraints();
        gbc_dodajProdajnoMjestoJButton.gridx = 2;
        gbc_dodajProdajnoMjestoJButton.gridy = 5;
        prodajnoMjestoJPanel.add(dodajProdajnoMjestoJButton, gbc_dodajProdajnoMjestoJButton);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 3;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        obrisiJButton = new JButton("Obri\u0161i");
        GridBagConstraints gbc_obrisiJButton = new GridBagConstraints();
        gbc_obrisiJButton.anchor = GridBagConstraints.SOUTH;
        gbc_obrisiJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_obrisiJButton.insets = new Insets(0, 0, 0, 5);
        gbc_obrisiJButton.gridx = 0;
        gbc_obrisiJButton.gridy = 0;
        dugmadJPanel.add(obrisiJButton, gbc_obrisiJButton);

        dodajJButton = new JButton("Dodaj");
        GridBagConstraints gbc_dodajJButton = new GridBagConstraints();
        gbc_dodajJButton.anchor = GridBagConstraints.SOUTH;
        gbc_dodajJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_dodajJButton.gridx = 1;
        gbc_dodajJButton.gridy = 0;
        dugmadJPanel.add(dodajJButton, gbc_dodajJButton);

        dodajListeners();
    }

    public JComboBox getTraziJComboBox() {
        return traziJComboBox;
    }

    public JTextField getNazivFirmeJTextField() {
        return nazivFirmeJTextField;
    }

    public JTextField getTelefonJTextField() {
        return telefonJTextField;
    }

    public JTextField getKontaktPodaciImeJTextField() {
        return kontaktPodaciImeJTextField;
    }

    public JTextField getKontaktPodaciPrezimeJTextField() {
        return kontaktPodaciPrezimeJTextField;
    }

    public JTextField getKontaktPodaciTelefonJTextField() {
        return kontaktPodaciTelefonJTextField;
    }

    public JTextField getKontaktPodaciEmailJTextField() {
        return kontaktPodaciEmailJTextField;
    }

    public JButton getObrisiJButton() {
        return obrisiJButton;
    }

    public JButton getDodajJButton() {
        return dodajJButton;
    }

    public JButton getPrethodnoProdajnoMjestoJButton() {
        return prethodnoProdajnoMjestoJButton;
    }

    public JButton getIduceProdajnoMjestoJButton() {
        return iduceProdajnoMjestoJButton;
    }

    public JButton getDodajProdajnoMjestoJButton() {
        return dodajProdajnoMjestoJButton;
    }

    public void dodajListeners() {
        RacunovodstvoKlijentiController racunovodstvoKlijentiController = new RacunovodstvoKlijentiController(this);

        getTraziJComboBox().addItemListener(racunovodstvoKlijentiController.getKlijentiTraziJComboBoxItemListener());
        getObrisiJButton().addActionListener(racunovodstvoKlijentiController.getKlijentiObrisiJButtonActionListener());
        getDodajJButton().addActionListener(racunovodstvoKlijentiController.getKlijentiDodajJButtonActionListener());
    }
    
    public void popuniSaPodacima(List<Klijent> sviKlijenti, long idSelektovanogKlijenta) {
        // TODO: Vjerovatno bi se još malo moglo refaktorisati ...
        if (sviKlijenti == null || sviKlijenti.size() <= 0) {
            ocistiPanel();
            return;
        }
        
        Klijent selektovaniKlijent = popuniTraziJComboBoxSa(sviKlijenti, idSelektovanogKlijenta);
        
        nazivFirmeJTextField.setText(selektovaniKlijent.getIme());
       // adresaJTextField.setText(selektovaniKlijent.getPrezime());
       // kontaktPodaciImeJTextField.setText(selektovaniKlijent.getKorisnickoIme());
        //kontaktPodaciPrezimeJTextField.setText(selektovaniKlijent.getLozinka());
        kontaktPodaciTelefonJTextField.setText(selektovaniKlijent.getTelefon());
        //kontaktPodaciEmailJTextField.setText(selektovaniKlijent.getEmail());

    }
    
    private Klijent popuniTraziJComboBoxSa(List<Klijent> sviKlijenti, long idSelektovanogKlijenta) {
    	
        Klijent selektovaniKlijent = null;
        JComboBox comboBoxKlijenti = getTraziJComboBox();
        // Izbjegavanje okidanja eventa SELECTED prilikom dinamickog dodavanja itemova
        ItemListener[] itemListeners = comboBoxKlijenti.getItemListeners();
        for (int i = 0; i < itemListeners.length; i++) {
            comboBoxKlijenti.removeItemListener(itemListeners[i]);
        }

        int indexSelektovanogKlijentaUJComboBox = 0;
        int index = 0;
        comboBoxKlijenti.removeAllItems();
        for (Klijent k : sviKlijenti) {
            comboBoxKlijenti.addItem(new JComboBoxItem(k.getId(), k.getIme()));
            if (k.getId() == idSelektovanogKlijenta) {
                selektovaniKlijent = k;
                indexSelektovanogKlijentaUJComboBox = index;
            }
            index++;
        }

        if (selektovaniKlijent == null) {
            throw new NePostojiUBaziStavkaSaDatomIdVrijednosti("Pokusavate popuniti formu za " +
                    "upravljanje korisnickim racunima. Id koji ste proslijedili ne postoji u bazi. " +
                    "Taj id je: " + idSelektovanogKlijenta);
        }

        comboBoxKlijenti.setSelectedIndex(indexSelektovanogKlijentaUJComboBox);

        // Vracanje EventListener-a na JComboBox
        for (int i = 0; i < itemListeners.length; i++) {
            comboBoxKlijenti.addItemListener(itemListeners[i]);
        }
        return selektovaniKlijent;
    }
    
    private void ocistiPanel() {
        traziJComboBox.removeAllItems();
        nazivFirmeJTextField.setText("");
        telefonJTextField.setText("");
        kontaktPodaciImeJTextField.setText("");
        kontaktPodaciPrezimeJTextField.setText("");
        kontaktPodaciEmailJTextField.setText("");
        kontaktPodaciTelefonJTextField.setText("");
       
    }
    
    public Klijent dajPodatkeONovomKlijentu() {
        Klijent klijent = new Klijent();
        klijent.setIme(getNazivFirmeJTextField().getText());
        klijent.setTelefon(getKontaktPodaciTelefonJTextField().getText());
        /*klijent.setIme(getImeJTextField().getText());
        klijent.setPrezime(getPrezimeJTextField().getText());
        klijent.setKorisnickoIme(getKorisnickoImeJTextField().getText());
        klijent.setLozinka(getLozinkaJTextField().getText());
        klijent.setEmail(getEmailJTextField().getText());
        klijent.setBrojTelefona(telefonJTextField.getText());
        klijent.setBrojMobitela(mobitelJTextField.getText());
        klijent.setAdresa(adresaJTextField.getText());
        Date date = new Date(Integer.parseInt(datumRodjenjaGodinaJComboBox.getSelectedItem().toString()),
                Integer.parseInt(datumRodjenjaMjesecJComboBox.getSelectedItem().toString()),
                Integer.parseInt(datumRodjenjaDanJComboBox.getSelectedItem().toString()));
        klijent.setDatumRodjenja(date);*/
        
        return klijent;
    }

    public void popuniSaSvimPodacimaIzBaze() {
        Baza baza = Baza.getBaza();
        java.util.List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);
        long idSelektiranogKlijenta = 0;
        if (sviKlijenti.size() > 0) {
            idSelektiranogKlijenta = sviKlijenti.get(0).getId();
        }
        popuniSaPodacima(sviKlijenti, idSelektiranogKlijenta);
    }
}
