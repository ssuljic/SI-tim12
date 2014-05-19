package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Racun {
    @GeneratedValue
    @Id
    private long id;

    @Temporal(TemporalType.DATE)
    private Date datum;

    private int broj;
    private double iznos;
    private boolean jePlacen;
    @Temporal(TemporalType.DATE)
    private Date pocetak;
    @Temporal(TemporalType.DATE)
    private Date kraj;
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    private Klijent klijent;
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    private Korisnik obracunao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public boolean isJePlacen() {
        return jePlacen;
    }

    public void setJePlacen(boolean jePlacen) {
        this.jePlacen = jePlacen;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Korisnik getObracunao() {
        return obracunao;
    }

    public void setObracunao(Korisnik obracunao) {
        this.obracunao = obracunao;
    }
}
