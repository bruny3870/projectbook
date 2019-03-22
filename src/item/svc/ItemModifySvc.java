package item.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.ItemDAO;
import vo.ItemBean;

public class ItemModifySvc {
	public boolean updateItem(ItemBean item, String it_code) {
		ItemDAO itemDAO = ItemDAO.getInstance();
		Connection con = getConnection();
		itemDAO.setConnection(con);
		boolean isModifySuccess = false;
		int updateCount = itemDAO.updateItem(item, it_code);
		if(updateCount > 0) {
			if(!item.getIt_code().equals(it_code)) {
				commit(con);
				isModifySuccess = true;
			} else {
				commit(con);
				isModifySuccess = true;
			}
		} else {
			rollback(con);
		}
		close(con);
		return isModifySuccess;
	}
}
