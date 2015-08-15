<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="errorMsg">

</div>
<div class="rightPanel">
	<div id="errorMsg"></div>
	<br> Class 
	<br> <select class="changeable" id="pattern_class_${pattern.id}">
	<c:forEach var="currClass" items="${classes}">
		<option value ="${currClass}">${currClass}</option>
	</c:forEach>
	</select>
	
	<%-- <input type="text" value="${pattern.pattern}" class="changeable" id="pattern_pattern_${pattern.id}"> --%>
	<br> Price <br> <input type="text" value="${pattern.price}" class="changeable" id="pattern_price_${pattern.id}">
	<br> Size <br> <input type="number" value="${pattern.size}" class="changeable" id="pattern_size_${pattern.id}">
	<br> Description <br> <input type="text" value="${pattern.description}" class="changeable" id="pattern_description_${pattern.id}">
	


</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>