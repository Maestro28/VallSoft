package com.maestro.DBManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	
	private final static String HOST = "jdbc:mysql://localhost:3306";
	 private final static String DB_NAME = "FastFoodShop";
	 private final static String USER = "root";
	 private final static String PASSWORD = "";
	 
	 private Scanner in;
	 
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String url = String.format("%s/%s?autoReconnect=true&useSSL=false", HOST, DB_NAME);

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, USER, PASSWORD);

			statement = connection.createStatement();

				//stmt.executeUpdate("INSERT INTO football (fio, goals, team) " + "VALUES ('Дрис Мертенс', 5, 'Наполи')");
				//stmt.executeUpdate("UPDATE football " + "SET fio = 'Роберт Левандовський'" + "WHERE id = 13;");
				/*stmt.executeUpdate("DELETE FROM football " + "WHERE id = 14;");
				 */
			
			Scanner in = new Scanner(System.in);
			BufferedReader bufIn = new BufferedReader(new InputStreamReader(System.in));
			
			int n;
		
			System.out.println("Action list : ");
			System.out.println("0 - close;");
			System.out.println("1 - check the table;");
			System.out.println("2 - insert;");
			System.out.println("3 - update;");
			System.out.println("4 - delete;");
			
			for(;;){
				
			
				System.out.println("Select action: ");
				
				n = in.nextInt();
				if(n==0)break;
				else if (n ==1){
					resultSet = statement.executeQuery("select * from product");
					
					ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
					
					for(int i=1; i<=resultSetMetadata.getColumnCount(); i++){
						System.out.print("" + resultSetMetadata.getColumnName(i) + " ");
					}
						
					System.out.println("");
						
					while (resultSet.next()) { 
						System.out.print("");
						System.out.print(resultSet.getString("id"));
						System.out.print(" ");
						System.out.print(resultSet.getString("name"));
						System.out.print(" ");
						System.out.print(resultSet.getString("price"));
						System.out.println("");
							
					}
				}else if (n==2){
					
					int id; 
					String name;  
					float prise; 
					
					System.out.println("enter id: "); 
					id = Integer.parseInt(bufIn.readLine());
					System.out.println("Enter product name: "); 
					name = bufIn.readLine();
					System.out.println("enter price: "); 
					prise = Float.parseFloat(bufIn.readLine());
					
					PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product (id, name, price) values(?, ?, ?)"); 
					preparedStatement.setInt(1, id); 
					preparedStatement.setString(2, name); 
					preparedStatement.setFloat(3, prise);
					preparedStatement.executeUpdate(); 			
				}else if (n==3){
					
					System.out.println("Enter id for update row:"); 
					int Id = Integer.parseInt(bufIn.readLine());

					int id ; 
					String name; 
					Float prise; 
					
					System.out.println("enter new  id:"); 
					id = Integer.parseInt(bufIn.readLine());
					System.out.println("enter new name:"); 
					name = bufIn.readLine();
					System.out.println("enter new price:"); 
					prise = Float.parseFloat(bufIn.readLine());
					
					PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Product SET id = ?, name = ?, price = ? WHERE id = ?"); 
					preparedStatement.setInt(1, id); 
					preparedStatement.setString(2, name); 
					preparedStatement.setFloat(3, prise);
					preparedStatement.setInt(4, Id); 
					preparedStatement.executeUpdate(); 
					
					
				}else if (n==4){
					System.out.println("Enter id for deleting table row:"); 
					int id = in.nextInt(); 

					PreparedStatement prepharedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?"); 
					prepharedStatement.setInt(1, id); 
					prepharedStatement.executeUpdate(); 
				}
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (connection != null) connection.close();
				if (statement != null) statement.close();
				if (resultSet != null) resultSet.close(); 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
	}
	

	
}
