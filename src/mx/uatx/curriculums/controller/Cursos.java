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

import mx.uatx.curriculums.dao.CursosDAO;
import mx.uatx.curriculums.dto.CursosDTO;

/**
 * Servlet implementation class Cursos
 */
@WebServlet("/Cursos")
public class Cursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cursos() {
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
		opc = request.getParameter("opc") != null ? request.getParameter("opc")

		.toString() : "";

		isUpdating = ssesion.getAttribute("isUpdating") != null ? (Boolean) ssesion

		.getAttribute("isUpdating") : false;

		if (opc.equals("1") && isUpdating == false) {

			CursosDTO cursoDTO = new CursosDTO();
			CursosDAO cursoDAO = new CursosDAO();

			String Nombre = "";
			String FechaI = "";
			String FechaF = "";
			String Institucion = "";
			String Lugar = "";
			String Horas = "";
			String Constancia = "";
			String Fecha = "";

			Nombre = request.getParameter("Nombre") != null ? request.getParameter("Nombre").toString() : "";

			FechaI = request.getParameter("FechaI") != null ? request.getParameter("FechaI").toString() : "";

			FechaF = request.getParameter("FechaF") != null ? request.getParameter("FechaF").toString() : "";

			Lugar = request.getParameter("Lugar") != null ? request.getParameter("Lugar").toString() : "";

			Institucion = request.getParameter("Institucion") != null ? request.getParameter("Institucion").toString()
					: "";

			Horas = request.getParameter("Horas") != null ? request.getParameter("Horas").toString() : "";

			Constancia = request.getParameter("Constancia") != null ? request.getParameter("Constancia").toString()
					: "";

			Fecha = request.getParameter("Fecha") != null ? request.getParameter("Fecha").toString() : "";

			cursoDTO = new CursosDTO();

			cursoDTO.setNombre(Nombre);
			cursoDTO.setFechaI(FechaI);
			cursoDTO.setInstitucion(Institucion);
			cursoDTO.setLugar(Lugar);
			cursoDTO.setFechaF(FechaF);
			cursoDTO.setConstancia(Constancia);
			cursoDTO.setFecha(Fecha);
			cursoDTO.setHoras(Horas);

			System.out.println(" en servlet" + cursoDTO.getIdCurso());

			cursoDAO.createCursos(cursoDTO);
			List<CursosDTO> listEmpleadoDTO = new ArrayList<CursosDTO>();
			listEmpleadoDTO = cursoDAO.retrieveCursos(new CursosDTO());
			ssesion.setAttribute("listaCurso", listEmpleadoDTO);
			response.sendRedirect("Cursos.jsp");
		}

		if (opc.equals("1") && isUpdating == true) {
			CursosDTO cursoDTO = new CursosDTO();
			CursosDAO cursoDAO = new CursosDAO();

			String Nombre = "";
			String FechaI = "";
			String FechaF = "";
			String Institucion = "";
			String Lugar = "";
			String Horas = "";
			String Constancia = "";
			String Fecha = "";
			String IdEstatus = "";

			Nombre = request.getParameter("Nombre") != null ? request.getParameter("Nombre").toString() : "";

			FechaI = request.getParameter("FechaI") != null ? request.getParameter("FechaI").toString() : "";

			FechaF = request.getParameter("FechaF") != null ? request.getParameter("FechaF").toString() : "";

			Lugar = request.getParameter("Lugar") != null ? request.getParameter("Lugar").toString() : "";

			Institucion = request.getParameter("Institucion") != null ? request.getParameter("Institucion").toString()
					: "";

			Horas = request.getParameter("Horas") != null ? request.getParameter("Horas").toString() : "";

			Constancia = request.getParameter("Constancia") != null ? request.getParameter("Constancia").toString()
					: "";

			Fecha = request.getParameter("Fecha") != null ? request.getParameter("Fecha").toString() : "";

			cursoDTO = new CursosDTO();

			cursoDTO.setNombre(Nombre);
			cursoDTO.setFechaI(FechaI);
			cursoDTO.setInstitucion(Institucion);
			cursoDTO.setLugar(Lugar);
			cursoDTO.setFechaF(FechaF);
			cursoDTO.setConstancia(Constancia);
			cursoDTO.setFecha(Fecha);
			cursoDTO.setHoras(Horas);

			cursoDTO.setIdCurso((Integer) request.getSession().getAttribute("IdCurso"));

			cursoDAO.updateCursos(cursoDTO);
			List<CursosDTO> listEmpleadoDTO = new ArrayList<CursosDTO>();
			listEmpleadoDTO = cursoDAO.retrieveCursos(new CursosDTO());
			ssesion.setAttribute("listaCurso", listEmpleadoDTO);
			ssesion.setAttribute("isUpdating", false);
			ssesion.setAttribute("IdCursos", 0);
			ssesion.setAttribute("updateCursosDTO", null);
			response.sendRedirect("Cursos.jsp");

		}
		if (opc.equals("2")) {

			CursosDTO cursoDTO = null;
			CursosDAO cursoDAO = new CursosDAO();
			CursosDTO updateCursosDTO = null;
			// ssesion = request.getSession();
			int id;
			id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
			cursoDTO = new CursosDTO();
			updateCursosDTO = new CursosDTO();
			cursoDTO.setIdCurso(id);
			updateCursosDTO = cursoDAO.retrieveCursos(cursoDTO).get(0);

			ssesion.setAttribute("updateCursosDTO", updateCursosDTO);
			ssesion.setAttribute("isUpdating", true);
			ssesion.setAttribute("IdCurso", id);
			response.sendRedirect("Cursos.jsp");
		}

		if (opc.equals("3")) {
			CursosDTO cursoDTO = new CursosDTO();
			CursosDAO cursoDAO = new CursosDAO();
			ssesion = request.getSession();
			int id = 0;
			id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
			cursoDTO = new CursosDTO();

			cursoDTO.setIdCurso(id);

			cursoDAO.deleteCursos(cursoDTO);
			List<CursosDTO> listEmpleado1DTO = new ArrayList<CursosDTO>();
			listEmpleado1DTO = cursoDAO.retrieveCursos(cursoDTO);
			ssesion.setAttribute("listaCurso", listEmpleado1DTO);
			response.sendRedirect("Cursos.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}