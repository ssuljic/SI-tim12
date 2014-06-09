package controllers;

import entities.PecivoUDostavi;
import exceptions.PodaciNisuValidniException;
import views.DostavljacPreuzimanjePecivaJPanel;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class DostavljacPreuzimanjePecivaController {

    private DostavljacPreuzimanjePecivaJPanel dostavljacPreuzimanjePecivaJPanel;

    public DostavljacPreuzimanjePecivaController(DostavljacPreuzimanjePecivaJPanel dostavljacPreuzimanjePecivaJPanel) {
        this.dostavljacPreuzimanjePecivaJPanel = dostavljacPreuzimanjePecivaJPanel;
    }

    public ActionListener getDostavljacPreuzimanjePecivaUkloniPecivoJButton() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PecivoUDostavi pecivo = dostavljacPreuzimanjePecivaJPanel.dajSelektiranoPecivoUDostaviIzPecivaDodanihUDostavu();
                if(dostavljacPreuzimanjePecivaJPanel.dajSvaDodanaPeciva() != null && pecivo != null) {
                    dostavljacPreuzimanjePecivaJPanel.dajSvaDodanaPeciva().remove(pecivo);
                    dostavljacPreuzimanjePecivaJPanel.osvjeziPecivaUDostaviTabelu();
                    dostavljacPreuzimanjePecivaJPanel.osvjeziJPanel();
                }
            }
        };
    }

    public ActionListener getDostavljacPreuzimanjePecivaDodajPecivoJButton() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					dostavljacPreuzimanjePecivaJPanel.validirajPodatke2();
					dostavljacPreuzimanjePecivaJPanel.popuniPecivaUDostaviTabeluSaSelektiranimPecivomIUnesenomKolicinom();
				} catch (Exception e1) {
				    JOptionPane.showMessageDialog(dostavljacPreuzimanjePecivaJPanel.getParent(), e1.getMessage());
				}
            }
        };
    }

    public ActionListener getDostavljacPreuzimanjePecivaPreuzmiDostavuJButton() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					dostavljacPreuzimanjePecivaJPanel.validirajPodatke();
					dostavljacPreuzimanjePecivaJPanel.napraviDostavu();
					JOptionPane.showMessageDialog(dostavljacPreuzimanjePecivaJPanel.getParent(), "Dostava je preuzeta, a potvrditi je mo\u017eete u sekciji Potvrda dostave!");
					dostavljacPreuzimanjePecivaJPanel.osvjeziJPanel2();
				} catch (IllegalArgumentException | PodaciNisuValidniException e1) {
				    JOptionPane.showMessageDialog(dostavljacPreuzimanjePecivaJPanel.getParent(), e1.getMessage());
				}
                
            }
        };
    }
}
