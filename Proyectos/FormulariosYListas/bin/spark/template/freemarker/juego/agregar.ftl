<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>
	<form action="/agregar-juego" method="POST">
		<div>
			<label for="nombre"> Nombre del juego: </label>
			<input type="text" name="nombre" id="nombre" />
		</div>
		<div>
			<label for="desarrollador"> Desarrollador: </label>
			<input type="text" name="desarrollador" id="desarrollador" />
		</div>
		<div>
			<label for="categoria"> Categoria: </label>
			<input type="text" name="categoria" id="categoria" />
		</div>
		<div>
			<label for="imagen"> URL de la Imagen: </label>
			<input type="text" name="imagen" id="imagen" />
		</div>
		<div>
			<label for="descripcion"> Descripcion del juego: </label>
			<textarea name="descripcion" id="descripcion">
			</textarea>
		</div>
		<div>
			<input type="submit" value="Agregar" />
		</div>
	</form>
</body>

</html>