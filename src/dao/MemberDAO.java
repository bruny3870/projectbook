package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.MemberBean;

public class MemberDAO {
	DataSource ds;
	Connection con;

	private static MemberDAO memberDAO;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int JoinDAO(MemberBean member) {
		System.out.println("[4]MemberDAO.JoinDAO");
		PreparedStatement pstmt = null;
		int insertId = 0;
		try {
			pstmt = con.prepareStatement("INSERT INTO member values(?,?,?,?,?,?,?,?,?,now())");
			System.out.println("[4]member.id : " + member.getMem_id());
			System.out.println("[4]member.pw : " + member.getMem_pw());
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getMem_pw());
			pstmt.setString(3, member.getMem_name());
			pstmt.setString(4, member.getMem_phone());
			pstmt.setString(5, member.getMem_gender());
			pstmt.setString(6, member.getMem_email());
			pstmt.setString(7, member.getMem_zip());
			pstmt.setString(8, member.getMem_addr1());
			pstmt.setString(9, member.getMem_addr2());
			insertId = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[4]JoinDAO error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertId;
	}

	public boolean LoginDAO(MemberBean member) {
		System.out.println("[4]MemberDAO.LoginDAO");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean selectId = false;
		try {
			pstmt = con.prepareStatement("SELECT * FROM member WHERE mem_id=? AND mem_pw=?");
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getMem_pw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (member.getMem_pw().equals(rs.getString("mem_pw"))) {
					selectId = true;
				} else {
					selectId = false;
				}
			}
		} catch (SQLException e) {
			System.out.println("[4]LoginDAO error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return selectId;
	}
	
	public MemberBean InfoDAO(String id) {
		System.out.println("[4]MemberDAO.InfoDAO");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean member = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM member WHERE mem_id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberBean();
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_gender(rs.getString("mem_gender"));
				member.setMem_email(rs.getString("mem_email"));
				member.setMem_zip(rs.getString("mem_zip"));
				member.setMem_addr1(rs.getString("mem_addr1"));
				member.setMem_addr2(rs.getString("mem_addr2"));
				member.setMem_date(rs.getTimestamp("mem_date"));
			}
		} catch(SQLException e) {
			System.out.println("[4]InfoDAO error");
			e.printStackTrace();
		}
		return member;
	}
	
	public int ModifyDAO(MemberBean member) {
		System.out.println("[4]MemberDAO.ModifyDAO");
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET mem_pass=?, mem_phone=?, mem_gender=?, mem_email=?, mem_zip=?, mem_addr1=?, mem_addr2=? WHERE mem_id=?";
		int medifyCount = 0;
		System.out.println("[4]sql : "+sql);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMem_pw());
			pstmt.setString(2, member.getMem_phone());
			pstmt.setString(3, member.getMem_gender());
			pstmt.setString(4, member.getMem_email());
			pstmt.setString(5, member.getMem_zip());
			pstmt.setString(6, member.getMem_addr1());
			pstmt.setString(7, member.getMem_addr2());
		} catch(SQLException e) {
			System.out.println("[4]ModifyDAO error");
			e.printStackTrace();
		}
		return medifyCount;
	}
	
	public int DeleteDAO(String id) {
		System.out.println("[4]MemberDAO.DeleteDAO");
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM member WHERE mem_id=?";
		int deleteCount = 0;
		System.out.println("[4]id : "+id);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}
	
	public ArrayList<MemberBean> getSelectList() {
		System.out.println("[4]MemberDAO.listDAO()");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberBean> list = new ArrayList<MemberBean>();
		MemberBean member = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM member");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberBean();
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_pw(rs.getString("mem_pw"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_gender(rs.getString("mem_gender"));
				member.setMem_email(rs.getString("mem_email"));
				member.setMem_zip(rs.getString("mem_zip"));
				member.setMem_addr1(rs.getString("mem_addr1"));
				member.setMem_addr2(rs.getString("mem_addr2"));
				list.add(member);
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
