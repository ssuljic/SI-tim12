package views;

import controllers.RacunovodstvoKorisnickiRacuniController;
import entities.Korisnik;
import entities.Status;
import entities.Tip;
import exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti;
import utilities.Baza;
import utilities.GuiUtilities;
import utilities.JComboBoxItem;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RacunovodstvoKorisnickiRacuniJPanel extends JPanel {
    private JTextField imeJTextField;
    private JTextField prezimeJTextField;
    private JTextField korisnickoImeJTextField;
    private JTextField lozinkaJTextField;
    private JComboBox traziJComboBox;
    private JComboBox privilegijeJComboBox;
    private JButton obrisiJButton;
    private JButton dodajJButton;
    private JTextField emailJTextField;
    private JTextField telefonJTextField;
    private JTextField mobitelJTextField;
    private JTextField adresaJTextField;
    private JLabel lozinkaJLabel;
    private JLabel korisnickoImeJLabel;
    private JLabel emailJLabel;
    private JLabel telefonJLabel;
    private JLabel datumRodjenjaJLabel;
    private JLabel mobitelJLabel;
    private JLabel adresaJLabel;
    private JComboBox datumRodjenjaGodinaJComboBox;
    private JComboBox datumRodjenjaMjesecJComboBox;
    private JComboBox datumRodjenjaDanJComboBox;
    private JLabel datumRodjenjaMjesecJLabel;
    private JLabel datumRodjenjaGodinaJLabel;
    private JLabel datumRodjenjaDanJLabel;
    private JLabel statusJLabel;
    private JComboBox statusJComboBox;
    private JLabel privilegijeJLabel;
    private JButton azurirajJButton;

    /**
     * Create the panel.
     */
    public RacunovodstvoKorisnickiRacuniJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Korisni\u010Dki ra\u010Duni:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
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

        JPanel podaciOKorisnikuJPanel = new JPanel();
        podaciOKorisnikuJPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Podaci o korisniku:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagConstraints gbc_podaciOKorisnikuJPanel = new GridBagConstraints();
        gbc_podaciOKorisnikuJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_podaciOKorisnikuJPanel.fill = GridBagConstraints.BOTH;
        gbc_podaciOKorisnikuJPanel.gridx = 0;
        gbc_podaciOKorisnikuJPanel.gridy = 1;
        add(podaciOKorisnikuJPanel, gbc_podaciOKorisnikuJPanel);
        GridBagLayout gbl_podaciOKorisnikuJPanel = new GridBagLayout();
        gbl_podaciOKorisnikuJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_podaciOKorisnikuJPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_podaciOKorisnikuJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_podaciOKorisnikuJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        podaciOKorisnikuJPanel.setLayout(gbl_podaciOKorisnikuJPanel);

        JLabel imeJLabel = new JLabel("Ime:");
        imeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_imeJLabel = new GridBagConstraints();
        gbc_imeJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_imeJLabel.anchor = GridBagConstraints.EAST;
        gbc_imeJLabel.gridx = 0;
        gbc_imeJLabel.gridy = 0;
        podaciOKorisnikuJPanel.add(imeJLabel, gbc_imeJLabel);

        imeJTextField = new JTextField();
        GridBagConstraints gbc_imeJTextField = new GridBagConstraints();
        gbc_imeJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_imeJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_imeJTextField.gridx = 1;
        gbc_imeJTextField.gridy = 0;
        podaciOKorisnikuJPanel.add(imeJTextField, gbc_imeJTextField);
        imeJTextField.setColumns(10);

        JLabel prezimeJLabel = new JLabel("Prezime:");
        prezimeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_prezimeJLabel = new GridBagConstraints();
        gbc_prezimeJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_prezimeJLabel.anchor = GridBagConstraints.EAST;
        gbc_prezimeJLabel.gridx = 0;
        gbc_prezimeJLabel.gridy = 1;
        podaciOKorisnikuJPanel.add(prezimeJLabel, gbc_prezimeJLabel);

        prezimeJTextField = new JTextField();
        prezimeJTextField.setColumns(10);
        GridBagConstraints gbc_prezimeJTextField = new GridBagConstraints();
        gbc_prezimeJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_prezimeJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_prezimeJTextField.gridx = 1;
        gbc_prezimeJTextField.gridy = 1;
        podaciOKorisnikuJPanel.add(prezimeJTextField, gbc_prezimeJTextField);

        korisnickoImeJLabel = new JLabel("Korisni\u010Dko ime:");
        korisnickoImeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_korisnickoImeJLabel = new GridBagConstraints();
        gbc_korisnickoImeJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_korisnickoImeJLabel.anchor = GridBagConstraints.EAST;
        gbc_korisnickoImeJLabel.gridx = 0;
        gbc_korisnickoImeJLabel.gridy = 2;
        podaciOKorisnikuJPanel.add(korisnickoImeJLabel, gbc_korisnickoImeJLabel);

        korisnickoImeJTextField = new JTextField();
        korisnickoImeJTextField.setColumns(10);
        GridBagConstraints gbc_korisnickoImeJTextField = new GridBagConstraints();
        gbc_korisnickoImeJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_korisnickoImeJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_korisnickoImeJTextField.gridx = 1;
        gbc_korisnickoImeJTextField.gridy = 2;
        podaciOKorisnikuJPanel.add(korisnickoImeJTextField, gbc_korisnickoImeJTextField);

        lozinkaJLabel = new JLabel("Lozinka:");
        lozinkaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lozinkaJLabel = new GridBagConstraints();
        gbc_lozinkaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lozinkaJLabel.anchor = GridBagConstraints.EAST;
        gbc_lozinkaJLabel.gridx = 0;
        gbc_lozinkaJLabel.gridy = 3;
        podaciOKorisnikuJPanel.add(lozinkaJLabel, gbc_lozinkaJLabel);

        lozinkaJTextField = new JTextField();
        lozinkaJTextField.setColumns(10);
        GridBagConstraints gbc_lozinkaJTextField = new GridBagConstraints();
        gbc_lozinkaJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_lozinkaJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_lozinkaJTextField.gridx = 1;
        gbc_lozinkaJTextField.gridy = 3;
        podaciOKorisnikuJPanel.add(lozinkaJTextField, gbc_lozinkaJTextField);

        emailJLabel = new JLabel("E-mail:");
        GridBagConstraints gbc_emailJLabel = new GridBagConstraints();
        gbc_emailJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_emailJLabel.anchor = GridBagConstraints.EAST;
        gbc_emailJLabel.gridx = 0;
        gbc_emailJLabel.gridy = 4;
        podaciOKorisnikuJPanel.add(emailJLabel, gbc_emailJLabel);

        emailJTextField = new JTextField();
        GridBagConstraints gbc_emailJTextField = new GridBagConstraints();
        gbc_emailJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_emailJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_emailJTextField.gridx = 1;
        gbc_emailJTextField.gridy = 4;
        podaciOKorisnikuJPanel.add(emailJTextField, gbc_emailJTextField);
        emailJTextField.setColumns(10);

        telefonJLabel = new JLabel("Telefon:");
        GridBagConstraints gbc_telefonJLabel = new GridBagConstraints();
        gbc_telefonJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_telefonJLabel.anchor = GridBagConstraints.EAST;
        gbc_telefonJLabel.gridx = 0;
        gbc_telefonJLabel.gridy = 5;
        podaciOKorisnikuJPanel.add(telefonJLabel, gbc_telefonJLabel);

        telefonJTextField = new JTextField();
        GridBagConstraints gbc_telefonJTextField = new GridBagConstraints();
        gbc_telefonJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_telefonJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_telefonJTextField.gridx = 1;
        gbc_telefonJTextField.gridy = 5;
        podaciOKorisnikuJPanel.add(telefonJTextField, gbc_telefonJTextField);
        telefonJTextField.setColumns(10);

        mobitelJLabel = new JLabel("Mobitel:");
        GridBagConstraints gbc_lblMobitel = new GridBagConstraints();
        gbc_lblMobitel.insets = new Insets(0, 0, 5, 5);
        gbc_lblMobitel.anchor = GridBagConstraints.EAST;
        gbc_lblMobitel.gridx = 0;
        gbc_lblMobitel.gridy = 6;
        podaciOKorisnikuJPanel.add(mobitelJLabel, gbc_lblMobitel);

        mobitelJTextField = new JTextField();
        GridBagConstraints gbc_mobitelJTextField = new GridBagConstraints();
        gbc_mobitelJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_mobitelJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_mobitelJTextField.gridx = 1;
        gbc_mobitelJTextField.gridy = 6;
        podaciOKorisnikuJPanel.add(mobitelJTextField, gbc_mobitelJTextField);
        mobitelJTextField.setColumns(10);

        adresaJLabel = new JLabel("Adresa:");
        GridBagConstraints gbc_adresaJLabel = new GridBagConstraints();
        gbc_adresaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_adresaJLabel.anchor = GridBagConstraints.EAST;
        gbc_adresaJLabel.gridx = 0;
        gbc_adresaJLabel.gridy = 7;
        podaciOKorisnikuJPanel.add(adresaJLabel, gbc_adresaJLabel);

        adresaJTextField = new JTextField();
        GridBagConstraints gbc_adresaJTextField = new GridBagConstraints();
        gbc_adresaJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_adresaJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_adresaJTextField.gridx = 1;
        gbc_adresaJTextField.gridy = 7;
        podaciOKorisnikuJPanel.add(adresaJTextField, gbc_adresaJTextField);
        adresaJTextField.setColumns(10);

        datumRodjenjaJLabel = new JLabel("Datum roÄ‘enja:");
        GridBagConstraints gbc_datumRodjenjaJLabel = new GridBagConstraints();
        gbc_datumRodjenjaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_datumRodjenjaJLabel.gridx = 0;
        gbc_datumRodjenjaJLabel.gridy = 8;
        podaciOKorisnikuJPanel.add(datumRodjenjaJLabel, gbc_datumRodjenjaJLabel);

        JPanel datumRodjenjaJPanel = new JPanel();
        GridBagConstraints gbc_datumRodjenjaJPanel = new GridBagConstraints();
        gbc_datumRodjenjaJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_datumRodjenjaJPanel.fill = GridBagConstraints.BOTH;
        gbc_datumRodjenjaJPanel.gridx = 1;
        gbc_datumRodjenjaJPanel.gridy = 8;
        podaciOKorisnikuJPanel.add(datumRodjenjaJPanel, gbc_datumRodjenjaJPanel);
        GridBagLayout gbl_datumRodjenjaJPanel = new GridBagLayout();
        gbl_datumRodjenjaJPanel.columnWidths = new int[]{41, 19, 68, 45, 33, 68, 45, 33, 68, 0};
        gbl_datumRodjenjaJPanel.rowHeights = new int[]{20, 0};
        gbl_datumRodjenjaJPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_datumRodjenjaJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        datumRodjenjaJPanel.setLayout(gbl_datumRodjenjaJPanel);

        datumRodjenjaDanJLabel = new JLabel("Dan");
        GridBagConstraints gbc_datumRodjenjaDanJLabel = new GridBagConstraints();
        gbc_datumRodjenjaDanJLabel.anchor = GridBagConstraints.EAST;
        gbc_datumRodjenjaDanJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_datumRodjenjaDanJLabel.gridx = 1;
        gbc_datumRodjenjaDanJLabel.gridy = 0;
        datumRodjenjaJPanel.add(datumRodjenjaDanJLabel, gbc_datumRodjenjaDanJLabel);

        datumRodjenjaDanJComboBox = new JComboBox();
        GridBagConstraints gbc_datumRodjenjaDanJComboBox = new GridBagConstraints();
        gbc_datumRodjenjaDanJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_datumRodjenjaDanJComboBox.insets = new Insets(0, 0, 0, 5);
        gbc_datumRodjenjaDanJComboBox.gridx = 2;
        gbc_datumRodjenjaDanJComboBox.gridy = 0;
        datumRodjenjaJPanel.add(datumRodjenjaDanJComboBox, gbc_datumRodjenjaDanJComboBox);

        datumRodjenjaMjesecJLabel = new JLabel("Mjesec");
        GridBagConstraints gbc_datumRodjenjaMjesecJLabel = new GridBagConstraints();
        gbc_datumRodjenjaMjesecJLabel.anchor = GridBagConstraints.EAST;
        gbc_datumRodjenjaMjesecJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_datumRodjenjaMjesecJLabel.gridx = 4;
        gbc_datumRodjenjaMjesecJLabel.gridy = 0;
        datumRodjenjaJPanel.add(datumRodjenjaMjesecJLabel, gbc_datumRodjenjaMjesecJLabel);

        datumRodjenjaMjesecJComboBox = new JComboBox();
        GridBagConstraints gbc_datumRodjenjaMjesecJComboBox = new GridBagConstraints();
        gbc_datumRodjenjaMjesecJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_datumRodjenjaMjesecJComboBox.insets = new Insets(0, 0, 0, 5);
        gbc_datumRodjenjaMjesecJComboBox.gridx = 5;
        gbc_datumRodjenjaMjesecJComboBox.gridy = 0;
        datumRodjenjaJPanel.add(datumRodjenjaMjesecJComboBox, gbc_datumRodjenjaMjesecJComboBox);

        datumRodjenjaGodinaJLabel = new JLabel("Godina");
        GridBagConstraints gbc_datumRodjenjaGodinaJLabel = new GridBagConstraints();
        gbc_datumRodjenjaGodinaJLabel.anchor = GridBagConstraints.EAST;
        gbc_datumRodjenjaGodinaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_datumRodjenjaGodinaJLabel.gridx = 7;
        gbc_datumRodjenjaGodinaJLabel.gridy = 0;
        datumRodjenjaJPanel.add(datumRodjenjaGodinaJLabel, gbc_datumRodjenjaGodinaJLabel);

        datumRodjenjaGodinaJComboBox = new JComboBox();
        GridBagConstraints gbc_datumRodjenjaGodinaJComboBox = new GridBagConstraints();
        gbc_datumRodjenjaGodinaJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_datumRodjenjaGodinaJComboBox.gridx = 8;
        gbc_datumRodjenjaGodinaJComboBox.gridy = 0;
        datumRodjenjaJPanel.add(datumRodjenjaGodinaJComboBox, gbc_datumRodjenjaGodinaJComboBox);

        statusJLabel = new JLabel("Status:");
        GridBagConstraints gbc_statusJLabel = new GridBagConstraints();
        gbc_statusJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_statusJLabel.anchor = GridBagConstraints.EAST;
        gbc_statusJLabel.gridx = 0;
        gbc_statusJLabel.gridy = 9;
        podaciOKorisnikuJPanel.add(statusJLabel, gbc_statusJLabel);

        statusJComboBox = new JComboBox();
        GridBagConstraints gbc_statusJComboBox = new GridBagConstraints();
        gbc_statusJComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_statusJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_statusJComboBox.gridx = 1;
        gbc_statusJComboBox.gridy = 9;
        podaciOKorisnikuJPanel.add(statusJComboBox, gbc_statusJComboBox);

        privilegijeJLabel = new JLabel("Privilegije:");
        privilegijeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_privilegijeJLabel = new GridBagConstraints();
        gbc_privilegijeJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_privilegijeJLabel.anchor = GridBagConstraints.EAST;
        gbc_privilegijeJLabel.gridx = 0;
        gbc_privilegijeJLabel.gridy = 10;
        podaciOKorisnikuJPanel.add(privilegijeJLabel, gbc_privilegijeJLabel);

        privilegijeJComboBox = new JComboBox();
        GridBagConstraints gbc_privilegijeJComboBox = new GridBagConstraints();
        gbc_privilegijeJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_privilegijeJComboBox.gridx = 1;
        gbc_privilegijeJComboBox.gridy = 10;
        podaciOKorisnikuJPanel.add(privilegijeJComboBox, gbc_privilegijeJComboBox);

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

        obrisiJButton = new JButton("Obri\u0161i");
        GridBagConstraints gbc_obrisiJButton = new GridBagConstraints();
        gbc_obrisiJButton.anchor = GridBagConstraints.SOUTH;
        gbc_obrisiJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_obrisiJButton.insets = new Insets(0, 0, 5, 5);
        gbc_obrisiJButton.gridx = 0;
        gbc_obrisiJButton.gridy = 0;
        dugmadJPanel.add(obrisiJButton, gbc_obrisiJButton);

        azurirajJButton = new JButton("A\u017Euriraj");
        GridBagConstraints gbc_azurirajJButton = new GridBagConstraints();
        gbc_azurirajJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_azurirajJButton.insets = new Insets(0, 0, 5, 0);
        gbc_azurirajJButton.gridx = 1;
        gbc_azurirajJButton.gridy = 0;
        dugmadJPanel.add(azurirajJButton, gbc_azurirajJButton);

        dodajJButton = new JButton("Dodaj");
        GridBagConstraints gbc_dodajJButton = new GridBagConstraints();
        gbc_dodajJButton.gridwidth = 2;
        gbc_dodajJButton.anchor = GridBagConstraints.SOUTH;
        gbc_dodajJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_dodajJButton.gridx = 0;
        gbc_dodajJButton.gridy = 1;
        dugmadJPanel.add(dodajJButton, gbc_dodajJButton);

        dodajListeners();

    }

    public JComboBox getTraziJComboBox() {
        return traziJComboBox;
    }

    public JTextField getImeJTextField() {
        return imeJTextField;
    }

    public JTextField getPrezimeJTextField() {
        return prezimeJTextField;
    }

    public JTextField getKorisnickoImeJTextField() {
        return korisnickoImeJTextField;
    }

    public JTextField getLozinkaJTextField() {
        return lozinkaJTextField;
    }

    public JComboBox getPrivilegijeJComboBox() {
        return privilegijeJComboBox;
    }

    public JButton getObrisiJButton() {
        return obrisiJButton;
    }

    public JButton getDodajJButton() {
        return dodajJButton;
    }

    public JTextField getEmailJTextField() {
        return emailJTextField;
    }

    public JTextField getTelefonJTextField() {
        return telefonJTextField;
    }

    public JTextField getMobitelJTextField() {
        return mobitelJTextField;
    }

    public JTextField getAdresaJTextField() {
        return adresaJTextField;
    }

    public JLabel getLozinkaJLabel() {
        return lozinkaJLabel;
    }

    public JLabel getKorisnickoImeJLabel() {
        return korisnickoImeJLabel;
    }

    public JLabel getEmailJLabel() {
        return emailJLabel;
    }

    public JLabel getTelefonJLabel() {
        return telefonJLabel;
    }

    public JLabel getDatumRodjenjaJLabel() {
        return datumRodjenjaJLabel;
    }

    public JLabel getMobitelJLabel() {
        return mobitelJLabel;
    }

    public JLabel getAdresaJLabel() {
        return adresaJLabel;
    }

    public JComboBox getDatumRodjenjaGodinaJComboBox() {
        return datumRodjenjaGodinaJComboBox;
    }

    public JComboBox getDatumRodjenjaMjesecJComboBox() {
        return datumRodjenjaMjesecJComboBox;
    }

    public JComboBox getDatumRodjenjaDanJComboBox() {
        return datumRodjenjaDanJComboBox;
    }

    public JLabel getDatumRodjenjaMjesecJLabel() {
        return datumRodjenjaMjesecJLabel;
    }

    public JLabel getDatumRodjenjaGodinaJLabel() {
        return datumRodjenjaGodinaJLabel;
    }

    public JLabel getDatumRodjenjaDanJLabel() {
        return datumRodjenjaDanJLabel;
    }

    public JLabel getStatusJLabel() {
        return statusJLabel;
    }

    public JComboBox getStatusJComboBox() {
        return statusJComboBox;
    }

    public JLabel getPrivilegijeJLabel() {
        return privilegijeJLabel;
    }

    public JButton getAzurirajJButton() {
        return azurirajJButton;
    }

    public void setAzurirajJButton(JButton azurirajJButton) {
        this.azurirajJButton = azurirajJButton;
    }

    public void dodajListeners() {
        RacunovodstvoKorisnickiRacuniController racunovodstvoKorisnickiRacuniController = new RacunovodstvoKorisnickiRacuniController(this);

        getTraziJComboBox().addItemListener(racunovodstvoKorisnickiRacuniController.getKorisnickiRacuniTraziJComboBoxItemListener());
        /*getPrivilegijeJComboBox().addActionListener(racunovodstvoKorisnickiRacuniController.getKorisnickiRacuniPrivilegijeJComboBoxActionListener());*/
        getObrisiJButton().addActionListener(racunovodstvoKorisnickiRacuniController.getKorisnickiRacuniObrisiJButtonActionListener());
        getDodajJButton().addActionListener(racunovodstvoKorisnickiRacuniController.getKorisnickiRacuniDodajJButtonActionListener());
        getAzurirajJButton().addActionListener(racunovodstvoKorisnickiRacuniController.getKorisnickiRacuniPrepraviJButtonActionListener());
    }

    public void popuniSaPodacima(List<Korisnik> sviKorisnici, long idSelektovanogKorisnika) {
        // TODO: Vjerovatno bi se još malo moglo refaktorisati ...
        if (sviKorisnici == null || sviKorisnici.size() <= 0) {
            ocistiPanel();
            return;
        }

        Korisnik selektovaniKorisnik = pupuniTraziJComboBoxSa(sviKorisnici, idSelektovanogKorisnika);

        imeJTextField.setText(selektovaniKorisnik.getIme());
        prezimeJTextField.setText(selektovaniKorisnik.getPrezime());
        korisnickoImeJTextField.setText(selektovaniKorisnik.getKorisnickoIme());
        lozinkaJTextField.setText(selektovaniKorisnik.getLozinka());
        adresaJTextField.setText(selektovaniKorisnik.getAdresa());
        emailJTextField.setText(selektovaniKorisnik.getEmail());
        telefonJTextField.setText(selektovaniKorisnik.getBrojTelefona());
        mobitelJTextField.setText(selektovaniKorisnik.getBrojMobitela());

        Date datumRodjenjaKorisnika = selektovaniKorisnik.getDatumRodjenja();
        GuiUtilities.postaviDatumUComboBoxove(datumRodjenjaKorisnika.getDay(), datumRodjenjaKorisnika.getMonth()+1, datumRodjenjaKorisnika.getYear(),
                datumRodjenjaDanJComboBox, datumRodjenjaMjesecJComboBox, datumRodjenjaGodinaJComboBox);

        Baza baza = Baza.getBaza();
        List<Status> sviStatusiKorisnika = baza.dajSve(Status.class);
        List<JComboBoxItem> sviStatusiKorisnikaJComboBoxItemi = napraviJComboBoxItemoveOdListeStatus(sviStatusiKorisnika);
        GuiUtilities.popuniJComboBoxListom(sviStatusiKorisnikaJComboBoxItemi, statusJComboBox);
        GuiUtilities.selektirajStavkuComboBoxaKojaImaId(selektovaniKorisnik.getStatus().getId(), statusJComboBox);

        List<Tip> sviTipoviKorisnika = baza.dajSve(Tip.class);
        List<JComboBoxItem> sviTipoviKorisnikaJComboBoxItemi = napraviJComboBoxItemoveOdListeTipova(sviTipoviKorisnika);
        GuiUtilities.popuniJComboBoxListom(sviTipoviKorisnikaJComboBoxItemi, privilegijeJComboBox);
        GuiUtilities.selektirajStavkuComboBoxaKojaImaId(selektovaniKorisnik.getTip().getId(), privilegijeJComboBox);
    }

    private Korisnik pupuniTraziJComboBoxSa(List<Korisnik> sviKorisnici, long idSelektovanogKorisnika) {
        Korisnik selektovaniKorisnik = null;
        JComboBox comboBoxKorisnici = getTraziJComboBox();
        // Izbjegavanje okidanja eventa SELECTED prilikom dinamickog dodavanja itemova
        ItemListener[] itemListeners = comboBoxKorisnici.getItemListeners();
        for (int i = 0; i < itemListeners.length; i++) {
            comboBoxKorisnici.removeItemListener(itemListeners[i]);
        }

        int indexSelektovanogKorisnikaUJComboBox = 0;
        int index = 0;
        comboBoxKorisnici.removeAllItems();
        for (Korisnik k : sviKorisnici) {
            comboBoxKorisnici.addItem(new JComboBoxItem(k.getId(), k.getIme() + " " + k.getPrezime()));
            if (k.getId() == idSelektovanogKorisnika) {
                selektovaniKorisnik = k;
                indexSelektovanogKorisnikaUJComboBox = index;
            }
            index++;
        }

        if (selektovaniKorisnik == null) {
            throw new NePostojiUBaziStavkaSaDatomIdVrijednosti("Pokusavate popuniti formu za " +
                    "upravljanje korisnickim racunima. Id koji ste proslijedili ne postoji u bazi. " +
                    "Taj id je: " + idSelektovanogKorisnika);
        }

        comboBoxKorisnici.setSelectedIndex(indexSelektovanogKorisnikaUJComboBox);

        // Vracanje EventListener-a na JComboBox
        for (int i = 0; i < itemListeners.length; i++) {
            comboBoxKorisnici.addItemListener(itemListeners[i]);
        }
        return selektovaniKorisnik;
    }

    private List<JComboBoxItem> napraviJComboBoxItemoveOdListeTipova(List<Tip> sviTipoviKorisnika) {
        List<JComboBoxItem> sviTipoviKorisnikaJComboBoxItemi = new ArrayList<JComboBoxItem>();
        for (Tip tip : sviTipoviKorisnika) {
            sviTipoviKorisnikaJComboBoxItemi.add(new JComboBoxItem(tip.getId(), tip.getTip()));
        }
        return sviTipoviKorisnikaJComboBoxItemi;
    }

    private List<JComboBoxItem> napraviJComboBoxItemoveOdListeStatus(List<Status> sviStatusiKorisnika) {
        List<JComboBoxItem> sviTipoviKorisnikaJComboBoxItemi = new ArrayList<JComboBoxItem>();
        for (Status status : sviStatusiKorisnika) {
            sviTipoviKorisnikaJComboBoxItemi.add(new JComboBoxItem(status.getId(), status.getStatus()));
        }
        return sviTipoviKorisnikaJComboBoxItemi;
    }

    private void ocistiPanel() {
        traziJComboBox.removeAllItems();
        imeJTextField.setText("");
        prezimeJTextField.setText("");
        korisnickoImeJTextField.setText("");
        lozinkaJTextField.setText("");
        emailJTextField.setText("");
        telefonJTextField.setText("");
        mobitelJTextField.setText("");
        adresaJTextField.setText("");
        datumRodjenjaDanJComboBox.removeAllItems();
        datumRodjenjaMjesecJComboBox.removeAllItems();
        datumRodjenjaGodinaJComboBox.removeAllItems();
        statusJComboBox.removeAllItems();
        privilegijeJComboBox.removeAllItems();
    }

    public Korisnik dajPodatkeONovomKorisniku() {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(getImeJTextField().getText());
        korisnik.setPrezime(getPrezimeJTextField().getText());
        korisnik.setKorisnickoIme(getKorisnickoImeJTextField().getText());
        korisnik.setLozinka(getLozinkaJTextField().getText());
        korisnik.setEmail(getEmailJTextField().getText());
        korisnik.setBrojTelefona(telefonJTextField.getText());
        korisnik.setBrojMobitela(mobitelJTextField.getText());
        korisnik.setAdresa(adresaJTextField.getText());
        Date date = new Date(Integer.parseInt(datumRodjenjaGodinaJComboBox.getSelectedItem().toString()),
                Integer.parseInt(datumRodjenjaMjesecJComboBox.getSelectedItem().toString()),
                Integer.parseInt(datumRodjenjaDanJComboBox.getSelectedItem().toString()));
        korisnik.setDatumRodjenja(date);
        Baza baza = Baza.getBaza();
        Status status = baza.dajPoId(Status.class, ((JComboBoxItem) statusJComboBox.getSelectedItem()).getId());
        korisnik.setStatus(status);
        Tip tip = baza.dajPoId(Tip.class, ((JComboBoxItem) privilegijeJComboBox.getSelectedItem()).getId());
        korisnik.setTip(tip);
        return korisnik;
    }

    public void popuniSaSvimPodacimaIzBaze() {
        Baza baza = Baza.getBaza();
        java.util.List<Korisnik> sviKorisnici = baza.dajSve(Korisnik.class);
        java.util.List<Korisnik> obrisaniKorisnici = new ArrayList<Korisnik>();
        for(Korisnik k : sviKorisnici) {
            if(k.isObrisano()) {
                obrisaniKorisnici.add(k);
            }
        }
        sviKorisnici.removeAll(obrisaniKorisnici);
        long idSelektiranogKorisnika = 0;
        if (sviKorisnici.size() > 0) {
            idSelektiranogKorisnika = sviKorisnici.get(0).getId();
        }
        popuniSaPodacima(sviKorisnici, idSelektiranogKorisnika);
    }
}
