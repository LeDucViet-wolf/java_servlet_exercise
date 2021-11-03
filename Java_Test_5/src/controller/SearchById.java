package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ViewModelDAOImpl;
import entity.ViewModel;

/**
 * Servlet implementation class SearchById
 */
@WebServlet("/SearchById")
public class SearchById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchById() {
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
		String strId = request.getParameter("searchId");
		List<ViewModel> listViewModel;
		if (strId == "") {
			listViewModel = new ViewModelDAOImpl().getListViewModel();
		}else {
			int searchId = Integer.parseInt(strId);
			listViewModel = new ViewModelDAOImpl().SearchById(searchId);
			request.setAttribute("searchId", searchId);
		}
		request.setAttribute("list", listViewModel);
		request.getRequestDispatcher("listViewModel.jsp").forward(request, response);
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
