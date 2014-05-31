package tests;

import static org.junit.Assert.*;
import entities.Klijent;
import entities.Pecivo;
import java.util.ArrayList;
import java.util.Collection;



import java.util.List;

import org.junit.Test;

import utilities.Baza;


public class DostavljacPreuzimanjePecivaJPanelTest {

	@Test 
	// da li su uklonjeni svi obrisani klijenti
	public void UkloniObrisaneKlijenteTest() {
		Baza baza = Baza.getBaza();
        // Uzmi sve klijente iz baze
        List<Klijent> sviKlijenti = baza.dajSve(Klijent.class);
		List obrisaniKlijenti = new ArrayList<Klijent>();
        for(Klijent k : sviKlijenti) {
            if(k.isObrisano()) {
                obrisaniKlijenti.add(k);
            }
        }
        sviKlijenti.removeAll(obrisaniKlijenti);
        obrisaniKlijenti.clear();
        for(Klijent k : sviKlijenti) {
            if(k.isObrisano()) {
                obrisaniKlijenti.add(k);
            }
        }
        

        assertTrue(obrisaniKlijenti.isEmpty());
	}

	@Test
	// da li su uklonjenna obrisana peciva
	public void UkloniObrisanaPecivaIzTest()
	{
		Baza baza = Baza.getBaza();
		List<Pecivo> svaPeciva=baza.dajSve(Pecivo.class);
		List<Pecivo> obrisanaPeciva = new ArrayList<Pecivo>();
        for (Pecivo p : svaPeciva) {
            if (p.isObrisano()) {
                obrisanaPeciva.add(p);
            }
        }
        svaPeciva.removeAll(obrisanaPeciva);
        obrisanaPeciva.clear();
        for(Pecivo p:svaPeciva)
        {
        	if(p.isObrisano())
        	{
        		obrisanaPeciva.add(p);
        	}
        }
        assertTrue(obrisanaPeciva.isEmpty());
	}
	
	
}
