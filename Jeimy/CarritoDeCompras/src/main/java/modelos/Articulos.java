package modelos;

public class Articulos {
	
	int precio;
	String NombredelArticulo;	
	String Descripcion;
	int Cantidad;
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNombredelArticulo() {
		return NombredelArticulo;
	}
	public void setNombredelArticulo(String nombredelArticulo) {
		NombredelArticulo = nombredelArticulo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public Articulos(int precio, String nombredelArticulo, String descripcion, int cantidad) {
		super();
		this.precio = precio;
		NombredelArticulo = nombredelArticulo;
		Descripcion = descripcion;
		Cantidad = cantidad;
	}
	
	

}
