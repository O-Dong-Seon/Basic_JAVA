package problem.DDBoard;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {
//	Connection conn;
//	PreparedStatement pstmt;
//	ResultSet rs;
//	ArrayList<BoardDTO> list = new ArrayList<>();

	BoardDTO bDto;
	int result;

	// mybatis 세팅값 호출
	// Session 을 생성하는 공장을 만드는 과정
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

	// Mapper에 접근하기 위한 sqlSession
	SqlSession sqlSession;
	List<BoardDTO> list;
	public void BoardInsert(String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);

		try {
			BoardDTO bDto = new BoardDTO(title, content, writer);
			result = sqlSession.insert("BoardInsert", bDto);

			if (result > 0) {
				System.out.println("게시글을 생성하였습니다");
			} else {
				System.out.println("게시글 작성에 실패하였습니다 다시 입력해주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void BoardUpdate(int bno, String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);

		HashMap<String, Object> map = new HashMap<>();

		map.put("bno", bno);
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);

		try {
//			BoardDTO bDto = new BoardDTO(bno,title,content,writer);

			result = sqlSession.update("BoardUpdate", map);

			if (result > 0) {
				System.out.println("게시판 수정이 완료되었습니다");
			} else {
				System.out.println("게시판 수정에 실패했습니다 처음부터 다시 입력해주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void BoardDelete(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);

//		HashMap<String,Integer> map = new HashMap<>();
//		map.put("bno", bno);

		try {
			bDto = new BoardDTO(bno);
			result = sqlSession.delete("BoardDelete", bDto);

			if (result > 0) {
				System.out.println("게시글이 삭제 되었습니다");
			} else {
				System.out.println("게시글 삭제가 되지않았습니다 다시 시도해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void BoardSelect() {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list = sqlSession.selectList("BoardSelect");
			
			for(BoardDTO line : list) {
				System.out.println(line.toString());
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void BoardSearch(String keyword) {
	
		sqlSession = sqlSessionFactory.openSession();
		
		
		
		try {
			list = sqlSession.selectList("BoardSearch" , "%"+keyword+"%");
			System.out.println("검색결과 총" + list.size()+"건의 게시글이 검색되었습니다");
			for(BoardDTO line : list) {
				System.out.println(line.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}

//	public void BoardInsert(BoardDTO bDto) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "INSERT INTO tbl_board(bno,title,content,writer)" 
//						+ "VALUES(seq_board.NEXTVAL, ?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, bDto.getTitle());
//			pstmt.setString(2, bDto.getContent());
//			pstmt.setString(3, bDto.getWriter());
//
//			int result = pstmt.executeUpdate();
//
//			if (result > 0) {
//				System.out.println("게시글 등록이 완료되었습니다");
//			} else {
//				System.out.println("게시글 등록이 되지않았습니다 관리자에게 문의해주세요");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
////			try {
////				conn.close();
////			} catch (Exception e2) {
////				e2.printStackTrace();
////			}
//		}
//	}
//
//	public void BoardUpdate(BoardDTO bDto) {
//
//		try {
//			conn = DBManager.getConnection();
//			String sql = "UPDATE tbl_board " 
//					+ "SET "
//					+ "title = ?, "
//					+ "content = ?, " 
//					+ "writer = ? "
//					+ "WHERE bno = ?";
//
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, bDto.getTitle());
//			pstmt.setString(2, bDto.getContent());
//			pstmt.setString(3, bDto.getWriter());
//			pstmt.setInt(4, bDto.getBno());
//
//			int result = pstmt.executeUpdate();
//
//			if (result > 0) {
//				System.out.println("게시글 수정이 완료되었습니다");
//			} else {
//				System.out.println("게시글 수정이 완료되지 않았습니다.관리자에게 문의해주세요");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
////			try {
////				conn.close();
////			} catch (Exception e2) {
////				e2.printStackTrace();
////			}
//		}
//	}
//
//	public void BoardDelete(int bno) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "DELETE FROM tbl_board " 
//					+ "WHERE bno = ? ";
//			pstmt = conn.prepareStatement(sql); //바인딩 변수가 있으므로 pstmt를 
//			pstmt.setInt(1, bno); //바인딩 변수를 채워줘야 하기때문에 set을 사용
//			int result = pstmt.executeUpdate();
//
//			if (result > 0) {
//				System.out.println("게시글이 삭제가 되었습니다");
//			} else {
//				System.out.println("게시글이 삭제가 되지 않았습니다. 관리자에게 문의해주세요");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
////			try {
////				conn.close();
////			} catch (Exception e2) {
////				e2.printStackTrace();
////			}
//		}
//	}
//
//	public void BoardSelect() {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT * FROM tbl_board " 
//						+ "ORDER BY bno DESC ";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			ResultSet rs = pstmt.executeQuery();
//
//			list.clear(); // 기존값을 지우고
//
//			while (rs.next()) {
//				int bno = rs.getInt("bno");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//				String writer = rs.getString("writer");
//				int viewcnt = rs.getInt("viewcnt");
//				Date regdate = rs.getDate("regdate");
//
//				BoardDTO bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
//				list.add(bDto);
//			}
//			System.out.println("==================================================");
//			System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 작성일자");
//			for (BoardDTO line : list) {
//
//				System.out.print(line.toString());
//
////				System.out.print(line.getBno() + "\t");
////				System.out.print(line.getTitle() + "\t");
////				System.out.print(line.getContent() + "\t");
////				System.out.print(line.getWriter() + "\t");
////				System.out.print(line.getRegdate() + "\t");
//
//				System.out.println();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
////			try {
//////				conn.close();
//////				pstmt.close();
//////				rs.close();
////			} catch (Exception e2) {
////				e2.printStackTrace();
////			}
//		}
//
//	}
//
//	public void BoardSearch(String search) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT * " 
//					+ "FROM tbl_board " 
//					+ "WHERE title LIKE ? " 
//					+ "OR content LIKE ?"; // 게시글과
//																										// 타이틀둘다
//																										// 검색가능
//			// "SELECT * FROM tbl_board " + "WHERE title LIKE '%'||?||'%' ";
//
//			pstmt = conn.prepareStatement(sql); // pstmt방식으로 sql문을 실행
//			pstmt.setString(1, "%" + search + "%");
//			pstmt.setString(2, "%" + search + "%");
//
//			rs = pstmt.executeQuery();
//
//			// ResultSet rs = pstmt.executeQuery();
//
//			list.clear(); // 기존값을 지우고
//
//			while (rs.next()) {
//				int bno = rs.getInt("bno");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//				String writer = rs.getString("writer");
//				Date regdate = rs.getDate("regdate");
//				int viewcnt = rs.getInt("viewcnt");
//				BoardDTO bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
//				list.add(bDto);
//			}
//			System.out.println("＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃");
//			System.out.println("\"" + search + "\"(으)로 검색한결과 총" + list.size() + "건이 나왔습니다");
//			System.out.println("＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃");
//			System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 작성일자");
//			System.out.println("＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃");
//			for (BoardDTO line : list) {
//
//				System.out.print(line.toString());
//
////				System.out.print(line.getBno() + "\t");
////				System.out.print(line.getTitle() + "\t");
////				System.out.print(line.getContent() + "\t");
////				System.out.print(line.getWriter() + "\t");
////				System.out.print(line.getRegdate() + "\t");
//
//				System.out.println();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
////			try {
////				conn.close();
////			} catch (Exception e2) {
////				e2.printStackTrace();
////			}
//		}
//
//	}
//
//	public void Boardview(int bno) {
//		// 상세게시글 조회수 +1 증가
//		int result = viewcntPlus(bno);
//		if (!(result > 0)) {
//			System.out.println("조회수 증가 실패");
//			return;
//		} else {
//			System.out.println("조회수 증가 성공");
//		}
//
//		// 상세게시글 출력
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT * " 
//						+ "FROM tbl_board "
//						+ "WHERE bno = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bno);
//
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//
//				bno = rs.getInt("bno");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//				String writer = rs.getString("writer");
//				int viewcnt = rs.getInt("viewcnt");
//				Date regdate = rs.getDate("regdate");
//				bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
//			}
//			System.out.println("게시글 번호" + bno + "제목" + bDto.getTitle());
//			System.out.println("작성일자" + bDto.getRegdate());
//			System.out.println("작성자" + bDto.getWriter());
//			System.out.println("조회수" + bDto.getViewcnt());
//			System.out.println("제목" + bDto.getTitle());
//			System.out.println("내용" + bDto.getContent());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//		}
//
//	}
//
//	public void Boardsort() {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT * "
//			+ "FROM tbl_board " 
//			+ "ORDER BY viewcnt DESC";
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery();
//			list.clear();
//			while (rs.next()) {
//
//				int bno = rs.getInt("bno");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//				String writer = rs.getString("writer");
//				int viewcnt = rs.getInt("viewcnt");
//				Date regdate = rs.getDate("regdate");
//
//				bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
//				
//				list.add(bDto);
//
//			}
//			for (BoardDTO line : list) {
//				System.out.println(line.toString());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//		}
//
//	}
//
//	public int viewcntPlus(int bno) {
//
//		try {
//			conn = DBManager.getConnection();
//			String sql = "UPDATE tbl_board " 
//					+ "SET viewcnt = viewcnt + 1 " 
//					+ "WHERE bno = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bno);
//
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//		}
//		return result;
//	}
//		// 조회된 결과를 출력하는 함수
//	
//		public void printQuery(ArrayList<BoardDTO> list) {
//			
//		}
//	

}
