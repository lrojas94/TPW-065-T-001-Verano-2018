import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Servidor {
	
    public static void main(String[] args) {
    	// ES NECESARIO PARA ACCEDER ARCHIVOS ESTATICOS
    	// Estaticos == HTML/CSS/JS
    	staticFileLocation("/");
    	
    	Logger logger = LoggerFactory.getLogger(Servidor.class);

    	get("/index", (req, res) -> {
    		logger.info("/index :: entramos por index");;
    		res.redirect("/index.html");
    		// ES OBLIGATORIO RETORNAR ALGO
    		// DENTRO DE LAS FUNCIONES DE RUTA
    		// DE SPARK,
    		return null;
    	});
    	
    	get("/contact", (req, res) -> {
    		logger.warn("/contact :: Peligro!");
    		res.redirect("/contact.html");
    		return null;
    	});
    	
    	get("/about", (req, res) -> {
    		res.redirect("/about.html");
    		return null;
    	});
    }
}