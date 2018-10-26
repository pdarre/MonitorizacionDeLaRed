package uy.ort.ob201802.Util;

import uy.ort.ob201802.EDD.Grafo;
import uy.ort.ob201802.EDD.HashTableVertices;
import uy.ort.ob201802.EDD.ListaVertices;
import uy.ort.ob201802.Modelo.Vertice;

public class Dijkstra {
	
	private int matAdy[][];
	private HashTableVertices vertices;
	private int tope;
	Grafo grafo;
	int[] dist;
	
	public Dijkstra(Grafo g) {
		this.matAdy = g.getMatriz();
		this.vertices = g.getHashTableVertices();
		this.tope = vertices.getSize();
		grafo = g;
	}

	public int dijkstra(Vertice origen, Vertice destino)
	{
		//si destino es null, no existe el vertice destino, retorna -1 (REVISAR!!!)
		if(destino == null)return -1;
		
		int posO = vertices.buscarIndiceVertice(origen);
		int posD = vertices.buscarIndiceVertice(destino);
		
		// Etapa 1: Inicializo vectores
//		int[] dist = new int[tope];
		dist = new int[tope];
		
		int[] ant = new int[tope];
		boolean[] vis = new boolean[tope];
		
//		for (int i = 0; i < tope; ant[i] = -1, dist[i] = Integer.MAX_VALUE,i++);
		
		for (int i = 0; i < vertices.getSize(); i++){
			ant[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		
		dijkstraInterno(posO, dist, ant, vis);
		
//		ListaVertices list = crearLista(ant, posO, posD);
//		
//		//temporal
//		printLista(list);
				
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
	
	public ListaVertices crearLista(int[] ant, int posO, int posD) {
		ListaVertices lista = new ListaVertices();
		int temp = posD;
		while(temp != posO) {
			int posicion = temp;
			lista.ingresarVerticeInvertido(vertices.buscarVerticeXindice(posicion));
			temp = ant[posicion];			
		}
		lista.ingresarVerticeInvertido(vertices.buscarVerticeXindice(posO));
		return lista;		
	}
	
	public void printLista(ListaVertices lista) {
		Vertice temp = (Vertice) lista.getRaiz();
		while(temp!= null) {
			System.out.print(temp.toString() + "|");
			temp = temp.getSiguiente();
		}
		System.out.println();
	}
}

