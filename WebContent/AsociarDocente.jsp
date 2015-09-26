<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.Calendar"
	import="java.util.GregorianCalendar"
	import="java.util.*,com.uatx.sacv.dto.EmpleadosDTO,com.uatx.sacv.dao.DocentesDAO,javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Vertebrate  
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20100423

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>AsociarDocentes</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
					<h1><a href="">Sistema de Administración de CV´s </a></h1>
			<p><a href="http://templated.co" rel="nofollow">UAMCC</a></p>
			</div>
		</div>
		<!-- end #header -->
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#">Home</a></li>
				<li><a href="DatosPersonales.jsp">Datos Personales</a></li>
				<li><a href="ExperienciaFormacion.jsp">Experiencia y
						Formaci&oacute;n</a></li>
				<li><a href="ExperienciaLaboral.jsp">Experiencia Laboral</a></li>
				<li><a href="Comisiones.jsp">Comisiones</a></li>
				<li><a href="Publicaciones.jsp">Publicaciones</a></li>
				<li><a href="MiembroOrganizacion.jsp">Miembro de
						Organizaci&oacute;n</a></li>
			    <li><a href="#">Asesor&iacutea de Tesis</a></li>
				<li><a href="#">Sinodal</a></li>

			</ul>
		</div>
		<!-- end #menu -->
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">DOCENTES</a>
							</h2>
							<p class="meta">
								<span class="date"> <%
 	Calendar fecha = new GregorianCalendar();
 	//Obtenemos el valor del año, mes, día,
 	//hora, minuto y segundo del sistema
 	//usando el método get y el parámetro correspondiente
 	int ano = fecha.get(Calendar.YEAR);
 	int mes = fecha.get(Calendar.MONTH);
 	int dia = fecha.get(Calendar.DAY_OF_MONTH);
 	int hora = fecha.get(Calendar.HOUR_OF_DAY);
 	int minuto = fecha.get(Calendar.MINUTE);
 	int segundo = fecha.get(Calendar.SECOND);
 	out.println(dia + "/" + (mes + 1) + "/" + ano);
 %>
 </span><span class="posted"> <a href="#"> </a></span>
							</p>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
							
 	<%
 	List<EmpleadosDTO> listEmpleadosDTO = new ArrayList<EmpleadosDTO>();
	EmpleadosDTO empleadosDTO = new EmpleadosDTO();
	DocentesDAO docentesDAO = new DocentesDAO();
	listEmpleadosDTO = docentesDAO.retrieveEmpleados(empleadosDTO);

		request.getSession().getAttribute("listaEmpleados");
		session.setAttribute("listaEmpleados", listEmpleadosDTO);
							
		out.println("<div class= CSSTableGenerator>");
		out.println("<table>");
		out.println("<tr><td>Nombre</td><td>Apellido Paterno</td><td>Apellido Materno</td><td>Numero de Empleado</td><td>Asociar Licenciatura</td></tr>");
					for (int reg = 0; reg < listEmpleadosDTO.size(); reg++) {
		         		empleadosDTO = listEmpleadosDTO.get(reg);
		         		
			out.println("<tr>");
			out.println("<td>");
			out.println(empleadosDTO.getIdEmpleado());
			out.println("</td>");
			out.println("<td>");
			out.println(empleadosDTO.getNombre());
			out.println("</td>");
			out.println("<td>");
			out.println(empleadosDTO.getAp());
			out.println("</td>");
			out.println("<td>");
			out.println(empleadosDTO.getAm());
			out.println("</td>");
			out.println("<td>");
			out.println("<a href=AsociarDocente?opc=1&id="
					+ empleadosDTO.getIdEmpleado() +" role=button >Asociar</a>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table></div>");
		%>	
								<br></br>
						
							</div>
						</div>

						<div style="clear: both;">&nbsp;</div>
					</div>
					<!-- end #content -->
					<div id="sidebar">
						<ul>
							<li>
								<div id="search">
									<form method="get" action="#">
										<div>
											<input type="text" name="s" id="search-text" value="" /> <input
												type="submit" id="search-submit" value="GO" />
										</div>
									</form>
								</div>
								<div style="clear: both;">&nbsp;</div>
							</li>
							<li>
								<h2>Aliquam tempus</h2>
								<p>Mauris vitae nisl nec metus placerat perdiet est.
									Phasellus dapibus semper consectetuer hendrerit.</p>
							</li>
							<li>
								<h2>Categories</h2>
								<ul>
									<li><a href="#">Aliquam libero</a></li>
									<li><a href="#">Consectetuer adipiscing elit</a></li>
									<li><a href="#">Metus aliquam pellentesque</a></li>
									<li><a href="#">Suspendisse iaculis mauris</a></li>
									<li><a href="#">Urnanet non molestie semper</a></li>
									<li><a href="#">Proin gravida orci porttitor</a></li>
								</ul>
							</li>
							<li>
								<h2>Blogroll</h2>
								<ul>
									<li><a href="#">Aliquam libero</a></li>
									<li><a href="#">Consectetuer adipiscing elit</a></li>
									<li><a href="#">Metus aliquam pellentesque</a></li>
									<li><a href="#">Suspendisse iaculis mauris</a></li>
									<li><a href="#">Urnanet non molestie semper</a></li>
									<li><a href="#">Proin gravida orci porttitor</a></li>
								</ul>
							</li>
							<li>
								<h2>Archives</h2>
								<ul>
									<li><a href="#">Aliquam libero</a></li>
									<li><a href="#">Consectetuer adipiscing elit</a></li>
									<li><a href="#">Metus aliquam pellentesque</a></li>
									<li><a href="#">Suspendisse iaculis mauris</a></li>
									<li><a href="#">Urnanet non molestie semper</a></li>
									<li><a href="#">Proin gravida orci porttitor</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<!-- end #sidebar -->
					<div style="clear: both;">&nbsp;</div>
				</div>
			</div>
		</div>
		<!-- end #page -->
	</div>
	<div id="footer">
		<p>
			&copy; Untitled. All rights reserved. Design by <a
				href="http://templated.co" rel="nofollow">TEMPLATED</a>.
		</p>
	</div>
	<!-- end #footer -->
</body>
</html>
