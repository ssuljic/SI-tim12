package bakersoft.bakersoft_prototype.models;

/**
 * Created by eturkovic on 5/4/2014.
 */
public class Adresa {
    private long id;
    private String drzava;
    private String grad;
    private int postanskiBroj;
    private String ulica;
    private int brojUlice;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public int getBrojUlice() {
		return brojUlice;
	}
	public void setBrojUlice(int brojUlice) {
		this.brojUlice = brojUlice;
	}
}
