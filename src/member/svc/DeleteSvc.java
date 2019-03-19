package member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class DeleteSvc {
	public int deletesvc(String id) {
		System.out.println("[3]DeleteSvc");
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int deleteCount = memberDAO.DeleteDAO(id);
		
		if(deleteCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return deleteCount;
	}
}
