package views;

import controllers.PrijavaController;

import javax.swing.*;
import java.awt.*;


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
