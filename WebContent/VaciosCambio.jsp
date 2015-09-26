<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
		smoke.confirm('Campos vacios, inserte datos por favor', function(e) {
			if (e) {
				location.href="CambioCont.jsp";
			} else {
				location.href="CambioCont.jsp";
			}
		}, {
			ok : "Intentar nuevamente",
			cancel : "Cancelar"
		} // Nombre de los botones
		); // Muestra mensaje de confirmación
		
	</script>
</body>
</html>