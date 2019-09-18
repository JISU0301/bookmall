package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;



public class UserDaoTest {
	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new UserDao().delete();
	}

	private static void selectTest() {
		System.out.println("===select test===");
		UserDao dao = new UserDao();
		
		List<UserVo> list = dao.getList();
		for(UserVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		System.out.println("===insert test===");
		UserDao dao = new UserDao();
		
		UserVo vo1 = new UserVo();
		vo1.setName("아리");
		vo1.setPhone("01012341234");
		vo1.setAddress("인천");
		vo1.setEmail("ari@gmail.com");
		vo1.setPasswd("1234");
		dao.insert(vo1);
		System.out.println(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setName("쫑이");
		vo2.setPhone("01034563456");
		vo2.setAddress("분당");
		vo2.setEmail("jjongee@gmail.com");
		vo2.setPasswd("3456");
		dao.insert(vo2);
		System.out.println(vo2);
		
		
		
	}
}