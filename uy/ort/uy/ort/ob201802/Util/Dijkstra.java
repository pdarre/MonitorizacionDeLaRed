package uy.ort.ob201802.Util;

import uy.ort.ob201802.EDD.Grafo;
import uy.ort.ob201802.EDD.HashTableVertices;
import uy.ort.ob201802.Modelo.Vertice;

public class Dijkstra {
	
	private int matAdy[][];
	private HashTableVertices vertices;
	private Grafo grafo;
	private int tope;
	
	public Dijkstra(Grafo g) {
		this.matAdy = g.getMatriz();
		this.vertices = g.getHashTableVertices();
		this.grafo = g;
		this.tope = vertices.getSize();
	}

	public int dijkstra(Vertice origen, Vertice destino)
	{
		int posO = vertices.buscarIndiceVertice(origen);
		int posD = vertices.buscarIndiceVertice(destino);
		
		// Etapa 1: Inicializo vectores
		int[] dist = new int[tope];
		int[] ant = new int[tope];
		boolean[] vis = new boolean[tope];
		
//		for (int i = 0; i < tope; ant[i] = -1, dist[i] = Integer.MAX_VALUE,i++);
		
		for (int i = 0; i < vertices.getSize(); i++){
			ant[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		
		dijkstraInterno(posO, dist, ant, vis);
			
		return dist[posD];
	}

	private void dijkstraInterno(int posO, int[] dist, int[] ant, boolean[] vis) {
		// Etapa 2: Actualizo las distancias de los adyacentes del origen
		dist[posO] = 0;
		vis[posO] = true;
		
		for (int i = 0; i < tope; i++) {
			if(matAdy[posO][i] != -1)
			{
				dist[i] = matAdy[posO][i];
				ant[i] = posO;
			}
		}
		
		// Etapa 3: Proceso iterativo para actualizar distancias,
		//    actualizando aquellas aristas que marquen un mejor camino
		
		for (int k = 1; k < tope; k++) {
			// Elijo al próximo vertice, siendo éste el de menor distancia no visitada
			int posCand = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < tope; i++) {
				if(!vis[i] && dist[i]<min)
				{
					min = dist[i];
					posCand = i;
				}
			}
			
			// Si no hay candidato, no es conexo.
			if(posCand == -1)
				return;
			
			vis[posCand] = true;
			
			for (int i = 0; i < tope; i++) {
				if(!vis[i] && matAdy[posCand][i] != -1)
				{
					int sumaDist = dist[posCand] + matAdy[posCand][i];
					if(sumaDist < dist[i])
					{
						dist[i] = sumaDist;
						ant[i] = posCand;						
					}
				}
			}
		}
	}
}
