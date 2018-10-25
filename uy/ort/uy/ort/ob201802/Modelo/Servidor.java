package uy.ort.ob201802.Modelo;

public class Servidor extends Vertice {

	private double coordX;
	private double coordY;
	private Vertice siguiente;
	
	public Servidor(double coordX, double coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.siguiente = null;
	}
	
	@Override
	public String getVerticeId() {
		return "Servidor";
	}
	
	@Override
	public double getCoordY() {
		return this.coordY;
	}
	
	@Override
	public double getCoordX() {
		return this.coordX;
	}
	
	@Override
	public void setSiguiente(Vertice v) {
		this.siguiente = v;
	}
	
	@Override
	public Vertice getSiguiente() {
		return this.siguiente;
	}
	
	@Override
	public String toString() {
		return "Servidor";
	}
}
