package item.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import item.svc.ItemDeleteSvc;
import vo.ActionForward;

public class ItemDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]ItemDeleteAction");
		ActionForward forward = null;
		ItemDeleteSvc itemDeleteSvc = new ItemDeleteSvc();
		String codes[];
		String it_code;
		int deleteCount = 0;
		it_code = request.getParameter("it_code");
		
		if(it_code == null) {
			codes = request.getParameterValues("icheck");
			for(int i=0;i<codes.length;i++) {
				deleteCount = itemDeleteSvc.deleteItem(codes[i]);
			}
		} else {
			deleteCount = itemDeleteSvc.deleteItem(it_code);
		}
		
		if(deleteCount == 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('error');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("/itemList.it");
			forward.setRedirect(false);
		}
		return forward;
	}
}
