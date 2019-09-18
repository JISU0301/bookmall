package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;

import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.vo.OrderBookVo;


public class OrderBookDaoTest {
	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new OrderBookDao().delete();
	}

	private static void selectTest() {
		System.out.println("===select test===");
		OrderBookDao dao = new OrderBookDao();
		
		ArrayList list = dao.getList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	private static void insertTest() {
		System.out.println("===insert test===");
		OrderBookDao dao = new OrderBookDao();
		
		OrderBookVo vo1 = new OrderBookVo();
		vo1.setQuantity(5);
		vo1.setBook_no(1);
		dao.insert(vo1);
		System.out.println(vo1);
		
		OrderBookVo vo2 = new OrderBookVo();
		vo2.setQuantity(8);
		vo2.setBook_no(2);
		dao.insert(vo2);
		System.out.println(vo2);
		
		OrderBookVo vo3 = new OrderBookVo();
		vo3.setQuantity(3);
		vo3.setBook_no(3);
		dao.insert(vo3);
		System.out.println(vo3);
	}
}