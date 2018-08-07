<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Title of the document</title>
<style>
      p {
        color:red;
        text-align:center;
        background-color: #cda;
      }
    </style>

</head>

<body>
	<form action="/agregar-disco" method="POST">
		<div>
			<label for="nombre"> Nombre del Artista: </label>
			<input type="text" name="nombre" id="nombre" />
		</div>
		<div>
			<label for="imagen"> URL de la Imagen: </label>
			<input type="text" name="imagen" id="imagen" />
		</div>
		<div>
			<label for="descripcion"> Descripcion del Disco: </label>
			<textarea name="descripcion" id="descripcion">
			</textarea>
		</div>
		<div>
		<p style="color:red"; > <input type="submit" value="Agregar" /> </p>
		</div>
	</form>
</body>

</html>