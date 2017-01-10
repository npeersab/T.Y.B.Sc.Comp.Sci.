package setA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement statement;

	@Override
	public void init() throws ServletException {
		try {
			// load drivers
			Class.forName("org.postgresql.Driver");
			
			// create connection
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost/student", "postgres", "noor!xyz");

			// create statement
			statement = connection.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.print("<html> <head>");
		writer.println("<title> Student Details </title> </head>");
		writer.println("<body>");
		
		try {
			// get roll no
			int rollNo = Integer.valueOf(req.getParameter("rollNo"));
			
			// execute query
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM student WHERE rollno = " + rollNo);
			
			// if data with given roll no is present in database
			if (resultSet.next()) {
				writer.println("<b> Student Details: </b> <br> <br>");
				writer.println("<table border = 1>");
				writer.println("<tr> <th> Roll No </th>");
				writer.println("<th> Name </th> </tr>");
				writer.println("<tr> <td> " + resultSet.getInt(1) + " </td>");
				writer.println("<td> " + resultSet.getString(2) + "</td> </tr> </table>");
			}
			else
				writer.println("Student with roll no " + rollNo + " not found");
		} catch (SQLException e) {
			writer.println("Database Error");
		} catch (NumberFormatException e) {
			writer.println("Invalid Input");
		}
		
		writer.println("</body> </html>");
	}
}