import java.awt.Image;

/**
 * CarriageEnum is an enumeration class to represents values of various instances of carriage target
 */
public enum CarriageEnum {
	
	SMALL(100),
	MEDIUM(250),
	LARGE(500);
	
	private int health;
	
	private CarriageEnum(int health){
		this.health = health;
	}
	
	public int health(){
		return health;
	}
	
}
