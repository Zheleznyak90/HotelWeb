
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper>
	<jsp:include page="/WEB-INF/content/admin/adminFunctions.jsp" />
	<jsp:include page="/WEB-INF/content/admin/${jspPage}.jsp" />
</t:wrapper>