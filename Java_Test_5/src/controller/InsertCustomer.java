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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String customerName = request.getParameter("customerName");
		String strGender = request.getParameter("gender");
		String strBirthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String strStatus = request.getParameter("status");

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = sf.parse(strBirthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean gender = Boolean.parseBoolean(strGender);
		boolean status = Boolean.parseBoolean(strStatus);
		
		boolean validateTelephone = new CustomerDAOImpl().validateTelephone(telephone);
		boolean validateEmail = new CustomerDAOImpl().validateEmail(email);
		
	

		Customer c = new Customer();
		c.setCustomerName(customerName);
		c.setGender(gender);
		c.setBirthday(birthday);
		c.setAddress(address);
		c.setEmail(email);
		c.setTelephone(telephone);
		c.setStatus(status);
		
		boolean bl = new CustomerDAOImpl().insertCustomer(c);
		if (validateEmail || validateTelephone) {
			request.setAttribute("message", "Insert failed!");
			request.getRequestDispatcher("insertCustomer.jsp").forward(request, response);
		}else {
			if (bl) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Insert failed!");
				request.getRequestDispatcher("insertCustomer.jsp").forward(request, response);
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
