<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div title="room">

		<form id="form_request" method="post" action="admin/RoomAddProc">
			<table>
				<tr>
					<td>Room type:</td>
					<td><select id="room_pattern" name="pattern">
							<c:forEach var="currPattern" items="${patterns}">
								<option value="${currPattern.id}"
									${room.pattern.id == currPattern.id ? 'selected':'' }>${currPattern.name}</option>
							</c:forEach>
					</select> *</td>
				</tr>
				<tr>
					<td>Number:</td>
					<td><input class="unique" type="number" name="number" min=1
						max=999> *</td>
				</tr>
				<tr>
					<td>Floor:</td>
					<td><input type="number" name="floor" min=1 max=10> *</td>
				</tr>
				<tr>
					<td>Is maintained:</td>
					<td><input type="checkbox" name="isActive"></td>
				</tr>
			</table>
			<input type="submit" value="Create new room">

		</form>
	</div>
</div>
