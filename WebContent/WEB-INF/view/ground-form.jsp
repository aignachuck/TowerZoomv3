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
		<h2>PGM - Project Ground Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Ground</h3>
		
		<form:form action="saveGround" modelAttribute="ground" method="POST">
			
			<!-- need to associate data with customer id -->
			
			<form:hidden path="groundId"/>
			
		
			<table>
				<tbody>
						
					<tr>
						<td><label>Ground Primary:</label></td>
						<td><form:input path="groundPrimary"/></td>
					</tr>
					
					<tr>
						<td><label>Ground Space Type:</label></td>
						<td><form:input path="groundSpaceType"/></td>
					</tr>
					
					<tr>
						<td><label>Ground Space Length (ft.):</label></td>
						<td><form:input path="groundSpaceLength"/></td>
					</tr>
					<tr>
						<td><label>Ground Space Width (ft.):</label></td>
						<td><form:input path="groundSpaceWidth"/></td>
					</tr>
					
					<tr>
						<td><label>Ground Space Area (sq. ft.):</label></td>
						<td><form:input path="groundArea"/></td>
					</tr>
									
					<tr>
						<td><label>Project Reference:</label></td>
						<td><form:input path="groundProject.projectNumber"/></td>
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
			<a href="${pageContext.request.contextPath}/main/groundList">Back to List</a>
		
		</p>
	</div>

</body>


</html>
