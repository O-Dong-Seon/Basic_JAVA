package problem.DDBank;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BankDAO {
	// mybatis 세팅값 호출
	// Session을 생성하는 공장을 만드는 과정
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;

	List<BankDTO> list;
	int result;
	


	// 신규 계좌 개설
	public void insertBank(String bname, String pw) {
		sqlSession = sqlSessionFactory.openSession(true); // 자동으로 커밋을 해줌 sqlSession.commit(); 를 입력하지 않아도 됨

		try {
			BankDTO bDto = new BankDTO(bname, pw);
			result = sqlSession.insert("insertBank", bDto);
			// sqlSession.commit(); openSession()안에 true를 넣으면 입려해줄 필요가 없음
			if (result > 0) {
				System.out.println(bname + "님 신규계좌를 개설하였습니다");
			} else {
				System.out.println("계좌 개설에 실패하였습니다. 관리자에게 문의해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	// 계좌 전체조회
	public void selectBank() {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list = sqlSession.selectList("selBank"); // selectlist- 결과 값이 여러건일때 , selectone - 결과 값이 한 건 일때

			for (BankDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void updateIn(int bno , int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		HashMap<String, Integer>map = new HashMap<>();
		map.put("bno", bno);
		map.put("money", money);
		map.put("flag", 1); // 동적쿼리(입금 or 출금 유무)
		
		try {
//			BankDTO bDto = new BankDTO(bno, money);
			result = sqlSession.update("changeMoney", map);
			
			if(result > 0 ) {
				System.out.println(money + "원이 입금되었습니다");
				System.out.println("현재 계좌  잔액은" + balanceMoney(bno) + "입니다");
			}else {
				System.out.println("입금에 실패했습니다 처음부터 다시 입력해주세요");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}
	
	public void updateOut(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
				
		HashMap<String , Integer>map = new HashMap<>();
		map.put("bno", bno);
		map.put("money" , money);
		map.put("flag" , 0);
		try {
			result = sqlSession.update("changeMoney", map);
			
			if(result > 0) {
				System.out.println(money + "원이 출금되었습니다" );
				System.out.println("현재 계좌 잔액은" + balanceMoney(bno));
			}else {
				System.out.println("출금이 실패했습니다 처음부터 다시 입력해주세요");
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
	}

	public void selectAccount(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			BankDTO bDto = new BankDTO(bno,pw);
			bDto = sqlSession.selectOne("selectAccount", bDto);
			
			// SelectOne 일땐 -> DTO
			// SelectList 일땐 -> List or DTO
			
			if(bDto == null) {
				System.out.println("존재하지 않는 계좌번호잆니다, 다시 입력해주세요");
				return;
			}else {
				System.out.println(bno + "계좌의 총 금액은" + bDto.getMoney() + "원 입니다");
			}
				
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}
	
	//계좌 해지
	public void deleteBank(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		HashMap<String, Object>map = new HashMap<>(); 			//hashmap은 <key,value>
		map.put("bno", bno);
		map.put("pw", pw);
		
		try {
					
			
//			BankDTO bDto = new BankDTO(bno,pw);
			result = sqlSession.delete("deleteBank" , map);
//			
			if(result > 0) {
				System.out.println("계좌가 해지되었습니다");
			}else {
				System.out.println("계좌가 해지되지않았습니다 다시 입력해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	//계좌 잔액 조회
	public int balanceMoney(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		int money = 0;
		try {
			money = sqlSession.selectOne("balanceMoney", bno);
			System.out.println("현재 잔액 : " + money);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return money;			
	}
	
	public boolean checkUser(int bno, String pw) {
		boolean flag = false;
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("pw", pw);
		try {
			result = sqlSession.selectOne("checkUser" , map);
			
			if(result > 0) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
		return flag;
	}
}
//	
//	Connection conn;
//	PreparedStatement pstmt;
//	ResultSet rs;
//	BankDTO bDto;
//
//	public void BankInsert(BankDTO bDto) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "INSERT INTO tbl_bank(bno,bname,pw) "
//					+ "VALUES(seq_bank.NEXTVAL,?,?)";  //
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, bDto.getBname());
//			pstmt.setString(2, bDto.getPw());
//			
//			int result = pstmt.executeUpdate();
//			
//			if(result > 0) {
//				System.out.println("계좌 개설이 완료되었습니다");
//			}else {
//				System.out.println("계좌가 개설되지 않았습니다 관리자에게 문의해주세요");
//			}
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			
//		}
//
//	}
//
//	public void BankUpdate(BankDTO bDto) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "UPDATE tbl_bank "
//					+ "SET "
//					+ "money = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bDto.getMoney());
//			
//			
//			int result = pstmt.executeUpdate();
//			
//			if(result > 0) {
//				System.out.println("입금을 완료 했습니다");
//			}else {
//				System.out.println("입금실패 관리자에게 문의 부탁드립니다");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			
//		}
//
//	}
//	
//	public void BankUpdate2(BankDTO bDto) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "UPDATE tbl_bank"
//					+ "SET"
//					+ "money = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bDto.getMoney());
//			int result = pstmt.executeUpdate();
//			
//			if(result > 0) {
//				System.out.println("출금이 완료되었습니다");
//			}else {
//				System.out.println("출금실패");
//			}
//				
//
//	}catch(
//
//	Exception e)
//	{
//			e.printStackTrace();
//		}finally
//	{
//
//	}
//	}
//
//	public void BankSelect(BankDTO bDto) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT * " + "FROM tbl_bank " + "WHERE bno = ? AND pw = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bDto.getBno());
//			pstmt.setString(2, bDto.getPw());
//			rs = pstmt.executeQuery();
//
//			list.clear();
//
//			while (rs.next()) {
//				int bno = rs.getInt("bno");
//				String bname = rs.getString("bname");
//				String pw = rs.getString("pw");
//				int money = rs.getInt("money");
//				Date regdate = rs.getDate("regdate");
//
//				bDto = new BankDTO(bno, bname, pw, money, regdate);
//				list.add(bDto);
//
//			}
//			for (BankDTO line : list) {
//				System.out.println(line.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//		}
//
//	}
//
//	public void Bankasearch() {
//
//	}
//
//}
