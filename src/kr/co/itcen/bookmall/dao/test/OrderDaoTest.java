package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;


public class OrderDaoTest {
	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new OrderDao().delete();
	}

	private static void selectTest() {
		System.out.println("===select test===");
		OrderDao dao = new OrderDao();
		
		ArrayList list = dao.getList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	private static void insertTest() {
		System.out.println("===insert test===");
		OrderDao dao = new OrderDao();
		
		//소설
		OrderVo vo1 = new OrderVo();
		vo1.setUser_no(1);
		vo1.setAddress("부천");
		dao.insert(vo1);
		System.out.println(vo1);
	}
}