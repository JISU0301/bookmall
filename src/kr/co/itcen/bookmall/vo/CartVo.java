package kr.co.itcen.bookmall.vo;

public class CartVo {
	private int user_no;
	private int book_no;
	private int quantity;
	
	@Override
	public String toString() {
		return "CartVo [user_no=" + user_no + ", book_no=" + book_no + ", quantity=" + quantity + "]";
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
}