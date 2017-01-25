package epn;

import javax.swing.JOptionPane;

public class ListaCircular {
	private Nodo lc;
	 public ListaCircular()
	 {
		 lc = null;
	 }
	 public ListaCircular insertar(String entrada)
	 {
	
		 Nodo nuevo;
	
		 nuevo = new Nodo(entrada);
	
		 if (lc != null) // lista circular no vacía
		 {
			 nuevo.enlace = lc.enlace;
			 lc.enlace = nuevo;
	
		 }
		 lc = nuevo; 		
		 return this;
	 }
	 
	 public void imprimir()	 {
	 	 Nodo p;
	 	 if (lc != null)
	 	 {
	 		 p = lc.enlace; // siguiente nodo al de acceso
	 		 do {
	 			 System.out.println("\t" + p.dato);
//	 			 JOptionPane.showMessageDialog(null, "\t"+ p.dato);
	 			 p = p.enlace;
	 		 }while (p != lc.enlace);
	 	 }
	 	 else
	 		 System.out.println("\t Lista Circular vacía.");
	 	 
	 }
	 
	 
	 public void eliminar(String entrada)
	 {
	 	 Nodo actual;
	 	 boolean encontrado = false;
	 	 //bucle de búsqueda
	 	 actual = lc;
	 	 while ((actual.enlace != lc) && (!encontrado))
	 	 {
//	 		 encontrado = (actual.enlace.dato == entrada);
	 		 encontrado = (actual.enlace.dato.equals(entrada));
	 		 
	 		 if (!encontrado)
	 		 {
	 			 actual = actual.enlace;
	 		 }
	 	 }
	 	 encontrado = (actual.enlace.dato.equals(entrada));
	 	 // Enlace de nodo anterior con el siguiente
	 	 if (encontrado)
	 	 {
	 		 Nodo p;
	 		 p = actual.enlace;		 // Nodo a eliminar
	 		 if (lc == lc.enlace)	 // Lista con un solo nodo
	 			 lc = null;
	 		 else
	 		 {
	 			 if (p == lc)
	 			 {
	 				 lc = actual;	 // Se borra el elemento referenciado por lc,
	 									 // el nuevo acceso a la lista es el anterior
	 			 }
	 			 actual.enlace = p.enlace;
	 		 }
	 		 p = null;
	 	 }
	 }

}
