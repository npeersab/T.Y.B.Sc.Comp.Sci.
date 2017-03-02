package setB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hobby")
public class Hobby extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookies[] = req.getCookies();
		if (cookies != null)
			displayHobby(resp, cookies[0]);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hobby = req.getParameter("hobby");
		Cookie cookie = new Cookie("hobby", hobby);
		resp.addCookie(cookie);
		displayHobby(resp, cookie);
	}

	private static void displayHobby(HttpServletResponse response, Cookie cookie) throws IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> Hobby </title> </head>");
		writer.println("<body>");
		writer.println("<h3> Your Hobby is " + cookie.getValue() + "</h3> </body> </html>");
	}
}
