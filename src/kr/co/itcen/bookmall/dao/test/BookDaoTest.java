package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		//deleteAllTest();
	}

//	private static void deleteAllTest() {
//		new BookDao().delete();
//	}

	private static void insertTest() {
		BookDao dao = new BookDao();
		
		CategoryDao cDao = new CategoryDao();
		List<CategoryVo> cList = cDao.getList();
		
		if(cList.size() == 0) {
			System.out.println("카테고리를 지정해주세요.");
			return;
		}
		
		
		BookVo vo1 = new BookVo();
		vo1.setTitle("빛의 과거");
		vo1.setPrice(11500);
		vo1.setCategory_no(cList.get(0).getNo());
		dao.insert(vo1);
		System.out.println(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setTitle("혼자가 혼자에게");
		vo2.setPrice(32950);
		vo2.setCategory_no(cList.get(1).getNo());
		dao.insert(vo2);
		System.out.println(vo2);
		
		BookVo vo3 = new BookVo();
		vo3.setTitle("JAVA Programming");
		vo3.setPrice(27590);
		vo3.setCategory_no(cList.get(2).getNo());
		dao.insert(vo3);
		System.out.println(vo3);
	}
		
	}
	

