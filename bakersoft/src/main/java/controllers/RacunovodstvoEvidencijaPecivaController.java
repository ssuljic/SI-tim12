package controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utilities.Baza;
import utilities.JComboBoxItem;
import views.RacunovodstvoEvidencijaPecivaJPanel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import entities.Klijent;
import entities.Pecivo;
import entities.Racun;



public class RacunovodstvoEvidencijaPecivaController
{
	private RacunovodstvoEvidencijaPecivaJPanel racunovodstvoEvidencijaPecivaJPanel;
	
	public RacunovodstvoEvidencijaPecivaController(RacunovodstvoEvidencijaPecivaJPanel racunovodstvoEvidencijaPecivaJPanel)
	{
		this.racunovodstvoEvidencijaPecivaJPanel = racunovodstvoEvidencijaPecivaJPanel;
	}
	
	public ActionListener getEvidencijaPecivaDodajPecivoJButtonActionListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					racunovodstvoEvidencijaPecivaJPanel.dodajPecivo();
	                JOptionPane.showMessageDialog(racunovodstvoEvidencijaPecivaJPanel.getParent(), "Pecivo je uspješno dodano.");
					racunovodstvoEvidencijaPecivaJPanel.osvjeziPanel();
				} catch (Exception e) {
	                JOptionPane.showMessageDialog(racunovodstvoEvidencijaPecivaJPanel.getParent(), e.getMessage());
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




