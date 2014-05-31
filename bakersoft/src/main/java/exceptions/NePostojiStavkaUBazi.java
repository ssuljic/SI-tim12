package exceptions;

import org.hibernate.criterion.NullExpression;


public class NePostojiStavkaUBazi extends RuntimeException {
	public NePostojiStavkaUBazi(String poruka) {
		super(poruka);
	}
}
