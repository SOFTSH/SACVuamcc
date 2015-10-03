<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="javax.servlet.http.HttpSession"
	import="java.util.*,mx.uatx.curriculums.dto.EmpleadoDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (request.getSession().getAttribute("idUsuario") == null)
		response.sendRedirect("index.jsp");
%>
<html >
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Principal</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />

<script type="text/javascript" src="js/CamposVacios.js"></script>
</head>
<body> 

	<div id="header">
		<div id="logo">
			<h1><a href="">Sistema de Administración de CV´s </a></h1>
			<p><a href="http://templated.co" rel="nofollow">UAMCC</a></p>
		</div>
	</div>
	<!-- end #header -->
	<div id="navegador">
		<ul>
		
			<%

 				Integer res= (Integer)session.getAttribute("idRol");
               System.out.println("aqui debe salir"+res);
             
               res = res==null?new Integer(0):res;
              
               if(res==4){
            	%>
            	<jsp:include page="MenuSuper.jsp"></jsp:include>
            	<% 
            	   
                   }
               if(res==1){
            	   out.print("<li><a href=>Visualizar docentes</a></li>");
            	   out.print("<li><a href=Logout.jsp>Salir</a></li>");
                   }
               if(res==2){
            	   %>
            	   <jsp:include page="MenuSecretaria.jsp"></jsp:include>
            	  
            	   <% 
                 }
              if(res==3){
            	  %>
           	   <jsp:include page="MenuDocente.jsp"></jsp:include>
           	  
           	   <%
             
       
               }
                 
				%>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<div class="post">
			<% 
			String nombre= (String)session.getAttribute("nombre");
               System.out.println(nombre);
               out.print("<h1 class="+"title"+"><a href="+"#>Bienvenido: "+nombre +"</a></h1>");
               %>
				
				<p class="meta"><span class="date"></span></p>
				<div style="clear: both;">&nbsp;</div>
				<div class="entry">
						<%

 				
               res = res==null?new Integer(0):res;
              
               if(res==4){
            	   %>
            	   <jsp:include page="Super.jsp"></jsp:include>
            	   <%
                   }
               if(res==1){
            	   
            	   out.print("<p>El perfil de usuario que tienes es <strong>Coordinador</strong> los privilegios en este sistema son:"+
                		   "<ul><li>Generar y descargar los curriculums de todos los docentes en un archivo pdf.</li><li>Generar y descargar un empaquetado con extension .zip de cada uno de los curriculums de los docentes.</li></ul></p>");
               }
               if(res==2){
            	   out.print("<p>El perfil de usuario que tienes es <strong>Secretaria</strong> los privilegios en este sistema son:"+
                		   "<ul><li>Registrar docentes.</li><li>Modificar información curricular de los docentes.</li><li>Generar y descargar el curriculum en formato pdf de un docente en particular</li><li>Asignar un docente a la licenciatura</li></ul></p>");
            	 }
              if(res==3){
            	  
            	  out.print("<p>El perfil de usuario que tienes es <strong>Docente</strong> los privilegios en este sistema son:"+
               		   "<ul><li>Administrar tu información curricular.</li><li>Generar y descargar tu curriculum en formato pdf.</li></ul></p>");
           	 
            	 
               }
                 
				%>
				 
</div>
			</div>
		
		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->

	</div>
	</div>
	<!-- end #page -->
</div>
	
	<!-- end #footer -->
</body>
</html>