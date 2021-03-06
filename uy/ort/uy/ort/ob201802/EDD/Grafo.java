package uy.ort.ob201802.EDD;

import java.awt.Desktop;
import java.net.URL;

import uy.ort.ob201802.Modelo.Canalera;
import uy.ort.ob201802.Modelo.Nodo;
import uy.ort.ob201802.Modelo.Servidor;
import uy.ort.ob201802.Modelo.Vertice;
import uy.ort.ob201802.Util.Dijkstra;

public class Grafo {

	private HashTableVertices vertices;
	private int[][] matrizAdy;
	private int contador;
	private int tam;
	private Dijkstra dijkstra;
	private int maximo;

	public Grafo(int tam) {
		this.contador = 0;
		this.vertices = new HashTableVertices(tam);
		this.maximo = tam;
		this.tam = vertices.getSize();
		this.matrizAdy = new int[vertices.getSize()][vertices.getSize()];
		dijkstra = new Dijkstra(this);
		iniciarMatriz();
	}

	public void iniciarMatriz() {
		for (int i = 0; i < matrizAdy.length; i++) {
			for (int j = 0; j < matrizAdy.length; j++) {
				matrizAdy[i][j] = -1;
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

	public void registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
		int origen = this.vertices.buscarIndiceVertice(coordXi, coordYi);
		int destino = this.vertices.buscarIndiceVertice(coordXf, coordYf);
		this.matrizAdy[origen][destino] = perdidaCalidad;
		this.matrizAdy[destino][origen] = perdidaCalidad;
	}

	public boolean existeTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		int origen = this.vertices.buscarIndiceVertice(coordXi, coordYi);
		int destino = this.vertices.buscarIndiceVertice(coordXf, coordYf);
		if (matrizAdy[origen][destino] != -1)
			return true;
		return false;
	}

	public void modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf,
			int nuevoValorPerdidaCalidad) {
		int verticeOrigen = vertices.buscarHashVertice(coordXi, coordYi);
		int verticeDestino = vertices.buscarHashVertice(coordXf, coordYf);
		this.matrizAdy[verticeOrigen][verticeDestino] = nuevoValorPerdidaCalidad;
		this.matrizAdy[verticeDestino][verticeOrigen] = nuevoValorPerdidaCalidad;
	}

	public int getSize() {
		return vertices.getSize();
	}

	public int[][] getMatriz() {
		return this.matrizAdy;
	}

	public int buscarIndiceVertice(double coordX, double coordY) {
		int indice = vertices.buscarIndiceVertice(coordX, coordY);
		return indice;
	}

	public boolean tramoIsValid(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		Vertice origen = this.buscarVertice(coordXi, coordYi);
		Vertice destino = this.buscarVertice(coordXf, coordYf);
		if (origen.getVerticeId() == "Servidor" && destino instanceof Canalera)
			return true;
		if (origen instanceof Canalera && destino.getVerticeId() == "Servidor")
			return true;
		return false;
	}

	public String getVerticeId(double coordX, double coordY) {
		return this.buscarVertice(coordX, coordY).getVerticeId();
	}

	public Vertice getServidor() {
		return vertices.getServidor();
	}

	// solo para las pruebas
	public HashTableVertices getHashTableVertices() {
		return this.vertices;
	}

	public int calidadCanalera(Double coordX, Double coordY) {
		Vertice destino = buscarVertice(coordX, coordY);
		return dijkstra.dijkstra(getServidor(), destino);
	}

	public String nodosCriticos() {
		return dijkstra.nodosCriticos();
	}

	public String dibujarMapa() { 
		String key = "AIzaSyC2kHGtzaC3OOyc7Wi1LMBcEwM9btRZLqw";
		String direccion = "http://maps.googleapis.com/maps/api/staticmap?center="
				+ "-34.908912,-56.194980&zoom=16&size=1200x600&maptype=roadmap&";
		Vertice serv = this.getServidor();
		direccion += "markers=color:green%7Clabel:S%7C" + serv.getCoordX() + "," + serv.getCoordY();
		Vertice[] vert = this.getHashTableVertices().getVertices();
		for (int i = 0; i < vert.length; i++) {
			if (vert[i] != null && vert[i] instanceof Nodo)
				direccion += "&markers=color:blue%7Clabel:N%7C" + vert[i].getCoordX() + "," + vert[i].getCoordY();
			if (vert[i] != null && vert[i] instanceof Canalera)
				direccion += "&markers=color:red%7Clabel:C%7C" + vert[i].getCoordX() + "," + vert[i].getCoordY();
			direccion += "&sensor=false&key=" + key;
		}
		return direccion;
	}

	public boolean cantMaxima() {
		return contador != this.maximo;
	}
}
