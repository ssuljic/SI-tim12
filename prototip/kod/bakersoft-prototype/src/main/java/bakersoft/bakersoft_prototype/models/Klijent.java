package bakersoft.bakersoft_prototype.models;

import java.util.Date;
import java.util.List;

/**
 * Created by eturkovic on 5/4/2014.
 */
public class Klijent {
    private long id;
    private String ime;
    private Date datum;
    private List<ProdajnoMjesto> prodajnaMjesta;
    private String telefon;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public List<ProdajnoMjesto> getProdajnaMjesta() {
		return prodajnaMjesta;
	}
	public void setProdajnaMjesta(List<ProdajnoMjesto> prodajnaMjesta) {
		this.prodajnaMjesta = prodajnaMjesta;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
    
}
