import static spark.Spark.*;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import Modelos.Pelicula;

/**
 * Gradle GSON: 	compile group: 'com.google.code.gson', name: 'gson', version: '2.8.5'
 * JSON VIEWER: https://chrome.google.com/webstore/detail/json-viewer/gbmdgpbipfallnflgajpaliibnhdgobh/related
 * POSTMAN: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop/related?hl=es
 
 * Link de ayuda: https://www.mscharhag.com/java/building-rest-api-with-spark
 */

public class Servidor {
	public static void main(String[] args) {
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		Logger log = LoggerFactory.getLogger(Servidor.class);
		Gson gson = new Gson();

		before("*", (req, res) -> {
			if(peliculas.size() == 0) {
				peliculas.add(new Pelicula(
					"Tarzan", // nombre, 
					"Familiar", // categoria, 
					"Una pelicula muy divertida", // Descripcion 
					5 // Puntaje
				));
				peliculas.add(new Pelicula(
					"El Barco", // nombre, 
					"Drama", // categoria, 
					"Ehm... Curiosa", // Descripcion 
					4 // Puntaje
				));
				peliculas.add(new Pelicula(
					"Lucifer", // nombre, 
					"Drama/Religion", // categoria, 
					"What is it that you desire?", // Descripcion 
					5 // Puntaje
				));
			}
		});
		
		get("/api/peliculas", (req, res) -> {
			return peliculas;
		}, gson::toJson);
		
		get("/api/peliculas/:id", (req, res) -> {
			try {
				int id = Integer.parseInt(req.params(":id"));
				return peliculas.get(id);
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				return "No encontrado";
			}
		}, gson::toJson);
		
		// A TRABAJAR:
		post("/api/peliculas", (req, res) -> {
			// Debe crear una nueva pelicula y 
			// Agregarla a la lista.
			
			// Ayudese con el metodo: 
			// gson.fromJson
			return null;
		});
		// A TRABAJAR: 
		put("/api/peliculas/:id", (req, res) -> {
			try {
				// Debe tomar este ID, y editar
				// Un objeto de la lista
				int id = Integer.parseInt(req.params(":id"));
				// gson.fromJson
				return "Borrado con exito";
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				return "No se pudo eliminar";
			}
		});
		
		// COMPLETO
		delete("/api/peliculas/:id", (req, res) -> {
			try {
				int id = Integer.parseInt(req.params(":id"));
				peliculas.remove(id);
				return "Borrado con exito";
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				return "No se pudo eliminar";
			}
		});
	}

}
