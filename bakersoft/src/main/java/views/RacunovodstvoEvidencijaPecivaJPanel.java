package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RacunovodstvoEvidencijaPecivaJPanel extends JPanel {
    private JTable pregledPecivaJTable;
    private JButton ukloniPecivoJButton;
    private JButton dodajPecivoJButton;

    /**
     * Create the panel.
     */
    public RacunovodstvoEvidencijaPecivaJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Evidencija peciva:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JScrollPane pregledPecivaJScrollPane = new JScrollPane();
        GridBagConstraints gbc_pregledPecivaJScrollPane = new GridBagConstraints();
        gbc_pregledPecivaJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_pregledPecivaJScrollPane.gridwidth = 2;
        gbc_pregledPecivaJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_pregledPecivaJScrollPane.gridx = 0;
        gbc_pregledPecivaJScrollPane.gridy = 0;
        add(pregledPecivaJScrollPane, gbc_pregledPecivaJScrollPane);

        pregledPecivaJTable = new JTable();
        pregledPecivaJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Naziv", "\u0160ifra", "Cijena"
                }
        ));
        pregledPecivaJScrollPane.setViewportView(pregledPecivaJTable);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.gridwidth = 2;
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 1;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        ukloniPecivoJButton = new JButton("Ukloni pecivo");
        GridBagConstraints gbc_ukloniPecivoJButton = new GridBagConstraints();
        gbc_ukloniPecivoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_ukloniPecivoJButton.insets = new Insets(0, 0, 0, 5);
        gbc_ukloniPecivoJButton.gridx = 0;
        gbc_ukloniPecivoJButton.gridy = 0;
        dugmadJPanel.add(ukloniPecivoJButton, gbc_ukloniPecivoJButton);

        dodajPecivoJButton = new JButton("Dodaj pecivo");
        GridBagConstraints gbc_dodajPecivoJButton = new GridBagConstraints();
        gbc_dodajPecivoJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_dodajPecivoJButton.gridx = 1;
        gbc_dodajPecivoJButton.gridy = 0;
        dugmadJPanel.add(dodajPecivoJButton, gbc_dodajPecivoJButton);

    }

    public JTable getPregledPecivaJTable() {
        return pregledPecivaJTable;
    }

    public JButton getUkloniPecivoJButton() {
        return ukloniPecivoJButton;
    }

    public JButton getDodajPecivoJButton() {
        return dodajPecivoJButton;
    }
}
