import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import modelos.Articulos;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Servidor {
	//hasta aqui pude llegar
	// Lista de articulos
	static ArrayList<Articulos> articulos = new ArrayList<>();
	
	public static void main(String[] args) {
		staticFiles.location("/staticFiles");
		// Un filtro de Before que nos permite agregar infomacion
		// A nuestra lista de peliculas vacias.

		before((req, res) -> {
			// Agregamos peliculas si la lista esta vacia
			if (articulos.size() == 0) {
				articulos.add(new Articulos(
					"30",
					"Audifonos",
					"inalambricos",
					"10"
				));
				articulos.add(new Articulos(
				"12",
				"Auxiliar",
				"de colores",
				"10"
				));
				articulos.add(new Articulos(
						"20",
						"Cargador",
						"inalambricos",
						"10"
				));
			}
		});
		
		// Dentro de la ruta slash (/) listaremos los articulos.
		// La pasamos dentro del modelo para que el template (home.ftl)
		// pueda hacer uso de la lista.
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			// Ponemos la lista de peliculas en el modelo:
			model.put("articulos", articulos);
			return new ModelAndView(model, "home.ftl");
		}, new FreeMarkerEngine());
	}

}
