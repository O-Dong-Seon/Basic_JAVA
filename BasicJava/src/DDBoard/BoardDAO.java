package problem.DDBoard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.DBManager;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>();

	public void BoardInsert(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno,title,content,writer)" + "VALUES(seq_board.NEXTVAL, ?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("게시글 등록이 완료되었습니다");
			} else {
				System.out.println("게시글 등록이 되지않았습니다 관리자에게 문의해주세요");
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
	}

	public void BoardUpdate(BoardDTO bDto) {

		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board " + "SET " + "title = ?, " + "content = ?, " + "writer = ? "
					+ "WHERE bno = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setInt(4, bDto.getBno());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("게시글 수정이 완료되었습니다");
			} else {
				System.out.println("게시글 수정이 완료되지 않았습니다.관리자에게 문의해주세요");
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
	}

	public void BoardDelete(int bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_board " + "WHERE bno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("게시글이 삭제가 되었습니다");
			} else {
				System.out.println("게시글이 삭제가 되지 않았습니다. 관리자에게 문의해주세요");
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
	}

	public void BoardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ResultSet rs = pstmt.executeQuery();

			list.clear(); // 기존값을 지우고

			while (rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String regdate = rs.getString("regdate");

				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
				list.add(bDto);
			}
			System.out.println("==================================================");
			System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 작성일자");
			for (BoardDTO line : list) {

				System.out.print(line.toString());

				System.out.print(line.getBno() + "\t");
				System.out.print(line.getTitle() + "\t");
				System.out.print(line.getContent() + "\t");
				System.out.print(line.getWriter() + "\t");
				System.out.print(line.getRegdate() + "\t");

				System.out.println();
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

	}

	public void BoardSearch(String search) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " + "WHERE title LIKE '%'||?||'%' ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			ResultSet rs = pstmt.executeQuery();

			list.clear(); // 기존값을 지우고

			while (rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String regdate = rs.getString("regdate");

				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
				list.add(bDto);
			}
			System.out.println("==================================================");
			System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 작성일자");
			for (BoardDTO line : list) {

				System.out.print(line.toString());

				System.out.print(line.getBno() + "\t");
				System.out.print(line.getTitle() + "\t");
				System.out.print(line.getContent() + "\t");
				System.out.print(line.getWriter() + "\t");
				System.out.print(line.getRegdate() + "\t");

				System.out.println();
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

	}

	public void Boardview() {
	}

	public void Boardsort() {
	}
}
