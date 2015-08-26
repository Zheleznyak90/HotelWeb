<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div class ="currItem" title="orderT" id="${order.id}">
		<table>
			<tr>
				<td><fmt:message key="client" /></td>
				<td>${order.client.email}</td>
			</tr>
			<tr>
				<td><fmt:message key="manager" /></td>
				<td>${order.manager.email}</td>
			</tr>
			<tr>
				<td><fmt:message key="number" /></td>
				<td>${order.room.number}</td>
			</tr>
			<tr>
				<td><fmt:message key="mealName" /></td>
				<td><select class="changeable" id="meal_id">
						<c:forEach var="currMeal" items="${meals}">
							<option value="${currMeal.id}" ${order.meal.name eq currMeal.name? 'selected':'' }>${currMeal.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><fmt:message key="status" /></td>
				<td><select class="changeable" id="order_status">
						<c:forEach var="currStatus" items="${statuses}">
							<option value="${currStatus.id}" ${order.status.status eq currStatus.status? 'selected':'' }>${currStatus.status}</option>
						</c:forEach>
				</select></td>
			</tr>

		</table>
	</div>

</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
	<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>