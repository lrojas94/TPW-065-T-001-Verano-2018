import static spark.Spark.*;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Modelos.Usuario;
import spark.Session;
/**
	En esta practica hacemos uso del objeto sesion
	para guardar una lista de usuarios que tienen nombre\
	apellido. Los usuarios se crean mediante una URL, digase:
	/crear-usuario/:nombre/:apellido
	
	Y la lista se lee mediante la URL:
	/usuarios
 */

public class Servidor {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Servidor.class);
		/**
			Haremos uso del Metodo GET /usuarios
			para leer la lista de usuarios y mostrarla 
			en pantalla mediante un tag <ul>.
		 */
		get("/usuarios", (req, res) -> {
			// Inicialmos con una lista <ul> vacia.
			String listaHtml = "<ul>";
			// Leemos la session.
			Session s = req.session(true);
			// Revisamos si la lista existe.
			if(s.attribute("usuarios") != null) {
				// Ya que sabemos que existe, la leemos:
				ArrayList<Usuario> listaUsuarios = s.attribute("usuarios");
				// Para cada usuario de la lista,
				// Creamos un elemento <li>
				for(Usuario u : listaUsuarios) {
					listaHtml += "<li>"
							+ u.getNombre()
							+ " "
							+ u.getApellido()
							+ "</li>";
				}
			}
			// Nos aseguramos de cerrar el elemento <ul>
			// que creamos en la linea 21.
			listaHtml += "</ul>";
			// Retornamos esta lista HTML.
			return listaHtml;
		});
		
		/**
			La url /crear-usuario/:nombre/:apellido
			nos permitira agregar un usuario a nuestra lista
			de sesion. Recordamos que :nombre y :apellido
			son parametros.
		 */
		get("/crear-usuario/:nombre/:apellido", (req, res) -> {
			// Leemos los parametros :nombre y :apellido
			String nombre = req.params(":nombre");
			String apellido = req.params(":apellido");

			// Dados estos parametros, creamos nuestro usuario.
			Usuario usuario = new Usuario(nombre, apellido);
			// Ahora intentaremos leer la lista de
			// la sesion
			ArrayList<Usuario> listaUsuarios;
			Session s = req.session(true);
			
			// Revisamos si la lista existe.
			if(s.attribute("usuarios") != null) {
				// Si existe, entonces la guardamos
				// en la variable listaUsuarios
				listaUsuarios = s.attribute("usuarios");
			} else {
				// De lo contrario, creamos una lista nueva en
				// listaUsuarios.
				listaUsuarios = new ArrayList<>();
			}
			
			// Agregamos el usuario que creamos a la lista.
			listaUsuarios.add(usuario);
			// Finalmente, guardamos la lista en la sesion.
			s.attribute("usuarios", listaUsuarios);
			
			return usuario.getNombre() + " " + usuario.getApellido();
		});
	}
}
