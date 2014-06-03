package controllers;

import entities.Klijent;
import entities.Racun;
import utilities.Baza;
import utilities.JComboBoxItem;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import views.RacunovodstvoSpaseniObracuniJPanel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Element;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class RacunovodstvoSpaseniObracuniController {
	private RacunovodstvoSpaseniObracuniJPanel racunovodstvoSpaseniObracuniJPanel;

    public RacunovodstvoSpaseniObracuniController(RacunovodstvoSpaseniObracuniJPanel racunovodstvoSpaseniObracuniJPanel) {
        this.racunovodstvoSpaseniObracuniJPanel = racunovodstvoSpaseniObracuniJPanel;
    }
    
    public ItemListener getSpaseniObracuniObracunZaJComboBoxItemListener() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    long idSelektiranogKlijenta = ((JComboBoxItem) racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().getSelectedItem()).getId();
                    racunovodstvoSpaseniObracuniJPanel.popuniSaPodacima(idSelektiranogKlijenta);
                }
            }
        };
    }
    
    public ActionListener getSpaseniObracuniObrisiJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int rbSelektiranogRacuna = 0;
                long idSelektiranogKorisnika = 0;
                if (racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().getItemCount() > 0) {
                    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().getSelectedItem()).getId();
                }
                rbSelektiranogRacuna = (int) racunovodstvoSpaseniObracuniJPanel.getObracuniJTable().getSelectedRow();
                if(rbSelektiranogRacuna == -1) {
                	JOptionPane.showMessageDialog(racunovodstvoSpaseniObracuniJPanel.getParent(), "Niste izabrali obračun");
                }
                else {
	                Baza baza = Baza.getBaza();
	                Klijent klijent = baza.dajPoId(Klijent.class, idSelektiranogKorisnika);
	                ((Racun)klijent.getRacuni().toArray()[rbSelektiranogRacuna]).setObrisano(true);
	                
	                baza.spasiUBazu(klijent);
	                racunovodstvoSpaseniObracuniJPanel.popuniObracuniJTableSaPodacimaOKlijentu(klijent);
	                JOptionPane.showMessageDialog(racunovodstvoSpaseniObracuniJPanel.getParent(), "Uspješno ste izbrisali obračun");
                }
            }
        };
    }
    
    public ActionListener getPDFJButtonActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	int rbSelektiranogRacuna = 0;
            	long idSelektiranogKorisnika = 0;
                if (racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().getItemCount() > 0) {
                    idSelektiranogKorisnika = ((JComboBoxItem) racunovodstvoSpaseniObracuniJPanel.getObracunZaJComboBox().getSelectedItem()).getId();
                }
                rbSelektiranogRacuna = (int) racunovodstvoSpaseniObracuniJPanel.getObracuniJTable().getSelectedRow();
                if(rbSelektiranogRacuna == -1) {
                	JOptionPane.showMessageDialog(racunovodstvoSpaseniObracuniJPanel.getParent(), "Niste izabrali obračun");
                }
                else {
	                Baza baza = Baza.getBaza();
	                
	                Klijent klijent = baza.dajPoId(Klijent.class, idSelektiranogKorisnika);
	                Racun r = ((Racun)klijent.getRacuni().toArray()[rbSelektiranogRacuna]);
	            	Document document = new Document();
	            	
	                try {
	                    PdfWriter.getInstance(document,
	                        new FileOutputStream(System.getProperty("java.io.tmpdir") + "/Racun" + r.getId() + ".pdf"));
	                    
	                    document.open();
	                    document.add(new Paragraph("Bakersoft obracun za klijenta " + klijent.getIme()));
	                    document.add(new Paragraph("Broj racuna: " + r.getBroj()));
	                    document.add(new Paragraph("\n"));
	                    document.add(new Paragraph("\n"));
	                    document.add(new Paragraph("\n"));
	                    
	                    PdfPTable table = new PdfPTable(3);

	                    PdfPCell head2 = new PdfPCell(new Paragraph("Pocetak obracuna"));
	                    PdfPCell head3 = new PdfPCell(new Paragraph("Kraj obracuna"));
	                    PdfPCell head4 = new PdfPCell(new Paragraph("Iznos"));

	                    table.addCell(head2);
	                    table.addCell(head3);
	                    table.addCell(head4);
	                    
	                    PdfPCell cell2 = new PdfPCell(new Paragraph(String.valueOf(new SimpleDateFormat("dd.MM.yyyy").format(r.getPocetak()))));
	                    PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(new SimpleDateFormat("dd.MM.yyyy").format(r.getKraj()))));
	                    PdfPCell cell4 = new PdfPCell(new Paragraph(String.valueOf(r.getIznos()) + " KM"));

	                    table.addCell(cell2);
	                    table.addCell(cell3);
	                    table.addCell(cell4);
	                    
	                    document.add(table);
	                    document.add(new Paragraph("\n"));
	                    document.add(new Paragraph("\n"));
	                    document.add(new Paragraph("\n"));
	                    document.add(new Paragraph("Datum izdavanja: " + new SimpleDateFormat("dd.MM.yyyy").format(r.getDatum())));
	                    
	                    PdfPTable potpisTable = new PdfPTable(1);
	                    potpisTable.setWidthPercentage(40);
	                    potpisTable.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                    
	                    PdfPCell potpis = new PdfPCell(new Paragraph("Direktor Bakersoft-a") );
	                    potpis.setBorder(Rectangle.TOP);
	                    potpis.setHorizontalAlignment(Element.ALIGN_CENTER);
	                    potpisTable.addCell(potpis);
	                    document.add(potpisTable);
	                    
	                    document.close();
	                    JOptionPane.showMessageDialog(racunovodstvoSpaseniObracuniJPanel.getParent(), "Račun je spašen u privremeni direktorij " + System.getProperty("java.io.tmpdir") + "/Racun" + r.getId() + ".pdf.\nUkoliko ga želite zadržati snimite ga u neki drugi direktorij.\nNakon što klikente OK otvorit će vam se dokument.");
	                    
	                    File pdfFile = new File(System.getProperty("java.io.tmpdir") + "/Racun" + r.getId() + ".pdf");
	            		if (pdfFile.exists()) {
	            			if (Desktop.isDesktopSupported()) {
	            				try {
	            					Desktop.getDesktop().open(pdfFile);
	            				}
	            				catch(IOException ignored) {
	            					
	            				}
	            			}
	            		}
	                } catch (DocumentException e) {
	                    e.printStackTrace();
	                } catch (FileNotFoundException e) {
	                    e.printStackTrace();
	                }
                }
                
            }
        };
    }
}
