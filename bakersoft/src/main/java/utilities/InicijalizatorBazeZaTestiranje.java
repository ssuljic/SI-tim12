package utilities;

import entities.Korisnik;
import entities.Status;
import entities.Tip;

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

        // Spasavanje u bazu
        baza.spasiTipKorisnika(tipKorisnika1);
        baza.spasiTipKorisnika(tipKorisnika2);

        baza.spasiStatusKorisnika(statusKorisnika1);
        baza.spasiStatusKorisnika(statusKorisnika2);

        baza.spasiKorisnika(korisnik1);
        baza.spasiKorisnika(korisnik2);
    }
}
