import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.LoggerFactory;

import freemarker.log.Logger;
import modelos.Juego;
import modelos.Consolas;
import spark.template.freemarker.FreeMarkerEngine;

public class Servidor {
	
	static ArrayList<Juego> juegos = new ArrayList<>();
	// Contador con el que asignaremos un ID Unico a cada
	// uno de nuestros juegos.
	static int idCounter = 0;
	
	public static void main(String[] args) {
		org.slf4j.Logger log = LoggerFactory.getLogger(Servidor.class);
        
		before((req, res) -> {
			// si la lista esta vacia,
			// Agregamos algunos juegos para
			// que el usuario nunca vea una pantalla
			// vacia.
			if(juegos.size() == 0) {
				juegos.add(new Juego(
					-2,
					"Fortnite", 
					"Square Enix", 
					"Battle Royale", 
					"https://ih0.redbubble.net/image.553222704.1931/flat,550x550,075,f.u1.jpg", 
					"Juego popular de Battle Royale"
				));
				juegos.add(new Juego(
					-1,
					"Vice City", 
					"Toni Montana", 
					"Adulto", 
					"https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/Vice-city-cover.jpg/220px-Vice-city-cover.jpg", 
					"Un clasico"
				));
			}
		});
		
		// Ruta para listar todos los
		// juegos que se encuentren en la lista.
		get("/", (req, res) -> {
        	HashMap<String, Object> model = new HashMap<>();
        	// Ponemos la lista de juegos en el modelo.
        	model.put("juegos", juegos);
        	return modelAndView(model, "juego/listar.ftl");
		}, new FreeMarkerEngine());
		
		// Ruta que permite visualizar 1 solo juego.
		// Mediante el ID, podemos acceder un juego en
		// especifico
		get("ver-juego/:id", (req, res) -> {
			// tomamos el ID de la URL.
			int id = Integer.parseInt(req.params(":id"));
			// Asumimos que el juego no existe.
			Juego juego = null;
			
			for(Juego j : juegos) {
				// Si encontramos un juego en la lsita
				// con el Id que deseamos, entonces el juego
				// existe y lo guadamos en la variable juego.
				if(j.getId() == id) {
					juego = j;
				}
			}
			
			// Si juego es null, quiere decir que no 
			// encontramos un juego en la lista con el
			// ID que esperabamos.
			if (juego == null) {
				throw new Exception("Juego no encontrado");
			}
			// el juego fue encontrado: 
        	HashMap<String, Object> model = new HashMap<>();
        	model.put("juego", juego);
        	
        	return modelAndView(model, "juego/visualizar.ftl");
		}, new FreeMarkerEngine());
		
		get("/agregar-juego", (req, res) -> {
        	HashMap<String, Object> model = new HashMap<>();
        	
        	return modelAndView(model, "juego/agregar.ftl");
        }, new FreeMarkerEngine());
        
        post("/agregar-juego", (req, res) -> {
        	// Primero leemos todas las variables de
        	// nuestro formulario.
        	String nombre = req.queryParams("nombre");
        	String desarrollador = req.queryParams("desarrollador");
        	String categoria = req.queryParams("categoria");
        	String descripcion = req.queryParams("descripcion");
        	String imagen = req.queryParams("imagen");
        	
        	// Creamos un juego, dandole el ID
        	// actual del contador. 
        	Juego juego = new Juego(idCounter, nombre, desarrollador, categoria, imagen, descripcion);
        	
        	// Aumentamos el contador de IDs
        	idCounter++;
        	
        	// Hacemos un log del juego.
        	// Recordamos que la funcion toString esta
        	// sobre-escrita en el modelo de Juego.
        	log.info(juego.toString());
        	// Agregamos el juego a la lista.
        	juegos.add(juego);
        	// Luego de agregado, redireccionamos a /
        	res.redirect("/");
        	return null;
        });
        
        // Permite agregar consolas a un juego
        // en especifico mediante el ID.
        post("/agregar-consolas/:id", (req, res) -> {
        	// Leer arriba (en /ver-juego/:id).
        	int id = Integer.parseInt(req.params(":id"));
			Juego juego = null;
			
			for(Juego j : juegos) {
				if(j.getId() == id) {
					juego = j;
				}
			}

			if (juego == null) {
				throw new Exception("Juego no encontrado");
			}
			
			// El juego existe:
			String nswitch = req.queryParamOrDefault("switch", null);
			String pc = req.queryParamOrDefault("pc", null);
			String xbox = req.queryParamOrDefault("xbox", null);
			String ps4 = req.queryParamOrDefault("ps4", null);
			String n3ds = req.queryParamOrDefault("n3ds", null);
			// Creamos una nueva lista de consolas. 
			// Esta la usaremos para agregar las consolas a
			// el juego en cuestion.
			ArrayList<Consolas> consolas = new ArrayList<>();
			
			if(nswitch != null) {
				consolas.add(Consolas.NIN_SWITCH);
			}
			if(pc != null) {
				consolas.add(Consolas.PC);
			}
			if(xbox != null) {
				consolas.add(Consolas.XBOXONE);
			}
			if(ps4 != null) {
				consolas.add(Consolas.PS4);
			}
			if(n3ds != null) {
				consolas.add(Consolas.NIN_3DS);
			}
			
			juego.setConsolas(consolas);
			
			res.redirect("/ver-juego/" + juego.getId());
			return null;
        });
	}

}
