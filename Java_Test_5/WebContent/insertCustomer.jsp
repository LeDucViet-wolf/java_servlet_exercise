<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.center {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<div class="center">
		<h1>ADD NEW CUSTOMER</h1>
		<h3 style="color:red">${message}</h3>
		<form action="InsertCustomer" method="post">
			<table border="1">
				<tr>
					<td>Tên Khách Hàng:</td>
					<td><input type="text" name="customerName" /></td>
				</tr>
				<tr>
					<td>Giới tính:</td>
					<td><input type="radio" name="gender" value="true" />Nam <input
						type="radio" name="gender" value="false" />Nữ</td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input type="date" name="birthday" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address"></input></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"></input></td>
				</tr>
				<tr>
					<td>TelePhone:</td>
					<td><input type="text" name="telephone"></input></td>
				</tr>
				<tr>
					<td>Giới tính:</td>
					<td><input type="radio" name="status" value="true" />Hoạt động <input
						type="radio" name="status" value="false" />Không hoạt động</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Thêm" />
						<input type="reset" value="Làm mới" />
					</td>
				</tr>
			</table>
		</form>
		<a href="index.jsp">Back</a>
	</div>
</body>
</html>