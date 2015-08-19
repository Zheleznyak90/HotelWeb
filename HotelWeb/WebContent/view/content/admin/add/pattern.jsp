<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div title="room_pattern">

		<form id="form_request" method="post" action="PatternAddProc">
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" class="unique" name="name"
						maxlength="50" required></td>
					<td>*</td>
				</tr>
				<tr>
					<td>Class:</td>
					<td><select name="class_id" required>
							<c:forEach var="currClass" items="${classes}">
								<option value="${currClass.id}"
									${pattern.aClass.id == currClass.id ? 'selected':'' }>${currClass.aClass}</option>
							</c:forEach>
					</select></td>
					<td>*</td>
				</tr>

				<tr>
					<td>Price:</td>
					<td><input type="number" step="0.01" name="price" min=0 required></td>
					<td>*</td>
				</tr>
				<tr>
					<td>Size:</td>
					<td><input type="number" name="size" min=0 max=10 required></td>
					<td>*</td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><textarea cols="40" rows="5" name="description"
							maxlength="500"></textarea></td>
				</tr>
				<tr>
					<td>Photo preview:</td>
					<td><input type="file" name="file_1" id=1 name="photo">
					</td>
					<td>*</td>
				</tr>

			</table>
			<input type="submit" value="Create new pattern">

		</form>
	</div>

</div>
<script src="<c:url value="/view/js/uniqueCheck.js" />"
	type="text/javascript"></script>