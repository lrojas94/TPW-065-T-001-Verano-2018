<!DOCTYPE html>
<html>
<body>
<h1>Agregar Articulo</h1>
<form method="POST" action="/agregar">
	<div>
		<label for="nombre">Nombre</label>
		<input type="text" name="nombre" id="nombre"/>
	</div>
	<div>
		<label for="desc">Descripcion</label>
		<input type="text" name="desc" id="desc"/>
	</div>
	<div>
		<label for="precio">Precio</label>
		<input type="number" step="0.01" name="precio" id="precio"/>
	</div>
	<div>
		<label for="cantidad">Cantidad</label>
		<input type="number" step="1" name="cantidad" id="cantidad"/>
	</div>
	
	<input type="submit" value="Enviar" />
</form>
</body>
</html>