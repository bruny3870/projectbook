package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.ItemBean;

public class ItemDAO {
	DataSource ds;
	Connection con;

	private static ItemDAO itemDAO;

	private ItemDAO() {
	}

	public static ItemDAO getInstance() {
		if (itemDAO == null) {
			itemDAO = new ItemDAO();
		}
		return itemDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int selectListCount() {
		System.out.println("[4]ItemDAO.selectListCount");
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM item");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("selectListCount error");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	public int insertItem(ItemBean item) {
		System.out.println("[4]ItemDAO.insertItem");
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		try {
			sql = "INSERT INTO item VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item.getIt_code());
			pstmt.setString(2, item.getIt_name());
			pstmt.setString(3, item.getIt_category());
			pstmt.setString(4, item.getIt_author());
			pstmt.setString(5, item.getIt_isbn());
			pstmt.setString(6, item.getIt_publisher());
			pstmt.setString(7, item.getIt_pubdate());
			pstmt.setInt(8, item.getIt_price());
			pstmt.setString(9, item.getIt_content());
			pstmt.setString(10, item.getIt_img());
			pstmt.setInt(11, item.getIt_count());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[4]insertItem error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<ItemBean> selectItemList(int page, int limit) {
		System.out.println("[4]ItemDAO.selectItemList");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ItemBean> itemList = new ArrayList<ItemBean>();
		ItemBean item = null;
		int starrow = (page -1) * 10;
		try {
			pstmt = con.prepareStatement("SELECT * FROM item ORDER BY it_code LIMIT ?,?");
			pstmt.setInt(1, starrow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				item = new ItemBean(
						rs.getString("it_code"), 
						rs.getString("it_name"), 
						rs.getString("it_category"), 
						rs.getString("it_author"), 
						rs.getString("it_isbn"), 
						rs.getString("it_publisher"), 
						rs.getString("it_pubdate"), 
						rs.getInt("it_price"), 
						rs.getString("it_content"), 
						rs.getString("it_img"), 
						rs.getInt("it_count"));
				
				itemList.add(item);
			}
		} catch (Exception e) {
			System.out.println("[4]selectItemList error");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return itemList;
	}

	public ItemBean selectItem(String it_code) {
		System.out.println("[4]ItemDAO.selectItem");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemBean item = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM item WHERE it_code=?");
			pstmt.setString(1, it_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String content = rs.getString("it_content");
				item = new ItemBean(rs.getString("it_code"), rs.getString("it_name"), rs.getString("it_category"),
						rs.getString("it_author"), rs.getString("it_isbn"), rs.getString("it_publisher"),
						rs.getString("it_pubdate"), rs.getInt("it_price"), content,
						rs.getString("it_img"), rs.getInt("it_count"));
			}
		} catch (Exception e) {
			System.out.println("[4]selectItem error");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return item;
	}
	
	public int updateCount(String it_code) {
		System.out.println("[4]ItemDAO.updateCount");
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		try {
			sql = "UPDATE item SET it_count = it_count + 1 WHERE it_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, it_code);
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[4]updateCount error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	public int updateItem(ItemBean item, String it_code) {
		System.out.println("[4]ItemDAO.updateItem");
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "UPDATE item SET it_code=?, it_name=?, it_category=?, it_author=?, it_isbn=?, it_publisher=?, it_pubdate=?, it_price=?, it_content=?, it_img=?, it_count=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item.getIt_code());
			pstmt.setString(2, item.getIt_name());
			pstmt.setString(3, item.getIt_category());
			pstmt.setString(4, item.getIt_author());
			pstmt.setString(5, item.getIt_isbn());
			pstmt.setString(6, item.getIt_publisher());
			pstmt.setString(7, item.getIt_pubdate());
			pstmt.setInt(8, item.getIt_price());
			pstmt.setString(9, item.getIt_content());
			pstmt.setString(10, item.getIt_img());
			pstmt.setInt(11, item.getIt_count());
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[4]updateItem error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	public int deleteItem(String it_code) {
		System.out.println("[4]ItemDAO.deleteItem");
		PreparedStatement pstmt = null;
		int updateCount = 0;
		try {
			pstmt = con.prepareStatement("DELETE FROM item WHERE it_code=?");
			pstmt.setString(1, it_code);
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[4]deleteItem error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateCount;
	}
}
