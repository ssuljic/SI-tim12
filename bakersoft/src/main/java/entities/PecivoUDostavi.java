package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class PecivoUDostavi {
    @GeneratedValue
    @Id
    private long id;

    private double kolicinaPreuzetog;
    private double kolicinaDostavljenog;
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, mappedBy = "peciva")
    private Collection<Dostava> dostave;
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    private Pecivo pecivo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getKolicinaPreuzetog() {
        return kolicinaPreuzetog;
    }

    public void setKolicinaPreuzetog(double kolicinaPreuzetog) {
        this.kolicinaPreuzetog = kolicinaPreuzetog;
    }

    public double getKolicinaDostavljenog() {
        return kolicinaDostavljenog;
    }

    public void setKolicinaDostavljenog(double kolicinaDostavljenog) {
        this.kolicinaDostavljenog = kolicinaDostavljenog;
    }

    public Collection<Dostava> getDostave() {
        return dostave;
    }

    public void setDostave(Collection<Dostava> dostave) {
        this.dostave = dostave;
    }

    public Pecivo getPecivo() {
        return pecivo;
    }

    public void setPecivo(Pecivo pecivo) {
        this.pecivo = pecivo;
    }
}
