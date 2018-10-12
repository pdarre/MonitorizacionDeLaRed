package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import Repo.IVertice;
import uy.ort.ob201802.ISistema;
import uy.ort.ob201802.Retorno;
import uy.ort.ob201802.Sistema;
import uy.ort.ob201802.Modelo.Nodo;

class Test1 {

	Sistema sis = new Sistema();
	Retorno ret = new Retorno();

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
		assertEquals(sis.registrarAfiliado("33411137", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
		assertEquals(sis.registrarAfiliado("3.341.113-8", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
		assertEquals(sis.registrarAfiliado("3.341.113-7", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_3");
	}

	@Test
	void testBuscarAfiliado() {
		sis.inicializarSistema(20, -34.7599678, -55.7271004);		
		sis.registrarAfiliado("3.333.333-3", "Juan", "juan@juan.com");
		sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@pablo.com");
		sis.registrarAfiliado("4.444.444-4", "Andres", "andres@andres.com");
		sis.registrarAfiliado("2.222.222-2", "Jose", "jose@jose.com");
		sis.registrarAfiliado("5.555.555-5", "Maria", "maria@maria.com");
		sis.registrarAfiliado("6.666.666-6", "Lucia", "lucia@lucia.com");
		sis.registrarAfiliado("7.777.777-7", "Roberto", "roberto@roberto.com");
		
		assertEquals(sis.buscarAfiliado("4.444.444-4").valorString, "4.444.444-4;Andres;andres@andres.com");
		assertEquals(sis.buscarAfiliado("4.444.444-4").valorEntero, 2);		
		assertEquals(sis.buscarAfiliado("5.555.555-5").valorString, "5.555.555-5;Maria;maria@maria.com");
		assertEquals(sis.buscarAfiliado("5.555.555-5").valorEntero, 3);		
		assertEquals(sis.buscarAfiliado("7.777.777-7").valorString, "7.777.777-7;Roberto;roberto@roberto.com");
		assertEquals(sis.buscarAfiliado("7.777.777-7").valorEntero, 5);				
		assertEquals(sis.buscarAfiliado("1.111.111-2").resultado.name(),"ERROR_1");
		assertEquals(sis.buscarAfiliado("8.888.888-8").resultado.name(),"ERROR_2");
	}

	@Test
	void listarAfiliados() {
		sis.inicializarSistema(20, -34.7599678, -55.7271004);
		sis.registrarAfiliado("3.341.113-7", "Pablo", "pablo@pablo.com");
		sis.registrarAfiliado("1.929.434-9", "Jose", "jose@jose.com");
		sis.registrarAfiliado("2.356.456-4", "Juan", "juan@juan.com");
		assertEquals(sis.listarAfiliados().resultado.name(), "OK");
	}

	@Test
	void registrarNodo() {
		sis.inicializarSistema(2, -34.7599678, -55.7271004);
		assertEquals(sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@pablo.com").resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo1", -24.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo2", -30.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo3", -59.7593868, -51.3865004).resultado.name(), "OK");
		// ERROR_2 ya se encuentra la ubicacion registrada
		assertEquals(sis.registrarNodo("nodo2", -30.7593868, -51.3865004).resultado.name(), "ERROR_2");
		assertEquals(sis.registrarNodo("nodo4", -61.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo5", -12.7593868, -51.3865004).resultado.name(), "OK");
		// ERROR_1 no hay mas lugar en el arreglo
		assertEquals(sis.registrarNodo("nodo6", -38.7593868, -12.3865004).resultado.name(), "ERROR_1");

		IVertice vertice = sis.getGrafo().buscarVertice(-12.7593868, -51.3865004);
		System.out.println(vertice.getTipo());
	}

	@Test
	void registrarCanalera() {
		sis.inicializarSistema(2, -34.7599678, -55.7271004);
		assertEquals(sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@pablo.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("2.222.222-2", "Juan", "juan@juan.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("3.333.333-3", "Lucia", "lucia@lucia.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("4.444.444-4", "Maria", "maria@maria.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("5.555.555-5", "Andres", "andres@andres.com").resultado.name(), "OK");

		assertEquals(sis.registrarCanalera("chip1", "1.111.111-1", -24.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarCanalera("chip2", "2.222.222-2", -59.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarCanalera("chip3", "3.333.333-3", -61.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarCanalera("chip4", "4.444.444-4", -20.7593868, -40.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarCanalera("chip5", "5.555.555-5", -12.7593868, -51.3865004).resultado.name(), "OK");

		assertEquals(sis.registrarCanalera("chip6", "6.666.666-6", -30.7593868, -51.3865004).resultado.name(),
				"ERROR_1");

	}
}