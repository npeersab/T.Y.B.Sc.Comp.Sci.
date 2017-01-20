package setB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShoppingPage2")
public class ShoppingPage2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		writer.println("<html> <head>");
		writer.println("<title> Vegetables </title> </head>");
		writer.println("<body>");
		writer.println("<h1> Select Items </h1>");
		writer.println("<form action=\"\\Assignment9\\ShoppingBill\" method=\"get\">");
		writer.println("<input type=\"checkbox\" name=\"veg\" value=\"40\"> Cabbage (Rs. 40) <br>");
		writer.println("<input type=\"checkbox\" name=\"veg\" value=\"50\"> Onion (Rs. 50) <br>");
		writer.println("<input type=\"checkbox\" name=\"veg\" value=\"70\"> Peas (Rs. 70) <br> <br>");
		writer.println("<input type=\"submit\" value=\"Get Bill\">");
		writer.println("</form> </body> </html>");

		String values[] = req.getParameterValues("fruit");

		int total = 0;
		if (values != null)
			for (String value : values)
				total += Integer.valueOf(value);

		HttpSession session = req.getSession();
		session.setAttribute("page1", String.valueOf(total));
	}
}