package bakersoft.bakersoft_prototype.gui.prijava;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import bakersoft.bakersoft_prototype.controllers.PrijavaController;

public class PrijavaJFrame extends JFrame {
	private PrijavaJPanel prijavaJPanel;
	
	public PrijavaJFrame() {
        prijavaJPanel = new PrijavaJPanel();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(prijavaJPanel);
        this.setSize(new Dimension(800, 500));
        
        addListeners();
	}
	
	public PrijavaJPanel getPrijavaJPanel() {
		return prijavaJPanel;
	}

	public void addListeners() {
		prijavaJPanel.getPrijavaJButton().addActionListener(new PrijavaController(this));
	}
}
