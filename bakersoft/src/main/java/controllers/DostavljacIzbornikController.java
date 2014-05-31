package controllers;

import views.DostavljacJFrame;
import views.DostavljacPotvrdaDostaveJPanel;

import javax.swing.*;

import java.awt.event.*;

public class DostavljacIzbornikController {
    private DostavljacJFrame dostavljacJFrame;

    public DostavljacIzbornikController(DostavljacJFrame dostavljacJFrame) {
        super();
        this.dostavljacJFrame = dostavljacJFrame;
    }

    public WindowListener getZatvorenJFrameActionListener() {
        return new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dostavljacJFrame.setVisible(false);
                JFrame pozivaocJForm = dostavljacJFrame.getPozivaocJFrame();
                if (pozivaocJForm != null) {
                    dostavljacJFrame.getPozivaocJFrame().setVisible(true);
                }

                dostavljacJFrame.dispose();
            }
        };
    }

    public ActionListener getIzbornikPreuzimanjePecivaJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dostavljacJFrame.postaviPreuzimanjePecivaJPanel();
            }
        };
    }

    public ActionListener getIzbornikPotvrdaDostaveJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dostavljacJFrame.postaviPotvrdaDostaveJPanel();
            }
        };
    }

    public ActionListener getIzbornikOdjavaJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dostavljacJFrame.setVisible(false);
                JFrame pozivaocJForm = dostavljacJFrame.getPozivaocJFrame();
                if (pozivaocJForm != null) {
                    dostavljacJFrame.getPozivaocJFrame().setVisible(true);
                }

                dostavljacJFrame.dispose();
            }
        };
    }
}
