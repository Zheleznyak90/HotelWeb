<%@ tag description="Wrap content with header and footer"
	language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty sessionLang ? sessionLang : 'en'}" scope="session"/>
<fmt:setLocale value="${language}" scope="session" />
<fmt:setBundle basename="ua.nure.zheleznyak.HotelWeb.model.localization.InternationalizationBundle" scope="session" />
<html>
<head>
<link href="<c:url value="/view/styles/styles.css" />" rel="stylesheet" type="text/css">

 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
<!-- jQuery 
 Verify.js (with Notify.js included)
<script src="//raw.github.com/jpillora/verifyjs/gh-pages/dist/verify.notify.min.js"></script> -->


<title></title>
</head>
<body>
	<div class="Mcontainer">
		<jsp:include page="/WEB-INF/content/common/header.jsp" />
		<div class="mainbody">
			<p><jsp:doBody />
		</div>
		<jsp:include page="/WEB-INF/content/common/footer.jsp" />
	</div>
</body>
</html>