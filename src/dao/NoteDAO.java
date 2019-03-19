/*package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.NoteBean;

public class NoteDAO {
	DataSource ds;
	Connection con;
	
	private static NoteDAO noteDAO;
	
	private NoteDAO() {
	}
	
	public static NoteDAO getInstance() {
		if (noteDAO == null) {
			noteDAO = new NoteDAO();
		}
		return noteDAO;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public int selectListCount(String sO, String sW) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT count(*) FROM note";
		if(!sO.equals("")) {
			sql+=" where "+sO+" like '%"+sW+"%' ";
		}
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("getListCount error: " +e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<NoteBean> selectArticleList(int page, int limit, String sO, String sW){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select * from board ";
		if(!sO.equals("")) {
			board_list_sql +=" where "+sO+" like '%"+sW+"%' ";
		}
		board_list_sql += "ORDER By board_re_ref desc, board_re_seq asc limit ?,?";
		System.out.println(board_list_sql);
		ArrayList<NoteBean> articleList = new ArrayList<NoteBean>();
		NoteBean board = null;
		int startrow=(page-1)*limit;
		
		try {
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				board= new NoteBean();
				board.setNo_num(rs.getInt("no_num"));
				board.setNo_name(rs.getString("no_name"));
				board.setNo_suject(rs.getString("no_subject"));
				board.setNo_content(rs.getString("no_content"));
				board.setNo_date(rs.getDate("no_date"));
				articleList.add(board);
			}
		}catch(Exception ex) {
			System.out.println("getBoardList 에러 : "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	//글 등록
	public int insertArticle(BoardBean article) {
		//System.out.println(article.getBOARD_CONTENT());
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql="";
		int insertCount = 0;
		try {
			pstmt=con.prepareStatement("select max(board_num) from board");
			rs=pstmt.executeQuery();
			
			if(rs.next())
				num= rs.getInt(1)+1;//불러온 첫번째 열에 +1
		
			else
				num=1;
			 //sql="insert into board(BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,BOARD_RE_LEV, BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE) values(?,?,?,?,?,?,?,0,0,0,now())";
			 sql="insert into board values(?,?,?,?,?,?,?,0,0,0,now())";//자동 증가가 아니면.사용
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1, num);
			 pstmt.setString(2, article.getBOARD_NAME());
			 pstmt.setString(3, article.getBOARD_PASS());
			 pstmt.setString(4, article.getBOARD_SUBJECT());
			 pstmt.setString(5, article.getBOARD_CONTENT());
			 pstmt.setString(6, article.getBOARD_FILE()==null?"":article.getBOARD_FILE());
			 pstmt.setInt(7, num);//기본키값 , 답글일 경우 참조
			// pstmt.setInt(8, 0);// 들여 쓰기
			// pstmt.setInt(9, 0);//순번 결정
			// pstmt.setInt(10, 0);//조회수
			 
			 insertCount=pstmt.executeUpdate();
			 
		}catch(Exception ex) {
			System.out.println("boardInsert 에러 : "+ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
		
	}
	//글내용 보기
	public BoardBean selectArticle(int board_num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;
		
		try {
			pstmt = con.prepareStatement("select * from board where BOARD_NUM=?");
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				boardBean= new BoardBean();
				boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				boardBean.setBOARD_NAME(rs.getString("BOARD_NAME"));
				boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
				boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
		}catch(Exception ex) {
			System.out.println("getDetail 에러 : " +ex);
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardBean;
	}
	//조회수 업데이트
	public int  updateReadCount(int board_num) {
		
		PreparedStatement pstmt  = null;
		int updateCount = 0;
		String sql="update board set BOARD_READCOUNT = "+"BOARD_READCOUNT+1 where BOARD_NUM = "+ board_num;
		
		try {
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
			}catch(SQLException ex) {
			System.out.println("setReadCountUpdate 에러 : "+ex);
			}finally {
		close(pstmt);
	}
		return updateCount;
}
*/