package vo;

import java.sql.Date;

public class ItemViewBean {
	private Date it_vdate;
	private String it_code;
	private String it_name;
	private String it_category;
	private String it_img;
	private int it_price;
	private int st_stock;
	private int it_count;
	private int it_purchase;
	
	public Date getIt_vdate() {
		return it_vdate;
	}
	public void setIt_vdate(Date it_vdate) {
		this.it_vdate = it_vdate;
	}
	public String getIt_code() {
		return it_code;
	}
	public void setIt_code(String it_code) {
		this.it_code = it_code;
	}
	public String getIt_name() {
		return it_name;
	}
	public void setIt_name(String it_name) {
		this.it_name = it_name;
	}
	public String getIt_category() {
		return it_category;
	}
	public void setIt_category(String it_category) {
		this.it_category = it_category;
	}
	public String getIt_img() {
		return it_img;
	}
	public void setIt_img(String it_img) {
		this.it_img = it_img;
	}
	public int getIt_price() {
		return it_price;
	}
	public void setIt_price(int it_price) {
		this.it_price = it_price;
	}
	public int getSt_stock() {
		return st_stock;
	}
	public void setSt_stock(int st_stock) {
		this.st_stock = st_stock;
	}
	public int getIt_count() {
		return it_count;
	}
	public void setIt_count(int it_count) {
		this.it_count = it_count;
	}
	public int getIt_purchase() {
		return it_purchase;
	}
	public void setIt_purchase(int it_purchase) {
		this.it_purchase = it_purchase;
	}
	
}
