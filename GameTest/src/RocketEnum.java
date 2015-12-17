import java.awt.Image;

/**
 * RocketEnum is an enumeration class to represents values of various instances of rocket target
 */
public enum RocketEnum {
	
	SMALL(50, 500, 300),
	MEDIUM(75, 1000, 500),
	LARGE( 100, 1500, 700);
	
	private int damage;
	private int damageArea;
	private int health;
	
	private RocketEnum(int damage, int damageArea, int health){
		this.damage = damage;
		this.damageArea = damageArea;
		this.health = health;
	}
	
	public int damage(){
		return damage;
	}
	
	public int damageArea(){
		return damageArea;
	}
	
	public int health(){
		return health;
	}
}
