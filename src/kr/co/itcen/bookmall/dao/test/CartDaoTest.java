package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;



public class CartDaoTest {
	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new CartDao().delete();
	}

	private static void selectTest() {
		System.out.println("===select test===");
		CartDao dao = new CartDao();
		
		ArrayList list = dao.getList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	private static void insertTest() {
		System.out.println("===insert test===");
		CartDao dao = new CartDao();
		
		CartVo vo1 = new CartVo();
		vo1.setQuantity(3);
		vo1.setUser_no(1);
		vo1.setBook_no(4);
		dao.insert(vo1);
		System.out.println(vo1);
		
		CartVo vo2 = new CartVo();
		vo2.setQuantity(1);
		vo2.setUser_no(1);
		vo2.setBook_no(2);
		dao.insert(vo2);
		System.out.println(vo2);
		
		CartVo vo3 = new CartVo();
		vo3.setQuantity(4);
		vo3.setUser_no(1);
		vo3.setBook_no(11);
		dao.insert(vo3);
		System.out.println(vo3);
		

	}
}