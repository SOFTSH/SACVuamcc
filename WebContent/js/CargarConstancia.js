/**
 * Archivo el cual permite subir un archivo al servlet para posteriormente 
 * almacenarlo en la DB.
 */
function CargarConstancia(dato){
	
	var file = dato.files[0]; // la variable donde se almacena la constancia
	var objHidden = document.formularioCursos.hid; //se hace referencia
	objHidden.value = file.hid;
	document.formularioCursos.target = "iframe"; //se direje el proceso al target iframe
	document.formularioCursos.action = "Cursos"; //vamos a mandar el documento al servlet
	document.formularioCursos.submit();
	alert("Proceso Terminado");
}