<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="rightPanel">
	<div id="errorMsg"></div>
	<table border="1" class="sortable">
		<tr>
			<td>Id</td>
			<td>Email</td>
			<td>Role</td>
			
			<td>Full name</td>
			<td>Phone number</td>
			<td>Edit</td>
			<td>Delete</td>

		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.email}</td>
				<td>${user.userRole.role}</td>
				<td>${user.fullName}</td>
				<td>${user.phoneNumber}</td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/editBtn.png"
					class="btnImg" alt="editBtn" id="editBtn_${user.id}"
					onClick="editRow('${pageContext.request.contextPath}','UserEdit',this)"></td>
				<td><img
					src="${pageContext.request.contextPath}/view/img/deleteBtn.png"
					class="btnImg" alt="deleteBtn" id="deleteBtn_${user.id}"
					onClick="deleteRow('${pageContext.request.contextPath}','userT', this)"></td>
			</tr>

		</c:forEach>
	</table>
</div>
<script src="<c:url value="/view/js/sorttable.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/view/js/adminPages.js" />"
	type="text/javascript"></script>


