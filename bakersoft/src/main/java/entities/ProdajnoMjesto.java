package entities;

import javax.persistence.*;

@Entity
public class ProdajnoMjesto {
    @GeneratedValue
    @Id
    private long id;

    private String mjesto;
    private String adresa;
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    private Klijent klijent;

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }
}
