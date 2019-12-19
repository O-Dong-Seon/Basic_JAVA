package problem.DDBank;

import java.util.Scanner;

public class DDBankMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BankDAO bDao = new BankDAO();

		while (true) {

			System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
			System.out.println("허쉬 은행");
			System.out.println("1. ♣계좌 개설");
			System.out.println("2. ♣입금");
			System.out.println("3. ♣출금");
			System.out.println("4. ♣계좌 조회");
			System.out.println("5. ♣사용자 검색");
			System.out.println("6. ♣프로그램 종료");

			int code = 0;
			// 1. 프로그램 전체반복
			// 2. 1~6번까지 번호만 허용(나머지는 무한반복 다시입력)
			// 3. 계좌개설 만들기(INSERT)
			// 4. 계좌조회 만들기(SELECT,전체조회)
			// 5. 사용자 검색 만들기(이름으로)
			// 6. 프로그램 종료기능 만들기
			while (true) {
				System.out.println("번호>>");
				code = sc.nextInt();

				if (code >= 1 && code <= 9) {
					break;
				} else {
					System.out.println("1~6까지의 값만 입력해주세요");
					continue;
				}
			}
		

			if (code == 1) {
				System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
				System.out.println("계좌를 개설합니다");
				sc.nextLine();
				System.out.println("예금주>>");
				String bname = sc.nextLine();
				System.out.println("계좌 비밀번호>>");
				String pw = sc.nextLine();

				BankDTO bDto = new BankDTO(bname, pw);
				bDao.BankInsert(bDto);

			} else if (code == 2) {
				System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
				System.out.println("입금할 계좌번호와 금액 입력해주세요");
				System.out.println("계좌번호>>");
				int bno = sc.nextInt();
				
				System.out.println("입금금액>>");
				sc.nextLine();
				int money = sc.nextInt();
								
				BankDTO bDto = new BankDTO(bno, money);
				bDao.BankUpdate(bDto);

			} else if (code == 3) {
				System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
				System.out.println("출금할 계좌번호와 금액을 입력해주세요");
				System.out.println("계좌번호>>");
				String bno = sc.nextLine();
				sc.nextLine();
				
				System.out.println("출금금액>>");
				int money = sc.nextInt();
				
				BankDTO bDto = new BankDTO(bno, money);
				bDao.BankUpdate2(bDto);
				

			} else if (code == 4) {
				System.out.println("사용자의 계좌를 조회합니다");
								
				System.out.println("계좌번호 입력>>");
				int bno = sc.nextInt();
				System.out.println("비밀번호 입력>>");
				sc.nextLine();
				String pw = sc.nextLine();
				
				BankDTO bDto = new BankDTO(bno, pw);
				bDao.BankSelect(bDto);
			} else if (code == 5) {

			} else if (code == 6) {

			}
		}

	}
}