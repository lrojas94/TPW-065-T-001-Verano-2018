import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import static spark.Spark.staticFiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import UsuraioDatos.Usuario;

public class Servidor {

	
	static Usuario[] usuarios = {
	    //Loggin
	    new Usuario("Richard", "Gomez", "rgomez", "gomez"),
	    new Usuario("Albert", "Santiago", "asantiago", "albert"),
	};
	
	public static void main(String[] args) {
		
		
         staticFileLocation("/");
    	
    	Logger logger = LoggerFactory.getLogger(Servidor.class);
    	
    	get("/index", (req, res) -> {
    		logger.info("/index :: entramos por home");;
    		res.redirect("/index.html");
    	
    		return null;
    	});
    	
    	get("/about", (req, res) -> {
    		logger.info("/about :: entramos por about");;
    		res.redirect("/about.html");
    		
    		return null;
    	});
    	
    	get("/music", (req, res) -> {
    		logger.info("/music :: entramos por music");;
    		res.redirect("/music.html");
    		
    		return null;
    	});
    	
    	get("/codresp", (req, res) -> {
    		logger.info("/codresp :: entramos al NOT FOUND");;
    		res.redirect("/codresp.html");
    		
    		return null;
    	});
    		
    		get("/notfound", (req, res) -> {
        		logger.info("/notfound :: Se ha registrado un 404");;
        		res.redirect("/notfound.html");
        		
        		return null;
   
    	});
    	
    	get("/index", (req, res) -> {
    		res.redirect("/index.html");
    		return null;
    	});
    	
    	get("/about", (req, res) -> {
    		logger.warn("/about :: Peligro!");
    		res.redirect("/about.html");
    		return null;
    	});
    	
    	get("/music", (req, res) -> {
    		res.redirect("/music.html");
    		return null;
    		
    	});
    	
    	get("/abouto", (req, res) -> {
        	res.status(302);
        	return "302: Lo que se solicita que la ha pagina ha sido movida";
        });
    	
    	get("/*", (req, res) -> {
        	logger.info("NOT FOUND");
        	res.status(404);
        	return "404: NOT FOUND";
        });
		
		before((req, res) -> {
			//Revisamos si la Cookie existe
              if(req.session(true).attribute("usuarioEnSesion") == null
				&& req.cookie("usuarioLoggeado") != null) {
		
				String nombreDeUsuario = req.cookie("usuarioLoggeado");
				
				for(Usuario user : usuarios) {
					//Guardamos en la session si existe el nombre de usuario
					if(user.getUsuario().equals(nombreDeUsuario)) {
						req.session(true).attribute("usuarioEnSesion", user);
					}
				}
			}
		});
		
		//Protegemos la ruta, para quienes no esten registrado
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
		
		//Nos permite tener nombre de usuario y contrasena
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
			return "So lo por usuarios loggeados ESTE";
		});
		
		get("/privado/tambien", (req, res) -> {
			return "Solo por usuarios loggeados TAMBIEN";
		});
		
        
	
	}



	}

