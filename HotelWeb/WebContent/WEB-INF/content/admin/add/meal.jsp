<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div title="meal">

		<form id="form_request" method="post" action="MealAddProc">
			<table>
				<tr id="check">
					<td><fmt:message key="mealName" />:</td>
					<td><input type="text" class="unique" name="name"
						maxlength="50" required></td>
					<td>*</td>
				</tr>
				<tr>
					<td><fmt:message key="price" />:</td>
					<td><input type="number" step="0.01" name="price" min=0 max=100 required></td>
					<td>*</td>
				</tr>
				<tr>
					<td><fmt:message key="description" />:</td>
					<td><textarea cols="40" rows="5" name="description"
							maxlength="500"></textarea></td>
				</tr>
				<tr>
					<td><fmt:message key="isActive" />:</td>
					<td><input type="checkbox" name="isActive" value="active"></td>
				</tr>
			</table>
			<input type="submit" value="<fmt:message key="add" />">


		</form>
	</div>
</div>
<script src="<c:url value="/view/js/uniqueCheck.js" />"
	type="text/javascript"></script>
