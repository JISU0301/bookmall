package kr.co.itcen.bookmall.dao.test;


import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		insertTest();
		//deleteAllTest();
	}

//	private static void deleteAllTest() {
//		new OrderDao().delete();
//		
//	}

	private static void insertTest() {
		OrderDao dao = new OrderDao();
		
		OrderVo vo = new OrderVo();
		vo.setTotal(total); //도서에서 가격을 받아와서 그걸 합산
		
	}

}
