import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.LoggerFactory;

import freemarker.log.Logger;
import modelos.Disco;
import modelos.Canciones;
import modelos.Consolas;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import spark.Session;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;

public class Servidor {

	static ArrayList<Disco> discos = new ArrayList<>();
	static ArrayList<String> tema = new ArrayList<>();
	static Gson gson = new Gson();
	
	// Contador con el que asignaremos un ID Unico a cada artista.
	
	static int idCounter = 0;

	public static void main(String[] args) {
		org.slf4j.Logger log = LoggerFactory.getLogger(Servidor.class);

		
		System.out.println("Valenzuela Records");
		
		staticFiles.location("/estaticos");
		
		
	      
		
		
		before((req, res) -> {
			
			
			if(discos.size() == 0) {
				
				
			   discos.add(new Disco(
					-3,
					"Daddy Yankee",
					"https://vignette.wikia.nocookie.net/imagenes7216/images/3/3c/Daddy_Yankee_El_Rey_Del_Reggaetón.png/revision/latest?cb=20170527215118&path-prefix=es",
					"El Big Boss:"
					+ "     " + "1)Mayor que yo"
				    + "      " +"2)Gasolina"
				    + "      " +"3)Despacito"
				    + "      " +"4)Dura"
					));
				discos.add(new Disco(
					-2,
					"Luis Miguel",
					"https://upload.wikimedia.org/wikipedia/commons/d/d9/Luis-Miguel-Pose.jpg",
					"El sol de mexico:"
							+ "     " + "1)La vikinga"
						    + "      " +"2)Si nos dejan"
						    + "      " +"3)Perdidos"
						    + "      " +"4)Reloj"
				));
				discos.add(new Disco(
					-1,
					"Jose Jose",
					"https://vignette.wikia.nocookie.net/inciclopedia/images/2/2f/Josesss.jpg/revision/latest?cb=20100504233649",
					"El Grande:"
							+ "     " + "1)Adios"
						    + "      " +"2)El perdedor"
						    + "      " +"3)Amor"
						    + "      " +"4)Desdicha"
				));
				
			}
		});
		
		// LEER TODOS LOS ARTISTAS

				get("/api/artistas", (req, res) -> {

					return discos;

				},gson::toJson);
				
				
				
				
				// AGREGAR UNA Artista

				post("/api/artistas", (req, res) -> {

					Disco cancionEnJSON = gson.fromJson(req.body(), Disco.class);

					discos.add(cancionEnJSON);

					return cancionEnJSON;

				}, gson::toJson);
				
				
				
				
				// EDITAR UNA Canciones

				put("/api/artistas/:id", (req, res) -> {

					try {

						int id = Integer.parseInt(req.params(":id"));

						Disco cancionVieja = discos.get(id);

						Disco cancionNueva = gson.fromJson(req.body(), Disco.class);

						cancionVieja.setNombre(cancionNueva.getNombre());

						cancionVieja.setDescripcion(cancionNueva.getDescripcion());

						return cancionVieja;

					} catch (Exception e) {

						log.error(e.getMessage());

						e.printStackTrace();

						return "No se actualizar El album";

					}

				}, gson::toJson);
				
				
				
				// BORRAR UNA PELICULA

				delete("/api/peliculas/:id", (req, res) -> {

					try {

						int id = Integer.parseInt(req.params(":id"));

						discos.remove(id);

						return "Borrado con exito";

					} catch (Exception e) {

						log.error(e.getMessage());

						e.printStackTrace();

						return "No se pudo eliminar";

					}

				});
				
		
		//revisar porque no funciona.
		
		/*/before((req, res) -> {

			if(tema.size() == 0) {

				tema.add(new Canciones(

					"Gasolina", // nombre, 

					5 // Puntaje

				));

				tema.add(new Canciones(

					"La vikinga", // nombre, 

					4 // Puntaje

				));


			}

		});*/
	         
		
		//redireccionando el registro a la ruta inicio
		
		
		post("/inicios", (req, res) -> {
	         res.redirect("/inicio");
	         return null;
	         
	       });
	         
		
		
		get("/counter-g", (req, res) -> {
			log.info("Logeandome");
			System.out.println("Despues de Logearme");
			return "?" ;
		});
		
		
        get("/counter", (req, res) -> {
        	Session s = req.session(true);
        	if(s.attribute("counter") == null) {
        		s.attribute("counter", 1);
				return "Creado";
        	}
        	
        	
        	int counter = s.attribute("counter");
    		s.attribute("counter", counter + 1);
        	return counter + 1;
        });
		 
        
       

		// Ruta para listar todos los
		// juegos que se encuentren en la lista.
		get("/inicio", (req, res) -> {
        	HashMap<String, Object> model = new HashMap<>();
        	// Ponemos la lista de artistas en el modelo.
        	model.put("discos", discos);
        	return new ModelAndView(model, "disco/listar.ftl");
		}, new FreeMarkerEngine());

		// Ruta que permite visualizar 1 solo disco.
		// Mediante el ID, podemos acceder un artista en
		// especifico
		get("ver-artista/:id", (req, res) -> {
			
			int id = Integer.parseInt(req.params(":id"));
			// Asumimos que el disco no existe.
			Disco disco = null;

			for(Disco j : discos) {
				// Si encontramos un disco en la lista
				// con el Id que deseamos, entonces el artista
				// existe y lo guadamos en la variable artista.
				if(j.getId() == id) {
					disco = j;
				}
			}

			// Si artista es null, quiere decir que no
			// encontramos un artista en la lista con el
			// ID que esperabamos.
			if (disco == null) {
				throw new Exception("Disco no encontrado");
			}
			// el disco fue encontrado:
        	HashMap<String, Object> model = new HashMap<>();
        	model.put("disco", disco);

        	return new ModelAndView(model, "disco/visualizar.ftl");
		}, new FreeMarkerEngine());

		get("/agregar-disco", (req, res) -> {
        	HashMap<String, Object> model = new HashMap<>();

        	return new ModelAndView(model, "disco/agregar.ftl");
        }, new FreeMarkerEngine());

        post("/agregar-disco", (req, res) -> {
        	// Primero leemos todas las variables de
        	// nuestro formulario.
        	String nombre = req.queryParams("nombre");
        	String descripcion = req.queryParams("descripcion");
        	String imagen = req.queryParams("imagen");
        	

        	// Creamos un disco, dandole el ID
        	// actual del contador.
        	Disco disco = new Disco(idCounter, nombre, imagen, descripcion);

        	// Aumentamos el contador de IDs
        	idCounter++;

        	// Hacemos un log del disco.
        	// Recordamos que la funcion toString esta
        	// sobre-escrita en el modelo de disco.
        	log.info(discos.toString());
        	// Agregamos el artista a la lista.
        	discos.add(disco);
        	// Luego de agregado, redireccionamos a /
        	res.redirect("/inicio");
        	return null;
        });

        // Permite agregar discos a un artistas
        // en especifico mediante el ID.
        post("/agregar-disco/:id", (req, res) -> {
        	// Leer arriba (en /ver-juego/:id).
        	int id = Integer.parseInt(req.params(":id"));
			Disco disco = null;

			for(Disco j : discos) {
				if(j.getId() == id) {
					disco = j;
				}
			}

			if (disco == null) {
				throw new Exception("Disco no encontrado");
			}

			
			String Salsa = req.queryParamOrDefault("Salsa", null);
			String Bachata = req.queryParamOrDefault("Bachata", null);
			String Dance = req.queryParamOrDefault("Dance", null);
			String Urbano = req.queryParamOrDefault("Urbano", null);
			String Merengue = req.queryParamOrDefault("Merengue", null);
			
			ArrayList<Consolas> consolas = new ArrayList<>();

			if(Salsa != null) {
				consolas.add(Consolas.Salsa);
			}
			if(Bachata != null) {
				consolas.add(Consolas.Bachata);
			}
			if(Dance != null) {
				consolas.add(Consolas.Dance);
			}
			if(Urbano != null) {
				consolas.add(Consolas.Urbano);
			}
			if(Merengue != null) {
				consolas.add(Consolas.Merengue);
			}

			disco.setConsolas(consolas);

			res.redirect("/ver-artista/" + disco.getId());
			return null;
        });
	}

}
