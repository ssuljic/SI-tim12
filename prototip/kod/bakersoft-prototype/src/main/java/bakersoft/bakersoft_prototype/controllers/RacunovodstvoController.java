package bakersoft.bakersoft_prototype.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bakersoft.bakersoft_prototype.gui.racunovodstvo.RacunovodstvoJFrame;

public class RacunovodstvoController {
	private RacunovodstvoJFrame racunovodstvoJFrame;

	public RacunovodstvoController(RacunovodstvoJFrame racunovodstvoJFrame) {
		super();
		this.racunovodstvoJFrame = racunovodstvoJFrame;
	}
	
	public WindowListener getZatvorenJFrameActionListener() {
		return new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				racunovodstvoJFrame.setVisible(false);
				JFrame pozivaocJForm = racunovodstvoJFrame.getPozivaocJFrame();
				if(pozivaocJForm != null) {
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
				if(pozivaocJForm != null) {
					racunovodstvoJFrame.getPozivaocJFrame().setVisible(true);
				}
				
				racunovodstvoJFrame.dispose();
			}
		};
	}
	
	public ActionListener getEvidencijaPecivaUkloniPecivoJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getEvidencijaPecivaDodajPecivoJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}

	public ActionListener getKlijentiObrisiJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getKlijentiDodajJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getKorisnickiRacuniTraziJComboBoxActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getKorisnickiRacuniPrivilegijeJComboBoxActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getKorisnickiRacuniObrisiJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getKorisnickiRacuniDodajJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getObracunavanjeObracunZaJComboBoxActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getObracunavanjeObrisiJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getObracunavanjeDodajJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getSpaseniObracuniObracunZaJComboBoxActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getSpaseniObracuniObrisiObracunJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
	
	public ActionListener getSpaseniObracuniNapraviNoviObracunJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				racunovodstvoJFrame.postaviObracunavanjeJPanel();
			}
		};
	}
	
	public ActionListener getSpaseniObracuniPosaljiObracunJButtonActionListener() {
		return new ActionListener() {			
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(racunovodstvoJFrame, "Nije implementirano");
			}
		};
	}
}
