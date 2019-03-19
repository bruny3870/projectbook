package member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class JoinSvc {
	public int Join(MemberBean member) {
		System.out.println("[3]JoinSvc");
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int insertId;
		insertId = memberDAO.JoinDAO(member);

		if (insertId > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return insertId;
	}
}
