<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form id="form_request" method="post" action="OrderProc" onSubmit="validate()">
<input type="hidden" name ="pattern_id" value="${pattern.id}">
	<table>
		<tr>
			<td><fmt:message key="patternName" /></td>
			<td>${pattern.name}</td>
		</tr>
		<tr>
			<td><fmt:message key="guestNum" /></td>
			<td>${pattern.size}</td>
		</tr>
		<tr>
			<td><fmt:message key="price" /></td>
			<td id="roomPrice">${pattern.price}&#36</td>
		</tr>
		<tr>
			<td><fmt:message key="mealName" /></td>
			<td><select class="recalc" name="meal" id="mealSelect" required>
					<c:forEach var="currMeal" items="${meals}">
						<option value="${currMeal.id}">${currMeal.name} -
							${currMeal.price}&#36</option>
					</c:forEach>
			</select></td>
		</tr>
		<jsp:useBean id="tomorrow" class="java.util.Date" />
		<jsp:setProperty name="tomorrow" property="time" value="${tomorrow.time + 86400000}"/>
		<jsp:useBean id="dayAfterTomorrow" class="java.util.Date" />
		<jsp:setProperty name="dayAfterTomorrow" property="time" value="${tomorrow.time + 86400000}"/>
		
		<tr>
			<td><fmt:message key="checkIn" /></td>
			<td><input type="text" id ="checkin" name="checkInDate" class="date recalc"
				value="<fmt:formatDate value="${tomorrow}" pattern="MM/dd/yyyy" />"
				required></td>
		</tr>
		<tr>
			<td><fmt:message key="checkOut" /></td>
			<td><input type="text" id ="checkout" name="checkOutDate" class="date recalc"
			value="<fmt:formatDate value="${dayAfterTomorrow}" pattern="MM/dd/yyyy" />" required></td>
		</tr>
	</table>
	<div>
		<fmt:message key="totalPrice" />: <span id="total">${pattern.price}</span>&#36
		
	</div>

	<input type="submit" value="Make order">

</form>
<link rel="stylesheet" href="<c:url value="/jslib/jquery-ui.css" />">
<script src="<c:url value="/jslib/jquery.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery-ui.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/view/js/requestPage.js" />" type="text/javascript"></script>	
