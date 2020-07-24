<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
 <title> Student Registration Form </title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
		
		Last name: <form:input path="lastName" />
		
		<br><br>
		
		Country
		<form:select path="country">
		
			<form:options items="${student.countryOptions}" />
			
		<!--
			<form:option value="Brazil" label="Brazil"/>
			<form:option value="France" label="France"/>
			<form:option value="Germany" label="Germany"/>
			<form:option value="Japon" label="Japon"/>
			<form:option value="Argentina" label="Argentina"/>
			<form:option value="Bolivia" label="Bolivia"/>
			<form:option value="India" label="India"/>
		-->
		</form:select>
		
		<br><br>
		
		Favorite Language  
		<br><br>
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		Go <form:radiobutton path="favoriteLanguage" value="Go" />
		Python <form:radiobutton path="favoriteLanguage" value="Python" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
		Javascript <form:radiobutton path="favoriteLanguage" value="Javascript" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		
		<br><br>
		
		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
		
		<br><br>
		<input type="submit" value="Submit" />
		
		
	</form:form>

</body>

</html>