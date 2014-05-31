package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Korisnik;
import views.RacunovodstvoKorisnickiRacuniJPanel;

public class RacunovodstvoKorisnickiRacuniJPanelTest {

	@Test
	// provjerava da li vraca podatke o novom korisniku 
	public void testPodaciONovomKorisniku()
	{
		RacunovodstvoKorisnickiRacuniJPanel rp=new RacunovodstvoKorisnickiRacuniJPanel();
		Korisnik korisnik = new Korisnik();
        korisnik.setIme("neki");
        String ocekivano="neki";
        assertEquals(ocekivano , korisnik.getIme() );
        
	}
	

	

	
}
