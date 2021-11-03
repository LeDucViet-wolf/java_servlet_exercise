package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.CustomerDAOImpl;
import entity.Customer;

/**
 * Servlet implementation class InsertCustomer
 */
@WebServlet("/InsertCustomer")
public class InsertCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertCustomer() {
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
		String customerName = request.getParameter("CustomerName");
		String gender = request.getParameter("Gender");
		String birthday = request.getParameter("Birthday");
		String address = request.getParameter("Address");
		String email = request.getParameter("Email");
		String telephone = request.getParameter("Telephone");
		String status = request.getParameter("Status");

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayToDate = null;
		try {
			birthdayToDate = sf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean genderToBoolean = Boolean.parseBoolean(gender);
		boolean statusToBoolean = Boolean.parseBoolean(status);

		Customer c = new Customer();
		c.setCustomerName(customerName);
		c.setGender(genderToBoolean);
		c.setBirthday(birthdayToDate);
		c.setAddress(address);
		c.setEmail(email);
		c.setTelephone(telephone);
		c.setStatus(statusToBoolean);

		boolean validatePhone = new CustomerDAOImpl().validatePhone(telephone, "");
		boolean validateEmail = new CustomerDAOImpl().validateEmail(email, "");

		if (validateEmail) {
			request.setAttribute("error", "Insert failed! Your email is exist!");
			request.getRequestDispatcher("insertCustomer.jsp").forward(request, response);
		} else if (validatePhone) {
			request.setAttribute("error", "Insert failed! Your phone is exist!");
			request.getRequestDispatcher("insertCustomer.jsp").forward(request, response);
		} else {
			boolean bl = new CustomerDAOImpl().insertCustomer(c);
			if (bl) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Insert failed!");
				request.getRequestDispatcher("insertCustomer.jsp").forward(request, response);
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
