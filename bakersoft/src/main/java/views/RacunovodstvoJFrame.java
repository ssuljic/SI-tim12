package views;

import controllers.RacunovodstvoController;
import entities.Korisnik;
import utilities.Baza;

import javax.swing.*;
import java.awt.*;

public class RacunovodstvoJFrame extends JFrame {

    private JFrame pozivaocJFrame;

    private JPanel contentPane;
    private RacunovodstvoIzbornikJPanel racunovodstvoIzbornikJPanel;
    private RacunovodstvoKorisnickiRacuniJPanel racunovodstvoKorisnickiRacuniJPanel;
    private RacunovodstvoKlijentiJPanel racunovodstvoKlijentiJPanel;
    private RacunovodstvoObracunavanjeJPanel racunovodstvoObracunavanjeJPanel;
    private RacunovodstvoSpaseniObracuniJPanel racunovodstvoSpaseniObracuniJPanel;
    private RacunovodstvoEvidencijaPecivaJPanel racunovodstvoEvidencijaPecivaJPanel;

    private Korisnik korisnik;

    /**
     * Create the frame.
     */
    public RacunovodstvoJFrame(JFrame pozivaocJFrame) {
        this.pozivaocJFrame = pozivaocJFrame;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        contentPane.setLayout(borderLayout);
        setContentPane(contentPane);

        racunovodstvoIzbornikJPanel = new RacunovodstvoIzbornikJPanel();
        racunovodstvoKorisnickiRacuniJPanel = new RacunovodstvoKorisnickiRacuniJPanel();
        racunovodstvoKlijentiJPanel = new RacunovodstvoKlijentiJPanel();
        racunovodstvoObracunavanjeJPanel = new RacunovodstvoObracunavanjeJPanel();
        racunovodstvoSpaseniObracuniJPanel = new RacunovodstvoSpaseniObracuniJPanel();
        racunovodstvoEvidencijaPecivaJPanel = new RacunovodstvoEvidencijaPecivaJPanel();

        dodajIzbornik();
        postaviKorisnickiRacuniJPanel();

        dodajListeners();
    }

    public void dodajIzbornik() {
        contentPane.add(racunovodstvoIzbornikJPanel, BorderLayout.WEST);
    }

    public void postaviKorisnickiRacuniJPanel() {
        ukloniPostojecePanele();
        Baza baza = Baza.getBaza();
        java.util.List<Korisnik> sviKorisnici = baza.dajSveKorisnike();
        long idSelektiranogKorisnika = 0;
        if (sviKorisnici.size() > 0) {
            idSelektiranogKorisnika = sviKorisnici.get(0).getId();
        }
        racunovodstvoKorisnickiRacuniJPanel.popuniSaPodacima(sviKorisnici, idSelektiranogKorisnika);
        contentPane.add(racunovodstvoKorisnickiRacuniJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    private void ukloniPostojecePanele() {
        contentPane.remove(racunovodstvoKorisnickiRacuniJPanel);
        contentPane.remove(racunovodstvoKlijentiJPanel);
        contentPane.remove(racunovodstvoObracunavanjeJPanel);
        contentPane.remove(racunovodstvoSpaseniObracuniJPanel);
        contentPane.remove(racunovodstvoEvidencijaPecivaJPanel);
    }

    public void osvjeziFormu() {
        this.validate();
        this.repaint();
    }

    public void postaviKlijentiJPanel() {
        ukloniPostojecePanele();
        contentPane.add(racunovodstvoKlijentiJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    public void postaviObracunavanjeJPanel() {
        ukloniPostojecePanele();
        contentPane.add(racunovodstvoObracunavanjeJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    public void postaviSpaseniObracuniJPanel() {
        ukloniPostojecePanele();
        contentPane.add(racunovodstvoSpaseniObracuniJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    public void postaviEvidencijaPecivaJPanel() {
        ukloniPostojecePanele();
        contentPane.add(racunovodstvoEvidencijaPecivaJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    public void dodajListeners() {
        RacunovodstvoController racunovodstvoController = new RacunovodstvoController(this);

        this.addWindowListener(racunovodstvoController.getZatvorenJFrameActionListener());

        racunovodstvoIzbornikJPanel.getKorisnickiRacuniJButton().addActionListener(racunovodstvoController.getIzbornikKorisnickiRacuniJButtonActionListener());
        racunovodstvoIzbornikJPanel.getKlijentiJButton().addActionListener(racunovodstvoController.getIzbornikKlijentiJButtonActionListener());
        racunovodstvoIzbornikJPanel.getObracunavanjeJButton().addActionListener(racunovodstvoController.getIzbornikObracunavanjeJButtonActionListener());
        racunovodstvoIzbornikJPanel.getSpaseniObracuniJButton().addActionListener(racunovodstvoController.getIzbornikSpaseniObracuniJButtonActionListener());
        racunovodstvoIzbornikJPanel.getEvidencijaPecivaJButton().addActionListener(racunovodstvoController.getIzbornikEvidencijaPecivaJButtonActionListener());
        racunovodstvoIzbornikJPanel.getOdjavaJButton().addActionListener(racunovodstvoController.getIzbornikOdjavaJButtonActionListener());

        racunovodstvoEvidencijaPecivaJPanel.getUkloniPecivoJButton().addActionListener(racunovodstvoController.getEvidencijaPecivaUkloniPecivoJButtonActionListener());
        racunovodstvoEvidencijaPecivaJPanel.getDodajPecivoJButton().addActionListener(racunovodstvoController.getEvidencijaPecivaDodajPecivoJButtonActionListener());

        racunovodstvoKlijentiJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getKlijentiObrisiJButtonActionListener());
        racunovodstvoKlijentiJPanel.getDodajJButton().addActionListener(racunovodstvoController.getKlijentiDodajJButtonActionListener());

        /*racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().addActionListener(racunovodstvoController.getKorisnickiRacuniTraziJComboBoxItemListener());
        racunovodstvoKorisnickiRacuniJPanel.getPrivilegijeJComboBox().addActionListener(racunovodstvoController.getKorisnickiRacuniPrivilegijeJComboBoxActionListener());
        racunovodstvoKorisnickiRacuniJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getKorisnickiRacuniObrisiJButtonActionListener());
        racunovodstvoKorisnickiRacuniJPanel.getDodajJButton().addActionListener(racunovodstvoController.getKorisnickiRacuniObrisiJButtonActionListener());*/

        racunovodstvoObracunavanjeJPanel.getObracunZaJComboBox().addActionListener(racunovodstvoController.getObracunavanjeObracunZaJComboBoxActionListener());
        racunovodstvoObracunavanjeJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getObracunavanjeObrisiJButtonActionListener());
        racunovodstvoObracunavanjeJPanel.getDodajJButton().addActionListener(racunovodstvoController.getObracunavanjeDodajJButtonActionListener());

        racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().addActionListener(racunovodstvoController.getSpaseniObracuniObracunZaJComboBoxActionListener());
        racunovodstvoSpaseniObracuniJPanel.getObrisiObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniObracunZaJComboBoxActionListener());
        racunovodstvoSpaseniObracuniJPanel.getNapraviNoviObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniNapraviNoviObracunJButtonActionListener());
        racunovodstvoSpaseniObracuniJPanel.getPosaljiObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniPosaljiObracunJButtonActionListener());
    }

    public JFrame getPozivaocJFrame() {
        return pozivaocJFrame;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
