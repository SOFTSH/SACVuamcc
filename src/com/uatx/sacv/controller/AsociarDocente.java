package com.uatx.sacv.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uatx.sacv.dao.DocentesDAO;
import com.uatx.sacv.dto.AsociarDocentesDTO;
import com.uatx.sacv.dto.EmpleadosDTO;


/**
 * Servlet implementation class AsociarDocente
 */
@WebServlet("/AsociarDocente")
public class AsociarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsociarDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		EmpleadosDTO empleadosDTO = new EmpleadosDTO();
		DocentesDAO docentesDAO = new DocentesDAO();
		List<EmpleadosDTO> listEmpleadosDTO = new ArrayList<EmpleadosDTO>();
		listEmpleadosDTO = docentesDAO.retrieveEmpleados(empleadosDTO);
		
		session.setAttribute("listaEmpleados", listEmpleadosDTO);
		
		String id;
		id = request.getParameter("id") != null ? request.getParameter("id").toString():"";
		session.setAttribute("IdDocente", id);
		String id1 = request.getSession().getAttribute("IdDocente").toString();
		
		String opc = "";
		
		opc = request.getParameter("opc") != null ? request.getParameter("opc")
				.toString() : "";

		if (opc.equals("1")) {
			
			List<AsociarDocentesDTO> listAsociarDocentesDTO = new ArrayList<AsociarDocentesDTO>();
			AsociarDocentesDTO asociarDocenetesDTO = null;
			int idDocente;
			idDocente =Integer.parseInt(id);
			
			asociarDocenetesDTO = new AsociarDocentesDTO();
			asociarDocenetesDTO.setIdEmpleado(idDocente);
			System.out.println("Seteando......"+ asociarDocenetesDTO.getIdEmpleado());
			listAsociarDocentesDTO = docentesDAO.retrieveAsociarDocente(asociarDocenetesDTO);
	
			session.setAttribute("listaAsociarDocente", listAsociarDocentesDTO);
			
			response.sendRedirect("AsociarLicenciatura.jsp");
		}
		if (opc.equals("2")){
			System.out.println("opc2");
			List<AsociarDocentesDTO> listAsociarDocentesDTO = new ArrayList<AsociarDocentesDTO>();
			DocentesDAO docenteDAO = new DocentesDAO();
			AsociarDocentesDTO asociarDocentesDTO = null;
			
			String idlic = "";
			idlic = request.getParameter("SelectLic").toString();
			String idDocente;
			idDocente =request.getParameter("idDoc") != null ? request.getParameter("idDoc").toString():"";
			int idlicenciatura = Integer.parseInt(idlic);
			int idDoc;
			idDoc=Integer.parseInt(idDocente);
			asociarDocentesDTO = new AsociarDocentesDTO();
			asociarDocentesDTO.setIdLicenciatura(idlicenciatura); 
			asociarDocentesDTO.setIdEmpleado(idDoc);
			System.out.println("Seteando.... opc2"+ asociarDocentesDTO.getIdEmpleado());
			if (DocentesDAO.VerificarAsociacion(idDoc,
					Integer.parseInt(idlic)) == 1) {

				/*asociarTemaDAO.updateAsociacion(asociarTemaDTO);
				session.setAttribute("listaAsociarTema", listAsociarTemaDTO);*/
				System.out.println("Existe Asociacion");
				response.sendRedirect("/Doc/AsociarDocente.jsp");
			} else if (DocentesDAO.VerificarAsociacion(idDoc,
					Integer.parseInt(idlic)) == 2) {
				DocentesDAO.AsociarDocente(asociarDocentesDTO);
				listAsociarDocentesDTO = docenteDAO.retrieveAsociarDocente(asociarDocentesDTO);
				session.setAttribute("listaAsociarDocente", listAsociarDocentesDTO);
				
				response.sendRedirect("AsociarLicenciatura.jsp");
			} else {
				response.sendRedirect("MSJ_01_04_01.jsp");
			}
		}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
