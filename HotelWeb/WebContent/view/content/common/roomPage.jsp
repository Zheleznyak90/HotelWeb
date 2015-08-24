<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="roomOverview">
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

</div>
<script src="<c:url value="/view/js/roomPage.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/jslib/jssor.js" />"></script>
<script src="<c:url value="/jslib/jssor.slider.js" />"></script>
