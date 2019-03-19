package vo;

import java.sql.Date;

public class NoteBean {
	private int no_num;
	private String no_name;
	private String no_subject;
	private String no_content;
	private Date no_date;
	
	public int getNo_num() {
		return no_num;
	}
	public void setNo_num(int no_num) {
		this.no_num = no_num;
	}
	public String getNo_name() {
		return no_name;
	}
	public void setNo_name(String no_name) {
		this.no_name = no_name;
	}
	public String getNo_suject() {
		return no_subject;
	}
	public void setNo_suject(String no_suject) {
		this.no_subject = no_suject;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public Date getNo_date() {
		return no_date;
	}
	public void setNo_date(Date no_date) {
		this.no_date = no_date;
	}
}
