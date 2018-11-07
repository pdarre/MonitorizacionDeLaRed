package uy.ort.ob201802.EDD;

import uy.ort.ob201802.Modelo.IVertice;
import uy.ort.ob201802.Modelo.Vertice;

public class ListaVertices {

	IVertice raiz;

	public ListaVertices() {
		raiz = null;
	}

	public boolean esVacia() {
		return raiz == null;
	}

	public void insertarVertice(Vertice vertice) {
		if (raiz == null) {
			raiz = vertice;
		} else {
			IVertice temp = raiz;
			while (temp.getSiguiente() != null) {
				temp = temp.getSiguiente();
			}
			temp.setSiguiente(vertice);
		}
	}

	public IVertice pop() {
		IVertice temp = raiz;
		IVertice retorno = null;
		if (raiz.getSiguiente() == null) {
			raiz = null;
			return temp;
		} else {
			while (temp.getSiguiente() != null) {
				if (temp.getSiguiente().getSiguiente() == null) {
					retorno = temp.getSiguiente();
					temp.setSiguiente(null);
				}
				temp = temp.getSiguiente();
			}
		}
		return retorno;
	}

	public IVertice getRaiz() {
		return raiz;
	}

	public int getSize() {
		int ret = 0;
		IVertice temp = raiz;
		while (temp != null) {
			ret++;
			temp = temp.getSiguiente();
		}
		return ret;
	}

	public IVertice getVertice(int index) {
		IVertice temp = raiz;
		for (int i = 0; i == index; i++) {
			if (i == index) {
				return temp;
			} else {
				temp = temp.getSiguiente();
			}
		}
		return temp;
	}

	public void ingresarVerticeInvertido(Vertice v) {
		if (raiz == null) {
			raiz = v;
		} else {
			v.setSiguiente((Vertice) raiz);
			raiz = v;
		}
	}
}
