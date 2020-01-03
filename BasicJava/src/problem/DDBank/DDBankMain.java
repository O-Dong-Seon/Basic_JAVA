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
			System.out.println("2. ♣계좌 해지");
			System.out.println("3. ♣입금");
			System.out.println("4. ♣출금");
			System.out.println("5. ♣계좌 조회");
			System.out.println("6. ♣사용자 검색");
			System.out.println("7. ♣프로그램 종료");

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
				System.out.println("예금주>>");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.println("계좌 비밀번호>>");
				String pw = sc.nextLine();

//				BankDTO bDto = new BankDTO(bname, pw);
//				bDao.BankInsert(bDto);

				bDao.insertBank(bname,pw);
				
			} else if(code == 2) {
				System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
				System.out.println("계좌를 해지합니다. 해지할 계좌번호를 입력해주세요");
				System.out.println("계좌번호>>");
				int bno = sc.nextInt();
							
				System.out.println("비밀번호>>");
				sc.nextLine();
				String pw = sc.nextLine();
				
				bDao.deleteBank(bno,pw);
				
			} else if (code == 3) {
				System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
				System.out.println("입금할 계좌번호와 금액 입력해주세요");
				System.out.println("계좌번호>>");
				int bno = sc.nextInt();
				
				System.out.println("입금금액>>");
				sc.nextLine();
				int money = sc.nextInt();
								
//				BankDTO bDto = new BankDTO(bno, money);
//				bDao.BankUpdate(bDto);

				bDao.updateIn(bno,money);
				
			} else if (code == 4) {
				System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
				System.out.println("출금할 계좌번호와 금액을 입력해주세요");
				System.out.println("계좌번호>>");
				int bno = sc.nextInt();
				
				System.out.println("비밀번호>>");
				sc.nextLine();
				String pw = sc.nextLine();
				
				if(bDao.checkUser(bno, pw)) {
					// 체크를 통과한 경우에만 출금 가능
					int balance = bDao.balanceMoney(bno); 
					System.out.println("잔액 :" + balance);
					System.out.println("출금하실 금액을 입력해주세요");
					System.out.println("출금액>>");
					int money = sc.nextInt();
					
					if(balance < money) {
						System.out.println("잔액이 부족합니다. 확인해주세요");
					}else {
						bDao.updateOut(bno, money);
						
					}
					
					
				}else {
					System.out.println("존재하지 않는 계좌번호이거나 암호가 틀렷습니다");
				}
				
				// 잔액  = 출금액 = 0    		>> 출금
				// 잔액  > 출금액 = 잔액 - 출금액 	>> 출금
				// 잔액  < 출금액 = 잘못입력		>> 경고메세지
				
					
			
//				BankDTO bDto = new BankDTO(bno, money);
//				bDao.BankUpdate2(bDto);
//				
//				bDao.updateOut(bno, pw);

			} else if (code == 5) {
				System.out.println("사용자의 계좌잔액을 조회합니다");
								
				System.out.println("계좌번호 입력>>");
				int bno = sc.nextInt();
				System.out.println("비밀번호 입력>>");
				sc.nextLine();
				String pw = sc.nextLine();
				
//				BankDTO bDto = new BankDTO(bno, pw);
//				bDao.BankSelect(bDto);
				
				bDao.selectAccount(bno, pw);
				
			} else if (code == 6) {
				System.out.println("사용자의 계좌 전체를 조회합니다");
				
				bDao.selectBank();
				
			} else if (code == 6) {

			}
		}

	}
}