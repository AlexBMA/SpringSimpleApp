package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDbServlet() {
       
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// setup connection variables
		String user="springstudent";
		String password="springstudent";
		String dbName ="web_customer_tracker";
		String jdbcUrl="jdbc:mysql://localhost:3306/"+dbName+"?userSSL=false";
		String driver ="com.mysql.jdbc.Driver";
		
		//get a connection to database
		
		try {
			PrintWriter out = response.getWriter();
		
			out.println("Connnecting to database:" +jdbcUrl);
			
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(jdbcUrl, user, password);

			out.println("connection succes!!!");
			
			conn.close();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
