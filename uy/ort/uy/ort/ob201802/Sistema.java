package uy.ort.ob201802;

import Repo.AbbAfiliados;
import Repo.Grafo;
import Repo.IVertice;
import uy.ort.ob201802.Modelo.Afiliado;
import uy.ort.ob201802.Modelo.Canalera;
import uy.ort.ob201802.Modelo.Nodo;
import uy.ort.ob201802.Retorno.Resultado;
import uy.ort.ob201802.Util.Cedula;
import uy.ort.ob201802.Util.Email;

public class Sistema implements ISistema {

	private Nodo servidor;
	private AbbAfiliados arbolAfiliados;
	private Grafo grafo;

	@Override
	public Retorno inicializarSistema(int maxPuntos, Double coordX, Double coordY) {
		if (maxPuntos <= 0) {
			return new Retorno(Resultado.ERROR_1);
		} else {
			this.arbolAfiliados = new AbbAfiliados();
			this.grafo = new Grafo(maxPuntos);
			return new Retorno(Resultado.OK);
		}
	}

	@Override
	public Retorno destruirSistema() {
		// arbol, grafo, etc en null
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarAfiliado(String cedula, String nombre, String email) {
		if (!Cedula.checkFormato(cedula) || !Cedula.esCIValida(Cedula.convertirCI(cedula))) {
			return new Retorno(Resultado.ERROR_1);
		} else if (!Email.isValid(email)) {
			return new Retorno(Resultado.ERROR_2);
		} else if (arbolAfiliados.getAfiliadoByCi(cedula) != null) {
			return new Retorno(Resultado.ERROR_3);
		}
		arbolAfiliados.addAfiliado(new Afiliado(cedula, nombre, email));
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno buscarAfiliado(String CI) {
		if (!Cedula.checkFormato(CI) || !Cedula.esCIValida(Cedula.convertirCI(CI))) {
			return new Retorno(Resultado.ERROR_1);
		}
		Afiliado a = arbolAfiliados.getAfiliadoByCi(CI);
		if (a != null) {
			String ret = formatStringBuscarAfiliado(a);
			int nivel = arbolAfiliados.getNivelAfiliado(CI);
			return new Retorno(Resultado.OK, ret, nivel);
		}
		return new Retorno(Resultado.ERROR_2);
	}

	private String formatStringBuscarAfiliado(Afiliado a) {
		return a.getCedula() + ";" + a.getNombre() + ";" + a.getEmail();
	}

	@Override
	public Retorno listarAfiliados() {
		String lista = arbolAfiliados.listarAfiliados();
		return new Retorno(Resultado.OK, lista, 0);
	}

	@Override
	public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
		IVertice vertice = new Canalera(chipid, CIafiliado, coordX, coordY);
		if (this.grafo.arregloHashLleno()) {
			return new Retorno(Resultado.ERROR_1);
		} else if (this.grafo.buscarVertice(coordX, coordY) != null) {
			return new Retorno(Resultado.ERROR_2);
		} else if (this.buscarAfiliado(CIafiliado) == null) {
			return new Retorno(Resultado.ERROR_3);
		}
		this.grafo.registrarVertice(vertice);
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
		IVertice vertice = new Nodo(nodoid, coordX, coordY);
		if (this.grafo.arregloHashLleno()) {
			return new Retorno(Resultado.ERROR_1);
		} else if (this.grafo.buscarVertice(coordX, coordY) != null) {
			return new Retorno(Resultado.ERROR_2);
		}
		this.grafo.registrarVertice(vertice);
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int perdidaCalidad) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno modificarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf,
			int nuevoValorPerdidaCalidad) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno calidadCanalera(Double coordX, Double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno nodosCriticos() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno dibujarMapa() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	public AbbAfiliados getArbolAfiliados() {
		return arbolAfiliados;
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

}
