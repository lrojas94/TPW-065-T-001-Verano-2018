import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import modelos.CarritoCompras;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;


public class Servidor {
	// Lista de Ropa
	static ArrayList<CarritoCompras> CarritoCompras = new ArrayList<>();
	static Logger log = LoggerFactory.getLogger(Servidor.class);
	
	public static void main(String[] args) {
		staticFiles.location("/staticFiles");
		// Un filtro de Before que nos permite agregar infomacion
		// A nuestra lista de peliculas vacias.
		before((req, res) -> {
			// Agregamos peliculas si la lista esta vacia
			if (CarritoCompras.size() == 0) {
				CarritoCompras.add(new CarritoCompras(
					"Camisa",
					"Rojas",
					"Samll",
					"$US 12.00"
				));
				CarritoCompras.add(new CarritoCompras(
					"T-shirt",
					"Azul",
					"large",
					"$US 15.00"
				));
				CarritoCompras.add(new CarritoCompras(
					"Pantalon",
					"negro",
					"33*35",
					"$US 20.00"
				));
			}
		});
		

/*Quiz #3:
Crear una pagina web que muestre un carrito de compras utilizando templates. 
Asuma que un articulo en el carrito de compra necesita los siguientes valores:
- Precio
- Nombre del articulo
- Descripcion
- Cantidad de articulos a comprar.

Ha de mostrar, tanto el total en el carrito, como el total de un articulo en especifico,
por ejemplo:

CARRITO:

- Gorra (Cantidad: 2) - Unidad: $1.00 | Total: $2.00
- USB (Cantidad: 1) - Unidad: $0.50 | Total: $0.50 

Total: $2.50


BONO:
1) mostrar los articulos en orden de precio (Organizarlos en el servidor) (1.5 pts)
2) Bono por diseno. (0.5 pts)*/
		// Dentro de la ruta slash (/) listaremos las peliculas.
		// La pasamos dentro del modelo para que el template (home.ftl)
		// pueda hacer uso de la lista.
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			// Ponemos la lista de peliculas en el modelo:
			model.put("CarritoCompras", CarritoCompras);
			return new ModelAndView(model, "home.ftl");
		}, new FreeMarkerEngine());
	}

}
