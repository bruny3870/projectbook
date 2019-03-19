
package item.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ItemDAO;
import vo.ItemBean;

public class ItemViewSvc {
	public ItemBean getItemView(String it_code) {
		System.out.println("[3]ItemViewSvc");
		Connection con = getConnection();
		ItemDAO itemDAO = ItemDAO.getInstance();
		itemDAO.setConnection(con);
		int updateCount = itemDAO.UpdateCount(it_code);
		if (updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		ItemBean item = itemDAO.SelectItem(it_code);
		close(con);
		return item;
	}
}
