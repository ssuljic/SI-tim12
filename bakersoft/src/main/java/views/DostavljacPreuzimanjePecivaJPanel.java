package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DostavljacPreuzimanjePecivaJPanel extends JPanel {
    private JTextField nazivDostaveJTextField;
    private JTable dostavaJTable;
    private JButton ukloniPecivoJButton;
    private JButton dodajPecivoJButton;
    private JButton preuzmiDostavuJButton;

    /**
     * Create the panel.
     */
    public DostavljacPreuzimanjePecivaJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Preuzimanje peciva:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 300, 76, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel nazivDostaveJLabel = new JLabel("Naziv dostave:");
        GridBagConstraints gbc_nazivDostaveJLabel = new GridBagConstraints();
        gbc_nazivDostaveJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nazivDostaveJLabel.anchor = GridBagConstraints.EAST;
        gbc_nazivDostaveJLabel.gridx = 0;
        gbc_nazivDostaveJLabel.gridy = 0;
        add(nazivDostaveJLabel, gbc_nazivDostaveJLabel);

        nazivDostaveJTextField = new JTextField();
        GridBagConstraints gbc_nazivDostaveJTextField = new GridBagConstraints();
        gbc_nazivDostaveJTextField.insets = new Insets(0, 0, 5, 0);
        gbc_nazivDostaveJTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nazivDostaveJTextField.gridx = 1;
        gbc_nazivDostaveJTextField.gridy = 0;
        add(nazivDostaveJTextField, gbc_nazivDostaveJTextField);
        nazivDostaveJTextField.setColumns(10);

        JScrollPane dostavaJScrollPane = new JScrollPane();
        GridBagConstraints gbc_dostavaJScrollPane = new GridBagConstraints();
        gbc_dostavaJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_dostavaJScrollPane.gridwidth = 2;
        gbc_dostavaJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_dostavaJScrollPane.gridx = 0;
        gbc_dostavaJScrollPane.gridy = 2;
        add(dostavaJScrollPane, gbc_dostavaJScrollPane);

        dostavaJTable = new JTable();
        dostavaJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Vrsta peciva", "Koli\u010Dina peciva"
                }
        ));
        dostavaJScrollPane.setViewportView(dostavaJTable);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.gridwidth = 2;
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 3;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        ukloniPecivoJButton = new JButton("Ukloni pecivo");
        GridBagConstraints gbc_ukloniPecivoJButton = new GridBagConstraints();
        gbc_ukloniPecivoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_ukloniPecivoJButton.insets = new Insets(0, 0, 5, 5);
        gbc_ukloniPecivoJButton.gridx = 0;
        gbc_ukloniPecivoJButton.gridy = 0;
        dugmadJPanel.add(ukloniPecivoJButton, gbc_ukloniPecivoJButton);

        dodajPecivoJButton = new JButton("Dodaj pecivo");
        GridBagConstraints gbc_dodajPecivoJButton = new GridBagConstraints();
        gbc_dodajPecivoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_dodajPecivoJButton.insets = new Insets(0, 0, 5, 0);
        gbc_dodajPecivoJButton.gridx = 1;
        gbc_dodajPecivoJButton.gridy = 0;
        dugmadJPanel.add(dodajPecivoJButton, gbc_dodajPecivoJButton);

        preuzmiDostavuJButton = new JButton("Preuzmi dostavu");
        GridBagConstraints gbc_preuzmiDostavuJButton = new GridBagConstraints();
        gbc_preuzmiDostavuJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_preuzmiDostavuJButton.gridwidth = 2;
        gbc_preuzmiDostavuJButton.insets = new Insets(0, 0, 0, 5);
        gbc_preuzmiDostavuJButton.gridx = 0;
        gbc_preuzmiDostavuJButton.gridy = 1;
        dugmadJPanel.add(preuzmiDostavuJButton, gbc_preuzmiDostavuJButton);

    }

    public JTable getDostavaJTable() {
        return dostavaJTable;
    }

    public JButton getUkloniPecivoJButton() {
        return ukloniPecivoJButton;
    }

    public JButton getDodajPecivoJButton() {
        return dodajPecivoJButton;
    }

    public JButton getPreuzmiDostavuJButton() {
        return preuzmiDostavuJButton;
    }
}
