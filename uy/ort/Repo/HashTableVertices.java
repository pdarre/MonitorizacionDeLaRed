package Repo;

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
	public int getHashVertice(IVertice vertice) {
		double sumaCoord = vertice.getCoordX() + vertice.getCoordY();
		int castSuma = (int) sumaCoord;
		int positivo = castSuma *= -1;
		return positivo % this.size;
	}

	// busca el primer lugar libre en el arrayVertices a partir del indice generado
	public int getLugarEnArrayVertice(IVertice vertice) {
		int lugar = getHashVertice(vertice);
		while (!arrayVertices[lugar].equals(vertice)) {
			lugar++;
		}
		return lugar;
	}

	// retorna el Nodo si lo encentra en el arrayVertices, si no lo encuentra
	// retorna null
	public IVertice buscarVertice(IVertice vertice) {
		IVertice vert = null;
		int lugar = getHashVertice(vertice);
		while (arrayVertices[lugar] != null && !arrayVertices[lugar].equals(vertice)) {
			lugar++;
		}
		return arrayVertices[lugar];
	}

	public int getSize() {
		return size;
	}
}
