import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import modelos.Pelicula;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Servidor {
	// Lista de peliculas
	static ArrayList<Pelicula> peliculas = new ArrayList<>();
	static Logger log = LoggerFactory.getLogger(Servidor.class);
	
	public static void main(String[] args) {
		staticFiles.location("/staticFiles");
		// Un filtro de Before que nos permite agregar infomacion
		// A nuestra lista de peliculas vacias.
		before((req, res) -> {
			// Agregamos peliculas si la lista esta vacia
			if (peliculas.size() == 0) {
				peliculas.add(new Pelicula(
					"Minions",
					"Familia",
					"Disney",
					"Una pelicula muy divertida"
				));
				peliculas.add(new Pelicula(
					"Avatar",
					"Accion",
					"James Cameron",
					"Pelicula sobre el espacio exterior"
				));
				peliculas.add(new Pelicula(
					"Hercules",
					"Familia",
					"Disney",
					"Historia del semi-dios Hercules"
				));
			}
		});
		
		// Dentro de la ruta slash (/) listaremos las peliculas.
		// La pasamos dentro del modelo para que el template (home.ftl)
		// pueda hacer uso de la lista.
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			// Ponemos la lista de peliculas en el modelo:
			model.put("peliculas", peliculas);
			return new ModelAndView(model, "home.ftl");
		}, new FreeMarkerEngine());
	}

}
