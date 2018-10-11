package Repo;

public class Grafo {

	HashTableVertices vertices;
	int[][] matrizAdy;

	public Grafo(int tam) {
		vertices = new HashTableVertices(tam);
		matrizAdy = new int[vertices.getSize()][vertices.getSize()];
		iniciarMatriz();
	}

	// inicia en 0 todos los valores de la matrizAdy
	public void iniciarMatriz() {
		int largo = matrizAdy.length;
		for (int i = 0; i < largo; i++) {
			for (int j = 0; j < largo; j++) {
				matrizAdy[i][j] = 0;
			}
		}
	}
	
	public int calcularLugarEnArrayVertices(double coordX, double coordY) {
		double sumaCoordenadas = coordX + coordY;
		int sumaInt = (int) sumaCoordenadas;
		int positivo = sumaInt *= -1;
		return positivo % 23;
	}
}
