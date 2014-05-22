package controllers;

import entities.Klijent;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoKlijentiJPanel;

import javax.swing.*;
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
                    List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);
                    racunovodstvoKlijentiJPanel.popuniSaPodacima(sviKlijenti, idSelektiranogKlijenta);
                }
            }
        };
    }

    public ActionListener getKlijentiObrisiJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                long idSelektiranogKlijenta = 0;
                if (racunovodstvoKlijentiJPanel.getTraziJComboBox().getItemCount() > 0) {
                    idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoKlijentiJPanel.getTraziJComboBox().getSelectedItem()).getId();
                }

                Baza baza = Baza.getBaza();
                if (idSelektiranogKlijenta > 0) {
                    baza.obrisiIzBaze(Klijent.class, idSelektiranogKlijenta);
                }

                List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);
                long idPrvogKlijenta = 0;
                if (sviKlijenti.size() > 0) {
                    idPrvogKlijenta = sviKlijenti.get(0).getId();
                }
                racunovodstvoKlijentiJPanel.popuniSaPodacima(sviKlijenti, idPrvogKlijenta);
                JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), "Uspješno ste izbrisali klijenta!");
            }
        };
    }

    public ActionListener getKlijentiDodajJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Klijent noviKlijent = racunovodstvoKlijentiJPanel.dajPodatkeONovomKlijentu();
                Baza baza = Baza.getBaza();
                baza.spasiUBazu(noviKlijent);
                JOptionPane.showMessageDialog(racunovodstvoKlijentiJPanel.getParent(), "Uspješno ste dodali klijenta: " + noviKlijent.getIme());
            }
        };
    }

}
