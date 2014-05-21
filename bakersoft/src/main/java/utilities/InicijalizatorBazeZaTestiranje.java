package utilities;

import entities.*;

import java.util.Date;

// TODO: Obrisati ovu klasu kada se zavrsi sa developmentom i izbaciti njeno pozivanje u main-u
public class InicijalizatorBazeZaTestiranje {
    public void popuniBazuPodacima() {
        Baza baza = Baza.getBaza();

        // Tipovi korisnika
        Tip tipKorisnika1 = new Tip();
        tipKorisnika1.setTip(Tip.RACUNOVODJA);
        Tip tipKorisnika2 = new Tip();
        tipKorisnika2.setTip(Tip.DOSTAVLJAC);

        // Statusi korisnika
        Status statusKorisnika1 = new Status();
        statusKorisnika1.setStatus(Status.ZAPOSLEN);
        Status statusKorisnika2 = new Status();
        statusKorisnika2.setStatus(Status.NEZAPOSLEN);

        // Korisnici
        Korisnik korisnik1 = new Korisnik();
        korisnik1.setIme("Mujo");
        korisnik1.setPrezime("Mujkic");
        korisnik1.setBrojMobitela("061-222-333");
        korisnik1.setBrojTelefona("033-234-345");
        korisnik1.setDatumRodjenja(new Date(1987, 9, 12));
        korisnik1.setKorisnickoIme("mujo");
        korisnik1.setLozinka("mujinaLozinka");
        korisnik1.setEmail("mujo.mujkic@hotmail.com");
        korisnik1.setAdresa("Titova 11");
        korisnik1.setTip(tipKorisnika2);
        korisnik1.setStatus(statusKorisnika1);
        Korisnik korisnik2 = new Korisnik();
        korisnik2.setIme("Fata");
        korisnik2.setPrezime("Fatimovic");
        korisnik2.setBrojMobitela("061-456-958");
        korisnik2.setBrojTelefona("033-234-345");
        korisnik2.setDatumRodjenja(new Date(1989, 6, 25));
        korisnik2.setKorisnickoIme("fata");
        korisnik2.setLozinka("fatinaLozinka");
        korisnik2.setEmail("fata.fatimovic@gmail.com");
        korisnik2.setAdresa("Marin Dvor 23");
        korisnik2.setTip(tipKorisnika1);
        korisnik2.setStatus(statusKorisnika1);

        // Klijenti
        Klijent klijent1 = new Klijent();
        klijent1.setIme("Mesnica Kengur");
        klijent1.setTelefon("062/274-040");
        Klijent klijent2 = new Klijent();
        klijent2.setIme("Mesnica Noj");
        klijent2.setTelefon("062/225-883");

        // Racuni
        Racun racun1 = new Racun();
        racun1.setDatum(new Date());
        racun1.setKlijent(klijent1);
        racun1.setObracunao(korisnik2);
        racun1.setPocetak(new Date(1992, 8, 10));
        racun1.setKraj(new Date(1992, 8, 12));
        racun1.setBroj(1234);
        racun1.setJePlacen(true);
        racun1.setIznos(1845);

        // Dostave
        Dostava dostava1 = new Dostava();
        dostava1.setDatum(new Date());
        dostava1.setKlijent(klijent1);
        dostava1.setNaziv("Krofna");
        dostava1.setPreuzeo(korisnik1);
        dostava1.setJeIsporuceno(true);
        
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

        baza.spasiUBazu(dostava1);
    }
}
