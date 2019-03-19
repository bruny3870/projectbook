package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class LogoutAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LogoutAction");
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		session.invalidate();
		
		forward.setRedirect(true);
		forward.setPath("/projecttest/main.jsp");
		
		return forward;
	}
}
