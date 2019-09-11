package kr.co.itcen.bookmall.dao.test;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;


public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		deleteAllTest();
	}
	
	private static void insertTest() {
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		vo1.setName("소설");
		dao.insert(vo1);
		System.out.println(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setName("수필");
		dao.insert(vo2);
		System.out.println(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setName("컴퓨터/IT");
		dao.insert(vo3);
		System.out.println(vo3);
	}

	private static void deleteAllTest(){
		new CategoryDao().delete();
	}
	
	

}
