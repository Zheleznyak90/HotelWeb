<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form id="form_request" method="post" action="RequestProc">
	<table>
		<tr>
			<td><fmt:message key="guestNum" /></td>
			<td><input type="number" name="num" required></td>
		</tr>
		<tr>
			<td><fmt:message key="aClass" /></td>
			<td><select name="class" required>
					<c:forEach var="currClass" items="${classes}">
						<option value="${currClass.id}">${currClass.aClass}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td><fmt:message key="checkIn" /></td>
			<td><input type="text" name="checkInDate" class="date" required>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="checkOut" /></td>
			<td><input type="text" name="checkOutDate" class="date" required>
			</td>
		</tr>
	</table>
	<input type="submit" value="<fmt:message key="sendReq" />">

</form>
 <link rel="stylesheet" href="<c:url value="/jslib/jquery-ui.css" />">
<script src="<c:url value="/jslib/jquery.min.js" />"></script>
<script src="<c:url value="/jslib/jquery-ui.min.js" />"></script>
<script src="<c:url value="/view/js/requestPage.js" />"></script>
