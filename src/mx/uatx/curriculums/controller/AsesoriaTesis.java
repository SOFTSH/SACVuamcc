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

import mx.uatx.curriculums.dao.AsesoriaTesisDAO;
import mx.uatx.curriculums.dto.AsesoriaTesisDTO;

/**
 * Servlet implementation class AsesoriaTesis
 */
@WebServlet("/AsesoriaTesis")
public class AsesoriaTesis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsesoriaTesis() {
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
			AsesoriaTesisDTO empleadoDTO = new AsesoriaTesisDTO();
			AsesoriaTesisDAO empleadoDAO = new AsesoriaTesisDAO();

			
				
			String Proyecto = "";
			String Nivel= "";
			String FechaTitulacion = "";
			String Alumno = "";
			String Constancia = "";
		
			Proyecto = request.getParameter("Proyecto") != null ? request
					.getParameter("Proyecto").toString() : "";
					
					 
					Nivel = request.getParameter("Nivel") != null ? request
							.getParameter("Nivel").toString() : "";
							
			FechaTitulacion = request.getParameter("FechaTitulacion") != null ? request
					.getParameter("FechaTitulacion").toString() : "";
					
			Alumno = request.getParameter("Alumno") != null ? request.getParameter(
					"Alumno").toString() : "";
			
			Constancia = request.getParameter("Constancia") != null ? request
					.getParameter("Constancia").toString() : "";
				
					
									empleadoDTO = new AsesoriaTesisDTO();
									
									empleadoDTO.setProyecto(Proyecto);
									empleadoDTO .setNivel(Nivel);
									empleadoDTO .setFechaTitulacion(FechaTitulacion);
									empleadoDTO .setAlumno(Alumno);
									empleadoDTO .setConstancia(Constancia);
						
								
		
			System.out.println("ROL en servlet" + empleadoDTO.getIdAsesoria());			
			
			empleadoDAO.createAsesoria(empleadoDTO);
			List<AsesoriaTesisDTO> listEmpleadoDTO = new ArrayList<AsesoriaTesisDTO>();
			listEmpleadoDTO = empleadoDAO.retrieveAsesoria(new  AsesoriaTesisDTO());
					ssesion.setAttribute("listaEmpleado", listEmpleadoDTO);
			response.sendRedirect("AsesoriaTesis.jsp");
				}
		
		
		if (opc.equals("1") && isUpdating == true) {
			AsesoriaTesisDTO empleadoDTO = new AsesoriaTesisDTO();
			AsesoriaTesisDAO empleadoDAO = new AsesoriaTesisDAO();

			String Proyecto = "";
			String Nivel= "";
			String FechaTitulacion = "";
			String Alumno = "";
			String Constancia = "";

		
		
			Proyecto = request.getParameter("Proyecto") != null ? request
					.getParameter("Proyecto").toString() : "";
					
					Nivel = request.getParameter("Nivel") != null ? request
							.getParameter("Nivel").toString() : "";
							
			
					
			FechaTitulacion = request.getParameter("FechaTitulacion") != null ? request
					.getParameter("FechaTitulacion").toString() : "";
					
			Alumno = request.getParameter("Alumno") != null ? request.getParameter(
					"Alumno").toString() : "";
			
		
			Constancia = request.getParameter("Constancia") != null ? request
							.getParameter("Constancia").toString() : "";
 

		
									empleadoDTO = new AsesoriaTesisDTO();
									
									empleadoDTO .setProyecto(Proyecto);
									empleadoDTO .setNivel(Nivel);
									empleadoDTO .setFechaTitulacion(FechaTitulacion);
									empleadoDTO .setAlumno(Alumno);
									empleadoDTO .setConstancia(Constancia);
						          
								
	
			empleadoDTO.setIdAsesoria((Integer) request.getSession()
					.getAttribute("idAsesoria"));

			empleadoDAO.updateAsesoria(empleadoDTO);
			List<AsesoriaTesisDTO> listEmpleadoDTO = new ArrayList<AsesoriaTesisDTO>();
			listEmpleadoDTO = empleadoDAO.retrieveAsesoria(new AsesoriaTesisDTO());
			ssesion.setAttribute("listaEmpleado", listEmpleadoDTO);
			ssesion.setAttribute("isUpdating", false);
			ssesion.setAttribute("idAsesoria", 0);
			ssesion.setAttribute("updateAsesoriaDTO", null);
			response.sendRedirect("AsesoriaTesis.jsp");

		}
		
		if (opc.equals("2")) {

			AsesoriaTesisDTO empleadoDTO = null;
			AsesoriaTesisDAO empleadoDAO = new AsesoriaTesisDAO();
			AsesoriaTesisDTO updateEmpleadoDTO = null;
			// ssesion = request.getSession();
			int id;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			empleadoDTO = new AsesoriaTesisDTO();
			updateEmpleadoDTO = new AsesoriaTesisDTO();
			empleadoDTO.setIdAsesoria(id);
			updateEmpleadoDTO = empleadoDAO.retrieveAsesoria(empleadoDTO)
					.get(0);

			ssesion.setAttribute("updateEmpleadoDTO", updateEmpleadoDTO);
			ssesion.setAttribute("isUpdating", true);
			ssesion.setAttribute("idAsesoria", id);
			response.sendRedirect("AsesoriaTesis.jsp");
		}
		
		
		if (opc.equals("3")) {
			AsesoriaTesisDTO empleadoDTO = new AsesoriaTesisDTO();
			AsesoriaTesisDAO empleadoDAO = new AsesoriaTesisDAO();
			ssesion = request.getSession();
			int id = 0;
			id = request.getParameter("id") != null ? Integer.parseInt(request
					.getParameter("id")) : 0;
			
			empleadoDTO = new AsesoriaTesisDTO();

			empleadoDTO.setIdAsesoria(id);

			empleadoDAO.deleteAsesoria(empleadoDTO);
			List<AsesoriaTesisDTO> listEmpleado1DTO = new ArrayList<AsesoriaTesisDTO>();
			listEmpleado1DTO = empleadoDAO.retrieveAsesoria(empleadoDTO);
			ssesion.setAttribute("listaEmpleado", listEmpleado1DTO);
			response.sendRedirect("AsesoriaTesis.jsp");

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

