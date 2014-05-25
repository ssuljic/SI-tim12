package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Klijent {
    @GeneratedValue
    @Id
    private long id;
    private boolean obrisano = false;
    private String ime;
    @Temporal(TemporalType.DATE)
    private Date datum;
    private String telefon;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "klijent")
    private Collection<ProdajnoMjesto> prodajnaMjesta;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "klijent")
    private Collection<Racun> racuni;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "klijent")
    private Collection<Dostava> dostave;

    public boolean isObrisano() {
        return obrisano;
    }

    public void setObrisano(boolean obrisan) {
        this.obrisano = obrisan;
    }

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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Collection<ProdajnoMjesto> getProdajnaMjesta() {
        return prodajnaMjesta;
    }

    public void setProdajnaMjesta(Collection<ProdajnoMjesto> prodajnaMjesta) {
        this.prodajnaMjesta = prodajnaMjesta;
    }

    public Collection<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(Collection<Racun> racuni) {
        this.racuni = racuni;
    }

    public Collection<Dostava> getDostave() {
        return dostave;
    }

    public void setDostave(Collection<Dostava> dostave) {
        this.dostave = dostave;
    }
}
