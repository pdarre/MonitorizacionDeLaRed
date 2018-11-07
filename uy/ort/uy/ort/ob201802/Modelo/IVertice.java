package uy.ort.ob201802.Modelo;

public interface IVertice {
	
	public double getCoordX();

	public double getCoordY();
	
	public void setSiguiente(Vertice v);
	
	public Vertice getSiguiente();
	
	public String getVerticeId();
	
	public boolean equals(Object obj);
	
	public String toString();
}
