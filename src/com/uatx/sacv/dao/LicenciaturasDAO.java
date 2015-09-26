package com.uatx.sacv.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uatx.sacv.db.ConexionBD;
import com.uatx.sacv.db.SQLQueries;
import com.uatx.sacv.dto.LicenciaturasDTO;

public class LicenciaturasDAO {
	
	public List<LicenciaturasDTO> retrieveLicenciaturas(LicenciaturasDTO licenciaturasDTO) {
		try {
			ConexionBD conexionBD = new ConexionBD();
			SQLQueries sqlQueries = null;
			List<LicenciaturasDTO> listLicenciaturasDTO = new ArrayList<LicenciaturasDTO>();
			ResultSet rs = null;
			LicenciaturasDTO filaLicenciaturaDTO = null;
			String query = "";
			conexionBD.abrir();
			Connection con = conexionBD.getConexion();
			sqlQueries = new SQLQueries(con);
			query = "select *from Licenciaturas";
						rs = sqlQueries.consulta(query);
			while (rs.next()) {
				filaLicenciaturaDTO = new LicenciaturasDTO();
				filaLicenciaturaDTO.setIdLicenciatura(rs.getInt("idLicenciatura"));
				System.out.print(rs.getInt("idLicenciatura"));
				filaLicenciaturaDTO.setNombre(rs.getString("Descripcion"));
				System.out.print(rs.getString("Descripcion"));
				
				listLicenciaturasDTO.add(filaLicenciaturaDTO);
				// System.out.println("");
			}
			conexionBD.cerrar();
			return listLicenciaturasDTO;
		} catch (Exception ex) {
			System.out.println("LicenciaturasDAO.retrieveLicenciaturas" + ex.getMessage());
			return null;
		}
	}

}
