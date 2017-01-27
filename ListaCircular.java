package epn;

import java.io.EOFException;

public class ListaCircular {
	private Nodo inicio;
    private Nodo fin;
    int tamaño;
    
    
    public void Lista(){
        inicio = null;
        fin = null;
        tamaño = 0;
    }
    
	  
	
	
	public int getTamaño() {
		return tamaño;
	}

	

	public boolean esVacia(){
        return inicio == null;
	
	}
	
	public void insertarAlInicio(String libro){
	    Nodo nuevo = new Nodo();
        nuevo.setLibro(libro);
        if (esVacia()) {
            inicio=  nuevo;
            fin= nuevo;  
            fin.setSiguiente(inicio);
        } else{
            nuevo.setSiguiente(inicio);
            inicio= nuevo;
            fin.setSiguiente(inicio);
//            inicio.setSiguiente(fin);
        }
        tamaño++;
		
	}
	
	
	public void insertarAlFinal(String libro){
        Nodo nuevo= new Nodo();
        nuevo.setLibro(libro);
        if (esVacia()) {
            inicio=  nuevo;
            fin= nuevo;
            fin.setSiguiente(inicio);
        } else{
            fin.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);
            fin = nuevo;
            
           
        }
        tamaño++;
    }
	
	public void insertarPorPosicion(int posicion,  String libro){
         if(posicion>= 0 && posicion<= tamaño){
            Nodo nuevo= new Nodo(); 
            nuevo.setLibro(libro); 
            if(posicion == 0){
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
                fin.setSiguiente(inicio);
            }
            else{
                  if(posicion == tamaño){
                    
                    fin.setSiguiente(nuevo);
                    nuevo.setSiguiente(inicio);
                    fin  =nuevo;     
                }
                else{
                    Nodo aux = inicio;
                    for (int i=0;  i <(posicion-1); i++) {
                        aux =  aux.getSiguiente();
                    }
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente );
                }
            }
           tamaño++;
        }
    }
	
	
	public void imprimir(){
        if (!esVacia()) {
            Nodo aux = inicio;
            int i = 0;
            do{
                 System.out.print(""+i + ".[ " + aux.getLibro() + " ]\n");
                aux  = aux.getSiguiente();
                i++;
            }while(aux!=inicio);
        }
    }
	
	
	
	
	
	
	 public String buscarPorPosicion(int posicion) throws Exception{
	       if(posicion>=0 && posicion<tamaño){
	            if (posicion == 0) {
	                return inicio.getLibro();
	            }else{
	                Nodo aux = inicio; //Hace una copia de la lista
	                for (int i = 0; i < posicion; i++) {
	                    aux = aux.getSiguiente();
	                }
	                
	                return aux.getLibro(); // regresa el valor del nodo
	            }
	        } else {
//	            throw  new Exception("No existe ese libro, elija valores entre 0 y "+ tamaño);
	            throw  new EOFException("No existe ese libro, elija valores entre 0 y "+ tamaño);
	        }
	    }
	 
	 
	 
	 
	 public String buscarPorPosicion2(int posicion) throws Exception{
	       if(posicion>=0 && posicion<tamaño){
	            if (posicion == 0) {
	                return inicio.getLibro();
	            }
	         
	            else{
	                Nodo aux = inicio; //Hace una copia de la lista
	                for (int i = 0; i < posicion; i++) {
	                    aux = aux.getSiguiente();
	                }
	                
	                return aux.getLibro(); // regresa el valor del nodo
	            }
	        } else {
//	            throw  new Exception("No existe ese libro, elija valores entre 0 y "+ tamaño);
	            throw  new EOFException("No existe ese libro, elija valores entre 0 y "+ tamaño);
	        }
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean buscar(String buscar){
	       Nodo aux = inicio;
	        boolean encontrado = false;
	        do{// busca en la lista hasta regresar al principio
	           if (buscar.equals(aux.getLibro())){
	                  encontrado=  true;
	            }
	            else{aux =  aux.getSiguiente();
	            }
	        }while(aux!=  inicio &&  encontrado!= true);
	        return encontrado;
	        
	    }
	 
	 
	 
	 
	 public int buscarPorNombre(String pBuscar) throws Exception{
	        if (buscar(pBuscar)) {
	            Nodo aux = inicio;
	            int contador = 0; //almacena la posicion del nodo
	            while(!pBuscar.equals(aux.getLibro())){
	                contador++;
	                aux =  aux.getSiguiente();
	            }
	            return contador;
	        } else {
	            throw new Exception("No existe el libro "+ pBuscar);
	        }
	    }
	 
	 
	 public void eliminarPosicion(int posicion){
	       if(posicion>=0 && posicion<tamaño){
	           if(posicion==0){
	                inicio = inicio.getSiguiente();  //elimina el primer nodo apuntando al siguiente
	                fin.setSiguiente(inicio);
	            }
	           else{
	               Nodo aux = inicio;
	               for (int i = 0; i < posicion-1; i++) {
	                    aux= aux.getSiguiente();  
	                }
	                if (aux.getSiguiente()==fin) {
	                    aux.setSiguiente(inicio);
	                    fin = aux;
	                } else {
	                    Nodo siguiente =  aux.getSiguiente();
	                    aux.setSiguiente(siguiente.getSiguiente());  
	                    }
	            }
	           tamaño--;
	        }
	    }



	

}
