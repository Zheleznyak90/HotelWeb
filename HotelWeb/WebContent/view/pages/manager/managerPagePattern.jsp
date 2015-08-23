<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:wrapper>
	<jsp:include page="/view/content/manager/navi.jsp" />
	<jsp:include page="/view/content/manager/${jspPage}.jsp" />
</t:wrapper>