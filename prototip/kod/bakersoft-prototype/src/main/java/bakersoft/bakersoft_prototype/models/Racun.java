package bakersoft.bakersoft_prototype.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by eturkovic on 5/4/2014.
 */
public class Racun {
    private long id;
    private Date datum;
    private BigDecimal iznos;
    private boolean jePlacen;
    private Klijent klijent;
    private Korisnik obracunavaoc;
    private Date pocetak;
    private Date kraj;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public BigDecimal getIznos() {
		return iznos;
	}
	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}
	public boolean isJePlacen() {
		return jePlacen;
	}
	public void setJePlacen(boolean jePlacen) {
		this.jePlacen = jePlacen;
	}
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	public Korisnik getObracunavaoc() {
		return obracunavaoc;
	}
	public void setObracunavaoc(Korisnik obracunavaoc) {
		this.obracunavaoc = obracunavaoc;
	}
	public Date getPocetak() {
		return pocetak;
	}
	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}
	public Date getKraj() {
		return kraj;
	}
	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}
}
