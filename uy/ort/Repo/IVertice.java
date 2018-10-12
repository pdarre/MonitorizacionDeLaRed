package Repo;

public interface IVertice {

	public String getTipo();
	
	public double getCoordX();

	public double getCoordY();

	public String getChipId();

	public String getCiAfiliado();

	public String getNodoId();
	
	public IVertice getSiguiente();
	
	public void setSiguiente(IVertice v);
}
