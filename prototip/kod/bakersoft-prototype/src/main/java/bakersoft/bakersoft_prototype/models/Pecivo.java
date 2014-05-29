package bakersoft.bakersoft_prototype.models;

import java.math.BigDecimal;

/**
 * Created by eturkovic on 5/4/2014.
 */
public class Pecivo {
    private long id;
    private String sifra;
    private String naziv;
    private double tezina;
    private BigDecimal cijena;
    private boolean jeUProdaji;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getTezina() {
		return tezina;
	}
	public void setTezina(double tezina) {
		this.tezina = tezina;
	}
	public BigDecimal getCijena() {
		return cijena;
	}
	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	public boolean isJeUProdaji() {
		return jeUProdaji;
	}
	public void setJeUProdaji(boolean jeUProdaji) {
		this.jeUProdaji = jeUProdaji;
	}
}
