package uy.ort.ob201802.Util;

import java.util.ArrayList;

import uy.ort.ob201802.EDD.Grafo;
import uy.ort.ob201802.EDD.IVertice;

public class CaminoMasCorto {

	Grafo grafo;
	IVertice[] vertices;
	int[][] matriz;

	public CaminoMasCorto(Grafo g) {
		grafo = g;
		vertices = g.getVertices();
		matriz = g.getMatriz();
	}

	public ArrayList<Integer> dijkstra(int origen, int destino) {
		ArrayList<Integer> camino = new ArrayList<Integer>();
		int distancia = Integer.MAX_VALUE;
		int nodo = origen;
		boolean fin = true;
		camino.add(nodo);
		while (fin) {
			if (this.matriz[nodo][destino] < distancia) {
				/*
				 * El metodo siguiente(nodo, destino), nos devuelve el siguiente nodo a visitar
				 */
				nodo = this.siguiente(nodo, destino);
				camino.add(nodo);
			}

			if (nodo == destino) {
				fin = false;
			}
		}

		return camino;
	}

	private int siguiente(int nodo, int destino) {
		// TODO Auto-generated method stub
		return 0;
	}
}
