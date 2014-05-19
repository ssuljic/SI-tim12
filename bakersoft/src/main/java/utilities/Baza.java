package utilities;

import entities.Korisnik;
import entities.Status;
import entities.Tip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Baza {
    private static Baza baza = null;
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;
    public final String NAZIV_PERZISTENTNE_JEDINICE = "bakersoftPersistenceUnit";

    private Baza() {
        factory = Persistence.createEntityManagerFactory(NAZIV_PERZISTENTNE_JEDINICE);
        entityManager = factory.createEntityManager();
    }

    public static synchronized Baza getBaza() {
        if (baza == null) {
            baza = new Baza();
        }

        return baza;
    }

    public EntityManager otvoriKonekcijuPremaBazi() {
        return entityManager;
    }

    public void zatvoriKonekcijuPremaBazi() {
        entityManager.close();
    }

    public void zatvoriBazu() {
        factory.close();
    }

    public List<Korisnik> dajSveKorisnike() {
        Query query = entityManager.createQuery("SELECT k FROM Korisnik k");
        List<Korisnik> sviKorisnici = query.getResultList();
        return sviKorisnici;
    }

    public void obrisiKorisnikaIzBaze(long idSelektiranogKorisnika) {
        Korisnik korisnik = entityManager.find(Korisnik.class, idSelektiranogKorisnika);
        entityManager.getTransaction().begin();
        entityManager.remove(korisnik);
        entityManager.getTransaction().commit();
    }

    public void spasiTipKorisnika(Tip tipKorisnika) {
        entityManager.getTransaction().begin();
        entityManager.persist(tipKorisnika);
        entityManager.getTransaction().commit();
    }

    public void spasiStatusKorisnika(Status statusKorisnika) {
        entityManager.getTransaction().begin();
        entityManager.persist(statusKorisnika);
        entityManager.getTransaction().commit();
    }

    public void spasiKorisnika(Korisnik korisnik) {
        entityManager.getTransaction().begin();
        entityManager.persist(korisnik);
        entityManager.getTransaction().commit();
    }

    public List<Tip> dajSveTipoveKorisnika() {
        Query query = entityManager.createQuery("SELECT t FROM Tip t");
        List<Tip> sviTipoviKorisnika = query.getResultList();
        return sviTipoviKorisnika;
    }

    public List<Status> getSviStatusiKorisnika() {
        Query query = entityManager.createQuery("SELECT s FROM Status s");
        List<Status> sviStatusiKorisnika = query.getResultList();
        return sviStatusiKorisnika;
    }

    public Status getStatusKorisnika(long id) {
        Status status = entityManager.find(Status.class, id);
        return status;
    }

    public Tip getTipKorisnika(long id) {
        Tip tip = entityManager.find(Tip.class, id);
        return tip;
    }
}
