package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Repo.HashTableVertices;
import Repo.IVertice;
import uy.ort.ob201802.ISistema;
import uy.ort.ob201802.Retorno;
import uy.ort.ob201802.Sistema;
import uy.ort.ob201802.Modelo.Canalera;
import uy.ort.ob201802.Modelo.Nodo;

class Test1 {

	Sistema sis = new Sistema();

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
//		assertEquals(sis.registrarAfiliado("3.341.113-7", "Pablo", "pablo@darre.com").resultado.name(), "OK");
//		assertEquals(sis.registrarAfiliado("33411137", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
//		assertEquals(sis.registrarAfiliado("3.341.113-8", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_1");
//		assertEquals(sis.registrarAfiliado("3.341.113-7", "Pablo", "pablo@darre.com").resultado.name(), "ERROR_3");
//	}
//	
//	@Test
//	void testBuscarAfiliado() {
//		sis.inicializarSistema(20, -34.7599678, -55.7271004);
//		sis.registrarAfiliado("3.341.113-7", "Pablo", "pablo@pablo.com");
//        sis.registrarAfiliado("1.929.434-9", "Jose", "jose@jose.com");		
//		sis.registrarAfiliado("2.356.456-4", "Juan", "juan@juan.com");
//		assertEquals(sis.buscarAfiliado("3.341.113-7").valorString,"3.341.113-7;Pablo;pablo@pablo.com");
//		assertEquals(sis.buscarAfiliado("3.341.113-7").valorEntero,1);		
//		assertEquals(sis.buscarAfiliado("2.356.456-4").valorString,"2.356.456-4;Juan;juan@juan.com");
//		assertEquals(sis.buscarAfiliado("2.356.456-4").valorEntero,3);
//		assertEquals(sis.buscarAfiliado("1.929.434-9").valorString,"1.929.434-9;Jose;jose@jose.com");
//		assertEquals(sis.buscarAfiliado("1.929.434-9").valorEntero,2);		
//		assertEquals(sis.buscarAfiliado("1.929.434-5").resultado.name(),"ERROR_1");
//		assertEquals(sis.buscarAfiliado("2.456.456-5").resultado.name(),"ERROR_2");
//	}
//	
//	@Test
//	void listarAfiliados() {
//		sis.inicializarSistema(20, -34.7599678, -55.7271004);
//		sis.registrarAfiliado("3.341.113-7", "Pablo", "pablo@pablo.com");
//        sis.registrarAfiliado("1.929.434-9", "Jose", "jose@jose.com");		
//		sis.registrarAfiliado("2.356.456-4", "Juan", "juan@juan.com");
//		assertEquals(sis.listarAfiliados().resultado.name(),"OK");
//	}

	

	@Test
	void test2() {
		Canalera can = new Canalera("canalera1", "3.341.113-7", -23.45675, -36.44567);
		Nodo nod = new Nodo("nodo1", -32.45555, -45.65432);
		
		IVertice n = nod;
		IVertice c = can;

		IVertice[] arrayIVertice = new IVertice[20];

		for (int i = 0; i < arrayIVertice.length; i++) {
			arrayIVertice[i] = null;
		}
		arrayIVertice[0] = c;
		arrayIVertice[1] = n;
		
//		f

		
		HashTableVertices ht = new HashTableVertices(20);
		for (IVertice v : arrayIVertice) {
			int hash = ht.getHashVertice(v);
			System.out.println(hash);
		}
	}
}