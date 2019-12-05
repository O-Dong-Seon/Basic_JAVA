package chapther10;

public class MazingerToyImpl implements IMissile, IMoveArmLeg{

	public  MazingerToyImpl() {
		System.out.println("마징가입니다.");
		canMissile();
		canMoveArmLeg();
		System.out.println("============================");
	}
	
	
	
	@Override
	public void canMissile() {
		System.out.println("미사일 발사!!!");		
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("마징가 팔다리 움직이기");
	}

}
