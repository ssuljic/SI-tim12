package bakersoft.bakersoft_prototype.utilities;

import java.util.List;

import bakersoft.bakersoft_prototype.mocks.ImitacijaBaze;
import bakersoft.bakersoft_prototype.models.Korisnik;


/**
 * Created by eturkovic on 5/4/2014.
 */
public class PrijavaUtilities {

	private ImitacijaBaze bazaMock;

	public PrijavaUtilities() {
		super();
		bazaMock = new ImitacijaBaze();
	}

	/**
	 * Za prijavu vrijede sljedeci podaci:
	 * RACUNOVODJA: fata fatinaLozinka
	 * DOSTAVLJAC: mujo mujinaLozinka
	 */
	
	public boolean jeKorisnikValidan(String korisnickoIme, String lozinka) {
		List<Korisnik> korisnici = bazaMock.getKorisnici();
		for(Korisnik k : korisnici) {
			if(k.getKorisnickoIme().equals(korisnickoIme) && k.getLozinka().equals(lozinka)) {
				return true;
			}
		}
		
		return false;
    }

    public Korisnik prijavi(String korisnickoIme, String lozinka) {
    	List<Korisnik> korisnici = bazaMock.getKorisnici();
		for(Korisnik k : korisnici) {
			if(k.getKorisnickoIme().equals(korisnickoIme) && k.getLozinka().equals(lozinka)) {
				return k;
			}
		}
		
		return null;
    }

    public void logout() {
    	// TODO: Ovdje vjerovatno logiranje kada je korisnik odjavljen...
    	throw new UnsupportedOperationException("Not implemented yet");
    }
}
