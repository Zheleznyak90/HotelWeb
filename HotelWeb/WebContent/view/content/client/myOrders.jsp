<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<div>

	<ul class="nav nav-tabs">
		<style scoped>
@import
	url("http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css");
</style>
		<li><a href="accManagment">Account</a>
		</li>
		<li class="active"><a href="MyOrders">My orders</a>
		</li>
	</ul>
	<div>
		<jsp:useBean id="tomorrow" class="java.util.Date" />
		<jsp:setProperty name="tomorrow" property="time"
			value="${tomorrow.time + 86400000}" />

		<c:forEach var="currOrder" items="${orders}">
			<div class="order" id="${currOrder.id}">
				<div class="left">
					<div class="manager">
						Your manager : <span>${currOrder.manager.email}</span>
					</div>
					<div class="orderInfo">
						<div class="orderInfoItem">
							Meal: <span>${currOrder.meal.name }</span>
						</div>
						<div class="orderInfoItem">
							Check In: <span>${currOrder.checkInDate}</span>
						</div>
						<div class="orderInfoItem">
							Check Out: <span>${currOrder.checkOutDate}</span>
						</div>
					</div>
					<div class="status">
						<div class="orderInfoItem">

							Order status: <span>${currOrder.status.status}</span>
						</div>
						<c:if
							test="${currOrder.status.status eq 'pending' && currOrder.checkInDate.time>tomorrow.time}">
							<div class="orderInfoItem">
								<button onClick="changeBooking(this,'Confirm')">Confirm</button>
							</div>
						</c:if>

						<c:if
							test="${(currOrder.status.status eq 'confirmed' || currOrder.status.status eq 'unconfirmed') && currOrder.checkInDate.time>tomorrow.time}">
							<div class="orderInfoItem">
								<button onClick="changeBooking(this,'Cancel')">Cancel</button>
							</div>
						</c:if>
						<script src="<c:url value="view/js/orders.js" />"></script>
					</div>
				</div>
				<div class="total">Total price is: ${currOrder.price}</div>

			</div>


		</c:forEach>
	</div>



</div>
<script src="<c:url value="/view/js/orders.js" />" type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
