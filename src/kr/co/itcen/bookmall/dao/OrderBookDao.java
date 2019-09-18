package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.itcen.bookmall.vo.OrderBookVo;


public class OrderBookDao {
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "delete from order_book";

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
	
	public Boolean insert(OrderBookVo vo) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Boolean result = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "insert into order_book values(null, ?, ?, null)";

			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, vo.getQuantity());
			pstmt.setInt(2, vo.getBook_no());
			int count = pstmt.executeUpdate();
			result = (count==1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				int no = rs.getInt(1);
				vo.setNo(no);
			}
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
			
			String sql = "select b.no as '도서번호',\r\n" + 
						"b.title as '도서제목',\r\n" + 
						"ob.quantity as '수량'\r\n" + 
						"from book b, order_book ob\r\n" + 
						"where b.no = ob.book_no";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String bookTitle = rs.getString(2);
				int quantity = rs.getInt(3);
				
				ArrayList<Object> vo = new ArrayList<Object>();
				vo.add(no);
				vo.add(bookTitle);
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