<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"  href="styles.css" />
    <link href="https://fonts.googleapis.com/css?family=Quicksand:400,500" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
<title>Carrito</title>
</head>
<style>
body{
	font-family: 'Quicksand', sans-serif;
	background:#e7e6fc;
}</style>
<body>
<h1 class="title"> Carrito <i class="fas fa-shopping-cart"></i></h1>
<#if titulo??>
	<h2>${titulo}</h2>
</#if>
<#list carrito as carrito>
	<div class="contenedor">
		<span>${carrito.nombre}, ${carrito.cantidad}, ${carrito.descripcion}, ${carrito.precio}</span>
	</div>
</#list>
</body>
</html>

