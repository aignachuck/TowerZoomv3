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
		<h2>CAM - Contract (Asset) Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Contract</h3>
		
		<form:form action="saveContract" modelAttribute="contract" method="POST">
			
			<!-- need to associate data with customer id -->
			
			<form:hidden path="contractId"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Contract Number:</label></td>
						<td><form:input path="contractNumber"/></td>
					</tr>
					
					<tr>
						<td><label>Parent Company:</label></td>
						<td><form:input path="parentCompany"/></td>
					</tr>
					
					<tr>
						<td><label>Primary RAD Center:</label></td>
						<td><form:input path="primaryRadCenter"/></td>
					</tr>
					<tr>
						<td><label>Primary RAD Tip:</label></td>
						<td><form:input path="primaryRadTip"/></td>
					</tr>
					<tr>
						<td><label>Primary RAD Base:</label></td>
						<td><form:input path="primaryRadBase"/></td>
					</tr>
					<tr>
						<td><label>Alternate RAD Center 1:</label></td>
						<td><form:input path="alternateRadCenter1"/></td>
					</tr>
					<tr>
						<td><label>Alternate RAD Tip 1:</label></td>
						<td><form:input path="alternateRadTip1"/></td>
					</tr>
					<tr>
						<td><label>Alternate RAD Base 1:</label></td>
						<td><form:input path="alternateRadBase1"/></td>
					</tr>
					<tr>
						<td><label>Alternate RAD Center 2:</label></td>
						<td><form:input path="alternateRadCenter2"/></td>
					</tr>
					<tr>
						<td><label>Alternate RAD Tip 2:</label></td>
						<td><form:input path="alternateRadTip2"/></td>
					</tr>
					<tr>
						<td><label>Alternate RAD Base 2:</label></td>
						<td><form:input path="alternateRadBase2"/></td>
					</tr>	
					<tr>
						<td><label>Tower ID:</label></td>
						<td><form:input path="towerContract.towerId"/></td>
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
			<a href="${pageContext.request.contextPath}/main/contractsList">Back to List</a>
		
		</p>
	</div>

</body>


</html>
