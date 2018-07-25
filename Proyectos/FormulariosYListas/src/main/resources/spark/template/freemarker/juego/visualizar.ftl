<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>
	<div>
		<img src="${juego.urlImagen}" style="max-width: 200px; max-height: 200px" />
		<h4>${juego.nombre}</h4>
		<p>${juego.descripcion}</p>
		<span>Categoria: ${juego.categoria}</span>
		<span>Desarrollador: ${juego.desarrollador}</span>
		<p>${juego.listaDeConsolas()}</p>
	</div>
	
	<a href="/"> Ver todos los juegos </a>
	<#include "consolas.ftl">
</body>

</html>