package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.Klijent;
import entities.ProdajnoMjesto;
import utilities.Baza;
import views.RacunovodstvoKlijentiJPanel;

public class RacunovdostvoKlijentiJPanelTest {

	@Test//Provjerava da li metoda èita sve sa forme iz kontrola i vraæa upravo tog klijenta kreiranog
	public void testDajPodatkeONovomKlijentu() {
		RacunovodstvoKlijentiJPanel rp = new RacunovodstvoKlijentiJPanel();
		
		Klijent k = new Klijent();
        rp.getNazivFirmeJTextField().setText("hopa");
        rp.getTelefonJTextField().setText("666-555");
        
        ProdajnoMjesto p = new ProdajnoMjesto();
		rp.getProdajnoMjestoNazivJTextField().setText("neki");
		rp.getProdajnoMjestoAdresaJTextField().setText("neka");
		
		k.setIme(rp.getNazivFirmeJTextField().getText());
        k.setTelefon(rp.getTelefonJTextField().getText());
        
        p.setMjesto(rp.getProdajnoMjestoNazivJTextField().getText());
    	p.setAdresa(rp.getProdajnoMjestoAdresaJTextField().getText());
    	p.setKlijent(k);

        Klijent novi = rp.dajPodatkeONovomKlijentu();

        assertEquals(k.getIme(),novi.getIme());
        assertEquals(k.getTelefon(),novi.getTelefon());
        //...

	}
	

	@Test//Da li metoda èisti gornja dva textfielda
	public void testOcistiGornjiDioPanela() {
		RacunovodstvoKlijentiJPanel rp = new RacunovodstvoKlijentiJPanel();
        rp.getNazivFirmeJTextField().setText("hopa");
        rp.getTelefonJTextField().setText("666-555");
        rp.ocistiGornjiDioPanela();
		assertEquals(rp.getNazivFirmeJTextField().getText(),"");
		assertEquals(rp.getTelefonJTextField().getText(),"");
	}


	@Test//Provjerava da li metoda stvarno oèisti ova dva textfielda
	public void testOcistiDonjiDioPanela() {
		RacunovodstvoKlijentiJPanel rp = new RacunovodstvoKlijentiJPanel();
		
		rp.getProdajnoMjestoNazivJTextField().setText("neki");
		rp.getProdajnoMjestoAdresaJTextField().setText("neka");
		
		rp.ocistiDonjiDioPanela();
		
		assertEquals(rp.getProdajnoMjestoNazivJTextField().getText(),"");
		assertEquals(rp.getProdajnoMjestoAdresaJTextField().getText(),"");

	}
	
	@Test//Da li sakrivanje radi dobro?
	public void testSakrijDugmad() {
		RacunovodstvoKlijentiJPanel rp = new RacunovodstvoKlijentiJPanel();
		
		rp.getDodajProdajnoMjestoJButton().setVisible(true);
        rp.getObrisiProdajnoMjestoJButton().setVisible(true);
        rp.getBtnSljedece().setVisible(true);
        rp.getObrisiKlijentaJButton().setVisible(true);
        
		assertTrue(rp.getDodajProdajnoMjestoJButton().isVisible());
		assertTrue(rp.getObrisiProdajnoMjestoJButton().isVisible());
		assertTrue(rp.getBtnSljedece().isVisible());
		assertTrue(rp.getObrisiKlijentaJButton().isVisible());
		
		rp.sakrijDugmad();
		
		assertFalse(rp.getDodajProdajnoMjestoJButton().isVisible());
		assertFalse(rp.getObrisiProdajnoMjestoJButton().isVisible());
		assertFalse(rp.getBtnSljedece().isVisible());
		assertFalse(rp.getObrisiKlijentaJButton().isVisible());

	}
	
	@Test//Da li prikazivanje ponovo radi? 
	public void testPrikaziDugmad() {
RacunovodstvoKlijentiJPanel rp = new RacunovodstvoKlijentiJPanel();
		
		rp.getDodajProdajnoMjestoJButton().setVisible(false);
        rp.getObrisiProdajnoMjestoJButton().setVisible(false);
        rp.getBtnSljedece().setVisible(false);
        rp.getObrisiKlijentaJButton().setVisible(false);
        
        assertFalse(rp.getDodajProdajnoMjestoJButton().isVisible());
        assertFalse(rp.getObrisiProdajnoMjestoJButton().isVisible());
        assertFalse(rp.getBtnSljedece().isVisible());
        assertFalse(rp.getObrisiKlijentaJButton().isVisible());
		
		rp.prikaziDugmad();
		
		assertTrue(rp.getDodajProdajnoMjestoJButton().isVisible());
		assertTrue(rp.getObrisiProdajnoMjestoJButton().isVisible());
		assertTrue(rp.getBtnSljedece().isVisible());
		assertTrue(rp.getObrisiKlijentaJButton().isVisible());

	}
	
	@Test(expected = exceptions.NePostojiUBaziStavkaSaDatomIdVrijednosti.class)
	public void testPopuniSaPodacima() {
		RacunovodstvoKlijentiJPanel rp = new RacunovodstvoKlijentiJPanel();
		
        Baza baza = Baza.getBaza();
		Klijent k = new Klijent();
        //rp.getNazivFirmeJTextField().setText("hopa");
        rp.getTelefonJTextField().setText("666-555");
        
        k.setIme("hopa");
        k.setTelefon(rp.getTelefonJTextField().getText());
        
        
        ProdajnoMjesto p = new ProdajnoMjesto();
		rp.getProdajnoMjestoNazivJTextField().setText("neki");
		rp.getProdajnoMjestoAdresaJTextField().setText("neka");
		
		p.setMjesto(rp.getProdajnoMjestoNazivJTextField().getText());
    	p.setAdresa(rp.getProdajnoMjestoAdresaJTextField().getText());
    	p.setKlijent(k);
		
    	baza.spasiUBazu(k);
    	
    	List<Klijent> svi = new ArrayList<Klijent>();
    	svi.add(k);
    	long idSelektiranog = 1;
    	
    	rp.popuniSaPodacima(svi, idSelektiranog);
    	
    	assertEquals(rp.getNazivFirmeJTextField().getText(),"hopa");
		
	}
	

}
