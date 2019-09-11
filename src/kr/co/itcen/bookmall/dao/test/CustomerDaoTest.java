package kr.co.itcen.bookmall.dao.test;

import kr.co.itcen.bookmall.dao.CustomerDao;
import kr.co.itcen.bookmall.vo.CustomerVo;


public class CustomerDaoTest {

	public static void main(String[] args) {
		insertTest();
		//deleteAllTest();

	}
	
//	private static void deleteAllTest() {
//		new CustomerDao().delete();
//		}
//	
	private static void insertTest() {
		CustomerDao dao = new CustomerDao();
		
		CustomerVo mv1 = new CustomerVo();
		mv1.setEmail("itjjong@gmail.com");
		mv1.setAddress("분당");
		mv1.setPhone("010-1234-5678");
		mv1.setPassword("abc123"); //비번은 암호화해야해서 스트링 안될텐데.. 
		mv1.setName("쫑이");
		dao.insert(mv1);
		System.out.println(mv1);
		
		CustomerVo mv2 = new CustomerVo();
		mv2.setEmail("itari@gmail.com");
		mv2.setAddress("인천");
		mv2.setPhone("010-5678-1234");
		mv2.setPassword("qwe123");
		mv2.setName("아리");
		dao.insert(mv2);
		System.out.println(mv2);
		
	}

	
	

}
