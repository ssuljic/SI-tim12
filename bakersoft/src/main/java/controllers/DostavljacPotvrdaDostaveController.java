package controllers;

import javax.persistence.Table;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import utilities.Baza;
import utilities.JComboBoxItem;
import entities.Dostava;
import entities.Klijent;
import entities.Korisnik;
import entities.PecivoUDostavi;
import entities.Racun;
import exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti;
import views.DostavljacJFrame;
import views.DostavljacPotvrdaDostaveJPanel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import utilities.JTableItem;

public class DostavljacPotvrdaDostaveController {
    private DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel;

    public DostavljacPotvrdaDostaveController(DostavljacPotvrdaDostaveJPanel racunovodstvoObracunavanjeJPanel) {
        this.dostavljacPotvrdaDostaveJPanel = dostavljacPotvrdaDostaveJPanel;
    }
   
    public ListSelectionListener getDostavljacPotvrdaDostaveZaJTableListSelectionListener() {
        return new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				Baza baza = Baza.getBaza();
				List<PecivoUDostavi> svaPecivaUDostavi = baza.dajSve(PecivoUDostavi.class);
				if (!e.getValueIsAdjusting()) {
                    dostavljacPotvrdaDostaveJPanel.popuniSaPodacima(dostavljacPotvrdaDostaveJPanel.dajSelektiranuDostavu(),svaPecivaUDostavi);              
                }
			}
		};
}

    public ListSelectionListener getObracunavanjeObracunZaJComboBoxItemListener() {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            	Baza baza = Baza.getBaza();
    			List<PecivoUDostavi> svaPecivaUDostavi = baza.dajSve(PecivoUDostavi.class);
                if (!e.getValueIsAdjusting()) {
                    long idSelektiraneDostave =(long) (dostavljacPotvrdaDostaveJPanel.getDostaveJTable().getSelectedRow());

                    dostavljacPotvrdaDostaveJPanel.popuniSaPodacima(idSelektiraneDostave ,svaPecivaUDostavi);
                }
            }
        };
    }
}
