package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CustomerVo;

public class CustomerDao {
	
	public Boolean insert(CustomerVo cv) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
			
		try {
			connection = getConnection();
			
			String sql = "insert into customer values(null, ?, ?, ?, password(?), ?)";
			pstmt = connection.prepareStatement(sql);
			
			
			pstmt.setString(1, cv.getEmail());
			pstmt.setString(2, cv.getAddress());
			pstmt.setString(3, cv.getPhone());
			pstmt.setString(4, cv.getPassword());
			pstmt.setString(5, cv.getName());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				cv.setNo(no);
			}
			
					
		} catch (SQLException e) {
			//System.out.println("error:" + e);
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
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
	public List<CustomerVo> getList() {
		List<CustomerVo> result = new ArrayList<CustomerVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "select no, name, address, phone, password, name from customer order by no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Long no = rs.getLong(1);
				String email = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				String password = rs.getString(5);
				String name = rs.getString(6);
				
				CustomerVo vo= new CustomerVo();
				vo.setNo(no);
				vo.setEmail(email);
				vo.setAddress(address);
				vo.setPhone(phone);
				vo.setPassword(password);
				vo.setName(name);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			//System.out.println("error:" + e);
			e.printStackTrace();
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

//		public void delete() {
//			Connection connection = null;
//			PreparedStatement pstmt = null;
//			
//			try {
//				connection = getConnection();
//				
//				String sql = "delete from member";
//				pstmt = connection.prepareStatement(sql);
//				
//				pstmt.executeUpdate();
//				
//			} catch (SQLException e) {
//				System.out.println("error:" + e);
//			} finally {
//				try {
//					if(pstmt != null) {
//						pstmt.close();
//					}
//					if(connection != null) {
//						connection.close();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//
//	}

}
