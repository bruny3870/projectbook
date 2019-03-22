package item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import item.svc.ItemModFormSvc;
import vo.ActionForward;
import vo.ItemBean;

public class ItemModFormAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]ItemModFormAction");
		ActionForward forward = null;
		forward = new ActionForward();
		String it_code = request.getParameter("it_code");
		ItemModFormSvc itemModFormSvc = new ItemModFormSvc();
		ItemBean item = itemModFormSvc.getItem(it_code);
		request.setAttribute("item", item);
		request.setAttribute("old_code", it_code);
		forward = new ActionForward();
		forward.setPath("/admin/itemModify.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
