<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>TowerZoom</title>

	<!-- reference the stylesheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>PCM - Project Cables Manager</h2>
		</div>	
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- add button for customer add -->
			<input type="button" value="Add Cables"
				   onclick="window.location.href='addCablesForm'; return false;"
				   class="add-button"/>	
				   
			<input type="button" value="Return to Start"
				   onclick="window.location.href='startPage'; return false;"
				   class="add-button"/>	   	
			
			<!-- Build HTML content table here -->
			
			<table>
				<tr>
					<th>Cable ID</th>
					<th>Cable Type</th>
					<th>Cable Quantity</th>		
					<th>Cable Diameter</th>
					<th>Cables Per Sector</th>
					<th>Cable Configuration</th>	
					<th>Project Reference</th>	
				</tr>
				
				<!-- Loop over and print the customers -->
				
				<c:forEach var="tempCables" items="${cables}">
				
<!-- 					construct an update link -->
					
					<c:url var="updateLink" value="/main/updateCablesForm">
						<c:param name="cableId" value="${tempCables.cableId}"/>
					</c:url>
					
<!-- 					construct an update link -->
					
					<c:url var="deleteLink" value="/main/deleteCables">
						<c:param name="cableId" value="${tempCables.cableId}"/>
					</c:url>
					

					
					<tr>
						<td> ${tempCables.cableId} </td>
						<td> ${tempCables.cableType} </td>
						<td> ${tempCables.cableQuantity} </td>
						<td> ${tempCables.cableDiameter} </td>
						<td> ${tempCables.cablePerSector} </td>
						<td> ${tempCables.cableConfiguration} </td>
						<td> ${tempEquipment.getCablesProject().getProjectNumber()} </td>
		
						
						<td>
							<a href="${updateLink}">Update</a>
							<br>
							
						 	<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to remove these cables?'))) return false">Delete</a>
						 	
						</td>				
					</tr>
				
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</body>

</html>