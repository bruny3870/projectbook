package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.action.DeleteAction;
import member.action.InfoAction;
import member.action.JoinAction;
import member.action.LoginAction;
import member.action.LogoutAction;
import member.action.MemberListAction;
import member.action.ModifyAction;
import vo.ActionForward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
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

		if (command.equals("/join.me")) {
			System.out.println("[1]join.me");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("member/join.jsp");

		} else if (command.equals("/login.me")) {
			System.out.println("[1]login.me");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("member/login.jsp");

		} else if (command.equals("/joinProcess.me")) {
			System.out.println("[1]joinProcess.me");
			action = new JoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]joinProcess.me error");
				e.printStackTrace();
			}

		} else if (command.equals("/loginProcess.me")) {
			System.out.println("[1]loginProcess.me");
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]loginProcess.me error");
				e.printStackTrace();
			}

		} else if (command.equals("/logout.me")) {
			System.out.println("[1]logout.me");
			action = new LogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/info.me")) {
			System.out.println("[1]info.me");
			action = new InfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]info.me error");
				e.printStackTrace();
			}
		} else if (command.equals("/modify.me")) {
			System.out.println("[1]modify.me");
			action = new ModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]modify.me error");
				e.printStackTrace();
			}
		} else if (command.equals("/delete.me")) {
			System.out.println("[1]delete.me");
			action = new DeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]delete.me error");
				e.printStackTrace();
			}
		} else if (command.equals("memberlist.me")) {
			System.out.println("[1]memberlist.me");
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("[1]memberlist.me error");
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