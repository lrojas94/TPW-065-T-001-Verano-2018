import static spark.Spark.*;

/**
 * Problemas conocidos
 * 1 - La aplicacion no corre. (Hay 2 razones para esto)
 * 2 - De correr, parece que los HTML no funcionan bien.
	Pruebe la url, /p2.html, la cual no deberia retornar 404
 * 3 - Al enviar el formulario de GET /form, la aplicacion se detiene.
 */

public class Servidor {
	public static void main(String[] args) {
		get("/", (req, res) -> {
			res.redirect("/form");
		});
		
		get("/p2", (req, res) -> {
			res.redirect("/p2.html");
			return null;
		});
		
		get("/form", (req, res) -> {
			// Al darle click al boton de enviar, la aplicacion lanza unos errores.
			return "<form action='/form' method='POST'>"
					+ "<input type='submit' value='enviar' />"
					+ "</form>";
		});
		
		post("/form", (req, res) -> {
			if (req.session(true).attribute("formulario").equals(null)) {
				// Establecemos la variable formulario con un valor:
				req.session(true).attribute("formulario", "Muy bien, resolvieron el punto 3");
				res.redirect("/form");
			}
			
			// Se ha de retornar `Muy bien, resolvieron el punto 3`
			// La 2da vez que se cliquea el boton de GET /form
			return req.session(true).attribute("formulario");
		});
    }
}
