
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper>
	<jsp:include page="/view/content/admin/adminFunctions.jsp" />
	<jsp:include page="/view/content/admin/${jspPage}.jsp" />
</t:wrapper>