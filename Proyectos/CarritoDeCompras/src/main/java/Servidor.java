import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Modelos.Articulo;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Servidor {
	static ArrayList<Articulo> carrito = new ArrayList();
	static Logger log = LoggerFactory.getLogger(Servidor.class);
	
	public static void main(String[] args) {
		staticFiles.location("/static");
		
		before((req, res) -> {
			if(carrito.size() == 0) {
				carrito.add(new Articulo(
					"Mouse Razer",
					"Un mouse que incluye RGB y DPI muy alto",
					2,
					50f
				));
				carrito.add(new Articulo(
					"Monitor HP",
					"27 Pulgadas, 4k, V-Sync",
					1,
					250f
				));
			}
		});
		
		get("/", (req, res) -> {
			HashMap<String, Object> model = new HashMap<>();
			float total = 0;
			
			for(Articulo art : carrito) {
				log.info(art.getNombre());
				total = total + (art.getCantidad() * art.getPrecio());
			}
			
			model.put("carrito", carrito);
			model.put("total", total);
			
			return new ModelAndView(model, "listar.ftl");
		}, new FreeMarkerEngine());
		
		get("/agregar-articulo", (req, res) -> {
			return new ModelAndView(null, "agregarArticulo.ftl");
		}, new FreeMarkerEngine());
		
		post("/agregar", (req, res) -> {
			String nombre = req.queryParams("nombre");
			String desc = req.queryParams("desc");
			float precio = Float.parseFloat(req.queryParams("precio"));
			int cantidad = Integer.parseInt(req.queryParams("cantidad"));
			
			Articulo nuevoArticulo = new Articulo(nombre, desc, cantidad, precio);
			carrito.add(nuevoArticulo);
			
			res.redirect("/");
			return null;
		});
	}

}
