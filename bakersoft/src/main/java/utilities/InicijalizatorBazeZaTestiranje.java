package utilities;

import entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO: Obrisati ovu klasu kada se zavrsi sa developmentom i izbaciti njeno pozivanje u main-u
public class InicijalizatorBazeZaTestiranje {
    public void popuniBazuPodacima() {
        Baza baza = Baza.getBaza();

        Tip tipKorisnika1 = new Tip();
        Tip tipKorisnika2 = new Tip();
        Status statusKorisnika1 = new Status();
        Status statusKorisnika2 = new Status();
        Korisnik korisnik1 = new Korisnik();
        Korisnik korisnik2 = new Korisnik();
        Klijent klijent1 = new Klijent();
        Klijent klijent2 = new Klijent();
        Dostava dostava1 = new Dostava();
        Dostava dostava2 = new Dostava();
        Racun racun1 = new Racun();
        Pecivo pecivo1 = new Pecivo();
        Pecivo pecivo2 = new Pecivo();
        ProdajnoMjesto prodajnoMjesto1 = new ProdajnoMjesto();
        ProdajnoMjesto prodajnoMjesto2 = new ProdajnoMjesto();
        ProdajnoMjesto prodajnoMjesto3 = new ProdajnoMjesto();
        PecivoUDostavi pecivoUDostavi1 = new PecivoUDostavi();
        PecivoUDostavi pecivoUDostavi2 = new PecivoUDostavi();
        PecivoUDostavi pecivoUDostavi11 = new PecivoUDostavi();
        PecivoUDostavi pecivoUDostavi22 = new PecivoUDostavi();

        // Tipovi korisnika
        tipKorisnika1.setTip(Tip.RACUNOVODJA);
        tipKorisnika2.setTip(Tip.DOSTAVLJAC);

        // Statusi korisnika
        statusKorisnika1.setStatus(Status.ZAPOSLEN);
        statusKorisnika2.setStatus(Status.NEZAPOSLEN);

        // Korisnici
        korisnik1.setIme("Mujo");
        korisnik1.setPrezime("Mujkic");
        korisnik1.setBrojMobitela("061-222-333");
        korisnik1.setBrojTelefona("033-234-345");
        korisnik1.setDatumRodjenja(new Date(1987, 9, 12));
        korisnik1.setKorisnickoIme("mujo");
        korisnik1.setLozinka("m");
        korisnik1.setEmail("mujo.mujkic@hotmail.com");
        korisnik1.setAdresa("Titova 11");
        korisnik1.setTip(tipKorisnika2);
        korisnik1.setStatus(statusKorisnika1);
        korisnik1.setDostave(new ArrayList<Dostava>());
        korisnik1.getDostave().add(dostava1);
        korisnik1.getDostave().add(dostava2);
        korisnik1.setObracunatiRacuni(new ArrayList<Racun>());
        korisnik1.getObracunatiRacuni().add(racun1);

        korisnik2.setIme("Fata");
        korisnik2.setPrezime("Fatimovic");
        korisnik2.setBrojMobitela("061-456-958");
        korisnik2.setBrojTelefona("033-234-345");
        korisnik2.setDatumRodjenja(new Date(1989, 6, 25));
        korisnik2.setKorisnickoIme("fata");
        korisnik2.setLozinka("f");
        korisnik2.setEmail("fata.fatimovic@gmail.com");
        korisnik2.setAdresa("Marin Dvor 23");
        korisnik2.setTip(tipKorisnika1);
        korisnik2.setStatus(statusKorisnika1);
        korisnik2.setDostave(new ArrayList<Dostava>());
        korisnik2.setObracunatiRacuni(new ArrayList<Racun>());

        // Klijenti
        klijent1.setIme("Mesnica Kengur");
        klijent1.setTelefon("062/274-040");
        klijent1.setDostave(new ArrayList<Dostava>());
        klijent1.getDostave().add(dostava1);
        klijent1.getDostave().add(dostava2);
        klijent1.setProdajnaMjesta(new ArrayList<ProdajnoMjesto>());
        klijent1.getProdajnaMjesta().add(prodajnoMjesto1);

        klijent2.setIme("Mesnica Noj");
        klijent2.setTelefon("062/225-883");
        klijent2.setProdajnaMjesta(new ArrayList<ProdajnoMjesto>());
        klijent2.setDostave(new ArrayList<Dostava>());

        // Racuni
        racun1.setDatum(new Date());
        racun1.setKlijent(klijent1);
        racun1.setObracunao(korisnik2);
        racun1.setPocetak(new Date(1992, 8, 10));
        racun1.setKraj(new Date(1992, 8, 12));
        racun1.setBroj(1234);
        racun1.setJePlacen(true);
        racun1.setIznos(1845);

        // Peciva
        pecivo1.setNaziv("Kifla");
        pecivo1.setCijena(0.20);
        pecivo1.setJeUProdaji(true);
        pecivo1.setSifra("kifloni-11");
        pecivo1.setTezina(0.05);
        pecivo1.setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
        pecivo1.getPecivaUDostavi().add(pecivoUDostavi1);
        pecivo1.getPecivaUDostavi().add(pecivoUDostavi11);

        pecivo2.setNaziv("Krofna");
        pecivo2.setCijena(1.20);
        pecivo2.setJeUProdaji(true);
        pecivo2.setSifra("krofna-192");
        pecivo2.setTezina(0.2);
        pecivo2.setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
        pecivo2.getPecivaUDostavi().add(pecivoUDostavi22);

        // Peciva u dostavi
        pecivoUDostavi1.setDostava(dostava1);
        pecivoUDostavi1.setPecivo(pecivo1);
        pecivoUDostavi1.setKolicinaPreuzetogPeciva(132.6);
        pecivoUDostavi1.setKolicinaVracenogPeciva(30.3);
        pecivoUDostavi2.setDostava(dostava1);
        pecivoUDostavi2.setPecivo(pecivo2);
        pecivoUDostavi2.setKolicinaPreuzetogPeciva(92.6);
        pecivoUDostavi2.setKolicinaVracenogPeciva(0.0);

        pecivoUDostavi11.setDostava(dostava2);
        pecivoUDostavi11.setPecivo(pecivo1);
        pecivoUDostavi11.setKolicinaPreuzetogPeciva(20.3);
        pecivoUDostavi11.setKolicinaVracenogPeciva(0.0);
        pecivoUDostavi22.setDostava(dostava2);
        pecivoUDostavi22.setPecivo(pecivo2);
        pecivoUDostavi22.setKolicinaPreuzetogPeciva(45.3);
        pecivoUDostavi22.setKolicinaVracenogPeciva(5.0);

        // Dostave
        dostava1.setDatum(new Date());
        dostava1.setKlijent(klijent1);
        dostava1.setNaziv("Dostava krofne i kifle");
        dostava1.setPreuzeo(korisnik1);
        dostava1.setJeIsporuceno(true);
        dostava1.setPeciva(new ArrayList<PecivoUDostavi>());
        dostava1.getPeciva().add(pecivoUDostavi1);
        dostava1.getPeciva().add(pecivoUDostavi2);

        dostava2.setDatum(new Date());
        dostava2.setKlijent(klijent1);
        dostava2.setNaziv("Dostava krofne i kifle 2");
        dostava2.setPreuzeo(korisnik1);
        dostava2.setJeIsporuceno(true);
        dostava2.setPeciva(new ArrayList<PecivoUDostavi>());
        dostava2.getPeciva().add(pecivoUDostavi11);
        dostava2.getPeciva().add(pecivoUDostavi22);

        // Prodajna mjesta
        prodajnoMjesto1.setAdresa("Tunguzija 23");
        prodajnoMjesto1.setKlijent(klijent1);
        prodajnoMjesto1.setMjesto("Sisha han");
        prodajnoMjesto2.setAdresa("Kipar 554");
        prodajnoMjesto2.setKlijent(klijent2);
        prodajnoMjesto2.setMjesto("Tiru liru faktory");
        prodajnoMjesto3.setAdresa("Bam bam 25");
        prodajnoMjesto3.setKlijent(klijent1);
        prodajnoMjesto3.setMjesto("Vispak kinder jaje");

        // Spasavanje u bazu
        baza.spasiUBazu(tipKorisnika1);
        baza.spasiUBazu(tipKorisnika2);

        baza.spasiUBazu(statusKorisnika1);
        baza.spasiUBazu(statusKorisnika2);

        baza.spasiUBazu(korisnik1);
        baza.spasiUBazu(korisnik2);

        baza.spasiUBazu(klijent1);
        baza.spasiUBazu(klijent2);

        baza.spasiUBazu(racun1);

        baza.spasiUBazu(pecivo1);
        baza.spasiUBazu(pecivo2);

        baza.spasiUBazu(pecivoUDostavi1);
        baza.spasiUBazu(pecivoUDostavi2);
        baza.spasiUBazu(pecivoUDostavi11);
        baza.spasiUBazu(pecivoUDostavi22);

        baza.spasiUBazu(prodajnoMjesto1);
        baza.spasiUBazu(prodajnoMjesto2);
        baza.spasiUBazu(prodajnoMjesto3);

        baza.spasiUBazu(dostava1);
    }
}