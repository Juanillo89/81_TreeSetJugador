package treeSetJugador;

public class Jugador implements Comparable<Jugador>
{
	private String nombre;
	private int estatura;
	
	public Jugador(String nombre, int estatura)
	{
		this.nombre = nombre;
		this.estatura = estatura;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(((Jugador)o).getNombre().compareToIgnoreCase(nombre) == 0)
			return true;
		return false;
	}
	
	@Override
	public int compareTo(Jugador o)
	{
		if(((Jugador)o).getNombre().compareToIgnoreCase(nombre) < 0)
			return 1;
		else if(((Jugador)o).getNombre().compareToIgnoreCase(nombre) > 0)
			return -1;
		else
			return 0;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getEstatura()
	{
		return estatura;
	}
}
