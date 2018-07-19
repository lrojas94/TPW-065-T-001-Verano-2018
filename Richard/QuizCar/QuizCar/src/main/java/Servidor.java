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
	// Lista de peliculas
	static ArrayList<Articulos> articulo = new ArrayList<>();
	static Logger log = LoggerFactory.getLogger(Servidor.class);
	
	public static void main(String[] args) {
		staticFiles.location("/staticFiles");
		// Un filtro de Before que nos permite agregar articulo
		// A nuestra lista de articulo vacias.
		before((req, res) -> {
			// Agregamos articulo a la lista
			if (articulo.size() == 0) {
				articulo.add(new Articulos(
				    "GORRA",
				    "1,000",
				    "2",
					"Gorra New Erz Size 3.5"
					));
				articulo.add(new Articulos(
					"USB",
					"3,000",
					"3",
					"USB TOSHIBA 128 GB"
				));
				
				articulo.add(new Articulos(
					"Audifonos",
					"11000",
					"3",
					"Audifonos Beats"
				));
			}
		});
		
		
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			// Ponemos la lista de peliculas en el modelo:
			model.put("articulo", articulo);
			return new ModelAndView(model, "home.ftl");
		}, new FreeMarkerEngine());
	}

}
