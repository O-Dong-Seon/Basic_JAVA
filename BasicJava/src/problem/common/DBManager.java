/*
 * @source: DMManager.java
 * @dascription: Connection 객체를 취득, 사용이 끝난
 * 				 자원을 해제하는 클래스
 * **************************************************
 * DATE				AUTHOR 			DESCRIPTION
 * **************************************************
 *  2019.12.12      보리			최초작성
 */

package problem.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	
	private static Connection conn;  
	
	
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final static String USER = "java";
	private final static String PASS = "1234";
	

	private DBManager() {
	} 
	
	public static Connection getConnection() {
		
		conn = null;
		if(conn == null) 
		{
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASS);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
