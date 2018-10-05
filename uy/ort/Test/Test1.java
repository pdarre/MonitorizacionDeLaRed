package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import uy.ort.ob201802.Retorno.Resultado;
import uy.ort.ob201802.Sistema;
import uy.ort.ob201802.Modelo.Cedula;

class Test1 {

	Sistema sis = new Sistema();
	
	@Test
	void test() {
		Sistema sis = new Sistema();
		String ret = sis.inicializarSistema(20, -34.7599678, -55.7271004).resultado.name();
		String res = "NO_IMPLEMENTADA";
		assertEquals(ret, res);
	}
	
	@Test
	void testInicializarSistema() {
		assertEquals(Resultado.NO_IMPLEMENTADA, sis.inicializarSistema(20, -34.7599678, -55.7271004).resultado);
	}
	
	@Test
	void testValidadorCedula() {
		String ci = "3.341.113-7";
		int ced = Cedula.convertirCedula(ci);
		boolean valida = Cedula.esCIValida(Cedula.convertirCedula(ci));
	}
	
	@Test
	void probarParseo() {
		int res = Cedula.convertirCedula("3.341.113-7");
		System.out.println();
	}
}