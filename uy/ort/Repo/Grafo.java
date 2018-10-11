package Repo;

import uy.ort.ob201802.Modelo.Nodo;

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

	public void registrarVertice(IVertice vertice) {
		vertices.registrarVertice(vertice);
		contador++;
	}
	
	public IVertice buscarVertice(IVertice vertice) {
		return vertices.buscarVertice(vertice);
	}

	public boolean esLlena() {
		return contador == tam;
	}

	public IVertice buscarVerticeXcoordenadas(Double coordXf, Double coordYf) {
		return vertices.buscarVerticeXcoordenadas(coordXf,coordYf);
	}

	public void registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
		int verticeOrigen = vertices.getHashVerticeXcoordenadas(coordXi, coordYi);
		int verticeDestino = vertices.getHashVerticeXcoordenadas(coordXf, coordYf);
		this.matrizAdy[verticeOrigen][verticeDestino] = perdidaCalidad;
		this.matrizAdy[verticeDestino][verticeOrigen] = perdidaCalidad;		
	}
	
}
