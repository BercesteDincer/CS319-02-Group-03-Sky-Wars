import java.awt.Image;

/**
 * ShipEnum is an enumeration class to represents values of various instances of ship target
 */
public enum ShipEnum {
	
	SMALL(100),
	MEDIUM(250),
	LARGE(500);
	
	private int health;
	
	private ShipEnum(int health){
		this.health = health;
	}
	
	public int health(){
		return health;
	}
	
}
