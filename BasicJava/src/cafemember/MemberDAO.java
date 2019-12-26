package problem.cafemember;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.DBManager;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberDTO mDto;
	
	ArrayList <MemberDTO> list = new ArrayList<>();
	
	
	public void MemberInsert(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO "
					+ "tbl_Membership(bno,name,nickname,pw) "
					+ "VALUES(seq_membership.NEXTVAL,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getName());
			pstmt.setString(2, mDto.getNickname());
			pstmt.setString(3, mDto.getPw());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("투썸 멤버십 계정이 등록이 되었습니다");
			}else {
				System.out.println("멤버십 생성에 실패했습니다 다시 입력해주세요");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
	
public void MemberSelect(MemberDTO mDto) {
	 try {
		 conn = DBManager.getConnection();
		 String sql = "SELECT * "
		 		+ "FROM tbl_membership "
		 		+ "WHERE nickname = ? AND pw = ?";
		 
		 pstmt = conn.prepareStatement(sql);
		
		 pstmt.setString(1, mDto.getNickname());
		 pstmt.setString(2, mDto.getPw());
		
		 rs = pstmt.executeQuery();
		 
		 list.clear();
		 while(rs.next()) {
			int bno = rs.getInt("bno");
			String name = rs.getString("name");
			String nickname = rs.getString("nickname");
			String pw = rs.getString("pw");
			int point = rs.getInt("point");
			Date regdate = rs.getDate("regdate");
			
			mDto = new MemberDTO(bno, name, nickname, pw, point, regdate);
			list.add(mDto);
		 }
		 for(MemberDTO line : list) {
			 System.out.println(line.toString());
		 }
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
	}
		
	}

public void MemberUpdate(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_membership "
					+ "SET "
					+ "name = ?, "
					+ "nickname = ?, "
					+ "pw = ? "
					+ "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getName());
			pstmt.setString(2, mDto.getNickname());
			pstmt.setString(3, mDto.getPw());
			pstmt.setInt(4, mDto.getBno());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("멤버십 회원의 정보가 수정되었습니다");
			}else {
				System.out.println("회원 정보수정에 실패했습니다 다시 입력해주세요");
			}
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
		
		}
	
}

public void MemberDelete(int bno
		) {
	
	try {
		conn = DBManager.getConnection();
		String sql = "DELETE FROM tbl_membership "
					+"WHERE bno = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		int result = pstmt.executeUpdate();
		
		if(result > 0 ) {
			System.out.println("계정이 삭제되었습니다");
		}else {
			System.out.println("삭제가 되지않았습니다 관리자에게 문의해주세요");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		
	}
	
}

	
}
