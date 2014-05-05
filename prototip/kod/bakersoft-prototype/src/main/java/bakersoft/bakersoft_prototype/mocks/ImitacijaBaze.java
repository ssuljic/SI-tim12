package bakersoft.bakersoft_prototype.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bakersoft.bakersoft_prototype.models.Adresa;
import bakersoft.bakersoft_prototype.models.Korisnik;
import bakersoft.bakersoft_prototype.models.Status;
import bakersoft.bakersoft_prototype.models.Tip;

public class ImitacijaBaze {
	
	private List<Adresa> adrese;
	private List<Korisnik> korisnici;
	
	public ImitacijaBaze() {
		super();
		kreirajAdrese();
		kreirajKorisnike();
		
	}

	public void kreirajAdrese() {
		Adresa adresa1 = new Adresa();
		adresa1.setId(1);
		adresa1.setDrzava("BiH");
		adresa1.setGrad("Sarajevo");
		adresa1.setPostanskiBroj(71000);
		adresa1.setUlica("Titova");
		adresa1.setBrojUlice(20);
		
		Adresa adresa2 = new Adresa();
		adresa2.setId(2);
		adresa2.setDrzava("BiH");
		adresa2.setGrad("Travnik");
		adresa2.setPostanskiBroj(72270);
		adresa2.setUlica("Bosanska");
		adresa2.setBrojUlice(2);
		
		adrese = new ArrayList<Adresa>();
		adrese.add(adresa1);
		adrese.add(adresa2);
	}
	
	public void kreirajKorisnike() {
		Korisnik korisnik1 = new Korisnik();
		korisnik1.setAdresa(adrese.get(0));
		korisnik1.setBrojMobitela("062333222");
		korisnik1.setBrojTelefona("033282121");
		korisnik1.setDatumRodjenja(new Date(1984, 5, 14));
		korisnik1.setEmail("mujo.mujkic@email.com");
		korisnik1.setId(1);
		korisnik1.setIme("Mujo");
		korisnik1.setLozinka("mujinaLozinka");
		korisnik1.setPrezime("Mujkic");
		korisnik1.setStatus(Status.AKTIVAN);
		korisnik1.setTip(Tip.DOSTAVLJAC);
		korisnik1.setKorisnickoIme("mujo");
		
		Korisnik korisnik2 = new Korisnik();
		korisnik2.setAdresa(adrese.get(0));
		korisnik2.setBrojMobitela("0614448888");
		korisnik2.setBrojTelefona("033111111");
		korisnik2.setDatumRodjenja(new Date(1987, 9, 23));
		korisnik2.setEmail("fata.fatunic@email.com");
		korisnik2.setId(2);
		korisnik2.setIme("Fata");
		korisnik2.setLozinka("fatinaLozinka");
		korisnik2.setPrezime("Fatunic");
		korisnik2.setStatus(Status.AKTIVAN);
		korisnik2.setTip(Tip.RACUNOVODJA);
		korisnik2.setKorisnickoIme("fata");
		
		korisnici = new ArrayList<Korisnik>();
		korisnici.add(korisnik1);
		korisnici.add(korisnik2);
	}

	public List<Adresa> getAdrese() {
		return adrese;
	}

	public List<Korisnik> getKorisnici() {
		return korisnici;
	}
}
