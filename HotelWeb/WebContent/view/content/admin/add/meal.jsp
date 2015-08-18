<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightPanel">

	<div id="errorMsg"></div>
	<div title="meal">

		<form id="form_request" method="post" action="MealAddProc">
			<table>
				<tr>
					<td>Meal Name:</td>
					<td><input type="text" class="unique" name="name"
						maxlength="50" required></td>
					<td>*</td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="number" step="0.01" name="price" min=0 max=100 required></td>
					<td>*</td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><textarea cols="40" rows="5" name="description"
							maxlength="500"></textarea></td>
				</tr>
				<tr>
					<td>Is active:</td>
					<td><input type="checkbox" name="isActive" value="active"></td>
				</tr>
			</table>
			<input type="submit" value="Create new meal">


		</form>
	</div>
</div>
