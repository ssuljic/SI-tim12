package bakersoft.bakersoft_prototype.models;

/**
 * Created by eturkovic on 5/4/2014.
 */
public enum Status {
    AKTIVAN("aktivan"), NEAKTIVAN("neaktivan");

    private final String vrijednost;

    private Status(String vrijednost) { this.vrijednost = vrijednost; }

    @Override
    public String toString() {
        return this.vrijednost;
    }
}
