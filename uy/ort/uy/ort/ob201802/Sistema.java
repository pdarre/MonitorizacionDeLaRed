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
		arbolAfiliados = new AbbAfiliados();
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno destruirSistema() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarAfiliado(String cedula, String nombre, String email) {
		if (!Cedula.esCIValida(Cedula.convertirCI(cedula))) {
			return new Retorno(Resultado.ERROR_1);
		} else if (!Email.isValid(email)) {
			return new Retorno(Resultado.ERROR_2);
		} else if (arbolAfiliados.getAfiliadoByCi(cedula) != null) {
			return new Retorno(Resultado.ERROR_3);
		}
		arbolAfiliados.insertar(new Afiliado(cedula, nombre, email));
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno buscarAfiliado(String CI) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
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

}
