package controllers;

import entities.Korisnik;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoKorisnickiRacuniJPanel;

import javax.swing.*;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class RacunovodstvoKorisnickiRacuniController {
    private RacunovodstvoKorisnickiRacuniJPanel racunovodstvoKorisnickiRacuniJPanel;
    public int brojKlikova = 0;
    public int brojKlikova2 = 0;
    
    public RacunovodstvoKorisnickiRacuniController(RacunovodstvoKorisnickiRacuniJPanel racunovodstvoKorisnickiRacuniJPanel) {
        this.racunovodstvoKorisnickiRacuniJPanel = racunovodstvoKorisnickiRacuniJPanel;
    }

    public ItemListener getKorisnickiRacuniTraziJComboBoxItemListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    long idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getSelectedItem()).getId();
                    Baza baza = Baza.getBaza();
                    List<Korisnik> sviKorisnici = baza.dajSve(Korisnik.class);
                    List<Korisnik> obrisaniKorisnici = new ArrayList<Korisnik>();
                    for(Korisnik k : obrisaniKorisnici) {
                        if(k.isObrisano()) {
                            obrisaniKorisnici.add(k);
                        }
                    }
                    sviKorisnici.removeAll(obrisaniKorisnici);
                    racunovodstvoKorisnickiRacuniJPanel.popuniSaPodacima(sviKorisnici, idSelektiranogKorisnika);
                }
            }
        };
    }

    public ActionListener getKorisnickiRacuniObrisiJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
					long idSelektiranogKorisnika = 0;
					if (racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getItemCount() > 0) {
					    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getSelectedItem()).getId();
					}

					Baza baza = Baza.getBaza();
					if (idSelektiranogKorisnika > 0) {
					    Korisnik korisnik = baza.dajPoId(Korisnik.class, idSelektiranogKorisnika);
					    Korisnik poredbeni = new Korisnik();
					    poredbeni = racunovodstvoKorisnickiRacuniJPanel.getPrijavljeni();
					    if(poredbeni.getId() == korisnik.getId())
						    throw new IllegalArgumentException("Korisnik kojeg pokušavate obrisati je trenutno prijavljen na sistem, tako da niste u mogućnosti to uraditi.");

					    korisnik.setObrisano(true);
					    JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), "Korisnik "+korisnik.getIme()+" je uspješno obrisan.");
					}

					// Uzmi id prvog korisnika kojem je zastavica "obrisan" false
					List<Korisnik> sviKorisnici = baza.dajSve(Korisnik.class);
					List<Korisnik> obrisaniKorisnici = new ArrayList<Korisnik>();
					for(Korisnik k : sviKorisnici) {
					    if(k.isObrisano()) {
					        obrisaniKorisnici.add(k);
					    }
					}
					sviKorisnici.removeAll(obrisaniKorisnici);
					long idPrvogNeobrisanogKorisnika = 0;
					if (sviKorisnici.size() > 0) {
					    for(Korisnik k : sviKorisnici) {
					            idPrvogNeobrisanogKorisnika = k.getId();
					    }
					}

					if(idPrvogNeobrisanogKorisnika > 0) {
					    racunovodstvoKorisnickiRacuniJPanel.popuniSaPodacima(sviKorisnici, idPrvogNeobrisanogKorisnika);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
				    JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), e.getMessage());
				}
            }
        };
    }
    public boolean validacija()
	{
    	 if(!racunovodstvoKorisnickiRacuniJPanel.getEmailJTextField().getText().matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
 		{

 			JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(),
 			        "Neispravan format e-mail adrese!.");
 			return false;
 		}
    	 else if(!racunovodstvoKorisnickiRacuniJPanel.getTelefonJTextField().getText().matches("\\d{3}/\\d{3}-\\d{3}")){
			JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(),
			        "Neispravan format telefona!.");
			return false;
		}
		
		else if(!racunovodstvoKorisnickiRacuniJPanel.getMobitelJTextField().getText().matches("\\d{3}/\\d{3}-\\d{3}"))
		{
			
			JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(),
			        "Neispravan format mobitela!.");
			return false;
		}
		
		
		
		return true;
	}
    public ActionListener getKorisnickiRacuniDodajJButtonActionListener() {
        return new ActionListener() {
        	
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                	if(brojKlikova2 == 0 && !racunovodstvoKorisnickiRacuniJPanel.getImeJTextField().getText().isEmpty() && !racunovodstvoKorisnickiRacuniJPanel.getKorisnickoImeJTextField().getText().isEmpty()){
                		racunovodstvoKorisnickiRacuniJPanel.ocistiPanel2();
						brojKlikova2=1;
						racunovodstvoKorisnickiRacuniJPanel.sakrijDugmad();
					    JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), "Sada možete unijeti podatke za novog korisnika");
                	}
                	else{
                		if(validacija()!=false)
                		{

                		Korisnik noviKorisnik = racunovodstvoKorisnickiRacuniJPanel.dajPodatkeONovomKorisniku();
    					Baza baza = Baza.getBaza();
    					List<Korisnik> svi = baza.dajSveNeobrisano(Korisnik.class);
	                    for(Korisnik k : svi) {
	                        if(k.getKorisnickoIme().equals(noviKorisnik.getKorisnickoIme())) {
							    throw new IllegalArgumentException("Korisnik sa ovim korisničkim imenom već postoji u bazi, molimo promjenite.");
	                        }
	                    }
    					baza.spasiUBazu(noviKorisnik);
						racunovodstvoKorisnickiRacuniJPanel.prikaziDugmad();
    					JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(),
    					        "Novi korisnik je uspješno dodan.");
						brojKlikova2=0;
                		
						long idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getSelectedItem()).getId();
	                    List<Korisnik> sviKorisnici = baza.dajSve(Korisnik.class);
	                    List<Korisnik> obrisaniKorisnici = new ArrayList<Korisnik>();
	                    for(Korisnik k : obrisaniKorisnici) {
	                        if(k.isObrisano()) {
	                            obrisaniKorisnici.add(k);
	                        }
	                    }
	                    sviKorisnici.removeAll(obrisaniKorisnici);
	                    racunovodstvoKorisnickiRacuniJPanel.popuniSaPodacima(sviKorisnici, idSelektiranogKorisnika);
                		}
                	}
					
				} catch (IllegalArgumentException e) {
				    JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), e.getMessage());
				}
            }
        };
    }

    public ActionListener getKorisnickiRacuniPrepraviJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
					long idSelektiranogKorisnika = 0;
					if (racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getItemCount() > 0) {
					    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoKorisnickiRacuniJPanel.getTraziJComboBox().getSelectedItem()).getId();
					}
					Korisnik noviKorisnik = racunovodstvoKorisnickiRacuniJPanel.dajPodatkeONovomKorisniku();
					if (idSelektiranogKorisnika > 0) {
					    noviKorisnik.setId(idSelektiranogKorisnika);
					    Baza baza = Baza.getBaza();
					    List<Korisnik> svi = baza.dajSveNeobrisano(Korisnik.class);
	                    for(Korisnik k : svi) {
	                        if(k.getKorisnickoIme().equals(noviKorisnik.getKorisnickoIme())) {
							    throw new IllegalArgumentException("Korisnik sa ovim korisničkim imenom već postoji u bazi, molimo promjenite.");
	                        }
	                    }
					    baza.azuriraj(noviKorisnik);
						JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), "Ažuriranje korisnika je uspješno.");
					} else {
					    JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(),
					            "Ne može se ažurirati korisnik. Nema selektiranih korisnika.");
					}
				} catch (IllegalArgumentException e) {
				    JOptionPane.showMessageDialog(racunovodstvoKorisnickiRacuniJPanel.getParent(), e.getMessage());
				}
            }
        };
    }
}
