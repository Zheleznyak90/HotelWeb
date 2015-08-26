<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form id="form_auth" method="post" action="UserValidation">
	<table>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td><fmt:message key="pass" /></td>
			<td><input type="password" name="password"></td>
		</tr>
	</table>
	<input type="submit" value="Log In">
</form>