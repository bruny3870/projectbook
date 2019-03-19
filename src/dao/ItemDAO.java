package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public int SelectListCount() {
		System.out.println("[4]ItemDAO.SelectListCount");
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
			System.out.println("SelectListCount error");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	public int InsertItem(ItemBean item) {
		System.out.println("[4]ItemDAO.InsertItem");
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
		} catch (SQLException e) {
			System.out.println("[4]InsertItem error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<ItemBean> SelectItemList(int page, int limit) {
		System.out.println("[4]ItemDAO.SelectItemList");
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
			System.out.println("SelectItemList error");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return itemList;
	}

	public ItemBean SelectItem(String it_code) {
		System.out.println("[4]ItemDAO.SelectItem");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemBean item = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM item WHERE it_code=?");
			pstmt.setString(1, it_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				item = new ItemBean(rs.getString("it_code"), rs.getString("it_name"), rs.getString("it_category"),
						rs.getString("it_author"), rs.getString("it_isbn"), rs.getString("it_publisher"),
						rs.getString("pubdate"), rs.getInt("it_price"), rs.getString("it_content"),
						rs.getString("it_image"), rs.getInt("it_count"));
			}
		} catch (SQLException e) {
			System.out.println("[4]SelectItem error");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return item;
	}

	public int UpdateCount(String it_code) {
		System.out.println("[4]ItemDAO.Updatecount");
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		try {
			sql = "UPDATE item SET it_count = it_count + 1 WHERE it_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, it_code);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[4]UpdateCount error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateCount;
	}



}
