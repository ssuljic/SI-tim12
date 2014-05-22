package controllers;

import utilities.JComboBoxItem;
import views.RacunovodstvoObracunavanjeJPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RacunovodstvoObracunavanjeController {
    private RacunovodstvoObracunavanjeJPanel racunovodstvoObracunavanjeJPanel;

    public RacunovodstvoObracunavanjeController(RacunovodstvoObracunavanjeJPanel racunovodstvoObracunavanjeJPanel) {
        this.racunovodstvoObracunavanjeJPanel = racunovodstvoObracunavanjeJPanel;
    }

    public ItemListener getRacunovodstvoObracunZaJComboBoxItemListener() {
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
/*
    public ActionListener getKorisnickiRacuniObrisiJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                long idSelektiranogKorisnika = 0;
                if (racunovodstvoObracunavanjeJPanel.getTraziJComboBox().getItemCount() > 0) {
                    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoObracunavanjeJPanel.getTraziJComboBox().getSelectedItem()).getId();
                }

                Baza baza = Baza.getBaza();
                if (idSelektiranogKorisnika > 0) {
                    baza.obrisiIzBaze(Korisnik.class, idSelektiranogKorisnika);
                }

                List<Korisnik> sviKorisnici = baza.dajSve(Korisnik.class);
                long idPrvogKorisnika = 0;
                if (sviKorisnici.size() > 0) {
                    idPrvogKorisnika = sviKorisnici.get(0).getId();
                }
                racunovodstvoObracunavanjeJPanel.popuniSaPodacima(sviKorisnici, idPrvogKorisnika);
            }
        };
    }

    public ActionListener getKorisnickiRacuniDodajJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Korisnik noviKorisnik = racunovodstvoObracunavanjeJPanel.dajPodatkeONovomKorisniku();
                Baza baza = Baza.getBaza();
                baza.spasiUBazu(noviKorisnik);
            }
        };
    }

    public ActionListener getKorisnickiRacuniPrepraviJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                long idSelektiranogKorisnika = 0;
                if (racunovodstvoObracunavanjeJPanel.getTraziJComboBox().getItemCount() > 0) {
                    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoObracunavanjeJPanel.getTraziJComboBox().getSelectedItem()).getId();
                }
                Korisnik noviKorisnik = racunovodstvoObracunavanjeJPanel.dajPodatkeONovomKorisniku();
                if (idSelektiranogKorisnika > 0) {
                    noviKorisnik.setId(idSelektiranogKorisnika);
                    Baza baza = Baza.getBaza();
                    baza.azuriraj(noviKorisnik);
                } else {
                    JOptionPane.showMessageDialog(racunovodstvoObracunavanjeJPanel.getParent(),
                            "Ne može se ažurirati korisnik. Nema selektiranih korisnika.");
                }
            }
        };
    }*/
}
