package member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.MemberListSvc;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ActionForward forward = null;
		System.out.println("[2]MemberList");
		
		if((session.getAttribute("id")==null) || (!((String)session.getAttribute("id")).equals("admin"))) {
			out.println("<script>");
			out.println("alert('관리자로 로그인하세요');");
			out.println("location.href='main.jsp';");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("/admin/member_list.jsp");
			System.out.println("setPath : "+forward.getPath());
		}
		
		MemberListSvc memberlist = new MemberListSvc();
		ArrayList<MemberBean> list = memberlist.getMemberList();
		request.setAttribute("list", list);
		
		return forward;
	}
}
