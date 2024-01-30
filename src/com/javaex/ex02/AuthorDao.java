package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/book_db";
	private String id = "book";
	private String pw = "book";

	// 생성자
	// 기본생성자 사용 (써주지 않아도 기본으로 제공되어있음)

	// 메소드 gs

	// 일반메소드
	private void getConnection() {// getConnection BookApp메인화면에서 사용하지 못하도록 public ->private 수정

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

	private void close() {// close() BookApp메인화면에서 사용하지 못하도록 public ->private 수정

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
	 ** - 작가등록1
	 ************************************************************************/
	public int authorInsert(String name, String desc) {

		int count = -1;

		this.getConnection();

		try {

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

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;

	}// authorInsert

	/***********************************************************************
	 ** - 작가등록2
	 ************************************************************************/
	public int authorInsert(AuthorVo authorVo) {

		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// -SQL문 준비
			String query = "";
			query += "  insert into author ";
			query += "  value(null,?,?) ";

			// -바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorVo.getAuthorName());
			pstmt.setString(2, authorVo.getAuthorDesc());

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
	 * - 작가리스트
	 *********************************************************/
	public List<AuthorVo> authorList() {

		this.getConnection();

		// 리스트 준비
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();

		try {
			
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
				int no = rs.getInt("author_id"); // 칼럼명
				String name = rs.getString("author_name");
				String desc = rs.getString("author_desc");

				AuthorVo authorVo = new AuthorVo(no, name, desc);
				authorList.add(authorVo);
			}
			System.out.println("list");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();

		return authorList;

	}// authorList()

	/********************************************************
	 * - 작가삭제
	 *********************************************************/
	public int authorDelete(int num) {

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
			pstmt.setInt(1, num);

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

	/********************************************************
	 * - 작가수정
	 *********************************************************/
	public int authorUpdete(String name, String desc, int id) {

		int count = -1;
		this.getConnection();

		// 3. SQL문 준비 / 바인딩 / 실행

		// -SQL문 준비
		try {
			String query = "";
			query += "  update author ";
			query += "  set  author_name =?, ";
			query += "       author_desc = ? ";
			query += "  where author_id = ? ";

			// -바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, desc);
			pstmt.setInt(3, id);

			// -실행
			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건이 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
			this.close();

		
		return count;
	}}



