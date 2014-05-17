package bakersoft.bakersoft_prototype.models;

/**
 * Created by eturkovic on 5/4/2014.
 */
public enum Tip {
    RACUNOVODJA("administrator"), DOSTAVLJAC("dostavljac");

    private final String vrijednost;

    private Tip(String vrijednost) { this.vrijednost = vrijednost; }

    @Override
    public String toString() {
        return this.vrijednost;
    }
}
