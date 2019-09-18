package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.itcen.bookmall.vo.CartVo;

public class CartDao {
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "delete from cart";

			pstmt = connection.prepareStatement(sql);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try { // 자원정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Boolean insert(CartVo vo) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Boolean result = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "insert into cart values(?, ?, ?)";

			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, vo.getQuantity());
			pstmt.setInt(2, vo.getUser_no());
			pstmt.setInt(3, vo.getBook_no());
			int count = pstmt.executeUpdate();
			result = (count==1);
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try { // 자원정리
				if (rs != null) {
					rs.close();
				}
				if(stmt != null) {
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
	
	public ArrayList<Object> getList() {
		ArrayList<Object> result = new ArrayList<Object>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "select u.name as '사용자이름',\r\n" + 
						"b.title as '도서제목',\r\n" + 
						"b.price as '도서가격',\r\n" + 
						"c.quantity as '수량'\r\n" + 
						"from cart c, book b, user u\r\n" + 
						"where c.user_no = u.no\r\n" + 
						"and c.book_no = b.no\r\n" + 
						"and c.user_no = ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, 1);	//사용자번호

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				int quantity = rs.getInt(4);
				
				ArrayList<Object> vo = new ArrayList<Object>();
				vo.add(name);
				vo.add(title);
				vo.add(price);
				vo.add(quantity);
				
				result.add(vo);
			}
			
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {	// 자원정리
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) 
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException{
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.1.77:3307/bookmall?characterEncoding-utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");			
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		}
		return connection;
	}
}