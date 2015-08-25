<%@ tag description="Wrap content with header and footer"
	language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="<c:url value="/view/styles/styles.css" />" rel="stylesheet" type="text/css">
<!-- jQuery -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>

<!-- Verify.js (with Notify.js included) -->
<script src="//raw.github.com/jpillora/verifyjs/gh-pages/dist/verify.notify.min.js"></script>


<title>Header</title>
</head>

<body>
	<div class="Mcontainer">
		<jsp:include page="/view/content/common/header.jsp" />
		<div class="mainbody">
			<p><jsp:doBody />
		</div>
		<jsp:include page="/view/content/common/footer.jsp" />
	</div>
</body>
</html>