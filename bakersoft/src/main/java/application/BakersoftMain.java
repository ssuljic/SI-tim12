package application;

import java.util.List;

import utilities.Baza;
import utilities.InicijalizatorBazeZaTestiranje;
import views.PrijavaJFrame;

import javax.swing.*;

import entities.Tip;

public class BakersoftMain {
    public static void main(String[] args) {
    	Baza baza = Baza.getBaza();
        List<Tip> sviTipovi = baza.dajSve(Tip.class);
        if(sviTipovi.size()<=0) {
        	InicijalizatorBazeZaTestiranje inicijalizatorBazeZaTestiranje = new InicijalizatorBazeZaTestiranje();
            inicijalizatorBazeZaTestiranje.popuniBazuPodacima();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        PrijavaJFrame prijavaJFrame = new PrijavaJFrame();
        prijavaJFrame.setBounds(100, 100, 500, 530);
        prijavaJFrame.setVisible(true);
    }
}