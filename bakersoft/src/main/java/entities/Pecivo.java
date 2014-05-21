package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Pecivo {
    @GeneratedValue
    @Id
    private long id;

    private String sifra;
    private String naziv;
    private String tezina;
    private double cijena;
    private boolean jeUProdaji;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pecivo")
    private Collection<PecivoUDostavi> preuzetaPeciva;

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

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
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

    public Collection<PecivoUDostavi> getPreuzetaPeciva() {
        return preuzetaPeciva;
    }

    public void setPreuzetaPeciva(Collection<PecivoUDostavi> preuzetaPeciva) {
        this.preuzetaPeciva = preuzetaPeciva;
    }
}
