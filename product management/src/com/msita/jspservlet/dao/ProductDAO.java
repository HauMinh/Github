  package com.msita.jspservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.msita.jspservlet.bo.Product;
import com.msita.jspservlet.dbconnection.ConnectionFactory;



public class ProductDAO {
      //getproduct(int idproduct)
	public Product getProduct(int idproduct) {                       
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM product WHERE idproduct = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idproduct);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = ConverToProduct(resultSet);
				return product;
			}
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
	        if (resultSet != null) {
                try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (preparedStatement != null) {
            	try {
            		preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
		
		return null;
	}
	
	//khởi tạo mãng 
	public ArrayList<Product> getAllProduct(){                 
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM product";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				productList.add(ConverToProduct(resultSet));
			}
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
	        if (resultSet != null) {
                try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (statement != null) {
            	try {
            		statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
		
		return productList;
	}
	      // tìm kiếm theo tên 
	public ArrayList<Product> findProductByName(String name){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM product WHERE name = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				productList.add(ConverToProduct(resultSet));
			}
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
	        if (resultSet != null) {
                try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (preparedStatement != null) {
            	try {
            		preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
		
		return productList;
	}
	 // insert product
	public void insertProduct(Product product){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO product (producer,name,total,price) VALUES (?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();	
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getProducer());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getTotal());
			preparedStatement.setInt(4, product.getPrice());
			preparedStatement.executeUpdate();
	        
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
            if (preparedStatement != null) {
            	try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
	}
	    
	    //update product
	public void updateProduct(Product product) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE product SET producer = ?, name = ?, total = ?, price = ? WHERE idproduct = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, product.getProducer());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getTotal());
			preparedStatement.setInt(4, product.getPrice());
			preparedStatement.setInt(5, product.getIdproduct());
			preparedStatement.executeUpdate();
			
		   } catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
			if (preparedStatement != null) {
            	try {
            		preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }


            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
	}
	public void updateAmountProduct(int idProduct,int total) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE product SET total = ? WHERE idproduct = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setInt(1, total);
			preparedStatement.setInt(2, idProduct);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
			if (preparedStatement != null) {
            	try {
            		preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }


            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
	}
      //delete product
	public void deleteProduct(int productId) {
		Connection connection = null;
		Statement statement = null;
		try {
			String sql = "DELETE FROM product WHERE idproduct =" + productId;
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} finally {
			//finally block used to close resources
            if (statement != null) {
            	try {
            		statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }

            if (connection != null) {
            	try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
		}
	}
	private Product ConverToProduct(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setIdproduct(rs.getInt(1));
		product.setProducer(rs.getString(2));
		product.setName(rs.getString(3));
		product.setTotal(rs.getInt(4));
		product.setPrice(rs.getInt(5));
	
		return product;
	}
}
	