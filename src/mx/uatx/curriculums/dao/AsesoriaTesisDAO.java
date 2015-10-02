package mx.uatx.curriculums.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.uatx.curriculums.db.ConexionBD;
import mx.uatx.curriculums.db.SQLQueries;
import mx.uatx.curriculums.dto.AsesoriaTesisDTO;
import mx.uatx.curriculums.dto.RegistroEmpleadoDTO;

/**
 * Servlet implementation class AsesoriaTesisDAO
 */
@WebServlet("/AsesoriaTesisDAO")
public class AsesoriaTesisDAO  {
	
///////////////////////////////////////////////////////////////Tesis/////////////////////////////////////////////////////////
/////////////////////////////////insertar///////////////////////////////////7

public boolean createAsesoria(AsesoriaTesisDTO empleadoDTO) {
try {
ConexionBD conexionBD = new ConexionBD();
SQLQueries sqlQueries = null;
String query = "";
conexionBD.abrir();
Connection con = conexionBD.getConexion();
sqlQueries = new SQLQueries(con);

query = "insert into asesoriatesis values (0,'"
+ empleadoDTO.getProyecto()
+ "','"
+ empleadoDTO.getNivel()
+ "','"
+ empleadoDTO.getFechaTitulacion()
+ "','"
+ empleadoDTO.getAlumno()
+ "','"
+ empleadoDTO.getConstancia()
+ "',curdate(),1,1,1)";
System.out.println(query);
sqlQueries.actualiza(query);
conexionBD.cerrar();
return true;
} catch (Exception ex) {
System.out.println("AsesoriaTesisDAO.createAsesoria"
+ ex.getMessage());
return false;
}
}
/////////////////////////////////////////////////////////////////Selecionar///////////////////////////////
public List<AsesoriaTesisDTO> retrieveAsesoria(		AsesoriaTesisDTO empleadoDTO) {
try {
ConexionBD conexionBD = new ConexionBD();
SQLQueries sqlQueries = null;
List<AsesoriaTesisDTO> listEmpleadoDTO = new ArrayList<AsesoriaTesisDTO>();
ResultSet rs = null;
AsesoriaTesisDTO filaEmpleadoDTO = null;
String query = "";
conexionBD.abrir();
Connection con = conexionBD.getConexion();
sqlQueries = new SQLQueries(con);
query = "select IdAsesoria,Proyecto,Nivel,FechaTitulacion,Alumno,Constancia from asesoriatesis where Estatus=1";

if (empleadoDTO.getIdAsesoria() > 0) {
query += " and IdAsesoria = " + empleadoDTO.getIdAsesoria();
System.out.println(query);
}
rs = sqlQueries.consulta(query);
while (rs.next()) {
filaEmpleadoDTO = new AsesoriaTesisDTO();

filaEmpleadoDTO.setIdAsesoria(rs.getInt("IdAsesoria"));
System.out.println();
System.out.println("este es el id:  "
+ rs.getInt("IdAsesoria"));

filaEmpleadoDTO.setProyecto(rs.getString("Proyecto"));
System.out.println("Proyecto:  " + rs.getString("Proyecto"));

filaEmpleadoDTO.setNivel(rs.getString("Nivel"));
System.out
.println("Nivel:  " + rs.getString("Nivel"));

filaEmpleadoDTO.setFechaTitulacion(rs.getString("FechaTitulacion"));
System.out
.println("Fecha titulacion:  " + rs.getString("FechaTitulacion"));

filaEmpleadoDTO.setAlumno(rs.getString("Alumno"));
System.out.println("el alumno es:  "
+ rs.getString("Alumno"));

filaEmpleadoDTO.setConstancia(rs.getString("Constancia"));
System.out.println("el alumno es:  "
+ rs.getString("Constancia"));

System.out
.println("______________________________________________");

listEmpleadoDTO.add(filaEmpleadoDTO);
System.out.println("");
}
conexionBD.cerrar();
return listEmpleadoDTO;
} catch (Exception ex) {
System.out.println("AsesoriaTesisoDAO.retrieveAsesoria"
+ ex.getMessage());
return null;
}
}
//////////////////////////////////////////////////Actualizar///////////////////////////////////////
public boolean updateAsesoria(AsesoriaTesisDTO empleadoDTO) {
try {
ConexionBD conexionBD = new ConexionBD();
SQLQueries sqlQueries = null;
String query = "";
conexionBD.abrir();
Connection conn = conexionBD.getConexion();
sqlQueries = new SQLQueries(conn);
query = " update asesoriatesis set Proyecto='" + empleadoDTO.getProyecto()
+ "',Nivel='" + empleadoDTO.getNivel() + "',FechaTitulacion='"
+ empleadoDTO.getFechaTitulacion() + "',Alumno='"
+ empleadoDTO.getAlumno() + "',Constancia='"
+ empleadoDTO.getConstancia() + " where IdAsesoria="
+ empleadoDTO.getIdAsesoria();

System.out.println("ID EMPLEADO"+empleadoDTO.getIdAsesoria());
System.out.println(query);

sqlQueries.actualiza(query);
conexionBD.cerrar();
return true;
} catch (Exception ex) {
System.out.println("AsesoriaTesisDAO.updateAsesoria:"
+ ex.getMessage());
return false;
}
}
////////////////////////////////////////////Eliminar//////////////////////////77
public boolean deleteAsesoria(AsesoriaTesisDTO empleadoDTO) {
try {
ConexionBD conexionBD = new ConexionBD();
SQLQueries sqlQueries = null;
String query = "";
conexionBD.abrir();
Connection conn = conexionBD.getConexion();
sqlQueries = new SQLQueries(conn);
query = " update asesoriatesis set Estatus=0 where IdAsesoria="
+ empleadoDTO.getIdAsesoria();

sqlQueries.actualiza(query);
conexionBD.cerrar();
return true;
} catch (Exception ex) {
System.out.println("AsesoriaTesisDAO.deleteAsesoria:"
+ ex.getMessage());
return false;
}
}

////////////////////////////////////////////////////	
}
