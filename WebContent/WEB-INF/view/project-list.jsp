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
			<h2>PAM - Projects (Asset) Manager</h2>
		</div>	
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- add button for customer add -->
			<input type="button" value="Add Project"
				   onclick="window.location.href='addProjectForm'; return false;"
				   class="add-button"/>	
				   
			<input type="button" value="Return to Start"
				   onclick="window.location.href='startPage'; return false;"
				   class="add-button"/>	   	
			
			<!-- Build HTML content table here -->
			
			<table>
				<tr>
					<th>Project Number</th>
					<th>Project Type</th>
					<th>Carrier Name</th>		
					<th>Contact Company</th>
					<th>Contact First Name</th>
					<th>Contact Last Name</th>
					<th>Contact Email</th>
					<th>Tower Reference</th>		
				</tr>
				
				<!-- Loop over and print the customers -->
				
				<c:forEach var="tempProject" items="${projects}">
				
<!-- 					construct an update link -->
					
					<c:url var="updateLink" value="/main/updateTowerForm">
						<c:param name="projectNumber" value="${tempProject.projectNumber}"/>
					</c:url>
					
<!-- 					construct an update link -->
					
					<c:url var="deleteLink" value="/main/deleteProject">
						<c:param name="projectNumber" value="${tempProject.projectNumber}"/>
					</c:url>
					
					<tr>
						<td> ${tempProject.projectNumber} </td>
						<td> ${tempProject.projectType} </td>
						<td> ${tempProject.carrierName} </td>
						<td> ${tempProject.contactCompany} </td>
						<td> ${tempProject.contactFirstName} </td>
						<td> ${tempProject.contactLastName} </td>
						<td> ${tempProject.contactEmail} </td>
						<td> ${tempProject.towerId} </td>
						
						<td>
							<a href="${updateLink}">Update</a>
							|
						 	<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to remove this project?'))) return false">Delete</a>
						</td>				
					</tr>
				
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</body>

</html>