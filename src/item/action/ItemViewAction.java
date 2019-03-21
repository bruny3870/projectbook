package item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import item.svc.ItemViewSvc;
import vo.ActionForward;
import vo.ItemBean;

public class ItemViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]ItemViewAction");
		String it_code = request.getParameter("it_code");
		ItemViewSvc itemViewSvc = new ItemViewSvc();
		ItemBean item = itemViewSvc.getItemView(it_code);
		request.setAttribute("item", item);
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/itemView.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
