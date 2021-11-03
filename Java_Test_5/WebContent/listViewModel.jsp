<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List VIEW MODEL</title>
</head>
<style type="text/css">
.center {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
<body>
	<div class="center">
		<h1>LIST VIEW MODEL</h1>
		<c:if test="${empty list}">
			<h3 style="color: red">No Data</h3>
		</c:if>
		<c:if test="${not empty list}">
			<table border="1">
				<tr>
					<th>Mã Tài Khoản</th>
					<th>Họ tên khách hàng</th>
					<th>Giới tính</th>
					<th>Ngày sinh</th>
					<th>Địa chỉ</th>
					<th>Số tài khoản</th>
					<th>Ngày tạo</th>
					<th>Số dư</th>
					<th></th>
				</tr>
				<c:forEach items="${list}" var="vm">
					<tr>
						<td>
						<c:if test="${vm.accountId != 0}">${vm.accountId}</c:if>
						</td>
						<td>${vm.customerName}</td>
						<td>${vm.gender?"Male":"Female"}</td>
						<td><fmt:formatDate value="${vm.birthday}"
								pattern="dd/MM/yyyy" /></td>
						<td>${vm.address}</td>
						<td>${vm.accountNumber}</td>
						<td><fmt:formatDate value="${vm.createDate}"
								pattern="dd/MM/yyyy" /></td>
						<td>${vm.balance}</td>
						<td>
							<c:if test="${ vm.customerId != 0}">
								<a href="EditCustomer?CustomerId=${ vm.customerId }">Edit Customer</a>
							</c:if>
							<c:if test="${ vm.accountId != 0}">
								<a href="EditAccount?AccountId=${ vm.accountId }">Edit Account</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="insertCustomer.jsp">Add New Customer</a>
		<a href="AccountForm">Add New Account</a>
	</div>
</body>
</html>