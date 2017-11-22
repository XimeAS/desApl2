package xas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xas.dao.FacturaDAO;
import xas.dao.FacturaDAOImpl;
import xas.model.Factura;


/**
 * Servlet implementation class FacturaController
 */
@WebServlet("/FacturaController")
public class FacturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Factura factura; 
	private List<Factura> facturas;
	private FacturaDAO facturaDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaController() {
        super();
        factura = new Factura();
        facturas = new ArrayList<Factura>();
        facturaDAO = new FacturaDAOImpl();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_save")!=null) {
			factura.setProveedor(request.getParameter("proveedor"));
			factura.setFecha(request.getParameter("fecha"));
    		factura.setImporte(Float.parseFloat(request.getParameter("importe")));
    		factura.setEmpleado(request.getParameter("empleado"));
    		if(factura.getId()==0L) {
    		facturaDAO.createFactura(factura);
    			
    		}else {
    			facturaDAO.updateFactura(factura);
    			
    		}
    			facturas = facturaDAO.readAllFacturas();
    			request.setAttribute("facturas", facturas);
    			request.getRequestDispatcher("factura_list.jsp").forward(request, response);
    			
    	}else if(request.getParameter("btn_new")!=null) {
    		factura = new Factura();
    		request.getRequestDispatcher("factura_form.jsp").forward(request, response);
       	}else if(request.getParameter("btn_edit")!=null) {
       		try {
       			Long id= Long.parseLong(request.getParameter("id"));
       			factura = facturaDAO.readFactura(id);
       		}catch(IndexOutOfBoundsException e) {
       			factura = new Factura();
       		}
       		request.setAttribute("factura",factura);
       		request.getRequestDispatcher("factura_form.jsp").forward(request, response);
      	}else if(request.getParameter("btn_delete")!=null) {
      		try {
      			Long id= Long.parseLong(request.getParameter("id"));
      			facturaDAO.deleteFactura(id);
      			facturas= facturaDAO.readAllFacturas();
      		}catch(Exception e){
      			e.printStackTrace();
      	}
      		request.setAttribute("facturas", facturas);
      		request.getRequestDispatcher("factura_list.jsp").forward(request, response);
      	}else {
      		facturas = facturaDAO.readAllFacturas();
      		request.setAttribute("facturas", facturas);
      		request.getRequestDispatcher("factura_list.jsp").forward(request, response);
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
