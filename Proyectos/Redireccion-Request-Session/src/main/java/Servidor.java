import static spark.Spark.*;

import spark.Session;

public class Servidor {
	public static void main(String[] args) {
		/**
		 * TAREA:
		 * Crear un contador *global* que cuente la cantidad
		 * de veces que se ha entrado en la ruta /counter-g
		 */
		get("/counter-g", (req, res) -> {
			// Contar y retornar todas las veces que
			// han entrado en el contador.
			
			return "?";
		});
		
		// Contador en sesion:
        get("/counter", (req, res) -> {
        	Session s = req.session(true);
        	// Revisamos si "counter" esta creado.
        	// De no estarlo, es necesario crearlo.
        	if(s.attribute("counter") == null) {
        		// Creamos counter con un valor de 1.
        		s.attribute("counter", 1);
        		// Retornamos: Created.
        		return "Created";
        	}
        	
        	// Leemos el valor de Counter de la sesion:
        	int counter = s.attribute("counter");
        	// Guardamos el valor de counter agregando 1.
    		s.attribute("counter", counter + 1);
    		
    		// Retornamos el valor de Counter agregando 1.
        	return counter + 1;
        });
	}

}
