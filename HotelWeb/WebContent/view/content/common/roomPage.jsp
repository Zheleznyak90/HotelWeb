<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="roomOverview">

	<div class="room" id="${pattern.id}" onClick="OfferRoom(this)">
		<div id="slider1_container">
			<div u="slides" id="slider">
				<c:forEach var="photo" items="${photoGallery}">
					<div>
						<img u="image" class="galleryImage"
							src="${pattern.photoSetPath}${photo}" />
					</div>
				</c:forEach>
				<!-- Arrow Left -->
				<span u="arrowleft" class="jssora01l" style="top: 123px; left: 8px;">
				</span>
				<!-- Arrow Right -->
				<span u="arrowright" class="jssora01r"
					style="top: 123px; right: 8px;"> </span>
			</div>

		</div>
		<c:choose>
			<c:when test="${not empty User}">
				<div class="roomOffer">
					<a class="offerBtn" onClick="OfferRoom">Offer for 
					<br>${pattern.price}&#36 rate  </a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="price">
					Rates from:<br> &#36; <span class="roomRateSort"> <c:out
							value="${pattern.price}"></c:out>
					</span> USD
				</div>
			</c:otherwise>
		</c:choose>

		<div class="roomInfo">
			<div class="description">
				<c:out value="${pattern.description }"></c:out>
			</div>
			<div class="roomClass">
				Class: <span class="roomClassSort"
					id="classId_${pattern.aClass.id }"><c:out
						value="${pattern.aClass.aClass }"></c:out> </span>
			</div>
			<div class="size">
				Number of person: <span class="roomCapacitySort"><c:out
						value="${pattern.size }"></c:out> </span>
			</div>

		</div>

	</div>

</div>
<script src="<c:url value="/view/js/roomPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jssor.js" />"></script>
<script src="<c:url value="/jslib/jssor.slider.js" />"></script>
