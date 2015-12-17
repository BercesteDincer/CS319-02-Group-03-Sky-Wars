import java.awt.Image;

/**
 * TargetPlaneEnum is an enumeration class to represents values of various instances of target planes
 */
public enum TargetPlaneEnum {
	
	F16(100, ImageConstants.f16TargetPlaneImage, ShootEnum.BULLET),
	REPUBLIC_ATTACK(300, ImageConstants.republicAttackTargetPlaneImage, ShootEnum.METALBALL),
	IMPERIAL_SHUTTLE(600, ImageConstants.imperialShuttleTargetPlaneImage, ShootEnum.FLAMEGUN),
	HAVOC_MARAUDER(1000, ImageConstants.havocMarauderTargetPlaneImage, ShootEnum.FROSTLASER),
	BOSS(1500, ImageConstants.bossTargetPlaneImage, ShootEnum.LASER);

	private int health;
	private Image image;
	private ShootEnum shoot;
	
	private TargetPlaneEnum(int health, Image image, ShootEnum shoot){
		this.health = health;
		this.image = image;
		this.shoot = shoot;
	}
	
	public int health(){
		return health;
	}
	
	public Image image(){
		return image;
	}
	
	public ShootEnum shoot(){
		return shoot;
	}
}
