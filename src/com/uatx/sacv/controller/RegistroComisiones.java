package mx.uatx.curriculum.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.uatx.curriculum.dao.RegistroComisionesDAO;
import mx.uatx.curriculum.dto.RegistroComisionesDTO;

/**
 * Servlet implementation class RegistroComisiones
 */
@WebServlet("/RegistroComisiones")
public class RegistroComisiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroComisiones() {
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
			RegistroComisionesDTO comisionesDTO = new RegistroComisionesDTO();
			RegistroComisionesDAO comisionesDAO = new RegistroComisionesDAO();

			String fechainicio = "";
			String NombreEvento= "";
			String Institucion = "";
			String lugar = "";
			String participaciones = "";
			String constancia = "";
			String fechafin = "";
			String FechaActual= "";
		
			fechainicio = request.getParameter("fechainicio") != null ? request
					.getParameter("fechainicio").toString() : "";
					
					
					NombreEvento = request.getParameter("NombreEvento") != null ? request
							.getParameter("NombreEvento").toString() : "";
							
			Institucion = request.getParameter("Institucion") != null ? request
					.getParameter("Institucion").toString() : "";
					
			lugar = request.getParameter("lugar") != null ? request.getParameter(
					"lugar").toString() : "";
			
			participaciones = request.getParameter("participaciones") != null ? request
					.getParameter("participaciones").toString() : "";
					
					
			constancia = request.getParameter("constancia") != null ? request
							.getParameter("constancia").toString() : "";
							
			fechafin = request.getParameter("fechafin") != null ? request
									.getParameter("fechafin").toString() : "";
									
									FechaActual = request.getParameter("FechaActual") != null ? request
											.getParameter("FechaActual").toString() : "";
					
									comisionesDTO = new RegistroComisionesDTO();
									
									comisionesDTO .setFechaInicio(fechainicio);
									comisionesDTO .setNombreEvento(NombreEvento);
									comisionesDTO .setInstitucion(Institucion);
									comisionesDTO .setLugar(lugar);
									comisionesDTO .setParticipaciones(participaciones);
									comisionesDTO .setConstancia(constancia);
									comisionesDTO .setFechaFin(fechafin);
									comisionesDTO .setFechaActual(FechaActual);
									
					
		
		
			System.out.println("ROL en servlet" + comisionesDTO.getIdComision());
		
			
			comisionesDAO.createComisiones(comisionesDTO);
			List<RegistroComisionesDTO> listEmpleadoDTO = new ArrayList<RegistroComisionesDTO>();
			listEmpleadoDTO = comisionesDAO.retrieveComisiones(new  RegistroComisionesDTO());
					ssesion.setAttribute("listaEmpleado", listEmpleadoDTO);
			response.sendRedirect("Comisiones.jsp");
		}
		
		
		if (opc.equals("1") && isUpdating == true) {
			RegistroComisionesDTO comisionesDTO = new RegistroComisionesDTO();
			RegistroComisionesDAO comisionesDAO = new RegistroComisionesDAO();


			String fechainicio = "";
			String NombreEvento= "";
			String Institucion = "";
			String lugar = "";
			String participaciones = "";
			String constancia = "";
			String fechafin = "";
			String FechaActual = "";
			
		
			fechainicio = request.getParameter("fechainicio") != null ? request
					.getParameter("fechainicio").toString() : "";
					
					NombreEvento = request.getParameter("NombreEvento") != null ? request
							.getParameter("NombreEvento").toString() : "";
							
			
					
							Institucion = request.getParameter("Institucion") != null ? request
					.getParameter("Institucion").toString() : "";
					
			lugar = request.getParameter("lugar") != null ? request.getParameter(
					"lugar").toString() : "";
			
			participaciones = request.getParameter("participaciones") != null ? request
					.getParameter("participaciones").toString() : "";
					
					
			constancia = request.getParameter("constancia") != null ? request
							.getParameter("constancia").toString() : "";
							
			fechafin = request.getParameter("fechafin") != null ? request
									.getParameter("fechafin").toString() : "";
									
									FechaActual = request.getParameter("FechaActual") != null ? request
											.getParameter("FechaActual").toString() : "";
					
											comisionesDTO = new RegistroComisionesDTO();
											
											comisionesDTO .setFechaInicio(fechainicio);
											comisionesDTO .setNombreEvento(NombreEvento);
											comisionesDTO .setInstitucion(Institucion);
											comisionesDTO .setLugar(lugar);
											comisionesDTO .setParticipaciones(participaciones);
											comisionesDTO .setConstancia(constancia);
											comisionesDTO .setFechaFin(fechafin);
											comisionesDTO .setFechaActual(FechaActual);
	
									comisionesDTO.setIdComision((Integer) request.getSession()
					.getAttribute("idComision"));

									comisionesDAO.updateComisiones(comisionesDTO);
									
			List<RegistroComisionesDTO> listEmpleadoDTO = new ArrayList<RegistroComisionesDTO>();
			listEmpleadoDTO = comisionesDAO.retrieveComisiones(new RegistroComisionesDTO());
			ssesion.setAttribute("listaEmpleado", listEmpleadoDTO);
			ssesion.setAttribute("isUpdating", false);
			ssesion.setAttribute("idComision", 0);
			ssesion.setAttribute("updateComisionesDTO", null);
			response.sendRedirect("Comisiones.jsp");

		}
	
		
		
		
		
		if (opc.equals("2")) {

			RegistroComisionesDTO comisionesDTO = null;
			RegistroComisionesDAO comisionesDAO = new RegistroComisionesDAO();
			RegistroComisionesDTO updateEmpleadoDTO = null;
			// ssesion = request.getSession();
			int id;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			comisionesDTO = new RegistroComisionesDTO();
			updateEmpleadoDTO = new RegistroComisionesDTO();
			comisionesDTO.setIdComision(id);
			updateEmpleadoDTO = comisionesDAO.retrieveComisiones(comisionesDTO)
					.get(0);

			ssesion.setAttribute("updateEmpleadoDTO", updateEmpleadoDTO);
			ssesion.setAttribute("isUpdating", true);
			ssesion.setAttribute("idComision", id);
			response.sendRedirect("Comisiones.jsp");
		}
		
		
		
		
		
		
		if (opc.equals("3")) {
			RegistroComisionesDTO comisionesDTO = new RegistroComisionesDTO();
			RegistroComisionesDAO comisionesDAO = new RegistroComisionesDAO();
			ssesion = request.getSession();
			int id = 0;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			comisionesDTO = new RegistroComisionesDTO();

			comisionesDTO.setIdComision(id);

			comisionesDAO.deleteComision(comisionesDTO);
			List<RegistroComisionesDTO> listEmpleado1DTO = new ArrayList<RegistroComisionesDTO>();
			listEmpleado1DTO = comisionesDAO.retrieveComisiones(comisionesDTO);
			ssesion.setAttribute("listaEmpleado", listEmpleado1DTO);
			response.sendRedirect("Comisiones.jsp");

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
