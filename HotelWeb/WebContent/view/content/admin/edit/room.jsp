<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="errorMsg">

</div>
<div class="rightPanel">
	<div id="errorMsg"></div>
	<br> Meal <br> <input type="text" value="${meal.meal}" class="changeble" id="meal_meal_${meal.id}">
	<br> Price <br> <input type="text" value="${meal.price}" class="changeble" id="meal_price_${meal.id}">
	<br> Description <br> <input type="text" value="${meal.description}" class="changeble" id="meal_description_${meal.id}">
	<br> Is Active
	<br> <input type="checkbox" ${meal.active?'checked':'' } class="changeble" id="meal_isActive_${meal.id}">


</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>