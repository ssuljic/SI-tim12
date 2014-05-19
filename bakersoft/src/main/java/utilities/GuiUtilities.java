package utilities;

import javax.swing.*;
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
        danJComboBox.removeAllItems();
        mjesecJComboBox.removeAllItems();
        godinaJComboBox.removeAllItems();
        danJComboBox.addItem(dan);
        mjesecJComboBox.addItem(mjesec);
        godinaJComboBox.addItem(godina);
    }
}
