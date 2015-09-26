<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.uatx.sacv.dto.LicenciaturasDTO,com.uatx.sacv.dao.LicenciaturasDAO,javax.servlet.http.HttpSession"
    import="java.util.*,com.uatx.sacv.dto.AsociarDocentesDTO,com.uatx.sacv.dao.DocentesDAO"
    import="java.util.*,com.uatx.sacv.dto.EmpleadosDTO,com.uatx.sacv.dao.DocentesDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Asociar Licenciatura</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="">Sistema de Administraci&oacute;n de CV´s </a>
				</h1>
				<p>
					<a href="http://templated.co" rel="nofollow">UAMCC</a>
				</p>

			</div>
		</div>
		<!-- end #header -->
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#">Home</a></li>
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
						<li>
						
						
		<div id="Datos" >
        <form method="get" action="AsociarDocente">
        <input type="hidden" name="opc" value="2" />
                   <div class="CSSTableGenerator">
	<%		
	List<AsociarDocentesDTO> listAsociarDocentesDTO = new ArrayList<AsociarDocentesDTO>();
	AsociarDocentesDTO asociarDocentesDTO = new AsociarDocentesDTO();
	DocentesDAO docentesDAO = new DocentesDAO();
	
	request.getSession().getAttribute("listaAsociarDocente");
	session.setAttribute("listaAsociarDocente", listAsociarDocentesDTO);
	String id = request.getSession().getAttribute("IdDocente").toString();
	int idDocente = Integer.parseInt(id);
	
	
	
	asociarDocentesDTO = new AsociarDocentesDTO();
	asociarDocentesDTO.setIdEmpleado(idDocente);
	listAsociarDocentesDTO =docentesDAO.retrieveAsociarDocente(asociarDocentesDTO);
			out.println("<table><td>"+""+"<td>");
			for (int reg = 0; reg < listAsociarDocentesDTO.size(); reg++) {
				asociarDocentesDTO = listAsociarDocentesDTO.get(reg);
				out.println("<tr>");
				out.println("<td>");
				out.println(asociarDocentesDTO.getLicenciatura());
				out.println("</td>");
				out.println("<td>");
				out.println("<a href=#?opc=2&id="
						+ asociarDocentesDTO.getIdAsignar() + ">[Actualizar]</a>");
				out.println("</td>");
	
				out.println("</tr>");
			}
			out.println("</table>");
%>
                        <br>
                           
                    </div>
        </form>
    </div>
    <div style="clear: both;">&nbsp;</div>

            </li>
							<h2 class="title">
								<a href="#">ASOCIAR LICENCIATURA</a>
							</h2>
							<p class="meta">
								<span class="date"> </span><span class="posted"> <a
									href="#"></a></span>
							</p>
							<div style="clear: both;">&nbsp;</div>
							<div class="entry">
					<form action="AsociarDocente" method="get" class="basic-grey">
					 <input type="hidden" name="opc" value="2" />
									<% asociarDocentesDTO = new AsociarDocentesDTO();
									asociarDocentesDTO.setIdEmpleado(idDocente);
									out.println("<input type=hidden name=idDoc value="+asociarDocentesDTO.getIdEmpleado()+" />");
									System.out.println("Segundo formulario"+asociarDocentesDTO.getIdEmpleado());  %>
						<label >
						<span>Licenciatura :</span>
 						<tr class="color">
  						</label></td>
            			<td>Licenciatura: <select id="SLic"
							name="SelectLic" size="1">
								<option value="#">Selecciona una Licenciatura</option>
								<%
									List<LicenciaturasDTO> listLicenciaturasDTO = new ArrayList<LicenciaturasDTO>();
									LicenciaturasDTO licenciaturasDTO = new LicenciaturasDTO();
									LicenciaturasDAO licenciaturasDAO = new LicenciaturasDAO();
									listLicenciaturasDTO = licenciaturasDAO.retrieveLicenciaturas(new LicenciaturasDTO());
									request.getSession().getAttribute("listaLicenciaturas");
									session.setAttribute("listaLicenciaturas", listLicenciaturasDTO);
									
									for (int reg = 0; reg < listLicenciaturasDTO.size(); reg++) {
										licenciaturasDTO = listLicenciaturasDTO.get(reg);
										out.println("<option value=" + licenciaturasDTO.getIdLicenciatura() + ">"
												+ licenciaturasDTO.getNombre() + "</option>");
										
									} 
									
								%>
						</select>
						</td>
<label>
        <span>&nbsp;</span> 
        <input type="submit" value="Insertar"></input>
        </label>    
</form>
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
