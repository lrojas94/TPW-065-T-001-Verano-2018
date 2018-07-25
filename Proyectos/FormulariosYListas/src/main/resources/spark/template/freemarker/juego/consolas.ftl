<hr/>
<form action="/agregar-consolas/${juego.id}" method="POST">
	<div>
	    <input type="checkbox" id="switch" name="switch" value="switch">
	    <label for="switch">Nintendo Switch</label>
  	</div>
  	<div>
	    <input type="checkbox" id="xbox" name="xbox" value="xbox">
	    <label for="xbox">XBOX ONE</label>
  	</div>
  	<div>
	    <input type="checkbox" id="ps4" name="ps4" value="ps4">
	    <label for="ps4">PlayStation 4</label>
  	</div>
  	<div>
	    <input type="checkbox" id="3ds" name="3ds" value="3ds">
	    <label for="3ds">Nintendo 3DS</label>
  	</div>
  	<div>
	    <input type="checkbox" id="pc" name="pc" value="pc">
	    <label for="pc">PC Gaming</label>
  	</div>
  	<input type="submit" value="Guardar" />
</form>