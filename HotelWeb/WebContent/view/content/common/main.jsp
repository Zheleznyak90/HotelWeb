<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="rightPanel">
	<div id="patternList">
		<c:forEach var="room" items="${roomList}">
			<div class="room" id="${room.id}" onClick="OfferRoom(this)">
				<img src="${room.photoSetPath}1.jpg" class="photo" alt="Room Photo">
				<div class="price">
					Rates from:<br> &#36;
					<span class="roomRateSort"> <c:out value="${room.price }"></c:out></span>
					USD
				</div>
				<div class="infoBlock">
					<div class="filler">
					
					</div>
					<div class="roomClass">
						<fmt:message key="aClass" />:
						<span class="roomClassSort" id ="classId_${room.aClass.id }"><c:out value="${room.aClass.aClass }"></c:out></span>
					</div>
					<div class="size">
						<fmt:message key="size" />:
						<span class="roomCapacitySort"><c:out value="${room.size }"></c:out></span>
					</div>

				</div>

			</div>
		</c:forEach>
	</div>
</div>

<script src="<c:url value="/view/js/mainPage.js" />"
	type="text/javascript"></script>