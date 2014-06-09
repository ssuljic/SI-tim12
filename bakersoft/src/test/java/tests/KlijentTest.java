package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Klijent;

public class KlijentTest {
	
	//Kapiram da je receno da se ne testiraju getteri i setteri, ali ovi su bitni jer je validacija 
	//sadrzana u njima, tj u ova dva xD ... samo cemo testirat nepravilan unos 
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIme() {
		Klijent k = new Klijent();
		k.setIme("");//prazan string pokusavamo
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTelefon() {
		Klijent k = new Klijent();
		k.setTelefon("");//prazan string pokusavamo
	}

}
