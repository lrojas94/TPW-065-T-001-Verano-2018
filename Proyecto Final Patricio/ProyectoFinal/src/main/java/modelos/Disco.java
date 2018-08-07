package modelos;

import java.util.ArrayList;

public class Disco {
	private int id;
	private String nombre;
	private String urlImagen;
	private String descripcion;
	private ArrayList<Consolas> consolas = new ArrayList<>();
	
	public Disco(int id, String nombre,  String urlImagen, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.urlImagen = urlImagen;
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<Consolas> getConsolas() {
		return consolas;
	}
	public void setConsolas(ArrayList<Consolas> consolas) {
		this.consolas = consolas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: " + this.nombre
				+ "\n Descripcion: " + this.descripcion
				+ "\n url de la Imagen: " + this.urlImagen;
	}
	
	public String listaDeConsolas() {
		String lista = "";
		for(Consolas c : consolas) {
			if(c == Consolas.Salsa) {
				lista += "|Salsa |";
			}
			if(c == Consolas.Bachata) {
				lista += "| Bachata |";
			}
			if(c == Consolas.Dance) {
				lista += "| Dance |";
			}
			if(c == Consolas.Urbano) {
				lista += "| Urbano |";
			}
			if(c == Consolas.Merengue) {
				lista += "| Merengue |";
			}
		}
		
		return lista;
		
	}
}
