package mx.uatx.curriculums.dto;

import java.sql.Blob;

public class CursosDTO {
	int IdCurso;
	String Nombre;
	String FechaI;
	String FechaF;
	String Institucion;
	String Lugar;
	String Horas;
	String Constancia;
	int IdEstatus;
	int IdAsignar;
	String Fecha;
	int IdUsuarioCambio;
	
	
	int Descripcion;
	
	
	public int getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(int descripcion) {
		Descripcion = descripcion;
	}
	int Estatus;
	public int getIdCurso() {
		return IdCurso;
	}
	public void setIdCurso(int idCurso) {
		IdCurso = idCurso;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getFechaI() {
		return FechaI;
	}
	public void setFechaI(String fechaI) {
		FechaI = fechaI;
	}
	public String getFechaF() {
		return FechaF;
	}
	public void setFechaF(String fechaF) {
		FechaF = fechaF;
	}
	public String getInstitucion() {
		return Institucion;
	}
	public void setInstitucion(String institucion) {
		Institucion = institucion;
	}
	public String getLugar() {
		return Lugar;
	}
	public void setLugar(String lugar) {
		Lugar = lugar;
	}
	public String getHoras() {
		return Horas;
	}
	public void setHoras(String horas) {
		Horas = horas;
	}
	public String getConstancia() {
		return Constancia;
	}
	public void setConstancia(String constancia) {
		Constancia = constancia;
	}
	public int getIdEstatus() {
		return IdEstatus;
	}
	public void setIdEstatus(int idEstatus) {
		IdEstatus = idEstatus;
	}
	public int getIdAsignar() {
		return IdAsignar;
	}
	public void setIdAsignar(int idAsignar) {
		IdAsignar = idAsignar;
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
}
