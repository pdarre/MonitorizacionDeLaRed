package uy.ort.ob201802.Util;

import uy.ort.ob201802.EDD.Grafo;
import uy.ort.ob201802.EDD.HashTableVertices;
import uy.ort.ob201802.EDD.ListaVertices;
import uy.ort.ob201802.Modelo.Canalera;
import uy.ort.ob201802.Modelo.Nodo;
import uy.ort.ob201802.Modelo.Servidor;
import uy.ort.ob201802.Modelo.Vertice;

public class Dijkstra {

	private int matAdy[][];
	private HashTableVertices vertices;
	private int tope;
	Grafo grafo;
	int[] dist;
	private int[][] copiaMatriz;

	public Dijkstra(Grafo g) {
		this.matAdy = g.getMatriz();
		this.vertices = g.getHashTableVertices();
		this.tope = vertices.getSize();
		grafo = g;
	}

	public int dijkstra(Vertice origen, Vertice destino) {
		int posO = vertices.buscarIndiceVertice(origen);
		int posD = vertices.buscarIndiceVertice(destino);

		dist = new int[tope];

		int[] ant = new int[tope];
		boolean[] vis = new boolean[tope];

		for (int i = 0; i < tope; ant[i] = -1, dist[i] = Integer.MAX_VALUE, i++)
			;

		dijkstraInterno(posO, dist, ant, vis);

		return dist[posD];
	}

	private void dijkstraInterno(int posO, int[] dist, int[] ant, boolean[] vis) {
		dist[posO] = 0;
		vis[posO] = true;

		for (int i = 0; i < tope; i++) {
			if (matAdy[posO][i] != -1) {
				dist[i] = matAdy[posO][i];
				ant[i] = posO;
			}
		}

		for (int k = 1; k < tope; k++) {
			int posCand = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < tope; i++) {
				if (!vis[i] && dist[i] < min) {
					min = dist[i];
					posCand = i;
				}
			}

			if (posCand == -1)
				return;

			vis[posCand] = true;

			for (int i = 0; i < tope; i++) {
				if (!vis[i] && matAdy[posCand][i] != -1) {
					int sumaDist = dist[posCand] + matAdy[posCand][i];
					if (sumaDist < dist[i]) {
						dist[i] = sumaDist;
						ant[i] = posCand;
					}
				}
			}
		}
	}

	public String nodosCriticos() {
		ListaVertices lista = new ListaVertices();
		Vertice[] vert = vertices.getVertices();
		Vertice v = null;
		for (int i = 0; i < vertices.getSize(); i++) {
			if (vert[i] instanceof Nodo) {
				v = vert[i];
				copiaDeAristas(i);
				eliminarAristas(i);
				Vertice origen = this.getServidor();
				Vertice destino = this.getCanalera();
				this.dijkstra(origen, destino);
				if (getNodoCritico(v))
					lista.insertarVertice(v);
				armarMatriz(i);
			}
		}
		return this.formatearLista(lista);
	}

	private void armarMatriz(int i) {
		for (int j = 0; j < vertices.getSize(); j++) {
			if (copiaMatriz[i][j] != -1)
				this.matAdy[i][j] = copiaMatriz[i][j];
			if (copiaMatriz[j][i] != -1)
				this.matAdy[j][i] = copiaMatriz[j][i];
		}
	}

	private void copiaDeAristas(int i) {
		copiaMatriz = new int[vertices.getSize()][vertices.getSize()];
		iniciarMatriz();
		for (int j = 0; j < vertices.getSize(); j++) {
			if (this.matAdy[i][j] != -1)
				copiaMatriz[i][j] = this.matAdy[i][j];
			if (this.matAdy[j][i] != -1)
				copiaMatriz[j][i] = this.matAdy[j][i];
		}
	}

	private void eliminarAristas(int i) {
		for (int j = 0; j < vertices.getSize(); j++) {
			this.matAdy[i][j] = -1;
			this.matAdy[j][i] = -1;
		}
	}

	private boolean getNodoCritico(Vertice v) {
		Vertice[] vert = vertices.getVertices();
		for (int i = 0; i < dist.length; i++) {
			if (vert[i] != null && !vert[i].equals(v) && !(vert[i] instanceof Servidor)
					&& !(vert[i] instanceof Canalera)) {
				if (dist[i] == Integer.MAX_VALUE) {
					return true;
				}
			}
		}
		return false;
	}

	private void iniciarMatriz() {
		for (int i = 0; i < copiaMatriz.length; i++) {
			for (int j = 0; j < copiaMatriz.length; j++) {
				copiaMatriz[i][j] = -1;
			}
		}
	}

	private String formatearLista(ListaVertices lista) {
		Vertice temp = (Vertice) lista.getRaiz();
		String retorno = "";
		while (temp != null) {
			retorno += temp.getVerticeId() + "|";
			temp = temp.getSiguiente();
		}
		return retorno;
	}

	public Vertice getCanalera() {
		Vertice[] vert = vertices.getVertices();
		for (int i = 0; i < vert.length; i++) {
			if (vert[i] instanceof Canalera)
				return vert[i];
		}
		return null;
	}

	public Vertice getServidor() {
		Vertice[] vert = vertices.getVertices();
		for (int i = 0; i < vert.length; i++) {
			if (vert[i] instanceof Servidor)
				return vert[i];
		}
		return null;
	}
}
