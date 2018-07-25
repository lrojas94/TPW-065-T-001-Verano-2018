package modelos;

import java.util.ArrayList;

public class Juego {
	private int id;
	private String nombre;
	private String desarrollador;
	private String categoria;
	private String urlImagen;
	private String descripcion;
	private ArrayList<Consolas> consolas = new ArrayList<>();
	
	public Juego(int id, String nombre, String desarrollador, String categoria, String urlImagen, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.desarrollador = desarrollador;
		this.categoria = categoria;
		this.urlImagen = urlImagen;
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesarrollador() {
		return desarrollador;
	}
	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
				+ "\n Desarrollador: " + this.desarrollador
				+ " - Categoria: " + this.categoria
				+ "\n url de la Imagen: " + this.urlImagen;
	}
	
	public String listaDeConsolas() {
		String lista = "";
		for(Consolas c : consolas) {
			if(c == Consolas.NIN_3DS) {
				lista += "| 3DS |";
			}
			if(c == Consolas.NIN_SWITCH) {
				lista += "| Nintendo Switch |";
			}
			if(c == Consolas.PC) {
				lista += "| PC |";
			}
			if(c == Consolas.PS4) {
				lista += "| PlayStation 4 |";
			}
			if(c == Consolas.XBOXONE) {
				lista += "| XBOX One |";
			}
		}
		
		return lista;
		
	}
}
