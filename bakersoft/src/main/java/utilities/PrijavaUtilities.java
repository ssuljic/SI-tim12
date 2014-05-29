package utilities;

import entities.Korisnik;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class PrijavaUtilities {
    private Baza baza;
    private List<Korisnik> korisnici;

    public PrijavaUtilities() {
        baza = Baza.getBaza();
        korisnici = baza.dajSve(Korisnik.class);
    }

    /**
     * Za prijavu vrijede sljedeci podaci:
     * RACUNOVODJA: fata fatinaLozinka
     * DOSTAVLJAC: mujo mujinaLozinka
     */

    public boolean jeKorisnikValidan(String korisnickoIme, String lozinka) {
        if (korisnici.size() > 0) {
            for (Korisnik korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equals(korisnickoIme) &&
                        korisnik.getLozinka().equals(lozinka)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Korisnik prijavi(String korisnickoIme, String lozinka) {
        if (korisnici.size() > 0) {
            for (Korisnik korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equals(korisnickoIme) &&
                        korisnik.getLozinka().equals(lozinka)) {
                    return korisnik;
                }
            }
        }

        return null;
    }

    public void logout() {
        // TODO: Ovdje vjerovatno logiranje kada je korisnik odjavljen...
        throw new NotImplementedException();
    }
}
