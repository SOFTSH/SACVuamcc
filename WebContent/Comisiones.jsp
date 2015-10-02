

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,mx.uatx.curriculum.dto.RegistroComisionesDTO,mx.uatx.curriculum.dao.RegistroComisionesDAO"%>
	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Comisiones</title>
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
			<ul>
					<li class="current_page_item"><a href="Bienvenido.jsp">Pricinpal</a></li>
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
								<a href="#">COMISIONES</a>
							</h2>
							<p class="meta">
								<span class="date"> </span><span class="get"> <a
									href="#"></a></span>
							</p>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
							
							
		<form name="comisi" action="RegistroComisiones" method="get" class="basic-grey" >
								<input type="hidden" name="opc" value="1" />
									
									
									<h1>
								Registro De Comisiones <span>Porfavor llene
									todos los Campos</span>
							</h1>
							
									<%
										List<RegistroComisionesDTO> listLicenciaturaDTO = new ArrayList<RegistroComisionesDTO>();
																	RegistroComisionesDTO comisionesDTO = new RegistroComisionesDTO();
																	RegistroComisionesDAO comisionesDAO = new RegistroComisionesDAO();
																	listLicenciaturaDTO = comisionesDAO.retrieveComisiones(comisionesDTO);
																	request.getSession().getAttribute("listaLic");
																	session.setAttribute("listaLic", listLicenciaturaDTO);
																	for (int reg = 0; reg < listLicenciaturaDTO.size(); reg++) {
																		comisionesDTO = listLicenciaturaDTO.get(reg);
																		
																	}
									%>
									
									<label> <span>Fecha inicio:</span>
									</label>
									<tr class="color">


										<input type="text" name="fechainicio" placeholder="Fecha inicio" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroComisionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getFechaInicio()
												: "");%> >
										
																	
									</tr>
									
									<label> <span>Fecha fin:</span>
											<tr class="color">
												<input id="name" type="text" name="fechafin" placeholder="Fecha fin" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroComisionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getFechaFin()
												: "");%> >
											<tr></label>


										<label> <span>Evento :</span>
											<tr class="color">
												<input type="text" name="NombreEvento" placeholder=" Evento" onkeypress="return  soloLetras(event)"  value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroComisionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getNombreEvento()
												: "");%> >

										<label> <span>Instituci&oacuten :</span>

											<tr class="color">
												<input id="email" type="text" name="Institucion" placeholder="Institución" onkeypress="return  soloLetras(event)"  value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroComisionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getInstitucion()
												: "");%> >
											<tr></label>

										<label> <span>Lugar :</span>
											<tr class="color">
												<input id="name" type="text" name="lugar" placeholder="Lugar"  onkeypress="return  soloLetras(event)" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroComisionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getLugar()
												: "");%> >
											<tr></label>
											
											<label> <span>Participaci&oacuten :</span>
											<tr class="color">
												<input id="name" type="text" name="participaciones" placeholder="Participación" onkeypress="return  soloLetras(event)" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroComisionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getParticipaciones()
												: "");%> >
											<tr></label>
											
											
											<label> <span>Constancia :</span>
											<tr class="color">
												<input id="name" type="text" name="constancia" placeholder="Constancia" value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroComisionesDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getConstancia()
												: "");%> >
											<tr></label>
											
											
										
											
											
																			
								 <input type="submit" value="Guardar" class="btn">
		<input type="button" value="Cancelar" class="btn" onclick=" location.href='RegistroCurricular.jsp'">
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
						List<RegistroComisionesDTO> listEmpleadoDTO = new ArrayList<RegistroComisionesDTO>();
						RegistroComisionesDTO empleadoRDTO = new RegistroComisionesDTO();
						RegistroComisionesDAO empleadoRDAO = new RegistroComisionesDAO();
						listEmpleadoDTO = empleadoRDAO.retrieveComisiones(empleadoRDTO);
							if (request.getSession().getAttribute("listaUsuario") != null) {
						listEmpleadoDTO = (List<RegistroComisionesDTO>) request
								.getSession().getAttribute("listaEmpleado");
							} else {
							}
							out.println("<center>");
							out.println("<div class=data >");
						///	out.println("<table >");
							out.println("<table  id='Pmoral' ><thead><tr>  <td>Fecha Inicio</td>  <td>Fecha fin</td> <td>Nombre Evento</td> <td>Instituci&oacuten</td> <td>Lugar</td> <td>Participaci&oacuten</td>    <td>Actualizar</td><td>Eliminar</td></thead><tbody>");
						
							
							for (int reg = 0; reg < listEmpleadoDTO.size(); reg++) {
						empleadoRDTO = listEmpleadoDTO.get(reg);

						out.println("<tr>");

						//out.println("<td>");
						//out.println("<center>"+usuarioDTO.getId()+"</center>");
						//out.println("</td>");
					//	empleadoRDTO.getIdComision();

						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFechaInicio() + "</center>");
						out.println("</th>");
						
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getFechaFin() + "</center>");
						out.println("</th>");
						
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getNombreEvento() + "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getInstitucion()
								+ "</center>");
						out.println("</th>");

						
						
						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getLugar()+ "</center>");
						out.println("</th>");

						out.println("<th>");
						out.println("<center>" + empleadoRDTO.getParticipaciones()
								+ "</center>");
						out.println("</th>");

						

						
						out.println("<th>");
						out.println("<center><a href=RegistroComisiones?opc=2&id="
								+ empleadoRDTO.getIdComision()
								+ "  class=btn btn-skin pull-right role=button id=ac  onClick=muestra('Pfisica').innerHTML>Actualizar<a/> </center>");
						out.println("</th>");
						
						out.println("<th>");
						out.println("<center><a href=RegistroComisiones?opc=3&id="
								+  empleadoRDTO.getIdComision()
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
