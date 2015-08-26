<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<style scoped>
	@import url("http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css");

  </style>
	<ul class="nav nav-tabs">
		<li class="active"><a href="accManagment"><fmt:message key="acc" /></a>
		</li>
		<li><a href="MyOrders"><fmt:message key="myOrders" /></a>
		</li>


	</ul>
	<table>
		<tr>
			<td><fmt:message key="changeName" /></td>
			<td><input>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="changePNumber" /></td>
			<td><input>
			</td>
		</tr>
	</table>


</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

