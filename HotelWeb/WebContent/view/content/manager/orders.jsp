<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="rightPanel">

	<table border="1" class="sortable">
		<thead>
			<tr>
				<td><fmt:message key="number" /></td>
				<td><fmt:message key="client" /></td>
				<td><fmt:message key="manager" /></td>
				<td><fmt:message key="mealName" /></td>
				<td><fmt:message key="status" /></td>
				<td><fmt:message key="checkIn" /></td>
				<td><fmt:message key="checkOut" /></td>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="currOrder" items="${orders}">
				<tr id="${currOrder.id }" onClick="selectItem(this,'OrderEdit')">
					<td>${currOrder.room.number}</td>
					<td>${currOrder.client.email}</td>
					<td>${currOrder.manager.email}</td>
					<td>${currOrder.meal.name}</td>
					<td>${currOrder.status.status}</td>
					<td>${currOrder.checkInDate}</td>
					<td>${currOrder.checkOutDate}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>
<script src="<c:url value="/view/js/sorttable.js" />"
	type="text/javascript"></script>
	<script src="<c:url value="/view/js/managerPages.js" />"
	type="text/javascript"></script>

