package controllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import entities.Klijent;
import entities.Pecivo;
import utilities.Baza;
import utilities.JComboBoxItem;
import views.DostavljacPreuzimanjePecivaJPanel;

public class DostavljacPreuzimanjePecivaController {

		private DostavljacPreuzimanjePecivaJPanel dostavljacPreuzimanjePecivaJPanel;
		
		public DostavljacPreuzimanjePecivaController(DostavljacPreuzimanjePecivaJPanel dostavljacPreuzimanjePecivaJPanel)
		{
			this.dostavljacPreuzimanjePecivaJPanel=dostavljacPreuzimanjePecivaJPanel;
		}
		//OVO sam ostavio, ne znam je l' ti treba uopste ? ako treba, super, ako ne lahko je izbrisat :D
		/*public ItemListener getPecivaJComboBoxItemListener() {
	        return new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                    long idSelektiranogPeciva = ((JComboBoxItem) dostavljacPreuzimanjePecivaJPanel.getComboBox().getSelectedItem()).getId();
	                    Baza baza = Baza.getBaza();
	                    List<Pecivo> svaPeciva = baza.dajSveNeobrisano(Pecivo.class);
	                    dostavljacPreuzimanjePecivaJPanel.popuniSaPodacima(svaPeciva, idSelektiranogPeciva);
	                }
	            }
	        };
	    }*/
		
}
