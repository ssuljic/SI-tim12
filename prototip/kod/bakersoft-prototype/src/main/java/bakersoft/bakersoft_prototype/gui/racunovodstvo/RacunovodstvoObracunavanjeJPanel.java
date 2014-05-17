package bakersoft.bakersoft_prototype.gui.racunovodstvo;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class RacunovodstvoObracunavanjeJPanel extends JPanel {
	private JTable dostaveJTable;
	private JComboBox obracunZaJComboBox;
	private JComboBox odDatumaDanJComboBox;
	private JComboBox odDatumaMjesecJComboBox;
	private JComboBox odDatumaGodinaJComboBox;
	private JComboBox doDatumaDanJComboBox;
	private JComboBox doDatumaMjesecJComboBox;
	private JComboBox doDatumaGodinaJComboBox;
	private JLabel brojDostavaIspisJLabel;
	private JLabel brojPovrataIspisJLabel;
	private JLabel zaradaIspisJLabel;
	private JButton obrisiJButton;
	private JButton dodajJButton;

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
		gbl_podaciZaObracunJPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		odDatumaDanJComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
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
		odDatumaMjesecJComboBox.setModel(new DefaultComboBoxModel(new String[] {"Januar", "Februar", "Mart", "April", "Maj", "Juni", "Juli", "August", "Septembar", "Oktobar", "Novembar", "Decembar"}));
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
		doDatumaDanJComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
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
		doDatumaMjesecJComboBox.setModel(new DefaultComboBoxModel(new String[] {"Januar", "Februar", "Mart", "April", "Maj", "Juni", "Juli", "August", "Septembar", "Oktobar", "Novembar", "Decembar"}));
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
		
		JLabel dostaveJLabel = new JLabel("Dostave:");
		dostaveJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_dostaveJLabel = new GridBagConstraints();
		gbc_dostaveJLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dostaveJLabel.anchor = GridBagConstraints.EAST;
		gbc_dostaveJLabel.gridx = 0;
		gbc_dostaveJLabel.gridy = 2;
		podaciZaObracunJPanel.add(dostaveJLabel, gbc_dostaveJLabel);
		
		JScrollPane dostaveJScrollPane = new JScrollPane();
		GridBagConstraints gbc_dostaveJScrollPane = new GridBagConstraints();
		gbc_dostaveJScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_dostaveJScrollPane.fill = GridBagConstraints.BOTH;
		gbc_dostaveJScrollPane.gridx = 1;
		gbc_dostaveJScrollPane.gridy = 2;
		podaciZaObracunJPanel.add(dostaveJScrollPane, gbc_dostaveJScrollPane);
		
		dostaveJTable = new JTable();
		dostaveJTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
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
		gbc_brojDostavaJLabel.gridy = 3;
		podaciZaObracunJPanel.add(brojDostavaJLabel, gbc_brojDostavaJLabel);
		
		brojDostavaIspisJLabel = new JLabel("");
		GridBagConstraints gbc_brojDostavaIspisJLabel = new GridBagConstraints();
		gbc_brojDostavaIspisJLabel.insets = new Insets(0, 0, 5, 0);
		gbc_brojDostavaIspisJLabel.gridx = 1;
		gbc_brojDostavaIspisJLabel.gridy = 3;
		podaciZaObracunJPanel.add(brojDostavaIspisJLabel, gbc_brojDostavaIspisJLabel);
		
		JLabel brojPovrataJLabel = new JLabel("Broj povrata:");
		brojPovrataJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_brojPovrataJLabel = new GridBagConstraints();
		gbc_brojPovrataJLabel.insets = new Insets(0, 0, 5, 5);
		gbc_brojPovrataJLabel.anchor = GridBagConstraints.EAST;
		gbc_brojPovrataJLabel.gridx = 0;
		gbc_brojPovrataJLabel.gridy = 4;
		podaciZaObracunJPanel.add(brojPovrataJLabel, gbc_brojPovrataJLabel);
		
		brojPovrataIspisJLabel = new JLabel("");
		GridBagConstraints gbc_brojPovrataIspisJLabel = new GridBagConstraints();
		gbc_brojPovrataIspisJLabel.insets = new Insets(0, 0, 5, 0);
		gbc_brojPovrataIspisJLabel.gridx = 1;
		gbc_brojPovrataIspisJLabel.gridy = 4;
		podaciZaObracunJPanel.add(brojPovrataIspisJLabel, gbc_brojPovrataIspisJLabel);
		
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
		gbl_dugmadJPanel.columnWidths = new int[]{0, 0, 0};
		gbl_dugmadJPanel.rowHeights = new int[]{0, 0};
		gbl_dugmadJPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_dugmadJPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dugmadJPanel.setLayout(gbl_dugmadJPanel);
		
		obrisiJButton = new JButton("Obri\u0161i");
		GridBagConstraints gbc_obrisiJButton = new GridBagConstraints();
		gbc_obrisiJButton.anchor = GridBagConstraints.SOUTH;
		gbc_obrisiJButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_obrisiJButton.insets = new Insets(0, 0, 0, 5);
		gbc_obrisiJButton.gridx = 0;
		gbc_obrisiJButton.gridy = 0;
		dugmadJPanel.add(obrisiJButton, gbc_obrisiJButton);
		
		dodajJButton = new JButton("Dodaj");
		GridBagConstraints gbc_dodajJButton = new GridBagConstraints();
		gbc_dodajJButton.anchor = GridBagConstraints.SOUTH;
		gbc_dodajJButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_dodajJButton.gridx = 1;
		gbc_dodajJButton.gridy = 0;
		dugmadJPanel.add(dodajJButton, gbc_dodajJButton);

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
	public JButton getObrisiJButton() {
		return obrisiJButton;
	}
	public JButton getDodajJButton() {
		return dodajJButton;
	}
}
