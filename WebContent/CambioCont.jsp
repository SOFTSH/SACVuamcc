<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Cambio de contraseña</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript">

  function validarCambio(){
	if(document.cambio.new_contra.value==""){
		location.href='VaciosCambio.jsp';  
		return false;
	} 
	if(document.cambio.new_contra1.value==""){ 
		location.href='VaciosCambio.jsp';
		return false;
	} 
	
	document.formLogin.submit();
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
			<li><a href="#">Registro de Personal</a></li>
			<li class="current_page_item"><a href="RegistroD.html">Registro de Docente</a></li>
            <li ><a href="#">Salir</a></li>
		</ul>
	</div>
	</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
		
			<form name="cambio" action="UpdatePass" method="post" class="basic-grey">
    <h1>Actualizar Contraseña
        <span>Porfavor llene todos los Campos</span>
    </h1>

 
    
    <label>
        <span>Nueva Contraseña :</span>

<tr class="color"> 
       <input id="email" type="text" name="new_contra" placeholder="Nueva Contraseña" />
       </tr>
    </label>
     <label>
        <span>Repite Contraseña :</span>

<tr class="color"> 
       <input id="email" type="text" name="new_contra1" placeholder="Repite Contraseña" />
       </tr>
    </label>


     <label>
        <span>&nbsp;</span> 
        <input type="button" class="button" value="Guardar" onclick="validarCambio()"/> 
    </label>    
</form>




			</div>
		
		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			
					
		
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>



	<!-- end #page -->
</div>
	<div id="footer">
	<p>&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
	</div>
	<!-- end #footer -->
</body>
</html>
