<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="rightPanel">
	<div id="errorMsg"></div>
	<div class ="currItem" title="room" id="${room.id}">
		<br> <fmt:message key="patternName" />
		<br> <select class="changeable" id="room_pattern">
		<c:forEach var="currPattern" items="${patterns}">
			<option value ="${currPattern.id}" ${room.pattern.id == currPattern.id ? 'selected':'' }>${currPattern.name}</option>
		</c:forEach>
		</select>
		<br> <fmt:message key="number" /> <br> <input type="text" value="${room.number}" class="changeable" id="number">
		<br> <fmt:message key="maintained" /> <br> <input type="checkbox" ${room.maintained?'checked':'' } class="changeable" id="isMaintained">
	
	</div>
</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>