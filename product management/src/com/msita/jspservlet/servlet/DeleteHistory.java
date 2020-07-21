package com.msita.jspservlet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msita.jspservlet.dao.HistoryDAO;
import com.msita.jspservlet.dao.ProductDAO;

/**
 * Servlet implementation class DeleteHistory
 */
@WebServlet("/deleteHistory")
public class DeleteHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idhistorystr = (String) request.getParameter("idhistory");
		int idhistory = Integer.parseInt(idhistorystr);
		HistoryDAO historyDAO = new HistoryDAO();
		historyDAO.deleteHistory(idhistory); 
		response.sendRedirect(request.getContextPath() + "/historyList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
