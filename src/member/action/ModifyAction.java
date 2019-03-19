package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.ModifySvc;
import vo.ActionForward;
import vo.MemberBean;

public class ModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]ModifyAction");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		ActionForward forward = null;
		String id = request.getParameter("id");
		System.out.println("Parameter "+id);
		ModifySvc modifysvc = null;
		
		if(session.getAttribute("id") != null) {
			modifysvc = new ModifySvc();
			MemberBean member = new MemberBean();
			member.setMem_id(id);
			member.setMem_pw(request.getParameter("pw"));
			member.setMem_name(request.getParameter("name"));
			member.setMem_phone(request.getParameter("phone"));
			member.setMem_gender(request.getParameter("gender"));
			member.setMem_email(request.getParameter("email"));
			member.setMem_zip(request.getParameter("zip"));
			member.setMem_addr1(request.getParameter("addr1"));
			member.setMem_addr2(request.getParameter("addr2"));
			modifysvc.modifysvc(member);
			
			forward = new ActionForward();
			forward.setPath("/main.jsp");
			System.out.println("setPath "+forward.getPath());
		} else {
			out.println("<script>");
			out.println("alert('로그인 하세요!!')");
			out.println("location.href='/main.jsp'");
			out.println("</script>");
		}
		return forward;
	}
}
