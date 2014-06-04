package application;

import utilities.InicijalizatorBazeZaTestiranje;
import views.PrijavaJFrame;

import javax.swing.*;

public class BakersoftMain {
    public static void main(String[] args) {
        InicijalizatorBazeZaTestiranje inicijalizatorBazeZaTestiranje = new InicijalizatorBazeZaTestiranje();
        inicijalizatorBazeZaTestiranje.popuniBazuPodacima();
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