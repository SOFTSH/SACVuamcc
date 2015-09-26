<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">

  function validarLogin(){
	if(document.formLogin.empleado.value==""){
		location.href='Vacios.jsp';  
		return false;
	} 
	if(document.formLogin.contrasenia.value==""){ 
		location.href='Vacios.jsp';
		return false;
	} 
	
	document.formLogin.submit();
  }
</script>

<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Principal</title>
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
			<li class="current_page_item"><a href="#">Inicio</a></li>
			
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
				<h1 class="title"><a href="#">Bienvenido </a></h1>
				<p class="meta"><span class="date"></span>
				<div style="clear: both;">&nbsp;</div>
				<div class="entry">
					<p>Este <strong>Sistema de Administración de CV´s</strong> de la <a href="http://templated.co" rel="nofollow">UAMCC</a>, será capaz de generar el curriculum de cada docente en el formato requerido, así mismo el Coordinador podrá Imprimir los curriculums de los docentes de forma automatizada. Para ello va a contar con las siguientes características y/o funciones:</p>
					<p>
					<ul><li> El sistema podrá administrar los curriculums de los docentes.</li>
					<li>El sistema  será capaz de generar un reporte  del curriculum de forma  individual con formato pdf.</li>
					<li>El sistema  será capaz de generar todos los curriculums de los docentes</li>
					</ul> 

					
				</div>
			


			</div>
		
		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			
		<div id="login" class="boxed">
		
			<div class="content">
			  <br>
 
  <form name="formLogin" action="IngresoSistema" method="post" class="login">

    <h1>Iniciar Sesión</h1>
 <center>
    <input name="empleado" class="login-input" placeholder="Número de empleado" maxlength="10" onkeypress="return soloNumeros(event)">
     <br></br>
    <input type="password"  name="contrasenia" class="login-input" placeholder="Contraseña" maxlength="10">
    <br></br>
    <input type="button" value="Entrar" class="btn" onclick="validarLogin()" >
    <p class="login-help"><a href="#">Olvidó su contraseña?</a></p>
    </center>
  </form>
			</div>
	
					
		
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>



	<!-- end #page -->
</div>
	<div id="footer">
	<br>
	</br>
	
	</div>
	<!-- end #footer -->
</body>
</html>
