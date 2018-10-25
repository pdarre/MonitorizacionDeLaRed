package uy.ort.ob201802;

import java.awt.Desktop;
import java.net.URL;

public class Main {

	public static void main(String[] args) {

		// String url = mimapa.getURLMapaPuntos();

		String key = "AIzaSyDbBdS0jsdliO9QKUXc1kR3ac318j6bjZo";

		String direccion = "http://maps.googleapis.com/maps/api/staticmap?center="
				+ "Montevideo,Uruguay&zoom=13&size=1200x600&maptype=roadmap&"
				+ "markers=color:blue%7Clabel:1%7C-34.90,-56.16" + "&markers=color:red%7Clabel:2%7C-34.91,-56.17"
				+ "&markers=color:green%7Clabel:3%7C-34.90,-56.19"
//				+ "markers=color:blue%7Clabel:4%7C-34.905,-56.19"
//              + "markers=color:blue%7Clabel:4%7C-34.90,-56.17"
				+ "&sensor=false&key=AIzaSyC2kHGtzaC3OOyc7Wi1LMBcEwM9btRZLqw";
		
		String direccion2 = "http://maps.googleapis.com/maps/api/staticmap?center="
				+ "Montevideo,Uruguay&zoom=13&size=1200x600&maptype=roadmap"
				+ "&markers=color:blue%7Clabel:1%7C-34.90,-56.16"
				+ "&markers=color:red%7Clabel:2%7C-34.91,-56.17"
				+ "&markers=color:green%7Clabel:3%7C-34.905,-56.19"
				+ "&sensor=false&key=" + key;

		try {
			Desktop.getDesktop().browse(new URL(direccion).toURI());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// El string url deberá tener un valor similar al del ejemplo que se da en el
		// anexo de la letra:

	}

}
