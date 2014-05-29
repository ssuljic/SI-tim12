package bakersoft.bakersoft_prototype.gui.racunovodstvo;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bakersoft.bakersoft_prototype.controllers.RacunovodstvoController;

public class RacunovodstvoJFrame extends JFrame {
	
	private JFrame pozivaocJFrame;

	private JPanel contentPane;
	private RacunovodstvoIzbornikJPanel racunovodstvoIzbornikJPanel;
	private RacunovodstvoKorisnickiRacuniJPanel racunovodstvoKorisnickiRacuniJPanel;
	private RacunovodstvoKlijentiJPanel racunovodstvoKlijentiJPanel;
	private RacunovodstvoObracunavanjeJPanel racunovodstvoObracunavanjeJPanel;
	private RacunovodstvoSpaseniObracuniJPanel racunovodstvoSpaseniObracuniJPanel;
	private RacunovodstvoEvidencijaPecivaJPanel racunovodstvoEvidencijaPecivaJPanel;

	/**
	 * Create the frame.
	 */
	public RacunovodstvoJFrame(JFrame pozivaocJFrame) {
		this.pozivaocJFrame = pozivaocJFrame;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		contentPane.setLayout(borderLayout);
		setContentPane(contentPane);
		
		racunovodstvoIzbornikJPanel = new RacunovodstvoIzbornikJPanel();
		racunovodstvoKorisnickiRacuniJPanel = new RacunovodstvoKorisnickiRacuniJPanel();
		racunovodstvoKlijentiJPanel = new RacunovodstvoKlijentiJPanel();
		racunovodstvoObracunavanjeJPanel = new RacunovodstvoObracunavanjeJPanel();
		racunovodstvoSpaseniObracuniJPanel = new RacunovodstvoSpaseniObracuniJPanel();
		racunovodstvoEvidencijaPecivaJPanel = new RacunovodstvoEvidencijaPecivaJPanel();
		
		dodajIzbornik();
		postaviKorisnickiRacuniJPanel();
		
		dodajListeners();
	}
	
	public void dodajIzbornik() {
		contentPane.add(racunovodstvoIzbornikJPanel, BorderLayout.WEST);
	}
	
	public void postaviKorisnickiRacuniJPanel() {
		contentPane.remove(racunovodstvoKlijentiJPanel);
		contentPane.remove(racunovodstvoObracunavanjeJPanel);
		contentPane.remove(racunovodstvoSpaseniObracuniJPanel);
		contentPane.remove(racunovodstvoEvidencijaPecivaJPanel);
		contentPane.add(racunovodstvoKorisnickiRacuniJPanel, BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}
	
	public void postaviKlijentiJPanel() {
		contentPane.remove(racunovodstvoKorisnickiRacuniJPanel);
		contentPane.remove(racunovodstvoObracunavanjeJPanel);
		contentPane.remove(racunovodstvoSpaseniObracuniJPanel);
		contentPane.remove(racunovodstvoEvidencijaPecivaJPanel);
		contentPane.add(racunovodstvoKlijentiJPanel, BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}
	
	public void postaviObracunavanjeJPanel() {
		contentPane.remove(racunovodstvoKorisnickiRacuniJPanel);
		contentPane.remove(racunovodstvoKlijentiJPanel);
		contentPane.remove(racunovodstvoSpaseniObracuniJPanel);
		contentPane.remove(racunovodstvoEvidencijaPecivaJPanel);
		contentPane.add(racunovodstvoObracunavanjeJPanel, BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}
	
	public void postaviSpaseniObracuniJPanel() {
		contentPane.remove(racunovodstvoKorisnickiRacuniJPanel);
		contentPane.remove(racunovodstvoKlijentiJPanel);
		contentPane.remove(racunovodstvoObracunavanjeJPanel);
		contentPane.remove(racunovodstvoEvidencijaPecivaJPanel);
		contentPane.add(racunovodstvoSpaseniObracuniJPanel, BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}
	
	public void postaviEvidencijaPecivaJPanel() {
		contentPane.remove(racunovodstvoKorisnickiRacuniJPanel);
		contentPane.remove(racunovodstvoKlijentiJPanel);
		contentPane.remove(racunovodstvoObracunavanjeJPanel);
		contentPane.remove(racunovodstvoSpaseniObracuniJPanel);
		contentPane.add(racunovodstvoEvidencijaPecivaJPanel, BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}

	public void dodajListeners() {
		RacunovodstvoController racunovodstvoController = new RacunovodstvoController(this);
		
		this.addWindowListener(racunovodstvoController.getZatvorenJFrameActionListener());
		
		racunovodstvoIzbornikJPanel.getKorisnickiRacuniJButton().addActionListener(racunovodstvoController.getIzbornikKorisnickiRacuniJButtonActionListener());
		racunovodstvoIzbornikJPanel.getKlijentiJButton().addActionListener(racunovodstvoController.getIzbornikKlijentiJButtonActionListener());
		racunovodstvoIzbornikJPanel.getObracunavanjeJButton().addActionListener(racunovodstvoController.getIzbornikObracunavanjeJButtonActionListener());
		racunovodstvoIzbornikJPanel.getSpaseniObracuniJButton().addActionListener(racunovodstvoController.getIzbornikSpaseniObracuniJButtonActionListener());
		racunovodstvoIzbornikJPanel.getEvidencijaPecivaJButton().addActionListener(racunovodstvoController.getIzbornikEvidencijaPecivaJButtonActionListener());
		racunovodstvoIzbornikJPanel.getOdjavaJButton().addActionListener(racunovodstvoController.getIzbornikOdjavaJButtonActionListener());
		
		racunovodstvoEvidencijaPecivaJPanel.getUkloniPecivoJButton().addActionListener(racunovodstvoController.getEvidencijaPecivaUkloniPecivoJButtonActionListener());
		racunovodstvoEvidencijaPecivaJPanel.getDodajPecivoJButton().addActionListener(racunovodstvoController.getEvidencijaPecivaDodajPecivoJButtonActionListener());
		
		racunovodstvoKlijentiJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getKlijentiObrisiJButtonActionListener());
		racunovodstvoKlijentiJPanel.getDodajJButton().addActionListener(racunovodstvoController.getKlijentiDodajJButtonActionListener());
		
		racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().addActionListener(racunovodstvoController.getKorisnickiRacuniTraziJComboBoxActionListener());
		racunovodstvoKorisnickiRacuniJPanel.getPrivilegijeJComboBox().addActionListener(racunovodstvoController.getKorisnickiRacuniPrivilegijeJComboBoxActionListener());
		racunovodstvoKorisnickiRacuniJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getKorisnickiRacuniObrisiJButtonActionListener());
		racunovodstvoKorisnickiRacuniJPanel.getDodajJButton().addActionListener(racunovodstvoController.getKorisnickiRacuniObrisiJButtonActionListener());
		
		racunovodstvoObracunavanjeJPanel.getObracunZaJComboBox().addActionListener(racunovodstvoController.getObracunavanjeObracunZaJComboBoxActionListener());
		racunovodstvoObracunavanjeJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getObracunavanjeObrisiJButtonActionListener());
		racunovodstvoObracunavanjeJPanel.getDodajJButton().addActionListener(racunovodstvoController.getObracunavanjeDodajJButtonActionListener());
		
		racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().addActionListener(racunovodstvoController.getSpaseniObracuniObracunZaJComboBoxActionListener());
		racunovodstvoSpaseniObracuniJPanel.getObrisiObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniObracunZaJComboBoxActionListener());
		racunovodstvoSpaseniObracuniJPanel.getNapraviNoviObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniNapraviNoviObracunJButtonActionListener());
		racunovodstvoSpaseniObracuniJPanel.getPosaljiObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniPosaljiObracunJButtonActionListener());
	}
	
	public JFrame getPozivaocJFrame() {
		return pozivaocJFrame;
	}
	
}
