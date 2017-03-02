<%@page import="java.util.Date"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Enter name</title>
</head>
<body>
	<%
		PrintWriter writer = response.getWriter();
		writer.print("<form action=\"http://localhost:8080/Assignment10/setB/que1/greets.jsp\">");
		writer.print(
				"Enter your name: <input type=\"text\" name=\"name\"> <input type=\"submit\" value=\"Submit\"> <br> </form>");

		String name = request.getParameter("name");
		String greet = null;
		if (name != null) {
			int hours = (new Date()).getHours();
			if (hours < 12 && hours > 5)
				greet = "Good Morning";
			else if (hours < 17 && hours > 12)
				greet = "Good Afternoon";
			else if (hours < 20 && hours > 17)
				greet = "Good Evening";
			else if (hours < 5 || hours > 20)
				greet = "Good Night";

			out.print(greet + " " + name);
		}
	%>
</body>
</html>