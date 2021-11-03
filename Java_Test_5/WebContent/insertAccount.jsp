<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Account</title>
</head>
<body>
	<div>
		<h1>Insert Account</h1>
		<h3>${ error }</h3>
		<form action="InsertAccount" method="POST">
			<table>
				<tr>
					<td>Mã tài khoản:</td>
					<td><input type="text" name="AccountNumber" /></td>
				</tr>
				<tr>
					<td>Mật khẩu:</td>
					<td><input type="password" name="Password" /></td>
				</tr>
				<tr>
					<td>Số dư:</td>
					<td><input type="text" name="Balance" /></td>
				</tr>
				<tr>
					<td>Trạng thái:</td>
					<td>
					<input type="radio" name="Status" value="true" /> Active
					<input type="radio" name="Status" value="false" /> Not Active
					</td>
				</tr>
				<tr>
					<td>Người dùng:</td>
					<td>
						<select name="CustomerId">
							<c:forEach items="${list}" var="c">
									<option value="${c.customerId}">${c.customerName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="Insert" /> <input type="reset"
						name="Clear" /></td>
				</tr>
			</table>
		</form>
		<a href="index.jsp">Back</a>
	</div>
</body>
</html>