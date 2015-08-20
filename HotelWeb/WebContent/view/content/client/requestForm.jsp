<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="form_request" method="post" action="RequestProc">
	<table>
		<tr>
			<td>Number of person</td>
			<td><input type="number" name="num" required></td>
		</tr>
		<tr>
			<td>Apartment Class</td>
			<td><select name="class" required>
					<c:forEach var="currClass" items="${classes}">
						<option value="${currClass.id}">${currClass.aClass}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Check-In Date</td>
			<td><input type="date" name="checkInDate" class="date" required>
			</td>
		</tr>
		<tr>
			<td>Check-Out Date</td>
			<td><input type="date" name="checkOutDate" class="date" required>
			</td>
		</tr>
	</table>
	<input type="submit" value="Send request">

</form>
 <link rel="stylesheet" href="<c:url value="/jslib/jquery-ui.css" />">
<script src="<c:url value="/jslib/jquery.min.js" />"></script>
<script src="<c:url value="/jslib/jquery-ui.min.js" />"></script>
<script src="<c:url value="/jslib/requestPage.js" />"></script>
