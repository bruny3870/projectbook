package vo;

public class ItemBean {
	private String it_code; // 도서코드
	private String it_name; // 도서명
	private String it_category; // 분야
	private String it_author; // 저자
	private String it_isbn; // 도서번호
	private String it_publisher; // 출판사
	private String it_pubdate; // 출판일
	private int it_price; // 가격
	private String it_content; // 설명
	private String it_img; // 이미지
	private int it_count; // 조회수
	
	public ItemBean(String it_code, String it_name, String it_category, String it_author, String it_isbn,
			String it_publisher, String it_pubdate, int it_price, String it_content, String it_img, int it_count) {
		super();
		this.it_code = it_code;
		this.it_name = it_name;
		this.it_category = it_category;
		this.it_author = it_author;
		this.it_isbn = it_isbn;
		this.it_publisher = it_publisher;
		this.it_pubdate = it_pubdate;
		this.it_price = it_price;
		this.it_content = it_content;
		this.it_img = it_img;
		this.it_count = it_count;
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
	public String getIt_author() {
		return it_author;
	}
	public void setIt_author(String it_author) {
		this.it_author = it_author;
	}
	public String getIt_isbn() {
		return it_isbn;
	}
	public void setIt_isbn(String it_isbn) {
		this.it_isbn = it_isbn;
	}
	public String getIt_publisher() {
		return it_publisher;
	}
	public void setIt_publisher(String it_publisher) {
		this.it_publisher = it_publisher;
	}
	public String getIt_pubdate() {
		return it_pubdate;
	}
	public void setIt_pubdate(String it_pubdate) {
		this.it_pubdate = it_pubdate;
	}
	public int getIt_price() {
		return it_price;
	}
	public void setIt_price(int it_price) {
		this.it_price = it_price;
	}
	public String getIt_content() {
		return it_content;
	}
	public void setIt_content(String it_content) {
		this.it_content = it_content;
	}
	public String getIt_img() {
		return it_img;
	}
	public void setIt_img(String it_img) {
		this.it_img = it_img;
	}
	public int getIt_count() {
		return it_count;
	}
	public void setIt_count(int it_count) {
		this.it_count = it_count;
	}
	
	
}
