<div class="leftPanel">
	Sort by:
	<ul>
		<li><span>Class <img
				src="${pageContext.request.contextPath}/view/img/arrowDown.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('aClass','direct')"> <img
				src="${pageContext.request.contextPath}/view/img/arrowUp.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('aClass','reverse')"> </span>
		<li><span>Price <img
				src="${pageContext.request.contextPath}/view/img/arrowDown.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('price','direct')"> <img
				src="${pageContext.request.contextPath}/view/img/arrowUp.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('price','reverse')">
		</span>
		<li><span>Number of person <img
				src="${pageContext.request.contextPath}/view/img/arrowDown.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('capacity','direct')"> <img
				src="${pageContext.request.contextPath}/view/img/arrowUp.png"
				class="tinySortArrow" alt="directSort"
				onClick="sort('capacity','reverse')">
		</span>
	</ul>
</div>
<script src="<c:url value="/view/js/mainPage.js" />"
	type="text/javascript"></script>
