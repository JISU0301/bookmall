package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.itcen.bookmall.vo.BookVo;

public class BookDao {
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "delete from book";

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
	
	public Boolean insert(BookVo vo) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Boolean result = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "insert into book values(null, ?, ?, ?)";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getCategory_no());
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
			
			String sql = "select c.name as '카테고리',\r\n" + 
						"b.title as '도서제목',\r\n" + 
						"b.price as '도서가격'\r\n" + 
						"from book b, category c\r\n" + 
						"where c.no = b.category_no";
			
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String categoryName = rs.getString(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				
				ArrayList<Object> vo = new ArrayList<Object>();
				vo.add(categoryName);
				vo.add(title);
				vo.add(price);
				
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