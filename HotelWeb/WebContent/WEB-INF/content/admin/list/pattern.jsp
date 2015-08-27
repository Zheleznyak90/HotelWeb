<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="rightPanel">
	<div id="errorMsg"></div>
	<table border="1" class="sortable">
		<tr>
			<td>Id</td>
			<td><fmt:message key="aClass" /></td>
			<td><fmt:message key="price" /></td>
			<td><fmt:message key="size" /></td>
			<td><fmt:message key="sName" /></td>
			<td><fmt:message key="edit" /></td>
			<td><fmt:message key="delete" /></td>

		</tr>
		<c:forEach var="pattern" items="${patterns}">
			<tr>
				<td>${pattern.id}</td>
				<td>${pattern.aClass.aClass}</td>
				<td>${pattern.price}</td>
				<td>${pattern.size}</td>
				<td>${pattern.name}</td>
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
	<img src="${pageContext.request.contextPath}/view/img/addBtn.png"
		class="btnImg" alt="addBtn" id="addBtn_Pattern"
		onClick="addNew('${pageContext.request.contextPath}',this)">
</div>
<script src="<c:url value="/view/js/sorttable.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/view/js/adminPages.js" />"
	type="text/javascript"></script>


