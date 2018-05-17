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
		<h2>TAM - Tower Asset Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Tower</h3>
		
		<form:form action="saveTower" modelAttribute="tower" method="POST">
			
			<!-- need to associate data with tower id -->
			
			<form:hidden path="towerId"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Tower Number:</label></td>
						<td><form:input path="towerNumber"/></td>
					</tr>
					
					<tr>
						<td><label>Tower Name:</label></td>
						<td><form:input path="towerName"/></td>
					</tr>
					
					<tr>
						<td><label>Tower Portfolio:</label></td>
						<td><form:input path="towerPortfolio"/></td>
					</tr>
					
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city"/></td>
					</tr>
					
					<tr>
						<td><label>State:</label></td>
						<td><form:input path="state"/></td>
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
			<a href="${pageContext.request.contextPath}/main/towersList">Back to List</a>
		
		</p>
	</div>

</body>


</html>
