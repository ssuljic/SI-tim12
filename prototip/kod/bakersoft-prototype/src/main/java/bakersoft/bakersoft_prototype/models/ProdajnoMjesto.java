package bakersoft.bakersoft_prototype.models;

/**
 * Created by eturkovic on 5/4/2014.
 */
public class ProdajnoMjesto {
    private long id;
    private String mjesto;
    private Adresa adresa;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMjesto() {
		return mjesto;
	}
	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
}
