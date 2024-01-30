package com.javaex.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {
	
	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/book_db";
	private String id = "book";
	private String pw = "book";
	
	// 일반메소드
		private void getConnection() {
				
			try {
				// 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("com.mysql.cj.jdbc.Driver");

				// 2. Connection 얻어오기
				String url = "jdbc:mysql://localhost:3306/book_db";
				conn = DriverManager.getConnection(url, "book", "book");

			} catch (ClassNotFoundException e) {
				System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}// getConnection()
		
		
	
		private void close() {
	
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}// close()
	
		/***********************************************************************
		 ** - 작가등록1 bookInsert(int bookId, String title, String  pubs, String pub_date, int authorId)
		 ************************************************************************/
	public int bookInsert(int bookId, String title, String  pubs, String pub_date, int authorId) {

		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// -SQL문 준비
			String query = "";
			query += "  insert into book ";
			query += "  value(null,?,?,?,?) ";

			// -바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			pstmt.setString(2, title);
			pstmt.setString(3, pubs);
			pstmt.setString(4, pub_date);
			pstmt.setInt(5, authorId);

			// -실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 등록되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;

	}

	/***********************************************************************
	 ** - 작가등록2 bookInsert(BookVo bookVo)
	 ************************************************************************/
    public int bookInsert(BookVo bookVo) {

	int count = -1;

	this.getConnection();

	try {

		// 3. SQL문 준비 / 바인딩 / 실행
		// -SQL문 준비
		String query = "";
		query += "  insert into book ";
		query += "  value(null,?,?,?,?) ";

		// -바인딩
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, bookVo.getBookId());
		pstmt.setString(2, bookVo.getBookTitle());
		pstmt.setString(3, bookVo.getBookPubs());
		pstmt.setString(4, bookVo.getBookpub_Date());
		pstmt.setInt(5, bookVo.getAuthorId());

		// -실행
		count = pstmt.executeUpdate();

		// 4.결과처리
		System.out.println(count + "건이 등록되었습니다.");

	} catch (SQLException e) {
		System.out.println("error:" + e);
	}

	this.close();

	return count;

}// authorInsert
	
    /********************************************************
	 * - 작가삭제 bookDelete() bookUpdate(BookVo bookVo)
	 *********************************************************/
	public int bookDelete() {

		int count = -1;
		this.getConnection();
		
		try {
		// 3. SQL문 준비 / 바인딩 / 실행
		     // -SQL문 준비
			String query = "";
			query += "  delete from author ";
			query += "  where author_id = ? ";

			// -바인딩
			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, num);

			// -실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
			this.close();

		
		return count;
	}// authorDelete()
	
	
	
	
	

	public BookDao() {
		/*
		 * bookInsert(BookVo bookVo) <--- bookInsert(int bookId, String title, String
		 * pubs, String pub_date, int authorId)
		 * 
		 * bookDelete() bookUpdate(BookVo bookVo)
		 * 
		 * bookSelect() <--책데이터만 다 가져오기
		 * bookSelectALL() <--책+작가 데이터 다 가져오기
		 * bookSelectOne(int bookId) <---2번책+작가 데이터 가져오기
		 */

	}

}
