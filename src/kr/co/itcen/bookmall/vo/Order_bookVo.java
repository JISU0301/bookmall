package kr.co.itcen.bookmall.vo;

public class Order_bookVo {
	private Long book_no;
	private String count;
	private String order_no;
	
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	
	@Override
	public String toString() {
		return "Order_bookVo [book_no=" + book_no + ", count=" + count + ", order_no=" + order_no + "]";
	}
	
}
