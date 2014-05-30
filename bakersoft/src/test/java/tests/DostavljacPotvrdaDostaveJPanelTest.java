package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.table.DefaultTableModel;

import junit.framework.Assert;
import views.DostavljacPotvrdaDostaveJPanel;
import entities.Klijent;
import entities.Dostava;
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
}

