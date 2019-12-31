package problem.DDBoard;

import java.util.Scanner;

public class DDBoardMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BoardDAO bDao = new BoardDAO();

		System.out.println("♣디디 게시판♣");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.게시글 조회");
		System.out.println("5.게시글 검색");
		System.out.println("6.게시글 정렬");
		System.out.println("7.상시 게시글");
		System.out.println("8. 만든이");

		int code = 0;
		while (true) {
			System.out.println("번호>>");
			code = sc.nextInt();

			if (code >= 1 && 9 >= code) {
				break;
			} else {
				System.out.println("1~7까지만 입력해주세요");
				continue;
			}

		}

		if (code == 1) {
			System.out.println("게시글을 등록합니다");
			System.out.println("제목>>");
			sc.nextLine();
			String title = sc.nextLine();
			
			System.out.println("내용>>");
			String content = sc.nextLine();
			System.out.println("작성자>>");
			String writer = sc.nextLine();

//			BoardDTO bDto = new BoardDTO(title, content, writer);

			bDao.BoardInsert(title, content, writer);

		} else if (code == 2) {

		} else if (code == 3) {

		} else if (code == 4) {

		} else if (code == 5) {

		} else if (code == 6) {

		} else if (code == 7) {

		} else if (code == 8) {

		}
	}

//		Scanner sc = new Scanner(System.in);
//		
//		BoardDAO bDao = new BoardDAO();
//		
//	
//		
//		while (true) {
//			System.out.println("◆ 디디게시판 ◆");
////			bDao.BoardSelect();
//			System.out.println("1. 게시글 등록");
//			System.out.println("2. 게시글 수정");
//			System.out.println("3. 게시글 삭제");
//			System.out.println("4. 게시글 조회");
//			System.out.println("5. 게시글 검색");
//			System.out.println("6. 게시글 정렬");
//			System.out.println("7. 상세 게시글");
//			System.out.println("8. 만든이");
//			System.out.println("9. 프로그램 종료");
//			
//		int code = 0; // 사용자가 선택한 프로그램 번호
//			
//			while (true) {
//				System.out.println("번호>>");
//				code = sc.nextInt();
//				
//				if (code >= 1 && code <= 9) {
//					break;
//				} else {
//					System.out.println("1~9까지의 값만 입력해주세요");
//					continue;
//				}
//				
//				
//			}
//			
//			if(code == 1) {
//				System.out.println("게시판을 등록합니다");
//				sc.nextLine();
//				
//				System.out.println("제목>>");
//				String title = sc.nextLine();
//				System.out.println("내용>>");
//				String content = sc.nextLine();
//				System.out.println("글쓴이");
//				String writer = sc.nextLine();
//				
////				BoardDTO bDto = new BoardDTO(title, content, writer);
////				bDao.BoardInsert(bDto);
//				
//			}else if(code == 2) {
//				System.out.println("수정할 게시판을 적어주세요");
//				System.out.println("번호>>");
//				int bno = sc.nextInt();
//				sc.nextLine();
//				
//				System.out.println("제목>>");
//				String title = sc.nextLine();
//				System.out.println("내용>>");
//				String content = sc.nextLine();
//				System.out.println("작성자");
//				String writer = sc.nextLine();
//				
//				BoardDTO bDto = new BoardDTO(bno, title, content, writer);
////				bDao.BoardUpdate(bDto);
//				
//				
//				
//			}else if(code == 3) {
//				System.out.println("삭제할 게시판 번호를 입력해주세요");
//				System.out.println("번호>>");
//				int bno = sc.nextInt();
//				sc.nextLine();
//				
////				bDao.BoardDelete(bno);
//				
//			}else if(code == 4) {
//				System.out.println("게시글을 조회합니다");
////				bDao.BoardSelect();
//			}else if(code == 5) { // 게시글로만 검색하기
//				
//				System.out.println("검색할 키워드를 입력하세요");
//				sc.nextLine();
//				System.out.println("검색>>");
//				
//				String search = sc.nextLine();
//			
////				bDao.BoardSearch(search);
//				
//				
//			}else if(code == 6) {
//				System.out.println("조회순으로 정렬됩니다");
//				
//				
////				bDao.Boardsort();
//			
//			}else if(code == 7) {
//				System.out.println("보고싶은 게시글 번호를 입력하세요");
//				System.out.println("게시글번호>>");
//				int bno = sc.nextInt();
//				
////				bDao.Boardsort();
//				
//				
//			}else if(code == 8) {
//				System.out.println("Name: DD Board Program");
//				System.out.println("Version: 1.7");
//				System.out.println("Use: JAVA, ORACLE");
//				System.out.println("date:2019.12.17");
//				System.out.println("made by 비폭력간디");
//				System.out.println("ehdtjs88kr@naver.com");
//				
//			}else if(code == 9) {
//				System.out.println("◆프로그램종료◆");
//				System.exit(0);
//			}
//			
//			
//			
//			
//			
//		}
//	}
}
