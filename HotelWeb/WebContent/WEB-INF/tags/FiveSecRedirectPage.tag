<%@ tag description="Rediraction wraper"
	language="java" pageEncoding="UTF-8"%>
	<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
	
<html>
<head>

<link href="<c:url value="/view/styles/styles.css" />" rel="stylesheet" type="text/css">

<meta http-equiv="Refresh" content="5;url=${pageContext.request.contextPath}/m">
<title>Redirected</title>
</head>

<body>
	<div class="Mcontainer">
		<jsp:include page="/view/content/common/header.jsp" />
		<div class="mainbody">
			<p><jsp:doBody /></p>
		</div>
		<jsp:include page="/view/content/common/footer.jsp" />
	</div>
</body>
</html>