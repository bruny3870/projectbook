package member.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.LoginSvc;
import vo.ActionForward;
import vo.MemberBean;

public class LoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]LoginAction");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		ActionForward forward = null;
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		member.setMem_id(request.getParameter("id"));
		member.setMem_pw(request.getParameter("pw"));
		LoginSvc loginsvc = new LoginSvc();
		boolean selectId = loginsvc.Login(member);
		
		if(!selectId) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디나 비밀번호가 일치하지 않습니다.')");
			out.println("location.href='./member/login.jsp'");
			out.println("</script>");
		} else {
			session.setAttribute("id", request.getParameter("id"));
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/main.jsp");
		}
		return forward;
	}
}