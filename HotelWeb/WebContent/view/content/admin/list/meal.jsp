<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="rightPanel">
	<div id="errorMsg"></div>

	<table border="1">
		<tr>
			<td>Id</td>
			<td>Meal</td>
			<td>Price</td>
			<td>Description</td>
			<td>Is Active</td>
			<td>Edit</td>
			<td>Delete</td>

		</tr>
		<c:forEach var="meal" items="${meals}">
			<tr>
				<td>${meal.id}</td>
				<td>${meal.name}</td>
				<td>${meal.price}</td>
				<td>${meal.description}</td>
				<td>${meal.active}</td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/editBtn.png"
					class="btnImg" alt="editBtn" id="editBtn_${meal.id}"
					onClick="editRow('${pageContext.request.contextPath}', 'MealEdit', this)"></td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/deleteBtn.png"
					class="btnImg" alt="deleteBtn" id="deleteBtn_${meal.id}"
					onClick="deleteRow('${pageContext.request.contextPath}', 'meal', this)"></td>
			</tr>

		</c:forEach>
	</table>
	<img src="${pageContext.request.contextPath}/view/img/addBtn.png"
		class="btnImg" alt="addBtn" id="addBtn_Meal"
		onClick="addNew('${pageContext.request.contextPath}',this)">
</div>
<script src="<c:url value="/view/js/adminPages.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>
