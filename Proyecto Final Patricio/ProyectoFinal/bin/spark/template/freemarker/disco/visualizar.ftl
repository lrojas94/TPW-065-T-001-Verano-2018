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

<p>Valenzuela Records</p>

<body>

   

	<div>
		<img src="${disco.urlImagen}" style="max-width: 200px; max-height: 200px" />
		<h4>${disco.nombre}</h4>
		<p>${disco.descripcion}</p>
		<p>${disco.listaDeConsolas()}</p>
	</div>
	
	<a href="/inicio"> Ver todos los Artistas </a>
	<#include "consolas.ftl">
</body>

</html>