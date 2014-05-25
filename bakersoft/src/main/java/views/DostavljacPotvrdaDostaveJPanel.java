package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controllers.DostavljacIzbornikController;
import controllers.RacunovodstvoObracunavanjeController;
import utilities.Baza;
import utilities.JComboBoxItem;
import entities.Dostava;
import entities.Klijent;
import exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.List;

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

        JScrollPane pecivaUDostaviJScrollPane = new JScrollPane();
        GridBagConstraints gbc_pecivaUDostaviJScrollPane = new GridBagConstraints();
        gbc_pecivaUDostaviJScrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_pecivaUDostaviJScrollPane.fill = GridBagConstraints.BOTH;
        gbc_pecivaUDostaviJScrollPane.gridx = 0;
        gbc_pecivaUDostaviJScrollPane.gridy = 1;
        add(pecivaUDostaviJScrollPane, gbc_pecivaUDostaviJScrollPane);

        podaciODostaviJTable = new JTable();
        podaciODostaviJTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Pecivo", "\u0160ifra", "Koli\u010Dina dostavljenog peciva"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                    false, false, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        pecivaUDostaviJScrollPane.setViewportView(podaciODostaviJTable);

        dostavaIzvrsenaJButton = new JButton("Dostava izvr\u0161ena");
        dostavaIzvrsenaJButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        GridBagConstraints gbc_dostavaIzvrsenaJButton = new GridBagConstraints();
        gbc_dostavaIzvrsenaJButton.fill = GridBagConstraints.BOTH;
        gbc_dostavaIzvrsenaJButton.gridx = 0;
        gbc_dostavaIzvrsenaJButton.gridy = 2;
        add(dostavaIzvrsenaJButton, gbc_dostavaIzvrsenaJButton);

    }
    
    
    
    public void popuniSaPodacima(List<Dostava> sveDostave, long idSelektovaneDostave) {
    	// TODO: Vjerovatno bi se jo� malo moglo refaktorisati ...
        if (sveDostave == null || sveDostave.size() <= 0) {
            ocistiPanel();
            return;
        }
        
      //  Dostava selektovanaDostava= popuniTraziJComboBoxSa(sveDostave, idSelektovaneDostave);
        
       // nazivFirmeJTextField.setText(selektovaniKlijent.getIme());
       // telefonJTextField.setText(selektovaniKlijent.getTelefon());

    }
    
    private void ocistiPanel() {
    	dostaveJTable.removeAll();
        podaciODostaviJTable.removeAll();

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
    
    private void dodajListeners() {
       // RacunovodstvoObracunavanjeController racunovodstvoObracunavanjeController = new RacunovodstvoObracunavanjeController(this);
        //DostavljacIzbornikController dostavljacIzbornikController = new DostavljacIzbornikController(this);
        //obracunZaJComboBox.addItemListener(racunovodstvoObracunavanjeController.getObracunavanjeObracunZaJComboBoxItemListener());
    }

    public void popuniSaSvimPodacimaIzBaze() {
    	Baza baza = Baza.getBaza();
    	 java.util.List<Dostava> sveDostave = baza.dajSve(Dostava.class);
        long idSelektiraneDostave = 0;
        if (sveDostave.size() > 0) {
            idSelektiraneDostave= sveDostave.get(0).getId();
        }
        popuniSaPodacima(sveDostave, idSelektiraneDostave);
        
    }
}
