<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project</title>

<script
	src="<c:url value="https://code.jquery.com/jquery-1.10.2.min.js" />"></script>

<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" />"></script>


<spring:url value="/resources/css/mainStyle.css" var="css" />
<link href="${css}" rel="stylesheet" />

<!--<spring:url value="/resources/js/mainScript.js" var="js" />
<script src="${js}"></script>-->

</head>
<body>
	<div id="wraper">

		<div id="customer_start_data">
			<div class="info_block">
				<div>
					<div>Customer</div>
					<div>Customer FIO</div>
				</div>
				<!-- END OF INFO BLOCK -->
			</div>
			<!-- END OF CUSTOMER -->
		</div>
		<div>
			SHOW DETAILS - DOUBLE CLICK ON ELEMENT<br> REDACT ELEMENTS -
			CLICK ON REDACTOR MODE BUTTON AND NEXT ADD ICON ON ELEMENT<br>
		</div>
		<div class="redactor_btn">redactor mode</div>
		<br>
		<!-- END OF START_DATA-->


		<p>Test forms for invoke ZoneManager methods</p>

		<form action="/web/projects/addRootGroupToProject" method="POST">
			<input name="groupName" type="text" value="CreatedRootGroupByProject">
			<input name="projectId" type="text" value="33"> <input
				type="submit" value="Add Group">
		</form>

		<form action="/web/projects/addGroupToGroup" method="POST">
			<input name="groupName" type="text" value="CreatedSubGroup">
			<input name="parentGroupId" type="text" value="1"> <input
				type="submit" value="Add SubGroup">
		</form>

		<form action="/web/projects/updateGroup" method="POST">
			<input name="groupName" type="text" value="UpdateGroup"> <input
				name="groupId" type="text" value="1"> <input type="submit"
				value="Update Group">
		</form>

		<form action="/web/projects/removeGroup" method="POST">
			<input name="groupId" type="text" value="5"> <input
				type="submit" value="Delete Group">
		</form>

		<form action="/web/projects/addZone" method="POST">
			<input name="name" type="text" value="CreatedNewZone"> <input
				name="parentGroupId" type="text" value="4"> <input
				name="measureName" type="text" value="M2"> <input
				name="width" type="text" value="123"> <input name="heigh"
				type="text" value="123.0"> <input type="submit"
				value="Add Zone">
		</form>

		<form action="/web/projects/addAdditionalZone" method="POST">
			<input name="name" type="text" value="CreatedNewAdditionalZone">
			<input name="parentZoneId" type="text" value="4"> <input
				name="measureName" type="text" value="M2"> <input
				name="width" type="text" value="3.0"> <input name="heigh"
				type="text" value="4.0"> <input type="submit"
				value="Add Additional Zone">
		</form>

		<form action="/web/projects/addSurplusZone" method="POST">
			<input name="name" type="text" value="CreatedNewSurplusZone">
			<input name="parentZoneId" type="text" value="4"> <input
				name="measureName" type="text" value="M2"> <input
				name="width" type="text" value="4.0"> <input name="heigh"
				type="text" value="2.5"> <input type="submit"
				value="Add Surplus Zone">
		</form>

		<form action="/web/projects/updateZone" method="POST">
			<input name="name" type="text" value="UpdatedZone"> <input
				name="zoneId" type="text" value="5"> <input
				name="measureName" type="text" value="M2"> <input
				name="width" type="text" value="123"> <input name="heigh"
				type="text" value="123.0"> <input type="submit"
				value="Update Zone">
		</form>

		<form action="/web/projects/removeZone" method="POST">
			<input name="zoneId" type="text" value="7"> <input
				type="submit" value="Delete Zone">
		</form>

		<jsp:include page="node.jsp" />

	</div>
	<!-- END OF WRAPER -->
</body>
</html>