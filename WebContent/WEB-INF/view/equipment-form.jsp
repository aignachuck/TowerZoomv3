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
		<h2>PEM - Project Equipment Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Equipment</h3>
		
		<form:form action="saveEquipment" modelAttribute="equipment" method="POST">
			
			<!-- need to associate data with customer id -->
			
			<form:hidden path="equipmentId"/>
			
		
			<table>
				<tbody>
						
					<tr>
						<td><label>Equipment Type:</label></td>
						<td><form:input path="equipmentType"/></td>
					</tr>
					
					<tr>
						<td><label>Equipment Quantity:</label></td>
						<td><form:input path="equipmentQuantity"/></td>
					</tr>
					
					<tr>
						<td><label>Equipment Manufacturer:</label></td>
						<td><form:input path="equipmentManufacturer"/></td>
					</tr>
					<tr>
						<td><label>Equipment Model:</label></td>
						<td><form:input path="equipmentModel"/></td>
					</tr>
					
					<tr>
						<td><label>Equipment Height:</label></td>
						<td><form:input path="equipmentHeight"/></td>
					</tr>
					
					<tr>
						<td><label>Equipment Width:</label></td>
						<td><form:input path="equipmentWidth"/></td>
					</tr>
					
					<tr>
						<td><label>Equipment Depth:</label></td>
						<td><form:input path="equipmentDepth"/></td>
					</tr>
					
					<tr>
						<td><label>Equipment Weight:</label></td>
						<td><form:input path="equipmentWeight"/></td>
					</tr>
					
					<tr>
						<td><label>Equipment RAD:</label></td>
						<td><form:input path="equipmentRad"/></td>
					</tr>
					
					<tr>
						<td><label>Mount Type:</label></td>
						<td><form:input path="mountType"/></td>
					</tr>
					
					<tr>
						<td><label>Azimuths:</label></td>
						<td><form:input path="azimuths"/></td>
					</tr>
					
					<tr>
						<td><label>Count Per Azimuth:</label></td>
						<td><form:input path="countPerAzimuth"/></td>
					</tr>
					
					<tr>
						<td><label>Tx Frequency:</label></td>
						<td><form:input path="txFrequency"/></td>
					</tr>
					
					<tr>
						<td><label>Rx Frequency:</label></td>
						<td><form:input path="rxFrequency"/></td>
					</tr>
					
					<tr>
						<td><label>Project Reference:</label></td>
						<td><form:input path="equipmentProject.projectNumber"/></td>
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
			<a href="${pageContext.request.contextPath}/main/equipmentList">Back to List</a>
		
		</p>
	</div>

</body>


</html>
