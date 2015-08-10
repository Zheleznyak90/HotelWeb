<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="rightPanel">
	<c:forEach var="pattern" items="${patterns}">
	${pattern.price }
	</c:forEach>
</div>