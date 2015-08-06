<%@ tag description="Wrap content with header and footer"
	language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="<c:url value="/view/styles/styles.css" />" rel="stylesheet" type="text/css">
<%-- 
<link rel="stylesheet" type="text/css" href="<c:url value="/view/styles/styles.css" />" /> --%>
<title>Header</title>
</head>

<body>
	<div class="container">
		<jsp:include page="/view/content/header.jsp" />
		<div class="mainbody">
			<p><jsp:doBody /></p>
		</div>
		<jsp:include page="/view/content/footer.jsp" />
	</div>
</body>
</html>