package mx.uatx.curriculum.dto;

public class RegistroPublicacionesDTO {
	
	private int IdPublicacion;

	public String FechaI;

	public String	FechaF;

	public String Nombre;

	public String Institucion;

	public String	Constancia;

	public String	FechaActual;

	public int IdUsuarioCambio;

	public int Estatus;

	public int  AsignarDocente_IdAsignar;

	public int getIdPublicacion() {
		return IdPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		IdPublicacion = idPublicacion;
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

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getInstitucion() {
		return Institucion;
	}

	public void setInstitucion(String institucion) {
		Institucion = institucion;
	}

	public String getConstancia() {
		return Constancia;
	}

	public void setConstancia(String constancia) {
		Constancia = constancia;
	}

	public String getFechaActual() {
		return FechaActual;
	}

	public void setFechaActual(String fechaActual) {
		FechaActual = fechaActual;
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
	
	
	

}
