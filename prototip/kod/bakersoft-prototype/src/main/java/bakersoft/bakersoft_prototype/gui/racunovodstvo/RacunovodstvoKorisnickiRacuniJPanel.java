package bakersoft.bakersoft_prototype.gui.racunovodstvo;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RacunovodstvoKorisnickiRacuniJPanel extends JPanel {
	private JTextField imeJTextField;
	private JTextField prezimeJTextField;
	private JTextField korisnickoImeJTextField;
	private JTextField lozinkaJTextField;
	private JComboBox traziJComboBox;
	private JComboBox privilegijeJComboBox;
	private JButton obrisiJButton;
	private JButton dodajJButton;

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
		traziJComboBox.setEditable(true);
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
		gbl_podaciOKorisnikuJPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_podaciOKorisnikuJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_podaciOKorisnikuJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel korisnickoImeJLabel = new JLabel("Korisni\u010Dko ime:");
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
		
		JLabel lozinkaJLabel = new JLabel("Lozinka:");
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
		
		JLabel privilegijeJLabel = new JLabel("Privilegije:");
		privilegijeJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_privilegijeJLabel = new GridBagConstraints();
		gbc_privilegijeJLabel.insets = new Insets(0, 0, 0, 5);
		gbc_privilegijeJLabel.anchor = GridBagConstraints.EAST;
		gbc_privilegijeJLabel.gridx = 0;
		gbc_privilegijeJLabel.gridy = 4;
		podaciOKorisnikuJPanel.add(privilegijeJLabel, gbc_privilegijeJLabel);
		
		privilegijeJComboBox = new JComboBox();
		GridBagConstraints gbc_privilegijeJComboBox = new GridBagConstraints();
		gbc_privilegijeJComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_privilegijeJComboBox.gridx = 1;
		gbc_privilegijeJComboBox.gridy = 4;
		podaciOKorisnikuJPanel.add(privilegijeJComboBox, gbc_privilegijeJComboBox);
		
		JPanel dugmadJPanel = new JPanel();
		GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
		gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
		gbc_dugmadJPanel.gridx = 0;
		gbc_dugmadJPanel.gridy = 2;
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
}
