package Estructuras;

import uy.ort.ob201802.Modelo.Vertice;

public class ColaVertices {

	private IVertice raiz, fondo;

	public ColaVertices() {
		raiz = null;
		fondo = null;
	}

	public boolean esVacia() {
		return raiz == null;
	}

	public void insertar(Vertice vertice) {
		vertice.setSiguiente(null);
		if (esVacia()) {
			raiz = vertice;
			fondo = vertice;
		} else {
			fondo.setSiguiente(vertice);
			fondo = vertice;
		}
	}

	public IVertice extraer() {
		IVertice retorno = null;
		IVertice retorno2 = null;
		if(!esVacia()) {
			retorno = raiz;
			retorno2 = raiz.getSiguiente();
			while(retorno2 != null) {
				if(retorno2.getSiguiente() == null) {
					retorno.setSiguiente(null);
					return retorno2;
				}
				retorno = retorno.getSiguiente();
				retorno2 = retorno2.getSiguiente();
			}
		}
		
		
		if (!esVacia()) {
			if (raiz == fondo) {
				retorno = raiz;
				raiz = null;
				fondo = null;
			} else {
				raiz = raiz.getSiguiente();
			}
		}
		return retorno;
	}
}
