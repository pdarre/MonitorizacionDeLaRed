package uy.ort.ob201802;

public class Afiliado {

	String cedula;
	String nombre;
	String email;
	Afiliado siguiente;
	
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
	public Afiliado getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Afiliado siguiente) {
		this.siguiente = siguiente;
	}
	
}
