import java.util.Scanner;
import java.util.ArrayList; //Importo dos librerías

public class ListaDeAlumnos {
	
	private static void agregarAlumno(ArrayList<String> alumno, String nombre) { //Creo un método llamado agregarAlumno sin retorno con el modificador de acceso private
		alumno.add(nombre); //Agrego el alumno al ArrayList
		System.out.println("\nNombre agregado con éxito\n");
	}

	private static void eliminarAlumno(ArrayList<String> alumno, Scanner teclado, int eliminar) { //Lo mismo pero se elimina el alumno por el nombre o por la posicion
		switch (eliminar) { //Creo un switch para que se lea bien el codigo, una segunda opción del if
		case 1:
			System.out.print("\nIngrese el nombre a eliminar: ");
			String nombreEliminar = teclado.next(); //Se guarda la variable lo introducido por el usuario
			boolean eliminado = alumno.remove(nombreEliminar); //Aquí, utilizo un booleano para verificar si el alumno existe o no. (true or false). Si es true se elimina el alumno, al contrario no se eliminará
			if (eliminado) { //Si el alumno existe, o sea, es true
				System.out.println("\nSe eliminó el alumno\n");
			} else {
				System.out.println("\nNo se encontró el alumno\n"); //Al contrario no se va a eliminar
			} //Se utiliza un if para evitar si el alumno no llega a existir que el programa salte errores y se pare la ejecución
			break; //Finaliza el caso 1 para evitar que se siga ejecutándose a continuación

		case 2:
			try { //Aquí, es una tercera opción del if, para manejar bien los erroes mediante la ejecución
				System.out.print("\nIngrese la posición a eliminar: "); //Lo mismo pero con la posición que se encuentra el alumno
				int posicionEliminar = teclado.nextInt();
				alumno.remove(posicionEliminar); //Aquí, si la posición llega a existir se va a eliminarse. Al contrario, esto evitará que se pare la ejecución y que no salte errores
				System.out.println("\nSe eliminó el alumno\n");
			} catch (IndexOutOfBoundsException e) { //Si llega no existir la posición, se va a ejecutarse aquí
				System.out.println("\nNo se encontró el alumno\n"); //Y mostrará un mensaje del motivo
			}
			break;

		default: //Por si la opcion no llega a existir
			System.out.println("\nEsa opción no existe\n");
		}
	}

	private static void modificarAlumno(ArrayList<String> alumno, int posicion, String nuevoNombre) { //Lo mismo pero modificamos el nombre del alumno
		try { 
			alumno.set(posicion, nuevoNombre); //Aquí, primero se inserta la posición de donde se encuentra el alumno a modificarse, luego el nuevo nombre
			System.out.println("\nNombre modificado\n");
		} catch (IndexOutOfBoundsException e) { //Evitamos que se finalize el programa
			System.out.println("\nNo se encontró la posición\n");
		}
	}
	
	private static void listarAlumno(ArrayList<String> alumno) { //Lo mismo pero listo todos los alumnos
		int x = 0; //Creo una variable que se inicializa a cero
		System.out.println("Alumnos:\n");
		for(String y: alumno) { //Es un foreach especialmente para los arrays
			System.out.println(x+"-> "+y); //Lo imprimimos en consola
			x++; //Sumamos uno
		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<String> alumnos = new ArrayList<String>(); //Creo el Scanner llamado "teclado" y un ArrayList de tipo String llamado "alumnos"
		
		int opcion; //Creo una variable de tipo int para el menú
		
		do {
			System.out.println("----------------- MENÚ ------------------" //Muestro el menú
					+ "\n1. Agregar alumnos"
					+ "\n2. Borrar alumnos"
					+ "\n3. Borrar todos los alumos"
					+ "\n4. Reemplazar alumno por otro"
					+ "\n5. Obtener alumno mediante el índice especificado"
					+ "\n6. Obtener número de cantidad de alumnos"
					+ "\n7. Obtener la posición de un alumno"
					+ "\n8. Listar los alumnos"
					+ "\n9. Finalizar programa"
					+ "\n-----------------      ------------------\n");
			opcion = teclado.nextInt(); //Guardo la opción que insertó el usuario
			
			 if (alumnos.isEmpty() && opcion!=9 && opcion!=1) { //Aquí, si la lista esta vacía muestro un mensaje que "la lista está vacía y que intente agregar alumnos a la lista"
		            System.out.println("La lista de alumnos está vacía. Intenta agregar alumnos primero\n");
		            continue; //Si la lista llega a estar vacía, omite las instrucciones que se encuentran abajo
			 }
			
			switch(opcion) { 
			case 1:
				System.out.print("Ingrese un nombre: ");
				String nombre = teclado.next();
				agregarAlumno(alumnos, nombre); //Invoco la función "agregarAlumno". Luego le paso la función el ArrayList y la variable que se almacenó
				break;
				
			case 2:
				System.out.println("¿Cómo quieres eliminar el alumno?\n1. Por su nombre\n2. Por su posición");
				int eliminar = teclado.nextInt();
				eliminarAlumno(alumnos, teclado, eliminar); //Aquí es lo mismo. Pero eliminamos un alumno y también le paso el Scanner
				break;
				
			case 3:
				alumnos.clear(); //Borro todo el ArrayList
				System.out.println("Se eliminó todos los alumnos\n");
				break;
				
			case 4:
				System.out.print("Ingrese la posición del alumno para cambiarlo: ");
				int posicion = teclado.nextInt();
				System.out.print("Ingrese el nuevo nombre: ");
				String nuevoNombre = teclado.next();
				modificarAlumno(alumnos, posicion, nuevoNombre); //Lo mismo pero modificamos el alumno
				break;
				
			case 5:
				try {
				System.out.print("Ingrese la posición: ");
				posicion = teclado.nextInt();
				System.out.println("\nLa posición "+posicion+" corresponde a: "+alumnos.get(posicion)+"\n"); //Aquí, se encuentra el alumno mediante la posición
				}catch(IndexOutOfBoundsException e) {
					System.out.println("\nLa posición no existe\n");
				}
				break;
				
			case 6:
				System.out.println("En total hay: "+alumnos.size()+"\n"); //Aquí, mostramos la cantidad de alumnos que existen
				break;
				
			case 7:
				System.out.print("Ingrese el nombre del alumno: ");
				String alumno = teclado.next();
				for(String y: alumnos) { //Recorremos todo el array si el alumno llega a existir o no
					if(alumnos.contains(alumno)) { //Aquí, el método contains verifica si el alumno existe o no
						System.out.println("\nEl alumno "+alumno+" tiene la posición: "+alumnos.indexOf(alumno)+"\n"); //Aquí, obtenemos la posición de un alumno en específico
						break;
					}else {
						System.out.println("\nEl nombre no existe\n");
						break;
					}
				}
				break;
				
			case 8:
				listarAlumno(alumnos); //Lo mismo pero listamos todos los alumnos
				System.out.println();
				break;
				
			case 9:
				System.out.print("Finalizando programa.");
				for(int i=0; i<=4; i++) {
					try {
						Thread.sleep(1000); //Creo un sleep de un segundo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.print(".");
				}
				teclado.close(); //Cierro el Scanner
				System.out.println("\nPrograma finalizado");
				System.exit(0); //Finalizo la ejecución
				break;
				
				default: //Se muestra un mensaje por si el usuario inserta una opción que no exista
					System.out.println("Esa opción no existe\n");
					break;
			}
		}while(opcion!=9); //Se sale del bucle do while si el usuario inserta una opción del menú

	}
}

// CREATED BY NAHUEL TELLECHEA FREIRE