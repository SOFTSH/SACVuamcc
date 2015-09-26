	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,mx.uatx.curriculum.dto.RegistroEmpleadoDTO,mx.uatx.curriculum.dao.RegistroEmpleadoDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Vertebrata by TEMPLATED</title>

<link href="style.css" rel="stylesheet" type="text/css" media="screen" />

  <script language="JavaScript">
  
   function oculta(id){
        var elDiv = document.getElementById(id); //se define la variable "elDiv" igual a nuestro div
        elDiv.style.display='none'; //damos un atributo display:none que oculta el div     
       }
  
   function muestra(id){
        var elDiv = document.getElementById(id); //se define la variable "elDiv" igual a nuestro div
        elDiv.style.display='block';//damos un atributo display:block que  el div     
       }
  
  
   window.onload = function(){/*hace que se cargue la función */
   /* "Mandamos como parametro el nombre de la Div para ocultar" */
   oculta('Pmoral'); /*Ocultamos Pmoral*/
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
		
			<li ><a href="#">Principal</a></li>
		<li ><a href=RegistroCS1.jsp>Nuevo</a></li>
			
			<li><a href="#">Salir</a></li>
		</ul>
	
	</div>
	</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
		
<input type="submit" class="button" value="Nuevo" id="b"   onClick="muestra('Pmoral'); oculta('Pfisica');oculta('b');"/>
<input type="submit" class="button" value="Cancelar" id="b"   onClick="oculta('Pmoral');"/>
<div id="Pmoral">

						<form action="RegistroEmpleado" method="get" class="basic-grey" >
							<input type="hidden" name="opc" value="1" />
							<h1>
								Registro De Coordinador y Secretaria <span>Porfavor llene
									todos los Campos</span>
							</h1>
							<label> <span>Licenciatura :</span>
							</label>
							<td><select id="lic" name="lic" size="1">
									<option value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroEmpleadoDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getIdLicenciatura()
												: "");%>>Seleción la Licenciatura</option>
									<%
										List<RegistroEmpleadoDTO> listLicenciaturaDTO = new ArrayList<RegistroEmpleadoDTO>();
																	RegistroEmpleadoDTO empleadoDTO = new RegistroEmpleadoDTO();
																	RegistroEmpleadoDAO empleadoDAO = new RegistroEmpleadoDAO();
																	listLicenciaturaDTO = empleadoDAO.retrieveLicenciatura(empleadoDTO);
																	request.getSession().getAttribute("listaLic");
																	session.setAttribute("listaLic", listLicenciaturaDTO);
																	for (int reg = 0; reg < listLicenciaturaDTO.size(); reg++) {
																		empleadoDTO = listLicenciaturaDTO.get(reg);
																		out.println("<option value=" + empleadoDTO.getIdLic() + ">"
																				+ empleadoDTO.getDescripcionLic() + "</option>");
																	}
									%>
							</select>
							</td>
							</h1>
							<label> <span>Cargo :</span>
							</label>
							<td><select name="rol" size="1">
									<option value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroEmpleadoDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getIdRol()
												: "");%>>Selecióne Cargo</option>
									<%
										List<RegistroEmpleadoDTO> listRolDTO = new ArrayList<RegistroEmpleadoDTO>();
																	RegistroEmpleadoDTO empleadoRolDTO = new RegistroEmpleadoDTO();
																	RegistroEmpleadoDAO empleadoRolDAO = new RegistroEmpleadoDAO();
																	listRolDTO = empleadoRolDAO.retrieveRol(empleadoRolDTO);
																	request.getSession().getAttribute("listaRol");
																	session.setAttribute("listaRol", listRolDTO);
																	for (int reg = 0; reg < listRolDTO.size(); reg++) {
																		empleadoDTO = listRolDTO.get(reg);
																		out.println("<option value=" + empleadoDTO.getIdRol1() + ">"
																				+ empleadoDTO.getDescripcionRol() + "</option>");
																	}
									%>
							</select></td> <label> </label> <label> <span>Nombre :</span>
								<tr class="color">
									<input id="name" type="text" name="nombre" placeholder="Nombre"
										value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroEmpleadoDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getNombre()
												: "");%> />
								<tr></label> <label> <span>A. Paterno :</span>

								<tr class="color">
									<input id="email" type="text" name="ap"
										placeholder="Apellido Paterno" 
										value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroEmpleadoDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getAp()
												: "");%>/>
								<tr></label> <label> <span>A. Materno:</span>
								<tr class="color">
									<input id="name" type="text" name="am"
										placeholder="Apellido Materno" 
										value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroEmpleadoDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getAm()
												: "");%>/>
								<tr></label> <label> <span>Contrasena:</span>
								<tr class="color">
									<input id="name" type="text" name="contrasena"
										placeholder="Apellido Materno" 
										value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroEmpleadoDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getContrasena()
												: "");%>/>
								<tr></label> <label> <span>N. Empleado:</span>
								<tr class="color">
									<input id="name" type="text" name="noe"
										placeholder="Numero de Empleado" 
										value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroEmpleadoDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getNumeroE()
												: "");%>/>
								<tr></label> <label> <span>E-mail :</span>
								<tr class="color">
									<input id="email" type="email" name="correo"
										placeholder="Direccion Email" 
										value=<%out.println(request.getSession().getAttribute("updateEmpleadoDTO") != null ? ((RegistroEmpleadoDTO) request
												.getSession().getAttribute("updateEmpleadoDTO")).getCorreo()
												: "");%>/>
								<tr></label> <span>&nbsp;</span> <input type="submit"
								class="button" value="Guardar" onClick="muestra('Pfisica'); oculta('Pmoral')"Cel.: 7834123409
		
 /> </label>
						</form>
						</div>


<div>

</div>

<br></br>	
	</div>
			<br></br>	
				<br></br>	
					<div class="CSSTableGenerator">
					
					
					<%
						//out.println("datos");
							//List<RegistroUsuarioDTO> listUsuarioDTO = new ArrayList<RegistroUsuarioDTO>();
						List<RegistroEmpleadoDTO> listEmpleadoDTO = new ArrayList<RegistroEmpleadoDTO>();
						RegistroEmpleadoDTO empleadoRDTO = new RegistroEmpleadoDTO();
						RegistroEmpleadoDAO empleadoRDAO = new RegistroEmpleadoDAO();
						listEmpleadoDTO = empleadoRDAO.retrieveEmpleado(empleadoRDTO);
							if (request.getSession().getAttribute("listaUsuario") != null) {
						listEmpleadoDTO = (List<RegistroEmpleadoDTO>) request
								.getSession().getAttribute("listaEmpleado");
							} else {
							}
							out.println("<center>");
							out.println("<div class=data >");
						///	out.println("<table >");
							out.println("<table  id='Pmoral' ><thead><tr><th>Nombre</th><th>Apellido Paterno</th><th>Apellido Materno</th><th>Licenciatura</th><th>Actualiza</th><th>Elimina</th></thead><tbody>");
							for (int reg = 0; reg < listEmpleadoDTO.size(); reg++) {
						empleadoRDTO = listEmpleadoDTO.get(reg);

						out.println("<tr>");

						//out.println("<td>");
						//out.println("<center>"+usuarioDTO.getId()+"</center>");
						//out.println("</td>");
						empleadoRDTO.getIdEmpleado();

						out.println("<td>");
						out.println("<center>" + empleadoRDTO.getNombre() + "</center>");
						out.println("</td>");

						out.println("<td>");
						out.println("<center>" + empleadoRDTO.getAp()
								+ "</center>");
						out.println("</td>");

						out.println("<td>");
						out.println("<center>" + empleadoRDTO.getAm()
								+ "</center>");
						out.println("</td>");

						out.println("<td>");
						out.println("<center>" + empleadoRDTO.getDesclic1() + "</center>");
						out.println("</td>");

						
						out.println("<td>");
						out.println("<center><a href=RegistroEmpleado?opc=2&id="
								+ empleadoRDTO.getIdEmpleado()
								+ "  class=btn btn-skin pull-right role=button id=ac  onClick=muestra('Pfisica')>Actualizar<a/> </center>");
						out.println("</td>");
						out.println("<td>");
						out.println("<center><a href=RegistroEmpleado?opc=3&id="
								+  empleadoRDTO.getIdEmpleado()
								+ " class=btn btn-skin pull-right role=button  >Eliminar<a/>");
						out.println("</td></center>");

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
