<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  href="${pageContext.request.contextPath}/resources/css/style.css" 
	   type="text/css"
	   rel="stylesheet" >
	   
<link  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" 
	   type="text/css"
	   rel="stylesheet" >
<title>Save Customer</title>
</head>
<body>
	<div id="wraper">
		<header id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</header>
		<br/>
		<main id="main">
			
			<h3>Save Customer</h3>
			
			
			<span><i>Fill out the form.(*) means required</i></span>
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
				<!--  need to associate this data with customer id-->
				<form:hidden path="id" />
				
				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						<tr>
							<td><label>Last name (*):</label></td>
							<td><form:input path="lastName"/></td>
							<td><form:errors path="lastName" cssClass="error"/></td>
						</tr>
						<tr>
							<td><label>Email (*):</label></td>
							<td><form:input path="email"/></td>
							<td><form:errors path="email" cssClass="error"/></td>
						</tr>
						
						<tr>
							<td><label>Free passes (*):</label></td>
							<td><form:input path="freePasses"/></td>
							<td><form:errors path="freePasses" cssClass="error"/></td>
						</tr>
							<tr>
							<td><label>Postal code (*):</label></td>
							<td><form:input path="postalCode"/></td>
							<td><form:errors path="postalCode" cssClass="error"/></td>
						</tr>		
						
						
						<tr>
							<td><label>Course code (*):</label></td>
							<td><form:input path="courseCode"/></td>
							<td><form:errors path="courseCode" cssClass="error"/></td>
						</tr>		
										
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
						
					</tbody>

				</table>
			</form:form>
			
		
		</main>
		<br/>
		<footer id="footer">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
			</p>
		</footer>
	</div>

</body>
</html>