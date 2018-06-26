import static spark.Spark.*;

import Modelos.Usuario;

public class Servidor {
	
	/**
	 * Nuestra "Base de Datos" de Usuarios
	 * La utilizaremos para iniciar sesion
	 */
	static Usuario[] usuarios = {
	    new Usuario("Luis", "Rojas", "lrojas", "rojas"),
	    new Usuario("Jeimy", "Garcia", "jgarcia", "garcia"),
	    new Usuario("Patricio", "Valenzuela", "pvalenzuela", "valen"),
	    new Usuario("Brayan", "Peralta", "bperalta", "peralta"),
	};
	
	public static void main(String[] args) {
		staticFiles.location("/");
		
		/**
		 * Metodo Before (all) que nos permite
		 * iniciar sesion a un usuario si este tiene un
		 * cookie guardado con su nombre de usuario.
		 */
		before((req, res) -> {
			/**
			 * Revisamos 2 cosas:
			 * 1 - El usuario NO esta iniciado en la sesion
			 * 2 - La cookie existe.
			 */
			if(req.session(true).attribute("usuarioEnSesion") == null
				&& req.cookie("usuarioLoggeado") != null) {
				/**
				 * Dado que ambas condiciones se dan,
				 * podemos tomar el nombre de usuario de la cookie "usuarioLoggeado"
				 */
				String nombreDeUsuario = req.cookie("usuarioLoggeado");
				/**
				 * For Each.
				 * Se lee: Para cada `usuario` de la lista de `usuarios`
				 * se realiza el bloque de codigo a continuacion
				 */
				for(Usuario user : usuarios) {
					/**
					 * Si hay un usuario en la lista que tenga
					 * el mismo nombre de usuario de la variable
					 * `nombreDeUsuario`, entonces lo guardamos en la sesion
					 */
					if(user.getUsuario().equals(nombreDeUsuario)) {
						req.session(true).attribute("usuarioEnSesion", user);
					}
				}
			}
		});
		
		/**
		 * Protegemos todas las rutas que empiezen con /privado/
		 */
		before("/privado/*", (req, res) -> {
			if(req.session(true).attribute("usuarioEnSesion") == null) {
				halt(401, "Usted no esta loggeado");
			}
		});
		
		get("/", (req, res) -> {
			if(req.session(true).attribute("usuarioEnSesion") == null) {
				res.redirect("/formulario.html");
				return null;
			}
			
			Usuario usuarioEnSesion = req.session(true).attribute("usuarioEnSesion");
			
			return "Bienvenido " + usuarioEnSesion.getNombre() + " " + usuarioEnSesion.getApellido();
		});
		
		/**
		 * Metodo que permite iniciar sesion basado
		 * en un usuario y contrasena.
		 */
		post("/login", (req, res) -> {
			String nombreUsuario = req.queryParams("usuario");
			String contrasena = req.queryParams("pass");
			boolean rememberMe = req.queryParamOrDefault("rem", "off").equals("on");
			
			for(Usuario user : usuarios) {
				if(user.getUsuario().equals(nombreUsuario)
					&& user.getContrasena().equals(contrasena)) {
					req.session(true).attribute("usuarioEnSesion", user);
					if(rememberMe) {
						res.cookie("usuarioLoggeado", user.getUsuario());
					}
				}
			}

			res.redirect("/");
			return null;
		});
		
		get("/privado/este", (req, res) -> {
			return "Solo por usuarios loggeados ESTE";
		});
		
		get("/privado/tambien", (req, res) -> {
			return "Solo por usuarios loggeados TAMBIEN";
		});
	}

}
