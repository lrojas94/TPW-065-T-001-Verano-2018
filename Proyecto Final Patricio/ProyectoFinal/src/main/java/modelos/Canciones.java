package modelos;
import java.util.ArrayList;



public class Canciones {

	String nombre;

	int puntaje;

	ArrayList<String> tema = new ArrayList<>();
	

	public Canciones (String nombre,  int puntaje) {

		super();

		this.nombre = nombre;

		this.puntaje = puntaje;

	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getPuntaje() {
		return puntaje;
	}




	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}




	public ArrayList<String> getTema() {
		return tema;
	}



	public void setTema(ArrayList<String> tema) {
		this.tema = tema;
	}
	}