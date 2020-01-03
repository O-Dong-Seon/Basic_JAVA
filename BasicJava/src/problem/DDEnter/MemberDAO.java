package problem.DDEnter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.common.DBManager;

public class MemberDAO {
	Connection conn = DBManager.getConnection();
	PreparedStatement pstmt;

	ArrayList<MemberDTO> list = new ArrayList<>();

	// 1.아티스트 등록 
	public void memInsert(MemberDTO mDto) {

		try {
			conn = DBManager.getConnection(); // getConnection 을 타고 conn에 연결정보가 들어감
			String sql = "INSERT INTO tbl_enter(ano,aname,major,groupyn,groupnm,sal)"
					+ "VALUES(seq_enter.NEXTVAL, ?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(mDto.getAname() + "아티스트와 계약을 하였습니다.");
			} else {
				System.out.println("등록에 실패했습니다 관리자에게 문의해주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	// 1.드라이버 로드
	// 2.Connection
	// 3.SQL작성(prparedStatement)s
	// 4.SQL실행
	// 5.Close(연결끊기)

	// 2.아티스트 수정
	public void memUpdate(MemberDTO mDto) {

		try {
			// 1.드라이버 로드
			// 2.Connection
			conn = DBManager.getConnection();
			// 3.SQL작성(preparedStatement)
			String sql = "UPDATE tbl_enter " + "SET aname = ?," + "    major = ?, " + "    groupyn = ?, "
					+ "    groupnm = ?, " + "    sal = ? " + " WHERE ano = ? ";
			// 4. SQL 실행

			pstmt = conn.prepareStatement(sql);
			// MemberDTO에 적힌 순서와는 상관없음
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			pstmt.setString(6, mDto.getAno());
			// 4.SQL 실행

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(mDto.getAname() + "아티스트의 정보가 수정되었습니다");
			} else {
				System.out.println("아티스트의 정보가 수정되지 않았습니다 관리자에게 문의해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. Close(연결끊기)
		}
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	// 3.아티스트 삭제
	public void memDelete(String ano) {
		try {
			// 1.드라이버 로드 2.DB연결

			// 3. SQL문 작성 (prepareStatement 방식)
			String sql = "DELETE FROM tbl_enter " + "WHERE ano = ? ";

			pstmt = conn.prepareStatement(sql);
			// 3.1 미완성 SQL문 완성(바인딩변수 사용)
			pstmt.setString(1, ano);
			// 4.SQL문 실행!!
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(ano + "아티스트와 계약을 해지하였습니다");
			} else {
				System.out.println("삭제에 실패하였습니다. 관리자에게 문의해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	};

	// 4.아티스트 조회
	public void memSelect() {

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_enter";
			pstmt = conn.prepareStatement(sql);

			// 4.SQL실행
			// ResultSet = SELECT문의 결과를 닫음

			ResultSet rs = pstmt.executeQuery(); // SELECT문은 Query 그외엔 Update

			// rs의 값이 있을경우 결과값이 true로 변한다 (값이 없으면 false)
			// 한 줄 씩 읽음
			while (rs.next()) {
				String ano = rs.getString("ano");
				String aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				String groupnm = rs.getString("groupnm");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");

				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate);
				list.add(mDto);
			}

			for (MemberDTO line : list) {
//				System.out.print(line.getAno());
//				System.out.print(line.getAname());
//				System.out.print(line.getMajor());
//				System.out.print(line.getGroupyn());
//				System.out.print(line.getGroupnm());
//				System.out.print(line.getSal()+"\t");
//				System.out.print(line.getRegdate());
//				System.out.println();
				
				System.out.println(line.toString());  // 한줄요약 코드
			
			}

			// ResultSet은 DB관련 개체이므로
			// JAVA전용 ArrayList에 ResultSet에 데이터를
			// 옮겨 담는 작업이 필요
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	};

	// 5.아티스트 검색
	public void memSearch(String aname) {
		try {
			// 1 .드라이버 등록  2.Connection
			conn = DBManager.getConnection();	
			// 3. SQL작성
			String sql = "SELECT * FROM tbl_enter "
					+ "WHERE aname LIKE '%' ||?|| '%'";
					// "WHERE aname LIKE ?";
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, aname);		// (1, "%" + aname + "%");
						
			ResultSet rs = pstmt.executeQuery(); // SELECT문은 Query
			
			while(rs.next()) {
				String ano = rs.getString("ano");
				aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				String groupnm = rs.getString("groupnm");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate);
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
}