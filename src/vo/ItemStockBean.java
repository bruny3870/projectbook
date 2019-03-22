package vo;

import java.sql.Date;

public class ItemStockBean {
	private String it_code;
	private String st_state;
	private Date st_date;
	private int amount;
	private int st_stock;
	private int st_code;
	
	public String getIt_code() {
		return it_code;
	}
	public void setIt_code(String it_code) {
		this.it_code = it_code;
	}
	public String getSt_state() {
		return st_state;
	}
	public void setSt_state(String st_state) {
		this.st_state = st_state;
	}
	public Date getSt_date() {
		return st_date;
	}
	public void setSt_date(Date st_date) {
		this.st_date = st_date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getSt_stock() {
		return st_stock;
	}
	public void setSt_stock(int st_stock) {
		this.st_stock = st_stock;
	}
	public int getSt_code() {
		return st_code;
	}
	public void setSt_code(int st_code) {
		this.st_code = st_code;
	}
}
