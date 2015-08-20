<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
	<div class="hcontainer">
		<a class="home" href="${pageContext.request.contextPath}/m">Home</a> <a
			class="lang">Language</a>

		<c:choose>
			<c:when test="${not empty User}">
				<jsp:include page="/view/content/common/authUser.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="/view/content/common/anonUser.jsp" />
			</c:otherwise>
		</c:choose>
	</div>
</div>