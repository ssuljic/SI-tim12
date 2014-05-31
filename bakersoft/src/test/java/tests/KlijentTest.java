package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Klijent;

public class KlijentTest {
	
	//Kapiram da je reèeno da se ne testiraju getteri i setteri, ali ovi su bitni jer je validacija 
	//sadržana u njima, tj u ova dva xD ... samo æemo testirat nepravilan unos
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIme() {
		Klijent k = new Klijent();
		k.setIme("");//prazan string pokušavamo
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTelefon() {
		Klijent k = new Klijent();
		k.setTelefon("");//prazan string pokušavamo
	}

}
