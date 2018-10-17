package uy.ort.ob201802.EDD;

import uy.ort.ob201802.Modelo.Afiliado;

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

	public String listarAfiliados() {
		if(this.raiz==null)return null;
		String retorno = "";
		Afiliado temp = this.raiz;
		while (temp != null) {
			if (temp.getSig() == null) {
				retorno += temp.getCedula() + ";" + temp.getNombre() + ";" + temp.getEmail();
			}else {
				retorno += temp.getCedula() + ";" + temp.getNombre() + ";" + temp.getEmail() + "|";
			}
			temp = temp.getSig();
		}
		return retorno;
	}
}
