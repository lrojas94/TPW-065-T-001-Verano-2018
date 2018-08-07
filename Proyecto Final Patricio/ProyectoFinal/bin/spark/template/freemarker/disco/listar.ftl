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

<body>

       
      
    
	<#list discos as disco>
		<div> 
			<h4>
				<a href="/ver-artista/${disco.id}">
					${disco.nombre}
				</a>
			</h4>
		</div>
	</#list>
	<a href="/agregar-disco"> <p style="color:red"; > Agregar nuevo Artista </p> </a>
	
</body>

</html>