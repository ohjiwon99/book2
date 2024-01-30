package librarylogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	// public class UserDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/*
	 * private String driver = "com.mysql.cj.jdbc.Driver"; private String url =
	 * "jdbc:mysql://localhost:3306/library_db"; private String id = "library";
	 * private String pw = "library";
	 */

	// 여기서 부터
	private void getConnection() {// getConnection BookApp메인화면에서 사용하지 못하도록 public ->private 수정

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/library_db";
			conn = DriverManager.getConnection(url, "library", "library");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
}

// getConnection()

/***********************************************************************
 ** - 로그인 입력
 ************************************************************************/
/*
 * public int login(int member_Id, String member_pw, String member_email) {
 * 
 * this.getConnection();
 * 
 * try { // 어떤 계정에 대한 실제로 로그인을 시도하는 함수, 인자값으로 ID와 Password를 받아 login을 판단함.
 * String query = ""; query += "  insert into login  "; query +=
 * "  values(null,?,?);  ";
 * 
 * 
 * pstmt = conn.prepareStatement(query); ;
 * 
 * //등록 rs = pstmt.executeQuery();
 * 
 * 
 * 
 * 
 * // 실제로 DB에 입력될 명령어를 SQL 문장으로 만듬. try { pstmt = conn.prepareStatement(SQL);
 * pstmt.setString(1, userID); rs = pstmt.executeQuery();
 * 
 * // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌 if (rs.next()) { if
 * (rs.getString(1).contentEquals(userPassword)) { return 1; // 로그인 성공 } else {
 * return 0; // 비밀번호 불일치 } } return -1; // 아이디가 없음 } catch (Exception e) {
 * e.printStackTrace(); } return -2; // DB 오류 }
 * 
 * }
 */
