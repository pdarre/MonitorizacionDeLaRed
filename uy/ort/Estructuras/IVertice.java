package Estructuras;

import uy.ort.ob201802.Modelo.Vertice;

public interface IVertice {
	
	public double getCoordX();

	public double getCoordY();
	
	public void setSiguiente(Vertice v);
	
	public Vertice getSiguiente();
}
