package uy.ort.ob201802;

public class Main {

	public static void main(String[] args) {
		Sistema sis = new Sistema();
		sis.inicializarSistema(20, 0.200, 0.300);
		sis.registrarAfiliado("3.341.113-7", "Jose Perez", "jose@perez.com");
		
		sis.registrarAfiliado("1.929.434-9", "Jose Perez2", "jose2@perez.com");
		
		sis.registrarAfiliado("2.356.456-4", "Jose Perez3", "jose3@perez.com");
		
		sis.registrarAfiliado("5.929.434-1", "algo", "algo@algo.com");
		
		sis.getArbolAfiliados().setCont(1);
		sis.buscarAfiliado("3.341.113-7");
		
		sis.getArbolAfiliados().setCont(1);
		sis.buscarAfiliado("5.929.434-1");
		
		sis.getArbolAfiliados().setCont(1);
		sis.buscarAfiliado("1.929.434-9");
		
		sis.getArbolAfiliados().setCont(1);
		sis.buscarAfiliado("2.356.456-4");
	}
}