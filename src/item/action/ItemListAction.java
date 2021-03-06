
package item.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import item.svc.ItemListSvc;
import vo.ActionForward;
import vo.ItemBean;
import vo.PageInfo;

public class ItemListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]ItemListAction");
		ArrayList<ItemBean> itemList = new ArrayList<ItemBean>();
		
		int page = 1;
		int limit = 10;
		int limitPage = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ItemListSvc itemListSvc = new ItemListSvc();
		int listCount = itemListSvc.getListCount();
		itemList = itemListSvc.getItemList(page, limit);
		int maxPage = (int)((double)listCount / limit + 0.95);
		int startPage = (((int)((double)page / limitPage + 0.9)) - 1) * limitPage + 1;
		int endPage = startPage + limitPage - 1;
		if(endPage > maxPage)
			endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("itemList", itemList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/admin/itemList.jsp");
		return forward;
		
	}
}
