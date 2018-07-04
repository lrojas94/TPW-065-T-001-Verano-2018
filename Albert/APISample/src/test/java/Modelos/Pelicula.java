package Modelos;

import java.util.ArrayList;

public class Pelicula {
	String nombre;
	String categoria;
	String descripcion;
	int puntaje;
	ArrayList<String> actores = new ArrayList<>();
	
	
	
	public Pelicula(String nombre, String categoria, String descripcion, int puntaje) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.puntaje = puntaje;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public ArrayList<String> getActores() {
		return actores;
	}
	public void setActores(ArrayList<String> actores) {
		this.actores = actores;
	}

	public static Object createPelicula(String queryParams, String queryParams2) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object updatePelicula(String params, String queryParams, String queryParams2) {
		// TODO Auto-generated method stub
		return null;
	}
}
