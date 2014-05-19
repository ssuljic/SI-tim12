package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Dostava {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String naziv;
    private boolean jeIsporuceno;
    @Temporal(TemporalType.DATE)
    private Date datum;
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    private Klijent klijent;
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    private Korisnik preuzeo;
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Collection<PecivoUDostavi> peciva;

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

    public boolean isJeIsporuceno() {
        return jeIsporuceno;
    }

    public void setJeIsporuceno(boolean jeIsporuceno) {
        this.jeIsporuceno = jeIsporuceno;
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

    public Korisnik getPreuzeo() {
        return preuzeo;
    }

    public void setPreuzeo(Korisnik preuzeo) {
        this.preuzeo = preuzeo;
    }

    public Collection<PecivoUDostavi> getPeciva() {
        return peciva;
    }

    public void setPeciva(Collection<PecivoUDostavi> peciva) {
        this.peciva = peciva;
    }
}
