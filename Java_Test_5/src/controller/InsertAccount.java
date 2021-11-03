package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.AccountDAOImpl;
import dao.impl.CustomerDAOImpl;
import entity.Account;
import entity.Customer;

/**
 * Servlet implementation class InsertAccount
 */
@WebServlet("/InsertAccount")
public class InsertAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String accountNumber = request.getParameter("AccountNumber");
		String password = request.getParameter("Password");
		String balance = request.getParameter("Balance");
		String status = request.getParameter("Status");
		String customerId = request.getParameter("CustomerId");

		float balanceToFloat = Float.parseFloat(balance);
		int customerIdToInt = Integer.parseInt(customerId);
		boolean statusToBoolean = Boolean.parseBoolean(status);

		Date createdDate = new Date();

		Account a = new Account();
		a.setAccountNumber(accountNumber);
		a.setPassword(password);
		a.setBalance(balanceToFloat);
		a.setCustomerId(customerIdToInt);
		a.setStatus(statusToBoolean);
		a.setCreateDate(createdDate);

		boolean validateCustomerId = new CustomerDAOImpl().validateCustomerId(customerId, "");

		List<Customer> listCustomer = new CustomerDAOImpl().getListCustomer();
		request.setAttribute("list", listCustomer);

		if (validateCustomerId) {
			request.setAttribute("error", "Customer id is duplicated!");
			request.getRequestDispatcher("insertAccount.jsp").forward(request, response);
		} else {
			boolean bl = new AccountDAOImpl().insertAccount(a);
			if (bl) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Insert failed!");
				request.getRequestDispatcher("insertAccount.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
