package uy.ort.ob201802;

import uy.ort.ob201802.Modelo.AbbAfiliados;
import uy.ort.ob201802.Modelo.Afiliado;
import uy.ort.ob201802.Modelo.Nodo;
import uy.ort.ob201802.Retorno.Resultado;
import uy.ort.ob201802.Util.Cedula;
import uy.ort.ob201802.Util.Email;

public class Sistema implements ISistema {

	private Nodo servidor;
	private AbbAfiliados arbolAfiliados;

	@Override
	public Retorno inicializarSistema(int maxPuntos, Double coordX, Double coordY) {		
		if (maxPuntos <= 0) {
			return new Retorno(Resultado.ERROR_1);
		} else {
			arbolAfiliados = new AbbAfiliados();
			return new Retorno(Resultado.OK);
		}
	}

	@Override
	public Retorno destruirSistema() {
		//arbol, grafo, etc en null
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarAfiliado(String cedula, String nombre, String email) {
		if (Cedula.checkFormato(cedula) && !Cedula.esCIValida(Cedula.convertirCI(cedula))) {
			return new Retorno(Resultado.ERROR_1);
		} else if (!Email.isValid(email)) {
			return new Retorno(Resultado.ERROR_2);
		} else if (arbolAfiliados.getAfiliadoByCi(cedula) != null) {
			return new Retorno(Resultado.ERROR_3);
		}
		arbolAfiliados.addAfiliado(new Afiliado(cedula, nombre, email));
		return new Retorno(Resultado.OK);
	}

	// recordar poner en 1 el contador luego de cada busqueda
	// decidi poner este contador para evitar hacer dos pasadas en el arbol por cada
	// busqueda
	@Override
	public Retorno buscarAfiliado(String CI) {
		Afiliado a = arbolAfiliados.getAfiliadoByCi(CI);
		String ret = formatStringBuscarAfiliado(a);
		if (a != null) {
			return new Retorno(Resultado.OK, ret, a.getContador());
		}
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	private String formatStringBuscarAfiliado(Afiliado a) {
		return a.getCedula() + ";" + a.getEmail() + ";" + a.getNombre();
	}

	@Override
	public Retorno listarAfiliados() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarCanalera(String chipid, String CIafiliado, Double coordX, Double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarNodo(String nodoid, Double coordX, Double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
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

}
