<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css" type="text/css"></link>
<script type="text/javascript" src="js/navegacion.js"></script>
</head>
<body>
<li class="current_page_item"><a href="Bienvenido.jsp">Principal</a></li>
 	<li id="seccion1" onmouseover="ver(1)" onmouseout="ocultar(1)">
				<a href="DatosPersonales.jsp">Datos Personales</a>
			
			</li>

			<li id="seccion2" onmouseover="ver(2)" onmouseout="ocultar(2)">
				<a href="#">Experiencia</a>
				<div id="subseccion2">
					<p>
						<a href="Asociar_Tema.jsp"> Experiencia y formación</a>
					</p>
                     <p>
						<a href="Experiencias.jsp"> Experiencia laboral</a>
					</p>
				</div>
			</li>
			<li id="seccion1" >
				<a href="">Comisiones</a>
				
			</li>
			<li id="seccion1">
				<a href="#">Publicaciones</a>
				
			</li>
	<li id="seccion1" >
				<a href="MiembroOrganizacion.jsp">Miembro de organización</a>
				
			</li>
			<li id="seccion2" onmouseover="ver(3)" onmouseout="ocultar(3)">
				<a href="#">Tésis</a>
				<div id="subseccion3">
					<p>
						<a href="Asociar_Tema.jsp">Asesoría de tésis</a>
					</p>
                     <p>
						<a href="Asociar_Tema.jsp">Sinodal</a>
					</p>
				</div>
			</li>
			 <li><a href=Cursos.jsp>Cursos</a></li>
			 <li><a href=Logout.jsp>Salir</a></li>
</body>
</html>