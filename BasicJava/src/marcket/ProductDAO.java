package marcket;

import java.awt.print.Printable;
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
		try {
			result = sqlSession.update("pdt.CntPlus", map);

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
			
			for(ProductDTO line :list) {
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
			list = sqlSession.selectList("pdt.search","%"+keyword+"%");
			System.out.println("검색결과 총" + list.size() +"건이 검색되었습니다");
			for(ProductDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
