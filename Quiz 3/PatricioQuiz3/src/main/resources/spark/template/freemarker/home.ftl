<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>
<body>
<#if CarritoCompras??>
	<h2>${CarritoCompras}</h2>
</#if>
<#list CarritoCompras as CarritoCompras>
	<div class="CarritoCompras">
		<h3>${CarritoCompras.nombre}</h3>
		<span>${CarritoCompras.precio}</span>
		<p>
			${CarritoCompras.descripcion}
		</p>
		<span>${CarritoCompras.cantidad}</span>
	</div>
</#list>
</body>
</html>