<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="rightPanel">
	<div id="errorMsg">123</div>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Role</td>
			<td>Email</td>
			<td>Full name</td>
			<td>Phone number</td>
			<td>Edit</td>
			<td>Delete</td>

		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.role}</td>
				<td>${user.email}</td>
				<td>${user.fullName}</td>
				<td>${user.phoneNumber}</td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/editBtn.png"
					class="btnImg" alt="editBtn" id="editBtn_${user.id}"
					onClick="editPattern('${pageContext.request.contextPath}',this)"></td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/deleteBtn.png"
					class="btnImg" alt="deleteBtn" id="deleteBtn_${user.id}"
					onClick="deletePattern('${pageContext.request.contextPath}',this)"></td>
			</tr>

		</c:forEach>
	</table>
</div>
<script src="<c:url value="/view/js/patternListScripts.js" />"
	type="text/javascript"></script>
<link href="<c:url value="/jslib/jquery-ui.css" />" rel="stylesheet"
	type="text/css" />
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery-ui.min.js" />"
	type="text/javascript"></script>

