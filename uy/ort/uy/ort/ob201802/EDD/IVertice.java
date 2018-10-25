package uy.ort.ob201802.EDD;

import uy.ort.ob201802.Modelo.Vertice;

public interface IVertice {
	
	public double getCoordX();

	public double getCoordY();
	
	public void setSiguiente(Vertice v);
	
	public Vertice getSiguiente();
	
	public String getVerticeId();
	
	public boolean equals(Object obj);
}
