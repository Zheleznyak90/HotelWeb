<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div title="room">

		<form id="form_request" method="post" action="RoomAddProc">
			<table>
				<tr>
					<td><fmt:message key="patternName" />:</td>
					<td><select id="room_pattern" name="pattern" required>
							<c:forEach var="currPattern" items="${patterns}">
								<option value="${currPattern.id}"
									${room.pattern.id == currPattern.id ? 'selected':'' }>${currPattern.name}</option>
							</c:forEach>
					</select></td>
					<td>*</td>
				</tr>
				<tr>
					<td><fmt:message key="number" />:</td>
					<td><input class="unique" type="number" name="number" min=1
						max=999 required></td>
					<td>*</td>
				</tr>
				<tr>
					<td><fmt:message key="floor" />:</td>
					<td><input type="number" name="floor" min=1 max=10 required></td>
					<td>*</td>
				</tr>
				<tr>
					<td><fmt:message key="maintained" />:</td>
					<td><input type="checkbox" name="isMaintained" value="maintained"></td>
				</tr>
			</table>
			<input type="submit" value="<fmt:message key="add" />">

		</form>
	</div>
</div>
<script src="<c:url value="/view/js/uniqueCheck.js" />"
	type="text/javascript"></script>