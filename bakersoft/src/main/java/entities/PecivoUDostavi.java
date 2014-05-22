package entities;

import javax.persistence.*;

/**
 * Created by Eli on 5/22/2014.
 */
@Entity
public class PecivoUDostavi {
    @GeneratedValue
    @Id
    private long id;
    private double kolicinaPreuzetogPeciva;
    private double kolicinaVracenogPeciva;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Pecivo pecivo;

    public Pecivo getPecivo() {
        return pecivo;
    }

    public void setPecivo(Pecivo pecivo) {
        this.pecivo = pecivo;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Dostava dostava;

    public Dostava getDostava() {
        return dostava;
    }

    public void setDostava(Dostava dostava) {
        this.dostava = dostava;
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
