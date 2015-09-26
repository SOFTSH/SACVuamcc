package mx.uatx.curriculums.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.uatx.curriculums.dao.EmpleadoDAO;
import mx.uatx.curriculums.dto.EmpleadoDTO;
import mx.uatx.curriculums.util.ComprobarContra;
//import mx.uatx.sicol.util.MD5;

/**
 * Servlet implementation class UpdatePass
 * Servlet que permite actualizar la contrasena del usuario en sesion
 * version 0.1
 */
@WebServlet("/UpdatePass")
public class UpdatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();

	
		ComprobarContra comprobar = new ComprobarContra();//instancia para comprobar los requisitos de la nueva contrasena
		EmpleadoDTO empleadoDTO = null;
	
		String pass = "";
		String pass2 = "";
	
		boolean r = true;
		boolean r1=true;
		int id = 0;
		int idRol=0;
	  
		pass = request.getParameter("new_contra") != null ? request
				.getParameter("new_contra").toString() : "";
		pass2 = request.getParameter("new_contra1") != null ? request
				.getParameter("new_contra1").toString() : "";
				
				
	
		if (pass.equals(pass2)) {
			r = comprobar.ContraM(pass);//primer filtro de la comprobacion de la contrasena(mayusculas)
			r1=comprobar.ContraS(pass);//segundo filtro de la comprobacion de la contrasena(caracteres especiales)
			System.out.println(r);
			System.out.println(r1);
			if (r == true&&r1==true) {
				
				empleadoDTO = new EmpleadoDTO();
				empleadoDTO.setContrasena(pass);
				id = (Integer) request.getSession().getAttribute("idUsuario");
				idRol =(Integer) request.getSession().getAttribute("idRol");
				String nombre=(String)request.getSession().getAttribute("nombre");
				System.out.println("este es el numero de rol"+idRol);
				empleadoDTO.setId(id);
				empleadoDTO.setIdRol(idRol);
				empleadoDTO.setNombre(nombre);
				empleadoDAO.updatePass(empleadoDTO);
				session.setAttribute("idUsuario", empleadoDTO.getId());
				session.setAttribute("idRol", empleadoDTO.getIdRol());
				session.setAttribute("nombre", empleadoDTO.getNombre());
				//session.setAttribute("pass",passF);
				
				response.sendRedirect("Bienvenido.jsp");
			} else {
				response.sendRedirect("MSJ_01_02_01.jsp");
			}

		} else {
			response.sendRedirect("MSJ_01_02_02.jsp");
		}
		

	}

}
