package member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class LoginSvc {
	public boolean Login(MemberBean member) {
		System.out.println("[3]LoginSvc");
		boolean selectId = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		selectId = memberDAO.LoginDAO(member);
		close(con);
		
		return selectId;
	}
}
