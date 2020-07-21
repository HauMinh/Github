package com.msita.jspservlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msita.jspservlet.bo.Product;
import com.msita.jspservlet.dao.ProductDAO;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet("/createProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/createproduct.jsp");
        dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String producer = (String) request.getParameter("producer");
	     String name = (String) request.getParameter("name");
	     String totalStr = (String) request.getParameter("total");
	     int total = Integer.parseInt(totalStr);
	     String priceStr = (String) request.getParameter("price");
	     int price = Integer.parseInt(priceStr);
	     
	     Product newProduct = new Product();
	     newProduct.setProducer(producer);
	     newProduct.setName(name);
	     newProduct.setTotal(total);
	     newProduct.setPrice(price);
	     ProductDAO productDAO = new ProductDAO();
	     productDAO.insertProduct(newProduct);
	     
	     response.sendRedirect(request.getContextPath() + "/productList");
	}

}



