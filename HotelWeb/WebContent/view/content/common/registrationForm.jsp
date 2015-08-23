

<form id="form_registr" method="post" action="Registration">
	<table>
		<tr>
			<td>Email </td>
			<td><input type="email" name="email" required> *</td>
		</tr>
		<tr>
			<td>Password </td>
			<td><input type="password" name="password" pattern=".{4,30}" required> *</td>
		</tr>
		<tr>
			<td>First Name </td>
			<td><input type="text" name="fName" pattern=".{2,30}" required> *</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lName" pattern=".{2,30}"></td>
		</tr>
		<tr>
			<td>Patronymic</td>
			<td><input type="text" name="patronymic" pattern=".{2,30}"></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><input type="text" name="phone"></td>
		</tr>
	</table>
	<input type="submit" value="Registrate">
</form>