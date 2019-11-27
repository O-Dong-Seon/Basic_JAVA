package problem;

public class TotalSum {
	public static void main(String[] args) {
		// 1~100까지 수 중에 짝수,홀수 각각 더해서 출력하시오.
		// 시작값: 1
		// 종료값: 100
		// 짝수 누적값 :even
		// 홀수 누적값 :odd
		
			
		int even = 0; // 덧셈 결과의 누적
		int odd = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
			
		}
		System.out.println("1~100까지 짝수총합" + even);
		System.out.println("1~100까지 홀수총합" + odd);
	}

}
