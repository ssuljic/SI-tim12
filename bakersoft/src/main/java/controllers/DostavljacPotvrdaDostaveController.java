package controllers;

import entities.Dostava;
import utilities.Baza;
import views.DostavljacPotvrdaDostaveJPanel;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DostavljacPotvrdaDostaveController {
    private DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel;

    public DostavljacPotvrdaDostaveController(DostavljacPotvrdaDostaveJPanel dostavljacPotvrdaDostaveJPanel) {
        this.dostavljacPotvrdaDostaveJPanel = dostavljacPotvrdaDostaveJPanel;
    }

    public ListSelectionListener getDostavljacPotvrdaDostaveDostaveJTableListSelectionListener() {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    Baza baza = Baza.getBaza();
                    Dostava selektiranaDostava = dostavljacPotvrdaDostaveJPanel.dajSelektiranuDostavu();
                    if(selektiranaDostava!=null) {
                        long idSelektiraneDostave = selektiranaDostava.getId();
                        dostavljacPotvrdaDostaveJPanel.popuniSaPodacima(idSelektiraneDostave);
                    }
                }
            }
        };
    }

    public ListSelectionListener getDostavaljacPotvrdaDostavePecivaUDostaviJTableListSelectionListener() {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){

                }
            }
        };
    }
  

    public ActionListener getDostavljacPotvrdaDostaveDostavaIzvrsenaActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
          try{
                Baza baza = Baza.getBaza();
                Dostava dostava = dostavljacPotvrdaDostaveJPanel.dajSelektiranuDostavu();
                dostava.setJeIsporuceno(true);
                baza.azuriraj(dostava);
                dostavljacPotvrdaDostaveJPanel.popuniSaSvimPodacimaIzBaze(0);
                JOptionPane.showMessageDialog(dostavljacPotvrdaDostaveJPanel.getParent(), "Uspje\u0161no ste potvrdili dostavu.");
          }catch  (NullPointerException e) {
            JOptionPane.showMessageDialog(dostavljacPotvrdaDostaveJPanel.getParent(), "Sve dostave su ve\u0107 potvr\u0111ene.");
   
            }
           }
        };
    }
}
