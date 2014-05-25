package views;

import controllers.RacunovodstvoObracunavanjeController;
import entities.*;
import utilities.Baza;
import utilities.GuiUtilities;
import utilities.JComboBoxItem;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.geom.Arc2D;
import java.util.*;
import java.util.List;

public class RacunovodstvoObracunavanjeJPanel extends JPanel {
    private JTable dostaveJTable;
    private JComboBox obracunZaJComboBox;
    private JComboBox odDatumaDanJComboBox;
    private JComboBox odDatumaMjesecJComboBox;
    private JComboBox odDatumaGodinaJComboBox;
    private JComboBox doDatumaDanJComboBox;
    private JComboBox doDatumaMjesecJComboBox;
    private JComboBox doDatumaGodinaJComboBox;
    private JLabel zaradaIspisJLabel;
    private JButton napraviObracunJButton;
    private JButton filtrirajDostaveJButton;
    private JTable pecivaDostaveJTable;

    /**
     * Create the panel.
     */
    public RacunovodstvoObracunavanjeJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Obra\u010Dunavanje:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

        JPanel podaciZaObracunJPanel = new JPanel();
        podaciZaObracunJPanel.setBorder(null);
        GridBagConstraints gbc_podaciZaObracunJPanel = new GridBagConstraints();
        gbc_podaciZaObracunJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_podaciZaObracunJPanel.fill = GridBagConstraints.BOTH;
        gbc_podaciZaObracunJPanel.gridx = 0;
        gbc_podaciZaObracunJPanel.gridy = 1;
        add(podaciZaObracunJPanel, gbc_podaciZaObracunJPanel);
        GridBagLayout gbl_podaciZaObracunJPanel = new GridBagLayout();
        gbl_podaciZaObracunJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_podaciZaObracunJPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_podaciZaObracunJPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_podaciZaObracunJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
        podaciZaObracunJPanel.setLayout(gbl_podaciZaObracunJPanel);

        JLabel odDatumaJLabel = new JLabel("Od datuma:");
        odDatumaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_odDatumaJLabel = new GridBagConstraints();
        gbc_odDatumaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_odDatumaJLabel.anchor = GridBagConstraints.EAST;
        gbc_odDatumaJLabel.gridx = 0;
        gbc_odDatumaJLabel.gridy = 0;
        podaciZaObracunJPanel.add(odDatumaJLabel, gbc_odDatumaJLabel);

        JPanel odDatumaDanMjesecGodinaSadrzajniJPanel = new JPanel();
        GridBagConstraints gbc_odDatumaDanMjesecGodinaSadrzajniJPanel = new GridBagConstraints();
        gbc_odDatumaDanMjesecGodinaSadrzajniJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_odDatumaDanMjesecGodinaSadrzajniJPanel.fill = GridBagConstraints.BOTH;
        gbc_odDatumaDanMjesecGodinaSadrzajniJPanel.gridx = 1;
        gbc_odDatumaDanMjesecGodinaSadrzajniJPanel.gridy = 0;
        podaciZaObracunJPanel.add(odDatumaDanMjesecGodinaSadrzajniJPanel, gbc_odDatumaDanMjesecGodinaSadrzajniJPanel);
        GridBagLayout gbl_odDatumaDanMjesecGodinaSadrzajniJPanel = new GridBagLayout();
        gbl_odDatumaDanMjesecGodinaSadrzajniJPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_odDatumaDanMjesecGodinaSadrzajniJPanel.rowHeights = new int[]{0, 0};
        gbl_odDatumaDanMjesecGodinaSadrzajniJPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_odDatumaDanMjesecGodinaSadrzajniJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        odDatumaDanMjesecGodinaSadrzajniJPanel.setLayout(gbl_odDatumaDanMjesecGodinaSadrzajniJPanel);

        JLabel odDatumaDanJLabel = new JLabel("Dan");
        GridBagConstraints gbc_odDatumaDanJLabel = new GridBagConstraints();
        gbc_odDatumaDanJLabel.anchor = GridBagConstraints.EAST;
        gbc_odDatumaDanJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_odDatumaDanJLabel.gridx = 0;
        gbc_odDatumaDanJLabel.gridy = 0;
        odDatumaDanMjesecGodinaSadrzajniJPanel.add(odDatumaDanJLabel, gbc_odDatumaDanJLabel);

        odDatumaDanJComboBox = new JComboBox();
        odDatumaDanJComboBox.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        GridBagConstraints gbc_odDatumaDanJComboBox = new GridBagConstraints();
        gbc_odDatumaDanJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_odDatumaDanJComboBox.insets = new Insets(0, 0, 0, 5);
        gbc_odDatumaDanJComboBox.gridx = 1;
        gbc_odDatumaDanJComboBox.gridy = 0;
        odDatumaDanMjesecGodinaSadrzajniJPanel.add(odDatumaDanJComboBox, gbc_odDatumaDanJComboBox);

        JLabel odDatumaMjesecJLabel = new JLabel("Mjesec");
        GridBagConstraints gbc_odDatumaMjesecJLabel = new GridBagConstraints();
        gbc_odDatumaMjesecJLabel.anchor = GridBagConstraints.EAST;
        gbc_odDatumaMjesecJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_odDatumaMjesecJLabel.gridx = 2;
        gbc_odDatumaMjesecJLabel.gridy = 0;
        odDatumaDanMjesecGodinaSadrzajniJPanel.add(odDatumaMjesecJLabel, gbc_odDatumaMjesecJLabel);

        odDatumaMjesecJComboBox = new JComboBox();
        odDatumaMjesecJComboBox.setModel(new DefaultComboBoxModel(new String[]{"Januar", "Februar", "Mart", "April", "Maj", "Juni", "Juli", "August", "Septembar", "Oktobar", "Novembar", "Decembar"}));
        GridBagConstraints gbc_odDatumaMjesecJComboBox = new GridBagConstraints();
        gbc_odDatumaMjesecJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_odDatumaMjesecJComboBox.insets = new Insets(0, 0, 0, 5);
        gbc_odDatumaMjesecJComboBox.gridx = 3;
        gbc_odDatumaMjesecJComboBox.gridy = 0;
        odDatumaDanMjesecGodinaSadrzajniJPanel.add(odDatumaMjesecJComboBox, gbc_odDatumaMjesecJComboBox);

        JLabel odDatumaGodinaJLabel = new JLabel("Godina");
        GridBagConstraints gbc_odDatumaGodinaJLabel = new GridBagConstraints();
        gbc_odDatumaGodinaJLabel.anchor = GridBagConstraints.EAST;
        gbc_odDatumaGodinaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_odDatumaGodinaJLabel.gridx = 4;
        gbc_odDatumaGodinaJLabel.gridy = 0;
        odDatumaDanMjesecGodinaSadrzajniJPanel.add(odDatumaGodinaJLabel, gbc_odDatumaGodinaJLabel);

        odDatumaGodinaJComboBox = new JComboBox();
        GridBagConstraints gbc_odDatumaGodinaJComboBox = new GridBagConstraints();
        gbc_odDatumaGodinaJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_odDatumaGodinaJComboBox.gridx = 5;
        gbc_odDatumaGodinaJComboBox.gridy = 0;
        odDatumaDanMjesecGodinaSadrzajniJPanel.add(odDatumaGodinaJComboBox, gbc_odDatumaGodinaJComboBox);

        JLabel doDatumaJLabel = new JLabel("Do datuma:");
        doDatumaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_doDatumaJLabel = new GridBagConstraints();
        gbc_doDatumaJLabel.anchor = GridBagConstraints.EAST;
        gbc_doDatumaJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_doDatumaJLabel.gridx = 0;
        gbc_doDatumaJLabel.gridy = 1;
        podaciZaObracunJPanel.add(doDatumaJLabel, gbc_doDatumaJLabel);

        JPanel doDatumaDanMjesecGodinaSadrzajniJPanel = new JPanel();
        GridBagConstraints gbc_doDatumaDanMjesecGodinaSadrzajniJPanel = new GridBagConstraints();
        gbc_doDatumaDanMjesecGodinaSadrzajniJPanel.insets = new Insets(0, 0, 5, 0);
        gbc_doDatumaDanMjesecGodinaSadrzajniJPanel.fill = GridBagConstraints.BOTH;
        gbc_doDatumaDanMjesecGodinaSadrzajniJPanel.gridx = 1;
        gbc_doDatumaDanMjesecGodinaSadrzajniJPanel.gridy = 1;
        podaciZaObracunJPanel.add(doDatumaDanMjesecGodinaSadrzajniJPanel, gbc_doDatumaDanMjesecGodinaSadrzajniJPanel);
        GridBagLayout gbl_doDatumaDanMjesecGodinaSadrzajniJPanel = new GridBagLayout();
        gbl_doDatumaDanMjesecGodinaSadrzajniJPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_doDatumaDanMjesecGodinaSadrzajniJPanel.rowHeights = new int[]{0, 0};
        gbl_doDatumaDanMjesecGodinaSadrzajniJPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_doDatumaDanMjesecGodinaSadrzajniJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        doDatumaDanMjesecGodinaSadrzajniJPanel.setLayout(gbl_doDatumaDanMjesecGodinaSadrzajniJPanel);

        JLabel doDatumaDanJLabel = new JLabel("Dan");
        GridBagConstraints gbc_doDatumaDanJLabel = new GridBagConstraints();
        gbc_doDatumaDanJLabel.anchor = GridBagConstraints.EAST;
        gbc_doDatumaDanJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_doDatumaDanJLabel.gridx = 0;
        gbc_doDatumaDanJLabel.gridy = 0;
        doDatumaDanMjesecGodinaSadrzajniJPanel.add(doDatumaDanJLabel, gbc_doDatumaDanJLabel);

        doDatumaDanJComboBox = new JComboBox();
        doDatumaDanJComboBox.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        GridBagConstraints gbc_doDatumaDanJComboBox = new GridBagConstraints();
        gbc_doDatumaDanJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_doDatumaDanJComboBox.insets = new Insets(0, 0, 0, 5);
        gbc_doDatumaDanJComboBox.gridx = 1;
        gbc_doDatumaDanJComboBox.gridy = 0;
        doDatumaDanMjesecGodinaSadrzajniJPanel.add(doDatumaDanJComboBox, gbc_doDatumaDanJComboBox);

        JLabel doDatumaMjesecJLabel = new JLabel("Mjesec");
        GridBagConstraints gbc_doDatumaMjesecJLabel = new GridBagConstraints();
        gbc_doDatumaMjesecJLabel.anchor = GridBagConstraints.EAST;
        gbc_doDatumaMjesecJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_doDatumaMjesecJLabel.gridx = 2;
        gbc_doDatumaMjesecJLabel.gridy = 0;
        doDatumaDanMjesecGodinaSadrzajniJPanel.add(doDatumaMjesecJLabel, gbc_doDatumaMjesecJLabel);

        doDatumaMjesecJComboBox = new JComboBox();
        doDatumaMjesecJComboBox.setModel(new DefaultComboBoxModel(new String[]{"Januar", "Februar", "Mart", "April", "Maj", "Juni", "Juli", "August", "Septembar", "Oktobar", "Novembar", "Decembar"}));
        GridBagConstraints gbc_doDatumaMjesecJComboBox = new GridBagConstraints();
        gbc_doDatumaMjesecJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_doDatumaMjesecJComboBox.insets = new Insets(0, 0, 0, 5);
        gbc_doDatumaMjesecJComboBox.gridx = 3;
        gbc_doDatumaMjesecJComboBox.gridy = 0;
        doDatumaDanMjesecGodinaSadrzajniJPanel.add(doDatumaMjesecJComboBox, gbc_doDatumaMjesecJComboBox);

        JLabel doDatumaGodinaJLabel = new JLabel("Godina");
        GridBagConstraints gbc_doDatumaGodinaJLabel = new GridBagConstraints();
        gbc_doDatumaGodinaJLabel.anchor = GridBagConstraints.EAST;
        gbc_doDatumaGodinaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_doDatumaGodinaJLabel.gridx = 4;
        gbc_doDatumaGodinaJLabel.gridy = 0;
        doDatumaDanMjesecGodinaSadrzajniJPanel.add(doDatumaGodinaJLabel, gbc_doDatumaGodinaJLabel);

        doDatumaGodinaJComboBox = new JComboBox();
        GridBagConstraints gbc_doDatumaGodinaJComboBox = new GridBagConstraints();
        gbc_doDatumaGodinaJComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_doDatumaGodinaJComboBox.gridx = 5;
        gbc_doDatumaGodinaJComboBox.gridy = 0;
        doDatumaDanMjesecGodinaSadrzajniJPanel.add(doDatumaGodinaJComboBox, gbc_doDatumaGodinaJComboBox);

        filtrirajDostaveJButton = new JButton("Filtriraj dostave");
        GridBagConstraints gbc_filtrirajDostaveJButton = new GridBagConstraints();
        gbc_filtrirajDostaveJButton.insets = new Insets(0, 0, 5, 0);
        gbc_filtrirajDostaveJButton.gridx = 1;
        gbc_filtrirajDostaveJButton.gridy = 2;
        podaciZaObracunJPanel.add(filtrirajDostaveJButton, gbc_filtrirajDostaveJButton);

        JLabel dostaveJLabel = new JLabel("Dostave:");
        dostaveJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_dostaveJLabel = new GridBagConstraints();
        gbc_dostaveJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_dostaveJLabel.anchor = GridBagConstraints.EAST;
        gbc_dostaveJLabel.gridx = 0;
        gbc_dostaveJLabel.gridy = 3;
        podaciZaObracunJPanel.add(dostaveJLabel, gbc_dostaveJLabel);

        JScrollPane dostaveJScrollPane = new JScrollPane();
        GridBagConstraints gbc_dostaveJScrollPane = new GridBagConstraints();
        gbc_dostaveJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_dostaveJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_dostaveJScrollPane.gridx = 1;
        gbc_dostaveJScrollPane.gridy = 3;
        podaciZaObracunJPanel.add(dostaveJScrollPane, gbc_dostaveJScrollPane);

        dostaveJTable = new JTable();
        dostaveJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Naziv dostave", "Isporu\u010Dioc", "Datum dostave", "Dostava isporucena"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    Object.class, Object.class, Object.class, Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        dostaveJScrollPane.setViewportView(dostaveJTable);

        JLabel pecivaDostaveJLabel = new JLabel("Peciva dostave:");
        GridBagConstraints gbc_pecivaDostaveJLabel = new GridBagConstraints();
        gbc_pecivaDostaveJLabel.insets = new Insets(0, 0, 5, 5);
        gbc_pecivaDostaveJLabel.gridx = 0;
        gbc_pecivaDostaveJLabel.gridy = 4;
        podaciZaObracunJPanel.add(pecivaDostaveJLabel, gbc_pecivaDostaveJLabel);

        JScrollPane pecivaDostaveJScrollPane = new JScrollPane();
        GridBagConstraints gbc_pecivaDostaveJScrollPane = new GridBagConstraints();
        gbc_pecivaDostaveJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_pecivaDostaveJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_pecivaDostaveJScrollPane.gridx = 1;
        gbc_pecivaDostaveJScrollPane.gridy = 4;
        podaciZaObracunJPanel.add(pecivaDostaveJScrollPane, gbc_pecivaDostaveJScrollPane);

        pecivaDostaveJTable = new JTable();
        pecivaDostaveJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "\u0160ifra", "Naziv", "Te\u017Eina", "Cijena", "Koli\u010Dina", "Ukupna cijena"
                }
        ));
        pecivaDostaveJScrollPane.setViewportView(pecivaDostaveJTable);

        JLabel zaradaJLabel = new JLabel("Zarada:");
        zaradaJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_zaradaJLabel = new GridBagConstraints();
        gbc_zaradaJLabel.insets = new Insets(0, 0, 0, 5);
        gbc_zaradaJLabel.anchor = GridBagConstraints.EAST;
        gbc_zaradaJLabel.gridx = 0;
        gbc_zaradaJLabel.gridy = 5;
        podaciZaObracunJPanel.add(zaradaJLabel, gbc_zaradaJLabel);

        zaradaIspisJLabel = new JLabel("");
        GridBagConstraints gbc_zaradaIspisJLabel = new GridBagConstraints();
        gbc_zaradaIspisJLabel.gridx = 1;
        gbc_zaradaIspisJLabel.gridy = 5;
        podaciZaObracunJPanel.add(zaradaIspisJLabel, gbc_zaradaIspisJLabel);

        JPanel dugmadJPanel = new JPanel();
        GridBagConstraints gbc_dugmadJPanel = new GridBagConstraints();
        gbc_dugmadJPanel.fill = GridBagConstraints.BOTH;
        gbc_dugmadJPanel.gridx = 0;
        gbc_dugmadJPanel.gridy = 2;
        add(dugmadJPanel, gbc_dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        napraviObracunJButton = new JButton("Napravi obra\u010Dun");
        GridBagConstraints gbc_napraviObracunJButton = new GridBagConstraints();
        gbc_napraviObracunJButton.anchor = GridBagConstraints.SOUTH;
        gbc_napraviObracunJButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_napraviObracunJButton.gridx = 0;
        gbc_napraviObracunJButton.gridy = 0;
        dugmadJPanel.add(napraviObracunJButton, gbc_napraviObracunJButton);

        dodajListeners();
    }

    public JTable getDostaveJTable() {
        return dostaveJTable;
    }

    public JComboBox getObracunZaJComboBox() {
        return obracunZaJComboBox;
    }

    public JComboBox getOdDatumaDanJComboBox() {
        return odDatumaDanJComboBox;
    }

    public JComboBox getOdDatumaMjesecJComboBox() {
        return odDatumaMjesecJComboBox;
    }

    public JComboBox getOdDatumaGodinaJComboBox() {
        return odDatumaGodinaJComboBox;
    }

    public JComboBox getDoDatumaDanJComboBox() {
        return doDatumaDanJComboBox;
    }

    public JComboBox getDoDatumaMjesecJComboBox() {
        return doDatumaMjesecJComboBox;
    }

    public JComboBox getDoDatumaGodinaJComboBox() {
        return doDatumaGodinaJComboBox;
    }

    public JButton getNapraviObracunJButton() {
        return napraviObracunJButton;
    }

    public JButton getFiltrirajDostaveJButton() {
        return filtrirajDostaveJButton;
    }

    public JTable getPecivaDostaveJTable() {
        return pecivaDostaveJTable;
    }

    public JLabel getZaradaIspisJLabel() {
        return zaradaIspisJLabel;
    }

    private void dodajListeners() {
        RacunovodstvoObracunavanjeController racunovodstvoObracunavanjeController = new RacunovodstvoObracunavanjeController(this);

        obracunZaJComboBox.addItemListener(racunovodstvoObracunavanjeController.getRacunovodstvoObracunZaJComboBoxItemListener());
    }

    public void popuniSaSvimPodacimaIzBaze() {
        // Uzmi sve klijente iz baze
        Baza baza = Baza.getBaza();
        List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);

        // izfiltriraj one klijente koji su obrisani
        List<Klijent> obrisaniKlijenti = new ArrayList<Klijent>();
        for(Klijent k : sviKlijenti) {
            if(k.isObrisano()) {
                obrisaniKlijenti.add(k);
            }
        }
        sviKlijenti.removeAll(obrisaniKlijenti);

        // uzmi prvog od neobrisanih klijenata
        Klijent klijent = sviKlijenti.get(0);
        List<Dostava> sveDostave = (List<Dostava>) klijent.getDostave();

        // Napravi jComboBoxItem-ove sa svim klijentima
        List<JComboBoxItem> sviKlijentiJComboBoxItemi = new ArrayList<JComboBoxItem>();
        for (Klijent k : sviKlijenti) {
            sviKlijentiJComboBoxItemi.add(new JComboBoxItem(k.getId(), k.getIme()));
        }
        // Popuni obracunZaJComboBox sa JComboBoxItem-ovima
        popuniJComboBoxSa(sviKlijentiJComboBoxItemi, obracunZaJComboBox);

        // Popuni ComboBox-ove za datume sa trenutnim datumom
        Calendar kalendarTrenutniDatum = Calendar.getInstance();
        kalendarTrenutniDatum.setTime(new Date());
        GuiUtilities.postaviDatumUComboBoxove(
                kalendarTrenutniDatum.get(Calendar.DAY_OF_MONTH), kalendarTrenutniDatum.get(Calendar.MONTH), kalendarTrenutniDatum.get(Calendar.YEAR),
                odDatumaDanJComboBox, odDatumaMjesecJComboBox, odDatumaGodinaJComboBox);
        GuiUtilities.postaviDatumUComboBoxove(
                kalendarTrenutniDatum.get(Calendar.DAY_OF_MONTH), kalendarTrenutniDatum.get(Calendar.MONTH), kalendarTrenutniDatum.get(Calendar.YEAR),
                doDatumaDanJComboBox, doDatumaMjesecJComboBox, doDatumaGodinaJComboBox);

        // Popuni tabelu dostave sa dostavama za trenutnog klijenta
        Klijent prviKlijentUJComboBoxu = sviKlijenti.get(0);
        TableModel dostaveTableModel;
        if (prviKlijentUJComboBoxu != null) {
            dostaveTableModel = new DostaveTableModel(prviKlijentUJComboBoxu);
        } else {
            Klijent prazanKlijent = new Klijent();
            prazanKlijent.setDostave(new ArrayList<Dostava>(0));
            dostaveTableModel = new DostaveTableModel(prazanKlijent);
        }
        dostaveJTable.setModel(dostaveTableModel);

        // Oznaci prvi red u tabeli za dostave
        ListSelectionModel selectionModel = dostaveJTable.getSelectionModel();
        selectionModel.setSelectionInterval(0, 0);

        // Uzmi oznacenu dostavu iz tabele Dostave
        Dostava oznacenaDostava = ((DostaveTableModel)dostaveJTable.getModel()).getDostaveZaKlijenta()
                .get(dostaveJTable.getSelectedRow());

        // Popuni tabelu peciva sa podacima o pecivima iz oznacene dostave
        PecivaDostaveTableModel pecivaDostaveTableModel = new PecivaDostaveTableModel(oznacenaDostava);
        pecivaDostaveJTable.setModel(pecivaDostaveTableModel);

        // Izracunati zaradu i upisati ju u zarada labelu
        double zarada = 0.0;
        for(int i=0; i<pecivaDostaveJTable.getRowCount(); i++) {
            zarada += (Double)pecivaDostaveJTable.getValueAt(i, 5);
        }
        zaradaIspisJLabel.setText(String.format("%.2f", zarada));

        // Refreshati panel
        this.validate();
        this.repaint();
    }

    private void popuniJComboBoxSa(List<JComboBoxItem> jComboBoxStavke, JComboBox jComboBox) {
        // Izbjegavanje okidanja eventa SELECTED prilikom dinamickog dodavanja itemova
        ItemListener[] itemListeners = jComboBox.getItemListeners();
        for (int i = 0; i < itemListeners.length; i++) {
            jComboBox.removeItemListener(itemListeners[i]);
        }

        for (JComboBoxItem j : jComboBoxStavke) {
            jComboBox.addItem(j);
        }

        // Vracanje EventListener-a na JComboBox
        for (int i = 0; i < itemListeners.length; i++) {
            jComboBox.addItemListener(itemListeners[i]);
        }
    }

    public void popuniSaPodacima(long idSelektiranogKlijenta) {
        Baza baza = Baza.getBaza();
        Klijent selektiraniKlijent = baza.dajPoId(Klijent.class, idSelektiranogKlijenta);
    }
}

class DostaveTableModel extends DefaultTableModel {

    private Klijent klijent;
    private List<Dostava> dostaveZaKlijenta;

    DostaveTableModel() {
    }

    DostaveTableModel(Klijent klijent) {
        this.klijent = klijent;
        this.dostaveZaKlijenta = (List<Dostava>) klijent.getDostave();
        List<Dostava> obrisaneDostave = new ArrayList<Dostava>();
        for(Dostava d : obrisaneDostave) {
            if(d.isObrisano()) {
                obrisaneDostave.add(d);
            }
        }
        dostaveZaKlijenta.removeAll(obrisaneDostave);
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public List<Dostava> getDostaveZaKlijenta() {
        return dostaveZaKlijenta;
    }

    @Override
    public int getRowCount() {
        if (dostaveZaKlijenta != null) {
            return dostaveZaKlijenta.size();
        }

        return 0;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Naziv dostave";
            case 1:
                return "Isporučioc";
            case 2:
                return "Datum dostave";
            case 3:
                return "Dostava isporučena";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Boolean.class;
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dostaveZaKlijenta.get(rowIndex).getNaziv();
            case 1:
                Korisnik korisnikKojiJePreuzeoDostavu = dostaveZaKlijenta.get(rowIndex).getPreuzeo();
                return korisnikKojiJePreuzeoDostavu.getIme() + " " + korisnikKojiJePreuzeoDostavu.getPrezime();
            case 2:
                return dostaveZaKlijenta.get(rowIndex).getDatum().toString();
            case 3:
                return dostaveZaKlijenta.get(rowIndex).isJeIsporuceno() ? Boolean.TRUE : Boolean.FALSE;
            default:
                return null;
        }
    }

    /*@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }*/
}

class PecivaDostaveTableModel extends DefaultTableModel {

    private Dostava dostava;
    private List<PecivoUDostavi> pecivaUDostavi;

    PecivaDostaveTableModel() {
    }

    PecivaDostaveTableModel(Dostava dostava) {
        this.dostava = dostava;
        this.pecivaUDostavi = (List<PecivoUDostavi>) dostava.getPeciva();
        List<PecivoUDostavi> obrisanaPecivaUDostavi = new ArrayList<PecivoUDostavi>();
        for(PecivoUDostavi p : obrisanaPecivaUDostavi) {
            if(p.isObrisano()) {
                obrisanaPecivaUDostavi.add(p);
            }
        }
        pecivaUDostavi.removeAll(obrisanaPecivaUDostavi);
    }

    public Dostava getDostava() {
        return dostava;
    }

    public List<PecivoUDostavi> getPecivaUDostavi() {
        return pecivaUDostavi;
    }

    @Override
    public int getRowCount() {
        if (pecivaUDostavi != null) {
            return pecivaUDostavi.size();
        }

        return 0;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Šifra";
            case 1:
                return "Naziv";
            case 2:
                return "Težina";
            case 3:
                return "Cijena";
            case 4:
                return "Količina";
            case 5:
                return "Ukupna cijena";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            case 4:
                return Integer.class;
            case 5:
                return Double.class;
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return pecivaUDostavi.get(rowIndex).getPecivo().getSifra();
            case 1:
                return pecivaUDostavi.get(rowIndex).getPecivo().getNaziv();
            case 2:
                return pecivaUDostavi.get(rowIndex).getPecivo().getTezina();
            case 3:
                return pecivaUDostavi.get(rowIndex).getPecivo().getCijena();
            case 4:
                return pecivaUDostavi.get(rowIndex).getKolicinaPreuzetogPeciva() - pecivaUDostavi.get(rowIndex).getKolicinaVracenogPeciva();
            case 5:
                double kolicinaDostavljenogPeciva = pecivaUDostavi.get(rowIndex).getKolicinaPreuzetogPeciva() - pecivaUDostavi.get(rowIndex).getKolicinaVracenogPeciva();
                return kolicinaDostavljenogPeciva*pecivaUDostavi.get(rowIndex).getPecivo().getCijena();
            default:
                return null;
        }
    }

    /*@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }*/
}