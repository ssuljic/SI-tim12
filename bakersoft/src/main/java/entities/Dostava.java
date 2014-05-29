package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Dostava {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private boolean obrisano = false;
    private String naziv;
    private boolean jeIsporuceno;
    @Temporal(TemporalType.DATE)
    private Date datum;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Klijent klijent;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Korisnik preuzeo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "dostava")
    private Collection<PecivoUDostavi> peciva;

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
