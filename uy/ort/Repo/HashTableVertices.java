package Repo;

import uy.ort.ob201802.Modelo.Nodo;

public class HashTableVertices {

	private IVertice[] arrayVertices;
	private int size;

	public HashTableVertices(int tam) {
		size = this.buscarPrimo(tam * 2);
		arrayVertices = new IVertice[size];
		iniciarArrayNodos();
	}

	// inicia cada lugar en el arrayVertices con null
	public void iniciarArrayNodos() {
		for (int i = 0; i < size; i++) {
			arrayVertices[i] = null;
		}
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

	public Object buscarVerticeXindice(int indice) {
		return arrayVertices[indice];
	}

	public int buscarIndiceVertice(String nodoId) {
		for (int i = 0; i < size; i++) {
			if (arrayVertices[i] != null && arrayVertices[i].getNodoId().equals(nodoId)) {
				return i;
			}
		}
		return 0;
	}

	// suma coordX + coordY
	// castea double de la suma a int
	// pasa a int positivo el casteo
	public int getHashVertice(double coordX, double coordY) {
		double sumaCoord = coordX + coordY;
		int castSuma = (int) sumaCoord;
		int positivo = castSuma *= -1;
		return positivo % this.size;
	}

	// busca el primer lugar libre en el arrayVertices a partir del indice generado
	public int getLugarEnArrayVertice(IVertice vertice) {
		int lugar = getHashVertice(vertice.getCoordX(), vertice.getCoordY());
		while (arrayVertices[lugar] != null) {
			if (lugar == this.size-1 && arrayVertices[size - 1] != null) {
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
	public IVertice buscarVertice(double coordX, double coordY) {
		for (int i = 0; i < arrayVertices.length; i++) {
			if (arrayVertices[i] != null) {
				if (arrayVertices[i].getCoordX() == coordX && arrayVertices[i].getCoordY() == coordY) {
					return arrayVertices[i];
				}
			}
		}
		return null;
	}

	public int getSize() {
		return size;
	}

	public void registrarVertice(IVertice vertice) {
		int lugar = getLugarEnArrayVertice(vertice);
		arrayVertices[lugar] = vertice;
	}

	public IVertice buscarVerticeXcoordenadas(Double coordXf, Double coordYf) {
		IVertice vertice = this.arrayVertices[getHashVerticeXcoordenadas(coordXf, coordYf)];
		return vertice;
	}

	public int getHashVerticeXcoordenadas(Double coordXf, Double coordYf) {
		double sumaCoord = coordXf + coordYf;
		int castSuma = (int) sumaCoord;
		int positivo = castSuma *= -1;
		return positivo % this.size;
	}

	// solo para pruebas
	public IVertice[] getArregloVertices() {
		return this.arrayVertices;
	}
}
