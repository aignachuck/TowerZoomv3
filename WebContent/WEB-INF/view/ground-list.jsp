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
			<h2>PGM - Project Ground Manager</h2>
		</div>	
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- add button for ground add -->
			<input type="button" value="Add Ground"
				   onclick="window.location.href='addGroundForm'; return false;"
				   class="add-button"/>	
				   
			<input type="button" value="Return to Start"
				   onclick="window.location.href='startPage'; return false;"
				   class="add-button"/>	   	
			
			<!-- Build HTML content table here -->
			
			<table>
				<tr>
					<th>Ground ID</th>
					<th>Ground Primary (Y/N?)</th>
					<th>Ground Space Type</th>
					<th>Ground Space Length</th>	
					<th>Ground Space Width</th>	
					<th>Ground Space Area (sq. ft.)</th>			
					<th>Project Reference</th>	
				</tr>
				
				<!-- Loop over and print the ground -->
				
				<c:forEach var="tempGround" items="${ground}">
				
<!-- 					construct an update link -->
					
					<c:url var="updateLink" value="/main/updateGroundForm">
						<c:param name="groundId" value="${tempGround.groundId}"/>
					</c:url>
					
<!-- 					construct a delete link -->
					
					<c:url var="deleteLink" value="/main/deleteGround">
						<c:param name="groundId" value="${tempGround.groundId}"/>
					</c:url>
										
					<tr>
						<td> ${tempGround.groundId} </td>
						<td> ${tempGround.groundPrimary} </td>
						<td> ${tempGround.groundSpaceType} </td>
						<td> ${tempGround.groundSpaceLength} </td>
						<td> ${tempGround.groundSpaceWidth} </td>
						<td> ${tempGround.groundArea} </td>						
						<td> ${tempEquipment.getGroundProject().getProjectNumber()} </td>
		
						
						<td>
							<a href="${updateLink}">Update</a>
							<br>
							
						 	<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to remove this ground space?'))) return false">Delete</a>
						 	
						</td>				
					</tr>
				
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</body>

</html>