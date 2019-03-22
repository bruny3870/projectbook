package item.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ItemDAO;
import vo.ItemBean;

public class ItemRegistSvc {
	public boolean registItem(ItemBean item) {
		System.out.println("[3]ItemRegistSvc");
		ItemDAO itemDAO = ItemDAO.getInstance();
		Connection con = getConnection();
		itemDAO.setConnection(con);
		boolean isRegistSuccess = false;
		int insertCount = itemDAO.insertItem(item);
		if(insertCount > 0) {
			commit(con);
			isRegistSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isRegistSuccess;
	}
}
