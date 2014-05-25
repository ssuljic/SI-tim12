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
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
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

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojMobitela() {
        return brojMobitela;
    }

    public void setBrojMobitela(String brojMobitela) {
        this.brojMobitela = brojMobitela;
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
