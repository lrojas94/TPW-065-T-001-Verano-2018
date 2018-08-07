package Modelos;

public class Articulo {
	String nombre;
	String desc;
	int cantidad;
	float precio;
	
	public Articulo(String nombre, String desc, int cantidad, float precio) {
		super();
		this.nombre = nombre;
		this.desc = desc;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
