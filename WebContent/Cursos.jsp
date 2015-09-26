<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="./js/CargarConstancia.js"></script>
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
								<form name="formularioCursos" enctype="multipart/form-data" action="" method="post" class="basic-grey">
								
								<label> <span>Nombre :</span></label>
									<tr class="color">
										<input type="text" name="Nombre" placeholder="Nombre">
									</tr>
								<label> <span>Periodo :</span></label>
									<tr class="color">
										<input type="text" name="Periodo" placeholder="Periodo">
									</tr>
								<label> <span>Instituci&oacute;n :</span></label>
									<tr class="color">
										<input type="text" name="Institución" placeholder="Institución">
									</tr>
								<label> <span>Lugar :</span></label>
									<tr class="color">
										<input type="text" name="Lugar" placeholder="Lugar">
									</tr>
								<label> <span>Horas :</span></label>
									<tr class="color">
										<input type="text" name="Horas" placeholder="Horas">
									</tr>
								
									<tr>
										<label> <span>Cargar Constancia:</span></label>
										<tr class="color">
										<input type=file name=constancia onchange="CargarConstancia(this)">
									</tr>
										<label>
     							   <span>&nbsp;</span> 
     							  <input name="guardar" type="button" class="button" value="Guardar" /> 
  									  </label>
    								<input type="hidden" name="hid" value="" />
									</form>
									<iframe name="iframe" style="display: none;"></iframe>
									
								<br></br>

								<div class="CSSTableGenerator">
									<table>
										<tr>

											<td>Nombre</td>
											<td>Instituci&oacute;n</td>
											<td>Constancia</td>
											<td>Actualizar</td>
											<td>Eliminar</td>
										</tr>
										<tr>
											<th>datos</th>
											<th>datos</th>
											<th>datos</th>
											<u><th>Editar</th></u>
											<u><th>Eliminar</th></u>
										</tr>
										<tr>
											<th>datos</th>
											<th>datos</th>
											<th>datos</th>
											<u><th>Editar</th></u>
											<u><th>Eliminar</th></u>
										</tr>

									</table>
								</div>

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