package bakersoft.bakersoft_prototype.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bakersoft.bakersoft_prototype.gui.dostava.DostavljacJFrame;
import bakersoft.bakersoft_prototype.gui.prijava.PrijavaJFrame;
import bakersoft.bakersoft_prototype.gui.racunovodstvo.RacunovodstvoJFrame;
import bakersoft.bakersoft_prototype.models.Korisnik;
import bakersoft.bakersoft_prototype.models.Tip;
import bakersoft.bakersoft_prototype.utilities.PrijavaUtilities;

public class PrijavaController implements ActionListener {
	private PrijavaJFrame prijavaJFrame;
	private PrijavaUtilities prijavaUtilities;
	
	
	public PrijavaController(PrijavaJFrame prijavaJFrame) {
		super();
		
		this.prijavaJFrame = prijavaJFrame;
		
		prijavaUtilities = new PrijavaUtilities();
	}



	public void actionPerformed(ActionEvent actionEvent) {
		String korisnickoIme = prijavaJFrame.getPrijavaJPanel().getKorisnickoImeJTextField().getText();
        String lozinka = String.valueOf(prijavaJFrame.getPrijavaJPanel().getLozinkaJPasswordField().getPassword());
        
        if(!prijavaUtilities.jeKorisnikValidan(korisnickoIme, lozinka)) {
        	JOptionPane.showMessageDialog(prijavaJFrame, "Korisnicko ime ili lozinka pogresno unesen.");
        	return;
        }
        
        Korisnik korisnik = prijavaUtilities.prijavi(korisnickoIme, lozinka);
        if(korisnik.getTip() == Tip.RACUNOVODJA) {
        	pokreniPanelZaRacunovodstvo();
        } else if(korisnik.getTip() == Tip.DOSTAVLJAC) {
        	pokreniPanelZaDostavljaca();
        }
	}



	private void pokreniPanelZaDostavljaca() {
		DostavljacJFrame dostavljacJFrame = new DostavljacJFrame(prijavaJFrame);
		prijavaJFrame.setVisible(false);
		dostavljacJFrame.setSize(new Dimension(800, 600));
		dostavljacJFrame.setVisible(true);
	}



	private void pokreniPanelZaRacunovodstvo() {
		RacunovodstvoJFrame racunovodstvoJFrame = new RacunovodstvoJFrame(prijavaJFrame);
		prijavaJFrame.setVisible(false);
		racunovodstvoJFrame.setSize(new Dimension(800, 600));
		racunovodstvoJFrame.setVisible(true);
	}
	
}
