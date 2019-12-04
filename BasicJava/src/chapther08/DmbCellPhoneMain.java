package chapther08;

public class DmbCellPhoneMain {

	public static void main(String[] args) {
		// CellPhon 클래스를 상속받고 있는 
		
		// 자식DmbCellPhone 클래스를 객체생성
		DmbCellPhone dmb = new DmbCellPhone("어머나 폰", "화이트" , 5);
		
		
		System.out.println("모델:" + dmb.model); // CellPhone 부모클래스로부터 상속받은 필드
		System.out.println("색상:" + dmb.color);
		
		// 자기자신의 필드
		System.out.println("채널:" + dmb.channel);
		
		
		// Cellphone 부모클래스로부터 상속받은 메서드
		dmb.powerOn();
		dmb.bell();
		dmb.sendVoice("여보세여");
		dmb.receiveVoice("안녕하세요.보리에요!");
		dmb.sendVoice("강아지가 말도하네요?");
		dmb.hang();
				
		//자기자신의 메서드
		dmb.turnOnDmb();
		dmb.ChangeChannelDmb(12);
		dmb.turnOffDmb();
	
	
	
	}

}
