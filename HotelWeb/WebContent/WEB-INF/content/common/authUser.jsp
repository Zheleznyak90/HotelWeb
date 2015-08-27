<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>
	<c:when test="${User.userRole.role=='client'}">
		<a class="auth" href="${pageContext.request.contextPath}/client/RequestInit"><fmt:message key="createReq" /></a>
	</c:when>
	<c:when test="${User.userRole.role=='manager'}">
		<a class="auth" href="${pageContext.request.contextPath}/manager/OrdersList"><fmt:message key="handleReq" /></a>
	</c:when>
	<c:when test="${User.userRole.role=='admin'}">
		<a class="auth" href="${pageContext.request.contextPath}/admin/PatternManagment"><fmt:message key="managment" />
		</a>
	</c:when>
</c:choose>
<a class="auth" href="${pageContext.request.contextPath}/client/accManagment"><fmt:message key="acc" /></a>
<a class="reg" href="${pageContext.request.contextPath}/LogOut"><fmt:message key="logOut" /></a>