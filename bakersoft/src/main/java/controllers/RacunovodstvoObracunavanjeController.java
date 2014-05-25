package controllers;

import entities.Klijent;
import entities.Korisnik;
import entities.Racun;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoJFrame;
import views.RacunovodstvoObracunavanjeJPanel;

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

public class RacunovodstvoObracunavanjeController {
    private RacunovodstvoObracunavanjeJPanel racunovodstvoObracunavanjeJPanel;

    public RacunovodstvoObracunavanjeController(RacunovodstvoObracunavanjeJPanel racunovodstvoObracunavanjeJPanel) {
        this.racunovodstvoObracunavanjeJPanel = racunovodstvoObracunavanjeJPanel;
    }

    public ItemListener getObracunavanjeObracunZaJComboBoxItemListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoObracunavanjeJPanel.getObracunZaJComboBox().getSelectedItem()).getId();
                    racunovodstvoObracunavanjeJPanel.popuniSaPodacima(idSelektiranogKlijenta);
                }
            }
        };
    }

    public ActionListener getObracunavanjeFiltrirajDostaveJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Date odDatuma = (Date) racunovodstvoObracunavanjeJPanel.getOdDatumaJSpinner().getValue();
                Date doDatuma = (Date) racunovodstvoObracunavanjeJPanel.getDoDatumaJSpinner().getValue();

                long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoObracunavanjeJPanel.getObracunZaJComboBox().getSelectedItem()).getId();

                racunovodstvoObracunavanjeJPanel.popuniSaPodacima(idSelektiranogKlijenta, odDatuma, doDatuma);
            }
        };
    }

    public ActionListener getObracunavanjeNapraviObracunJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Racun noviRacun = new Racun();

                // Uzmi klijenta za kojeg se obracunava racun
                long idSelektiranogKlijenta = 0;
                if (racunovodstvoObracunavanjeJPanel.getObracunZaJComboBox().getItemCount() > 0) {
                    idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoObracunavanjeJPanel.getObracunZaJComboBox().getSelectedItem()).getId();
                }

                if (idSelektiranogKlijenta > 0) {
                    Baza baza = Baza.getBaza();
                    Klijent klijent = baza.dajPoId(Klijent.class, idSelektiranogKlijenta);

                    // Postavi na racun trenutni datum
                    noviRacun.setDatum(new Date());

                    // Izracunati konacni iznos racuna
                    // Uzmi iz tabele dostava dostavu selektiranog reda
                    // Za prodji kroz svaku stavku dostave i sracunaj ju u konacni iznos racuna
                    double iznosRacuna = 0.0;
                    iznosRacuna = Double.valueOf(racunovodstvoObracunavanjeJPanel.getZaradaIspisJLabel().getText());
                    noviRacun.setIznos(iznosRacuna);

                    // Postaviti da je racun nije placen
                    noviRacun.setJePlacen(false);

                    // Postaviti klijenta kojem se izdaje racun na racun i obratno, postaviti racun na klijnta
                    noviRacun.setKlijent(klijent);
                    if (klijent.getRacuni() == null) {
                        klijent.setRacuni(new ArrayList<Racun>());
                    }
                    klijent.getRacuni().add(noviRacun);

                    // Postaviti korisnika koji je obracunao racun na racun i obratno, postaviti racun na korisnika
                    Korisnik obracunavaoc = ((RacunovodstvoJFrame) SwingUtilities.getWindowAncestor(racunovodstvoObracunavanjeJPanel)).getKorisnik();
                    if (obracunavaoc.getObracunatiRacuni() == null) {
                        obracunavaoc.setObracunatiRacuni(new ArrayList<Racun>());
                    }
                    obracunavaoc.getObracunatiRacuni().add(noviRacun);
                    noviRacun.setObracunao(obracunavaoc);

                    // Uzeti "pocetak obracuna" i "kraj obracuna" datume, te ih unijeti na racun
                    noviRacun.setPocetak((Date) racunovodstvoObracunavanjeJPanel.getPocetniRokIsplateJSpinner().getValue());
                    noviRacun.setKraj((Date) racunovodstvoObracunavanjeJPanel.getKrajnjiRokIsplateJSpinner().getValue());

                    // Spasiti racun, azurirati klijenta i korisnika koji je obracunao
                    baza.spasiUBazu(noviRacun);
                    baza.azuriraj(klijent);
                    baza.azuriraj(obracunavaoc);
                }
            }
        };
    }

    public ListSelectionListener getObracunavanjeDostaveJTableListSelectionListener() {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    racunovodstvoObracunavanjeJPanel.popuniSaPodacima(racunovodstvoObracunavanjeJPanel.dajSelektiranuDostavu());
                }
            }
        };
    }
}
