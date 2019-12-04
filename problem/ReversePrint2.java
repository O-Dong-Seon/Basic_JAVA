package problem;

import java.util.Scanner;

public class ReversePrint2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("번호>>");
		// num = 사용자가 키보드로 입력한 값
		int num = sc.nextInt();
		int finalNum = num; //죵료값
		
		for(int i = 1 ; i <= finalNum ; i++) {
			num = num -1;
			System.out.println(num); 
		 }
			System.out.println("===============");
	}
	
	

}
