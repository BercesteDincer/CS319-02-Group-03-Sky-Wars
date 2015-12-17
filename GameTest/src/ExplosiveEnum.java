import java.awt.Image;

/**
 * ExplosiveEnum is an enumeration class to represents values of various instances of explosives
 */
public enum ExplosiveEnum {
	
	BOMB(50, 300, ImageConstants.bombImage),
	MISSILE(75, 500, ImageConstants.missileImage);
	
	private int damage;
	private int damageArea;
	private Image image;
	
	private ExplosiveEnum(int damage, int damageArea, Image image){
		this.damage = damage;
		this.damageArea = damageArea;
		this.image = image;
	}
	
	public int damage(){
		return damage;
	}
	
	public int damageArea(){
		return damageArea;
	}
	
	public Image image(){
		return image;
	}

}
