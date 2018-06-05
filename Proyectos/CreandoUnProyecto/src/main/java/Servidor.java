import static spark.Spark.*;

public class Servidor {
    public static void main(String[] args) {
    	/**
    	 * Necesario para archivos estaticos:
    	 */
    	staticFileLocation("/static");
    	/**
    	 * Creando un formulario que hace POST a la ruta
    	 *  /post:
    	 */
        get("/hello", (req, res) -> {
        	/**
        	 * Definiendo MimeType:
        	 */
        	res.header("content-type", "text/html");
        	
        	/**
        	 * Retornando HTML:
        	 */
        	return "<form action='/post' method='POST'>"
				+ "<button type='submit'> ENVIAR </button>"
				+ "</form>";
        });
        /**
         * Una ruta con el metodo POST que retorna Hello World
         */
        post("/post", (req, res) -> {
        	return "Hello World";
        });
        /**
         * Una ruta que toma un nombre como parametro
         * y lo retorna al usuario
         */
        get("/hola/:nombre", (req, res) -> {
        	return req.params(":nombre") ;
        });
        
        /**
         * Codigos de respuestas:
         */
        get("/codigo", (req, res) -> {
        	res.status(404);
        	return "Hello World";
        });
        /**
         * Redireccionando a un
         * archivo estatico:
         */
        get("/prueba", (req, res) -> {
        	res.redirect("/prueba.html");
        	return null;
        });
        /**
         * Retornando CSS si no se encuentra la pagina:
         */
        get("*", (req, res) -> {
        	res.status(404);
        	res.header("content-type", "text/css");
        	return "h1 { color: pink; }";
        });
   }
}