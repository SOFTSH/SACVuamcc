package mx.uatx.curriculums.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.uatx.curriculums.db.ConexionBD;
import mx.uatx.curriculums.db.SQLQueries;
import mx.uatx.curriculums.dto.RegistroEmpleadoDTO;

public class RegistroEmpleadoDAO {
	public boolean createEmpleado(RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "insert into empleados VALUES(0,'"
					+ empleadoDTO.getNombre()
					+ "','"
					+ empleadoDTO.getAp()
					+ "','"
					+ empleadoDTO.getAm()
					+ "','"
					+ empleadoDTO.getNumeroE()
					+ "','"
					+ empleadoDTO.getNumeroE()
					+ "','"
					+ empleadoDTO.getCorreo()
					+ "',"
					+ empleadoDTO.getIdRol() + ",1)";
			System.out.println(query);
			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.createEmpleado"
					+ ex.getMessage());
			return false;
		}
	}
	////////////
	public boolean createDocente(RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "insert into empleados VALUES(0,'"
					+ empleadoDTO.getNombre()
					+ "','"
					+ empleadoDTO.getAp()
					+ "','"
					+ empleadoDTO.getAm()
					+ "','"
					+ empleadoDTO.getNumeroE()
					+ "','"
					+ empleadoDTO.getNumeroE()
					+ "','"
					+ empleadoDTO.getCorreo()
					+ "',3,1)";
			System.out.println(query);
			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.createEmpleado"
					+ ex.getMessage());
			return false;
		}
	}

	/**
	 * metodo para mostrar los empleados
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	public List<RegistroEmpleadoDTO> retrieveEmpleado(
			RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<RegistroEmpleadoDTO> listEmpleadoDTO = new ArrayList<RegistroEmpleadoDTO>();
			ResultSet rs = null;
			RegistroEmpleadoDTO filaEmpleadoDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select idempleado,nombre,ap,am,noempleado,correo,roles.descripcion from empleados inner join roles where empleados.idrol=roles.idrol and empleados.estatus=1";
			if (empleadoDTO.getIdEmpleado() > 0) {
				query += " and idempleado = " + empleadoDTO.getIdEmpleado();
				System.out.println(query);
			}
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaEmpleadoDTO = new RegistroEmpleadoDTO();

				filaEmpleadoDTO.setIdEmpleado(rs.getInt("idempleado"));
				System.out.println();
				System.out.println("este es el id:  "
						+ rs.getInt("idempleado"));

				filaEmpleadoDTO.setNombre(rs.getString("nombre"));
				System.out.println("nombre:  " + rs.getString("nombre"));

				filaEmpleadoDTO.setAp(rs.getString("ap"));
				System.out
						.println("apellido paterno:  " + rs.getString("ap"));

				filaEmpleadoDTO.setAm(rs.getString("am"));
				System.out
						.println("apellido paterno:  " + rs.getString("am"));

				filaEmpleadoDTO.setNumeroE(rs.getString("noempleado"));
				System.out.println("numero de empleado:  "
						+ rs.getString("noempleado"));

			

				filaEmpleadoDTO.setCorreo(rs.getString("correo"));
				System.out.println("correo:  " + rs.getString("correo"));

				filaEmpleadoDTO.setDescripcion(rs.getString("roles.descripcion"));
				System.out.println("roles.descripcion:  "
						+ rs.getString("roles.descripcion"));

				
				System.out
						.println("______________________________________________");

				listEmpleadoDTO.add(filaEmpleadoDTO);
				System.out.println("");
			}
			conexionBD.cerrar();
			return listEmpleadoDTO;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.retrieveEmpleado"
					+ ex.getMessage());
			return null;
		}
	}
///////////////////////////////////
	public List<RegistroEmpleadoDTO> retrieveDocente(
			RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<RegistroEmpleadoDTO> listEmpleadoDTO = new ArrayList<RegistroEmpleadoDTO>();
			ResultSet rs = null;
			RegistroEmpleadoDTO filaEmpleadoDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select idempleado,nombre,ap,am,noempleado,correo,roles.descripcion from empleados inner join roles where empleados.idrol=roles.idrol and empleados.estatus=1 and empleados.idRol=3";
			if (empleadoDTO.getIdEmpleado() > 0) {
				query += " and idempleado = " + empleadoDTO.getIdEmpleado();
				System.out.println(query);
			}
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaEmpleadoDTO = new RegistroEmpleadoDTO();

				filaEmpleadoDTO.setIdEmpleado(rs.getInt("idempleado"));
				System.out.println();
				System.out.println("este es el id:  "
						+ rs.getInt("idempleado"));

				filaEmpleadoDTO.setNombre(rs.getString("nombre"));
				System.out.println("nombre:  " + rs.getString("nombre"));

				filaEmpleadoDTO.setAp(rs.getString("ap"));
				System.out
						.println("apellido paterno:  " + rs.getString("ap"));

				filaEmpleadoDTO.setAm(rs.getString("am"));
				System.out
						.println("apellido paterno:  " + rs.getString("am"));

				filaEmpleadoDTO.setNumeroE(rs.getString("noempleado"));
				System.out.println("numero de empleado:  "
						+ rs.getString("noempleado"));

			

				filaEmpleadoDTO.setCorreo(rs.getString("correo"));
				System.out.println("correo:  " + rs.getString("correo"));

				filaEmpleadoDTO.setDescripcion(rs.getString("roles.descripcion"));
				System.out.println("roles.descripcion:  "
						+ rs.getString("roles.descripcion"));

				
				System.out
						.println("______________________________________________");

				listEmpleadoDTO.add(filaEmpleadoDTO);
				System.out.println("");
			}
			conexionBD.cerrar();
			return listEmpleadoDTO;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.retrieveEmpleado"
					+ ex.getMessage());
			return null;
		}
	}

	/**
	 * update Empleado
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	public boolean updateEmpleado(RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update empleados set nombre='" + empleadoDTO.getNombre()
					+ "',ap='" + empleadoDTO.getAp() + "',am='"
					+ empleadoDTO.getAm() + "',noempleado='"
					+ empleadoDTO.getNumeroE() + "',correo='"
					+ empleadoDTO.getCorreo() + "',idrol="
					+ empleadoDTO.getIdRol() + " where idempleado="
					+ empleadoDTO.getIdEmpleado();
			System.out.println("ID EMPLEADO"+empleadoDTO.getIdEmpleado());
			System.out.println(query);

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.updateEmpleado:"
					+ ex.getMessage());
			return false;
		}
	}

	/**
	 * delete
	 * 
	 * @param empleadoDTO
	 * @return
	 */
	public boolean deleteEmpleado(RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update empleados set estatus=0 where idempleado="
					+ empleadoDTO.getIdEmpleado();

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.deleteEmpleado:"
					+ ex.getMessage());
			return false;
		}
	}

	/**
	 * retrive rol
	 * 
	 * @param empleadoDTO
	 * @return
	 */

	public List<RegistroEmpleadoDTO> retrieveLicenciatura(
			RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<RegistroEmpleadoDTO> listLicenciaturaDTO = new ArrayList<RegistroEmpleadoDTO>();
			ResultSet rs = null;
			RegistroEmpleadoDTO filaLicenciaturaDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select idlicenciatura,descripcion from licenciaturas";
			/**
			 * if (empleadoDTO.getIdEmpleado() > 0) { query += " and id = " +
			 * empleadoDTO.getIdEmpleado(); System.out.println(query); }
			 */
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaLicenciaturaDTO = new RegistroEmpleadoDTO();

				filaLicenciaturaDTO.setIdLic(rs.getInt("idlicenciatura"));
				// System.out.println("idlic: " + rs.getInt("idlicenciatura"));

				filaLicenciaturaDTO.setDescripcionLic(rs
						.getString("descripcion"));
				// System.out.println("descripcion: "
				// + rs.getString("descripcion"));

				listLicenciaturaDTO.add(filaLicenciaturaDTO);
				System.out.println("");
			}
			conexionBD.cerrar();
			return listLicenciaturaDTO;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.retrieveLicenciatura"
					+ ex.getMessage());
			return null;
		}
	}

	/***
	 * retrive rol
	 * 
	 * @param empleadoDTO
	 * @return
	 */

	public List<RegistroEmpleadoDTO> retrieveRol(RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<RegistroEmpleadoDTO> listRolDTO = new ArrayList<RegistroEmpleadoDTO>();
			ResultSet rs = null;
			RegistroEmpleadoDTO filaRolDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select idrol,descripcion from roles where idrol<3";
			/**
			 * if (empleadoDTO.getIdEmpleado() > 0) { query += " and id = " +
			 * empleadoDTO.getIdEmpleado(); System.out.println(query); }
			 */
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaRolDTO = new RegistroEmpleadoDTO();

				filaRolDTO.setIdRol1(rs.getInt("idrol"));
				// System.out.println("idrol mostrar:" +rs.getInt("idrol"));

				filaRolDTO.setDescripcionRol(rs.getString("descripcion"));
				// System.out.println("descripcion rol:" +
				// rs.getString("descripcion"));

				listRolDTO.add(filaRolDTO);
				System.out.println("");
			}
			conexionBD.cerrar();
			return listRolDTO;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.retrieveRol"
					+ ex.getMessage());
			return null;
		}
	}

}
