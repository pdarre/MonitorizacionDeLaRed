package uy.ort.ob201802.Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cedula {

	public static boolean esCIValida(int cedula) {
		String ci = Integer.toString(cedula);
		if (ci.length() != 7 && ci.length() != 8) {
			return false;
		} else {
			try {
				Integer.parseInt(ci);
			} catch (NumberFormatException e) {
				return false;
			}
		}

		int digVerificador = Integer.parseInt((ci.charAt(ci.length() - 1)) + "");
		int[] factores;
		int temp = ci.length();
		if (ci.length() == 7) {
			factores = new int[] { 9, 8, 7, 6, 3, 4 };
		} else {
			factores = new int[] { 2, 9, 8, 7, 6, 3, 4 };
		}

		int suma = 0;
		for (int i = 0; i < ci.length() - 1; i++) {
			int digito = Integer.parseInt(ci.charAt(i) + "");
			suma += digito * factores[i];
		}

		int resto = suma % 10;
		int checkdigit = 10 - resto;

		if (checkdigit == 10) {
			return (digVerificador == 0);
		} else {
			return (checkdigit == digVerificador);
		}
	}

	public static int convertirCI(String ci) {
		return Integer.parseInt(ci.replaceAll("[\\s\\-\\.\\'\\?/?\\¿\\!\\¡\\,\\:\\)\\(\\_\\@]+", ""));
	}

	//TEMPORAL, CAMBIAR A EXPRESION REGULAR
	public static boolean checkFormato(String ci) {
		if (ci.length() >= 11) {
			String uno = String.valueOf(ci.charAt(1));
			String dos = String.valueOf(ci.charAt(5));
			String tres = String.valueOf(ci.charAt(9));
			if (uno.equals(".") && dos.equals(".") && tres.equals("-")) {
				return true;
			}
		}
		return false;
	}
}