<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII" import="java.util.Date" import="javax.servlet.http.Cookie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Using Implicit Object</title>
</head>
<body>
<%
	out.print("Current date and time: " + new Date() + "<br>");
	Enumeration<String> enumeration = request.getHeaderNames();
	while (enumeration.hasMoreElements()) {
		String name = enumeration.nextElement();
		out.print(name + ": " + request.getHeader(name) + "<br>");
	}

	response.addCookie(new Cookie("cookie1", "value1"));
	out.print("Cookie Added !!! <br>");
	out.print("User session id: " + session.getId() + "<br>");
	out.print("Generated Servlet Name: " + page);
%>
</body>
</html>