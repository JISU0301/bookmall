package kr.co.itcen.bookmall.vo;

public class CategoryVo {
	private Long no;
	private String name;

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryVo [번호 : " + no + ", 이름 : " + name + "]";
	}
	

}
