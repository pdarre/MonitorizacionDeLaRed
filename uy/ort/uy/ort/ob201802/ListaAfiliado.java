package uy.ort.ob201802;

public class ListaAfiliado {

	Afiliado raiz;
	
	public ListaAfiliado() {
		raiz = null;
	}

	public boolean esVacia() {
		return raiz == null;
	}

	public void insertarVertice(Afiliado afiliado) {
		if (raiz == null) {
			raiz = afiliado;
		} else {
			Afiliado temp = raiz;
			while (temp.getSiguiente() != null) {
				temp = temp.getSiguiente();
			}
			temp.setSiguiente(afiliado);
		}
	}

	public Afiliado pop() {
		Afiliado temp = raiz;
		Afiliado retorno = null;
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

	public Afiliado getRaiz() {
		return raiz;
	}

	public int getSize() {
		int ret = 0;
		Afiliado temp = raiz;
		while (temp != null) {
			ret++;
			temp = temp.getSiguiente();
		}
		return ret;
	}
}
