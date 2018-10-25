package uy.ort.ob201802.Util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Email {

	public static boolean isValid(String email) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		if (mather.find() == true) {
			return true;
		} else {
			return false;
		}
	}
}