package problem;

import java.util.Scanner;

public class BigSmall01 {

	public static void main(String[] args) {
		// 사용자가 값을 2개 입력
		// --입력--
		// 번호1 >>
		// 번호2 >>
		// -- 조건 --
		// 번호 1 < 번호2보다 작으면
		// 번호 1에 값과 번호 2의 값을 서로 교환하여
		// 번호 1이 항상 큰 수를 가지게 만든다.
		// -- 출력 --
		// 번호 1 > 번호2
		Scanner sc = new Scanner(System.in);
		System.out.print("번호1 >>");
		int num1 = sc.nextInt();
		System.out.print("번호2 >>");
		int num2 = sc.nextInt();
				
		int temp = 0; //  임시 변수 설정
		if(num1 < num2);{
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
			
		System.out.println(num1 + ">" + num2);
		
		//System.out.println(num1 + "," + num2);
		
	}

}
