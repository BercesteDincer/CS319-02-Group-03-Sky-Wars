import java.awt.Image;

/**
 * UserPlaneEnum is an enumeration class to represents values of various instances of user plane
 */
public enum UserPlaneEnum {
	
	ALDERAAN_CRUISER(250, 0, 0, 10),
	TOMCAT(500, 10, 0, 20),
	F22_RAPTOR(750, 20, 0, 30),
	SAAB_GRIPEN(1000, 30, 1, 40),
	WUNDERWAFFE(1250, 40, 1, 50);
	
	private int health;
	private int shootDamage;
	private int shootType;
	private int speed;
	
	private UserPlaneEnum(int health, int shootDamage, int shootType, int speed) {
		this.health = health;
		this.shootDamage = shootDamage;
		this.shootType = shootType;
		this.speed = speed;
	}

	public int health(){
		return health;
	}
	
	public int shootDamage(){
		return shootDamage;
	}
	
	public int shootType(){
		return shootType;
	}
	
	public int speed(){
		return speed;
	}
}

