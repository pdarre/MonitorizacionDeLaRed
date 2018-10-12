package uy.ort.ob201802.Modelo;

import Repo.IVertice;

public class Canalera implements IVertice {

	private String chipId;
	private String ciAfiliado;
	private double coordX;
	private double coordY;
	private IVertice siguiente;
	
	public Canalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
		this.chipId = chipid;
		this.ciAfiliado = CIafiliado;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public Canalera() {
		
	}

	@Override
	public String getTipo() {
		return "canalera";
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
	public String getChipId() {
		return this.chipId;
	}

	@Override
	public String getCiAfiliado() {
		return this.ciAfiliado;
	}

	@Override
	public String getNodoId() {
		return null;
	}

	@Override
	public IVertice getSiguiente() {
		return this.siguiente;
	}

	@Override
	public void setSiguiente(IVertice v) {
		this.siguiente = v;
	}
}