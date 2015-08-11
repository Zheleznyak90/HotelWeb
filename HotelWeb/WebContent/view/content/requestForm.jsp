<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="form_request" method="post" action="RequestProc">
	<table>
		<tr>
			<td>Number of person</td>
			<td><input type="number" name="num"></td>
		</tr>
		<tr>
			<td>Apartment Class</td>
			<td><select name="class">
					<c:forEach var="currClass" items="${classes}">
						<option value="${currClass}">${currClass}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Check-In Date</td>
			<td><input type="date" name="checkInDate" class="date">
			</td>
		</tr>
		<tr>
			<td>Check-Out Date</td>
			<td><input type="date" name="checkOutDate" class="date">
			</td>
		</tr>
	</table>
	<input type="submit" value="Send request">

</form>

<script src="<c:url value="/jslib/requestPage.js" />"></script>