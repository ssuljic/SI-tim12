package controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoEvidencijaPecivaJPanel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import entities.Klijent;
import entities.Pecivo;
import entities.Racun;
import utilities.Baza;



public class RacunovodstvoEvidencijaPecivaController
{
	private RacunovodstvoEvidencijaPecivaJPanel racunovodstvoEvidencijaPecivaJPanel;
	
	public RacunovodstvoEvidencijaPecivaController(RacunovodstvoEvidencijaPecivaJPanel racunovodstvoEvidencijaPecivaJPanel)
	{
		this.racunovodstvoEvidencijaPecivaJPanel = racunovodstvoEvidencijaPecivaJPanel;
	}
	
	public ActionListener getEvidencijaPecivaDodajPecivoJButtonActionListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean postoji_pecivo = false;
					Baza baza = Baza.getBaza();
					List<Pecivo> _svapeciva = baza.dajSve(Pecivo.class);

					for (Pecivo p : _svapeciva) {
						if (p.getSifra().equals(
								racunovodstvoEvidencijaPecivaJPanel
										.getSifratextField().getText())) {
							postoji_pecivo = true;
							break;
						}
					}
					if (!postoji_pecivo) {
						racunovodstvoEvidencijaPecivaJPanel.dodajPecivo();
						JOptionPane
								.showMessageDialog(
										racunovodstvoEvidencijaPecivaJPanel
												.getParent(),
										"Pecivo je uspješno dodano.");
						racunovodstvoEvidencijaPecivaJPanel.osvjeziPanel();
					} else {
						JOptionPane
								.showMessageDialog(
										racunovodstvoEvidencijaPecivaJPanel
												.getParent(),
										"Pecivo sa unesenom sifrom vec postoji!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(
							racunovodstvoEvidencijaPecivaJPanel.getParent(),
							e.getMessage());
				}

			}
		};
	}
	
	
	public ActionListener getEvidencijaPecivaUkloniPecivoJButtonActionListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				  int idSelektiranogPeciva;
				  idSelektiranogPeciva = racunovodstvoEvidencijaPecivaJPanel.getPregledPecivaJTable().getSelectedRow();
				  Baza baza = Baza.getBaza();
				  Pecivo pecivo = baza.dajPoId(Pecivo.class, idSelektiranogPeciva);
				  pecivo.setObrisano(true);
				  baza.spasiUBazu(pecivo);
				  //racunovodstvoEvidencijaPecivaJPanel.azurirajPecivo();
			}
		};
	}
}




