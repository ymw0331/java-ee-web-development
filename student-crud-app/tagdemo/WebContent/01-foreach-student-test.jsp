<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.*, com.wayneyong.jsp.tagdemo.Student"%>

<%
//just create some sample data

List<Student> data = new ArrayList<>();

data.add(new Student("John", "Doe", false));
data.add(new Student("Maxwell", "Johnson", false));
data.add(new Student("Mary", "Public", true));

pageContext.setAttribute("myStudents", data);
%>

<html>

<body>

	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gold Customer</th>
		</tr>

		<c:forEach var="tempStudent" items="${myStudents}">
			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td>${tempStudent.goldCustomer}</td>
			</tr>

		</c:forEach>


	</table>

	<%-- 	<c:forEach var="tempStudent" items="${myStudents}">
	
	${tempStudent.firstName} ${tempStudent.lastName}, ${tempStudent.goldCustomer}
	<br />


	</c:forEach> --%>

</body>

</html>