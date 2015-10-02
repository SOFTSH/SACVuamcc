<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,mx.uatx.curriculums.dto.AsesoriaTesisDTO,mx.uatx.curriculums.dao.AsesoriaTesisDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Asesoria Tesis</title>

<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<!-- Libreria jQuery -->

<script type="text/javascript" src="js/validarCampos.js"></script>
<script type="text/javascript">
	function validarD() {
		if (document.registrocs.nombre.value == "") {
			location.href = 'Vaciosrd.jsp';
			return false;
		}
		if (document.registrocs.ap.value == "") {
			location.href = 'Vaciosrd.jsp';
			return false;
		}
		if (document.registrocs.am.value == "") {
			location.href = 'Vaciosrd.jsp';
			return false;
		}
		if (document.registrocs.noe.value == "") {
			location.href = 'Vaciosrd.jsp';
			return false;
		}
		if (document.registrocs.correo.value == "") {
			location.href = 'Vaciosrd.jsp';
			return false;
		}

		document.registrocs.submit();
	}
</script>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="">Sistema de Aministración de CV´s </a>
				</h1>
				<p>
					<a href="http://templated.co" rel="nofollow">UAMCC</a>
				</p>
			</div>
		</div>
		<!-- end #header -->
		<div id="menu">

			<div id="menu">
				<ul>

					<li><a href="Bienvenido.jsp">Principal</a></li>


					<li><a href="#">Salir</a></li>
				</ul>

			</div>
		</div>
		<!-- end #menu -->
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="content">

						<div class="target">

							<form name="registrocs" action="AsesoriaTesis" method="get"
								class="basic-grey">
								<input type="hidden" name="opc" value="1" />
								<h1>
									Asesoria Tesis <span>Porfavor llene todos los Campos</span>
								</h1>

								<%
									List<AsesoriaTesisDTO> listLicenciaturaDTO = new ArrayList<AsesoriaTesisDTO>();
								AsesoriaTesisDTO empleadoDTO = new AsesoriaTesisDTO();
								AsesoriaTesisDAO empleadoDAO = new AsesoriaTesisDAO();
									listLicenciaturaDTO = empleadoDAO.retrieveAsesoria(empleadoDTO);
									request.getSession().getAttribute("listaLic");
									session.setAttribute("listaLic", listLicenciaturaDTO);
									for (int reg = 0; reg < listLicenciaturaDTO.size(); reg++) {
										empleadoDTO = listLicenciaturaDTO.get(reg);

									}
								%>


								 <label> <span>Proyecto :</span>
									<tr class="color">
										<input onkeypress="return soloLetras(event)" id="name"
											type="text" name="Proyecto" placeholder="Proyecto"
											value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null
					? ((AsesoriaTesisDTO) request.getSession().getAttribute("updateEmpleadoDTO")).getProyecto()
					: "");%>>
									</tr></label>
									
									
								 <label> <span>Nivel :</span>

									<tr class="color">

										<input onkeypress="return soloLetras(event)" id="nivel"
											type="text" name="Nivel" placeholder="Nivel"
											value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null
					? ((AsesoriaTesisDTO) request.getSession().getAttribute("updateEmpleadoDTO")).getNivel() : "");%>>
									</tr></label> 
									
							
							<label> <span>Fecha Titulacion:</span>
									<tr class="color">
										<input onkeypress="return soloNumeros(event)" id="name"
											type="text" name="FechaTitulacion"
											placeholder="Fecha Titulacion"
											value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null
					? ((AsesoriaTesisDTO) request.getSession().getAttribute("updateEmpleadoDTO"))
							.getFechaTitulacion()
					: "");%>>
									</tr></label> 
									
									
					<label> <span>Alumno:</span>
									<tr class="color">
										<input onkeypress="return soloLetras(event)"
											id="name" type="text" name="Alumno"
											placeholder="Nombre del Alumno"
											value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null
					? ((AsesoriaTesisDTO) request.getSession().getAttribute("updateEmpleadoDTO")).getAlumno() : "");%>>
									</tr></label> 
									
									
						 <label> <span>Constancia :</span>
									<tr class="color">
										<input onkeypress="return soloNumeros(event)" id="nivel"
											type="text" name="Constancia" placeholder="Constancia"
											value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null
							? ((AsesoriaTesisDTO) request.getSession().getAttribute("updateEmpleadoDTO")).getConstancia() : "");%>>
		
		
									
 
 						 <input type="submit" value="Guardar" class="btn">
 						 </form>
				</div>
	</div>
			<br></br>	
				<br></br>	
				<br></br>	
					<div class="CSSTableGenerator">
					
					
					<%
																//out.println("datos");
																//List<RegistroUsuarioDTO> listUsuarioDTO = new ArrayList<RegistroUsuarioDTO>();
																List<AsesoriaTesisDTO> listEmpleadoDTO = new ArrayList<AsesoriaTesisDTO>();
																AsesoriaTesisDTO empleadoRDTO = new AsesoriaTesisDTO();
																AsesoriaTesisDAO empleadoRDAO = new AsesoriaTesisDAO();
																listEmpleadoDTO = empleadoRDAO.retrieveAsesoria(empleadoDTO);
																if (request.getSession().getAttribute("listaUsuario") != null) {
																	listEmpleadoDTO = (List<AsesoriaTesisDTO>) request.getSession().getAttribute("listaEmpleado");
																} else {
																}
																out.println("<center>");
																out.println("<div class=data >");
																///	out.println("<table >");
																out.println(
																		"<table  id='Pmoral' ><thead><tr><td>Proyecto</td><td>Nivel</td><td>Fecha De Titulacion</td><td>Alumno (s)</td><td>Constancia</td><td>Actualizar</td><td>Eliminar</td></thead><tbody>");
																for (int reg = 0; reg < listEmpleadoDTO.size(); reg++) {
																	empleadoRDTO = listEmpleadoDTO.get(reg);

																	out.println("<tr>");

																	//out.println("<td>");
																	//out.println("<center>"+usuarioDTO.getId()+"</center>");
																	//out.println("</td>");

																	out.println("<th>");
																	out.println("<center>" + empleadoRDTO.getProyecto() + "</center>");
																	out.println("</th>");

																	out.println("<th>");
																	out.println("<center>" + empleadoRDTO.getNivel() + "</center>");
																	out.println("</th>");

																	out.println("<th>");
																	out.println("<center>" + empleadoRDTO.getFechaTitulacion() + "</center>");
																	out.println("</th>");

																	out.println("<th>");
																	out.println("<center>" + empleadoRDTO.getAlumno() + "</center>");
																	out.println("</th>");

																	out.println("<th>");
																	out.println("<center>" + empleadoRDTO.getConstancia() + "</center>");
																	out.println("</th>");

																	out.println("<th>");
																	out.println("<center><a href=AsesoriaTesis?opc=2&id=" + empleadoRDTO.getIdAsesoria()
																			+ "  class=btn btn-skin pull-right role=button id=ac  onClick=muestra('Pfisica').innerHTML>Actualizar<a/> </center>");
																	out.println("</th>");
																	out.println("<th>");
																	out.println("<center><a href=AsesoriaTesis?opc=3&id=" + empleadoRDTO.getIdAsesoria()
																			+ " class=btn btn-skin pull-right role=button  >Eliminar<a/>");
																	out.println("</th></center>");

																	out.println("</tr>");

																}
																out.println("</tbody></table> </div>");
																out.println("</center>");
															%>
</div>

			</div>

					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->
				<div id="sidebar"></div>
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