package controllers;

import entities.Klijent;
import entities.Korisnik;
import entities.Racun;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoJFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;

import utilities.JComboBoxItem;
import views.RacunovodstvoSpaseniObracuniJPanel;

public class RacunovodstvoSpaseniObracuniController {
	private RacunovodstvoSpaseniObracuniJPanel racunovodstvoSpaseniObracuniJPanel;

    public RacunovodstvoSpaseniObracuniController(RacunovodstvoSpaseniObracuniJPanel racunovodstvoSpaseniObracuniJPanel) {
        this.racunovodstvoSpaseniObracuniJPanel = racunovodstvoSpaseniObracuniJPanel;
    }
    
    public ItemListener getSpaseniObracuniObracunZaJComboBoxItemListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().getSelectedItem()).getId();
                    racunovodstvoSpaseniObracuniJPanel.popuniSaPodacima(idSelektiranogKlijenta);
                }
            }
        };
    }
}
