package chapther10;

public class PoohToyImpl  implements IMoveArmLeg{
	public PoohToyImpl() {
		System.out.println("푸에염");
		canMoveArmLeg();
		System.out.println("====================");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("푸가 뒤뚱뒤뚱 움직이는중");
	}

}
