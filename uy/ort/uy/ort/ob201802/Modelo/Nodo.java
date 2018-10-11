package uy.ort.ob201802.Modelo;

import Repo.IVertice;

public class Nodo implements IVertice{

	private String nodoId;
	private double coordX;
	private double coordY;

	public Nodo(String nodoId, double coordX, double coordY) {
		this.nodoId = nodoId;
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public Nodo() {
	}

	@Override
	public String getTipo() {
		return "nodo";
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
	public String getNodoId() {
		return this.nodoId;
	}

	@Override
	public String getChipId() {
		return null;
	}

	@Override
	public String getCiAfiliado() {
		return null;
	}
}