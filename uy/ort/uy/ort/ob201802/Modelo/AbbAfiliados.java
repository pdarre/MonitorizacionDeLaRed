package uy.ort.ob201802.Modelo;

import uy.ort.ob201802.Util.Cedula;

public class AbbAfiliados {

	private Afiliado raiz;

	public AbbAfiliados() {
		this.raiz = null;
	}

	public Afiliado getRaiz() {
		return raiz;
	}

	public void setRaiz(Afiliado a) {
		this.raiz = a;
	}

	public boolean isEmpty() {
		return (raiz == null);
	}

	public Afiliado getAfiliado(Afiliado afiliado) {
		return null;
	}

	public int cantNodos(Afiliado nodo) {
		int cont = 0;
		if (nodo != null) {
			cont += cantNodos(nodo.getIzq());
			cont++;
			cont += cantNodos(nodo.getDer());

		}
		return cont;
	}

	public int obtenerPeso(Afiliado nodo) {
		int peso = 0;
		int peso_izq = 0;
		int peso_der = 0;

		if (nodo != null) {
			peso_izq = cantNodos(nodo.getIzq());
			peso_der = cantNodos(nodo.getDer());
			peso = peso_izq + peso_der;

		}
		return peso;
	}

	public Afiliado getAfiliadoByCi(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAfiliado(Afiliado nuevo, Afiliado raiz) {
		if (raiz == null) {
			this.setRaiz(nuevo);
		} else {
			if (Cedula.convertirCI(nuevo.getCedula()) <= Cedula.convertirCI(raiz.getCedula())) {
				if (raiz.getIzq() == null) {
					raiz.setIzq(nuevo);
				} else {
					addAfiliado(nuevo, raiz.getIzq());
				}
			} else {
				if (raiz.getDer() == null) {
					raiz.setDer(nuevo);
				} else {
					addAfiliado(nuevo, raiz.getDer());
				}
			}
		}
	}

	public void addAfiliado(Afiliado afiliado) {
		this.addAfiliado(afiliado, this.raiz);
	}
}