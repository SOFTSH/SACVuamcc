package com.uatx.sacv.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.uatx.sacv.db.ConexionBD;
import com.uatx.sacv.db.SQLQueries;
import com.uatx.sacv.dto.AsociarDocentesDTO;
import com.uatx.sacv.dto.EmpleadosDTO;

public class DocentesDAO {
	
	
	
	/**
	 * Método que permite realizar una consulta a la tabla 'Empleados' de la Base
	 * de Datos 'mydb'
	 * 
	 * @param datos
	 *            de tipo EmpleadoDTO
	 * @return arreglo de tipo EmpleadoDTO
	 */
	public List<EmpleadosDTO> retrieveEmpleados(EmpleadosDTO EmpleadosDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<EmpleadosDTO> listEmpleadosDTO = new ArrayList<EmpleadosDTO>();
			ResultSet rs = null;
			EmpleadosDTO filaEmpleadoDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select idEmpleado,Nombre,Ap,Am,NoEmpleado,Contrasena,Correo,IdRol,EstatusEmpleado"
					+ " FROM Empleados where IdRol = 4";
						rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaEmpleadoDTO = new EmpleadosDTO();
				filaEmpleadoDTO.setIdEmpleado(rs.getInt("idEmpleado"));
				System.out.print(rs.getInt("idEmpleado"));
				filaEmpleadoDTO.setNombre(rs.getString("Nombre"));
				System.out.print(rs.getString("Nombre"));
				filaEmpleadoDTO.setAp(rs.getString("Ap"));
				filaEmpleadoDTO.setAm(rs.getString("Am"));
				filaEmpleadoDTO.setNoEmpleado(rs.getString("NoEmpleado"));
				filaEmpleadoDTO.setContrasenia(rs.getString("Contrasena"));
				filaEmpleadoDTO.setEmail(rs.getString("Correo"));
				filaEmpleadoDTO.setRol(rs.getInt("IdRol"));
				filaEmpleadoDTO.setEstatus(rs.getInt("EstatusEmpleado"));
				listEmpleadosDTO.add(filaEmpleadoDTO);
				// System.out.println("");
			}
			conexionBD.cerrar();
			return listEmpleadosDTO;
		} catch (Exception ex) {
			System.out.println("EmpleadosDAO.retrieveEmpleados" + ex.getMessage());
			return null;
		}
	}
	
	public static boolean AsociarDocente(AsociarDocentesDTO asociarDocentesDTO) {
			
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "INSERT INTO AsigarDocente  VALUES(0,"
					+ asociarDocentesDTO.getIdEmpleado()
					+ ","
					+ asociarDocentesDTO.getIdLicenciatura() + ",1)";
			// System.out.println(query);
			sqlQueries.actualiza(query);
			conexionBD.cerrar();
			return true;
		} catch (Exception ex) {
			System.out.println("DocenteDAO.AsociarDocente"
					+ ex.getMessage());
			return false;
		}
	}
	
	public static int VerificarAsociacion(int idDocente, int idlicenciatura) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			ResultSet rs = null;
			String query = "";
			conexionBD.abrir();
			Connection conn = conexionBD.getConexion();
			sqlQueries = new SQLQueries(conn);
			query = "SELECT *FROM AsigarDocente WHERE idEmpleado="
					+ idDocente
					+ " and idLicenciatura="
					+ idlicenciatura
					+ " and EstatusEmpleado=1";
			
			rs = sqlQueries.consulta(query);
			int count = 0;
			while (rs.next()) {
				count++;
			}
			if (count > 0) {
				System.out.println("Existe Asociacion");
				return 1;
			}  else {
				System.out.println("No Existe Asociacion");
			}
			conexionBD.cerrar();
		} catch (Exception ex) {
			System.out.println("DocentesDAO.VerificarAsociacion:"
					+ ex.getMessage());
			return 0;
		}
		return 2;
	}
	
	public List<AsociarDocentesDTO> retrieveAsociarDocente(
			AsociarDocentesDTO asociarDocentesDTO) {
		System.out.println("Entro Retive AsociarDocente");
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<AsociarDocentesDTO> listAsociarDocentesDTO = new ArrayList<AsociarDocentesDTO>();
			ResultSet rs = null;
			AsociarDocentesDTO filaAsociarDocenteDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			System.out.println("id Retrive"+asociarDocentesDTO.getIdEmpleado());
			query = "select Licenciaturas.Descripcion from AsigarDocente "
					+ "inner join Licenciaturas on AsigarDocente.IdLicenciatura = Licenciaturas.IdLicenciatura "
					+ "where IdEmpleado ="
					+ asociarDocentesDTO.getIdEmpleado();
			
			/*if (asociarTemaDTO.getId() > 0) {
				query += " and id = " + asociarTemaDTO.getId();
				// System.out.println(query);
			}*/
			rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaAsociarDocenteDTO = new AsociarDocentesDTO();
				filaAsociarDocenteDTO.setLicenciatura(rs.getString("Descripcion"));
				 System.out.print(rs.getString("Descripcion"));
				listAsociarDocentesDTO.add(filaAsociarDocenteDTO);
				// System.out.println("");
			}
			conexionBD.cerrar();
			return listAsociarDocentesDTO;
		} catch (Exception ex) {
			System.out.println("DocentesDAO.retrieveAsociarDocente" + ex.getMessage());
			return null;
		}
	}

}
