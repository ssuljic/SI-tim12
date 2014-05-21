package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Tip {
    public static final String RACUNOVODJA = "Racunovodstvo";
    public static final String DOSTAVLJAC = "Dostavljac";


    @GeneratedValue
    @Id
    private long id;

    private String tip;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tip")
    private Collection<Korisnik> korisnici;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Collection<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Collection<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
}
