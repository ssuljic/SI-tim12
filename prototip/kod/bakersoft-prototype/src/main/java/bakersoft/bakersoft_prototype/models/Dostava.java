package bakersoft.bakersoft_prototype.models;

import java.util.Date;
import java.util.List;

/**
 * Created by eturkovic on 5/4/2014.
 */
public class Dostava {
    private long id;
    private String naziv;
    private boolean jeIsporucena;
    private List<PreuzetoPecivo> peciva;
    private Date datum;
    private Klijent klijent;
    private Korisnik dostavljac;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public boolean isJeIsporucena() {
		return jeIsporucena;
	}
	public void setJeIsporucena(boolean jeIsporucena) {
		this.jeIsporucena = jeIsporucena;
	}
	public List<PreuzetoPecivo> getPeciva() {
		return peciva;
	}
	public void setPeciva(List<PreuzetoPecivo> peciva) {
		this.peciva = peciva;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	public Korisnik getDostavljac() {
		return dostavljac;
	}
	public void setDostavljac(Korisnik dostavljac) {
		this.dostavljac = dostavljac;
	}
}
