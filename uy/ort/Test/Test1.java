package Test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import uy.ort.ob201802.Retorno;
import uy.ort.ob201802.Sistema;
import uy.ort.ob201802.Modelo.Canalera;
import uy.ort.ob201802.Modelo.Nodo;
import uy.ort.ob201802.Modelo.Vertice;
import uy.ort.ob201802.Utilidades.Dijkstra;

class Test1 {

	Sistema sis = new Sistema();
	Retorno ret = new Retorno();

//	@Test
//	void testInicializarSistemaError() {
//		assertEquals(sis.inicializarSistema(-1, -34.7599678, -55.7271004).resultado.name(), "ERROR_1");
//		assertEquals(sis.inicializarSistema(0, -34.7599678, -55.7271004).resultado.name(), "ERROR_1");
//		assertEquals(sis.inicializarSistema(20, -34.7599678, -55.7271004).resultado.name(), "OK");
//	}
//
//	@Test
//	void testRegistrarAfiliado() {
//		sis.inicializarSistema(20, -34.7599678, -55.7271004);
//		assertEquals(sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@darre.com").resultado.name(), "OK");
//		assertEquals(sis.registrarAfiliado("11111111", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
//		assertEquals(sis.registrarAfiliado("1.111.111-2", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
//		assertEquals(sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_3");
//	}
//
//	@Test
//	void testBuscarAfiliado() {
//		sis.inicializarSistema(20, -34.7599678, -55.7271004);
//		sis.registrarAfiliado("3.333.333-3", "Juan", "juan@juan.com");
//		sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@pablo.com");
//		sis.registrarAfiliado("4.444.444-4", "Andres", "andres@andres.com");
//		sis.registrarAfiliado("2.222.222-2", "Jose", "jose@jose.com");
//		sis.registrarAfiliado("5.555.555-5", "Maria", "maria@maria.com");
//		sis.registrarAfiliado("6.666.666-6", "Lucia", "lucia@lucia.com");
//		sis.registrarAfiliado("7.777.777-7", "Roberto", "roberto@roberto.com");
//
//		assertEquals(sis.buscarAfiliado("4.444.444-4").valorString, "4.444.444-4;Andres;andres@andres.com");
//		assertEquals(sis.buscarAfiliado("4.444.444-4").valorEntero, 2);
//		assertEquals(sis.buscarAfiliado("5.555.555-5").valorString, "5.555.555-5;Maria;maria@maria.com");
//		assertEquals(sis.buscarAfiliado("5.555.555-5").valorEntero, 3);
//		assertEquals(sis.buscarAfiliado("7.777.777-7").valorString, "7.777.777-7;Roberto;roberto@roberto.com");
//		assertEquals(sis.buscarAfiliado("7.777.777-7").valorEntero, 5);
//		assertEquals(sis.buscarAfiliado("1.111.111-2").resultado.name(), "ERROR_1");
//		assertEquals(sis.buscarAfiliado("8.888.888-8").resultado.name(), "ERROR_2");
//	}
//
//	@Test
//	void listarAfiliados() {
//		sis.inicializarSistema(20, -34.7599678, -55.7271004);
//		sis.registrarAfiliado("3.333.333-3", "Pablo", "pablo@pablo.com");
//		sis.registrarAfiliado("1.111.111-1", "Jose", "jose@jose.com");
//		sis.registrarAfiliado("2.222.222-2", "Juan", "juan@juan.com");
//
//		Retorno ret = sis.listarAfiliados();
//		String res = "1.111.111-1;Jose;jose@jose.com|2.222.222-2;Juan;juan@juan.com|3.333.333-3;Pablo;pablo@pablo.com";
//		assertEquals(ret.valorString, res);
//		assertEquals(ret.resultado.name(), "OK");
//	}
//
//	@Test
//	void registrarNodo() {
//		sis.inicializarSistema(2, -34.7599678, -55.7271004);
//		assertEquals(sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@pablo.com").resultado.name(), "OK");
//		assertEquals(sis.registrarNodo("nodo1", -24.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarNodo("nodo2", -30.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarNodo("nodo3", -59.7593868, -51.3865004).resultado.name(), "OK");
//
//		// ERROR_2 ya se encuentra la ubicacion registrada
//		assertEquals(sis.registrarNodo("nodo2", -30.7593868, -51.3865004).resultado.name(), "ERROR_2");
//		assertEquals(sis.registrarNodo("nodo4", -61.7593868, -51.3865004).resultado.name(), "OK");
//
//		// ERROR_1 no hay mas lugar en el arreglo
//		assertEquals(sis.registrarNodo("nodo6", -38.7593868, -12.3865004).resultado.name(), "ERROR_1");
//	}
//
//	@Test
//	void registrarCanalera() {
//		sis.inicializarSistema(2, -34.7599678, -55.7271004);
//		assertEquals(sis.registrarAfiliado("1.111.111-1", "Pablo", "pablo@pablo.com").resultado.name(), "OK");
//		assertEquals(sis.registrarAfiliado("2.222.222-2", "Juan", "juan@juan.com").resultado.name(), "OK");
//		assertEquals(sis.registrarAfiliado("3.333.333-3", "Lucia", "lucia@lucia.com").resultado.name(), "OK");
//		assertEquals(sis.registrarAfiliado("4.444.444-4", "Maria", "maria@maria.com").resultado.name(), "OK");
//		assertEquals(sis.registrarAfiliado("5.555.555-5", "Andres", "andres@andres.com").resultado.name(), "OK");
//
//		assertEquals(sis.registrarCanalera("chip1", "1.111.111-1", -24.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarCanalera("chip2", "2.222.222-2", -59.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarCanalera("chip3", "3.333.333-3", -61.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarCanalera("chip4", "4.444.444-4", -20.7593868, -40.3865004).resultado.name(), "OK");
//
//		// ERROR_1 no hay mas lugar en el arreglo
//		assertEquals(sis.registrarCanalera("chip5", "5.555.555-5", -12.7593868, -51.3865004).resultado.name(),
//				"ERROR_1");
//	}
//
//	@Test
//	void registrarTramo() {
//		sis.inicializarSistema(20, -34.7599678, -55.7271004);
//		assertEquals(sis.registrarNodo("nodo1", -24.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarNodo("nodo2", -30.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarNodo("nodo3", -59.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarNodo("nodo4", -61.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarNodo("nodo5", -12.7593868, -51.3865004).resultado.name(), "OK");
//		assertEquals(sis.registrarAfiliado("1.111.111-1", "Juan", "juan@juan.com").resultado.name(), "OK");
//		assertEquals(sis.registrarCanalera("Canalera-1", "1.111.111-1", -14.7593868, -28.3865004).resultado.name(), "OK");
//
//		// servidor - nodo1
//		assertEquals(sis.registrarTramo(-34.7599678, -55.7271004, -24.7593868, -51.3865004, 20).resultado.name(), "OK");
//		// nodo1 - nodo2
//		assertEquals(sis.registrarTramo(-24.7593868, -51.3865004, -30.7593868, -51.3865004, 10).resultado.name(), "OK");
//		// nodo2 - nodo3
//		assertEquals(sis.registrarTramo(-30.7593868, -51.3865004, -59.7593868, -51.3865004, 30).resultado.name(), "OK");
//		// nodo 3 - nodo1
//		assertEquals(sis.registrarTramo(-59.7593868, -51.3865004, -24.7593868, -51.3865004, 5).resultado.name(), "OK");
//		// nodo3 - nodo4
//		assertEquals(sis.registrarTramo(-59.7593868, -51.3865004, -61.7593868, -51.3865004, 8).resultado.name(), "OK");
//		// nodo3 - nodo5
//		assertEquals(sis.registrarTramo(-59.7593868, -51.3865004, -12.7593868, -51.3865004, 6).resultado.name(), "OK");
//		printMatriz(sis.getGrafo().getMatriz());
//		
//		//intenta registrar un tramo con perdida de calidad 0
//		assertEquals(sis.registrarTramo(-30.7593868, -51.3865004, -59.7593868, -51.3865004, 0).resultado.name(), "ERROR_1");
//		
//		//intenta registrar un tramo donde no existen las coordenadas origen
//	    assertEquals(sis.registrarTramo(-57.8883868, -34.8888004, -30.7593868, -51.3865004, 40).resultado.name(), "ERROR_2");
//		
//	  //intenta registrar un tramo donde no existen las coordenadas destino
//	    assertEquals(sis.registrarTramo(-30.7593868, -51.3865004, -22.7444868, -51.3865004, 40).resultado.name(), "ERROR_2");
//	    
//	    //intenta registrar un tramo ya existente
//	    assertEquals(sis.registrarTramo(-59.7593868, -51.3865004, -24.7593868, -51.3865004, 5).resultado.name(), "ERROR_3");
//	    
//		//intenta agregar un tramo entre servidor y una canalera
//		assertEquals(sis.registrarTramo(-34.7599678, -55.7271004, -14.7593868, -28.3865004, 50).resultado.name(), "ERROR_4");
//
//		// modificar nodo3 - nodo4
//		assertEquals(sis.modificarTramo(-59.7593868, -51.3865004, -61.7593868, -51.3865004, 14).resultado.name(), "OK");		
//		printMatriz(sis.getGrafo().getMatriz());
//		
//		// modificar nodo4 -nodo3
//		assertEquals(sis.modificarTramo(-61.7593868, -51.3865004, -59.7593868, -51.3865004, 2).resultado.name(), "OK");		
//		printMatriz(sis.getGrafo().getMatriz());	
//		
//		//intenta modificar un tramo con perdida de calidad 0
//		assertEquals(sis.modificarTramo(-61.7593868, -51.3865004, -59.7593868, -51.3865004, 0).resultado.name(), "ERROR_1");
//		
//		//intenta modificar un tramo donde no existen las coordenadas origen
//		assertEquals(sis.modificarTramo(-12.7593868, -51.3865004, -24.7593868, -51.3865004, 80).resultado.name(), "ERROR_2");
//
//		//solo para pruebas, BORRAR!!!
//		printArray(sis.getGrafo().getHashTableVertices().getVertices());
//	}
	
	@Test
	public void testDijktra() {
		sis.inicializarSistema(5, -34.7599678, -55.7271004);
		assertEquals(sis.registrarNodo("nodo1", -24.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo2", -30.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo3", -59.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo4", -61.7593868, -51.3865004).resultado.name(), "OK");
		assertEquals(sis.registrarNodo("nodo5", -12.7593868, -51.3865004).resultado.name(), "OK");
		
		//servidor-nodo1-20
		sis.registrarTramo(-34.7599678, -55.7271004, -24.7593868, -51.3865004, 20);
		
		//nodo1-nodo2-30
		sis.registrarTramo(-24.7593868, -51.3865004, -30.7593868, -51.3865004, 30);
		
		//nodo2-nodo3-20
		sis.registrarTramo(-30.7593868, -51.3865004, -59.7593868, -51.3865004, 20);
		
		//nodo2-nodo4-10
		sis.registrarTramo(-30.7593868, -51.3865004, -61.7593868, -51.3865004, 10);
		
		//nodo4-nodo5-40
		sis.registrarTramo(-61.7593868, -51.3865004, -12.7593868, -51.3865004, 40);
		
		//nodo3-nodo5-10
		sis.registrarTramo(-59.7593868, -51.3865004, -12.7593868, -51.3865004, 10);
		
		//nodo4-servidor-40
		sis.registrarTramo(-61.7593868, -51.3865004, -34.7599678, -55.7271004, 40);
		
		Dijkstra dijkstra = new Dijkstra(sis.getGrafo());
		dijkstra.dijkstra_GetMinDistances(2);
		
	}

	//BORRAR!!!
	public void printMatriz(int[][] matriz) {
		int largo = sis.getGrafo().getMatriz().length;
		for (int i = 0; i < largo; i++) {
			for (int j = 0; j < largo; j++) {
				int valor = sis.getGrafo().getMatriz()[i][j];
				if (valor != 0) {
					System.out.print("{" + i + "}");
					System.out.print("{" + j + "}");
					System.out.println(valor);
				}
			}
			System.out.print("");
		}
		System.out.println();
	}

	//BORRAR!!!
	public void printArray(Vertice[] v) {
		for (int i = 0; i < v.length; i++) {
			if (v[i] != null) {
				System.out.println(v[i].getVerticeId() + "-" + i);
			}
		}
	}

}