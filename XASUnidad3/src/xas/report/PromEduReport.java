package xas.report;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xas.dao.PromEduDAO;
import xas.dao.PromEduDAOImpl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class ProgramasReport
 */
@WebServlet("/PromEduReport")
public class PromEduReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PromEduDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromEduReport() {
        super();
        dao= new PromEduDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reportPath = "C:\\Users\\OscarTadeo\\Desktop\\AplicacionesTacho\\XASUnidad3\\src\\xas\\report\\ProgramReport.jrxml";
		try {
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("imagen_1", this.getServletContext().getRealPath("/") + "/images/imagen_1.png");
			
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnection());
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (Exception e) {
			e.printStackTrace();
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
