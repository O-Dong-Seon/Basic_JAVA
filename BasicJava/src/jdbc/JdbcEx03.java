package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); //키보드를 입력받는값을 빌려옴
		System.out.print("번호:");				// 번호입력
		int num = sc.nextInt();						// num에 집어넣고
		System.out.print("이름:");				// 이름입력
		sc.nextLine();
		String name = sc.nextLine();
		System.err.print("나이:");
		int age = sc.nextInt();
	
		//Connection conn = DBManager.getConnection();
		
		
	//	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";				//자바와 연결하기위한 값 정리
	//String user = "java";											//자바와 연결하기위한 값 정리
	//	String password = "1234";										//자바와 연결하기위한 값 정리		

		try {										//예외가 발생할 수도 있는 부분
		//	Class.forName("oracle.jdbc.driver.OracleDriver");       // 동적 개체 설정 방법 (오라클 드라이버를 사용할거라고 명시함)
			Connection conn = DBManager.getConnection();  // 자바와 오라클의 연결부분

			String sql = "INSERT INTO tbl_study VALUES(? , ? , ?)";   // sql이라는 변수에 담음
			PreparedStatement pstmt = conn.prepareStatement(sql);    // preparedtatment - 값을 동적으로 바꿀수 있게 해줌
			pstmt.setInt(1, num);												
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			
			int result = pstmt.executeUpdate();  // 자바가 DB에 값을 저장하라고 함 
			if(result > 0) {    // 값을 가지고 DB에 가서 저장하고 온다 1. 성공 0.실패
				System.out.println("등록성공");
			}else {
				System.out.println("등록실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	
	}

}
