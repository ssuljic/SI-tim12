package controllers;

import entities.Korisnik;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoKorisnickiRacuniJPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
                    List<Korisnik> sviKorisnici = baza.dajSveKorisnike();
                    racunovodstvoKorisnickiRacuniJPanel.popuniSaPodacima(sviKorisnici, idSelektiranogKorisnika);
                }
            }
        };
    }

    /*public ActionListener getKorisnickiRacuniPrivilegijeJComboBoxActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), "Nije implementirano");
            }
        };
    }*/

    public ActionListener getKorisnickiRacuniObrisiJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                long idSelektiranogKorisnika = 0;
                if (racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getItemCount() > 0) {
                    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getSelectedItem()).getId();
                }

                Baza baza = Baza.getBaza();
                if (idSelektiranogKorisnika > 0) {
                    baza.obrisiKorisnikaIzBaze(idSelektiranogKorisnika);
                }

                List<Korisnik> sviKorisnici = baza.dajSveKorisnike();
                long idPrvogKorisnika = 0;
                if (sviKorisnici.size() > 0) {
                    idPrvogKorisnika = sviKorisnici.get(0).getId();
                }
                racunovodstvoKorisnickiRacuniJPanel.popuniSaPodacima(sviKorisnici, idPrvogKorisnika);
            }
        };
    }

    public ActionListener getKorisnickiRacuniDodajJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                /*JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), "Nije implementirano");*/
                Korisnik noviKorisnik = racunovodstvoKorisnickiRacuniJPanel.dajPodatkeONovomKorisniku();
                System.out.println(noviKorisnik);
                // TODO: Dovrsiti ovu metodu
                /*if(KorisnikUtilities.suPodaciOKorisnikuValidni(noviKorisnik)) {
                    Baza baza = Baza.getBaza();
                    baza.spasiKorisnika(noviKorisnik);
                } else {
                    JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), "Pogrešni podaci unešeni!");
                }*/
            }
        };
    }
}
