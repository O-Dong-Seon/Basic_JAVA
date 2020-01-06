package marcket;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MarcketMain {
	// 내부 저장소 (관리자 계정 ID와 PW 선언)
	// 프로그램을 최초실행시 로그인을 하게 만듬
	// (전역변수)
	String id = "admin";
	String pw = "1234";

	// Static은 공용의 개념
	public static void main(String[] args) { // 모든것은 메인클래스 먼저 시작
		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		MarcketMain mm = new MarcketMain(); // 자기자신도 객체생성했음
		int code = 0;
		Boolean flag = false;
		SaleDAO sDao = new SaleDAO();

		// 프로그램 시작
		String userid = ""; // 지역변수로 선언 된것
		String userpw = ""; // 지역변수로 선언 된것
		System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
		System.out.println("♣♣ Marcket System Ver1.0");

		// 로그인 체크
		// do { // do while은 반복문에 있는 조건을 최초에 1번만 시킬것이나,그냥 반복문이 true경우만 돌릴경우
		// System.out.println("♣♣ [MSG] Please login to use.");
		// System.out.println("♣♣ ID>> ");
		// userid = sc.nextLine(); // admin
		// System.out.println("♣♣ PW>> ");
		// userpw = sc.nextLine(); // 1234
		// } while (mm.login(userid, userpw)); // 실패했을시 다시 로그인 (true인경우 실패)

		// 로그인 성공 시 업무 시작
		while (true) {
			System.out.println("♣ 1. 제품 판매");
			System.out.println("♣ 2. 제품 등록 & 추가"); // 제품이 처음 들어왔을때 등록 / 재고를 더 주문할경우 (DB에)물품자체는 등록이 되어있으니 재고 수량만 늘어나게해야한다
			System.out.println("♣ 3. 제품 수정");
			System.out.println("♣ 4. 제품 삭제");
			System.out.println("♣ 5. 제품 조회");
			System.out.println("♣ 6. 제품 검색");
			System.out.println("♣ 7. 일일 매출현황");
			System.out.println("♣ 8. 프로그램 종료");
			System.out.print("번호>>");

			code = sc.nextInt();
			if (code >= 0 && code <= 7) {

				break;
			} else {
				System.out.println("1~7까지의 숫자만 입력해주세요");
				continue;

			}
		}

		if (code == 1) {
			System.out.println("구매하고 싶은 제품의 번호와 수량을 입력하세요.");
			// 현재 등록된 제품중 재고가 1보다 큰것(수량이 0이 아닌 제품을 제외)
			List<ProductDTO> list = pDao.selectUsepdt();
			int buyCode = 0; // 구매할 상품번호
			int cnt = 0; // 재고수량
			int price = 0; // 가격
			int tprice = 0; // 토탈 가격 (cnt*price)
			String pname;
			while (true) {
				System.out.print("구매할 제품>>");
				sc.nextLine();
				buyCode = sc.nextInt();
				System.out.print("구매할 수량>>");
				cnt = sc.nextInt();
				// 사용자가 구매하려는 제품의 1개 가격
				price = list.get(buyCode - 1).getPrice();
				System.out.println(price);
				// 판매할 제품명
				pname = list.get(buyCode - 1).getPname();
				// 총가격 = 구매수량 x 개당 가격
				tprice = price * cnt;
				// 현재 재품 재고량
				int nowCnt = list.get(buyCode - 1).getCnt();

				if (nowCnt >= cnt) {
					System.out.println("구매 진행");
					break;
				} else {
					System.out.println("재고가 부족합니다");
				}
			}
			// tbl_sale에 판매기록을 저장(판매한 제품명 , 수량, 총가격)
			HashMap<String, Object> map = new HashMap<>();
			map.put("sname", pname);
			map.put("cnt", cnt);
			map.put("tprice", price);
			int result = sDao.insertSale(map);
			if (result > 0) {
				System.out.println("구매 완료");
				// tbl_product에서 재고를 마이너스
				pDao.pdtcntMinus(pname, cnt);
			} else {
				System.out.println("Error,contact your admin");
			}

		} else if (code == 2)

		{
			System.out.println("제품 등록&추가");
			System.out.print("♣제품명>>");
			sc.nextLine();
			String pname = sc.nextLine();

			if (pDao.pdtAlready(pname)) {
				// 기존에 등록된 제품이므로 추가(UPDATE)기능
				// 입고수량 입력받아서 UPDATE
				System.out.println("♣입고수량>>");
				int cnt = sc.nextInt();
				pDao.pdtCntPlus(pname, cnt);
			} else {
				// 최초 등록된 제품이므로 등록(INSERT)
				// bno,pname은 자동으로 값을 가져주니
				// company(제조회사),price(가격), cnt(입고수량)만 입력받아서 INSERT
				System.out.print("♣제조회사>>");
				String company = sc.nextLine();
				System.out.print("♣가격>>");
				int price = sc.nextInt();
				System.out.print("♣입고수량>>");
				int cnt = sc.nextInt();
				ProductDTO pDto = new ProductDTO(pname, company, price, cnt);

				pDao.insertpdt(pDto);

			}

		} else if (code == 3) {
			System.out.println("물품정보를 수정합니다");
			System.out.print("제품명>>");
			sc.nextLine();
			String pname = sc.nextLine();
			System.out.print("제조회사>>");
			String company = sc.nextLine();
			System.out.print("가격>>");
			int price = sc.nextInt();
			System.out.print("수량>>");
			int cnt = sc.nextInt();

			ProductDTO pDto = new ProductDTO(pname, company, price, cnt);

			pDao.updatepdt(pDto);

		} else if (code == 4) {
			System.out.println("물품정보를 삭제합니다");
			System.out.print("제품이름>>");
			sc.nextLine();
			String pname = sc.nextLine();

			pDao.deletepdt(pname);

		} else if (code == 5) {
			System.out.println("물품정보를 조회합니다");

			pDao.selectpdt();

		} else if (code == 6) {
			System.out.println("제품을 검색합니다");
			System.out.print("키워드>>");
			sc.nextLine();
			String keyword = sc.nextLine();

			pDao.searchpdt(keyword);
		} else if (code == 7) {
			System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
			System.out.println("♣♣일일 매출 현황");
			sDao.dashBoard();

		} else if (code == 8) {

		} else if (code == 9) {
			System.out.println(" [MSG] Exit the program");
			System.exit(0);
		}
	}

	public boolean login(String userid, String userpw) { // 공백 두개가 들어가 있음
		Boolean flag = true; // 로그인 유무 판별(true:실패 , false:성공)

		if (userid.equals(id) && userpw.contentEquals(pw)) { // 로그인 성공 / &&는 둘다 값이 같을때 그 값이 나옴
			flag = false;
			System.out.println("환영합니다 관리자님");
		} else {
			System.out.println("[MSG] Login denied.");
		}

		return flag; // 결과값을 flag로 가져감
	}

}

/*
 * 판매기능 1.현재 편의점에 등록된 재고가 0 이상인 상품을 모두 조회해서 출력한다. (SELECT ~WHERE)
 * 
 * 2.사용자가 구매를한다. (조건:한 번에 한 상품 구매가능 수량은 여러개가능) 구매할 제품번호와 수량을 입력받는다 예를들면 1001
 * 코카콜라 3개를 구매(개당 가격은 1000원)
 * 
 * 3.입력받은 값으로 tbl_product에서 cnt를 판매한 수만큼 뺀다 예를 들면 코카콜라 cnt에서 -3을 한다(UPDATE)
 * 4.tbl_sale에 판매기록을 저장한다 (INSERT) 예를들면 sno는 시퀀스값 , sname은 코카콜라,cnt는 3,
 * tprice(3000 = 3 X 1000)
 * 
 * 선행조건) tbl_sale테이블을 생성한다 sno number PK, sname VARCHAR2(100) NOT NULL, cnt
 * NUMBER NOT NULL, tprice NUMBER NOT NULL, regdate DATE DEFAULT SYSDATE
 * 
 * 
 */
