package problem;

import java.util.Scanner;

public class bubbleMain {
	static int[] data = new int[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("버블정렬 ver.1");
		System.out.println("5개의 무작위 수를 입력하시오");

//		 System.out.print("1번수>>");
//		 data [0] = sc.nextInt();
//		 
//		 System.out.print("2번수>>");
//		 data [1] = sc.nextInt();
//		 
//		 System.out.print("3번수>>");
//		 data [2] = sc.nextInt();
//		 
//		 System.out.print("4번수>>");
//		 data [3] = sc.nextInt();
//		 
//		 System.out.print("5번수>>");
//		 data [4] = sc.nextInt();

		for (int i = 0; i < data.length; i++) {
			System.out.print((i + 1) + "번수>>");
			data[i] = sc.nextInt();

		}

	}
	
	public static void viewData() {
		for (int i = 0 ; i < data.length; i++) {
			System.out.println(data[i]+" ");
			
		}
			
		
	}

}
