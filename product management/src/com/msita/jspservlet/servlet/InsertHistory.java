package com.msita.jspservlet.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msita.jspservlet.bo.History;
import com.msita.jspservlet.bo.Product;
import com.msita.jspservlet.dao.HistoryDAO;
import com.msita.jspservlet.dao.ProductDAO;

/**
 * Servlet implementation class InsertHistory
 */
@WebServlet("/insertHistory")
public class InsertHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idproductstr = (String) request.getParameter("idproduct");
		int idproduct = Integer.parseInt(idproductstr);
		
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProduct(idproduct);
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/sellproduct.jsp");
        dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     String idproductStr = (String) request.getParameter("idproduct");
	     int idproduct = Integer.parseInt(idproductStr);
	     int iduser = 1;  
	     String totalStr = (String) request.getParameter("total");
	     int total = Integer.parseInt(totalStr);
	     String amountStr = (String) request.getParameter("amount");
	     int amount = Integer.parseInt(amountStr);
	     @SuppressWarnings("unused")
		String dateStr = (String) request.getParameter("date");
	     
	     History newHistory = new History();
	     newHistory.setIdproduct(idproduct);
	     newHistory.setIduser(iduser);
	     newHistory.setTotal(amount);
	     ProductDAO productDAO = new ProductDAO();
	     productDAO.updateAmountProduct(idproduct,total - amount);
	     HistoryDAO historyDAO = new HistoryDAO();
	     historyDAO.insertHistory(newHistory);
	     
	     response.sendRedirect(request.getContextPath() + "/historyList");
	}

}
