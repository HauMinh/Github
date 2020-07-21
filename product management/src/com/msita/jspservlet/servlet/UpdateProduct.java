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
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateproduct.jsp");
        dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idproductstr = (String) request.getParameter("idproduct");
		int idproduct = Integer.parseInt(idproductstr);
		String producer = (String) request.getParameter("producer");
	    String name = (String) request.getParameter("name");
	    String totalStr = (String) request.getParameter("total");
	    int total = Integer.parseInt(totalStr);
	    String priceStr = (String) request.getParameter("price");
	    int price = Integer.parseInt(priceStr);
	     
	    Product product = new Product();
	    product.setIdproduct(idproduct);
	    product.setProducer(producer);
	    product.setName(name);
	    product.setTotal(total);
	    product.setPrice(price);
	     
	    ProductDAO productDAO = new ProductDAO();
	    productDAO.updateProduct(product);
	     
	    response.sendRedirect(request.getContextPath() + "/productList");
	}

}
