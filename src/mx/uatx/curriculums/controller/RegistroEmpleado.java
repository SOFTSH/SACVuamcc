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
import mx.uatx.curriculums.dto.RegistroEmpleadoDTO;

/**
 * Servlet implementation class RegistroEmpleado
 */
@WebServlet("/RegistroEmpleado")
public class RegistroEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession ssesion = request.getSession();
		String opc = "";
		boolean isUpdating = false;
		opc = request.getParameter("opc") != null ? request.getParameter("opc")
				.toString() : "";
		isUpdating = ssesion.getAttribute("isUpdating") != null ? (Boolean) ssesion
				.getAttribute("isUpdating") : false;
		if (opc.equals("1") && isUpdating == false) {
			RegistroEmpleadoDTO empleadoDTO = new RegistroEmpleadoDTO();
			RegistroEmpleadoDAO empleadoDAO = new RegistroEmpleadoDAO();

			String nombre = "";
			String ap = "";
			String am = "";
			String noe = "";
			String contrasena = "";
			String correo = "";
			String rol = "";
			String lic = "";
			nombre = request.getParameter("nombre") != null ? request
					.getParameter("nombre").toString() : "";
			ap = request.getParameter("ap") != null ? request
					.getParameter("ap").toString() : "";
			am = request.getParameter("am") != null ? request
					.getParameter("am").toString() : "";
			noe = request.getParameter("noe") != null ? request.getParameter(
					"noe").toString() : "";
			
			correo = request.getParameter("correo") != null ? request
					.getParameter("correo").toString() : "";
			rol = request.getParameter("rol").toString();
			
			int rol1 = Integer.parseInt(rol);
		
			empleadoDTO = new RegistroEmpleadoDTO();
			empleadoDTO.setNombre(nombre);
			empleadoDTO.setAp(ap);
			empleadoDTO.setAm(am);
			empleadoDTO.setNumeroE(noe);
			empleadoDTO.setContrasena(contrasena);
			empleadoDTO.setCorreo(correo);
			empleadoDTO.setIdRol(rol1);

			System.out.println("ROL en servlet" + empleadoDTO.getIdRol());
			System.out.println("LIC en servlet"
					+ empleadoDTO.getIdLicenciatura());
			empleadoDAO.createEmpleado(empleadoDTO);
			List<RegistroEmpleadoDTO> listEmpleadoDTO = new ArrayList<RegistroEmpleadoDTO>();
			listEmpleadoDTO = empleadoDAO
					.retrieveEmpleado(new RegistroEmpleadoDTO());
			ssesion.setAttribute("listaEmpleado", listEmpleadoDTO);
			response.sendRedirect("RegistroCS.jsp");
		}
		if (opc.equals("1") && isUpdating == true) {
			RegistroEmpleadoDTO empleadoDTO = new RegistroEmpleadoDTO();
			RegistroEmpleadoDAO empleadoDAO = new RegistroEmpleadoDAO();

			String nombre = "";
			String ap = "";
			String am = "";
			String noe = "";
			String contrasena = "";
			String correo = "";
			String rol = "";
			
			nombre = request.getParameter("nombre") != null ? request
					.getParameter("nombre").toString() : "";
			ap = request.getParameter("ap") != null ? request
					.getParameter("ap").toString() : "";
			am = request.getParameter("am") != null ? request
					.getParameter("am").toString() : "";
			noe = request.getParameter("noe") != null ? request.getParameter(
					"noe").toString() : "";
			contrasena = request.getParameter("contrasena") != null ? request
					.getParameter("contrasena").toString() : "";
			correo = request.getParameter("correo") != null ? request
					.getParameter("correo").toString() : "";
			rol = request.getParameter("rol").toString();

			int rol1 = Integer.parseInt(rol);

			empleadoDTO = new RegistroEmpleadoDTO();
			empleadoDTO.setNombre(nombre);
			empleadoDTO.setAp(ap);
			empleadoDTO.setAm(am);
			empleadoDTO.setNumeroE(noe);
			empleadoDTO.setContrasena(contrasena);
			empleadoDTO.setCorreo(correo);
			empleadoDTO.setIdRol(rol1);
	
			empleadoDTO.setIdEmpleado((Integer) request.getSession()
					.getAttribute("idEmpleado"));

			empleadoDAO.updateEmpleado(empleadoDTO);
			List<RegistroEmpleadoDTO> listEmpleadoDTO = new ArrayList<RegistroEmpleadoDTO>();
			listEmpleadoDTO = empleadoDAO
					.retrieveEmpleado(new RegistroEmpleadoDTO());
			ssesion.setAttribute("listaEmpleado", listEmpleadoDTO);
			ssesion.setAttribute("isUpdating", false);
			ssesion.setAttribute("idEmpleado", 0);
			ssesion.setAttribute("updateEmpleadoDTO", null);
			response.sendRedirect("RegistroCS.jsp");

		}
		if (opc.equals("2")) {

			RegistroEmpleadoDTO empleadoDTO = null;
			RegistroEmpleadoDAO empleadoDAO = new RegistroEmpleadoDAO();
			RegistroEmpleadoDTO updateEmpleadoDTO = null;
			// ssesion = request.getSession();
			int id;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			empleadoDTO = new RegistroEmpleadoDTO();
			updateEmpleadoDTO = new RegistroEmpleadoDTO();
			empleadoDTO.setIdEmpleado(id);
			updateEmpleadoDTO = empleadoDAO.retrieveEmpleado(empleadoDTO)
					.get(0);

			ssesion.setAttribute("updateEmpleadoDTO", updateEmpleadoDTO);
			ssesion.setAttribute("isUpdating", true);
			ssesion.setAttribute("idEmpleado", id);
			response.sendRedirect("RegistroCS.jsp");
		}

		if (opc.equals("3")) {
			RegistroEmpleadoDTO empleado1DTO = new RegistroEmpleadoDTO();
			RegistroEmpleadoDAO empleado1DAO = new RegistroEmpleadoDAO();
			ssesion = request.getSession();
			int id = 0;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			empleado1DTO = new RegistroEmpleadoDTO();

			empleado1DTO.setIdEmpleado(id);

			empleado1DAO.deleteEmpleado(empleado1DTO);
			List<RegistroEmpleadoDTO> listEmpleado1DTO = new ArrayList<RegistroEmpleadoDTO>();
			listEmpleado1DTO = empleado1DAO.retrieveEmpleado(empleado1DTO);
			ssesion.setAttribute("listaEmpleado", listEmpleado1DTO);
			response.sendRedirect("RegistroCS.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
