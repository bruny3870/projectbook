package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.InfoSvc;
import vo.ActionForward;
import vo.MemberBean;

public class InfoAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]InfoAction");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='./member/Login.me?turn=ok';");
			out.println("</script>");
		} else {
			InfoSvc infosvc = new InfoSvc();
			MemberBean member = infosvc.Info(id);
			request.setAttribute("member", member);
			forward = new ActionForward();
			request.setAttribute("id", id);
			forward.setPath("/member/info.jsp");
		}
		return forward;
	}
}
