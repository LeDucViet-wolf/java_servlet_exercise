<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer</title>
</head>
<body>
<div>
		<h1>Edit Customer</h1>
		<h3>${ error }</h3>
		<form action="SaveCustomer" method="POST">
			<input type="hidden" name="CustomerId" value="${ c.customerId }" />
			<table>
				<tr>
					<td>Tên tài khoản:</td>
					<td><input type="text" name="CustomerName" value="${ c.customerName }" /></td>
				</tr>
				<tr>
					<td>Giới tính:</td>
					<td>
						<c:if test="${c.gender == true}">
							<input type="radio" name="Gender" value="true" checked /> Male
							<input type="radio" name="Gender" value="false" /> Female
						</c:if>
						<c:if test="${c.gender == false}">
							<input type="radio" name="Gender" value="true" /> Male
							<input type="radio" name="Gender" value="false" checked /> Female
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Ngày sinh:</td>
					<td><input type="date" name="Birthday" value="${ c.birthday }" /></td>
				</tr>
				<tr>
					<td>Địa chỉ:</td>
					<td><input type="text" name="Address" value="${ c.address }" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="Email" value="${ c.email }" /></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<td><input type="text" name="Telephone" value="${ c.telephone }" /></td>
				</tr>
				<tr>
					<td>Trạng thái:</td>
					<td>
						<c:if test="${c.status == true}">
							<input type="radio" name="Status" value="true" checked /> Active
							<input type="radio" name="Status" value="false" /> Not Active
						</c:if>
						<c:if test="${c.status == false}">
							<input type="radio" name="Status" value="true" /> Active
							<input type="radio" name="Status" value="false" checked /> Not Active
						</c:if>
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