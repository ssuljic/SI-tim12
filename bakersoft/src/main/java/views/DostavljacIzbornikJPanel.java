package views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class DostavljacIzbornikJPanel extends JPanel {
    private JButton preuzimanjePecivaJButton;
    private JButton potvrdaDostaveJButton;
    private JButton odjavaJButton;

    /**
     * Create the panel.
     */
    public DostavljacIzbornikJPanel() {
        setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Izbornik:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        setLayout(new GridLayout(6, 1, 0, 0));

        preuzimanjePecivaJButton = new JButton("Preuzimanje peciva");
        add(preuzimanjePecivaJButton);

        potvrdaDostaveJButton = new JButton("Potvrda dostave");
        add(potvrdaDostaveJButton);

        JPanel odjavaJButtonPozicioner1JPanel = new JPanel();
        add(odjavaJButtonPozicioner1JPanel);
        odjavaJButtonPozicioner1JPanel.setLayout(null);

        JPanel odjavaJButtonPozicioner2JPanel = new JPanel();
        add(odjavaJButtonPozicioner2JPanel);

        JPanel odjavaJButtonPozicioner3JPanel = new JPanel();
        add(odjavaJButtonPozicioner3JPanel);

        odjavaJButton = new JButton("Odjava");
        add(odjavaJButton);

    }

    public JButton getPreuzimanjePecivaJButton() {
        return preuzimanjePecivaJButton;
    }

    public JButton getPotvrdaDostaveJButton() {
        return potvrdaDostaveJButton;
    }

    public JButton getOdjavaJButton() {
        return odjavaJButton;
    }
}
