package problem.DDEnter;

import java.util.Scanner;

public class DDEnterMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		// 1.화면에 출력하는 부분
		while (true) {
			System.out.println("더블디 엔터 관리시스템");
			System.out.println("1. 아티스트 등록");
			System.out.println("2. 아티스트 수정");
			System.out.println("3. 아티스트 해지");
			System.out.println("4. 아티스트 조회");
			System.out.println("5. 아티스트 검색");
			System.out.println("6. 프로그램 종료");
			
			
			// 2. 사용자가 실행할 프로그램을 입력받는 부분
			int code = 0;
			while (true) {
				System.out.print("번호 입력>>");
				 code = sc.nextInt();

				// 사용자가 1~6까지 입력하기전까지
				// 계속 번호를 입력하게 도는 반복문(경고 메시지 출력)

				// 1~6인 경우에만 무한반복을 빠져나감!
				if (code >= 1 && code <= 6) { // 참 참
					break; //가장 가까운 반복문을 빠져나감
				} else {
					System.err.println("1~6까지만 입력해주세요");
					continue;
				}

			} 
			MemberDAO mDao = new MemberDAO();
			// 사용자가 입력한 값 1~6인 경우
			if(code == 1) {        // 등록
				System.out.println("계약할 아티스트 번호를 입력해주세요");
				System.out.print("이름>>");
				sc.nextLine();
				String aname = sc.nextLine();
				System.out.print("분야>>");
				String major = sc.nextLine();
				System.out.print("그룹유무(y/n)>>");
				String groupyn = sc.nextLine();
				System.out.print("그룹이름>>");
				String groupnm = sc.nextLine();
				System.out.print("연봉>>");
				int sal = sc.nextInt();
				
				MemberDTO  mDto = new MemberDTO(aname, major, groupyn, groupnm, sal); 
				// mDto라는 공간이 만들어짐
				
				mDao.memInsert(mDto);
			}else if (code == 2) { // 수정
	            System.out.println("수정할 아티스트 번호를 입력해주세요");
				System.out.print("번호>>");
				sc.nextLine();
				String ano = sc.nextLine();
			
				// 이름,전공,그룹유무,그룹이름, 연봉
				String aname = sc.nextLine();
				System.out.print("분야>>");
				String major = sc.nextLine();
				System.out.print("그룹유무(y/n)>>");
				String groupyn = sc.nextLine();
				System.out.print("그룹이름>>");
				String groupnm = sc.nextLine();
				System.out.print("연봉>>");
				int sal = sc.nextInt();
				
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal);
				
				mDao.memUpdate(mDto);
			}else if (code == 3) { // 소속 삭제
				System.out.println("삭제할 아티스트 번호를 입력해주세요");
				System.out.println("번호>>");
				sc.nextLine();
				String ano = sc.nextLine();
				
				mDao.memDelete(ano);
				
			}else if (code == 4) { // 조회
				mDao.memSelect();
			}else if (code == 5) { // 검색
				mDao.memSearch();
			}else if (code == 6) { 
				System.out.println("<프로그램 종료>");
				System.exit(0);  // 숫자마다 옵션이 존재 0은 종료 
			}
		}
	}

}
