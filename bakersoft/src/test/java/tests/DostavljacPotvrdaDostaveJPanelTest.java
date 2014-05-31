package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import exceptions.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import junit.framework.Assert;
import views.DostavljacPotvrdaDostaveJPanel;
import entities.Klijent;
import entities.Dostava;
import entities.Korisnik;
import entities.PecivoUDostavi;
import utilities.Baza;
import utilities.GuiUtilities;

import org.junit.Test;

public class DostavljacPotvrdaDostaveJPanelTest {

	@Test //da li su uklonjene sve isporucene dostave
	public void TestUkloniSveIsporuceneDostaveIz() {
		DostavljacPotvrdaDostaveJPanel dpd = new DostavljacPotvrdaDostaveJPanel();
		Baza baza = Baza.getBaza();
		List<Dostava> isporuceneDostave = baza.dajSve(Dostava.class);
		for (Dostava d : isporuceneDostave) {
	        if (d.isJeIsporuceno()) {
	            isporuceneDostave.add(d);
	        }
	    }
		isporuceneDostave.removeAll(isporuceneDostave);
		assertTrue(isporuceneDostave.isEmpty());
	}
	@Test //da li su obrisana peciva u dostavi 
	public void TestUkloniObrisanaPecivaUDostavi() {
		DostavljacPotvrdaDostaveJPanel dpd = new DostavljacPotvrdaDostaveJPanel();
		Baza baza = Baza.getBaza();
		List<PecivoUDostavi> pecivaUDostavi = baza.dajSve(PecivoUDostavi.class);
        List<PecivoUDostavi> obrisanaPecivaUDostavi = new ArrayList<PecivoUDostavi>();
		for (PecivoUDostavi pud : pecivaUDostavi) {
	        if (pud.isObrisano()) {
	        	obrisanaPecivaUDostavi.add(pud);
	        }
	    }
		pecivaUDostavi.removeAll(obrisanaPecivaUDostavi);
		assertTrue(pecivaUDostavi.isEmpty());
	}
	
	
	@Test(expected = NullPointerException.class)
	 public void TestIndexaPopuniSaPodacima() {
		DostavljacPotvrdaDostaveJPanel dpd = new DostavljacPotvrdaDostaveJPanel();
	//	Baza baza = Baza.getBaza();
	//	List<Dostava> _dostave = baza.dajSve(Dostava.class);
		dpd.popuniSaPodacima(18);
	}
	
	@Test //da li su uklonjene dostave koje ne isporucuje korisnik
	public void TestUkloniSveDostaveKojeNeIsporucujeKorisnik() {
		DostavljacPotvrdaDostaveJPanel dpd = new DostavljacPotvrdaDostaveJPanel();
		Baza baza = Baza.getBaza();
		List<Dostava> _dostave = baza.dajSve(Dostava.class);
        List<Dostava> dostaveZaObrisati = new ArrayList<Dostava>();
		Korisnik dostavljac = new Korisnik();
		dostavljac.setAdresa("adresa");
		dostavljac.setBrojMobitela("030225883");
		dostavljac.setId(1);
		dostavljac.setIme("Edin");
		dostavljac.setPrezime("Basara");
		for (Dostava d : _dostave) {
	        if (d.getPreuzeo().getId() != dostavljac.getId()) {
                dostaveZaObrisati.add(d);

	        }
	    }
		_dostave.removeAll(dostaveZaObrisati);
		assertTrue(_dostave.isEmpty());
	}
	
}

