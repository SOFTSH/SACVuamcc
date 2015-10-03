package mx.uatx.curriculums.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.uatx.curriculums.db.ConexionBD;
import mx.uatx.curriculums.db.SQLQueries;
import mx.uatx.curriculums.dto.RegistroEmpleadoDTO;
import mx.uatx.curriculums.dto.SinodalDTO;

public class SinodalDAO {
	public boolean createSinodal(SinodalDTO sinodalDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "insert into sinodales VALUES(0,'"
					+ sinodalDTO.getNombreProyecto()
					+ "','"
					+ sinodalDTO.getNivel()
					+ "','"
					+sinodalDTO.getFechaTitulacion()
					+ "','"
					+ sinodalDTO.getAlumnos()
					+ "','"
					+ sinodalDTO.getConstancia()
					+ "',now(),'"+sinodalDTO.getIdempleado()+ "',1,'"+sinodalDTO.getIdempleado() +"',"+sinodalDTO.getOpcionTitulacion()
					+")";
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
	
	public List<SinodalDTO> retrieveSinodal(
			SinodalDTO sinodalDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<SinodalDTO> listSinodalDTO = new ArrayList<SinodalDTO>();
			ResultSet rs = null;
			SinodalDTO filaSinodalDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select idsinodal,opcionTitulacion_idopciontitulacion,nombreproyecto,nivel,fechaTitulacion,alumnos,constancia,opciontitulacion.descripcion from sinodales inner join opciontitulacion on sinodales.opcionTitulacion_idopciontitulacion=opciontitulacion.idopciontitulacion where sinodales.estatus=1";
			if (sinodalDTO.getIdSinodal() > 0) {
				query += " and idsinodal = " + sinodalDTO.getIdSinodal();
				System.out.println(query);
			}
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaSinodalDTO = new SinodalDTO();
				filaSinodalDTO.setOpcionTitulacion(rs.getInt("opcionTitulacion_idopciontitulacion"));
				filaSinodalDTO.setIdSinodal(rs.getInt("idsinodal"));
				

				filaSinodalDTO.setNombreProyecto(rs.getString("nombreproyecto"));
				

				filaSinodalDTO.setNivel(rs.getString("nivel"));

				filaSinodalDTO.setFechaTitulacion(rs.getString("fechatitulacion"));

				filaSinodalDTO.setAlumnos(rs.getString("alumnos"));
				filaSinodalDTO.setConstancia(rs.getString("constancia"));
				filaSinodalDTO.setDescripcionTitu(rs.getString("opciontitulacion.descripcion"));
				
				
				
				
				
				
			
			
				
				System.out
						.println("______________________________________________");

				listSinodalDTO.add(filaSinodalDTO);
				System.out.println("");
			}
			conexionBD.cerrar();
			return listSinodalDTO;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.retrieveEmpleado"
					+ ex.getMessage());
			return null;
		}
	}
///////////////////////////////////
	
	/**
	 * update Empleado
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	public boolean updateSinodal(SinodalDTO sinodalDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update sinodales set nombreproyecto='" + sinodalDTO.getNombreProyecto()
					+ "',nivel='" + sinodalDTO.getNivel() + "',fechatitulacion='"
					+ sinodalDTO.getFechaTitulacion() + "',alumnos='"
					+ sinodalDTO.getAlumnos() + "',constancia='"
					+ sinodalDTO.getConstancia() + "',OpcionTitulacion_idOpcionTitulacion="
					+ sinodalDTO.getOpcionTitulacion() + ",fecha=curdate(),idusuariocambio='"+sinodalDTO.getIdempleado()+"' where idsinodal="
					+sinodalDTO.getIdSinodal();
	
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

	public boolean deleteSinodal(SinodalDTO sinodalDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update sinodales set estatus=0,idusuariocambio='"+sinodalDTO.getIdempleado()+"' where idsinodal="
					+ sinodalDTO.getIdSinodal();

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.deleteEmpleado:"
					+ ex.getMessage());
			return false;
		}
	}
	public boolean deleteLicenciatura(RegistroEmpleadoDTO empleadoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update licenciaturas set estatus=0 where idlicenciatura="
					+ empleadoDTO.getIdLic();
System.out.println(query);
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
			query = "select idlicenciatura,descripcion from licenciaturas where estatus=1";
			
			  if (empleadoDTO.getIdLic() > 0) { 
				  query += " and idLicenciatura = " +
			  empleadoDTO.getIdLic(); System.out.println(query); 
			  }
			 
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
