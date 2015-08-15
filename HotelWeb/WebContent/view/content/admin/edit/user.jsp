<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightPanel">
	<div id="errorMsg"></div>
	<div title="UserT" id="${user.id}">
		<br> Email <br> ${user.email}
		<br> Role <br> <select class="changeable" id="role_id">
		<c:forEach var="currRole" items="${roles}">
			<option value ="${currRole.id}" ${user.userRole.id == currRole.id ? 'selected':'' }>${currRole.role}</option>
		</c:forEach>
		</select>
		<br> Password
		<br> <button>Reset password</button>
	</div>

</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>