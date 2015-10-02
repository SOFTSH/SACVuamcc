package mx.uatx.curriculum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.uatx.curriculum.db.ConexionBD;
import mx.uatx.curriculum.db.SQLQueries;

import mx.uatx.curriculum.dto.RegistroPublicacionesDTO;

public class RegistroPublicacionesDAO {
	///////////// crear publicaciones

	public boolean createPublicaciones(RegistroPublicacionesDTO publicacionesDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;																												
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "insert into publicaciones values (0,'" + publicacionesDTO.getFechaI() + "', '"
					+ publicacionesDTO.getFechaF() + "','" + publicacionesDTO.getNombre() + "', '"
					+ publicacionesDTO.getInstitucion() + "', '" + publicacionesDTO.getConstancia()
					+ "', curdate(), 1,1,1)";

			System.out.println(query);
			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroPublicacionesDAO.createPublicaciones" + ex.getMessage());
			return false;
		}
	}

	////////////////////////// actualizar publicaciones

	public boolean updatePublicaciones(RegistroPublicacionesDTO publicacionesDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);

			query = "update publicaciones set FechaI='" + publicacionesDTO.getFechaI() + "', FechaF='"
					+ publicacionesDTO.getFechaF() + "', Nombre='" + publicacionesDTO.getNombre() + "', Institucion='"
					+ publicacionesDTO.getInstitucion() + "', constancia='" + publicacionesDTO.getConstancia()
					+ "', FechaActual= curdate() where IdPublicacion=1";

			System.out.println("ID publicacion" + publicacionesDTO.getIdPublicacion());
			System.out.println(query);

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroPublicacionesDAO.updatePublicaciones:" + ex.getMessage());
			return false;
		}
	}
	
	
	////////////////////////eliminar
	
	
	public boolean deletePublicaciones(RegistroPublicacionesDTO publicacionesDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = "update publicaciones set estatus= 0 where IdPublicacion =" + publicacionesDTO.getIdPublicacion();

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroPublicacionesDAO.deletePublicaciones:" + ex.getMessage());
			return false;
		}
	}
	//////////////////////listar
	
	
	public List<RegistroPublicacionesDTO> retrievePublicaciones(RegistroPublicacionesDTO publicacionesDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<RegistroPublicacionesDTO> listEmpleadoDTO = new ArrayList<RegistroPublicacionesDTO>();
			ResultSet rs = null;
			RegistroPublicacionesDTO filaEmpleadoDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select idpublicacion,fechai,fechaf,nombre,institucion,constancia,fechaActual, IdUsuarioCambio,estatus,AsignarDocente_IdAsignar  from publicaciones where estatus=1";
			
			if (publicacionesDTO.getIdPublicacion() > 0) {
				query += " and IdPublicacion = " + publicacionesDTO.getIdPublicacion();
				System.out.println(query);
			}
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaEmpleadoDTO = new RegistroPublicacionesDTO();

				System.out.println();
				System.out.println("este es el id:  " + rs.getInt("IdPublicacion"));

				filaEmpleadoDTO.setIdPublicacion(rs.getInt("IdPublicacion"));
				// System.out.println("nombre: " + rs.getString("nombre"));

				filaEmpleadoDTO.setFechaI(rs.getString("FechaI"));
				filaEmpleadoDTO.setFechaF(rs.getString("FechaF"));
				filaEmpleadoDTO.setNombre(rs.getString("Nombre"));
				filaEmpleadoDTO.setInstitucion(rs.getString("Institucion"));
				filaEmpleadoDTO.setConstancia(rs.getString("Constancia"));
				filaEmpleadoDTO.setFechaActual(rs.getString("FechaActual"));
				filaEmpleadoDTO.setIdUsuarioCambio(rs.getInt("IdUsuarioCambio"));
				filaEmpleadoDTO.setEstatus(rs.getInt("Estatus"));
				filaEmpleadoDTO.setAsignarDocente_IdAsignar(rs.getInt("AsignarDocente_IdAsignar"));
				

				listEmpleadoDTO.add(filaEmpleadoDTO);

			}
			conexionBD.cerrar();
			return listEmpleadoDTO;
		} catch (Exception ex) {
			System.out.println("RegistroPublicacionesDAO.retrievePublicaciones" + ex.getMessage());
			return null;
		}
	}

}
