package views;

import entities.Dostava;
import entities.Klijent;
import exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import utilities.Baza;
import utilities.JComboBoxItem;
import controllers.RacunovodstvoKlijentiController;

import java.awt.*;
import java.awt.event.ItemListener;
import java.util.List;

public class RacunovodstvoKlijentiJPanel extends JPanel {
    private JTextField nazivFirmeJTextField;
    private JTextField telefonJTextField;
    private JTextField prodajnoMjestoNazivJTextField;
    private JTextField prodajnoMjestoAdresaJTextField;
    private JComboBox traziJComboBox;
    private JButton obrisiKlijentaJButton;
    private JButton dodajKlijentaJButton;
    private JButton dodajProdajnoMjestoJButton;
    private JComboBox prodajnoMjestoJComboBox;
    private JButton obrisiProdajnoMjestoJButton;

    /**
     * Create the panel.
     */
    public RacunovodstvoKlijentiJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Klijenti:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
        gbl_prodajnoMjestoJPanel.columnWidths = new int[]{0, 147, 0, 0};
        gbl_prodajnoMjestoJPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_prodajnoMjestoJPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_prodajnoMjestoJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        prodajnoMjestoJPanel.setLayout(gbl_prodajnoMjestoJPanel);

        prodajnoMjestoJComboBox = new JComboBox();
        GridBagConstraints gbc_prodajnoMjestoJComboBox = new GridBagConstraints();
        gbc_prodajnoMjestoJComboBox.gridwidth = 2;
        gbc_prodajnoMjestoJComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_prodajnoMjestoJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_prodajnoMjestoJComboBox.gridx = 1;
        gbc_prodajnoMjestoJComboBox.gridy = 0;
        prodajnoMjestoJPanel.add(prodajnoMjestoJComboBox, gbc_prodajnoMjestoJComboBox);

        JLabel prodajnoMjestoNazivJLabel = new JLabel("Naziv:");
        prodajnoMjestoNazivJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_prodajnoMjestoNazivJLabel = new GridBagConstraints();
        gbc_prodajnoMjestoNazivJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_prodajnoMjestoNazivJLabel.anchor = GridBagConstraints.EAST;
        gbc_prodajnoMjestoNazivJLabel.gridx = 0;
        gbc_prodajnoMjestoNazivJLabel.gridy = 1;
        prodajnoMjestoJPanel.add(prodajnoMjestoNazivJLabel, gbc_prodajnoMjestoNazivJLabel);

        prodajnoMjestoNazivJTextField = new JTextField();
        GridBagConstraints gbc_prodajnoMjestoNazivJTextField = new GridBagConstraints();
        gbc_prodajnoMjestoNazivJTextField.gridwidth = 2;
        gbc_prodajnoMjestoNazivJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_prodajnoMjestoNazivJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_prodajnoMjestoNazivJTextField.gridx = 1;
        gbc_prodajnoMjestoNazivJTextField.gridy = 1;
        prodajnoMjestoJPanel.add(prodajnoMjestoNazivJTextField, gbc_prodajnoMjestoNazivJTextField);
        prodajnoMjestoNazivJTextField.setColumns(10);

        JLabel prodajnoMjestoAdresaJLabel = new JLabel("Adresa:");
        prodajnoMjestoAdresaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_prodajnoMjestoAdresaJLabel = new GridBagConstraints();
        gbc_prodajnoMjestoAdresaJLabel.anchor = GridBagConstraints.EAST;
        gbc_prodajnoMjestoAdresaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_prodajnoMjestoAdresaJLabel.gridx = 0;
        gbc_prodajnoMjestoAdresaJLabel.gridy = 2;
        prodajnoMjestoJPanel.add(prodajnoMjestoAdresaJLabel, gbc_prodajnoMjestoAdresaJLabel);

        prodajnoMjestoAdresaJTextField = new JTextField();
        prodajnoMjestoAdresaJTextField.setColumns(10);
        GridBagConstraints gbc_prodajnoMjestoAdresaJTextField = new GridBagConstraints();
        gbc_prodajnoMjestoAdresaJTextField.gridwidth = 2;
        gbc_prodajnoMjestoAdresaJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_prodajnoMjestoAdresaJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_prodajnoMjestoAdresaJTextField.gridx = 1;
        gbc_prodajnoMjestoAdresaJTextField.gridy = 2;
        prodajnoMjestoJPanel.add(prodajnoMjestoAdresaJTextField, gbc_prodajnoMjestoAdresaJTextField);

        obrisiProdajnoMjestoJButton = new JButton("Obri\u0161i prodajno mjesto");
        GridBagConstraints gbc_obrisiProdajnoMjestoJButton = new GridBagConstraints();
        gbc_obrisiProdajnoMjestoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_obrisiProdajnoMjestoJButton.insets = new Insets(0, 0, 0, 5);
        gbc_obrisiProdajnoMjestoJButton.gridx = 1;
        gbc_obrisiProdajnoMjestoJButton.gridy = 3;
        prodajnoMjestoJPanel.add(obrisiProdajnoMjestoJButton, gbc_obrisiProdajnoMjestoJButton);

        dodajProdajnoMjestoJButton = new JButton("Dodaj prodajno mjesto");
        GridBagConstraints gbc_dodajProdajnoMjestoJButton = new GridBagConstraints();
        gbc_dodajProdajnoMjestoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_dodajProdajnoMjestoJButton.gridx = 2;
        gbc_dodajProdajnoMjestoJButton.gridy = 3;
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

        obrisiKlijentaJButton = new JButton("Obri\u0161i klijenta");
        GridBagConstraints gbc_obrisiKlijentaJButton = new GridBagConstraints();
        gbc_obrisiKlijentaJButton.anchor = GridBagConstraints.SOUTH;
        gbc_obrisiKlijentaJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_obrisiKlijentaJButton.insets = new Insets(0, 0, 0, 5);
        gbc_obrisiKlijentaJButton.gridx = 0;
        gbc_obrisiKlijentaJButton.gridy = 0;
        dugmadJPanel.add(obrisiKlijentaJButton, gbc_obrisiKlijentaJButton);

        dodajKlijentaJButton = new JButton("Dodaj klijenta");
        GridBagConstraints gbc_dodajKlijentaJButton = new GridBagConstraints();
        gbc_dodajKlijentaJButton.anchor = GridBagConstraints.SOUTH;
        gbc_dodajKlijentaJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_dodajKlijentaJButton.gridx = 1;
        gbc_dodajKlijentaJButton.gridy = 0;
        dugmadJPanel.add(dodajKlijentaJButton, gbc_dodajKlijentaJButton);

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

    public JTextField getProdajnoMjestoNazivJTextField() {
        return prodajnoMjestoNazivJTextField;
    }

    public JTextField getProdajnoMjestoAdresaJTextField() {
        return prodajnoMjestoAdresaJTextField;
    }

    public JButton getObrisiKlijentaJButton() {
        return obrisiKlijentaJButton;
    }

    public JButton getDodajKlijentaJButton() {
        return dodajKlijentaJButton;
    }

    public JComboBox getProdajnoMjestoJComboBox() {
        return prodajnoMjestoJComboBox;
    }

    public JButton getObrisiProdajnoMjestoJButton() {
        return obrisiProdajnoMjestoJButton;
    }

    public JButton getDodajProdajnoMjestoJButton() {
        return dodajProdajnoMjestoJButton;
    }

    public void dodajListeners() {
    	RacunovodstvoKlijentiController racunovodstvoKlijentiController = new RacunovodstvoKlijentiController(this);

        getTraziJComboBox().addItemListener(racunovodstvoKlijentiController.getKlijentiTraziJComboBoxItemListener());
        getObrisiKlijentaJButton().addActionListener(racunovodstvoKlijentiController.getKlijentiObrisiJButtonActionListener());
        getDodajKlijentaJButton().addActionListener(racunovodstvoKlijentiController.getKlijentiDodajJButtonActionListener());
    }

    public void popuniSaPodacima(List<Klijent> sviKlijenti, long idSelektovanogKlijenta) {
    	// TODO: Vjerovatno bi se još malo moglo refaktorisati ...
        if (sviKlijenti == null || sviKlijenti.size() <= 0) {
            ocistiPanel();
            return;
        }
        
        Klijent selektovaniKlijent = popuniTraziJComboBoxSa(sviKlijenti, idSelektovanogKlijenta);
        
        nazivFirmeJTextField.setText(selektovaniKlijent.getIme());
        telefonJTextField.setText(selektovaniKlijent.getTelefon());

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

    }

    public Klijent dajPodatkeONovomKlijentu() {
    	Klijent klijent = new Klijent();
        klijent.setIme(getNazivFirmeJTextField().getText());
        klijent.setTelefon(getTelefonJTextField().getText());
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
