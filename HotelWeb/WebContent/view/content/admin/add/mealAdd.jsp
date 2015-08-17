<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<form id="form_request" method="post" action="admin/AddMeal">
		<table>
			<tr>
				<td>Meal Name:</td>
				<td><input type="text" name="name" maxlength="50"> *</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" min=0 max=100> *</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><textarea cols="40" rows="5" name="Description" maxlength="500"></textarea>
				</td>
			</tr>
			<tr>
				<td>Is active:</td>
				<td><input type="checkbox" name="isActive"></td>
			</tr>
		</table>
		<input type="submit" value="Create new meal">

	</form>

</div>
