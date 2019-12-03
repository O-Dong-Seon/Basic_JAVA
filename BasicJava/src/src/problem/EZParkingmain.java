/*
 * desc: Array를 사용하여 주차공간을 만들고
 * 		 차량을 입고 또는 출고 하는 주차타워프로그램
 * writer: ehdtjs88kr
 * date: 2019.12.03
 */
package problem;

import java.util.Scanner;

public class EZParkingmain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Parking park = new Parking(); // 1.객체생성 2.1회기능 <-dafault 생성자

		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■ EZParking ver.1.5 ");
			System.out.print("■ car Number>>");
			int car = sc.nextInt(); // 주차타워를 이용할 차량번호

			int code = 0; // 사용자가 선택한 번호!
			while (true) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■ 1.차량입고");
				System.out.println("■ 2.차량출고");
				System.out.println("■ 3.취소");
				System.out.print("■ 선택>>");
				code = sc.nextInt(); // 입고,출고,취소

				if (code > 3 || code < 1) {
					System.out.println("■ 올바른 값을 입력하세요");
					continue;
				} else { // code가 1,2,3 인 경우
					break;
				}

			}
			if (code == 1) { // 차량 입고
				park.inParking(car);
				// 현재 주차타워가 빈공간이 없는 경우
				
			} else if (code == 2) { // 차량 출고
				// 주차타워에 차량이 0대인 경우
					park.outParking(car);
			} else if (code == 3) { // 취소
				car = 0; // 기존에 입력한 차량번호 Clear
				System.out.println("■ 취소 되었습니다. 다음에 이용해주세요~");
				continue;
			}

		}
	}
}
