package views;

import controllers.RacunovodstvoIzbornikController;
import entities.Korisnik;

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
        racunovodstvoKorisnickiRacuniJPanel.popuniSaSvimPodacimaIzBaze(getKorisnik());
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
        racunovodstvoKlijentiJPanel.popuniSaSvimPodacimaIzBaze();
        contentPane.add(racunovodstvoKlijentiJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    public void postaviObracunavanjeJPanel() {
        ukloniPostojecePanele();
        racunovodstvoObracunavanjeJPanel.popuniSaSvimPodacimaIzBaze();
        contentPane.add(racunovodstvoObracunavanjeJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    public void postaviSpaseniObracuniJPanel() {
        ukloniPostojecePanele();
        racunovodstvoSpaseniObracuniJPanel.popuniSaSvimPodacimaIzBaze();
        contentPane.add(racunovodstvoSpaseniObracuniJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    public void postaviEvidencijaPecivaJPanel() {
        ukloniPostojecePanele();
        racunovodstvoEvidencijaPecivaJPanel.popuniSaSvimPodacimaIzBaze();
        contentPane.add(racunovodstvoEvidencijaPecivaJPanel, BorderLayout.CENTER);
        osvjeziFormu();
    }

    public void dodajListeners() {
        RacunovodstvoIzbornikController racunovodstvoIzbornikController = new RacunovodstvoIzbornikController(this);

        this.addWindowListener(racunovodstvoIzbornikController.getZatvorenJFrameActionListener());

        racunovodstvoIzbornikJPanel.getKorisnickiRacuniJButton().addActionListener(racunovodstvoIzbornikController.getIzbornikKorisnickiRacuniJButtonActionListener());
        racunovodstvoIzbornikJPanel.getKlijentiJButton().addActionListener(racunovodstvoIzbornikController.getIzbornikKlijentiJButtonActionListener());
        racunovodstvoIzbornikJPanel.getObracunavanjeJButton().addActionListener(racunovodstvoIzbornikController.getIzbornikObracunavanjeJButtonActionListener());
        racunovodstvoIzbornikJPanel.getSpaseniObracuniJButton().addActionListener(racunovodstvoIzbornikController.getIzbornikSpaseniObracuniJButtonActionListener());
        racunovodstvoIzbornikJPanel.getEvidencijaPecivaJButton().addActionListener(racunovodstvoIzbornikController.getIzbornikEvidencijaPecivaJButtonActionListener());
        racunovodstvoIzbornikJPanel.getOdjavaJButton().addActionListener(racunovodstvoIzbornikController.getIzbornikOdjavaJButtonActionListener());

        /*racunovodstvoEvidencijaPecivaJPanel.getUkloniPecivoJButton().addActionListener(racunovodstvoController.getEvidencijaPecivaUkloniPecivoJButtonActionListener());
        racunovodstvoEvidencijaPecivaJPanel.getDodajPecivoJButton().addActionListener(racunovodstvoController.getEvidencijaPecivaDodajPecivoJButtonActionListener());

        racunovodstvoKlijentiJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getKlijentiObrisiJButtonActionListener());
        racunovodstvoKlijentiJPanel.getDodajJButton().addActionListener(racunovodstvoController.getKlijentiDodajJButtonActionListener());

        racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().addActionListener(racunovodstvoController.getKorisnickiRacuniTraziJComboBoxItemListener());
        racunovodstvoKorisnickiRacuniJPanel.getPrivilegijeJComboBox().addActionListener(racunovodstvoController.getKorisnickiRacuniPrivilegijeJComboBoxActionListener());
        racunovodstvoKorisnickiRacuniJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getKorisnickiRacuniObrisiJButtonActionListener());
        racunovodstvoKorisnickiRacuniJPanel.getDodajJButton().addActionListener(racunovodstvoController.getKorisnickiRacuniObrisiJButtonActionListener());

        racunovodstvoObracunavanjeJPanel.getObracunZaJComboBox().addActionListener(racunovodstvoController.getObracunavanjeObracunZaJComboBoxActionListener());
        racunovodstvoObracunavanjeJPanel.getObrisiJButton().addActionListener(racunovodstvoController.getObracunavanjeObrisiJButtonActionListener());
        racunovodstvoObracunavanjeJPanel.getDodajJButton().addActionListener(racunovodstvoController.getObracunavanjeDodajJButtonActionListener());

        racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().addActionListener(racunovodstvoController.getSpaseniObracuniObracunZaJComboBoxActionListener());
        racunovodstvoSpaseniObracuniJPanel.getObrisiObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniObracunZaJComboBoxActionListener());
        racunovodstvoSpaseniObracuniJPanel.getNapraviNoviObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniNapraviNoviObracunJButtonActionListener());
        racunovodstvoSpaseniObracuniJPanel.getPosaljiObracunJButton().addActionListener(racunovodstvoController.getSpaseniObracuniPosaljiObracunJButtonActionListener());*/
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
