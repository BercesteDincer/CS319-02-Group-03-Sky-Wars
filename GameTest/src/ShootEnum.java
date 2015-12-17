import java.awt.Image;

/**
 * ShootEnum is an enumeration class to represents values of various instances of shoots
 */
public enum ShootEnum {
	
	BULLET(10, ImageConstants.bulletImage),
	METALBALL(20, ImageConstants.metalBallImage),
	FLAMEGUN(30, ImageConstants.flameGunImage),
	FROSTLASER(40, ImageConstants.frostLaserImage),
	LASER(50, ImageConstants.laserImage);
	
	private int damage;
	private Image image;
	
	private ShootEnum(int damage, Image image){
		this.damage = damage;
		this.image = image;
	}
	
	public int damage(){
		return damage;
	}
	
	public Image image(){
		return image;
	}

}
