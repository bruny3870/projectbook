package item.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import item.svc.ItemModifySvc;
import vo.ActionForward;
import vo.ItemBean;

public class ItemModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("[2]ItemModifyAction");
		ActionForward forward = null;
		ItemModifySvc itemModifySvc = new ItemModifySvc();
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "UTF-8";
		int fileSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, encType, new DefaultFileRenamePolicy());
		
		String image = multi.getFilesystemName("it_img");
		String it_code = multi.getParameter("id_code");
		
		if(multi.getFilesystemName("it_img")==null) {
			image = multi.getParameter("oldImage");
		}
		ItemBean item = new ItemBean(
				it_code, 
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
		boolean isModifySuccess = itemModifySvc.updateItem(item, multi.getParameter("old_code"));
		if(!isModifySuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('error');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("./itemView.it?it_code");
			forward.setRedirect(false);
		}
		return forward;
	}
}
