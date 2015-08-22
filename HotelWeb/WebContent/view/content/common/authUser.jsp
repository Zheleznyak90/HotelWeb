<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${User.userRole.role=='client'}">
		<a class="auth" href="${pageContext.request.contextPath}/client/RequestInit">Create
			request</a>
	</c:when>
	<c:when test="${User.userRole.role=='manager'}">
		<a class="auth" href="${pageContext.request.contextPath}/manager/OrdersList">Get
			requests</a>
	</c:when>
	<c:when test="${User.userRole.role=='admin'}">
		<a class="auth" href="${pageContext.request.contextPath}/admin/PatternManagment">Managment
		</a>
	</c:when>
</c:choose>
<a class="auth" href="${pageContext.request.contextPath}/client/accManagment">My
	Account</a>
<a class="reg" href="${pageContext.request.contextPath}/LogOut">Log
	Out</a>