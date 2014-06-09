package entities;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Korisnik {
    @GeneratedValue
    @Id
    private long id;
    private boolean obrisano = false;

    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String lozinka;
    private String adresa;
    private String brojMobitela;
    private String brojTelefona;
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "obracunao")
    private Collection<Racun> obracunatiRacuni;
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Tip tip;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "preuzeo")
    private Collection<Dostava> dostave;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isObrisano() {
        return obrisano;
    }

    public void setObrisano(boolean obrisan) {
        this.obrisano = obrisan;
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

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime2) {
    	if(prezime2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Prezime ne mo\u017ee biti prazno.");
    	}
    	else
        this.prezime = prezime2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email2) {
    	if(email2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Email ne mo\u017ee biti prazno.");
    	}
    	else
        this.email = email2;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme2) {
    	if(korisnickoIme2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Korisni\u010dko ime ne mo\u017ee biti prazno.");
    	}
        this.korisnickoIme = korisnickoIme2;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka2) {
    	if(lozinka2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Lozinka ne mo\u017ee biti prazno.");
    	}
        this.lozinka = lozinka2;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa2) {
    	if(adresa2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Adresa ne mo\u017ee biti prazno.");
    	}
        this.adresa = adresa2;
    }

    public String getBrojMobitela() {
        return brojMobitela;
    }

    public void setBrojMobitela(String brojMobitela2) {
    	if(brojMobitela2.isEmpty()) {
    		throw new IllegalArgumentException("Polje Broj mobitela ne mo\u017ee biti prazno.");
    	}
        this.brojMobitela = brojMobitela2;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Collection<Racun> getObracunatiRacuni() {
        return obracunatiRacuni;
    }

    public void setObracunatiRacuni(Collection<Racun> obracunatiRacuni) {
        this.obracunatiRacuni = obracunatiRacuni;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public Collection<Dostava> getDostave() {
        return dostave;
    }

    public void setDostave(Collection<Dostava> dostave) {
        this.dostave = dostave;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brojMobitela='" + brojMobitela + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", obracunatiRacuni=" + obracunatiRacuni +
                ", status=" + status +
                ", tip=" + tip +
                ", dostave=" + dostave +
                '}';
    }
}
