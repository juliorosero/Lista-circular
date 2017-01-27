package epn;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Aplicación {

	public static void main(String[] args) throws Exception {
		ListaCircular listaCircular= new ListaCircular();
		int opcion, opciones;
		
	
		
		do{
			Object[] botones={"Insertar", "Imprimir", "Buscar", "Eliminar"};
			opciones=JOptionPane.showOptionDialog(null, "Que desea hacer","Opciones",JOptionPane.DEFAULT_OPTION,JOptionPane.NO_OPTION,null,botones, botones[0]);
			
			switch(opciones){
			case 0:{ //Insertar
				do{
					Object[] boton1={"Insertar al principio", "Insertar al final", "Por posicion"};
					opciones=JOptionPane.showOptionDialog(null, "como desea ingresar","Opciones",JOptionPane.DEFAULT_OPTION,JOptionPane.NO_OPTION,null,boton1, boton1[0]);
					System.out.println("\n***************************************");
					switch(opciones){
					case 0:{//insertar al inicio
						String libro= JOptionPane.showInputDialog("Ingrese nombre de libro");
						listaCircular.insertarAlInicio(libro);
						listaCircular.imprimir();
					
						break;
					}
					
					case 1:{//insertar al final
						
						String libro= JOptionPane.showInputDialog("Ingrese nombre de libro");
						listaCircular.insertarAlFinal(libro);
						listaCircular.imprimir();
						
						
						break;
					}
					
					case 2:{// insertar por posicion
						String linea=JOptionPane.showInputDialog("Ingrese la posicion y el nuevo libro a ingresar separados por coma");
						StringTokenizer tokens= new StringTokenizer(linea,",");
						int n=Integer.parseInt(tokens.nextToken());
						String libro=tokens.nextToken();
						listaCircular.insertarPorPosicion(n, libro);
						listaCircular.imprimir();
						
						
						break;
					}
					}
				
					opcion=JOptionPane.showConfirmDialog(null, "Seguir Ingresando", "Continuar",JOptionPane.YES_NO_OPTION);
				}while(opcion==JOptionPane.YES_NO_OPTION);	
				
			
					
			
				break;
			}
			
			case 1:{ // IMPRIMIR
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("LA LISTA DE LIBROS ES:");
				listaCircular.imprimir();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
				
				break;
			}
			
			
			case 2:{ //BUSCAR
				do{
					Object[] boton2={"Buscar por indice", "Buscar por nombre", "Imprime circular"};
					opciones=JOptionPane.showOptionDialog(null, "Que desea hacer","Opciones",JOptionPane.DEFAULT_OPTION,JOptionPane.NO_OPTION,null,boton2, boton2[0]);
					switch(opciones){
					case 0:{ //buscar por indice
						int n= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea buscar"));
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//						System.out.println("El libro en la posición "+n+" es: ");
						System.out.println("El libro en la posición "+n+" es: " + listaCircular.buscarPorPosicion(n));
						
						
						
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						
						break;
					}
					case 1:{// buscar por palabra
						String buscar= (JOptionPane.showInputDialog("Ingrese la posicion que desea buscar"));
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("El libro "+buscar+" si existe y está en la posicion: " + listaCircular.buscarPorNombre(buscar));
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
														
						break;
					}
					
					case 2:{ //imprimir circular
						int n= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea buscar"));
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("El libro anterior es " + listaCircular.buscarPorPosicion(n-1));
						System.out.println("El libro en la posición "+n+" es: " + listaCircular.buscarPorPosicion(n));
						System.out.println("El libro siguiente es: " + listaCircular.buscarPorPosicion(n+1));
						
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						int m= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion final"));
						System.out.println("El libro anterior es " + listaCircular.buscarPorPosicion(m-1));
						System.out.println("El libro en la posición "+n+" es: " + listaCircular.buscarPorPosicion(m));
						System.out.println("El libro siguiente es: " + listaCircular.buscarPorPosicion(0));
						
						
						
					}
				
					}	
					opcion=JOptionPane.showConfirmDialog(null, "Desea seguir Buscando", "Continuar",JOptionPane.YES_NO_OPTION);
				}while(opcion==JOptionPane.YES_NO_OPTION);		
						
				
						
						
				break;
			}
			
			
			case 3:{ //ELIMINAR
				int n= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion que desea eliminarr"));
				listaCircular.eliminarPosicion(n);
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("La nueva lista es:");
				listaCircular.imprimir();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
				
				break;
			}
				
			}
			opcion=JOptionPane.showConfirmDialog(null, "Regresar al menu principal", "Continuar",JOptionPane.YES_NO_OPTION);
		}while(opcion==JOptionPane.YES_NO_OPTION);	

	}

}
