<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  href="${pageContext.request.contextPath}/resources/css/style.css" 
	   type="text/css"
	   rel="stylesheet" >
	   
<link  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" 
	   type="text/css"
	   rel="stylesheet" >
<title>Insert title here</title>
</head>
<body>
	<div id="wraper">
		<header id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</header>
		<br/>
		<main id="main">
			
			<p>${customer.firstName}</p>
			<p>${customer.lastName}</p>
			
		
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