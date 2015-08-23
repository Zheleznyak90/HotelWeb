<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="rightPanel">

	<table border="1" class="sortable">
		<thead>
			<tr>
				<td>Room</td>
				<td>Client</td>
				<td>Manager</td>
				<td>Meal</td>
				<td>Status</td>
				<td>CheckIn</td>
				<td>CheckOut</td>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="currOrder" items="${orders}">
				<tr id="${currOrder.id }" onClick="selectOrder(this)">
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
	<script src="<c:url value="/view/js/orders.js" />"
	type="text/javascript"></script>

