package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Korisnik;
import utilities.Baza;
import views.RacunovodstvoKorisnickiRacuniJPanel;

import java.util.ArrayList;
import java.util.List;

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
	
	
	@Test
	(expected= NullPointerException.class)
	public void testPopuniSaJComboBox()
	{
		RacunovodstvoKorisnickiRacuniJPanel rp=new RacunovodstvoKorisnickiRacuniJPanel();
		rp.pupuniTraziJComboBoxSa(null,50);
	}
	
}
