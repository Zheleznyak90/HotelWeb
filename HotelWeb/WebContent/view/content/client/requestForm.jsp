<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form id="form_request" method="post" action="RequestProc"
	onSubmit="validate()">
	<table>
		<tr>
			<td><fmt:message key="guestNum" />
			</td>
			<td><input type="number" name="num" required>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="aClass" />
			</td>
			<td><select name="class" required>
					<c:forEach var="currClass" items="${classes}">
						<option value="${currClass.id}">${currClass.aClass}</option>
					</c:forEach>
			</select>
			</td>
		</tr>

		<tr>
			<td><fmt:message key="mealName" />
			</td>
			<td><select name="meal" required>
					<c:forEach var="currMeal" items="${meals}">
						<option value="${currMeal.id}">${currMeal.name}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
		
		<jsp:useBean id="tomorrow" class="java.util.Date" />
		<jsp:setProperty name="tomorrow" property="time"
			value="${tomorrow.time + 86400000}" />
		<jsp:useBean id="dayAfterTomorrow" class="java.util.Date" />
		<jsp:setProperty name="dayAfterTomorrow" property="time"
			value="${tomorrow.time + 86400000}" />
		<tr>
			<td><fmt:message key="checkIn" />
			</td>
			<td><input type="text" name="checkInDate" value="<fmt:formatDate value="${tomorrow}" pattern="MM/dd/yyyy" />" class="date" required>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="checkOut" />
			</td>
			<td><input type="text" name="checkOutDate" value="<fmt:formatDate value="${dayAfterTomorrow}" pattern="MM/dd/yyyy" />" class="date" required>
			</td>
		</tr>
	</table>
	<input type="submit" value="<fmt:message key="sendReq" />">

</form>
<link rel="stylesheet" href="<c:url value="/jslib/jquery-ui.css" />">
<script src="<c:url value="/jslib/jquery.min.js" />"></script>
<script src="<c:url value="/jslib/jquery-ui.min.js" />"></script>
<script src="<c:url value="/view/js/requestPage.js" />"></script>
