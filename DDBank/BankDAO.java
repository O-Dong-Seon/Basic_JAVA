package problem.DDBank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.dotorybook.DBManager;

public class BankDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	BankDTO bDto;
	ArrayList<BankDTO> list = new ArrayList<>();

	public void BankInsert(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_bank(bno,bname,pw) "
					+ "VALUES(seq_bank.NEXTVAL,?,?)";  //
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getPw());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("계좌 개설이 완료되었습니다");
			}else {
				System.out.println("계좌가 개설되지 않았습니다 관리자에게 문의해주세요");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}

	}

	public void BankUpdate(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank "
					+ "SET "
					+ "money = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getMoney());
			
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("입금을 완료 했습니다");
			}else {
				System.out.println("입금실패 관리자에게 문의 부탁드립니다");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}

	}
	
	public void BankUpdate2(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank"
					+ "SET"
					+ "money = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getMoney());
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("출금이 완료되었습니다");
			}else {
				System.out.println("출금실패");
			}
				
					
					
					
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

	public void BankSelect(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * "
					   + "FROM tbl_bank "
					   + "WHERE bno = ? AND pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getBno());
			pstmt.setString(2, bDto.getPw());
			rs = pstmt.executeQuery();
			
			list.clear();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String bname = rs.getString("bname");
				String pw = rs.getString("pw");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");
				
				bDto = new BankDTO(bno, bname, pw, money, regdate);
				list.add(bDto);
				
			}
			for(BankDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}

	}

	public void Bankasearch() {

	}

	

}
