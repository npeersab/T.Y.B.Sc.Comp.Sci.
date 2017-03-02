package setB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShoppingBill")
public class ShoppingBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> Total </title> </head>");
		writer.println("<body>");

		HttpSession session = req.getSession();
		String total = (String) session.getAttribute("page1");

		writer.println("Page 1 total: " + total);

		String values[] = req.getParameterValues("veg");
		int page2Total = 0;

		if (values != null)
			for (String value : values)
				page2Total += Integer.valueOf(value);

		writer.println("<br>Page 2 total: " + page2Total);

		int grandTotal = Integer.valueOf(total) + page2Total;

		writer.println("<br>Grand Total: " + grandTotal);
		writer.println("</body> </html>");
	}
}
