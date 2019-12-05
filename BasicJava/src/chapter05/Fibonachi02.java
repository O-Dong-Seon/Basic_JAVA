package chapter05;

import java.util.Scanner;

public class Fibonachi02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력>>");
		int depth = sc.nextInt();
		
		int front = 1;
		int end = 1;
		int sum = front + end;
		
		for(int i = 2; i <= depth;i++) {
		sum = end;
		end = end + front;
		front= sum;
		
		}
		
		
		
	}
}
