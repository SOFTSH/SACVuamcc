<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atención!</title>
<link rel="stylesheet" href="css/smoke.css" type="text/css"></link>
<script type="text/javascript" src="js/smoke.js"></script>
<script type="text/javascript" src="js/smoke.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		smoke.confirm('El usuario o contrase&ntildea es incorrecto', function(e) {
			if (e) {
				location.href="index.jsp";
			} else {
				location.href="index.jsp";
			}
		}, {
			ok : "Intentar nuevamente",
			cancel : "Cancelar"
		} // Nombre de los botones
		); // Muestra mensaje de confirmación
		
	</script>
</body>
</html>