<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<head>
	<title>gubacode Company Home Page</title>
</head>

<body>
	<h2>gubacode Company Home Page</h2>
	<hr>
	
	Welcome to the gubacode company home page!

	<hr>
		<!-- Display user name and role-->
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Role(s): <security:authentication property="principal.authorities" />
		</p>

		<security:authorize access="hasRole('MANAGER')">
			<hr>
			<p>
				<!-- Add a link to point to /leaders ... this is for the managers -->
				<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
				(Only for Manager peeps)
			</p>
			<hr>
		</security:authorize>



		<security:authorize access="hasRole('ADMIN')">
			<hr>
			<p>
				<!-- Add a link to point to /systems ... this is for the Admins -->
				<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
				(Only for Admin peeps)
			</p>
			<hr>
		</security:authorize>


	<!-- Add a logout button-->
	<form:form action="${pageContext.request.contextPath}/logout"
				mathod="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>

</html>