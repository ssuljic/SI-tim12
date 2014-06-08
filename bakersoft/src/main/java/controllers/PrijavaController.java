package controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import utilities.PrijavaUtilities;
import views.DostavljacJFrame;
import views.PrijavaJFrame;
import views.RacunovodstvoJFrame;
import entities.Korisnik;
import entities.Tip;

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

        if (!prijavaUtilities.jeKorisnikValidan(korisnickoIme, lozinka)) {
            JOptionPane.showMessageDialog(prijavaJFrame, "Korisnièko ime ili lozinka pogrešno uneseni.");
            return;
        }
		
        Korisnik korisnik = prijavaUtilities.prijavi(korisnickoIme, lozinka);

        if (korisnik.getTip().getTip().equals(Tip.RACUNOVODJA)) {
            pokreniPanelZaRacunovodstvo(korisnik);
        } else if (korisnik.getTip().getTip().equals(Tip.DOSTAVLJAC)) {
           pokreniPanelZaDostavljaca(korisnik);
        }
    }


    private void pokreniPanelZaDostavljaca(Korisnik korisnik) {
        DostavljacJFrame dostavljacJFrame = new DostavljacJFrame(prijavaJFrame);
        dostavljacJFrame.setKorisnik(korisnik);
        dostavljacJFrame.setKorisnik(korisnik);
        prijavaJFrame.setVisible(false);
        dostavljacJFrame.setSize(new Dimension(800, 600));
        dostavljacJFrame.setVisible(true);
    }


    private void pokreniPanelZaRacunovodstvo(Korisnik korisnik) {
        RacunovodstvoJFrame racunovodstvoJFrame = new RacunovodstvoJFrame(prijavaJFrame);
        racunovodstvoJFrame.setKorisnik(korisnik);
        prijavaJFrame.setVisible(false);
        racunovodstvoJFrame.setSize(new Dimension(800, 600));
        racunovodstvoJFrame.setVisible(true);
    }
}
