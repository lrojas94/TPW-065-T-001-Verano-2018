<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/styles.css">
	<link rel="stylesheet" type="text/css" href="/nested/styles2.css">
</head>
<body>
<h1>Carrito de Compras</h1>
<#list carrito as articulo>
<div class="articulo">
	<h3>${articulo.nombre}</h3>
	<p>${articulo.desc}</p>
	<div>
		<span> Precio: $${articulo.precio} </span>
		<span> Cantidad: ${articulo.cantidad} </span>
		<span> Total Articulo: $${articulo.precio * articulo.cantidad} </span>
	</div>
</div>
</#list>

<h4> Total: $${total} </h4>

</body>
</html>