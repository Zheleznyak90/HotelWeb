<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightPanel">
	<c:forEach var="room" items="${roomList}">
		<div class="room">
			<img src="${room.photoSetPath}/1.jpg" class="photo" alt="Room Photo">
			<div class="price">
				Rates from:<br> &#36;
				<c:out value="${room.price }"></c:out>
				USD
			</div>
			<div class="infoBlock">
				<div class="description">
					<c:out value="${room.description }"></c:out>
				</div>
				<div class="roomClass">
					Class:
					<c:out value="${room.aClass.aClass }"></c:out>
				</div>
				<div class="size">
					Number of person:
					<c:out value="${room.size }"></c:out>
				</div>

			</div>

		</div>
	</c:forEach>
</div>