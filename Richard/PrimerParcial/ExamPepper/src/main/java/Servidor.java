import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Servidor {
	
    public static void main(String[] args) {
    	
    	staticFileLocation("/");
    	
    	Logger logger = LoggerFactory.getLogger(Servidor.class);
    	
    	get("/index", (req, res) -> {
    		logger.info("/index :: entramos por home");;
    		res.redirect("/index.html");
    	
    		return null;
    	});
    	
    	get("/contact", (req, res) -> {
    		logger.info("/contact :: entramos por contacto");;
    		res.redirect("/contact.html");
    		
    		return null;
    	});
    	
    	get("/about", (req, res) -> {
    		logger.info("/about :: entramos por about");;
    		res.redirect("/about.html");
    		
    		return null;
    	});
    	
    	get("/codresp", (req, res) -> {
    		logger.info("/codresp :: entramos al NOT FOUND");;
    		res.redirect("/codresp.html");
    		
    		return null;
    	});
    	
    	
    	get("/index", (req, res) -> {
    		res.redirect("/index.html");
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
    	
    	get("/codresp", (req, res) -> {
        	res.status(404);
        	return "NOT FOUND";
        });
    }
}