<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>
<div class="content-one">
<#if QuizCar??>
	<h1>${QuizCar}</h1>
</#if>
<#list articulo as articulo>
	<div class="articulos">
	<img src="images/usb.png">
		<h3>${articulo.precio}</h3>
		<span>${articulo.namearticulo}</span>
		<p>
			${articulo.cantidadarti}
		</p>
		<span>${articulo.descripcion}</span>
	</div>
</#list>
</body>
</html>