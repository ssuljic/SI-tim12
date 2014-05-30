package controllers;

import entities.PecivoUDostavi;
import views.DostavljacPreuzimanjePecivaJPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                dostavljacPreuzimanjePecivaJPanel.popuniPecivaUDostaviTabeluSaSelektiranimPecivomIUnesenomKolicinom();
            }
        };
    }

    public ActionListener getDostavljacPreuzimanjePecivaPreuzmiDostavuJButton() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dostavljacPreuzimanjePecivaJPanel.napraviDostavu();
            }
        };
    }
}
