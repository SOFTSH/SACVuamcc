package mx.uatx.curriculums.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.uatx.curriculums.dao.RegistroEmpleadoDAO;
import mx.uatx.curriculums.dao.SinodalDAO;
import mx.uatx.curriculums.dto.RegistroEmpleadoDTO;
import mx.uatx.curriculums.dto.SinodalDTO;

/**
 * Servlet implementation class Sinodal
 */
@WebServlet("/Sinodal")
public class Sinodal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sinodal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ssesion = request.getSession();
		String opc = "";
		boolean isUpdating = false;
		opc = request.getParameter("opc") != null ? request.getParameter("opc")
				.toString() : "";
		isUpdating = ssesion.getAttribute("isUpdating") != null ? (Boolean) ssesion
				.getAttribute("isUpdating") : false;
		if (opc.equals("1") && isUpdating == false) {
			SinodalDTO sinodalDTO = new SinodalDTO();
			SinodalDAO sinodalDAO = new SinodalDAO();
			String nombre = "";
			String nivel = "";
			String fechaTitu = "";
			String alumnos = "";
			String constancia = "";
			int opctitu;
			
			nombre = request.getParameter("NombreProyecto") != null ? request
					.getParameter("NombreProyecto").toString() : "";
			nivel = request.getParameter("Nivel") != null ? request
					.getParameter("Nivel").toString() : "";
			fechaTitu = request.getParameter("FechaTitulacion") != null ? request
					.getParameter("FechaTitulacion").toString() : "";
			alumnos = request.getParameter("Alumnos") != null ? request.getParameter(
					"Alumnos").toString() : "";
			constancia = request.getParameter("Constancia") != null ? request
					.getParameter("Constancia").toString() : "";
			opctitu = request.getParameter("opctitu") != null ? Integer.parseInt(request
					.getParameter("opctitu")) : 0;
                    
	
					sinodalDTO = new SinodalDTO();
					sinodalDTO.setNombreProyecto(nombre);
					sinodalDTO.setNivel(nivel);
					sinodalDTO.setFechaTitulacion(fechaTitu);
					sinodalDTO.setAlumnos(alumnos);
					sinodalDTO.setConstancia(constancia);
					sinodalDTO.setOpcionTitulacion(opctitu);
		             sinodalDTO.setIdempleado((int)request.getSession().getAttribute("idUsuario"));
			sinodalDAO.createSinodal(sinodalDTO);
			List<SinodalDTO> listSinodalDTO = new ArrayList<SinodalDTO>();
			listSinodalDTO = sinodalDAO.retrieveSinodal(new SinodalDTO());
			ssesion.setAttribute("listaSinodal", listSinodalDTO);
			response.sendRedirect("Sinodal.jsp");
		}
		if (opc.equals("1") && isUpdating == true) {
			SinodalDTO sinodalDTO = new SinodalDTO();
			SinodalDAO sinodalDAO = new SinodalDAO();
			String nombre = "";
			String nivel = "";
			String fechaTitu = "";
			String alumnos = "";
			String constancia = "";
			int opctitu;
			
			nombre = request.getParameter("NombreProyecto") != null ? request
					.getParameter("NombreProyecto").toString() : "";
			nivel = request.getParameter("Nivel") != null ? request
					.getParameter("Nivel").toString() : "";
			fechaTitu = request.getParameter("FechaTitulacion") != null ? request
					.getParameter("FechaTitulacion").toString() : "";
			alumnos = request.getParameter("Alumnos") != null ? request.getParameter(
					"Alumnos").toString() : "";
			constancia = request.getParameter("Constancia") != null ? request
					.getParameter("Constancia").toString() : "";
			opctitu = request.getParameter("opctitu") != null ? Integer.parseInt(request
					.getParameter("opctitu")) : 0;

	
					sinodalDTO = new SinodalDTO();
					sinodalDTO.setNombreProyecto(nombre);
					sinodalDTO.setNivel(nivel);
					sinodalDTO.setFechaTitulacion(fechaTitu);
					sinodalDTO.setAlumnos(alumnos);
					sinodalDTO.setConstancia(constancia);
					sinodalDTO.setOpcionTitulacion(opctitu);
					sinodalDTO.setIdSinodal((int)request.getSession().getAttribute("idSinodal"));
					sinodalDTO.setIdempleado((int)request.getSession().getAttribute("idUsuario"));
			sinodalDAO.updateSinodal(sinodalDTO);
			List<SinodalDTO> listSinodalDTO = new ArrayList<SinodalDTO>();
			listSinodalDTO = sinodalDAO
					.retrieveSinodal(new SinodalDTO());
			ssesion.setAttribute("listaSinodal", listSinodalDTO);
			ssesion.setAttribute("isUpdating", false);
			ssesion.setAttribute("idUsuario", 0);
			ssesion.setAttribute("idSinodal", 0);
			ssesion.setAttribute("updateSinodalDTO", null);
			response.sendRedirect("Sinodal.jsp");

		}
		if (opc.equals("2")) {

			SinodalDTO sinodalDTO = null;
            SinodalDAO sinodalDAO = new SinodalDAO();
			SinodalDTO updateSinodalDTO = null;
			// ssesion = request.getSession();
			int id;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			sinodalDTO = new SinodalDTO();
			updateSinodalDTO = new SinodalDTO();
			sinodalDTO.setIdSinodal(id);
			updateSinodalDTO = sinodalDAO.retrieveSinodal(sinodalDTO).get(0);
			ssesion.setAttribute("updateSinodalDTO", updateSinodalDTO);
			ssesion.setAttribute("isUpdating", true);
			ssesion.setAttribute("idSinodal", id);
			response.sendRedirect("Sinodal.jsp");
		}

		if (opc.equals("3")) {
			SinodalDTO sinodalDTO = new SinodalDTO();
			SinodalDAO sinodalDAO = new SinodalDAO();
			ssesion = request.getSession();
			int id = 0;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			sinodalDTO = new SinodalDTO();

			sinodalDTO.setIdSinodal(id);
			sinodalDTO.setIdempleado((int)request.getSession().getAttribute("idUsuario"));
			sinodalDAO.deleteSinodal(sinodalDTO);
			List<SinodalDTO> listSinodalDTO = new ArrayList<SinodalDTO>();
			
			listSinodalDTO = sinodalDAO.retrieveSinodal(sinodalDTO);
			ssesion.setAttribute("listasinodal", listSinodalDTO);
			response.sendRedirect("Sinodal.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
