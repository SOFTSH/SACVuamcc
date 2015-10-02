package mx.uatx.curriculum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.uatx.curriculum.db.ConexionBD;
import mx.uatx.curriculum.db.SQLQueries;
import mx.uatx.curriculum.dto.RegistroComisionesDTO;



public class RegistroComisionesDAO {


	
	
	public boolean createComisiones(RegistroComisionesDTO comisionesDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "insert into comisiones VALUES(0,'" + comisionesDTO.getFechaInicio() + "','" + comisionesDTO.getNombreEvento() + "','"
					+ comisionesDTO.getInstitucion() + "','"
					+ comisionesDTO.getLugar() 
					+ "','" 
					+ comisionesDTO.getParticipaciones() 
					+ "','"
					+ comisionesDTO.getConstancia() 
					+ "','" 
					+ comisionesDTO.getFechaFin() 
					+ "',1,1,1,curdate())";
			System.out.println(query);
			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroComisionesDAO.createComisiones" + ex.getMessage());
			return false;
		}
	}

	
	
	
////////////////////////ACTUALIZAR COMISIONES

	public boolean updateComisiones(RegistroComisionesDTO comisionesDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = "update comisiones set FechaInicio='" + comisionesDTO.getFechaInicio() + "',NombreEvento='"
					+ comisionesDTO.getNombreEvento() + "',Institucion='" + comisionesDTO.getInstitucion() + "',Lugar='"
					+ comisionesDTO.getLugar() + "',Participaciones='" + comisionesDTO.getParticipaciones()
					+ "', constancia='" + comisionesDTO.getConstancia() 
					+ "', FechaFin='" + comisionesDTO.getFechaFin()
 					+ "', FechaActual=curdate() where idcomision=" + comisionesDTO.getIdComision();

			System.out.println("ID comision" + comisionesDTO.getIdComision());
			System.out.println(query);

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroComisionesDAO.updateComisiones:" + ex.getMessage());
			return false;
		}
	}
	//////////////////////////////////////// retrieve comisiones
	
	
	
	public List<RegistroComisionesDTO> retrieveComisiones(RegistroComisionesDTO comisionesDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<RegistroComisionesDTO> listEmpleadoDTO = new ArrayList<RegistroComisionesDTO>();
			ResultSet rs = null;
			RegistroComisionesDTO filaEmpleadoDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select IdComision , FechaInicio , NombreEvento, Institucion, Lugar, Participaciones, Constancia, FechaFin, IdUsuarioCambio, Estatus, AsignarDocente_IdAsignar, FechaActual from comisiones where estatus=1";
			if (comisionesDTO.getIdComision() > 0) {
				query += " and IdComision = " + comisionesDTO.getIdComision();
				System.out.println(query);
			}
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaEmpleadoDTO = new RegistroComisionesDTO();

				System.out.println();
				System.out.println("este es el id:  " + rs.getInt("IdComision"));

				filaEmpleadoDTO.setIdComision(rs.getInt("idComision"));
				// System.out.println("nombre: " + rs.getString("nombre"));

				filaEmpleadoDTO.setFechaInicio(rs.getString("FechaInicio"));
				// System.out.println("descripcion: "
				// + rs.getString("descripcion"));
				filaEmpleadoDTO.setNombreEvento(rs.getString("NombreEvento"));
				filaEmpleadoDTO.setInstitucion(rs.getString("Institucion"));
				filaEmpleadoDTO.setLugar(rs.getString("Lugar"));
				filaEmpleadoDTO.setParticipaciones(rs.getString("Participaciones"));
				filaEmpleadoDTO.setConstancia(rs.getString("Constancia"));
				filaEmpleadoDTO.setFechaFin(rs.getString("FechaFin"));
				filaEmpleadoDTO.setIdUsuariCambio(rs.getInt("IdUsuarioCambio"));
				filaEmpleadoDTO.setEstatus(rs.getInt("Estatus"));
				filaEmpleadoDTO.setAsignarDocente_IdAsignar(rs.getInt("AsignarDocente_IdAsignar"));
				filaEmpleadoDTO.setFechaActual(rs.getString("FechaActual"));

				listEmpleadoDTO.add(filaEmpleadoDTO);

			}
			conexionBD.cerrar();
			return listEmpleadoDTO;
		} catch (Exception ex) {
			System.out.println("RegistroComisionesDAO.retrieveComisiones" + ex.getMessage());
			return null;
		}
	}
///////////////////////
	
	public boolean deleteComision(RegistroComisionesDTO comisionesDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update comisiones set estatus=0 where idComision=" + comisionesDTO.getIdComision();

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroComisionesDAO.deleteComision:" + ex.getMessage());
			return false;
		}
	}
	
	
}
