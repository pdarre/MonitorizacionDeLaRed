package Test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import uy.ort.ob201802.Retorno;
import uy.ort.ob201802.Sistema;
import uy.ort.ob201802.EDD.ListaVertices;
import uy.ort.ob201802.Modelo.Canalera;
import uy.ort.ob201802.Modelo.Nodo;
import uy.ort.ob201802.Modelo.Vertice;
import uy.ort.ob201802.Util.Dijkstra;

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
		assertEquals(sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@darre.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("11111111", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
		assertEquals(sis.registrarAfiliado("1.111.111-2", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
		assertEquals(sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_3");
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
		assertEquals(sis.buscarAfiliado("1.111.111-2").resultado.name(), "ERROR_1");
		assertEquals(sis.buscarAfiliado("8.888.888-8").resultado.name(), "ERROR_2");
	}

	@Test
	void listarAfiliados() {
		sis.inicializarSistema(20, -34.7599678, -55.7271004);
		sis.registrarAfiliado("3.333.333-3", "Pablo", "pablo@pablo.com");
		sis.registrarAfiliado("1.111.111-1", "Jose", "jose@jose.com");
		sis.registrarAfiliado("2.222.222-2", "Juan", "juan@juan.com");

		Retorno ret = sis.listarAfiliados();
		String res = "1.111.111-1;Jose;jose@jose.com|2.222.222-2;Juan;juan@juan.com|3.333.333-3;Pablo;pablo@pablo.com";
		assertEquals(ret.valorString, res);
		assertEquals(ret.resultado.name(), "OK");
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

		// ERROR_1 no hay mas lugar en el arreglo
		assertEquals(sis.registrarNodo("nodo6", -38.7593868, -12.3865004).resultado.name(), "ERROR_1");
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

		// ERROR_1 no hay mas lugar en el arreglo
		assertEquals(sis.registrarCanalera("chip5", "5.555.555-5", -12.7593868, -51.3865004).resultado.name(),
				"ERROR_1");
	}

	@Test
	void registrarTramo() {
		sis.inicializarSistema(20, -34.7599678, -55.7271004);
		assertEquals(sis.registrarNodo("nodo1", -24.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo2", -30.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo3", -59.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo4", -61.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo5", -12.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("1.111.111-1", "Juan", "juan@juan.com").resultado.name(), "OK");
		assertEquals(sis.registrarCanalera("Canalera-1", "1.111.111-1", -14.7593868, -28.3865004).resultado.name(),
				"OK");

		// servidor - nodo1
		assertEquals(sis.registrarTramo(-34.7599678, -55.7271004, -24.7593868, -51.3865004, 20).resultado.name(), "OK");
		// nodo1 - nodo2
		assertEquals(sis.registrarTramo(-24.7593868, -51.3865004, -30.7593868, -51.3865004, 10).resultado.name(), "OK");
		// nodo2 - nodo3
		assertEquals(sis.registrarTramo(-30.7593868, -51.3865004, -59.7593868, -51.3865004, 30).resultado.name(), "OK");
		// nodo 3 - nodo1
		assertEquals(sis.registrarTramo(-59.7593868, -51.3865004, -24.7593868, -51.3865004, 5).resultado.name(), "OK");
		// nodo3 - nodo4
		assertEquals(sis.registrarTramo(-59.7593868, -51.3865004, -61.7593868, -51.3865004, 8).resultado.name(), "OK");
		// nodo3 - nodo5
		assertEquals(sis.registrarTramo(-59.7593868, -51.3865004, -12.7593868, -51.3865004, 6).resultado.name(), "OK");

		// intenta registrar un tramo con perdida de calidad 0
		assertEquals(sis.registrarTramo(-30.7593868, -51.3865004, -59.7593868, -51.3865004, 0).resultado.name(),
				"ERROR_1");

		// intenta registrar un tramo donde no existen las coordenadas origen
		assertEquals(sis.registrarTramo(-57.8883868, -34.8888004, -30.7593868, -51.3865004, 40).resultado.name(),
				"ERROR_2");

		// intenta registrar un tramo donde no existen las coordenadas destino
		assertEquals(sis.registrarTramo(-30.7593868, -51.3865004, -22.7444868, -51.3865004, 40).resultado.name(),
				"ERROR_2");

		// intenta registrar un tramo ya existente
		assertEquals(sis.registrarTramo(-59.7593868, -51.3865004, -24.7593868, -51.3865004, 5).resultado.name(),
				"ERROR_3");

		// intenta agregar un tramo entre servidor y una canalera
		assertEquals(sis.registrarTramo(-34.7599678, -55.7271004, -14.7593868, -28.3865004, 50).resultado.name(),
				"ERROR_4");

		// modificar nodo3 - nodo4
		assertEquals(sis.modificarTramo(-59.7593868, -51.3865004, -61.7593868, -51.3865004, 14).resultado.name(), "OK");

		// modificar nodo4 -nodo3
		assertEquals(sis.modificarTramo(-61.7593868, -51.3865004, -59.7593868, -51.3865004, 2).resultado.name(), "OK");

		// intenta modificar un tramo con perdida de calidad 0
		assertEquals(sis.modificarTramo(-61.7593868, -51.3865004, -59.7593868, -51.3865004, 0).resultado.name(),
				"ERROR_1");

		// intenta modificar un tramo donde no existen las coordenadas origen
		assertEquals(sis.modificarTramo(-12.7593868, -51.3865004, -24.7593868, -51.3865004, 80).resultado.name(),
				"ERROR_2");
	}

	@Test
	public void calidadCanalera() {
		crearGrafoCompleto();

		Retorno retERROR1 = sis.calidadCanalera(-18.76, -28.35);
		assertEquals(retERROR1.valorEntero, 0);
		assertEquals(retERROR1.resultado.name(), "ERROR_1");

		// registra canalera sin camino a servidor
		assertEquals(sis.registrarCanalera("CanaleraId15", "6.666.666-6", -20.75, -27.35).resultado.name(), "OK");
		Retorno retERROR2 = sis.calidadCanalera(-20.75, -27.35);
		assertEquals(retERROR2.resultado.name(), "ERROR_2");

		// prueba perdida de calidad a canaleraId14
		Retorno retOK = sis.calidadCanalera(-34.885236, -56.108902);
		assertEquals(retOK.valorEntero, 114);
		assertEquals(retOK.resultado.name(), "OK");
	}

	private void crearGrafoCompleto() {
		sis.destruirSistema();
		// Servidor
		sis.inicializarSistema(20, -34.904081, -56.190410);
		// Afiliados
		assertEquals(sis.registrarAfiliado("4.444.444-4", "Lucia", "lucia@lucia.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("3.333.333-3", "Maria", "maria@maria.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("1.111.111-1", "Juan", "juan@juan.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("2.222.222-2", "Luis", "luis@luis.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("6.666.666-6", "Francisco", "francisco@francisco.com").resultado.name(),
				"OK");
		assertEquals(sis.registrarAfiliado("5.555.555-5", "Andres", "andres@andres.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("7.777.777-7", "Lucia2", "lucia2@lucia2.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("8.888.888-8", "Maria2", "maria2@maria2.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("9.999.999-9", "Juan2", "juan2@juan2.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("1.111.112-7", "Luis2", "luis2@luis2.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("1.111.113-3", "Lucia3", "lucia3@lucia3.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("1.111.114-9", "Maria3", "maria3@maria3.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("1.111.115-5", "Juan3", "juan3@juan3.com").resultado.name(), "OK");
		assertEquals(sis.registrarAfiliado("1.111.116-1", "Luis3", "luis3@luis3.com").resultado.name(), "OK");

		// Nodos
		assertEquals(sis.registrarNodo("nodoId1", -34.895378, -56.189077).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodoId2", -34.884016, -56.174349).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodoId3", -34.870581, -56.138626).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodoId4", -34.911098, -56.165418).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodoId5", -34.901274, -56.139839).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodoId6", -34.885342, -56.121980).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodoId7", -34.884928, -56.110715).resultado.name(), "OK");

		// Canaleras
		assertEquals(sis.registrarCanalera("CanaleraId1", "1.111.111-1", -34.893944, -56.189678).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId2", "2.222.222-2", -34.895422, -56.187993).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId3", "3.333.333-3", -34.882872, -56.174210).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId4", "4.444.444-4", -34.883981, -56.172729).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId5", "5.555.555-5", -34.870123, -56.139838).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId6", "6.666.666-6", -34.871400, -56.138315).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId7", "7.777.777-7", -34.910060, -56.166394).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId8", "8.888.888-8", -34.911116, -56.164206).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId9", "9.999.999-9", -34.900156, -56.140515).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId10", "1.111.112-7", -34.902831, -56.139463).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId11", "1.111.113-3", -34.885993, -56.122355).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId12", "1.111.114-9", -34.885571, -56.120467).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId13", "1.111.115-5", -34.885826, -56.111380).resultado.name(),
				"OK");
		assertEquals(sis.registrarCanalera("CanaleraId14", "1.111.116-1", -34.885236, -56.108902).resultado.name(),
				"OK");

		// tramos entre nodos
		// servidor-nodo1-80
		assertEquals(sis.registrarTramo(-34.904081, -56.190410, -34.895378, -56.189077, 80).resultado.name(), "OK");
		// nodo1-nodo2-10
		assertEquals(sis.registrarTramo(-34.895378, -56.189077, -34.884016, -56.174349, 10).resultado.name(), "OK");
		// nodo2-nodo3-30
		assertEquals(sis.registrarTramo(-34.884016, -56.174349, -34.870581, -56.138626, 30).resultado.name(), "OK");
		// servidor-nodo4-20
		assertEquals(sis.registrarTramo(-34.904081, -56.190410, -34.911098, -56.165418, 20).resultado.name(), "OK");
		// nodo4-nodo5-30
		assertEquals(sis.registrarTramo(-34.911098, -56.165418, -34.901274, -56.139839, 30).resultado.name(), "OK");
		// nodo1-nodo4-10
		assertEquals(sis.registrarTramo(-34.895378, -56.189077, -34.911098, -56.165418, 10).resultado.name(), "OK");
		// nodo2-nodo5-20
		assertEquals(sis.registrarTramo(-34.884016, -56.174349, -34.901274, -56.139839, 20).resultado.name(), "OK");
		// nodo3-nodo6-10
		assertEquals(sis.registrarTramo(-34.870581, -56.138626, -34.885342, -56.121980, 10).resultado.name(), "OK");
		// nodo6-nodo7-25
		assertEquals(sis.registrarTramo(-34.885342, -56.121980, -34.884928, -56.110715, 25).resultado.name(), "OK");

		// tramos entre nodo-canalera
		// nodoId1 - canaleraId1
		assertEquals(sis.registrarTramo(-34.895378, -56.189077, -34.893944, -56.189678, 15).resultado.name(), "OK");
		// nodoId1 - canaleraId2
		assertEquals(sis.registrarTramo(-34.895378, -56.189077, -34.895422, -56.187993, 25).resultado.name(), "OK");
		// nodoId2 - canaleraId3
		assertEquals(sis.registrarTramo(-34.884016, -56.174349, -34.882872, -56.174210, 15).resultado.name(), "OK");
		// nodoId2 - canaleraId4
		assertEquals(sis.registrarTramo(-34.884016, -56.174349, -34.883981, -56.172729, 20).resultado.name(), "OK");
		// nodoId3 - canaleraId5
		assertEquals(sis.registrarTramo(-34.870581, -56.138626, -34.870123, -56.139838, 10).resultado.name(), "OK");
		// nodoId3 - canaleraId6
		assertEquals(sis.registrarTramo(-34.870581, -56.138626, -34.871400, -56.138315, 18).resultado.name(), "OK");
		// nodoId4 - canaleraId7
		assertEquals(sis.registrarTramo(-34.911098, -56.165418, -34.910060, -56.166394, 12).resultado.name(), "OK");
		// nodoId4 - canaleraId8
		assertEquals(sis.registrarTramo(-34.911098, -56.165418, -34.911116, -56.164206, 32).resultado.name(), "OK");
		// nodoId5 - canaleraId9
		assertEquals(sis.registrarTramo(-34.901274, -56.139839, -34.900156, -56.140515, 18).resultado.name(), "OK");
		// nodoId5 - canaleraId10
		assertEquals(sis.registrarTramo(-34.901274, -56.139839, -34.902831, -56.139463, 20).resultado.name(), "OK");
		// nodoId6 - canaleraId11
		assertEquals(sis.registrarTramo(-34.885342, -56.121980, -34.885993, -56.122355, 15).resultado.name(), "OK");
		// nodoId6 - canaleraId12
		assertEquals(sis.registrarTramo(-34.885342, -56.121980, -34.885571, -56.120467, 23).resultado.name(), "OK");
		// nodoId7 - canaleraId13
		assertEquals(sis.registrarTramo(-34.884928, -56.110715, -34.885826, -56.111380, 17).resultado.name(), "OK");
		// nodoId7 - canaleraId14
		assertEquals(sis.registrarTramo(-34.884928, -56.110715, -34.885236, -56.108902, 9).resultado.name(), "OK");
	}
	
	@Test
	public void nodosCriticos() {
		this.crearGrafoCompleto();
		
		Retorno ret = sis.nodosCriticos();
		assertEquals(ret.resultado.name() , "OK");
		assertEquals(ret.valorString, "nodoId2|nodoId3|nodoId6|");
	}
}