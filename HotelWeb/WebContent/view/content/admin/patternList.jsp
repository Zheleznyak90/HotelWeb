<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="rightPanel">
<div id="errorMsg">
123
</div>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Class</td>
			<td>Price</td>
			<td>Size</td>
			<td>Description</td>
			<td>PhotoSetPath</td>
			<td>Rating</td>
			<td>Edit</td>
			<td>Delete</td>

		</tr>
		<c:forEach var="pattern" items="${patterns}">
			<tr>
				<td>${pattern.id}</td>
				<td>${pattern.aClass.aClass}</td>
				<td>${pattern.price}</td>
				<td>${pattern.size}</td>
				<td>${pattern.description}</td>
				<td>${pattern.photoSetPath}</td>
				<td>${pattern.rating}</td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/editBtn.png"
					class="btnImg" alt="editBtn" id="editBtn_${pattern.id}"
					onClick="editRow('${pageContext.request.contextPath}', 'PatternEdit', this)"></td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/deleteBtn.png"
					class="btnImg" alt="deleteBtn" id="deleteBtn_${pattern.id}"
					onClick="deleteRow('${pageContext.request.contextPath}', 'room_pattern', this)"></td>
			</tr>

		</c:forEach>
	</table>
</div>
<script src="<c:url value="/view/js/dbAdministrationScripts.js" />"
	type="text/javascript"></script>
<link href="<c:url value="/jslib/jquery-ui.css" />" rel="stylesheet"
	type="text/css" />
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery-ui.min.js" />"
	type="text/javascript"></script>

