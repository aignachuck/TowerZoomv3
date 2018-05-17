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
		<h2>PCM - Project Cables Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Cables</h3>
		
		<form:form action="saveCables" modelAttribute="cables" method="POST">
			
			<!-- need to associate data with customer id -->
			
			<form:hidden path="cableId"/>
			
		
			<table>
				<tbody>
						
					<tr>
						<td><label>Cable Type:</label></td>
						<td><form:input path="cableType"/></td>
					</tr>
					
					<tr>
						<td><label>Cable Quantity:</label></td>
						<td><form:input path="cableQuantity"/></td>
					</tr>
					
					<tr>
						<td><label>Cable Diameter (in.):</label></td>
						<td><form:input path="cableDiameter"/></td>
					</tr>
					<tr>
						<td><label>Cables Per Sector:</label></td>
						<td><form:input path="cablePerSector"/></td>
					</tr>
					
					<tr>
						<td><label>Cable Configuration:</label></td>
						<td><form:input path="cableConfiguration"/></td>
					</tr>
					
					
					<tr>
						<td><label>Project Reference:</label></td>
						<td><form:input path="cablesProject.projectNumber"/></td>
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
			<a href="${pageContext.request.contextPath}/main/cablesList">Back to List</a>
		
		</p>
	</div>

</body>


</html>
