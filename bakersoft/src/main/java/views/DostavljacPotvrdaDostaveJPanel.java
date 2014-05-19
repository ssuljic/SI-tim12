package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DostavljacPotvrdaDostaveJPanel extends JPanel {
    private JTable dostaveJTable;
    private JTable podaciODostaviJTable;
    private JButton dostavaIzvrsenaJButton;

    /**
     * Create the panel.
     */
    public DostavljacPotvrdaDostaveJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Potvrda dostave:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JScrollPane dostaveJScrollPane = new JScrollPane();
        GridBagConstraints gbc_dostaveJScrollPane = new GridBagConstraints();
        gbc_dostaveJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_dostaveJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_dostaveJScrollPane.gridx = 0;
        gbc_dostaveJScrollPane.gridy = 0;
        add(dostaveJScrollPane, gbc_dostaveJScrollPane);

        dostaveJTable = new JTable();
        dostaveJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Naziv dostave"
                }
        ));
        dostaveJScrollPane.setViewportView(dostaveJTable);

        JScrollPane podaciODostaviJScrollPane = new JScrollPane();
        GridBagConstraints gbc_podaciODostaviJScrollPane = new GridBagConstraints();
        gbc_podaciODostaviJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_podaciODostaviJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_podaciODostaviJScrollPane.gridx = 0;
        gbc_podaciODostaviJScrollPane.gridy = 1;
        add(podaciODostaviJScrollPane, gbc_podaciODostaviJScrollPane);

        podaciODostaviJTable = new JTable();
        podaciODostaviJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Pecivo", "Tra\u017Eena koli\u010Dina", "Dostavljena koli\u010Dina"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, false, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        podaciODostaviJScrollPane.setViewportView(podaciODostaviJTable);

        dostavaIzvrsenaJButton = new JButton("Dostava izvr\u0161ena");
        GridBagConstraints gbc_dostavaIzvrsenaJButton = new GridBagConstraints();
        gbc_dostavaIzvrsenaJButton.fill = GridBagConstraints.BOTH;
        gbc_dostavaIzvrsenaJButton.gridx = 0;
        gbc_dostavaIzvrsenaJButton.gridy = 2;
        add(dostavaIzvrsenaJButton, gbc_dostavaIzvrsenaJButton);

    }

    public JTable getDostaveJTable() {
        return dostaveJTable;
    }

    public JTable getPodaciODostaviJTable() {
        return podaciODostaviJTable;
    }

    public JButton getDostavaIzvrsenaJButton() {
        return dostavaIzvrsenaJButton;
    }
}
