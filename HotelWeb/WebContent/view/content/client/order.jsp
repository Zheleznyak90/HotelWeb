<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form id="form_request" method="post" action="OrderProc">
<input type="hidden" name ="pattern_id" value="${pattern.id}">
	<table>
		<tr>
			<td>Name</td>
			<td>${pattern.name}</td>
		</tr>
		<tr>
			<td>Number of person</td>
			<td>${pattern.size}</td>
		</tr>
		<tr>
			<td>Price</td>
			<td id="roomPrice">${pattern.price}&#36</td>
		</tr>
		<tr>
			<td>Meal</td>
			<td><select class="recalc" name="meal" id="mealSelect" required>
					<c:forEach var="currMeal" items="${meals}">
						<option value="${currMeal.id}">${currMeal.name} -
							${currMeal.price}&#36</option>
					</c:forEach>
			</select></td>
		</tr>
		<jsp:useBean id="now" class="java.util.Date" />
		<jsp:useBean id="tomorrow" class="java.util.Date" />
		<jsp:setProperty name="tomorrow" property="time" value="${tomorrow.time + 86400000}"/>
		
		<tr>
			<td>Check-In Date</td>
			<td><input type="date" id ="checkin" name="checkInDate" class="date recalc"
				value="<fmt:formatDate value="${now}" pattern="MM/dd/yyyy" />"
				required></td>
		</tr>
		<tr>
			<td>Check-Out Date</td>
			<td><input type="date" id ="checkout" name="checkOutDate" class="date recalc"
			value="<fmt:formatDate value="${tomorrow}" pattern="MM/dd/yyyy" />" required></td>
		</tr>
	</table>
	<div>
		Total price: <div id="total">${pattern.price}</div>&#36
		
	</div>

	<input type="submit" value="Make order">

</form>
<link rel="stylesheet" href="<c:url value="/jslib/jquery-ui.css" />">
<script src="<c:url value="/jslib/jquery.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery-ui.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/jslib/requestPage.js" />" type="text/javascript"></script>	
