package Estructuras;

import uy.ort.ob201802.Modelo.Vertice;

public class Grafo {

	private HashTableVertices vertices;
	private int[][] matrizAdy;
	private int contador;
	private int tam;

	public Grafo(int tam) {
		this.contador = 0;
		this.tam = tam;
		this.vertices = new HashTableVertices(tam);
		this.matrizAdy = new int[vertices.getSize()][vertices.getSize()];
		iniciarMatriz();
	}

	public void iniciarMatriz() {
		for (int i = 0; i < matrizAdy.length; i++) {
			for (int j = 0; j < matrizAdy.length; j++) {
				matrizAdy[i][j] = 0;
			}
		}
	}

	public void registrarVertice(Vertice vertice) {
		vertices.registrarVertice(vertice);
		contador++;
	}

	public Vertice buscarVertice(Double coordX, Double coordY) {
		return vertices.buscarVertice(coordX, coordY);
	}

	public boolean arregloHashLleno() {
		return contador == this.getHashTableVertices().getSize();
	}

	public void registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
		int verticeOrigen = vertices.buscarHashVertice(coordXi, coordYi);
		int verticeDestino = vertices.buscarHashVertice(coordXf, coordYf);
		this.matrizAdy[verticeOrigen][verticeDestino] = perdidaCalidad;
		this.matrizAdy[verticeDestino][verticeOrigen] = perdidaCalidad;
	}

	// solo para las pruebas
	public HashTableVertices getHashTableVertices() {
		return this.vertices;
	}

	public boolean existeTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		int origen = this.vertices.buscarHashVertice(coordXi, coordYi);
		int destino = this.vertices.buscarHashVertice(coordXf, coordYf);
		return this.matrizAdy[origen][destino] != 0;
	}

	public void modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf,
			int nuevoValorPerdidaCalidad) {
		int verticeOrigen = vertices.buscarHashVertice(coordXi, coordYi);
		int verticeDestino = vertices.buscarHashVertice(coordXf, coordYf);
		this.matrizAdy[verticeOrigen][verticeDestino] = nuevoValorPerdidaCalidad;
		this.matrizAdy[verticeDestino][verticeOrigen] = nuevoValorPerdidaCalidad;
	}

	// recibe un vertice y retorna ua lista con los vertices adyacentes
	public ListaVertices buscarAdyacentes(Vertice vertice) {
		ListaVertices retorno = new ListaVertices();
		int indiceVerticeOrigen = vertices.buscarIndicePalabra(vertice.getCoordX(), vertice.getCoordY());
		for (int i = 0; i < matrizAdy.length; i++) {
			if (matrizAdy[indiceVerticeOrigen][i] != 0) {
				Vertice temp = vertices.buscarVerticeXindice(i);
				retorno.insertarVertice(temp);
			}
		}
		return retorno;
	}

	public int getSize() {
		return vertices.getSize();
	}

	// para pruebas
	public int[][] getMatriz() {
		return this.matrizAdy;
	}

	public IVertice[] getVertices() {
		return vertices.getVertices();
	}

	public int buscarIndiceVertice(double coordX, double coordY) {
		int indice = vertices.buscarIndicePalabra(coordX, coordY);
		return indice;
	}

	public boolean esAdyacente(IVertice origen, IVertice destino) {
		int o = this.buscarIndiceVertice(origen.getCoordX(), origen.getCoordY());
		int d = this.buscarIndiceVertice(destino.getCoordX(), origen.getCoordY());
		if(this.matrizAdy[o][d] != 0) {
			return true;
		}
		return false;
	}
}
