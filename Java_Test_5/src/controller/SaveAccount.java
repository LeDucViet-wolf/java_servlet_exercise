package controller;

import java.io.IOException;
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
 * Servlet implementation class SaveAccount
 */
@WebServlet("/SaveAccount")
public class SaveAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String accountId = request.getParameter("AccountId");
		String accountNumber = request.getParameter("AccountNumber");
		String password = request.getParameter("Password");
		String balance = request.getParameter("Balance");
		String status = request.getParameter("Status");
		String customerId = request.getParameter("CustomerId");

		float balanceToFloat = Float.parseFloat(balance);
		int customerIdToInt = Integer.parseInt(customerId);
		int accountIdToInt = Integer.parseInt(accountId);
		boolean statusToBoolean = Boolean.parseBoolean(status);

		Date createdDate = new Date();

		Account a = new Account();
		a.setAccountNumber(accountNumber);
		a.setPassword(password);
		a.setBalance(balanceToFloat);
		a.setCustomerId(customerIdToInt);
		a.setStatus(statusToBoolean);
		a.setCreateDate(createdDate);
		a.setAccountId(accountIdToInt);

		boolean validateCustomerId = new CustomerDAOImpl().validateCustomerId(customerId, accountId);

		List<Customer> listCustomer = new CustomerDAOImpl().getListCustomer();
		request.setAttribute("list", listCustomer);

		if (validateCustomerId) {
			request.setAttribute("error", "Customer id is duplicated!");
			Account accountById = new AccountDAOImpl().getAccountById(accountIdToInt);
			request.setAttribute("a", accountById);
			request.getRequestDispatcher("editAccount.jsp").forward(request, response);
		} else {
			boolean bl = new AccountDAOImpl().saveAccount(a);
			if (bl) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Update failed!");
				request.getRequestDispatcher("editAccount.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
