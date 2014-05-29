package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.RacunovodstvoEvidencijaPecivaJPanel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



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
				
				racunovodstvoEvidencijaPecivaJPanel.popuniSaPodacima();
				
			}
		};
	}
	
	public ActionListener getEvidencijaPecivaAzurirajJButtonActionListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				racunovodstvoEvidencijaPecivaJPanel.popuniSaPodacima();
			}
		};
	}
	
	public ActionListener getEvidencijaPecivaUkloniPecivoJButtonActionListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				racunovodstvoEvidencijaPecivaJPanel.popuniSaPodacima();
			}
		};
	}
}




