package uy.ort.ob201802.Modelo;

import uy.ort.ob201802.EDD.IVertice;

public class Nodo extends Vertice{

	private String nodoId;
	private double coordX;
	private double coordY;
	private Vertice siguiente;

	public Nodo(String nodoId, double coordX, double coordY) {
		this.nodoId = nodoId;
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public Nodo() {
	}
	
	@Override
	public String getVerticeId() {
		return this.nodoId;
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
		return nodoId;
	}
}