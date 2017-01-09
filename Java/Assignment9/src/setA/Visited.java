package setA;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Visited")
public class Visited extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie[] = req.getCookies();
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();		
		if (cookie == null) {
			Cookie cookie2 = new Cookie("Visited", "1");
			writer.println("<h1> Welcome </h1>");
			resp.addCookie(cookie2);
		}
		else {
			int visited = Integer.valueOf(cookie[0].getValue());
			writer.println("You have visited this page " + (++visited) + " times");
			cookie[0].setValue(String.valueOf(visited));
			resp.addCookie(cookie[0]);
		}
	}
}
