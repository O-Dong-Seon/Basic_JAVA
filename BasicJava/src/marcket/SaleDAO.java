package marcket;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;


// 판매 관련 DAO 클래스
public class SaleDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<SaleDTO> list;

	public int insertSale(HashMap<String, Object> map) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("sale.insert", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	// 일일 판매량 출력함수
	public void dashBoard() {
		sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		int price = 0;
		
		try {
			int i = 0;
			list = sqlSession.selectList("sale.dashBoard");
			System.out.println("번호\t 제품명\t 판매수량\t 가격");
			for(SaleDTO line : list) {
				System.out.println((i+1)+"\t" );
				System.out.println("오늘 판매한 제품은"+ +list.size() + "개 입니다");
				System.out.println(line.getSname() + "\t");
				System.out.println(line.getCnt() + "\t");
				System.out.println(line.getTprice() + "\t");
				System.out.println();
				cnt += list.get(i).getCnt();
				price += list.get(i).getTprice();
				i += 1;
			}
				System.out.println("오늘 판매한 제품은 총"+ list.size() + "종류") ;
				System.out.println("총"+ cnt +"개,판매액" + price + "원 입니다");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}
}
