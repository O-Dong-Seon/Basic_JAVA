package chapter05;

public class Constructor01 {
	//Default 생성자
	//  :Class에 생성자가 존재하지 않으면
	// 	 JAVA에서 Default 생성자를 생성
	// 	Default 생성자는 객체 생성만 함 
	public Constructor01() {} //Default
	public Constructor01(String a) {} // 1. 매개변수의 갯수가 다르거나
	public Constructor01(int a) {}	  // 2. 매개변수에 갯수가 같으면 타입이 다르면 됨.
	public Constructor01(int a , int b , String c) {}
	public Constructor01(int a , String c , int b) {} //3. 매개변수의 순서가 다르면 됨

	//public Constructor01(String milk, String cake) {} 
	//public Constructor01(String cake ,String milk) {}
}
