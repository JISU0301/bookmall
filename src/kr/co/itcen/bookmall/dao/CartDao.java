package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import kr.co.itcen.bookmall.vo.CartVo;



public class CartDao {
	public Boolean insert(CartVo cv) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "insert into book values(?, ?)";
			pstmt = connection.prepareStatement(sql);

			
			pstmt.setInt(1, cv.getBook_no());
			pstmt.setInt(2, cv.getCustomer_no());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);

			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if (rs.next()) {
				Long no = rs.getLong(1);
				//bv.setNo(no);
			}
			
			
		} catch (SQLException e) {
//			System.out.println("error:" + e);
			e.printStackTrace();
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
	
	public List<CartVo> getList() {
		List<CartVo> result = new ArrayList<CartVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select book_no, customer_no from cart order by no asc";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int book_no = rs.getInt(1);
				int customer_no = rs.getInt(2);

				CartVo cv = new CartVo();
				cv.setBook_no(book_no);
				cv.setCustomer_no(customer_no);

				result.add(cv);
			}
		} catch (SQLException e) {
			//System.out.println("error:" + e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
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
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.1.77:3307/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			//System.out.println("Fail to Loading Driver:" + e);
			e.printStackTrace();
		}

		return connection;
	}
	
//	public void delete() {
//	Connection connection = null;
//	PreparedStatement pstmt = null;
//
//	try {
//		connection = getConnection();
//
//		String sql = "delete from Cart";
//		pstmt = connection.prepareStatement(sql);
//
//		pstmt.executeUpdate();
//
//	} catch (SQLException e) {
//		System.out.println("error:" + e);
//	} finally {
//		try {
//			if (pstmt != null) {
//				pstmt.close();
//			}
//			if (connection != null) {
//				connection.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
}
