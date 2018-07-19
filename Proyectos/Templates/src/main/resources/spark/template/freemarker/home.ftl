<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>
<#if titulo??>
	<h1>${titulo}</h1>
</#if>
<#list peliculas as pelicula>
	<div class="pelicula">
		<h3>${pelicula.nombre}</h3>
		<span>${pelicula.categoria}</span>
		<p>
			${pelicula.descripcion}
		</p>
		<span>${pelicula.autor}</span>
	</div>
</#list>
</body>
</html>