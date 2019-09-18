package kr.co.itcen.bookmall.vo;

public class UserVo {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String email;
	private String passwd;
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", passwd=" + passwd + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}