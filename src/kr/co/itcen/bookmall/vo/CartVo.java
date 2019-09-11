package kr.co.itcen.bookmall.vo;

public class CartVo {
	private int book_no;
	private int customer_no;
	private 
	
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	
	@Override
	public String toString() {
		return "CartVo [책 번호 : " + book_no + ", 고객 번호 : " + customer_no + "]";
	}
	
}
