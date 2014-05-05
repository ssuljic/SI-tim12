package bakersoft.bakersoft_prototype.models;

/**
 * Created by eturkovic on 5/4/2014.
 */
public class PreuzetoPecivo {
    private long id;
    private Pecivo pecivo;
    private double kolicinaPreuzetogPeciva;
    private double kolicinaVracenogPeciva;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Pecivo getPecivo() {
		return pecivo;
	}
	public void setPecivo(Pecivo pecivo) {
		this.pecivo = pecivo;
	}
	public double getKolicinaPreuzetogPeciva() {
		return kolicinaPreuzetogPeciva;
	}
	public void setKolicinaPreuzetogPeciva(double kolicinaPreuzetogPeciva) {
		this.kolicinaPreuzetogPeciva = kolicinaPreuzetogPeciva;
	}
	public double getKolicinaVracenogPeciva() {
		return kolicinaVracenogPeciva;
	}
	public void setKolicinaVracenogPeciva(double kolicinaVracenogPeciva) {
		this.kolicinaVracenogPeciva = kolicinaVracenogPeciva;
	}
}
