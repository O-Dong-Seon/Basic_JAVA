package problem.cafemember;

import java.util.Scanner;

public class CafeMemberMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MemberDAO mDao = new MemberDAO();
		MemberDTO mDto;

		int code = 0;

		while (true) {
			System.out.println("투썸멤버십");
			System.out.println("1. 멤버십 등록");
			System.out.println("2. 멤버십 조회");
			System.out.println("3. 멤버십 수정");
			System.out.println("4. 멤버십 탈퇴");
			System.out.println("5. 프로그램 종료");

			System.out.println("무엇을 도와드릴까요?>>");
			code = sc.nextInt();

			if (code == 1) {
				System.out.println("회원을 등록합니다");
				System.out.print("이름>>");
				sc.nextLine();

				String name = sc.nextLine();
				System.out.println("닉네임>>");
				String nickname = sc.nextLine();
				System.out.println("비밀번호>>");
				String pw = sc.nextLine();

				mDto = new MemberDTO(name, nickname, pw);
				mDao.MemberInsert(mDto);

			} else if (code == 2) {
				System.out.println("멤버십 회원을 조회합니다");
				System.out.print("닉네임>>");
				sc.nextLine();
				String nickname = sc.nextLine();

				System.out.println("비밀번호>>");
				String pw = sc.nextLine();

				mDto = new MemberDTO(nickname, pw);
				mDao.MemberSelect(mDto);

			} else if (code == 3) {
				System.out.println("멤버십회원 정보를 수정합니다");
				System.out.println("회원번호>>");
				int bno = sc.nextInt();

				System.out.println("이름>>");
				sc.nextLine();
				String name = sc.nextLine();

				System.out.println("닉네임>>");
				String nickname = sc.nextLine();
				System.out.println("비밀번호>>");
				String pw = sc.nextLine();

				mDto = new MemberDTO(bno, name, nickname, pw);
				mDao.MemberUpdate(mDto);

			} else if (code == 4) {
				System.out.println("멤버십 회원 계정을 삭제합니다");
				System.out.println("삭제할 회원 계정>>");
				int bno = sc.nextInt();
				sc.nextLine();
				
				mDao.MemberDelete(bno);
						
				

			}
		}
	}
}
