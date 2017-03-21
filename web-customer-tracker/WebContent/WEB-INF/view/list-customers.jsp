<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  reference our style sheet -->
<link  href="${pageContext.request.contextPath}/resources/css/style.css" 
	   type="text/css"
	   rel="stylesheet" >
<script src="${pageContext.request.contextPath}/resources/js/script.js" type="application/javascript"></script>
<title>List Customers</title>
</head>
<body>
	<div id="wraper">
		<header id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</header>
		<br>
		<main id="main">
			
			<!-- put new button : Add Customer -->
			
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
			/>
			
			<!-- add our html table here -->
			<table>
				<tr>
					<th>First Name
					</th>
					<th>Last Name
					</th>
					<th>Email 
					</th>
					<th>Action
					</th>
				</tr>
				
				<!--  loop over and print  out the information -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<!-- construct an update link -->	
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					
					<!--  construct an delete link -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<tr>
						<td>
							${tempCustomer.firstName}
						</td>
						<td>
							${tempCustomer.lastName}
						</td>
						<td>
							${tempCustomer.email}
						</td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							<!-- display the delete link -->
							<a href="${deleteLink}" onclick="areYouSure()">Delete</a>
						</td>
							
					</tr>
				</c:forEach>
			</table>
			
		</main>
		<br>
		<footer id="footer">
		</footer>
	</div>

</body>
</html>