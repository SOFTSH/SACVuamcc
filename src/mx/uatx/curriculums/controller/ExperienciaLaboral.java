package mx.uatx.curriculums.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mx.uatx.curriculums.dao.ExperienciasDAO;
import mx.uatx.curriculums.dao.RegistroEmpleadoDAO;
import mx.uatx.curriculums.dto.ExperienciasDTO;
import mx.uatx.curriculums.dto.RegistroEmpleadoDTO;

/**
 * Servlet implementation class ExperienciaLaboral
 */
@WebServlet("/ExperienciaLaboral")
public class ExperienciaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExperienciaLaboral() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ssesion = request.getSession();
		String opc = "";
		boolean isUpdating = false;
		opc = request.getParameter("opc") != null ? request.getParameter("opc").toString() : "";
		isUpdating = ssesion.getAttribute("isUpdating") != null ? (Boolean) ssesion.getAttribute("isUpdating") : false;
		if (opc.equals("1") && isUpdating == false) {
			ExperienciasDTO experienciasDTO = new ExperienciasDTO();
			ExperienciasDAO experienciasDAO = new ExperienciasDAO();

			String inicio = "";
			String fin = "";
			String empresa = "";
			String departamento = "";
			String lugar = "";
			String puesto = "";
            String archivo="";
			inicio = request.getParameter("inicio") != null ? request.getParameter("inicio").toString() : "";
			fin = request.getParameter("fin") != null ? request.getParameter("fin").toString() : "";
			empresa = request.getParameter("empresa") != null ? request.getParameter("empresa").toString() : "";
			departamento = request.getParameter("departamento") != null
					? request.getParameter("departamento").toString() : "";

			lugar = request.getParameter("lugar") != null ? request.getParameter("lugar").toString() : "";

			puesto = request.getParameter("puesto") != null ? request.getParameter("puesto").toString() : "";
			//archivo = request.getParameter("file") != null ? request.getParameter("file").toString() : "";
		
			
			experienciasDTO = new ExperienciasDTO();
			experienciasDTO.setFechaI(inicio);
			experienciasDTO.setFecahF(fin);
			experienciasDTO.setInstitucion(empresa);
			experienciasDTO.setFacultad(departamento);
		
			experienciasDTO.setLugar(lugar);
			experienciasDTO.setPuesto(puesto);
			experienciasDTO.setConstancia("");
			experienciasDTO.setIdEmpleado((int)request.getSession().getAttribute("idUsuario"));
			experienciasDAO.createExperiencia(experienciasDTO);
			List<ExperienciasDTO> listExperienciasDTO = new ArrayList<ExperienciasDTO>();
			listExperienciasDTO = experienciasDAO.retrieveExperiencia(new ExperienciasDTO());
			ssesion.setAttribute("listaExperiencia", listExperienciasDTO);
			response.sendRedirect("Experiencias.jsp");
		}
		if (opc.equals("1") && isUpdating == true) {
			ExperienciasDTO experienciasDTO = new ExperienciasDTO();
			ExperienciasDAO experienciasDAO = new ExperienciasDAO();

			String inicio = "";
			String fin = "";
			String empresa = "";
			String departamento = "";
			String lugar = "";
			String puesto = "";
            String archivo="";
			inicio = request.getParameter("inicio") != null ? request.getParameter("inicio").toString() : "";
			fin = request.getParameter("fin") != null ? request.getParameter("fin").toString() : "";
			empresa = request.getParameter("empresa") != null ? request.getParameter("empresa").toString() : "";
			departamento = request.getParameter("departamento") != null
					? request.getParameter("departamento").toString() : "";

			lugar = request.getParameter("lugar") != null ? request.getParameter("lugar").toString() : "";

			puesto = request.getParameter("puesto") != null ? request.getParameter("puesto").toString() : "";
			//archivo = request.getParameter("file") != null ? request.getParameter("file").toString() : "";
		
			
			experienciasDTO = new ExperienciasDTO();
			experienciasDTO.setFechaI(inicio);
			experienciasDTO.setFecahF(fin);
			experienciasDTO.setInstitucion(empresa);
			experienciasDTO.setFacultad(departamento);
		
			experienciasDTO.setLugar(lugar);
			experienciasDTO.setPuesto(puesto);
			experienciasDTO.setConstancia("");

			experienciasDTO.setIdEx((Integer) request.getSession().getAttribute("idExp"));
			experienciasDTO.setIdEmpleado((int)request.getSession().getAttribute("idUsuario"));
			experienciasDAO.updateExperiencia(experienciasDTO);
			List<ExperienciasDTO> listExperienciasDTO = new ArrayList<ExperienciasDTO>();
			listExperienciasDTO = experienciasDAO.retrieveExperiencia(new ExperienciasDTO());
			ssesion.setAttribute("listaExperiencia", listExperienciasDTO);
			ssesion.setAttribute("isUpdating", false);
			ssesion.setAttribute("idExp", 0);
			ssesion.setAttribute("idUsuario", 0);
			ssesion.setAttribute("updateExperienciaDTO", null);
			response.sendRedirect("Experiencias.jsp");

		}
		if (opc.equals("2")) {

			ExperienciasDTO experienciasDTO = null;
			ExperienciasDAO experienciasDAO = new ExperienciasDAO();
			ExperienciasDTO updateExperienciasDTO = null;
			// ssesion = request.getSession();
			int id;
			id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
			experienciasDTO = new ExperienciasDTO();
			updateExperienciasDTO = new ExperienciasDTO();
			experienciasDTO.setIdEx(id);
			experienciasDTO.setIdEmpleado((int)request.getSession().getAttribute("idUsuario"));
			System.out.println("jjji"+experienciasDTO.getIdEmpleado() );
			updateExperienciasDTO = experienciasDAO.retrieveExperiencia(experienciasDTO).get(0);
           
			ssesion.setAttribute("updateExperienciaDTO", updateExperienciasDTO);
			ssesion.setAttribute("isUpdating", true);
			ssesion.setAttribute("idExp", id);
			ssesion.setAttribute("idUsuario", (int)request.getSession().getAttribute("idUsuario"));
			response.sendRedirect("Experiencias.jsp");
		}

		if (opc.equals("3")) {
			ExperienciasDTO experienciaDTO = new ExperienciasDTO();
			ExperienciasDAO experienciasDAO = new ExperienciasDAO();
			ssesion = request.getSession();
			int id = 0;
			id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
			experienciaDTO = new ExperienciasDTO();

			experienciaDTO.setIdEx(id);

			experienciasDAO.deleteExperiencia(experienciaDTO);
			List<ExperienciasDTO> listExperienciaDTO = new ArrayList<ExperienciasDTO>();
			listExperienciaDTO = experienciasDAO.retrieveExperiencia(experienciaDTO);
			ssesion.setAttribute("listaExperiencia", listExperienciaDTO);
			response.sendRedirect("Experiencias.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
