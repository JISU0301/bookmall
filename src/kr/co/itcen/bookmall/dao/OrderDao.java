package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDao {
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "delete from final_order";

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
	
	public Boolean insert(OrderVo vo) {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Boolean result = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "insert into final_order values(null, \r\n" + 
						 "(select sum(price)\r\n" + 
						 "from (select b.price*o.quantity as price\r\n" + 
						 "from book b, order_book o\r\n" + 
						 "where b.no = o.book_no\r\n" + 
						 "and o.order_no is null\r\n" + 
						 "group by b.no) order_b), \r\n" + 
						 "?, ?)";

			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, vo.getUser_no());
			pstmt.setString(2, vo.getAddress());
			
			int count = pstmt.executeUpdate();
			result = (count==1);
			
			stmt = connection.createStatement();
			stmt.executeUpdate("update order_book set order_no = (select last_insert_id()) where order_no is null");
//			if(rs.next()) {
//				int no = rs.getInt(1);
//				vo.setNo(no);
//			}
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
			
			String sql = "select fo.no as '주문번호',\r\n" + 
						"concat(u.name, ' ', u.email) as '주문자',\r\n" + 
						"fo.total_price as '결제금액',\r\n" + 
						"fo.address as '배송지'\r\n" + 
						"from final_order fo, user u\r\n" + 
						"where fo.user_no = u.no\r\n" + 
						"and u.no = ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, 1); //사용자번호
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int orderNo = rs.getInt(1);
				String userName = rs.getString(2);
				int TotalPrice = rs.getInt(3);
				String address = rs.getString(4);
				
				ArrayList<Object> vo = new ArrayList<Object>();
				vo.add(orderNo);
				vo.add(userName);
				vo.add(TotalPrice);
				vo.add(address);
				
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