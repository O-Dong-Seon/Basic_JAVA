package chapther08;

//자식 클래스
// : JAVA는 단일상속만 가능!
public class DmbCellPhone extends CellPhone{
	int channel;
	
	public DmbCellPhone() {
		super();
	}
	
	public DmbCellPhone(String model, String collor,int channel) {
		// super();  부모생성자 호출(부모 객체 생성)
		// 부모객체생성 후 자식객체가 생성 됨!
		super(); // == CellPtone(); //super는 맨위에 써야함 (한줄만 내려도 에러) 
		this.model = model; 
		this.color = color;
		this.channel = channel;
		// super();=>CellPhone();생성자메서드
		//자식생성자(){} ->super
		
	}
	
	public void turnOnDmb() {
		System.out.println("채널" + channel + "번 방송 수신을 시작합니다.");
	}
	public void ChangeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel+"번으로변경합니다");
	}
	public void turnOffDmb() {
		System.out.println("DMB방송 수신을 멈춥니다");
	}

}
