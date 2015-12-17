import java.awt.Image;

/**
 * AllyEnum is an enumeration class to represents values of various instances of ally target
 */
public enum AllyEnum {
	
	ALDERAAN_CRUISER(100, ImageConstants.alderaanCruiserAllyImage),
	TOMCAT(200, ImageConstants.tomcatAllyImage),
	F22_RAPTOR(300, ImageConstants.f22RaptorAllyImage),
	SAAB_GRIPEN(400, ImageConstants.saabGripenAllyImage),
	WUNDERWAFFE(500, ImageConstants.wunderWaffeAllyImage);
	
	private int health;
	private Image image;
	
	private AllyEnum(int health, Image image){
		this.health = health;
		this.image = image;
	}
	
	public int health(){
		return health;
	}
	
	public Image image(){
		return image;
	}
}
