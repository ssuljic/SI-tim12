package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RacunovodstvoKlijentiJPanel extends JPanel {
    private JTextField nazivFirmeJTextField;
    private JTextField adresaJTextField;
    private JTextField kontaktPodaciImeJTextField;
    private JTextField kontaktPodaciPrezimeJTextField;
    private JTextField kontaktPodaciTelefonJTextField;
    private JTextField kontaktPodaciEmailJTextField;
    private JComboBox traziJComboBox;
    private JButton obrisiJButton;
    private JButton dodajJButton;

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

        JLabel adresaJLabel = new JLabel("Adresa:");
        adresaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_adresaJLabel = new GridBagConstraints();
        gbc_adresaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_adresaJLabel.anchor = GridBagConstraints.EAST;
        gbc_adresaJLabel.gridx = 0;
        gbc_adresaJLabel.gridy = 1;
        podaciOFirmiJPanel.add(adresaJLabel, gbc_adresaJLabel);

        adresaJTextField = new JTextField();
        adresaJTextField.setColumns(10);
        GridBagConstraints gbc_adresaJTextField = new GridBagConstraints();
        gbc_adresaJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_adresaJTextField.gridx = 1;
        gbc_adresaJTextField.gridy = 1;
        podaciOFirmiJPanel.add(adresaJTextField, gbc_adresaJTextField);

        JPanel kontaktPodaciJPanel = new JPanel();
        kontaktPodaciJPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Kontakt podaci:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_kontaktPodaciJPanel = new GridBagConstraints();
        gbc_kontaktPodaciJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_kontaktPodaciJPanel.fill = GridBagConstraints.BOTH;
        gbc_kontaktPodaciJPanel.gridx = 0;
        gbc_kontaktPodaciJPanel.gridy = 2;
        add(kontaktPodaciJPanel, gbc_kontaktPodaciJPanel);
        GridBagLayout gbl_kontaktPodaciJPanel = new GridBagLayout();
        gbl_kontaktPodaciJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_kontaktPodaciJPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_kontaktPodaciJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_kontaktPodaciJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        kontaktPodaciJPanel.setLayout(gbl_kontaktPodaciJPanel);

        JLabel kontaktPodaciImeJLabel = new JLabel("Ime:");
        kontaktPodaciImeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_kontaktPodaciImeJLabel = new GridBagConstraints();
        gbc_kontaktPodaciImeJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_kontaktPodaciImeJLabel.anchor = GridBagConstraints.EAST;
        gbc_kontaktPodaciImeJLabel.gridx = 0;
        gbc_kontaktPodaciImeJLabel.gridy = 0;
        kontaktPodaciJPanel.add(kontaktPodaciImeJLabel, gbc_kontaktPodaciImeJLabel);

        kontaktPodaciImeJTextField = new JTextField();
        GridBagConstraints gbc_kontaktPodaciImeJTextField = new GridBagConstraints();
        gbc_kontaktPodaciImeJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_kontaktPodaciImeJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_kontaktPodaciImeJTextField.gridx = 1;
        gbc_kontaktPodaciImeJTextField.gridy = 0;
        kontaktPodaciJPanel.add(kontaktPodaciImeJTextField, gbc_kontaktPodaciImeJTextField);
        kontaktPodaciImeJTextField.setColumns(10);

        JLabel kotaktPodaciPrezimeJLabel = new JLabel("Prezime:");
        kotaktPodaciPrezimeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_kotaktPodaciPrezimeJLabel = new GridBagConstraints();
        gbc_kotaktPodaciPrezimeJLabel.anchor = GridBagConstraints.EAST;
        gbc_kotaktPodaciPrezimeJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_kotaktPodaciPrezimeJLabel.gridx = 0;
        gbc_kotaktPodaciPrezimeJLabel.gridy = 1;
        kontaktPodaciJPanel.add(kotaktPodaciPrezimeJLabel, gbc_kotaktPodaciPrezimeJLabel);

        kontaktPodaciPrezimeJTextField = new JTextField();
        kontaktPodaciPrezimeJTextField.setColumns(10);
        GridBagConstraints gbc_kontaktPodaciPrezimeJTextField = new GridBagConstraints();
        gbc_kontaktPodaciPrezimeJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_kontaktPodaciPrezimeJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_kontaktPodaciPrezimeJTextField.gridx = 1;
        gbc_kontaktPodaciPrezimeJTextField.gridy = 1;
        kontaktPodaciJPanel.add(kontaktPodaciPrezimeJTextField, gbc_kontaktPodaciPrezimeJTextField);

        JLabel kontaktPodaciTelefonJLabel = new JLabel("Telefon:");
        kontaktPodaciTelefonJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_kontaktPodaciTelefonJLabel = new GridBagConstraints();
        gbc_kontaktPodaciTelefonJLabel.anchor = GridBagConstraints.EAST;
        gbc_kontaktPodaciTelefonJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_kontaktPodaciTelefonJLabel.gridx = 0;
        gbc_kontaktPodaciTelefonJLabel.gridy = 2;
        kontaktPodaciJPanel.add(kontaktPodaciTelefonJLabel, gbc_kontaktPodaciTelefonJLabel);

        kontaktPodaciTelefonJTextField = new JTextField();
        kontaktPodaciTelefonJTextField.setColumns(10);
        GridBagConstraints gbc_kontaktPodaciTelefonJTextField = new GridBagConstraints();
        gbc_kontaktPodaciTelefonJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_kontaktPodaciTelefonJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_kontaktPodaciTelefonJTextField.gridx = 1;
        gbc_kontaktPodaciTelefonJTextField.gridy = 2;
        kontaktPodaciJPanel.add(kontaktPodaciTelefonJTextField, gbc_kontaktPodaciTelefonJTextField);

        JLabel kontaktPodaciEmailJLabel = new JLabel("E-mail:");
        kontaktPodaciEmailJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_kontaktPodaciEmailJLabel = new GridBagConstraints();
        gbc_kontaktPodaciEmailJLabel.anchor = GridBagConstraints.EAST;
        gbc_kontaktPodaciEmailJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_kontaktPodaciEmailJLabel.gridx = 0;
        gbc_kontaktPodaciEmailJLabel.gridy = 3;
        kontaktPodaciJPanel.add(kontaktPodaciEmailJLabel, gbc_kontaktPodaciEmailJLabel);

        kontaktPodaciEmailJTextField = new JTextField();
        kontaktPodaciEmailJTextField.setColumns(10);
        GridBagConstraints gbc_kontaktPodaciEmailJTextField = new GridBagConstraints();
        gbc_kontaktPodaciEmailJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_kontaktPodaciEmailJTextField.gridx = 1;
        gbc_kontaktPodaciEmailJTextField.gridy = 3;
        kontaktPodaciJPanel.add(kontaktPodaciEmailJTextField, gbc_kontaktPodaciEmailJTextField);

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

    }

    public JComboBox getTraziJComboBox() {
        return traziJComboBox;
    }

    public JTextField getNazivFirmeJTextField() {
        return nazivFirmeJTextField;
    }

    public JTextField getAdresaJTextField() {
        return adresaJTextField;
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
}
