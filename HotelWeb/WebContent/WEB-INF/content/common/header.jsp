<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="header">
	<div class="hcontainer">
		<a class="home" href="${pageContext.request.contextPath}/m">Home</a>
		<div class="lang">
			<fmt:message key="lang" /> <select onChange="langChange(this)">

				<option value="en" ${language eq 'en' ? 'selected' : ''}><fmt:message key="english" /></option>
				<option value="ru" ${language eq 'ru' ? 'selected' : ''}><fmt:message key="russian" /></option>
			</select>
		</div>

		<c:choose>
			<c:when test="${not empty User}">
				<jsp:include page="/WEB-INF/content/common/authUser.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="/WEB-INF/content/common/anonUser.jsp" />
			</c:otherwise>
		</c:choose>
	</div>
</div>
<script src="<c:url value="/view/js/langChange.js" />"
	type="text/javascript"></script>