package mx.uatx.curriculums.dto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SinodalDTO
 */
@WebServlet("/SinodalDTO")
public class SinodalDTO extends HttpServlet {

	
private int IdSinodal;
private String NombreProyecto;
private String Nivel;
private String FechaTitulacion;
private String Alumnos;
private String Constancia;
private String Fecha;
private int Estatus;
private String descripcionTitu;
public String getDescripcionTitu() {
	return descripcionTitu;
}
public void setDescripcionTitu(String descripcionTitu) {
	this.descripcionTitu = descripcionTitu;
}
private int OpcionTitulacion;
private int idempleado;
public int getIdempleado() {
	return idempleado;
}
public void setIdempleado(int idempleado) {
	this.idempleado = idempleado;
}
public int getIdSinodal() {
	return IdSinodal;
}
public void setIdSinodal(int idSinodal) {
	IdSinodal = idSinodal;
}
public String getNombreProyecto() {
	return NombreProyecto;
}
public void setNombreProyecto(String nombreProyecto) {
	NombreProyecto = nombreProyecto;
}
public String getNivel() {
	return Nivel;
}
public void setNivel(String nivel) {
	Nivel = nivel;
}
public String getFechaTitulacion() {
	return FechaTitulacion;
}
public void setFechaTitulacion(String fechaTitulacion) {
	FechaTitulacion = fechaTitulacion;
}
public String getAlumnos() {
	return Alumnos;
}
public void setAlumnos(String alumnos) {
	Alumnos = alumnos;
}
public String getConstancia() {
	return Constancia;
}
public void setConstancia(String constancia) {
	Constancia = constancia;
}
public String getFecha() {
	return Fecha;
}
public void setFecha(String fecha) {
	Fecha = fecha;
}
public int getEstatus() {
	return Estatus;
}
public void setEstatus(int estatus) {
	Estatus = estatus;
}
public int getOpcionTitulacion() {
	return OpcionTitulacion;
}
public void setOpcionTitulacion(int opcionTitulacion) {
	OpcionTitulacion = opcionTitulacion;
}



}
