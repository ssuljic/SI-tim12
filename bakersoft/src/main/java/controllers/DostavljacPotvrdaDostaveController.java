package controllers;

import javax.persistence.Table;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controllers.DostavljacIzbornikController;
import controllers.RacunovodstvoObracunavanjeController;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoObracunavanjeJPanel;
import entities.Dostava;
import entities.Klijent;
import exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import utilities.JTableItem;
import views.DostavljacPotvrdaDostaveJPanel;

public class DostavljacPotvrdaDostaveController {
	private DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel;

    /**
     * @wbp.parser.entryPoint
     */
    public DostavljacPotvrdaDostaveController(DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel) {
        this.dostavljacPotvrdaDostaveJPanel = dostavljacPotvrdaDostaveJPanel;
    }
   

    /**
     * @wbp.parser.entryPoint
     */
    public ListSelectionListener getDostavljacPotvrdaDostaveZaJTableListSelectionListener() {
        return new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting()) {
                    dostavljacPotvrdaDostaveJPanel.popuniSaPodacima(dostavljacPotvrdaDostaveJPanel.dajSelektiranuDostavu());              
                    
                }
			}
		};
}
}
