package chapter05;

import java.util.Scanner;

public class Fibonachi01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("피보나치 수열 입력>>");
		int depth = sc.nextInt();//피보나치의 깊이(반복횟수)
		
		int front = 1;	// 첫번째 항	
		int end = 1;	// 두번째 항
		int sum = front + end; //첫번째 항, 두번째 항을 더한 값
		
		System.out.println("피보나치 depth" + depth);
		System.out.println("1 1");
		for(int i = 2; i<= depth ; i++) {
			sum = end;						// end 값을 sum으로
			end = front+end;				// front+end의 값을 end로
			front = sum;					// sum의 값을 front로
			
			System.out.println(end + " " + i);
		}
		
			
	}

}
