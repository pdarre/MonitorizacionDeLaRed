package uy.ort.ob201802.Modelo;

import Estructuras.IVertice;

public class Canalera extends Vertice {

	private String chipId;
	private String ciAfiliado;
	private double coordX;
	private double coordY;
	private Vertice siguiente;
	
	public Canalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
		this.chipId = chipid;
		this.ciAfiliado = CIafiliado;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public Canalera() {
		
	}

	public String getChipId() {
		return this.chipId;
	}

	public String getCiAfiliado() {
		return this.ciAfiliado;
	}

	public String getNodoId() {
		return null;
	}
	
	@Override
	public double getCoordX() {
		return this.coordX;
	}

	@Override
	public double getCoordY() {
		return this.coordY;
	}
	
	@Override
	public void setSiguiente(Vertice v) {
		this.siguiente = v;
	}
	
	@Override
	public Vertice getSiguiente() {
		return this.siguiente;
	}
}
