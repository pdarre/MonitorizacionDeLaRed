package uy.ort.ob201802.Modelo;

public class Afiliado {

	private String cedula;
	private String nombre;
	private String email;
	private Afiliado izq;
	private Afiliado der;

	public Afiliado(String cedula, String nombre, String email) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.email = email;
		this.izq = null;
		this.der = null;
	}

	public Afiliado(String cedula, String nombre, String email, Afiliado i, Afiliado d) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.email = email;
		this.izq = i;
		this.der = d;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Afiliado getIzq() {
		return izq;
	}

	public void setIzq(Afiliado izq) {
		this.izq = izq;
	}

	public Afiliado getDer() {
		return der;
	}

	public void setDer(Afiliado der) {
		this.der = der;
	}
}