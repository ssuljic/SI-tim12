package controllers;

import views.DostavljacJFrame;

import javax.swing.*;
import java.awt.event.*;

public class DostavljacController {
    private DostavljacJFrame dostavljacJFrame;

    public DostavljacController(DostavljacJFrame dostavljacJFrame) {
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

    public ActionListener getPotvrdaDostaveDostavaIzvrsenaJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(dostavljacJFrame, "Nije implementirano");
            }
        };
    }

    public ActionListener getPreuzimanjePecivaUkloniPecivoJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(dostavljacJFrame, "Nije implementirano");
            }
        };
    }

    public ActionListener getPreuzimanjePecivaDodajPecivoJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(dostavljacJFrame, "Nije implementirano");
            }
        };
    }

    public ActionListener getPreuzimanjePecivaPreuzmiDostavuJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(dostavljacJFrame, "Nije implementirano");
            }
        };
    }

}
