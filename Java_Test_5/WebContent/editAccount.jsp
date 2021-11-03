<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Account</title>
</head>
<body>
<div>
		<h1>Insert Account</h1>
		<h3>${ error }</h3>
		<form action="SaveAccount" method="POST">
			<input type="hidden" name="AccountId" value="${ a.accountId }" />
			<table>
				<tr>
					<td>Mã tài khoản:</td>
					<td><input type="text" name="AccountNumber" value="${ a.accountNumber }" /></td>
				</tr>
				<tr>
					<td>Mật khẩu:</td>
					<td><input type="password" name="Password" value="${ a.password }" /></td>
				</tr>
				<tr>
					<td>Số dư:</td>
					<td><input type="text" name="Balance" value="${ a.balance }" /></td>
				</tr>
				<tr>
					<td>Trạng thái:</td>
					<td>
						<c:if test="${a.status == true}">
							<input type="radio" name="Status" value="true" checked /> Active
							<input type="radio" name="Status" value="false" /> Not Active
						</c:if>
						<c:if test="${a.status == false}">
							<input type="radio" name="Status" value="true" /> Active
							<input type="radio" name="Status" value="false" checked /> Not Active
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Người dùng:</td>
					<td>
						<select name="CustomerId">
							<c:forEach items="${list}" var="c">
								<c:if test="${c.customerId == a.customerId}">
									<option value=${c.customerId} selected>${c.customerName}</option>
								</c:if>
								<c:if test="${c.customerId != a.customerId}">
									<option value=${c.customerId}>${c.customerName}</option>
								</c:if>
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