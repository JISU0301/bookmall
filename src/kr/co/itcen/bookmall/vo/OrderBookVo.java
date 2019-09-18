package kr.co.itcen.bookmall.vo;

public class OrderBookVo {
	private int no;
	private int quantity;
	private int book_no;
	private int order_no;
	
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", quantity=" + quantity + ", book_no=" + book_no + ", order_no=" + order_no
				+ "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
}