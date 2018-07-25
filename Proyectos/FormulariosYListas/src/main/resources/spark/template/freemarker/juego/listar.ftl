<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>
	<#list juegos as juego>
		<div> 
			<h4>
				<a href="/ver-juego/${juego.id}">
					${juego.nombre}
				</a>
			</h4>
		</div>
	</#list>
	<a href="/agregar-juego"> Agregar nuevo juego </a>
</body>

</html>