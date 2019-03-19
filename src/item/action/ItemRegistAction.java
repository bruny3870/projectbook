package item.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import item.svc.ItemRegistSvc;
import vo.ActionForward;
import vo.ItemBean;

public class ItemRegistAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]ItemRegistAction");
		ActionForward forward = null;
		ItemRegistSvc itemRegistSvc = new ItemRegistSvc();
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("it_img");
		ItemBean item = new ItemBean(
				multi.getParameter("it_code"), 
				multi.getParameter("it_name"), 
				multi.getParameter("it_category"), 
				multi.getParameter("it_author"), 
				multi.getParameter("it_isbn"), 
				multi.getParameter("it_publisher"), 
				multi.getParameter("it_pubdate"), 
				Integer.parseInt(multi.getParameter("it_price")), 
				multi.getParameter("it_content"), 
				image, 
				0);
		boolean isRegistSuccess = itemRegistSvc.registItem(item);
		
		if(isRegistSuccess) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./itemList.it");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('false');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}
}
