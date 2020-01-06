package marcket;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	Boolean flag = false;
//	int minus = 0;
	// 제품 등록&추가 기능 작동시 기존에 등록된 제품인지 최초입고제품인지 판별하는 ㅣ능

	public boolean pdtAlready(String pname) {
		sqlSession = sqlSessionFactory.openSession();

		try {
			result = sqlSession.selectOne("pdt.alredy", pname);

			if (result > 0) {
				flag = true; // flag의 DEFAULT값은 false
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}

	public void pdtCntPlus(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("cnt", cnt);
		map.put("flag", "plus");
		try {
			result = sqlSession.update("pdt.cntchange", map);

			if (result > 0) {
				System.out.println("수량이 정상적으로 입고 되었습니다");
			} else {
				System.out.println("수량이 입고되지않았습니다 다시 확인해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void insertpdt(ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession(true);

		try {
			result = sqlSession.insert("pdt.insert", pDto);

			if (result > 0) {
				System.out.println("물품이 새로 등록되었습니다 ");
			} else {
				System.out.println(" 물품이 등록되지않았습니다 다시 시도해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void updatepdt(ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession(true);

		try {
			result = sqlSession.update("pdt.update", pDto);

			if (result > 0) {
				System.out.println("물품이 정상적으로 수정이 되었습니다");
			} else {
				System.out.println("물품이 수정되지않았습니다 다시 입력해주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void deletepdt(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("pdt.delete", pname);

			if (result > 0) {
				System.out.println("물품정보를 삭제합니다");
			} else {
				System.out.println("물품이 삭제되지않았습니다 다시 입력해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void selectpdt() {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list = sqlSession.selectList("pdt.select");

			for (ProductDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void searchpdt(String keyword) {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list = sqlSession.selectList("pdt.search", "%" + keyword + "%");
			System.out.println("검색결과 총" + list.size() + "건이 검색되었습니다");
			for (ProductDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	// 제품 전체조회(재고가 > 1)
	public List<ProductDTO> selectUsepdt() {
		int i = 1;
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			list = sqlSession.selectList("pdt.selectUse");
			for (ProductDTO line : list) {
				System.out.println(i +"\t"+line.toString());
				i += 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;  //제품이 1개 이상인것을 리턴시킴
	}
 
	// 상품 판매시 재고를 마이너스 하는 함수  
	public void pdtcntMinus(String pname, int cnt) { // 타입이아니라 순서대로 들어오기때문에 이름이 달라도 상관없음
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object>map = new HashMap<>();
		map.put("pname",pname);
		map.put("cnt",cnt);
		map.put("flag","minus");
		
		try {
			sqlSession.update("pdt.cntchange", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
//	public void dashBoard() {
//		sqlSession = sqlSessionFactory.openSession(true);
//		
//		try {
//			list = sqlSession.selectList("sale.dashBoard");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			sqlSession.close();
//		}
//		
//	}
}
