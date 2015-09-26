package mx.uatx.curriculums.dto;

public class EmpleadoDTO {
private int id;
private String nombre;
private String ap;
private String am;
private String noEmpleado;
private String contrasena;
private String correo;
private int idRol;
private String desRol;
public String getDesRol() {
	return desRol;
}
public void setDesRol(String desRol) {
	this.desRol = desRol;
}
public int getIdRol() {
	return idRol;
}
public void setIdRol(int idRol) {
	this.idRol = idRol;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getAp() {
	return ap;
}
public void setAp(String ap) {
	this.ap = ap;
}
public String getAm() {
	return am;
}
public void setAm(String am) {
	this.am = am;
}
public String getNoEmpleado() {
	return noEmpleado;
}
public void setNoEmpleado(String noEmpleado) {
	this.noEmpleado = noEmpleado;
}
public String getContrasena() {
	return contrasena;
}
public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}

}
