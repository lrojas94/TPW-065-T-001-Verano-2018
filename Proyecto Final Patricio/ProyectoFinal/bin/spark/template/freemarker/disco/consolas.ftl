<hr/>
<form action="/agregar-disco/${disco.id}" method="POST">
	<div>
	    <input type="checkbox" id="switch" name="switch" value="switch">
	    <label for="switch">Salsa</label>
  	</div>
  	<div>
	    <input type="checkbox" id="xbox" name="xbox" value="xbox">
	    <label for="xbox">Bachata</label>
  	</div>
  	<div>
	    <input type="checkbox" id="ps4" name="ps4" value="ps4">
	    <label for="ps4">Dance</label>
  	</div>
  	<div>
	    <input type="checkbox" id="3ds" name="3ds" value="3ds">
	    <label for="3ds"> Urbano </label>
  	</div>
  	<div>
	    <input type="checkbox" id="pc" name="pc" value="pc">
	    <label for="pc"> Merengue </label>
  	</div>
  	<input type="submit" value="Guardar" />
</form>