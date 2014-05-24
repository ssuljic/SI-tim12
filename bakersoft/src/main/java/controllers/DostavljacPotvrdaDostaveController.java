package controllers;

import javax.persistence.Table;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
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

import utilities.JTableItem;
import views.DostavljacPotvrdaDostaveJPanel;

public class DostavljacPotvrdaDostaveController {
	private DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel;

    public DostavljacPotvrdaDostaveController(DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel) {
        this.dostavljacPotvrdaDostaveJPanel = dostavljacPotvrdaDostaveJPanel;
    }
   
/*
    public ItemListener getDostavljacPotvrdaDostaveZaJTableItemListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    long idSelektiraneDostave =(JTableItem)(dostavljacPotvrdaDostaveJPanel.getDostaveJTable().getSelectedRow()).getId();
                    Baza baza = Baza.getBaza();
                    List<Dostava> sveDostave= baza.dajSve(Dostava.class);
                    dostavljacPotvrdaDostaveJPanel.popuniSaPodacima(sveDostave, idSelektiraneDostave);              
                    
                }
            }
        };
    }*/
}

