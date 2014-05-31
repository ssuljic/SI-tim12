package entities;

import javax.persistence.*;

@Entity
public class ProdajnoMjesto {
    @GeneratedValue
    @Id
    private long id;
    private boolean obrisano = false;
    private String mjesto;
    private String adresa;
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Klijent klijent;

    public boolean isObrisano() {
        return obrisano;
    }

    public void setObrisano(boolean obrisano) {
        this.obrisano = obrisano;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMjesto() {
    	return mjesto;
    }

    public void setMjesto(String mjesto2) {
    	if(mjesto2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Naziv prodajnog mjesta ne može biti prazno.");
    	}
        this.mjesto = mjesto2;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa2) {
    	if(adresa2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Naziv prodajnog mjesta ne može biti prazno.");
    	}
        this.adresa = adresa2;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }
}
