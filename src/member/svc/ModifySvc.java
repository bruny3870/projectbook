package member.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class ModifySvc {
	public void modifysvc(MemberBean member) {
		System.out.println("[3]ModifySvc");
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int modifycount = memberDAO.ModifyDAO(member);
		
		if(modifycount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
	}
}
