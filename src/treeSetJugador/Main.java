package treeSetJugador;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		TreeSet<Jugador> tSJugador = new TreeSet<Jugador>();
		String opcion = "";
		Iterator<Jugador> iterator = tSJugador.iterator();
		do
		{
			mostrarMenu();
			System.out.println("Introduzca la opcion deseada: ");
			opcion = sc.nextLine();
			switch (opcion) {
			case "1":
				System.out.print("Nombre: ");
				String nombre = sc.nextLine();
				int estatura = 0;
				while(estatura <= 0)
				{	
					try
					{
						System.out.print("Estatura en centimetros: ");
						estatura = Integer.parseInt(sc.nextLine());
						if(estatura <= 0)
							System.out.println("Debe ser un número entero positivo.");
					}
					catch(NumberFormatException e)
					{
						System.out.println("Debe ser un número entero positivo.");
					}
				}	
				Jugador jugador = new Jugador(nombre, estatura);
				if(tSJugador.add(jugador))
					System.out.println("Jugador almacenado.");
				else
					System.out.println("Jugador repetido.");
				break;
			case "2":
				if(!tSJugador.isEmpty())
				{	
					iterator = tSJugador.iterator();
					System.out.println("Listado jugadores:");
					while(iterator.hasNext())
					{
						System.out.println("Nombre: " + iterator.next().getNombre());
					}
				}
				else
					System.out.println("No hay jugadores almacenados.");
				break;
			case "3":
				System.out.print("Nombre del jugador a eliminar: ");
				nombre = sc.nextLine();
				jugador = new Jugador(nombre, 0);
				if(tSJugador.remove(jugador))
					System.out.println("Jugador borrado.");
				else
					System.out.println("El jugador no está almacenado.");
				break;
			case "4":
				tSJugador.clear();
				break;
			case "5":
				System.out.println("Hasta luego.");
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		}
		while(!opcion.equals("5"));
		sc.close();
	}
	
	private static void mostrarMenu()
	{
		System.out.println("\nMenú:\n" +
			"1.-Introducir jugador.\n" +
			"2.-Listar jugadores.\n" +
			"3.-Eliminar jugador.\n" +
			"4.-Borrar todos.\n" +
			"5.-Salir.\n");
	}
}
