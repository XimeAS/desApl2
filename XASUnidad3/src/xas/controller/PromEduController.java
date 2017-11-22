package xas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xas.dao.PromEduDAO;
import xas.dao.PromEduDAOImpl;
import xas.model.PromEdu;


/**
 * Servlet implementation class PromEduController
 */
@WebServlet("/PromEduController")
public class PromEduController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PromEdu programa; 
	private List<PromEdu> programas;
	private PromEduDAO promEduDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromEduController() {
        super();
        programa = new PromEdu();
        programas = new ArrayList<PromEdu>();
        promEduDAO = new PromEduDAOImpl();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_save")!=null) {
			programa.setNumeroalumnos(Integer.parseInt(request.getParameter("numeroalumnos")));
			programa.setCarrera(request.getParameter("carrera"));
    		programa.setEdificio(request.getParameter("edificio"));
    		if(programa.getId()==0L) {
    		promEduDAO.createPrograma(programa);
    			
    		}else {
    			promEduDAO.updatePrograma(programa);
    			
    		}
    			programas = promEduDAO.readAllProgramas();
    			request.setAttribute("programas", programas);
    			request.getRequestDispatcher("promEdu_list.jsp").forward(request, response);
    			
    	}else if(request.getParameter("btn_new")!=null) {
    		programa = new PromEdu();
    		request.getRequestDispatcher("promEdu_form.jsp").forward(request, response);
       	}else if(request.getParameter("btn_edit")!=null) {
       		try {
       			Long id= Long.parseLong(request.getParameter("id"));
       			programa = promEduDAO.readPrograma(id);
       		}catch(IndexOutOfBoundsException e) {
       			programa = new PromEdu();
       		}
       		request.setAttribute("programa",programa);
       		request.getRequestDispatcher("promEdu_form.jsp").forward(request, response);
      	}else if(request.getParameter("btn_delete")!=null) {
      		try {
      			Long id= Long.parseLong(request.getParameter("id"));
      			promEduDAO.deletePrograma(id);
      			programas= promEduDAO.readAllProgramas();
      		}catch(Exception e){
      			e.printStackTrace();
      	}
      		request.setAttribute("programas", programas);
      		request.getRequestDispatcher("promEdu_list.jsp").forward(request, response);
      	}else {
      		programas = promEduDAO.readAllProgramas();
      		request.setAttribute("programas", programas);
      		request.getRequestDispatcher("promEdu_list.jsp").forward(request, response);
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
