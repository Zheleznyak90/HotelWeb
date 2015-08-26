<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div class ="currItem" title="meal" id="${meal.id}">
		<br> <fmt:message key="mealName" /><br> <input type="text" value="${meal.name}" class="unique changeable" id="name">
		<br> <fmt:message key="price" /> <br> <input type="text" value="${meal.price}" class="changeable" id="price">
		<br> <fmt:message key="description" /> <br> <textarea cols="40" rows="5" class="changeable" id="description" >${meal.description}</textarea>
		<br> <fmt:message key="isActive" />
		<br> <input type="checkbox" ${meal.active?'checked':'' } class="changeable" id="isActive">
	</div>

</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
