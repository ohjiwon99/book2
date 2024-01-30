package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

	// 필드

	// 생성자
	// 기본생성자 사용 (써주지 않아도 기본으로 제공되어있음)

	// 메소드 gs

	// 일반메소드

	/********************************************************
	 * - 작가리스트
	 *********************************************************/
	public List<AuthorVo>/*void*/ authorList() {
		
		// 리스트만들고
		// db에서 데이터 가져오고
		// 리스트에 추가하기
		// 리스트 주소 전달

		// 리스트 준비
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();

		// db에서 데이터
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += "  select author_id, ";
			query += "         author_name, ";
			query += "         author_desc ";
			query += "  from author ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);

			// -실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int no = rs.getInt("author_id");//칼럼명
			    String name = rs.getString("author_name");
			    String desc = rs.getString("author_desc");
			    
			    AuthorVo authorVo = new AuthorVo(no,name,desc);
			    authorList.add(authorVo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
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
		}
		
		return authorList;
	}//authorList()

	/********************************************************
	 * - 작가삭제
	 *********************************************************/
	public int authorDelete(int num) {
		
		int count = -1;

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");

			// 3. SQL문 준비 / 바인딩 / 실행

			// -SQL문 준비
			String query = "";
			query += "  delete from author ";
			query += "  where author_id = ? ";

			// -바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);

			// -실행
			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건이 삭제되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {

				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}return count;
	}//authorDelete()

	/***********************************************************************
	 ** - 작가등록
	 * @return 
	 ************************************************************************/
	// authorDao.authorInsert("이효리","제주도민");
	public int authorInsert(String name, String desc) {
		
		  int count=-1;

		// book 데이터 베이스에 접속
		// book/book
		// author 테이블에
		// 작가를 insert 작가이름, 작가설명

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book"); // (아이디,패스워드)

			// 3. SQL문 준비 / 바인딩 / 실행

			// -SQL문 준비
			String query = "";
			query += "  insert into author ";
			query += "  value(null,?,?) ";

			// -바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, desc);

			// -실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건이 등록되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {

				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		} return count;
	}// authorInsert
}
