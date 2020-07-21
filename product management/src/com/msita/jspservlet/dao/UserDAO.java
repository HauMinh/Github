package com.msita.jspservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.msita.jspservlet.bo.History;
import com.msita.jspservlet.bo.User;
import com.msita.jspservlet.dbconnection.ConnectionFactory;

public class UserDAO {
	
	

		
		public User getUser (int iduser) {                       
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				connection = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM user WHERE iduser = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, iduser);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					User user = convertToUser(resultSet);
					return user;
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
		public ArrayList<User> getAllUser(){                 
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			ArrayList<User > 	userList = new ArrayList<User>();
			
			try {
				connection = ConnectionFactory.getConnection();
				String sql = "SELECT * FROM history";
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
				 userList.add(convertToUser(resultSet));
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
			
			return userList;
		}
		    
	
	
	

	private static User convertToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setIduser(rs.getInt(1));		
		user.setUsername(rs.getString(2));		
		user.setPassword(rs.getString(3));		
		user.setRole(rs.getString(4));	
		return user;
	}
	
	
	public void insertUser(User user){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO user (name,password,role) VALUES (?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();	
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3,user.getRole());
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
	
	public void updateUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			String updateSql = "UPDATE user SET username = ?, password = ?, role = ? WHERE iduser = ?";
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole());
			preparedStatement.setInt(4, user.getIduser());
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
	
	public void deleteUser(int idproduct) {
		Connection connection = null;
		Statement statement = null;
		try {
			String sql = "DELETE FROM product WHERE idproduct =" + idproduct ;
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
	
	public User findUserByUsernameAndPassword(String username, String password){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = convertToUser(resultSet);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	}
