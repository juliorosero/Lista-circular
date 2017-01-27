package epn;

public class Nodo {
	private String libro;
    private Nodo siguiente;
    
    
    
    public Nodo() {
		super();
		this.libro = "";
		this.siguiente = null;
	}



	public String getLibro() {
		return libro;
	}



	public void setLibro(String libro) {
		this.libro = libro;
	}



	public Nodo getSiguiente() {
		return siguiente;
	}



	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}


	
    

}
