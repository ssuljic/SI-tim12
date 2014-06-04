package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Pecivo {
    @GeneratedValue
    @Id
    private long id;
    private boolean obrisano = false;
    private String sifra;
    private String naziv;
    private double tezina;
    private double cijena;
    private boolean jeUProdaji;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pecivo")
    private Collection<PecivoUDostavi> pecivaUDostavi;

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

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public boolean isJeUProdaji() {
        return jeUProdaji;
    }

    public void setJeUProdaji(boolean jeUProdaji) {
        this.jeUProdaji = jeUProdaji;
    }

    public Collection<PecivoUDostavi> getPecivaUDostavi() {
        return pecivaUDostavi;
    }

    public void setPecivaUDostavi(Collection<PecivoUDostavi> pecivaUDostavi) {
        this.pecivaUDostavi = pecivaUDostavi;
    }
}
