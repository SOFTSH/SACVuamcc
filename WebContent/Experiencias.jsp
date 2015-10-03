
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,mx.uatx.curriculums.dto.ExperienciasDTO,mx.uatx.curriculums.dao.ExperienciasDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Registro Experiencia Laboral</title>

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

							<form name="registrocs" action="ExperienciaLaboral" method="get"
								class="basic-grey">
								<input type="hidden" name="opc" value="1" />
								<h1>
									Registro Experiencia Laboral<span>Por favor llene todos los
										Campos</span>
								</h1>

								<%
									List<ExperienciasDTO> listExperienciasDTO = new ArrayList<ExperienciasDTO>();
									ExperienciasDTO experienciasDTO = new ExperienciasDTO();
									ExperienciasDAO experienciasDAO = new ExperienciasDAO();
									listExperienciasDTO = experienciasDAO.retrieveExperiencia(experienciasDTO);
									request.getSession().getAttribute("listaExperiencia");
									session.setAttribute("listaExperiencia", listExperienciasDTO);
									for (int reg = 0; reg < listExperienciasDTO.size(); reg++) {
										experienciasDTO = listExperienciasDTO.get(reg);

									}
								%>


								<label> </label> <label> <span>Fecha inicio :</span>
									<tr class="color">
										<input onkeypress="return soloLetras(event)" id="name"
											type="date" name="inicio" 
											value=<%out.println(request.getSession().getAttribute("updateExperienciaDTO") != null
					? ((ExperienciasDTO) request.getSession().getAttribute("updateExperienciaDTO")).getFechaI() : "");%>>
									<tr></label> <label> <span>Fecha fin :</span>

									<tr class="color">
										<input onkeypress="return soloLetras(event)" id="email"
											type="date" name="fin" 
											value=<%out.println(request.getSession().getAttribute("updateExperienciaDTO") != null
					? ((ExperienciasDTO) request.getSession().getAttribute("updateExperienciaDTO")).getFecahF() : "");%>>
									<tr></label> <label> <span>Institución o empresa:</span>
									<tr class="color">
										<input onkeypress="return soloLetras(event)" id="name"
											type="text" name="empresa" placeholder="Institución o Empresa"
											value=<%out.println(request.getSession().getAttribute("updateExperienciaDTO") != null
					? ((ExperienciasDTO) request.getSession().getAttribute("updateExperienciaDTO")).getInstitucion() : "");%>>
									<tr></label> <label> <span>Departamento o facultad:</span>
									<tr class="color">
										<input id="name" type="text" name="departamento"
											placeholder="Departamento o Facultad"
											value=<%out.println(request.getSession().getAttribute("updateExperienciaDTO") != null
					? ((ExperienciasDTO) request.getSession().getAttribute("updateExperienciaDTO")).getFacultad() : "");%>>
									<tr></label> <label> <span>Lugar :</span>
									<tr class="color">
										<input id="lugar" type="text" name="lugar"
											placeholder="Lugar"
											value=<%out.println(request.getSession().getAttribute("updateExperienciaDTO") != null
					? ((ExperienciasDTO) request.getSession().getAttribute("updateExperienciaDTO")).getLugar() : "");%>>
									<tr></label> <label> <span>Puesto :</span>
									<tr class="color">
										<input id="puesto" type="text" name="puesto"
											placeholder="Puesto"
											value=<%out.println(request.getSession().getAttribute("updateExperienciaDTO") != null
					? ((ExperienciasDTO) request.getSession().getAttribute("updateExperienciaDTO")).getPuesto() : "");%>>

									</tr>
									<tr></label> <span>&nbsp;</span> <input type="submit"
									class="button" value="Guardar" /> </label>
							</form>
						</div>


						<div></div>

						<br></br>
					</div>
					<br></br> <br></br>
					<div class="CSSTableGenerator">


						<%
							//out.println("datos");
							//List<RegistroUsuarioDTO> listUsuarioDTO = new ArrayList<RegistroUsuarioDTO>();
							List<ExperienciasDTO> listExperienciasRDTO = new ArrayList<ExperienciasDTO>();
							ExperienciasDTO experienciasRDTO = new ExperienciasDTO();
							ExperienciasDAO experienciasRDAO = new ExperienciasDAO();
							listExperienciasDTO = experienciasDAO.retrieveExperiencia(experienciasDTO);
							request.getSession().getAttribute("listaExperiencia");
							if (request.getSession().getAttribute("listaExperiencia") != null) {
								listExperienciasRDTO = (List<ExperienciasDTO>) request.getSession().getAttribute("listaExperiencia");
							} else {
							}
							out.println("<center>");
							out.println("<div class=data >");
							///	out.println("<table >");
							out.println(
									"<table  id='Pmoral' ><thead><tr><td>Periodo</td><td>Institución O Empresa</td><td>Departamento O Facultad</td><td>Lugar</td><td>Puesto</td><td>Actualizar</td><td>Eliminar</td></thead><tbody>");
							for (int reg = 0; reg < listExperienciasRDTO.size(); reg++) {
								experienciasRDTO = listExperienciasRDTO.get(reg);

								out.println("<tr>");

								out.println("<th>");
								out.println("<center>" + experienciasRDTO.getFechaI()+"-"+experienciasRDTO.getFecahF() + "</center>");
								out.println("</th>");

								out.println("<th>");
								out.println("<center>" + experienciasRDTO.getInstitucion() + "</center>");
								out.println("</th>");

								out.println("<th>");
								out.println("<center>" + experienciasRDTO.getFacultad() + "</center>");
								out.println("</th>");

								out.println("<th>");
								out.println("<center>" + experienciasRDTO.getLugar() + "</center>");
								out.println("</th>");
								out.println("<th>");
								out.println("<center>" + experienciasRDTO.getPuesto() + "</center>");
								out.println("</th>");

								out.println("<th>");
								out.println("<center><a href=ExperienciaLaboral?opc=2&id=" + experienciasRDTO.getIdEx()
										+ "  class=btn btn-skin pull-right role=button id=ac  onClick=muestra('Pfisica').innerHTML>Actualizar<a/> </center>");
								out.println("</th>");
								out.println("<th>");
								out.println("<center><a href=ExperienciaLaboral?opc=3&id=" + experienciasRDTO.getIdEx()
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