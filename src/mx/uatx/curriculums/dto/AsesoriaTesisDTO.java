package mx.uatx.curriculums.dto;

import java.io.IOException;
import java.sql.Blob;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsesoriaTesisDTO
 */
@WebServlet("/AsesoriaTesisDTO")
public class AsesoriaTesisDTO extends HttpServlet {

public int getIdAsesoria() {
		return IdAsesoria;
	}
	public void setIdAsesoria(int idAsesoria) {
		IdAsesoria = idAsesoria;
	}
	public String getProyecto() {
		return Proyecto;
	}
	public void setProyecto(String proyecto) {
		Proyecto = proyecto;
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
	public String getAlumno() {
		return Alumno;
	}
	public void setAlumno(String alumno) {
		Alumno = alumno;
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
	public int getIdUsuarioCambio() {
		return IdUsuarioCambio;
	}
	public void setIdUsuarioCambio(int idUsuarioCambio) {
		IdUsuarioCambio = idUsuarioCambio;
	}
	public int getEstatus() {
		return Estatus;
	}
	public void setEstatus(int estatus) {
		Estatus = estatus;
	}
	public int getAsignarDocente_IdAsignar() {
		return AsignarDocente_IdAsignar;
	}
	public void setAsignarDocente_IdAsignar(int asignarDocente_IdAsignar) {
		AsignarDocente_IdAsignar = asignarDocente_IdAsignar;
	}
int IdAsesoria;
String Proyecto;
String Nivel;
String FechaTitulacion;
String Alumno;
String Constancia;
String Fecha;
int IdUsuarioCambio;
int Estatus;
int AsignarDocente_IdAsignar;

	
}
