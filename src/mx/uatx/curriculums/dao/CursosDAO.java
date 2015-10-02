package mx.uatx.curriculums.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.uatx.curriculums.db.ConexionBD;
import mx.uatx.curriculums.db.SQLQueries;
import mx.uatx.curriculums.dto.CursosDTO;

public class CursosDAO {

	////////////////////////// metodo para crear cursos

	public boolean createCursos(CursosDTO cursoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);

			query = "insert into cursos values(0, '" + cursoDTO.getNombre() + "', '" + cursoDTO.getFechaI() + "','"
					+ cursoDTO.getFechaF() + "','" + cursoDTO.getInstitucion() + "','" + cursoDTO.getLugar() + "','"
					+ cursoDTO.getHoras() + "','" + cursoDTO.getConstancia() + "','1','1','" + cursoDTO.getFecha()
					+ "','1','1' )";

			System.out.println(query);
			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("CursosDAO.createCursos" + ex.getMessage());
			return false;
		}
	}

	//////////// actualizar cursos
	public boolean updateCursos(CursosDTO cursoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);

			query = "update cursos set Nombre='" + cursoDTO.getNombre() + "', FechaI='" + cursoDTO.getFechaI()
					+ "', Institucion='" + cursoDTO.getInstitucion() + "', Lugar='" + cursoDTO.getLugar() + "', Horas='"
					+ cursoDTO.getHoras() + "', Constancia='" + cursoDTO.getConstancia() + "', FechaF='"
					+ cursoDTO.getFechaF() + "' ,Fecha=curdate()" + " where IdCurso="
					+ cursoDTO.getIdCurso();

			System.out.println("ID Curso" + cursoDTO.getIdCurso());
			System.out.println(query);

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("CursosDAO.updateCursos:" + ex.getMessage());
			return false;
		}
	}//////// eliminar curso

	public boolean deleteCursos(CursosDTO cursoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = " update cursos set estatus=0 where IdCurso=" + cursoDTO.getIdCurso();

			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("CursosDAO.deleteCursos:" + ex.getMessage());
			return false;
		}
	}

	//////////////////// enlistar cursos
	public List<CursosDTO> retrieveCursos(CursosDTO cursoDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<CursosDTO> listEmpleadoDTO = new ArrayList<CursosDTO>();
			ResultSet rs = null;
			CursosDTO filaEmpleadoDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);

			query = " select IdCurso , FechaI, FechaF , Nombre, Institucion, Lugar, Horas, Constancia, IdEstatus, IdAsignar, IdUsuarioCambio,Fecha, Estatus from cursos where estatus=1";

			if (cursoDTO.getIdCurso() > 0) {
				query += " and IdCurso = " + cursoDTO.getIdCurso();
				System.out.println(query);
			}

			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaEmpleadoDTO = new CursosDTO();

				filaEmpleadoDTO.setIdCurso(rs.getInt("IdCurso"));
				
				filaEmpleadoDTO.setFechaI(rs.getString("FechaI"));
				// System.out.println("descripcion rol:" +
				// rs.getString("descripcion"));
				filaEmpleadoDTO.setFechaF(rs.getString("FechaF"));
				filaEmpleadoDTO.setNombre(rs.getString("Nombre"));
				filaEmpleadoDTO.setInstitucion(rs.getString("Institucion"));
				filaEmpleadoDTO.setLugar(rs.getString("Lugar"));
				filaEmpleadoDTO.setHoras(rs.getString("Horas"));
				filaEmpleadoDTO.setConstancia(rs.getString("Constancia"));
				filaEmpleadoDTO.setIdEstatus(rs.getInt("idEstatus"));
				filaEmpleadoDTO.setIdAsignar(rs.getInt("idAsignar"));
				filaEmpleadoDTO.setIdUsuarioCambio(rs.getInt("idUsuarioCambio"));
				filaEmpleadoDTO.setFecha(rs.getString("Fecha"));
				filaEmpleadoDTO.setEstatus(rs.getInt("Estatus"));

				listEmpleadoDTO.add(filaEmpleadoDTO);
				System.out.println("");
			}
			conexionBD.cerrar();
			return listEmpleadoDTO;
		} catch (Exception ex) {
			System.out.println("CursosDAO.retrieveCursos" + ex.getMessage());
			return null;
		}

	}
	///////////////////
}