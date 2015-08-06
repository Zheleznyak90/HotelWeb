<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var = "room" items="${roomList}">
	<br>
	<c:out value="${room.roomClass }"></c:out>
</c:forEach>