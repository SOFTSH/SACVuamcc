package com.uatx.sacv.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class Cursos
 * Servlet que permite al usuario Docente y secretaria registrar cursos a su curriculum
 * @autor Edi Guzman Cruz
 * @version 0.1
 */
@WebServlet("/Cursos")
@MultipartConfig
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * Metodo post que obtiene todos los valores de la vista Cursos.jsp
	 * registrandolos en la DB 'AdministracionCurriculum'
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String nomb = request.getParameter("hid");
			Part contConstancia = request.getPart("constancia");
			InputStream is = contConstancia.getInputStream();
			File f = new File("/Users/edi_guzman_cruz160810/Desktop/Constancias/"+nomb);
			//f.mkdir(); 
			FileOutputStream ous = new FileOutputStream(f);
			int dato = is.read();
			while(dato != -1){
				ous.write(dato);
				dato = is.read();
			}
			ous.close();
			is.close();
		}catch(Throwable theException){
			System.out.println("Exception is"+ theException);
		}
	}

}
