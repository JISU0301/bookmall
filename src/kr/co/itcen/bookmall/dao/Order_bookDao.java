package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CustomerVo;
import kr.co.itcen.bookmall.vo.Order_bookVo;


public class Order_bookDao {
	public Boolean insert(Order_bookVo obv) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();

			String sql = "insert into book_order values(null, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, obv.getbook_no());// 도서의 도서번호
			pstmt.setString(2, obv.getcount());// 도서의 
			pstmt.setString(3, obv.getorder_no());
		
			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if (rs.next()) {
				Long no = rs.getLong(1);
				obv.setBook_no(no);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<Order_bookVo> getList() {
		List<Order_bookVo> result = new ArrayList<Order_bookVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "select no, count, order_no from book_order order by no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Long book_no = rs.getLong(1);
				String count = rs.getString(2);
				String order_no = rs.getString(3);
				
				
				CustomerVo vo= new CustomerVo();
				vo.setBook_no(book_no);
				vo.setCount(count);
				vo.setOrder_no(order_no);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}	

}
