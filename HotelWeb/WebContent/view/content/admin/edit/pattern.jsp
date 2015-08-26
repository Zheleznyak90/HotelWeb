<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="rightPanel">
	<div id="errorMsg"></div>
	<div class ="currItem" title="room_pattern" id="${pattern.id}">
		<br> <fmt:message key="aClass" />
		<br> <select class="changeable" id="class_id">
		<c:forEach var="currClass" items="${classes}">
			<option value ="${currClass.id}" ${pattern.aClass.id == currClass.id ? 'selected':'' }>${currClass.aClass}</option>
		</c:forEach>
		</select>
		
		<br> <fmt:message key="price" /> <br> <input type="text" value="${pattern.price}" class="changeable" id="price">
		<br> <fmt:message key="size" /> <br> <input type="number" value="${pattern.size}" class="changeable" id="size">
		<br> <fmt:message key="description" /> <br> <textarea cols="40" rows="5" class="changeable" id="description">${pattern.description}</textarea>
	
	</div>
</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>