package utilities;

import entities.Korisnik;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class PrijavaUtilities {
    private Baza baza;
    private List<Korisnik> korisnici;

    public PrijavaUtilities() {
        baza = Baza.getBaza();
        korisnici = baza.dajSve(Korisnik.class);
    }

    /**
     * Za prijavu vrijede sljedeci podaci:
     * RACUNOVODJA: fata f
     * DOSTAVLJAC: mujo m
     */

    public boolean jeKorisnikValidan(String korisnickoIme, String lozinka) {
    	HashFunction hashFunkcija = Hashing.md5();
        HashCode hashKodLozinke = hashFunkcija.newHasher().putString(lozinka, Charsets.UTF_8).hash();
        if (korisnici.size() > 0) {
            for (Korisnik korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equals(korisnickoIme) &&
                        korisnik.getLozinka().equals(new String(hashKodLozinke.asBytes()))) {
                    return true;
                }
            }
        }

        return false;
    }

    public Korisnik prijavi(String korisnickoIme, String lozinka) {
    	HashFunction hashFunkcija = Hashing.md5();
        HashCode hashKodLozinke = hashFunkcija.newHasher().putString(lozinka, Charsets.UTF_8).hash();
        if (korisnici.size() > 0) {
            for (Korisnik korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equals(korisnickoIme) &&
                        korisnik.getLozinka().equals(new String(hashKodLozinke.asBytes()))) {
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
