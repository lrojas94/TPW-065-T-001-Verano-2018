<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>
<div class="content-one">
<#if CarritoDeCompras??>
	<h1>${CarritoDeCompras}</h1>
</#if>
<#list Articulos as articulo>
	<div class="articulos">
	<img src="">
		<h3>${articulo.precio}</h3>
		<span>${articulo.NombredelArticulo}</span>
		<p>
			${articulo.Cantidad}
		</p>
		<span>${articulo.Descripcion}</span>
	</div>
</#list>
</body>
</html>