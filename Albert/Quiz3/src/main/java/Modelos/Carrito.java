package Modelos;

public class Carrito {
String Precio;
String Nombre;
String Descripcion;
String Cantidad;


public Carrito(String precio, String nombre, String descripcion, String cantidad) {
	super();
	Precio = precio;
	Nombre = nombre;
	Descripcion = descripcion;
	Cantidad = cantidad;
}


public String getPrecio() {
	return Precio;
}
public void setPrecio(String precio) {
	Precio = precio;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getDescripcion() {
	return Descripcion;
}
public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}
public String getCantidad() {
	return Cantidad;
}
public void setCantidad(String cantidad) {
	Cantidad = cantidad;
}


public static int size() {
	// TODO Auto-generated method stub
	return 0;
}




}
