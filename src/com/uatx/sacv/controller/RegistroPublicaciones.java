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
import mx.uatx.curriculum.dao.RegistroPublicacionesDAO;
import mx.uatx.curriculum.dto.RegistroComisionesDTO;
import mx.uatx.curriculum.dto.RegistroPublicacionesDTO;

/**
 * Servlet implementation class RegistroPublicaciones
 */
@WebServlet("/RegistroPublicaciones")
public class RegistroPublicaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroPublicaciones() {
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
			RegistroPublicacionesDTO publicacionesDTO = new RegistroPublicacionesDTO();
			RegistroPublicacionesDAO publicacionesDAO = new RegistroPublicacionesDAO();

			String FechaI = "";
			String FechaF= "";
			String Nombre = "";
			String Institucion = "";
			String Constancia = "";
			String FechaActual= "";
	
			
		
			
			
			FechaI = request.getParameter("FechaI") != null ? request
					.getParameter("FechaI").toString() : "";
					
					
					FechaF = request.getParameter("FechaF") != null ? request
							.getParameter("FechaF").toString() : "";
				
					Nombre = request.getParameter("Nombre") != null ? request.getParameter(
									"Nombre").toString() : "";
							
							
			Institucion = request.getParameter("Institucion") != null ? request
					.getParameter("Institucion").toString() : "";
					
				
					Constancia = request.getParameter("Constancia") != null ? request
					.getParameter("Constancia").toString() : "";
					
	
									
									FechaActual = request.getParameter("FechaActual") != null ? request
											.getParameter("FechaActual").toString() : "";
					
											publicacionesDTO = new RegistroPublicacionesDTO();
									
											publicacionesDTO.setFechaI(FechaI);
											publicacionesDTO .setFechaF(FechaF);
											publicacionesDTO.setNombre(Nombre);
											publicacionesDTO .setInstitucion(Institucion);
										
											publicacionesDTO .setConstancia(Constancia);
										
											publicacionesDTO .setFechaActual(FechaActual);
									
					
		
		
			System.out.println("ROL en servlet" +publicacionesDTO.getIdPublicacion());
		
			
			publicacionesDAO.createPublicaciones(publicacionesDTO);
			List<RegistroPublicacionesDTO> listEmpleadoDTO = new ArrayList<RegistroPublicacionesDTO>();
			listEmpleadoDTO = publicacionesDAO.retrievePublicaciones(new  RegistroPublicacionesDTO());
					ssesion.setAttribute("listaEmpleado", listEmpleadoDTO);
			response.sendRedirect("Publicaciones.jsp");
		}
		
		
		if (opc.equals("1") && isUpdating == true) {
			RegistroPublicacionesDTO publicacionesDTO = new RegistroPublicacionesDTO();
			RegistroPublicacionesDAO publicacionesDAO = new RegistroPublicacionesDAO();



			String FechaI = "";
			String FechaF= "";
			String Nombre = "";
			String Institucion = "";
			String Constancia = "";
			String FechaActual= "";
	
			
		
			
			
			FechaI = request.getParameter("FechaI") != null ? request
					.getParameter("FechaI").toString() : "";
					
					
					FechaF = request.getParameter("FechaF") != null ? request
							.getParameter("FechaF").toString() : "";
				
					Nombre = request.getParameter("Nombre") != null ? request.getParameter(
									"Nombre").toString() : "";
							
							
			Institucion = request.getParameter("Institucion") != null ? request
					.getParameter("Institucion").toString() : "";
					
				
					Constancia = request.getParameter("Constancia") != null ? request
					.getParameter("Constancia").toString() : "";
					
	
				FechaActual = request.getParameter("FechaActual") != null ? request
											.getParameter("FechaActual").toString() : "";
					
											publicacionesDTO = new RegistroPublicacionesDTO();
									
											publicacionesDTO.setFechaI(FechaI);
											publicacionesDTO .setFechaF(FechaF);
											publicacionesDTO.setNombre(Nombre);
											publicacionesDTO .setInstitucion(Institucion);
										
											publicacionesDTO .setConstancia(Constancia);
										
	
											publicacionesDTO.setIdPublicacion((Integer) request.getSession().getAttribute("IdPublicacion"));

											publicacionesDAO.updatePublicaciones(publicacionesDTO);
									
			List<RegistroPublicacionesDTO> listEmpleadoDTO = new ArrayList<RegistroPublicacionesDTO>();
			listEmpleadoDTO = publicacionesDAO.retrievePublicaciones(new RegistroPublicacionesDTO());
			ssesion.setAttribute("listaEmpleado", listEmpleadoDTO);
			ssesion.setAttribute("isUpdating", false);
			ssesion.setAttribute("IdPublicacion", 0);
			ssesion.setAttribute("updatePublicacionesDTO", null);
			response.sendRedirect("Publicaciones.jsp");

		}
	
		
		
		
		
		if (opc.equals("2")) {

			RegistroPublicacionesDTO publicacionesDTO = null;
			RegistroPublicacionesDAO publicacionesDAO = new RegistroPublicacionesDAO();
			RegistroPublicacionesDTO updateEmpleadoDTO = null;
			// ssesion = request.getSession();
			int id;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			publicacionesDTO= new RegistroPublicacionesDTO();
			updateEmpleadoDTO = new RegistroPublicacionesDTO();
			publicacionesDTO.setIdPublicacion(id);
			updateEmpleadoDTO = publicacionesDAO.retrievePublicaciones(publicacionesDTO)
					.get(0);

			ssesion.setAttribute("updateEmpleadoDTO", updateEmpleadoDTO);
			ssesion.setAttribute("isUpdating", true);
			ssesion.setAttribute("IdPublicacion", id);
			response.sendRedirect("Publicaciones.jsp");
		}
		
		

		if (opc.equals("3")) {
			RegistroPublicacionesDTO publicacionesDTO = new RegistroPublicacionesDTO();
			RegistroPublicacionesDAO publicacionesDAO = new RegistroPublicacionesDAO();
			ssesion = request.getSession();
			int id = 0;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			publicacionesDTO = new RegistroPublicacionesDTO();

			publicacionesDTO.setIdPublicacion(id);

			publicacionesDAO.deletePublicaciones(publicacionesDTO);
			List<RegistroPublicacionesDTO> listEmpleado1DTO = new ArrayList<RegistroPublicacionesDTO>();
			listEmpleado1DTO = publicacionesDAO.retrievePublicaciones(publicacionesDTO);
			ssesion.setAttribute("listaEmpleado", listEmpleado1DTO);
			response.sendRedirect("Publicaciones.jsp");

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
