<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="rightPanel">
	<div id="errorMsg"></div>
	<div class="currItem" title="UserT" id="${user.id}">
		<br> Email <br> ${user.email} <br>
		<fmt:message key="role" />
		<br> <select class="changeable" id="role_id">
			<c:forEach var="currRole" items="${roles}">
				<option value="${currRole.id}" ${user.userRole.id==currRole.id ? 'selected':'' }>${currRole.role}</option>
			</c:forEach>
		</select>	
	</div>

</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>