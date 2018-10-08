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
		// TO DO
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
		return getAfiliadoByCi(cedula, this.raiz);
	}
	
	public int cont = 1;
	public Afiliado getAfiliadoByCi(String cedula, Afiliado afiliado) {
		int ci = Cedula.convertirCI(cedula);
		if (afiliado == null) {
			return null;
		} else {
			if (ci == Cedula.convertirCI(afiliado.getCedula())) {
				afiliado.setContador(cont);
				return afiliado;
			} else if (ci < Cedula.convertirCI(afiliado.getCedula())) {
				cont++;
				return getAfiliadoByCi(cedula, afiliado.getIzq());
			} else {
				cont++;
				return getAfiliadoByCi(cedula, afiliado.getDer());
			}
		}
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

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
}