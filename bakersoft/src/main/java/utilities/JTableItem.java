package utilities;

import java.util.List;

public class JTableItem {
    long id;
    List<String> sadrzajJednogReda;

    public JTableItem() {
    }

    public JTableItem(long id, List<String> sadrzajKolona) {
        this.id = id;
        this.sadrzajJednogReda = sadrzajKolona;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getSadrzajJednogReda() {
        return sadrzajJednogReda;
    }

    public void setSadrzajJednogReda(List<String> sadrzajJednogReda) {
        this.sadrzajJednogReda = sadrzajJednogReda;
    }
}
