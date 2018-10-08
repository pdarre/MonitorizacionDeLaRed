package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import uy.ort.ob201802.ISistema;
import uy.ort.ob201802.Retorno;
import uy.ort.ob201802.Retorno.Resultado;
import uy.ort.ob201802.Sistema;

class Test1 {

	Sistema sis = new Sistema();
	
	@Test
	void testInicializarSistemaError() {
		assertEquals(sis.inicializarSistema(-1, -34.7599678, -55.7271004).resultado.name(), "ERROR_1");
		assertEquals(sis.inicializarSistema(0, -34.7599678, -55.7271004).resultado.name(), "ERROR_1");
		assertEquals(sis.inicializarSistema(20, -34.7599678, -55.7271004).resultado.name(), "OK");
	}
	
	@Test
	void testRegistrarAfiliado() {		
		sis.inicializarSistema(20, -34.7599678, -55.7271004);
		assertEquals(sis.registrarAfiliado("3.341.113-7", "Pablo", "pablo@darre.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("3.341.113-76", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
		assertEquals(sis.registrarAfiliado("3.341.113-8", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
		assertEquals(sis.registrarAfiliado("3.341.113-7", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_3");
	}
}