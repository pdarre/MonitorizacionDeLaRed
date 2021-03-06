package uy.ort.ob201802.EDD;

import uy.ort.ob201802.Modelo.Vertice;

public class HashTableVertices {

	private Vertice[] arrayVertices;
	private int size;
	private int cantMaxima;

	public HashTableVertices(int tam) {
		size = this.buscarPrimo(tam * 2);
		arrayVertices = new Vertice[size];
		this.cantMaxima = 0;
		iniciarArrayNodos();
	}

	// inicia cada lugar en el arrayVertices con null
	public void iniciarArrayNodos() {
		for (int i = 0; i < size; arrayVertices[i++] = null)
			;
	}

	public int buscarPrimo(int num) {
		while (!esPrimo(num)) {
			num++;
		}
		return num;
	}

	public boolean esPrimo(int num) {
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != num)) {
			if (num % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}

	// suma coordX + coordY
	// castea double de la suma a int
	// pasa a int positivo el casteo
	public int getHashVertice(double coordX, double coordY) {
		double sumaCoord = coordX + coordY;
		int castSuma = (int) sumaCoord;
		if(castSuma > 0)
			return castSuma % this.size;
		int positivo = castSuma *= -1;
		return positivo % this.size;
	}

	// busca el primer lugar libre en el arrayVertices a partir del indice generado
	public int getLugarEnArrayVertice(Vertice vertice) {
		int lugar = getHashVertice(vertice.getCoordX(), vertice.getCoordY());
		while (arrayVertices[lugar] != null) {
			if (lugar == this.size - 1 && arrayVertices[size - 1] != null) {
				lugar = 0;
				while (arrayVertices[lugar] == null) {
					return lugar;
				}
			}
			lugar++;
		}
		return lugar;
	}

	// retorna el Nodo si lo encentra en el arrayVertices, si no lo encuentra
	// retorna null
	public Vertice buscarVertice(double coordX, double coordY) {
		for (int i = 0; i < arrayVertices.length; i++) {
			if (arrayVertices[i] != null) {
				if (arrayVertices[i].getCoordX() == coordX && arrayVertices[i].getCoordY() == coordY)
					return arrayVertices[i];
			}
		}
		return null;
	}

	public int getSize() {
		return size;
	}

	public void registrarVertice(Vertice vertice) {
		arrayVertices[getLugarEnArrayVertice(vertice)] = vertice;
		this.cantMaxima++;
	}

	public int buscarHashVertice(Double coordX, Double coordY) {
		for (int i = 0; i < arrayVertices.length; i++) {
			if (arrayVertices[i] != null)
				if (arrayVertices[i].getCoordX() == coordX && arrayVertices[i].getCoordY() == coordY)
					return i;

		}
		return -1;
	}

	public Vertice buscarVerticeXindice(int indice) {
		return arrayVertices[indice];
	}

	// pruebas
	public Vertice[] getVertices() {
		return this.arrayVertices;
	}

	public int buscarIndiceVertice(double coordX, double coordY) {
		for (int i = 0; i < size; i++) {
			if (arrayVertices[i] != null && arrayVertices[i].getCoordX() == coordX
					&& arrayVertices[i].getCoordY() == coordY) {
				return i;
			}
		}
		return -1;
	}

	public int buscarIndiceVertice(Vertice v) {
		for (int i = 0; i < arrayVertices.length; i++) {
			if (arrayVertices[i] != null && arrayVertices[i].equals(v))
				return i;
		}
		return -1;
	}

	public boolean isExiste(int i) {
		return arrayVertices[i] != null;
	}

	public Vertice getServidor() {
		for (int i = 0; i < arrayVertices.length; i++) {
			if (arrayVertices[i] != null) {
				if (arrayVertices[i].toString().equals("Servidor")) {
					return arrayVertices[i];
				}
			}
		}
		return null;
	}

	public void quitarVertice(int i) {
		arrayVertices[i] = null;		
	}

	public void setVertices(Vertice[] temp) {
		this.arrayVertices = temp;		
	}
}
