package com.msita.jspservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;

import com.msita.jspservlet.bo.History;
import com.msita.jspservlet.dbconnection.ConnectionFactory;

public class HistoryDAO {

	private String date;
	public History getHistory (int idhistory) {                       
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM history WHERE idhistory = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idhistory);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				History history = ConverToProduct(resultSet);
				return history;
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
	public ArrayList<History > getAllHistory(){                 
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<History > historyList = new ArrayList<History>();
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM history";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				historyList.add(ConverToProduct(resultSet));
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
		
		return historyList;
	}
	      // tìm kiếm theo tên 
	public ArrayList<History> findHistoryByDate(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<History> historyList = new ArrayList<History>();
		
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM history WHERE date = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, date);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				historyList.add(ConverToProduct(resultSet));
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
		return historyList;
	}
	 // insert product
	public void insertHistory(History history){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO history (idproduct,iduser,total) VALUES (?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();	
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, history.getIdproduct());
			preparedStatement.setInt(2, history.getIduser());
			preparedStatement.setInt(3, history.getTotal());
			//java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			//preparedStatement.setTimestamp(4, date);
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
	    
	
	public void deleteHistory(int historyId) {
		Connection connection = null;
		Statement statement = null;
		try {
			String sql = "DELETE FROM history WHERE idhistory =" +historyId;
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
	private History ConverToProduct(ResultSet rs) throws SQLException {
		History history = new History();
        history.setIdhistory(rs.getInt(1));
		history.setIduser(rs.getInt(2));
		history.setIdproduct(rs.getInt(3));
		history.setTotal(rs.getInt(4));
		history.setDate(rs.getDate(5));;
	
		return history;
	}
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
}
