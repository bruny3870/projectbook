package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.svc.JoinSvc;
import vo.ActionForward;
import vo.MemberBean;

public class JoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]JoinAction");
		MemberBean member = new MemberBean();
		member.setMem_id(request.getParameter("id"));
		member.setMem_pw(request.getParameter("pw"));
		member.setMem_name(request.getParameter("name"));
		member.setMem_phone(request.getParameter("phone"));
		member.setMem_gender(request.getParameter("gender"));
		member.setMem_email(request.getParameter("email"));
		member.setMem_zip(request.getParameter("zip"));
		member.setMem_addr1(request.getParameter("addr1"));
		member.setMem_addr2(request.getParameter("addr2"));
		ActionForward forward = null;
		JoinSvc joinsvc = new JoinSvc();
		int insertId = joinsvc.Join(member);

		if (insertId > 0) {
			forward = new ActionForward();
			forward.setPath("/projecttest/login.me");
			forward.setRedirect(true);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입에 실패했습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}
		System.out.println("insertId : " + insertId);
		return forward;
	}
}