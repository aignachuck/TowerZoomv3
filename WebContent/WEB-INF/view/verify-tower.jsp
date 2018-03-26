<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
<title>Star Towers VPM</title>

<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css">
	  
<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2>Confirm Tower</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Please enter a valid Tower number:</h3>
		
		<form:form action="confirmTower" modelAttribute="number" method="POST">
			
			<!-- need to associate data with customer id -->
			
<%-- 			<form:hidden path="projectNumber"/> --%>
		
			<table>
				<tbody>
					<tr>
						<td><label>Tower Number:</label></td>
						<td><form:input path="towerNumber"/></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Confirm" class="save"/></td>
					</tr>
					
					
				
				</tbody>
			
			</table>
		</form:form>
		
	<div style="clear;both;"></div>
	
		<p>
			<a href="${pageContext.request.contextPath}/main/startPage">Return to Start</a>
		
		</p>
	</div>

</body>


</html>
