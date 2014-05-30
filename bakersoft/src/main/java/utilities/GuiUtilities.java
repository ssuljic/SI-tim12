package utilities;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class GuiUtilities {
    public static void selektirajStavkuComboBoxaKojaImaId(long id, JComboBox jComboBox) {
        for (int i = 0; i < jComboBox.getItemCount(); i++) {
            if (((JComboBoxItem) jComboBox.getItemAt(i)).getId() == id) {
                jComboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    public static void popuniJComboBoxListom(List<JComboBoxItem> listaJComboBox, JComboBox jComboBox) {
        jComboBox.removeAllItems();
        for (JComboBoxItem jComboBoxItem : listaJComboBox) {
            jComboBox.addItem(jComboBoxItem);
        }
    }

    public static void postaviDatumUComboBoxove(int dan, int mjesec, int godina, JComboBox danJComboBox, JComboBox mjesecJComboBox, JComboBox godinaJComboBox) {
        // Pp

        danJComboBox.removeAllItems();
        mjesecJComboBox.removeAllItems();
        godinaJComboBox.removeAllItems();
        int mjesecKonstanta = Calendar.JANUARY;
        switch(mjesec) {
            case 1:
                mjesecKonstanta = Calendar.JANUARY;
                break;
            case 2:
                mjesecKonstanta = Calendar.FEBRUARY;
                break;
            case 3:
                mjesecKonstanta = Calendar.MARCH;
                break;
            case 4:
                mjesecKonstanta = Calendar.APRIL;
                break;
            case 5:
                mjesecKonstanta = Calendar.MAY;
                break;
            case 6:
                mjesecKonstanta = Calendar.JUNE;
                break;
            case 7:
                mjesecKonstanta = Calendar.JULY;
                break;
            case 8:
                mjesecKonstanta = Calendar.AUGUST;
                break;
            case 9:
                mjesecKonstanta = Calendar.SEPTEMBER;
                break;
            case 10:
                mjesecKonstanta = Calendar.OCTOBER;
                break;
            case 11:
                mjesecKonstanta = Calendar.NOVEMBER;
                break;
            case 12:
                mjesecKonstanta = Calendar.DECEMBER;
                break;
        }
        Calendar kalendar = new GregorianCalendar(godina, mjesecKonstanta, dan);
        danJComboBox.addItem(dan);
        mjesecJComboBox.addItem(mjesec);
        godinaJComboBox.addItem(godina);
    }

    public static Date uzmiDatumIzJComboBoxova(JComboBox danJComboBox, JComboBox mjesecJComboBox, JComboBox godinaJComboBox){
        int dan = (Integer)danJComboBox.getSelectedItem();
        int mjesec = (Integer)mjesecJComboBox.getSelectedItem();
        int godina = (Integer)godinaJComboBox.getSelectedItem();
        String datumStr = dan + "/" + mjesec + "/" + godina;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return simpleDateFormat.parse(datumStr);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static void popuniJComboBoxSa(List<JComboBoxItem> jComboBoxStavke, JComboBox jComboBox, long idSelektiraneStavke) {
        // Izbjegavanje okidanja eventa SELECTED prilikom dinamickog dodavanja itemova
        ItemListener[] itemListeners = jComboBox.getItemListeners();
        for (int i = 0; i < itemListeners.length; i++) {
            jComboBox.removeItemListener(itemListeners[i]);
        }

        // Brisanje prethodnog sadrzaja jComboBox-a
        jComboBox.removeAllItems();

        // Pronalazenje indeksa unutar JComboBox-a za selektirani jComboBoxItem
        int indeksSelektiraneStavke = -1;
        int tekucaStavkaUJComboBoxu = 0;
        for (JComboBoxItem j : jComboBoxStavke) {
            jComboBox.addItem(j);
            if(j.getId() == idSelektiraneStavke) {
                indeksSelektiraneStavke = tekucaStavkaUJComboBoxu;
            }
            tekucaStavkaUJComboBoxu ++;
        }

        if(indeksSelektiraneStavke >= 0) {
            jComboBox.setSelectedIndex(indeksSelektiraneStavke);
        }

        // Vracanje EventListener-a na JComboBox
        for (int i = 0; i < itemListeners.length; i++) {
            jComboBox.addItemListener(itemListeners[i]);
        }
    }
    
    
    public static void popuniJComboBoxSa(List<JComboBoxItem> jComboBoxStavke, JComboBox jComboBox, String naziv) {
        // Izbjegavanje okidanja eventa SELECTED prilikom dinamickog dodavanja itemova
        ItemListener[] itemListeners = jComboBox.getItemListeners();
        for (int i = 0; i < itemListeners.length; i++) {
            jComboBox.removeItemListener(itemListeners[i]);
        }

        // Brisanje prethodnog sadrzaja jComboBox-a
        jComboBox.removeAllItems();

        // Pronalazenje indeksa unutar JComboBox-a za selektirani jComboBoxItem
        int indeksSelektiraneStavke = -1;
        int tekucaStavkaUJComboBoxu = 0;
        for (JComboBoxItem j : jComboBoxStavke) {
            jComboBox.addItem(j);
            if(j.getSadrzaj() == naziv) {
                indeksSelektiraneStavke = tekucaStavkaUJComboBoxu;
            }
            tekucaStavkaUJComboBoxu ++;
        }

        if(indeksSelektiraneStavke >= 0) {
            jComboBox.setSelectedIndex(indeksSelektiraneStavke);
        }

        // Vracanje EventListener-a na JComboBox
        for (int i = 0; i < itemListeners.length; i++) {
            jComboBox.addItemListener(itemListeners[i]);
        }
    }

    public static void oznaciNtiRedUJTable(JTable jTable, int rowIndex) {
        ListSelectionModel selectionModel = jTable.getSelectionModel();
        ListSelectionListener[] listeners = ((DefaultListSelectionModel) selectionModel).getListSelectionListeners();
        for (ListSelectionListener l : listeners) {
            selectionModel.removeListSelectionListener(l);
        }
        selectionModel.setSelectionInterval(rowIndex, rowIndex);
        for (ListSelectionListener l : listeners) {
            selectionModel.addListSelectionListener(l);
        }
    }
}
