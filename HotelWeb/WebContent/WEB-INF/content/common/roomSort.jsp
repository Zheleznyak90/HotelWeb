<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="leftPanel">
	<fmt:message key="sortBy" />:
	<ul>
		<li><span><fmt:message key="aClass" /> <img
				src="${pageContext.request.contextPath}/view/img/arrowDown.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('aClass','direct')"> <img
				src="${pageContext.request.contextPath}/view/img/arrowUp.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('aClass','reverse')"> </span>
		<li><span><fmt:message key="price" /> <img
				src="${pageContext.request.contextPath}/view/img/arrowDown.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('price','direct')"> <img
				src="${pageContext.request.contextPath}/view/img/arrowUp.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('price','reverse')">
		</span>
		<li><span><fmt:message key="size" /> <img
				src="${pageContext.request.contextPath}/view/img/arrowDown.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('capacity','direct')"> <img
				src="${pageContext.request.contextPath}/view/img/arrowUp.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('capacity','reverse')">
		</span>
	</ul>
	<div id="map"></div>
</div>
<script src="https://maps.googleapis.com/maps/api/js"></script>

<script src="<c:url value="/view/js/mainPage.js" />"
	type="text/javascript"></script>

	
