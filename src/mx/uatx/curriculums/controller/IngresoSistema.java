package mx.uatx.curriculums.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.uatx.curriculums.dao.EmpleadoDAO;
import mx.uatx.curriculums.dto.EmpleadoDTO;
//import mx.uatx.sicol.util.MD5;

/**
 * @author David Candia Servlet implementation class IngresoSistema Servelt que
 *         permite validar el usuario y contraseña y da acceso al sistema
 *         version 0.1
 */
@WebServlet("/IngresoSistema")
public class IngresoSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IngresoSistema() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	
				
		try {
			EmpleadoDTO empleadoDTO = new EmpleadoDTO();
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();

			String pass = request.getParameter("contrasenia");
			String login = request.getParameter("empleado");
			List<EmpleadoDTO> res;
			List<EmpleadoDTO> res1;
			empleadoDTO.setNoEmpleado(login);
			empleadoDTO.setContrasena(pass);
			res1 =empleadoDAO.PrimerSesions(empleadoDTO);
			if(res1!=null){
				response.sendRedirect("CambioCont.jsp");	
				empleadoDTO = res1.get(0);
				session = request.getSession(true);
				session.setAttribute("idUsuario", empleadoDTO.getId());
				session.setAttribute("pass", empleadoDTO.getContrasena());
				session.setAttribute("correo", empleadoDTO.getCorreo());
				session.setAttribute("idRol", empleadoDTO.getIdRol());
				session.setAttribute("nombre", empleadoDTO.getNombre());
				System.out.println("Correo "+empleadoDTO.getCorreo());
			}
			else{
				res = empleadoDAO.Login(empleadoDTO);
				if (res != null) {
					empleadoDTO = res.get(0);
					session = request.getSession(true);
					session.setAttribute("sessionActual", res);
					session.setAttribute("idUsuario", empleadoDTO.getId());
					session.setAttribute("nombre", empleadoDTO.getNombre());
					session.setAttribute("pass", empleadoDTO.getContrasena());
					session.setAttribute("idRol", empleadoDTO.getIdRol());
					System.out.println("Este es el ID: " + empleadoDTO.getId());
					System.out.println("Esta es la pass:" + empleadoDTO.getContrasena());
					System.out.println("este " + empleadoDTO.getIdRol());

					response.sendRedirect("Bienvenido.jsp");
					System.out.println("este por segunda" + empleadoDTO.getIdRol());

				} else {
					response.sendRedirect("MSJ_01_01_02.jsp");
				}
			}
			
		
		} catch (Throwable theException) {
			System.out.println("Exception is" + theException);

		}

	}

}
