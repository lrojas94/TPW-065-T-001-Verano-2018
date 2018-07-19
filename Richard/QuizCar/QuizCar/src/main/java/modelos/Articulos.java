package modelos;

public class Articulos {
	
	String namearticulo;
	String precio;
	String cantidadarti;
	String descripcion;
	
	public Articulos(String namearticulo, String precio, String cantidadarti, String descripcion) {
		super();
		
		this.namearticulo = namearticulo;
		this.precio = precio;
		this.cantidadarti = cantidadarti;
		this.descripcion = descripcion;
	}
	
	
	public String getNamearticulo() {
		return namearticulo;
	}
	public void setNamearticulo(String categoria) {
		this.namearticulo = namearticulo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String nombre) {
		this.precio = precio;
	}
	public String getCantidadarti() {
		return cantidadarti;
	}
	public void setCantidadarti(String autor) {
		this.cantidadarti = cantidadarti;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
