import java.awt.Image;

/**
 * PilotEnum is an enumeration class to represents values of various instances of pilot
 */
public enum PilotEnum {
	
	NICK(0),
	PENNY(10),
	MIKE(10),
	EVA(20),
	NEO(20);
	
	private int speed;
	
	private PilotEnum(int speed){
		this.speed = speed;
	}
	
	public int speed(){
		return speed;
	}
	
}
