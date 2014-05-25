package controllers;

import entities.Korisnik;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoKorisnickiRacuniJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class RacunovodstvoKorisnickiRacuniController {
    private RacunovodstvoKorisnickiRacuniJPanel racunovodstvoKorisnickiRacuniJPanel;

    public RacunovodstvoKorisnickiRacuniController(RacunovodstvoKorisnickiRacuniJPanel racunovodstvoKorisnickiRacuniJPanel) {
        this.racunovodstvoKorisnickiRacuniJPanel = racunovodstvoKorisnickiRacuniJPanel;
    }

    public ItemListener getKorisnickiRacuniTraziJComboBoxItemListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    long idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getSelectedItem()).getId();
                    Baza baza = Baza.getBaza();
                    List<Korisnik> sviKorisnici = baza.dajSve(Korisnik.class);
                    List<Korisnik> obrisaniKorisnici = new ArrayList<Korisnik>();
                    for(Korisnik k : obrisaniKorisnici) {
                        if(k.isObrisano()) {
                            obrisaniKorisnici.add(k);
                        }
                    }
                    sviKorisnici.removeAll(obrisaniKorisnici);
                    racunovodstvoKorisnickiRacuniJPanel.popuniSaPodacima(sviKorisnici, idSelektiranogKorisnika);
                }
            }
        };
    }

    public ActionListener getKorisnickiRacuniObrisiJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                long idSelektiranogKorisnika = 0;
                if (racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getItemCount() > 0) {
                    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getSelectedItem()).getId();
                }

                Baza baza = Baza.getBaza();
                if (idSelektiranogKorisnika > 0) {
                    Korisnik korisnik = baza.dajPoId(Korisnik.class, idSelektiranogKorisnika);
                    korisnik.setObrisano(true);
                }

                // Uzmi id prvog korisnika kojem je zastavica "obrisan" false
                List<Korisnik> sviKorisnici = baza.dajSve(Korisnik.class);
                List<Korisnik> obrisaniKorisnici = new ArrayList<Korisnik>();
                for(Korisnik k : sviKorisnici) {
                    if(k.isObrisano()) {
                        obrisaniKorisnici.add(k);
                    }
                }
                sviKorisnici.removeAll(obrisaniKorisnici);
                long idPrvogNeobrisanogKorisnika = 0;
                if (sviKorisnici.size() > 0) {
                    for(Korisnik k : sviKorisnici) {
                            idPrvogNeobrisanogKorisnika = k.getId();
                    }
                }

                if(idPrvogNeobrisanogKorisnika > 0) {
                    racunovodstvoKorisnickiRacuniJPanel.popuniSaPodacima(sviKorisnici, idPrvogNeobrisanogKorisnika);
                }
            }
        };
    }

    public ActionListener getKorisnickiRacuniDodajJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Korisnik noviKorisnik = racunovodstvoKorisnickiRacuniJPanel.dajPodatkeONovomKorisniku();
                Baza baza = Baza.getBaza();
                baza.spasiUBazu(noviKorisnik);
            }
        };
    }

    public ActionListener getKorisnickiRacuniPrepraviJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                long idSelektiranogKorisnika = 0;
                if (racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getItemCount() > 0) {
                    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getSelectedItem()).getId();
                }
                Korisnik noviKorisnik = racunovodstvoKorisnickiRacuniJPanel.dajPodatkeONovomKorisniku();
                if (idSelektiranogKorisnika > 0) {
                    noviKorisnik.setId(idSelektiranogKorisnika);
                    Baza baza = Baza.getBaza();
                    baza.azuriraj(noviKorisnik);
                } else {
                    JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(),
                            "Ne može se ažurirati korisnik. Nema selektiranih korisnika.");
                }
            }
        };
    }
}
