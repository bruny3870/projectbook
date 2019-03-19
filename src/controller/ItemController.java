package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import item.action.ItemListAction;
import item.action.ItemRegistAction;
import vo.ActionForward;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("*.it")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;
		System.out.println("[1]command : " + command);

		if (command.equals("/itemList.it")) {
			System.out.println("[1]itemList.it");
			action = new ItemListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]itemList.it error");
				e.printStackTrace();
			}
		}
		if (command.equals("/itemRegist.it")) {
			System.out.println("[1]itemRegist.it");
			action = new ItemRegistAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]itemRegist.it error");
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
