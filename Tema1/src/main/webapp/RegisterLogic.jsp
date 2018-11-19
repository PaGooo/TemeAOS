<%@ page import="com.unitbv.lab1.controllers.RegisterController"%>
<%
	try {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		RegisterController.InsertNewPerson(name, email);
		out.println("Person inserted!");
	} catch (Exception e) {
		out.println("Something went wrong !! Please try again");
	}
%>
<a href="Register.jsp">Click here to insert another one!</a>