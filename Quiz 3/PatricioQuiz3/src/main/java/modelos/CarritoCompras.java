package modelos;

public class CarritoCompras {
String Precio;
String Nombre;
String Descripcion;
String Cantidad;


public CarritoCompras( String Precio , String nombre, String descripcion, String Cantidad) {
	super();
	 Precio= this.Precio;
	Nombre = nombre;
	Descripcion = descripcion;
	Cantidad=this.Cantidad;
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

