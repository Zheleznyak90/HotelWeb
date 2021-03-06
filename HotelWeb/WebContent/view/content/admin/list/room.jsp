<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="rightPanel">
	<div id="errorMsg"></div>
	<table border="1" class="sortable">
		<tr>
			<td>Id</td>
			<td>Room pattern</td>
			<td>Number</td>
			<td>Floor</td>
			<td>Maintance</td>

			<td>Edit</td>
			<td>Delete</td>

		</tr>
		<c:forEach var="room" items="${rooms}">
			<tr>
				<td>${room.id}</td>
				<td>${room.pattern.id}</td>
				<td>${room.number}</td>
				<td>${room.floor}</td>
				<td>${room.maintained}</td>

				<td><img
					src="${pageContext.request.contextPath}/view/img/editBtn.png"
					class="btnImg" alt="editBtn" id="editBtn_${room.id}"
					onClick="editRow('${pageContext.request.contextPath}','RoomEdit',this)"></td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/deleteBtn.png"
					class="btnImg" alt="deleteBtn" id="deleteBtn_${room.id}"
					onClick="deleteRow('${pageContext.request.contextPath}','room',this)"></td>
			</tr>

		</c:forEach>
	</table>
	<img src="${pageContext.request.contextPath}/view/img/addBtn.png"
		class="btnImg" alt="addBtn" id="addBtn_Room"
		onClick="addNew('${pageContext.request.contextPath}',this)">
</div>
<script src="<c:url value="/view/js/sorttable.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/view/js/adminPages.js" />"
	type="text/javascript"></script>
