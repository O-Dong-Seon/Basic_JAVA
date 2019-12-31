package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {    //정적블럭 : 클래스 로딩시 1회만 실행되는 코드
		String resource = "mybatis/Configuration.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(resource); //resource 변수 경로에 있는 파일을 읽어서 reader에 넣음
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //build 패턴  - b
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	} //정적블럭

	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}
