<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div>
		<fmt:parseDate value="${checkInDate}" pattern="yyyy-MM-dd"
			var="checkIn" />
		<fmt:parseDate value="${checkOutDate}" pattern="yyyy-MM-dd"
			var="checkOut" />
		<table>
			<tr>
				<td>client</td>
				<td>${request.client.email}</td>
			</tr>
			<tr>
				<td>persons</td>
				<td>${request.numberOfPerson}</td>
			</tr>
			<form method="post" action="HandleRequest" id="handleReqForm">
				<input type="hidden" name="id" value="${request.id }" />
				<tr>
					<td>Class</td>
					<td><select name="class_id" class="refresh">
							<c:forEach var="currClass" items="${aClasses}">
								<option value="${currClass.aClass}" ${aClass eq currClass.aClass ?'selected':'' }>${currClass.aClass}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Check In</td>
					<td><input type="text" id="checkIn" name="checkInDate"
						class="date refresh"
						value="<fmt:formatDate value="${checkIn}" pattern="MM/dd/yyyy"/>">
					</td>
				</tr>
				<tr>
					<td>Check out</td>
					<td><input type="text" id="checkOut" name="checkOutDate"
						class="date refresh"
						value="<fmt:formatDate value="${checkOut}" pattern="MM/dd/yyyy"/>">
					</td>
				</tr>
			<tr>
				<td>rooms</td>
				<td><select name="room_id">
						<c:forEach var="currRoom" items="${rooms}">
							<option value="${currRoom.id}">${currRoom.number}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			</form>
		</table>
		<c:if test="${not empty rooms }">
			<button onClick="createOrder()">123</button>
		</c:if>

	</div>

</div>
<link rel="stylesheet" href="<c:url value="/jslib/jquery-ui.css" />">
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery-ui.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/view/js/handleReq.js" />"
	type="text/javascript"></script>

