<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII" import="java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>File Extension</title>
</head>
<body>

	<%
		PrintWriter writer = response.getWriter();
		writer.print("<form action=\"http://localhost:8080/Assignment10/setA/que2/file_extension.jsp\">");
		writer.print("<input type=\"text\" name=\"ext\"> <input type=\"submit\" value=\"Get files\"> <br> </form>");

		String ext = request.getParameter("ext");
		if (ext != null) {
			File dir = (new File(request.getSession().getServletContext().getRealPath(request.getServletPath())))
					.getParentFile();

			String files[] = dir.list();
			for (String file : files) {
				if (file.endsWith(ext))
					out.print("<a href=\"" + file + "\">" + file + "</a>");
			}
		}
	%>
</body>
</html>