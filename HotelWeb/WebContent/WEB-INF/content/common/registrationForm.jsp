<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form id="form_registr" method="post" action="Registration">
	<table>
		<tr>
			<td>Email </td>
			<td><input type="email" name="email" required> *</td>
		</tr>
		<tr>
			<td><fmt:message key="pass" /> </td>
			<td><input type="password" name="password" pattern=".{4,30}" required> *</td>
		</tr>
		<tr>
			<td><fmt:message key="name" /> </td>
			<td><input type="text" name="fName" pattern=".{2,30}" required> *</td>
		</tr>
		<tr>
			<td><fmt:message key="pNumber" /></td>
			<td><input type="text" name="phone"></td>
		</tr>
	</table>
	<input type="submit" value="<fmt:message key="registration" />">
</form>