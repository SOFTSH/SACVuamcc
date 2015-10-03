	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,mx.uatx.curriculums.dto.SinodalDTO,mx.uatx.curriculums.dao.SinodalDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Sinodales</title>

<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
		<!-- Libreria jQuery -->
	 <script type="text/javascript" src="js/validarCampos.js"></script>
        <script type="text/javascript">

  function validarCS(){
	if(document.registrocs.nombre.value==""){
		location.href='Vaciosrcs.jsp';  
		return false;
	} 
	if(document.registrocs.ap.value==""){
		location.href='Vaciosrcs.jsp';  
		return false;
	} 
	if(document.registrocs.am.value==""){
		location.href='Vaciosrcs.jsp';  
		return false;
	} 
	if(document.registrocs.noe.value==""){
		location.href='Vaciosrcs.jsp';  
		return false;
	} 
	if(document.registrocs.correo.value==""){
		location.href='Vaciosrcs.jsp';  
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
			<h1><a href="">Sistema de Aministración de CV´s </a></h1>
			<p><a href="http://templated.co" rel="nofollow">UAMCC</a></p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		
		<div id="menu">
		<ul>
		
			<li ><a href="Bienvenido.jsp">Principal</a></li>
		
			
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

						<form name="sinodal" action="Sinodal" method="get" class="basic-grey" >
							<input type="hidden" name="opc" value="1" />
							<h1>
								Sinodales <span>Porfavor llene
									todos los Campos</span>
							</h1>
							
									<%
										List<SinodalDTO> SinodalDTO = new ArrayList<SinodalDTO>();
									SinodalDTO empleadoDTO = new SinodalDTO();
									SinodalDAO empleadoDAO = new SinodalDAO();
									SinodalDTO = empleadoDAO.retrieveSinodal(empleadoDTO);
																	request.getSession().getAttribute("listaSinodal");
																	session.setAttribute("listaSinodal", SinodalDTO);
																	for (int reg = 0; reg < SinodalDTO.size(); reg++) {
																		empleadoDTO = SinodalDTO.get(reg);
																		
																	}
									%>
							
														
							
							<label> <span>Nombre Proyecto :</span>
								<tr class="color">
									<input onkeypress="return soloLetras(event)" id="NombreProyecto" type="text" name="NombreProyecto" placeholder="NombreProyecto"
										value=<%out.println(request.getSession().getAttribute("updateSinodalDTO") != null ? ((SinodalDTO) request
												.getSession().getAttribute("updateSinodalDTO")).getNombreProyecto()
												: "");%> >
										</tr></label>		
										
											
							 <label> <span>Nivel:</span>
								<tr class="color">
									<input onkeypress="return soloLetras(event)" id="Nivel" type="text" name="Nivel"
										placeholder="Nivel" 
										value=<%out.println(request.getSession().getAttribute("updateSinodalDTO") != null ? ((SinodalDTO) request
												.getSession().getAttribute("updateSinodalDTO")).getNivel()
												: "");%>>
								</tr></label>
						
								 <label> <span>Fecha Titulacion:</span>
								<tr class="color">
									<input  id="FechaTitulacion" type="date" name="FechaTitulacion"
										placeholder="FechaTitulacion" 
										value=<%out.println(request.getSession().getAttribute("updateSinodalDTO") != null ? ((SinodalDTO) request
												.getSession().getAttribute("updateSinodalDTO")).getFechaTitulacion()
												: "");%>>
								</tr></label>
								
								<tr></label> 
								
								 <label> <span>Alumnos:</span>
								<tr class="color">
									<input onkeypress="return soloLetras(event)" id="Alumnos" type="text" name="Alumnos"
										placeholder="Alumnos" 
										value=<%out.println(request.getSession().getAttribute("updateSinodalDTO") != null ? ((SinodalDTO) request
												.getSession().getAttribute("updateSinodalDTO")).getAlumnos()
												: "");%>>
								</tr></label>
								
								 <label> <span>Constancia:</span>
								<tr class="color">
									<input onkeypress="return soloLetras(event)" id="Constancia" type="text" name="Constancia"
										placeholder="Constancia" 
										value=<%out.println(request.getSession().getAttribute("updateSinodalDTO") != null ? ((SinodalDTO) request
												.getSession().getAttribute("updateSinodalDTO")).getConstancia()
												: "");%>>
								</tr></label>
								
								
								
									<label> <span>Opci&oacute;n de Titulaci&oacute;n
											:</span>
										<tr class="color"></label>
									</td>
									<td><select name="opctitu">
											<option Value="0">Seleccione una Opción</option>
											<option name=lib value="1">Tesis</option>
											<option name=lib value="2">Titulación por
												promedio</option>
											<option name=lib value="3">Memoria</option>
											<option name=lib value="4">Prototipo</option>
											<option name=lib value="5">Actualización
												Curricular</option>
											<option name=lib value="6">Examen General de
												Conociientos</option>
											<tr>
									</select> 
								
								<tr></label> <span>&nbsp;</span> <input type="submit"
								class="button" value="Guardar" /> 
						</form>
						</div>
<br><br>	
	</div>
			<br><br>	
				<br><br>
					
					<div class="CSSTableGenerator">
						
					<%
					
						List<SinodalDTO> listEmpleadoDTO = new ArrayList<SinodalDTO>();
						SinodalDTO empleadoRDTO = new SinodalDTO();
						SinodalDAO empleadoRDAO = new SinodalDAO();
						listEmpleadoDTO = empleadoRDAO.retrieveSinodal(empleadoRDTO);
							if (request.getSession().getAttribute("listaUsuario") != null) {
						listEmpleadoDTO = (List<SinodalDTO>) request
								.getSession().getAttribute("listaEmpleado");
							} else {
							}
							out.println("<center>");
							out.println("<div class=data >");
							out.println("<table  id='Pmoral' ><thead><tr><td>Nombre Proyecto</td><td>Opcion Titulacion</td><td>Nivel</td><td>Fecha Titulacion</td><td>Alumno (s)</td></td><td>Actualizar</td><td>Eliminar</td></thead><tbody>");
							for (int reg = 0; reg < listEmpleadoDTO.size(); reg++) {
						empleadoRDTO = listEmpleadoDTO.get(reg);

						out.println("<tr>");

						empleadoRDTO.getIdSinodal();

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getNombreProyecto() + "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getDescripcionTitu()
								+ "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getNivel()
								+ "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFechaTitulacion() + "</center>");
						out.println("</th>");

						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getAlumnos() + "</center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center><a href=Sinodal?opc=2&id="
								+ empleadoRDTO.getIdSinodal()
								+ "  class=btn btn-skin pull-right role=button id=ac  onClick=muestra('Pfisica').innerHTML>Actualizar<a/> </center>");
						out.println("</th>");
						out.println("<th>");
						out.println("<center><a href=Sinodal?opc=3&id="
								+  empleadoRDTO.getIdSinodal()
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