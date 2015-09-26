package com.uatx.sacv.dto;

public class AsociarDocentesDTO {
	
	private int idAsignar;
	private int idEmpleado;
	private int idLicenciatura;
	private int idEstatus;
	private String licenciatura;
	
	public int getIdAsignar() {
		return idAsignar;
	}
	public void setIdAsignar(int idAsignar) {
		this.idAsignar = idAsignar;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdLicenciatura() {
		return idLicenciatura;
	}
	public void setIdLicenciatura(int idLicenciatura) {
		this.idLicenciatura = idLicenciatura;
	}
	public int getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	public String getLicenciatura() {
		return licenciatura;
	}
	public void setLicenciatura(String licenciatura) {
		this.licenciatura = licenciatura;
	}

}
