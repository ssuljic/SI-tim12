package controllers;

import entities.Klijent;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoKlijentiJPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class RacunovodstvoKlijentiController {
    private RacunovodstvoKlijentiJPanel racunovodstvoKlijentiJPanel;

    public RacunovodstvoKlijentiController(RacunovodstvoKlijentiJPanel racunovodstvoKlijentiJPanel) {
        this.racunovodstvoKlijentiJPanel = racunovodstvoKlijentiJPanel;
    }

    public ItemListener getKlijentiTraziJComboBoxItemListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoKlijentiJPanel.getTraziJComboBox().getSelectedItem()).getId();
                    Baza baza = Baza.getBaza();
                    List<Klijent> sviKlijenti = baza.dajSveKlijente();
                    racunovodstvoKlijentiJPanel.popuniSaPodacima(sviKlijenti, idSelektiranogKlijenta);
                }
            }
        };
    }


}
