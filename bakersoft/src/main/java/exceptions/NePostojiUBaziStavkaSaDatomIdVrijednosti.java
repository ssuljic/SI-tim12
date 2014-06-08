package exceptions;

import org.hibernate.criterion.NullExpression;

public class NePostojiUBaziStavkaSaDatomIdVrijednosti extends RuntimeException {
    public NePostojiUBaziStavkaSaDatomIdVrijednosti(String poruka) {
        super(poruka);
    }
}


