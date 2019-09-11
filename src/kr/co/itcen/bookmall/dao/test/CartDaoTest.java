package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CustomerDao;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.CustomerVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		//deleteAllTest();

	}

	private static void insertTest() {
		CartDao dao = new CartDao();
		
		
		
		CartVo vo1 = new CartVo();
		vo1.setBook_no(1);
		vo1.setCustomer_no(1);
		dao.insert(vo1);
		System.out.println(vo1);
		
		CartVo vo2 = new CartVo();
		vo2.setBook_no(1);
		vo2.setCustomer_no(1);
		dao.insert(vo2);
		System.out.println(vo2);
	}

}
