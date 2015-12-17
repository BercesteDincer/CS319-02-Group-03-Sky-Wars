import java.awt.Image;

/**
 * BonusMissionTargetEnum is an enumeration class to represents values of various instances of bonus mission targets
 */
public enum BonusMissionTargetEnum {
	
	SHIP_MISSION(0),
	COIN_MISSION(1);
	
	private int bonusMissionId;
	
	private BonusMissionTargetEnum(int bonusMissionId){
		this.bonusMissionId = bonusMissionId;
	}
	
	public int bonusMissionId(){
		return bonusMissionId;
	}

}
