

<form id="form_registr" method="post" action="Registration">
	<table>
		<tr>
			<td>Email </td>
			<td><input type="email" name="email" data-validate="required,email"> *</td>
		</tr>
		<tr>
			<td>Password </td>
			<td><input type="password" name="password" data-validate="required,size(4,20)"> *</td>
		</tr>
		<tr>
			<td>First Name </td>
			<td><input type="text" name="fName" data-validate="required,size(2,30)"> *</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lName" data_validate="size(2,30)"></td>
		</tr>
		<tr>
			<td>Patronymic</td>
			<td><input type="text" name="patronymic" data_validate="size(2,30)"></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><input type="text" name="phone" data-validate="required"></td>
		</tr>
	</table>
	<input type="submit" value="Registrate">
</form>