package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;


public class BookDaoTest {
	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new BookDao().delete();
	}

	private static void selectTest() {
		System.out.println("===select test===");
		BookDao dao = new BookDao();
		
		ArrayList list = dao.getList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	private static void insertTest() {
		System.out.println("===insert test===");
		BookDao dao = new BookDao();
		
		//소설
		BookVo vo101 = new BookVo();
		vo101.setTitle("빛의과거");
		vo101.setPrice(11500);
		vo101.setCategory_no(1);
		dao.insert(vo101);
		System.out.println(vo101);
		
		BookVo vo102 = new BookVo();
		vo102.setTitle("빨강머리앤");
		vo102.setPrice(8000);
		vo102.setCategory_no(1);
		dao.insert(vo102);
		System.out.println(vo102);
		
		//수필
		BookVo vo201 = new BookVo();
		vo201.setTitle("나는 나로 살기로 했다");
		vo201.setPrice(12500);
		vo201.setCategory_no(2);
		dao.insert(vo201);
		System.out.println(vo201);
		
		BookVo vo202 = new BookVo();
		vo202.setTitle("혼자가 혼자에게");
		vo202.setPrice(9500);
		vo202.setCategory_no(2);
		dao.insert(vo202);
		System.out.println(vo202);
		
		//컴퓨터/IT
		BookVo vo301 = new BookVo();
		vo301.setTitle("JAVA");
		vo301.setPrice(13500);
		vo301.setCategory_no(3);
		dao.insert(vo301);
		System.out.println(vo301);
		
		BookVo vo302 = new BookVo();
		vo302.setTitle("혼자공부하는 파이썬");
		vo302.setPrice(27500);
		vo302.setCategory_no(3);
		dao.insert(vo302);
		System.out.println(vo302);
		
		//인문
		BookVo vo401 = new BookVo();
		vo401.setTitle("설민석의 삼국지. 1");
		vo401.setPrice(19800);
		vo401.setCategory_no(4);
		dao.insert(vo401);
		System.out.println(vo401);
		
		BookVo vo402 = new BookVo();
		vo402.setTitle("유럽 도시 기행. 1");
		vo402.setPrice(17500);
		vo402.setCategory_no(4);
		dao.insert(vo402);
		System.out.println(vo402);
		
		//경제
		BookVo vo501 = new BookVo();
		vo501.setTitle("돈의 감각");
		vo501.setPrice(16000);
		vo501.setCategory_no(5);
		dao.insert(vo501);
		System.out.println(vo501);
		
		BookVo vo502 = new BookVo();
		vo502.setTitle("90년생이 온다");
		vo502.setPrice(13700);
		vo502.setCategory_no(5);
		dao.insert(vo502);
		System.out.println(vo502);
		
		//예술
		BookVo vo601 = new BookVo();
		vo601.setTitle("영화는 두번 시작된다");
		vo601.setPrice(17000);
		vo601.setCategory_no(6);
		dao.insert(vo601);
		System.out.println(vo601);
		
		BookVo vo602 = new BookVo();
		vo602.setTitle("잔나비 피아노 연주곡집");
		vo602.setPrice(21800);
		vo602.setCategory_no(6);
		dao.insert(vo602);
		System.out.println(vo602);
	}
}