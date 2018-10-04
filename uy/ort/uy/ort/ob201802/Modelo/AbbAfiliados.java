package uy.ort.ob201802.Modelo;

public class AbbAfiliados {

	private Afiliado raiz;
	
	public AbbAfiliados() {
		this.raiz = null;
	}
		
	public Afiliado getRaiz() {
		return raiz;
	}

    public boolean isEmpty() {
		return (raiz == null) ;
	}

    public Afiliado getAfiliado(Afiliado afiliado) {
		return null;
	}
	
	public int cantNodos(Afiliado nodo) {
		int cont = 0;
		if(nodo != null)
        {
			cont += cantNodos(nodo.getIzq());
			cont++;
			cont += cantNodos(nodo.getDer());
            
		}
		return cont;
	}

    public int obtenerPeso(Afiliado nodo) {
		int peso     = 0;
		int peso_izq = 0;
		int peso_der = 0;

		if(nodo != null) {
			peso_izq = cantNodos(nodo.getIzq());
			peso_der = cantNodos(nodo.getDer());
			peso = peso_izq + peso_der;
            
		}
		return peso;
	}

    public void insertar(Afiliado afiliado) {        
    }
}