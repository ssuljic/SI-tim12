package utilities;

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

    public <E> List<E> dajSve(Class<E> klasaObjekta) {
        Query zahtjev = entityManager.createQuery("SELECT k FROM " + klasaObjekta.getSimpleName() + " k");
        List<E> sviObjekti = zahtjev.getResultList();
        return sviObjekti;
    }

    public <E> List<E> dajSveNeobrisano(Class<E> klasaObjekta) {
        Query zahtjev = entityManager.createQuery("SELECT k FROM " + klasaObjekta.getSimpleName() + " k WHERE k.obrisano = FALSE");
        List<E> sviNeobrisaniObjekti = zahtjev.getResultList();
        return sviNeobrisaniObjekti;
    }

    public <E> void obrisiIzBaze(Class<E> klasaObjekta, long idObjekta) {
        E objekatKojiSeBrise = entityManager.find(klasaObjekta, idObjekta);
        entityManager.getTransaction().begin();
        entityManager.remove(objekatKojiSeBrise);
        entityManager.getTransaction().commit();
    }

    public <E> void spasiUBazu(E objekat) {
        entityManager.getTransaction().begin();
        entityManager.persist(objekat);
        entityManager.getTransaction().commit();
    }

    public <E> E dajPoId(Class<E> klasaObjekta, long idObjekta) {
        E objekat = entityManager.find(klasaObjekta, idObjekta);
        return objekat;
    }

    public <E> void azuriraj(E objekat) {
        entityManager.getTransaction().begin();
        entityManager.merge(objekat);
        entityManager.getTransaction().commit();
    }
}
