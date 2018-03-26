<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Star Towers VPM</title>

	<!-- reference the stylesheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>TAM - Tower Asset Manager</h2>
		</div>	
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- add button for customer add -->
			<input type="button" value="Add Tower"
				   onclick="window.location.href='addTowerForm'; return false;"
				   class="add-button"/>
				   
			<input type="button" value="Return to Start"
				   onclick="window.location.href='startPage'; return false;"
				   class="add-button"/>		
			
			<!-- Build HTML content table here -->
			
			<table>
				<tr>
					<th>Tower Number</th>
					<th>Tower Name</th>
					<th>Tower Portfolio</th>		
					<th>City</th>
					<th>State</th>
				</tr>
				
				<!-- Loop over and print the customers -->
				
				<c:forEach var="tempTower" items="${towers}">
				
<!-- 					construct an update link -->
					
					<c:url var="updateLink" value="/main/updateTowerForm">
						<c:param name="towerId" value="${tempTower.towerId}"/>
					</c:url>
					
<!-- 					construct a delete link -->
					
					<c:url var="deleteLink" value="/main/deleteTower">
						<c:param name="towerId" value="${tempTower.towerId}"/>
					</c:url>
					
					<c:url var="projectLink" value="main/addProjectForm">
						<c:param name="towerId" value="${tempProject.towerId}"/>
					</c:url>
					
					<tr>
						<td> ${tempTower.towerNumber} </td>
						<td> ${tempTower.towerName} </td>
						<td> ${tempTower.towerPortfolio} </td>
						<td> ${tempTower.city} </td>
						<td> ${tempTower.state} </td>	
						<td>
							<a href="${updateLink}">Update</a>
							|
						 	<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to remove this Tower?'))) return false">Delete</a>
							|
							<a href="${projectLink}">Add Project</a>
						</td>				
					</tr>
				
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</body>

</html>