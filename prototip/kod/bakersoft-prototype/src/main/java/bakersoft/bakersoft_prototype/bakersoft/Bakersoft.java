package bakersoft.bakersoft_prototype.bakersoft;

import javax.swing.SwingUtilities;

import bakersoft.bakersoft_prototype.gui.prijava.PrijavaJFrame;

public class Bakersoft {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        PrijavaJFrame prijavaJFrame = new PrijavaJFrame();
        prijavaJFrame.setBounds(100, 100, 500, 530);
        prijavaJFrame.setVisible(true);
    }
}