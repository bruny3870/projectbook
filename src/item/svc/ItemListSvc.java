
package item.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.ItemDAO;
import vo.ItemBean;

public class ItemListSvc {
	
	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		ItemDAO itemDAO = ItemDAO.getInstance();
		itemDAO.setConnection(con);
		listCount = itemDAO.SelectListCount();
		close(con);
		return listCount;
	}

	public ArrayList<ItemBean> getItemList(int page, int limit) throws Exception {
		System.out.println("[3]ItemListSvc");
		ItemDAO itemDAO = ItemDAO.getInstance();
		Connection con = getConnection();
		itemDAO.setConnection(con);
		ArrayList<ItemBean> itemList = itemDAO.SelectItemList(page, limit);
		close(con);
		return itemList;
	}

}
