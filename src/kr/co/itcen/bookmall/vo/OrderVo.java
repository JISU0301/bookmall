package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private int no;
	private int total_price;
	private int user_no;
	private String address;
	
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", total_price=" + total_price + ", user_no=" + user_no + ", address=" + address
				+ "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}