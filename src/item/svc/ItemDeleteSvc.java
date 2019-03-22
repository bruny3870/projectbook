package item.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.ItemDAO;

public class ItemDeleteSvc {
	public int deleteItem(String it_code) {
		System.out.println("[3]ItemDeleteSvc");
		ItemDAO itemDAO = ItemDAO.getInstance();
		Connection con = getConnection();
		itemDAO.setConnection(con);
		int deleteCount = itemDAO.deleteItem(it_code);
		if(deleteCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return deleteCount;
	}
}
