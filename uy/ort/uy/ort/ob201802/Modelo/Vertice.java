package uy.ort.ob201802.Modelo;

import uy.ort.ob201802.EDD.IVertice;

public class Vertice implements IVertice {

	private double coordX;
	private double coordY;

	@Override
	public double getCoordX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCoordY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSiguiente(Vertice v) {
		// TODO Auto-generated method stub
	}

	@Override
	public Vertice getSiguiente() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		Vertice temp = (Vertice) obj;
		if(this.getCoordX() == temp.getCoordX() && this.getCoordY() == temp.getCoordY()) return true;
		return false;
	}

	@Override
	public String getVerticeId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
