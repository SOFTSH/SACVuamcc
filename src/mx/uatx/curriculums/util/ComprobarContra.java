package mx.uatx.curriculums.util;

public class ComprobarContra {
	public boolean ContraM(String pass) {

		for (int i = 0; i < pass.length(); i++) {
			if (Character.isUpperCase(pass.charAt(i)) && pass.length() >= 6
					&& pass.length() <= 10) {
				return true;

			} 

		}
		return false;
	}

	public boolean ContraS(String pass) {
		char[] cadena = pass.toCharArray();
		for (int i = 0; i < pass.length(); i++) {
			if (cadena[i] == '.' || cadena[i] == '$' || cadena[i] == '_'
					|| cadena[i] == '-') {
				return true;

			} 

		}
		return false;
	}
}
