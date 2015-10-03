package mx.uatx.curriculums.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.uatx.curriculums.db.ConexionBD;
import mx.uatx.curriculums.db.SQLQueries;
import mx.uatx.curriculums.dto.ExperienciasDTO;
import mx.uatx.curriculums.dto.RegistroEmpleadoDTO;

public class ExperienciasDAO {
	public boolean createExperiencia(ExperienciasDTO experienciaDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
		    
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "insert into experiencias VALUES(0,'"
					+ experienciaDTO.getFechaI()
					+ "','"
					+experienciaDTO.getFecahF()
					+ "','"
					+ experienciaDTO.getInstitucion()
					+ "','"
					+ experienciaDTO.getFacultad()
					+ "','"
					+ experienciaDTO.getLugar()
					+ "','"
					+ experienciaDTO.getPuesto()
					+ "','',now(),"+experienciaDTO.getIdEmpleado()+",1,"+experienciaDTO.getIdEmpleado()+")";
			System.out.println(query);
			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroExperienciasDAO.createExperiencias"
					+ ex.getMessage());
			return false;
		}
	}
	
	public List<ExperienciasDTO> retrieveExperiencia(ExperienciasDTO experienciasDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<ExperienciasDTO> listExperienciasDTO = new ArrayList<ExperienciasDTO>();
			ResultSet rs = null;
			ExperienciasDTO filaExperienciasDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = " select idexperiencia,fechaI,fechaF,institucion,facultad,lugar,puesto from experiencias where estatus=1";
			System.out.println("algo"+experienciasDTO.getIdEx());
			if (experienciasDTO.getIdEx()> 0) {
				query += " and idexperiencia = " + experienciasDTO.getIdEx();
				System.out.println(query);
			}
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaExperienciasDTO = new ExperienciasDTO();

				filaExperienciasDTO.setIdEx(rs.getInt("idexperiencia"));
				System.out.println();
				System.out.println("este es el id:  "
						+ rs.getInt("idexperiencia"));

				filaExperienciasDTO.setFechaI(rs.getString("fechaI"));
				System.out.println("Fecha I:  " + rs.getString("fechaI"));

				filaExperienciasDTO.setFecahF(rs.getString("fechaf"));
				System.out
						.println("fecha:  " + rs.getString("fechaf"));

				filaExperienciasDTO.setInstitucion(rs.getString("institucion"));
				System.out
						.println("inst:  " + rs.getString("institucion"));

				filaExperienciasDTO.setFacultad(rs.getString("facultad"));
				System.out.println("facultad:  "
						+ rs.getString("facultad"));

			

				filaExperienciasDTO.setLugar(rs.getString("lugar"));
				System.out.println("lugar:  " + rs.getString("lugar"));

				filaExperienciasDTO.setPuesto(rs.getString("puesto"));
				System.out.println("puesto:  "
						+ rs.getString("puesto"));

				
				System.out
						.println("______________________________________________");

				listExperienciasDTO.add(filaExperienciasDTO);
				System.out.println("");
			}
			conexionBD.cerrar();
			return listExperienciasDTO;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.retrieveEmpleado"
					+ ex.getMessage());
			return null;
		}
	}

	public boolean updateExperiencia(ExperienciasDTO experienciasDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update experiencias set fechaI='" + experienciasDTO.getFechaI()
					+ "',fechaF='" + experienciasDTO.getFecahF() + "',institucion='"
					+ experienciasDTO.getInstitucion() + "',facultad='"
					+ experienciasDTO.getFacultad() + "',lugar='"
					+ experienciasDTO.getLugar() + "',puesto='"
					+ experienciasDTO.getPuesto() + "', IdUsuarioCambio='"+experienciasDTO.getIdEmpleado()+"' where idexperiencia="
					+ experienciasDTO.getIdEx();
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

	public boolean deleteExperiencia(ExperienciasDTO experienciaDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update experiencias set estatus=0 where idexperiencia="
					+ experienciaDTO.getIdEx();

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("RegistroEmpleadoDAO.deleteEmpleado:"
					+ ex.getMessage());
			return false;
		}
	}
	
 
}
