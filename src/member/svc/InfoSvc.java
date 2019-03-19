package member.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class InfoSvc {
	public MemberBean Info(String id) {
		System.out.println("[3]InfoSvc");
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberBean member = memberDAO.InfoDAO(id);
		close(con);
		
		return member;
	}
}
