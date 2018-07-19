import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Modelos.Carrito;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Server {
	static ArrayList<Carrito> carrito = new ArrayList<>();
	static Logger log = LoggerFactory.getLogger(Server.class);
	
    public static void main(String[] args) {
    	port(3030);
    	staticFiles.location("/staticFiles");
		// Un filtro de Before que nos permite agregar infomacion
		// A nuestra lista de peliculas vacias.
		before((req, res) -> {
			// Agregamos peliculas si la lista esta vacia
			if (Carrito.size() == 0) {
				carrito.add(new Carrito(
					"Price: 8,800",
					"Article: Jeans",
					"Description: Blue, size 32",
					"Amount: 3"
				));
				carrito.add(new Carrito(
					"Price: 5,000",
					"Article: Fitbit",
					"Description: Clock",
					"Amount: 2"
				));
				carrito.add(new Carrito(
					"Price: 10,000",
					"Article: PS4",
					"Description: Video Game Console",
					"Amount: 1"
				));
			}
		});
		
		
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("carrito", carrito);
			return new ModelAndView(model, "home.ftl");
		}, new FreeMarkerEngine());
	}

}
