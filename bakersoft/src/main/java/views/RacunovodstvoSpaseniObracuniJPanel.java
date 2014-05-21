package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RacunovodstvoSpaseniObracuniJPanel extends JPanel {
    private JTable dostaveJTable;
    private JTable obracuniJTable;
    private JComboBox obracunZaJComboBox;
    private JLabel brojDostavaIspisJLabel;
    private JLabel brojPovrataIspisJLabel;
    private JLabel zaradaIspisJLabel;
    private JButton obrisiObracunJButton;
    private JButton napraviNoviObracunJButton;
    private JButton posaljiObracunJButton;

    /**
     * Create the panel.
     */
    public RacunovodstvoSpaseniObracuniJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Spa\u0161eni obra\u010Duni:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JPanel obracunZaJPanel = new JPanel();
        GridBagConstraints gbc_obracunZaJPanel = new GridBagConstraints();
        gbc_obracunZaJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_obracunZaJPanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_obracunZaJPanel.gridx = 0;
        gbc_obracunZaJPanel.gridy = 0;
        add(obracunZaJPanel, gbc_obracunZaJPanel);
        GridBagLayout gbl_obracunZaJPanel = new GridBagLayout();
        gbl_obracunZaJPanel.columnWidths = new int[]{46, 392, 0};
        gbl_obracunZaJPanel.rowHeights = new int[]{141, 0};
        gbl_obracunZaJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_obracunZaJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        obracunZaJPanel.setLayout(gbl_obracunZaJPanel);

        JLabel obracunZaJLabel = new JLabel("Obra\u010Dun za:");
        obracunZaJLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        GridBagConstraints gbc_obracunZaJLabel = new GridBagConstraints();
        gbc_obracunZaJLabel.fill = GridBagConstraints.BOTH;
        gbc_obracunZaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_obracunZaJLabel.gridx = 0;
        gbc_obracunZaJLabel.gridy = 0;
        obracunZaJPanel.add(obracunZaJLabel, gbc_obracunZaJLabel);

        obracunZaJComboBox = new JComboBox();
        GridBagConstraints gbc_obracunZaJComboBox = new GridBagConstraints();
        gbc_obracunZaJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_obracunZaJComboBox.gridx = 1;
        gbc_obracunZaJComboBox.gridy = 0;
        obracunZaJPanel.add(obracunZaJComboBox, gbc_obracunZaJComboBox);

        JPanel podaciOObracunimaJPanel = new JPanel();
        podaciOObracunimaJPanel.setBorder(null);
        GridBagConstraints gbc_podaciOObracunimaJPanel = new GridBagConstraints();
        gbc_podaciOObracunimaJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_podaciOObracunimaJPanel.fill = GridBagConstraints.BOTH;
        gbc_podaciOObracunimaJPanel.gridx = 0;
        gbc_podaciOObracunimaJPanel.gridy = 1;
        add(podaciOObracunimaJPanel, gbc_podaciOObracunimaJPanel);
        GridBagLayout gbl_podaciOObracunimaJPanel = new GridBagLayout();
        gbl_podaciOObracunimaJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_podaciOObracunimaJPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_podaciOObracunimaJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_podaciOObracunimaJPanel.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        podaciOObracunimaJPanel.setLayout(gbl_podaciOObracunimaJPanel);

        JLabel obracuniJLabel = new JLabel("Obra\u010Duni:");
        obracuniJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_obracuniJLabel = new GridBagConstraints();
        gbc_obracuniJLabel.anchor = GridBagConstraints.EAST;
        gbc_obracuniJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_obracuniJLabel.gridx = 0;
        gbc_obracuniJLabel.gridy = 0;
        podaciOObracunimaJPanel.add(obracuniJLabel, gbc_obracuniJLabel);

        JScrollPane obracuniJScrollPane = new JScrollPane();
        GridBagConstraints gbc_obracuniJScrollPane = new GridBagConstraints();
        gbc_obracuniJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_obracuniJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_obracuniJScrollPane.gridx = 1;
        gbc_obracuniJScrollPane.gridy = 0;
        podaciOObracunimaJPanel.add(obracuniJScrollPane, gbc_obracuniJScrollPane);

        obracuniJTable = new JTable();
        obracuniJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Id izvje\u0161taja", "Naziv izvje\u0161taja", "Datum kreiranja izvje\u0161taja"
                }
        ));
        obracuniJScrollPane.setViewportView(obracuniJTable);

        JLabel dostaveJLabel = new JLabel("Dostave:");
        dostaveJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_dostaveJLabel = new GridBagConstraints();
        gbc_dostaveJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_dostaveJLabel.anchor = GridBagConstraints.EAST;
        gbc_dostaveJLabel.gridx = 0;
        gbc_dostaveJLabel.gridy = 1;
        podaciOObracunimaJPanel.add(dostaveJLabel, gbc_dostaveJLabel);

        JScrollPane dostaveJScrollPane = new JScrollPane();
        GridBagConstraints gbc_dostaveJScrollPane = new GridBagConstraints();
        gbc_dostaveJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_dostaveJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_dostaveJScrollPane.gridx = 1;
        gbc_dostaveJScrollPane.gridy = 1;
        podaciOObracunimaJPanel.add(dostaveJScrollPane, gbc_dostaveJScrollPane);

        dostaveJTable = new JTable();
        dostaveJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Klijent", "Vrijeme dostave", "Vrsta peciva", "Koli\u010Dina dostavljenog peciva"
                }
        ));
        dostaveJScrollPane.setViewportView(dostaveJTable);

        JLabel brojDostavaJLabel = new JLabel("Broj dostava:");
        brojDostavaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_brojDostavaJLabel = new GridBagConstraints();
        gbc_brojDostavaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_brojDostavaJLabel.anchor = GridBagConstraints.EAST;
        gbc_brojDostavaJLabel.gridx = 0;
        gbc_brojDostavaJLabel.gridy = 2;
        podaciOObracunimaJPanel.add(brojDostavaJLabel, gbc_brojDostavaJLabel);

        brojDostavaIspisJLabel = new JLabel("");
        GridBagConstraints gbc_brojDostavaIspisJLabel = new GridBagConstraints();
        gbc_brojDostavaIspisJLabel.insets = new Insets(0, 0, 5, 0);
        gbc_brojDostavaIspisJLabel.gridx = 1;
        gbc_brojDostavaIspisJLabel.gridy = 2;
        podaciOObracunimaJPanel.add(brojDostavaIspisJLabel, gbc_brojDostavaIspisJLabel);

        JLabel brojPovrataJLabel = new JLabel("Broj povrata:");
        brojPovrataJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_brojPovrataJLabel = new GridBagConstraints();
        gbc_brojPovrataJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_brojPovrataJLabel.anchor = GridBagConstraints.EAST;
        gbc_brojPovrataJLabel.gridx = 0;
        gbc_brojPovrataJLabel.gridy = 3;
        podaciOObracunimaJPanel.add(brojPovrataJLabel, gbc_brojPovrataJLabel);

        brojPovrataIspisJLabel = new JLabel("");
        GridBagConstraints gbc_brojPovrataIspisJLabel = new GridBagConstraints();
        gbc_brojPovrataIspisJLabel.insets = new Insets(0, 0, 5, 0);
        gbc_brojPovrataIspisJLabel.gridx = 1;
        gbc_brojPovrataIspisJLabel.gridy = 3;
        podaciOObracunimaJPanel.add(brojPovrataIspisJLabel, gbc_brojPovrataIspisJLabel);

        JLabel zaradaJLabel = new JLabel("Zarada:");
        zaradaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_zaradaJLabel = new GridBagConstraints();
        gbc_zaradaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_zaradaJLabel.anchor = GridBagConstraints.EAST;
        gbc_zaradaJLabel.gridx = 0;
        gbc_zaradaJLabel.gridy = 4;
        podaciOObracunimaJPanel.add(zaradaJLabel, gbc_zaradaJLabel);

        zaradaIspisJLabel = new JLabel("");
        GridBagConstraints gbc_zaradaIspisJLabel = new GridBagConstraints();
        gbc_zaradaIspisJLabel.gridx = 1;
        gbc_zaradaIspisJLabel.gridy = 4;
        podaciOObracunimaJPanel.add(zaradaIspisJLabel, gbc_zaradaIspisJLabel);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 2;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        obrisiObracunJButton = new JButton("Obri\u0161i obra\u010Dun");
        GridBagConstraints gbc_obrisiObracunJButton = new GridBagConstraints();
        gbc_obrisiObracunJButton.anchor = GridBagConstraints.SOUTH;
        gbc_obrisiObracunJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_obrisiObracunJButton.insets = new Insets(0, 0, 5, 5);
        gbc_obrisiObracunJButton.gridx = 0;
        gbc_obrisiObracunJButton.gridy = 0;
        dugmadJPanel.add(obrisiObracunJButton, gbc_obrisiObracunJButton);

        napraviNoviObracunJButton = new JButton("Napravi novi obra\u010Dun");
        GridBagConstraints gbc_napraviNoviObracunJButton = new GridBagConstraints();
        gbc_napraviNoviObracunJButton.insets = new Insets(0, 0, 5, 0);
        gbc_napraviNoviObracunJButton.anchor = GridBagConstraints.SOUTH;
        gbc_napraviNoviObracunJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_napraviNoviObracunJButton.gridx = 1;
        gbc_napraviNoviObracunJButton.gridy = 0;
        dugmadJPanel.add(napraviNoviObracunJButton, gbc_napraviNoviObracunJButton);

        posaljiObracunJButton = new JButton("Po\u0161alji obra\u010Dun");
        GridBagConstraints gbc_posaljiObracunJButton = new GridBagConstraints();
        gbc_posaljiObracunJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_posaljiObracunJButton.gridwidth = 2;
        gbc_posaljiObracunJButton.insets = new Insets(0, 0, 0, 5);
        gbc_posaljiObracunJButton.gridx = 0;
        gbc_posaljiObracunJButton.gridy = 1;
        dugmadJPanel.add(posaljiObracunJButton, gbc_posaljiObracunJButton);

    }

    public JComboBox getObracunZaJComboBox() {
        return obracunZaJComboBox;
    }

    public JTable getObracuniJTable() {
        return obracuniJTable;
    }

    public JTable getDostaveJTable() {
        return dostaveJTable;
    }

    public JLabel getBrojDostavaIspisJLabel() {
        return brojDostavaIspisJLabel;
    }

    public JLabel getBrojPovrataIspisJLabel() {
        return brojPovrataIspisJLabel;
    }

    public JLabel getZaradaIspisJLabel() {
        return zaradaIspisJLabel;
    }

    public JButton getObrisiObracunJButton() {
        return obrisiObracunJButton;
    }

    public JButton getNapraviNoviObracunJButton() {
        return napraviNoviObracunJButton;
    }

    public JButton getPosaljiObracunJButton() {
        return posaljiObracunJButton;
    }

    public void popuniSaSvimPodacimaIzBaze() {

    }
}
