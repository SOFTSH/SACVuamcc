package mx.uatx.curriculums.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.uatx.curriculums.db.ConexionBD;
import mx.uatx.curriculums.db.SQLQueries;
import mx.uatx.curriculums.dto.EmpleadoDTO;

/**
 * Clase DAO para realizar el CRUD de la tabla 'usuario' de la Base de Datos
 * 'SICOL' version 0.1 primera implementacion
 * 
 * @author David Candia
 * 
 */
public class EmpleadoDAO {

	/**
	 * Método que permite insertar un nuevo registro a la tabla 'usuario' de la
	 * Base de Datos'SICOL'
	 * 
	 * @param datos
	 *            de tipo usuarioDTO
	 * @return true si la accion se completo con exito, de lo contario regresa
	 *         false
	 */
	

	/**
	 * 
	 * @param datos
	 *            de tipo usuarioDTO
	 * @return true si el usuario y contraseña existen en BD, de lo contrario
	 *         regresa false.
	 */

	public List<EmpleadoDTO> Login(EmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<EmpleadoDTO> listUsuarioEnSessionDTO = new ArrayList<EmpleadoDTO>();
			EmpleadoDTO filaUsuarioDTO = null;
			ResultSet rs = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = "SELECT idEmpleado, nombre, ap, am, noEmpleado,contrasena,correo,IdRol FROM empleados WHERE noEmpleado='"
					+ empleadoDTO.getNoEmpleado() + "' AND contrasena='"
					+ empleadoDTO.getContrasena() + "'";
			rs = sqlQueries.consulta(query);
			int count = 0;
			while (rs.next()) {
				filaUsuarioDTO = new EmpleadoDTO();
				filaUsuarioDTO.setId(rs.getInt("idEmpleado"));
				System.out.print(rs.getInt("idEmpleado"));
				filaUsuarioDTO.setNombre(rs.getString("nombre"));
				System.out.print(rs.getString("nombre"));
				filaUsuarioDTO.setAp(rs.getString("ap"));
				System.out.print(rs.getString("ap"));
				filaUsuarioDTO.setAm(rs.getString("am"));
				System.out.print(rs.getString("am"));
				filaUsuarioDTO.setNoEmpleado(rs.getString("noEmpleado"));
				System.out.print(rs.getString("noEmpleado"));
				filaUsuarioDTO.setContrasena(rs.getString("Contrasena"));
				System.out.print(rs.getString("Contrasena"));
				filaUsuarioDTO.setCorreo(rs.getString("correo"));
				System.out.print(rs.getString("correo"));
				filaUsuarioDTO.setIdRol(rs.getInt("idRol"));
				System.out.print(rs.getInt("idRol"));
				listUsuarioEnSessionDTO.add(filaUsuarioDTO);
				System.out.println("");
				count++;
			}
			if (count != 0) {
				System.out.println(count);
				System.out.println("Bienvenido"+filaUsuarioDTO.getNombre());
				return listUsuarioEnSessionDTO;
			}if(count ==0) {
				System.out.println("Usuario no registrado");
			}
			conexionBD.cerrar();
		} catch (Exception ex) {
			System.out.println("EmpleadoDAO.Login:" + ex.getMessage());
			return null;
		}
		return null;
	}
	public List<EmpleadoDTO> PrimerSesions(EmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<EmpleadoDTO> listUsuarioEnSessionDTO = new ArrayList<EmpleadoDTO>();
			EmpleadoDTO filaUsuarioDTO = null;
			ResultSet rs = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = "SELECT idEmpleado, nombre, ap, am, noEmpleado,contrasena,correo,IdRol FROM empleados WHERE noEmpleado='"
					+ empleadoDTO.getNoEmpleado() + "' AND contrasena='"
					+ empleadoDTO.getNoEmpleado() + "'";
			rs = sqlQueries.consulta(query);
			int count = 0;
			while (rs.next()) {
				filaUsuarioDTO = new EmpleadoDTO();
				filaUsuarioDTO.setId(rs.getInt("idEmpleado"));
				System.out.print(rs.getInt("idEmpleado"));
				filaUsuarioDTO.setNombre(rs.getString("nombre"));
				System.out.print(rs.getString("nombre"));
				filaUsuarioDTO.setAp(rs.getString("ap"));
				System.out.print(rs.getString("ap"));
				filaUsuarioDTO.setAm(rs.getString("am"));
				System.out.print(rs.getString("am"));
				filaUsuarioDTO.setNoEmpleado(rs.getString("noEmpleado"));
				System.out.print(rs.getString("noEmpleado"));
				filaUsuarioDTO.setContrasena(rs.getString("Contrasena"));
				System.out.print(rs.getString("Contrasena"));
				filaUsuarioDTO.setCorreo(rs.getString("correo"));
				System.out.print(rs.getString("correo"));
				filaUsuarioDTO.setIdRol(rs.getInt("idRol"));
				System.out.print(rs.getInt("idRol"));
				listUsuarioEnSessionDTO.add(filaUsuarioDTO);
				System.out.println("");
				count++;
			}
			if (count != 0) {
				System.out.println(count);
				System.out.println("Bienvenido"+filaUsuarioDTO.getNombre());
				return listUsuarioEnSessionDTO;
			}if(count ==0) {
				System.out.println("Usuario no registrado");
			}
			conexionBD.cerrar();
		} catch (Exception ex) {
			System.out.println("EmpleadoDAO.Login:" + ex.getMessage());
			return null;
		}
		return null;
	}
	/*
	 *@param datos
	 *actulizar la contrasenia
	 *
	 *return true si se actualizo la contrasenia de lo contrario
	 *       false 
	 */
	public boolean updatePass(EmpleadoDTO empleadoDTO){
		try{
			ConexionBD conexionBD= new ConexionBD();
			SQLQueries sqlQueries = null;
			String query="";
			conexionBD.abrir();
			Connection conn= conexionBD.getConexion();
			 sqlQueries= new SQLQueries(conn);
			query="update empleados set contrasena='"+empleadoDTO.getContrasena()+"'  where idempleado="+empleadoDTO.getId();
			 sqlQueries.actualiza(query);
			 conexionBD.cerrar();
			return true;
			}catch(Exception ex){
				System.out.println("usuarioDAO.updatePass:"+ex.getMessage());
			return false;
			}
	}

}
