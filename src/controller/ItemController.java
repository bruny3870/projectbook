package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import item.action.ItemDeleteAction;
import item.action.ItemListAction;
import item.action.ItemModFormAction;
import item.action.ItemModifyAction;
import item.action.ItemRegistAction;
import item.action.ItemViewAction;
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
		if (command.equals("/itemRegistFrom.it")) {
			System.out.println("[1]itemRegistFrom.it");
			forward = new ActionForward();
			forward.setPath("/admin/itemRegist.jsp");
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
		
		if (command.equals("/itemView.it")) {
			System.out.println("[1]itemView.it");
			action = new ItemViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]itemView.it error");
				e.printStackTrace();
			}
		}

		else if (command.equals("/itemModForm.it")) {
			System.out.println("[1]itemModForm.it");
			action = new ItemModFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]itemModForm.it error");
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/itemModify.it")) {
			System.out.println("[1]itemModify.it");
			action = new ItemModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]itemModify.it error");
				e.printStackTrace();
			}
		}
		
		else if (command.equals("/itemDelete.it")) {
			System.out.println("[1]itemDelete.it");
			action = new ItemDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]itemDelete.it error");
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
