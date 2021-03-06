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

    public void setIme(String ime2) {
    	if(ime2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Ime ne mo\u017ee biti prazno.");
    	}
    	else
        this.ime = ime2;
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

    public void setTelefon(String telefon2) {
    	if(telefon2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Telefon ne mo\u017ee biti prazno.");
    	}
    	/*else if(!telefon2.matches("^\\d{3}/\\d{3}-\\d{3}$")) {
    		throw new IllegalArgumentException("Telefon nije u pravilnom formatu, pravilan format je xxx/xxx-xxx.");
    	}*/
    	else
        this.telefon = telefon2;

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
