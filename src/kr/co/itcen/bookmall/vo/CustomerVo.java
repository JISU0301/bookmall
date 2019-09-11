package kr.co.itcen.bookmall.vo;

public class CustomerVo {
	private Long no;
	private String email;
	private String address;
	private String phone;
	private String password;
	private String name;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MemberVo [회원번호 : " + no + ", email=" + email + ", 주소 : " + address + ", 전화번호 : " + phone + ", 비밀번호 : "
				+ password + ", 이름 : " + name + "]";
	}
	
	
}
