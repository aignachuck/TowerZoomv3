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
			<h2>PEM - Project Equipment Manager</h2>
		</div>	
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- add button for customer add -->
			<input type="button" value="Add Equipment"
				   onclick="window.location.href='addEquipmentForm'; return false;"
				   class="add-button"/>	
				   
			<input type="button" value="Return to Start"
				   onclick="window.location.href='startPage'; return false;"
				   class="add-button"/>	   	
			
			<!-- Build HTML content table here -->
			
			<table>
				<tr>
					<th>Equipment ID</th>
					<th>Equipment Type</th>
					<th>Equipment Quantity</th>		
					<th>Equipment Manufacturer</th>
					<th>Equipment Model</th>
					<th>Equipment Height</th>	
					<th>Equipment Width</th>
					<th>Equipment Depth</th>
					<th>Equipment Weight</th>	
					<th>Equipment RAD</th>
					<th>Mount Type</th>
					<th>Azimuths</th>	
					<th>Count Per Azimuth</th>
					<th>TX Frequency</th>
					<th>RX Frequency</th>
					<th>Project Reference</th>	
				</tr>
				
				<!-- Loop over and print the customers -->
				
				<c:forEach var="tempEquipment" items="${equipment}">
				
<!-- 					construct an update link -->
					
					<c:url var="updateLink" value="/main/updateEquipmentForm">
						<c:param name="equipmentId" value="${tempEquipment.equipmentId}"/>
					</c:url>
					
<!-- 					construct an update link -->
					
					<c:url var="deleteLink" value="/main/deleteEquipment">
						<c:param name="equipmentId" value="${tempEquipment.equipmentId}"/>
					</c:url>
					

					
					<tr>
						<td> ${tempEquipment.equipmentId} </td>
						<td> ${tempEquipment.equipmentType} </td>
						<td> ${tempEquipment.equipmentQuantity} </td>
						<td> ${tempEquipment.equipmentManufacturer} </td>
						<td> ${tempEquipment.equipmentModel} </td>
						<td> ${tempEquipment.equipmentHeight} </td>
						<td> ${tempEquipment.equipmentWidth} </td>
						<td> ${tempEquipment.equipmentDepth} </td>
						<td> ${tempEquipment.equipmentWeight} </td>
						<td> ${tempEquipment.equipmentRad} </td>
						<td> ${tempEquipment.mountType} </td>
						<td> ${tempEquipment.azimuths} </td>
						<td> ${tempEquipment.countPerAzimuth} </td>
						<td> ${tempEquipment.txFrequency} </td>
						<td> ${tempEquipment.rxFrequency} </td>
						<td> ${tempEquipment.getEquipmentProject().getProjectNumber()} </td>
		
						
						<td>
							<a href="${updateLink}">Update</a>
							<br>
							
						 	<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to remove this equipment?'))) return false">Delete</a>
						 	
						</td>				
					</tr>
				
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</body>

</html>