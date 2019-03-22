package item.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.ItemDAO;
import vo.ItemBean;

public class ItemModFormSvc {
	public ItemBean getItem(String it_code) {
		System.out.println("[3]ItemModFormSvc");
		ItemDAO itemDAO = ItemDAO.getInstance();
		Connection con = getConnection();
		itemDAO.setConnection(con);
		ItemBean item = itemDAO.selectItem(it_code);
		close(con);
		return item;
	}
}
