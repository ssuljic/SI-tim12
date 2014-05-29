package controllers;

import views.RacunovodstvoJFrame;

import javax.swing.*;
import java.awt.event.*;

public class RacunovodstvoIzbornikController {
    private RacunovodstvoJFrame racunovodstvoJFrame;

    public RacunovodstvoIzbornikController(RacunovodstvoJFrame racunovodstvoJFrame) {
        super();
        this.racunovodstvoJFrame = racunovodstvoJFrame;
    }

    public WindowListener getZatvorenJFrameActionListener() {
        return new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                racunovodstvoJFrame.setVisible(false);
                JFrame pozivaocJForm = racunovodstvoJFrame.getPozivaocJFrame();
                if (pozivaocJForm != null) {
                    racunovodstvoJFrame.getPozivaocJFrame().setVisible(true);
                }

                racunovodstvoJFrame.dispose();
            }
        };
    }

    public ActionListener getIzbornikKorisnickiRacuniJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                racunovodstvoJFrame.postaviKorisnickiRacuniJPanel();
            }
        };
    }

    public ActionListener getIzbornikKlijentiJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                racunovodstvoJFrame.postaviKlijentiJPanel();
            }
        };
    }

    public ActionListener getIzbornikObracunavanjeJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                racunovodstvoJFrame.postaviObracunavanjeJPanel();
            }
        };
    }

    public ActionListener getIzbornikSpaseniObracuniJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                racunovodstvoJFrame.postaviSpaseniObracuniJPanel();
            }
        };
    }

    public ActionListener getIzbornikEvidencijaPecivaJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                racunovodstvoJFrame.postaviEvidencijaPecivaJPanel();
            }
        };
    }

    public ActionListener getIzbornikOdjavaJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                racunovodstvoJFrame.setVisible(false);
                JFrame pozivaocJForm = racunovodstvoJFrame.getPozivaocJFrame();
                if (pozivaocJForm != null) {
                    racunovodstvoJFrame.getPozivaocJFrame().setVisible(true);
                }

                racunovodstvoJFrame.dispose();
            }
        };
    }
}
