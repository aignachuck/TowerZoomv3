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
			<h2>CAM - Contracts (Asset) Manager</h2>
		</div>	
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- add button for customer add -->
			<input type="button" value="Add Contract"
				   onclick="window.location.href='addContractForm'; return false;"
				   class="add-button"/>	
				   
			<input type="button" value="Return to Start"
				   onclick="window.location.href='startPage'; return false;"
				   class="add-button"/>	   	
			
			<!-- Build HTML content table here -->
			
			<table>
				<tr>
					<th>Contract ID</th>
					<th>Contract Number</th>
					<th>Parent Company</th>		
					<th>Primary RAD Center</th>
					<th>Primary RAD Tip</th>
					<th>Primary RAD Base</th>
					<th>Alternate RAD Center 1</th>
					<th>Alternate RAD Tip 1</th>
					<th>Alternate RAD Base 1</th>	
					<th>Alternate RAD Center 2</th>
					<th>Alternate RAD Tip 2</th>
					<th>Alternate RAD Base 2</th>		
					<th>Tower ID</th>
				</tr>
				
				<!-- Loop over and print the customers -->
				
				<c:forEach var="tempContract" items="${contracts}">
				
<!-- 					construct an update link -->
					
					<c:url var="updateLink" value="/main/updateContractForm">
						<c:param name="contractId" value="${tempContract.contractId}"/>
					</c:url>
					
<!-- 					construct an update link -->
					
					<c:url var="deleteLink" value="/main/deleteContract">
						<c:param name="contractId" value="${tempContract.contractId}"/>
					</c:url>
					
<%-- 					<c:url var="addEquipment" value="/main/addEquipment"> --%>
<%-- 						<c:param name="projectNumber" value="${tempProject.projectNumber}"/> --%>
<%-- 					</c:url> --%>
					
					<tr>
						<td> ${tempContract.contractId} </td>
						<td> ${tempContract.contractNumber} </td>
						<td> ${tempContract.parentCompany} </td>
						<td> ${tempContract.primaryRadCenter} </td>
						<td> ${tempContract.primaryRadTip} </td>
						<td> ${tempContract.primaryRadBase} </td>
						<td> ${tempContract.alternateRadCenter1} </td>
						<td> ${tempContract.alternateRadTip1} </td>
						<td> ${tempContract.alternateRadBase1} </td>
						<td> ${tempContract.alternateRadCenter2} </td>
						<td> ${tempContract.alternateRadTip2} </td>
						<td> ${tempContract.alternateRadBase2} </td>					
						<td> ${tempContract.getTowerContract().getTowerId()} </td>
						<td>
							<a href="${updateLink}">Update</a>
							<br>
							
						 	<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to remove this contract?'))) return false">Delete</a>
						 	
						</td>				
					</tr>
				
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</body>

</html>