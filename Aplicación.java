package epn;

import javax.swing.JOptionPane;

public class Aplicación {

	public static void main(String[] args) {
		ListaCircular lista= new ListaCircular();
//		String entrada=JOptionPane.showInputDialog("Ingrese nombre");
		int opcion, opciones;
		/*lista.insertar(entrada);
		lista.recorrer();
		
		lista.eliminar(entrada);*/
		do{
//			Libro libro=new Libro();
			Object[] botones={"Insertar", "Imprimir", "Eliminar"};
			opciones=JOptionPane.showOptionDialog(null,  "Que desea hacer","Opciones",JOptionPane.DEFAULT_OPTION,JOptionPane.NO_OPTION,null,botones, botones[0]);
			
			switch(opciones){
			case 0:{
				String entrada=JOptionPane.showInputDialog("Ingrese nombre de libro");
				lista.insertar(entrada);
				
//				JOptionPane.showMessageDialog(null, lista);
				break;
			}
			
			case 1:{
				lista.imprimir();
				
				
				
				break;
			}
			case 2:{
				String entrada=JOptionPane.showInputDialog("Ingrese libro a eliminar");
				lista.eliminar(entrada);
				
			}
			}
			System.out.println("***********************");
			
			opcion=JOptionPane.showConfirmDialog(null, "Seguir en el sistema", "Continuar",JOptionPane.YES_NO_OPTION);
		}while(opcion==JOptionPane.YES_NO_OPTION);		
		
		
	}

}
