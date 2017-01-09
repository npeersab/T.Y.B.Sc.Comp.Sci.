package setA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		writer.println("Client IP address: " + req.getRemoteAddr());
		writer.println("<br>Server IP address: " + req.getLocalAddr());
		writer.println("<br>Port number: " + req.getLocalPort());
		writer.println("<br>Request method: " + req.getMethod());
		writer.println("<br>Protocol: " + req.getProtocol());
		writer.println("<br>Servlet Path: " + req.getServletPath());
	}
}
