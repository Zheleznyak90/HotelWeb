<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="rightPanel">

	<table border="1" class="sortable">
		<thead>
			<tr>
				<td><fmt:message key="client" /></td>
				<td><fmt:message key="manager" /></td>
				<td><fmt:message key="aClass" /></td>
				<td><fmt:message key="guestNum" /></td>
				<td><fmt:message key="checkIn" /></td>
				<td><fmt:message key="checkOut" /></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="currRequest" items="${requests}">
				<tr id="${currRequest.id }"
					onClick="selectItem(this,'HandleRequest')">
					<td>${currRequest.client.email}</td>
					<td>${currRequest.manager.email}</td>
					<td>${currRequest.aClass.aClass}</td>
					<td>${currRequest.numberOfPerson}</td>
					<td>${currRequest.checkInDate}</td>
					<td>${currRequest.checkOutDate}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>
<script src="<c:url value="/view/js/sorttable.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/view/js/managerPages.js" />"
	type="text/javascript"></script>
