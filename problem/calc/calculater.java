package problem.calc;

public class calculater {
	int result; //결과를 저장 할 변수
	// 덧셈 기능
	public int sum(int first, int second) {
		result = first + second;
			return result;
		
	}
	// 뺄셈기능
	public int sub(int first, int second) {
		result = first - second;

		return result;
	}
	// 곱셈기능
	public int multi(int first, int second) {
		result = first * second;
		return result;
	}
	
	// 나눗셈기능
	public int div(int first, int second) {
		result = first / second;
		return result;
	}
}
