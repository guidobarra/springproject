<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	Welcome to the luv2code company home page!

	<hr>
		<!-- Display user name and role-->
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Role(s): <security:authentication property="principal.authorities" />
		</p>
	<hr>

	<!-- Add a logout button-->
	<form:form action="${pageContext.request.contextPath}/logout"
				mathod="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>

</html>