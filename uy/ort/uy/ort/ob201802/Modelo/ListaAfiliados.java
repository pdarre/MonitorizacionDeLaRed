package uy.ort.ob201802.Modelo;

public class ListaAfiliados {

	Afiliado raiz;

	public ListaAfiliados() {
		this.raiz = null;
	}

	public void insertarAfiliado(Afiliado afiliado) {
		if (raiz == null) {
			raiz = afiliado;
		} else {
			Afiliado temp = raiz;
			while (temp.getSig() != null) {
				temp = temp.getSig();
			}
			temp.setSig(afiliado);
		}
	}

	public Afiliado getRaiz() {
		return raiz;
	}

	public void setRaiz(Afiliado raiz) {
		this.raiz = raiz;
	}
}
