<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,mx.uatx.curriculums.dto.CursosDTO,mx.uatx.curriculums.dao.CursosDAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Cursos</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="">Sistema de Administración de CV´s </a>
				</h1>
				<p>
					<a href="http://templated.co" rel="nofollow">UAMCC</a>
				</p>
			</div>
		</div>
		<!-- end #header -->
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="Bienvenido.jsp">Principal</a></li>
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
				<li><a href=Cursos.jsp>Cursos</a></li>





			</ul>
		</div>
		<!-- end #menu -->
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
					<div id="content">
						<div class="post">
							<h2 class="title">
								<a href="#">CURSOS</a>
							</h2>
							<p class="meta">
								<span class="date"> </span><span class="posted"> <a
									href="#"></a></span>
							</p>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
							
							
							<form name="comisi" action="Cursos" method="get" class="basic-grey" >
								<input type="hidden" name="opc" value="1" />
									
									
									<h1>
								Registro De Comisiones <span>Porfavor llene
									todos los Campos</span>
									
							</h1>
							
								<%
										List<CursosDTO> listLicenciaturaDTO = new ArrayList<CursosDTO>();
																	CursosDTO cursosDTO = new CursosDTO();
																	CursosDAO comisionesDAO = new CursosDAO();
																	listLicenciaturaDTO = comisionesDAO.retrieveCursos(cursosDTO);
																	request.getSession().getAttribute("listaLic");
																	session.setAttribute("listaLic", listLicenciaturaDTO);
																	for (int reg = 0; reg < listLicenciaturaDTO.size(); reg++) {
																		cursosDTO = listLicenciaturaDTO.get(reg);
																		
																	}
									%>
									<label> <span>Nombre:</span>
											<tr class="color">
												<input id="name" type="text" name="Nombre" placeholder="Nombre" value=<%out.println(request.getSession().getAttribute("updateCursosDTO") != null ? ((CursosDTO) request
												.getSession().getAttribute("updateCursosDTO")).getNombre()
												: "");%> >
											<tr></label>
									<label> <span>Fecha inicio:</span>
									</label>
									<tr class="color">


										<input type="text" name="FechaI" placeholder="FechaI" value=<%out.println(request.getSession().getAttribute("updateCursosDTO") != null ? ((CursosDTO) request
												.getSession().getAttribute("updateCursosDTO")).getFechaI()
												: "");%> >
										
																	
									</tr>
									
									<label> <span>Fecha fin:</span>
											<tr class="color">
												<input id="name" type="text" name="FechaF" placeholder="Fecha fin" value=<%out.println(request.getSession().getAttribute("updateCursosDTO") != null ? ((CursosDTO) request
												.getSession().getAttribute("updateCursosDTO")).getFechaF()
												: "");%> >
											<tr></label>
 
                                             
											
										<label> <span>Institucione:</span>
											<tr class="color">
												<input type="text" name="Institucion" placeholder=" Instituciones" onkeypress="return  soloLetras(event)"  value=<%out.println(request.getSession().getAttribute("updateCursosDTO") != null ? ((CursosDTO) request
												.getSession().getAttribute("updateCursosDTO")).getInstitucion()
												: "");%> >

                                              <label> <span> Fecha :</span>
											<tr class="color">
												<input id="name" type="text" name="Fecha" placeholder="Fecha" value=<%out.println(request.getSession().getAttribute("updateCursosDTO") != null ? ((CursosDTO) request
												.getSession().getAttribute("updateCursosDTO")).getConstancia()
												: "");%> >
											<tr></label>
											

										<label> <span>Lugar :</span>
											<tr class="color">
												<input id="name" type="text" name="Lugar" placeholder="Lugar"  onkeypress="return  soloLetras(event)" value=<%out.println(request.getSession().getAttribute("updateCursosDTO") != null ? ((CursosDTO) request
												.getSession().getAttribute("updateCursosDTO")).getLugar()
												: "");%> >
											<tr></label>
											
											<label> <span>Horas :</span>
											<tr class="color">
												<input id="name" type="text" name="Horas" placeholder="Horas" onkeypress="return  soloLetras(event)" value=<%out.println(request.getSession().getAttribute("updateCursosDTO") != null ? ((CursosDTO) request
												.getSession().getAttribute("updateCursosDTO")).getHoras()
												: "");%> >
											<tr></label>
											
											
											<label> <span>Constancia :</span>
											<tr class="color">
												<input id="name" type="text" name="Constancia" placeholder="Constancia" value=<%out.println(request.getSession().getAttribute("updateCursosDTO") != null ? ((CursosDTO) request
												.getSession().getAttribute("updateCursosDTO")).getConstancia()
												: "");%> >
											<tr></label>
									

								<!-- <tr>
										<label> <span>Cargar Constancia:</span></label>
									<tr class="color">
										<input type=file name=image
											onchange="updateFilename(this.value)">
										<script>
											function updateFilename(path) {
												var name = extractFilename(path);
												document
														.getElementById('filename').textContent = name;
											} 
										</script> -->
									</tr>
									</tr>
									<input type="submit" value="Guardar" class="btn">
		<!-- <input type="button" value="Cancelar" class="btn" onclick=" location.href='RegistroCurricular.jsp'"> -->
								</form>
							
								<br></br>
								<br></br>

							</div>	
						</div>

						<div style="clear: both;">&nbsp;</div>
						
						
					</div>
					<!-- end #content -->
					<div class="CSSTableGenerator">
									
						
					<%
						//out.println("datos");
							//List<RegistroUsuarioDTO> listUsuarioDTO = new ArrayList<RegistroUsuarioDTO>();
						List<CursosDTO> listEmpleadoDTO = new ArrayList<CursosDTO>();
						CursosDTO empleadoRDTO = new CursosDTO();
						CursosDAO empleadoRDAO = new CursosDAO();
						listEmpleadoDTO = empleadoRDAO.retrieveCursos(empleadoRDTO);
							if (request.getSession().getAttribute("listaCurso") != null) {
						listEmpleadoDTO = (List<CursosDTO>) request
								.getSession().getAttribute("listaCurso");
							} else {
							}
							out.println("<center>");
							out.println("<div class=data >");
						///	out.println("<table >");
							out.println("<table  id='Pmoral' ><thead><tr> <td>IdCurso</td> <td>Nombre</td> <td>Fecha Inicio</td>  <td>Fecha Fin</td> <td>Institucion</td> <td>Lugar</td> <td>Horas</td> <td>Constancia</td><td>IdEstatus</td> <td>IdAsignar</td> <td>IdUsuarioCambio</td> <td>Fecha</td> <td>Estatus</td>    <td>Actualizar</td><td>Eliminar</td></thead><tbody>");
							 
							
							for (int reg = 0; reg < listEmpleadoDTO.size(); reg++) {
						empleadoRDTO = listEmpleadoDTO.get(reg);

						out.println("<tr>");

						//out.println("<td>");
						//out.println("<center>"+usuarioDTO.getId()+"</center>");
						//out.println("</td>");
					//	empleadoRDTO.getIdComision();

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getIdCurso() + "</center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getNombre() + "</center>");
						out.println("</th>");
						
			
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFechaI() + "</center>");
						out.println("</th>");
						
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFechaF() + "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getInstitucion()
								+ "</center>");
						out.println("</th>");

						
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getLugar()+ "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getHoras()
								+ "</center>");
						out.println("</th>");

						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getConstancia()
								+ "</center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getIdEstatus()
								+ "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getIdAsignar()
								+ "</center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFecha()+ "</center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getEstatus()+ "</center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getIdUsuarioCambio() + "</center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center><a href=Cursos?opc=2&id="
								+ empleadoRDTO.getIdCurso()
								+ "  class=btn btn-skin pull-right role=button id=ac  onClick=muestra('Pfisica').innerHTML>Actualizar<a/> </center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center><a href=Cursos?opc=3&id="
								+  empleadoRDTO.getIdCurso()
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