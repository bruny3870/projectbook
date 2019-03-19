package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import member.svc.DeleteSvc;
import vo.ActionForward;

public class DeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]DeleteAction");
		ActionForward forward = null;
		DeleteSvc deletesvc = new DeleteSvc();
		int deleteCount;
		HttpSession session = request.getSession();
		if (session.getAttribute("id") != null) {
			deleteCount = deletesvc.deletesvc(request.getParameter("id"));
			if(deleteCount > 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('Å»ÅðµÇ¾ú½À´Ï´Ù.');");
				if(session.getAttribute("id").equals("admin")) {
				forward = new ActionForward();
				forward.setPath("/Projecttest/admingetlist.mem");
				forward.setRedirect(true);
			} else {
				out.println("location.href='logout.me';");
			}
				out.println("</script>");
			}
		}
		return forward;
	}
}
