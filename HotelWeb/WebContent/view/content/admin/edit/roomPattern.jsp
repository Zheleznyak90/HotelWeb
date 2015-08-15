<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightPanel">
	<div id="errorMsg"></div>
	<div title="room_pattern" id="${pattern.id}">
		<br> Class 
		<br> <select class="changeable" id="class_id">
		<c:forEach var="currClass" items="${classes}">
			<option value ="${currClass.id}" ${pattern.aClass.id == currClass.id ? 'selected':'' }>${currClass.aClass}</option>
		</c:forEach>
		</select>
		
		<br> Price <br> <input type="text" value="${pattern.price}" class="changeable" id="price">
		<br> Size <br> <input type="number" value="${pattern.size}" class="changeable" id="size">
		<br> Description <br> <input type="text" value="${pattern.description}" class="changeable" id="description">
	
	</div>
</div>

<script src="<c:url value="/view/js/editPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jquery.min.js" />"
	type="text/javascript"></script>