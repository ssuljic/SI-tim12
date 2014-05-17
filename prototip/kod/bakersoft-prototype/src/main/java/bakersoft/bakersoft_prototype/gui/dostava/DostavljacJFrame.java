package bakersoft.bakersoft_prototype.gui.dostava;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bakersoft.bakersoft_prototype.controllers.DostavljacController;

public class DostavljacJFrame extends JFrame {
	
	private JFrame pozivaocJFrame;

	private JPanel contentPane;
	private DostavljacPreuzimanjePecivaJPanel dostavljacPreuzimanjePecivaJPanel;
	private DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel;
	private DostavljacIzbornikJPanel dostavljacIzbornikJPanel;
	
	/**
	 * Create the frame.
	 */
	public DostavljacJFrame(JFrame pozivaocJFrame) {
		this.pozivaocJFrame = pozivaocJFrame;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		contentPane.setLayout(borderLayout);
		setContentPane(contentPane);
		
		dostavljacPreuzimanjePecivaJPanel = new DostavljacPreuzimanjePecivaJPanel();
		dostavljacPotvrdaDostaveJPanel = new DostavljacPotvrdaDostaveJPanel();
		dostavljacIzbornikJPanel = new DostavljacIzbornikJPanel();
		
		dodajIzbornik();
		postaviPreuzimanjePecivaJPanel();
		dodajListeners();
	}

	public void dodajIzbornik() {
		contentPane.add(dostavljacIzbornikJPanel, BorderLayout.WEST);
	}
	
	public void postaviPreuzimanjePecivaJPanel() {
		contentPane.remove(dostavljacPotvrdaDostaveJPanel);
		contentPane.add(dostavljacPreuzimanjePecivaJPanel, BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}
	
	public void postaviPotvrdaDostaveJPanel() {
		contentPane.remove(dostavljacPreuzimanjePecivaJPanel);
		contentPane.add(dostavljacPotvrdaDostaveJPanel, BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}
	
	public void dodajListeners() {
		DostavljacController dostavljacController = new DostavljacController(this);
		
		this.addWindowListener(dostavljacController.getZatvorenJFrameActionListener());
		
		dostavljacIzbornikJPanel.getPreuzimanjePecivaJButton().addActionListener(dostavljacController.getIzbornikPreuzimanjePecivaJButtonActionListener());
		dostavljacIzbornikJPanel.getPotvrdaDostaveJButton().addActionListener(dostavljacController.getIzbornikPotvrdaDostaveJButtonActionListener());
		dostavljacIzbornikJPanel.getOdjavaJButton().addActionListener(dostavljacController.getIzbornikOdjavaJButtonActionListener());
		
		dostavljacPotvrdaDostaveJPanel.getDostavaIzvrsenaJButton().addActionListener(dostavljacController.getPotvrdaDostaveDostavaIzvrsenaJButtonActionListener());
		
		dostavljacPreuzimanjePecivaJPanel.getUkloniPecivoJButton().addActionListener(dostavljacController.getPreuzimanjePecivaUkloniPecivoJButtonActionListener());
		dostavljacPreuzimanjePecivaJPanel.getDodajPecivoJButton().addActionListener(dostavljacController.getPreuzimanjePecivaDodajPecivoJButtonActionListener());
		dostavljacPreuzimanjePecivaJPanel.getPreuzmiDostavuJButton().addActionListener(dostavljacController.getPreuzimanjePecivaPreuzmiDostavuJButtonActionListener());
	}

	public JFrame getPozivaocJFrame() {
		return pozivaocJFrame;
	}
	
}