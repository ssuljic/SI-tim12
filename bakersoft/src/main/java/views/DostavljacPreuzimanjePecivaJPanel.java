package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DostavljacPreuzimanjePecivaJPanel extends JPanel {
    private JTextField nazivDostaveJTextField;
    private JTable dostavaJTable;
    private JButton ukloniPecivoJButton;
    private JButton dodajPecivoJButton;
    private JButton preuzmiDostavuJButton;
    private JScrollPane dostavaJScrollPane;
    private JTextField kolicinaJTextField;

    /**
     * Create the panel.
     */
    public DostavljacPreuzimanjePecivaJPanel() {
        setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Preuzimanje peciva:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        setLayout(null);

        JLabel nazivDostaveJLabel = new JLabel("Naziv dostave:");
        nazivDostaveJLabel.setBounds(6, 18, 72, 14);
        add(nazivDostaveJLabel);

        nazivDostaveJTextField = new JTextField();
        nazivDostaveJTextField.setBounds(83, 15, 169, 20);
        add(nazivDostaveJTextField);
        nazivDostaveJTextField.setColumns(10);
        
                dostavaJScrollPane = new JScrollPane();
                dostavaJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                dostavaJScrollPane.setBounds(6, 166, 474, 213);
                add(dostavaJScrollPane);
                
                        dostavaJTable = new JTable();
                        dostavaJTable.setModel(new DefaultTableModel(
                                new Object[][]{
                                },
                                new String[]{
                                        "Pecivo", "\u0160ifra", "Koli\u010Dina peciva"
                                }
                        ));
                        dostavaJScrollPane.setViewportView(dostavaJTable);
        
        

        JPanel dugmadJPanel = new JPanel();
        dugmadJPanel.setBounds(6, 390, 474, 116);
        add(dugmadJPanel);
        GridBagLayout gbl_dugmadJPanel = new GridBagLayout();
        gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
        gbl_dugmadJPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_dugmadJPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        dugmadJPanel.setLayout(gbl_dugmadJPanel);

        ukloniPecivoJButton = new JButton("Ukloni pecivo");
        ukloniPecivoJButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        	}
        });
        
        
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
                                gbc_preuzmiDostavuJButton.insets = new Insets(0, 0, 5, 0);
                                gbc_preuzmiDostavuJButton.fill = GridBagConstraints.HORIZONTAL;
                                gbc_preuzmiDostavuJButton.gridwidth = 2;
                                gbc_preuzmiDostavuJButton.gridx = 0;
                                gbc_preuzmiDostavuJButton.gridy = 1;
                                dugmadJPanel.add(preuzmiDostavuJButton, gbc_preuzmiDostavuJButton);
                                
                                JLabel pecivoJLabel = new JLabel("Pecivo:");
                                pecivoJLabel.setBounds(42, 46, 46, 14);
                                add(pecivoJLabel);
                                
                                JComboBox comboBox = new JComboBox();
                                comboBox.setBounds(83, 43, 169, 20);
                                add(comboBox);
                                
                                JLabel kolicinaJLabel = new JLabel("Kolicina:");
                                kolicinaJLabel.setBounds(42, 81, 46, 14);
                                add(kolicinaJLabel);
                                
                                kolicinaJTextField = new JTextField();
                                kolicinaJTextField.setBounds(83, 78, 169, 20);
                                add(kolicinaJTextField);
                                kolicinaJTextField.setColumns(10);
                                
                                JButton btnDodajPecivo = new JButton("Dodaj pecivo");
                                btnDodajPecivo.setBounds(122, 119, 130, 23);
                                add(btnDodajPecivo);

        
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

    public void popuniSaSvimPodacimaIzBaze() {

    }
}
