<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,mx.uatx.curriculum.dto.RegistroPublicacionesDTO,mx.uatx.curriculum.dao.RegistroPublicacionesDAO"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Publicaciones</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>



<script type="text/javascript">
        function soloLetras(e) {
            tecla = (document.all) ? e.keyCode : e.which;
            if (tecla == 8)
                return true;
            patron = /[A-Za-zñÑ\s]/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        }
        function soloNum(e) {
            tecla = (document.all) ? e.keyCode : e.which;
            if (tecla == 8)
                return true;
            patron = /\d/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        }
        function numYletras(e) {
            tecla = (document.all) ? e.keyCode : e.which;
            if (tecla == 8)
                return true;
            patron = /\w/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        }
    
    </script>


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
			<ul>	<li class="current_page_item"><a href="Bienvenido.jsp">Pricinpal</a></li>
				<li><a href="DatosPersonales.jsp">Datos Personales</a></li>
				<li><a href="ExperienciaFormacion.jsp">Experiencia y
						Formación</a></li>
				<li><a href="ExperienciaLaboral.jsp">Experiencia Laboral</a></li>
				<li><a href="Comisiones.jsp">Comisiones</a></li>
				<li><a href="Publicaciones.jsp">Publicaciones</a></li>
				<li><a href="MiembroOrganizacion.jsp">Miembro de
						Organización</a></li>
			    <li><a href=AsesoriaTesis.jsp>Asesoría de Tesis</a></li>
				<li><a href=Sinodal.jsp>Sinodal</a></li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">PUBLICACIONES</a>
							</h2>
							<p class="meta">
								<span class="date"> </span><span class="posted"> <a
									href="#"></a></span>
							</p>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
							<form name="comisi" action="RegistroPublicaciones" method="get" class="basic-grey" >
								<input type="hidden" name="opc" value="1" />
									
									<h1>
								Registro De Publicaciones <span>Porfavor llene
									todos los Campos</span>
							</h1>
							
									<%
										List<RegistroPublicacionesDTO> listLicenciaturaDTO = new ArrayList<RegistroPublicacionesDTO>();
									RegistroPublicacionesDTO publicacionesDTO = new RegistroPublicacionesDTO();
											RegistroPublicacionesDAO publicacionesDAO = new RegistroPublicacionesDAO();
																	listLicenciaturaDTO = publicacionesDAO.retrievePublicaciones(publicacionesDTO);
																	request.getSession().getAttribute("listaLic");
																	session.setAttribute("listaLic", listLicenciaturaDTO);
																	for (int reg = 0; reg < listLicenciaturaDTO.size(); reg++) {
																		publicacionesDTO = listLicenciaturaDTO.get(reg);
																		
																	}
									%>
									

								
										<label> <span>Fecha inicio:</span>
									</label>
									<tr class="color">


										<input type="text" name="FechaI" placeholder="Fecha inicio" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroPublicacionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getFechaI()
												: "");%> >
										
										<label> <span>Fecha fin:</span>
									</label>
													<input type="text" name="FechaF" placeholder="Fecha fin" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroPublicacionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getFechaF()
												: "");%> >			
												
										<label> <span>Nombre:</span>
									</label>
												
												
												<input type="text" name="Nombre" placeholder="Nombre" onkeypress="return  soloLetras(event)" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroPublicacionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getNombre()
												: "");%> >
										
										<label> <span>Institución:</span>
									</label>
													<input type="text" name="Institucion" placeholder="Institución" onkeypress="return  soloLetras(event)" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroPublicacionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getInstitucion()
												: "");%> >		
																							
										
										<label> <span>Constancia:</span>
									</label>
													<input type="text" name="Constancia" placeholder="Constancia" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroPublicacionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getConstancia()
												: "");%> >		
									</tr>

	<br></br>
										 <input type="submit" value="Guardar" class="btn">
		<input type="button" value="Cancelar" class="btn" onclick=" location.href='RegistroCurricular.jsp'">
								</form>
								
											<br></br>

								<div class="CSSTableGenerator">
									
						
					<%
						//out.println("datos");
							//List<RegistroUsuarioDTO> listUsuarioDTO = new ArrayList<RegistroUsuarioDTO>();
						List<RegistroPublicacionesDTO> listEmpleadoDTO = new ArrayList<RegistroPublicacionesDTO>();
						RegistroPublicacionesDTO empleadoRDTO = new RegistroPublicacionesDTO();
						RegistroPublicacionesDAO empleadoRDAO = new RegistroPublicacionesDAO();
						listEmpleadoDTO = empleadoRDAO.retrievePublicaciones(empleadoRDTO);
							if (request.getSession().getAttribute("listaUsuario") != null) {
						listEmpleadoDTO = (List<RegistroPublicacionesDTO>) request
								.getSession().getAttribute("listaEmpleado");
							} else {
							}
							out.println("<center>");
							out.println("<div class=data >");
						///	out.println("<table >");
							out.println("<table  id='Pmoral' ><thead><tr><td>Fecha Inicio</td>  <td>Fecha fin</td> <td>Nombre</td> <td>Instituci&oacuten</td>  <td>Actualizar</td><td>Eliminar</td></thead><tbody>");
							

							

							
							
							for (int reg = 0; reg < listEmpleadoDTO.size(); reg++) {
						empleadoRDTO = listEmpleadoDTO.get(reg);

						out.println("<tr>");

						//out.println("<td>");
						//out.println("<center>"+usuarioDTO.getId()+"</center>");
						//out.println("</td>");
					//	empleadoRDTO.getIdComision();

						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFechaI() + "</center>");
						out.println("</th>");
						
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFechaF() + "</center>");
						out.println("</th>");
						
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getNombre() + "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getInstitucion()
								+ "</center>");
						out.println("</th>");

						
						
						/* out.println("<th>");
						out.println("<center>" + empleadoRDTO.getConstancia()+ "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFechaActual()
								+ "</center>");
						out.println("</th>");

						

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getIdUsuarioCambio()+ "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getEstatus()
								+ "</center>");
						out.println("</th>");

						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getAsignarDocente_IdAsignar()
								+ "</center>");
						out.println("</th>"); */

					
						out.println("<th>");
						out.println("<center><a href=RegistroPublicaciones?opc=2&id="
								+ empleadoRDTO.getIdPublicacion()
								+ "  class=btn btn-skin pull-right role=button id=ac  onClick=muestra('Pfisica').innerHTML>Actualizar<a/> </center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center><a href=RegistroPublicaciones?opc=3&id="
								+  empleadoRDTO.getIdPublicacion()
								+ " class=btn btn-skin pull-right role=button  >Eliminar<a/>");
						out.println("</th></center>");

						out.println("</tr>");
						

							}
							out.println("</tbody></table> </div>");
							out.println("</center>");
					%>


									
								</div>
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
