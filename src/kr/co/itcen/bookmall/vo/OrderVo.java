package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long no;
	private String customer_name;
	private int total;
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", customer_name=" + customer_name + ", total=" + total + "]";
	}
	
	
}
