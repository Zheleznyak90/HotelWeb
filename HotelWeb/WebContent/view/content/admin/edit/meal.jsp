<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div title="meal" id="${meal.id}">
		<br> Meal <br> <input type="text" value="${meal.meal}" class="changeable" id="meal">
		<br> Price <br> <input type="text" value="${meal.price}" class="changeable" id="price">
		<br> Description <br> <input type="text" value="${meal.description}" class="changeable" id="description" >
		<br> Is Active
		<br> <input type="checkbox" ${meal.active?'checked':'' } class="changeable" id="isActive">
	</div>

</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>
