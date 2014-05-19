package utilities;

import java.io.Serializable;

public class JComboBoxItem implements Serializable {
    private long id;
    private String sadrzaj;

    public JComboBoxItem() {
    }

    public JComboBoxItem(long id, String sadrzaj) {
        this.id = id;
        this.sadrzaj = sadrzaj;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    @Override
    public String toString() {
        return sadrzaj;
    }
}
