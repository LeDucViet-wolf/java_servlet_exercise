<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Customer</title>
</head>
<body>
	<div>
		<h1>Insert Customer</h1>
		<h3>${ error }</h3>
		<form action="InsertCustomer" method="POST">
			<table>
				<tr>
					<td>Tên tài khoản:</td>
					<td><input type="text" name="CustomerName" /></td>
				</tr>
				<tr>
					<td>Giới tính:</td>
					<td>
					<input type="radio" name="Gender" value="true" /> Male
					<input type="radio" name="Gender" value="false" /> Female
					</td>
				</tr>
				<tr>
					<td>Ngày sinh:</td>
					<td><input type="date" name="Birthday" /></td>
				</tr>
				<tr>
					<td>Địa chỉ:</td>
					<td><input type="text" name="Address" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="Email" /></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<td><input type="text" name="Telephone" /></td>
				</tr>
				<tr>
					<td>Trạng thái:</td>
					<td>
					<input type="radio" name="Status" value="true" /> Active
					<input type="radio" name="Status" value="false" /> Not Active
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="Insert" /> 
					<input type="reset" name="Clear" />
					</td>
				</tr>
			</table>
		</form>
		<a href="index.jsp">Back</a>
	</div>
</body>
</html>