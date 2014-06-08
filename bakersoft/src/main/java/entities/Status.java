package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Status {
    public static final String ZAPOSLEN = "Zaposlen";
    public static final String NEZAPOSLEN = "Nezaposlen";

    @GeneratedValue
    @Id
    private long id;

    private String status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "status")
    private Collection<Korisnik> korisnici;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Collection<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
}
