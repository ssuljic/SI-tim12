package views;

import javax.swing.*;
import java.awt.*;

public class PrijavaJPanel extends JPanel {
    private JTextField korisnickoImeJTextField;
    private JButton prijavaJButton;
    private JPasswordField lozinkaJPasswordField;

    /**
     * Create the panel.
     */
    public PrijavaJPanel() {
        setLayout(new GridLayout(2, 3, 0, 0));

        JPanel naslovSadrzajniJPanel = new JPanel();
        add(naslovSadrzajniJPanel);
        naslovSadrzajniJPanel.setLayout(new BorderLayout(0, 0));

        JLabel nazivAplikacijeJLabel = new JLabel("Bakersoft");
        nazivAplikacijeJLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nazivAplikacijeJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        naslovSadrzajniJPanel.add(nazivAplikacijeJLabel, BorderLayout.CENTER);

        JPanel prijavaFormaSadrzajniJPanel = new JPanel();
        add(prijavaFormaSadrzajniJPanel);
        prijavaFormaSadrzajniJPanel.setLayout(new GridLayout(2, 3, 0, 0));

        JPanel prijavaFormaPozicionerZapadniJPanel = new JPanel();
        prijavaFormaSadrzajniJPanel.add(prijavaFormaPozicionerZapadniJPanel);

        JPanel prijavaFormaJPanel = new JPanel();
        prijavaFormaSadrzajniJPanel.add(prijavaFormaJPanel);
        prijavaFormaJPanel.setLayout(new GridLayout(6, 1, 0, 0));

        JLabel korisnickoImeJLabel = new JLabel("Korisničo ime:");
        korisnickoImeJLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        korisnickoImeJLabel.setHorizontalAlignment(SwingConstants.LEFT);
        prijavaFormaJPanel.add(korisnickoImeJLabel);

        korisnickoImeJTextField = new JTextField();
        prijavaFormaJPanel.add(korisnickoImeJTextField);
        korisnickoImeJTextField.setColumns(10);

        JLabel lozinkaJLabel = new JLabel("Lozinka:");
        lozinkaJLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lozinkaJLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        prijavaFormaJPanel.add(lozinkaJLabel);

        lozinkaJPasswordField = new JPasswordField();
        prijavaFormaJPanel.add(lozinkaJPasswordField);

        Component prijavaJButtonPozicionerVerticalStrut = Box.createVerticalStrut(20);
        prijavaFormaJPanel.add(prijavaJButtonPozicionerVerticalStrut);

        prijavaJButton = new JButton("Prijava");
        prijavaFormaJPanel.add(prijavaJButton);

        JPanel prijavaFormaPozicionerIstocniJPanel = new JPanel();
        prijavaFormaSadrzajniJPanel.add(prijavaFormaPozicionerIstocniJPanel);

        JPanel prijavaFormaPozicionerJugozapadniJPanel = new JPanel();
        prijavaFormaSadrzajniJPanel.add(prijavaFormaPozicionerJugozapadniJPanel);

        JPanel prijavaFormaPozicionerJuzniJPanel = new JPanel();
        prijavaFormaSadrzajniJPanel.add(prijavaFormaPozicionerJuzniJPanel);

        JPanel prijavaFormaPozicionerJugoistocniJPanel = new JPanel();
        prijavaFormaSadrzajniJPanel.add(prijavaFormaPozicionerJugoistocniJPanel);


    }

    public JButton getPrijavaJButton() {
        return prijavaJButton;
    }

    public JTextField getKorisnickoImeJTextField() {
        return korisnickoImeJTextField;
    }

    public JPasswordField getLozinkaJPasswordField() {
        return lozinkaJPasswordField;
    }
}
