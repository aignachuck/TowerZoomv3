<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
<title>TowerZoom</title>

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
		<h2>PAM - Project (Asset) Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Project</h3>
		
		<form:form action="saveProject" modelAttribute="project" method="POST">
			
			<!-- need to associate data with customer id -->
			
			<form:hidden path="projectNumber"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Project Type:</label></td>
						<td><form:input path="projectType"/></td>
					</tr>
					
					<tr>
						<td><label>Carrier Name:</label></td>
						<td><form:input path="carrierName"/></td>
					</tr>
					
					<tr>
						<td><label>Contact Company:</label></td>
						<td><form:input path="contactCompany"/></td>
					</tr>
					<tr>
						<td><label>Contact First Name:</label></td>
						<td><form:input path="contactFirstName"/></td>
					</tr>
					
					<tr>
						<td><label>Contact Last Name:</label></td>
						<td><form:input path="contactLastName"/></td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="contactEmail"/></td>
					</tr>
					
					<tr>
						<td><label>Tower Reference:</label></td>
						<td><form:input path="tower.towerId"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				
				</tbody>
			
			</table>
		</form:form>
		
	<div style="clear;both;"></div>
	
		<p>
			<a href="${pageContext.request.contextPath}/main/projectsList">Back to List</a>
		
		</p>
	</div>

</body>


</html>
