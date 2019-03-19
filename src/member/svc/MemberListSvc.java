package member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberListSvc {
	public ArrayList<MemberBean> getMemberList() {
		System.out.println("[3]MemberListSvc");
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		ArrayList<MemberBean> list = memberDAO.getSelectList();
		
		close(con);
		return list;
	}
}
