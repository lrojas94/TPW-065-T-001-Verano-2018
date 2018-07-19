package modelos;

public class Pelicula {
	String nombre;
	String categoria;
	String autor;
	String descripcion;
	
	public Pelicula(String nombre, String categoria, String autor, String descripcion) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.autor = autor;
		this.descripcion = descripcion;
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
