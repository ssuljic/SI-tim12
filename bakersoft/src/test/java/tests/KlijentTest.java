package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Klijent;

public class KlijentTest {
	
	//Kapiram da je re�eno da se ne testiraju getteri i setteri, ali ovi su bitni jer je validacija 
	//sadr�ana u njima, tj u ova dva xD ... samo �emo testirat nepravilan unos
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIme() {
		Klijent k = new Klijent();
		k.setIme("");//prazan string poku�avamo
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTelefon() {
		Klijent k = new Klijent();
		k.setTelefon("");//prazan string poku�avamo
	}

}
