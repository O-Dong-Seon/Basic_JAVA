package problem.fafatouch;

import java.util.Scanner;

public class cafemain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		String[][] mainMenu = new String[5][2];
		
		mainMenu[0][0] = "아메리카노";
		mainMenu[1][0] = "카페라떼";
		mainMenu[2][0] = "마끼아또";
		mainMenu[3][0] = "카푸치노";
		mainMenu[4][0] = "프라푸치노";
		mainMenu[0][1] = "3500";
		mainMenu[1][1] = "4000";
		mainMenu[2][1] = "4500";
		mainMenu[3][1] = "4500";
		mainMenu[4][1] = "5500";
		
		String[][]dessertMenu = new String[5][2];
		
		dessertMenu[0][0] = "초콜릿케익";
		dessertMenu[1][0] = "레드벨벳";
		dessertMenu[2][0] = "카스테라";
		dessertMenu[3][0] = "마카롱";
		dessertMenu[4][0] = "팬케이크";
		dessertMenu[0][1] = "4000";
		dessertMenu[1][1] = "4000";
		dessertMenu[2][1] = "4000";
		dessertMenu[3][1] = "2000";
		dessertMenu[4][1] = "9000";
		
		
		while(true) {
		System.out.println("메인메뉴");
		System.out.println("1. 아메리카노");
		System.out.println("2. 카페라떼");
		System.out.println("3. 마끼아또");
		System.out.println("4. 카푸치노");
		System.out.println("5. 프라푸치노");
		System.out.print("어떤 음료를 고르시겠습니까?>>");
		int mainNum = sc.nextInt();
		
		System.out.println("디저트");
		System.out.println("1.초콜릿무스");
		System.out.println("2.레드벨벳");
		System.out.println("3.카스테라");
		System.out.println("4.마카롱");
		System.out.println("5.팬케이크");
		System.out.print("어떤 음료를 고르시겠습니까?>>");
		int dessertNum = sc.nextInt();
		
		int mPrice = Integer.parseInt(mainMenu[mainNum -1][1]);
		int dPrice = Integer.parseInt(dessertMenu[dessertNum -1][1]);	
		int tPrice = mPrice + dPrice;
		
		System.out.println("1." + mainMenu[mainNum -1][0]);
		System.out.println("2." + dessertMenu[dessertNum -1][0]);
		System.out.println("총 금액은" +tPrice + "입니다");
		System.out.println("계산을 하시겠습니까? (y/n)>>");
		
	
		sc.nextLine();
		String order = sc.nextLine();
		System.out.println(order);
		
		while(true) {
			System.out.println("결제금액>>");
			int money = sc.nextInt();	
			if(tPrice > money) {
					System.out.println("금액이 부족합니다");
					continue;
				}else {
					if(tPrice < money) {
						System.out.println((money - tPrice)+ " 거스름돈 받아주세요");
					}
					
					System.out.println("결제 완료되었습니다 맛있게드세요~");
					break;
				}
			}
		}

	}
}
