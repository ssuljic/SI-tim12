package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
	private static Validator validator = null;
	
	private Validator() {
	}
	
	public static synchronized Validator instancirajValidatora() {
		if(validator == null) {
			validator = new Validator();
		}
		
		return validator;
	}
	
	public boolean jeImeValidno(String ime) {
		if(ime != null) {
			return ime.matches("[a-zA-Z1-9]+");
		}
		
		return false;
	}

	public boolean jePasswordValidan(String password) {
		if(password != null) {
			return password.length() >= 6;			
		}
		
		return false;
	}

	public boolean jeEmailValidan(String email) {
		if(email != null) {
			return email.matches("[a-zA-Z0-9_]+@[a-zA-Z0-9_]+\\.[a-zA-Z0-9_]+");
		}
		return false;
	}

	public boolean jeTelefonValidan(String telefon) {
		if(telefon == null) {
			return false;
		}
		
		try{
			Integer.parseInt(telefon);
		} catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}

	public boolean jeDatumRodjenjaValidan(Date datumRodjenja) {
		if(datumRodjenja == null) {
			return false;
		}
		
		Date trenutniDatum = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date godina1930 = simpleDateFormat.parse("01-01-1930");
			if(datumRodjenja.before(godina1930) || datumRodjenja.after(trenutniDatum)) {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
