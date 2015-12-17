import java.awt.Graphics;
import java.awt.Rectangle;

public class SpeedBonusPackage extends PresentBonusPackage {

	private int speedAmount;
	private int effectPeriod;

	public SpeedBonusPackage (int speed,int period, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.speedAmount = speed;
		this.effectPeriod = period;
	}

	public int getSpeedAmount() {
		return speedAmount;
	}

	public int getEffectPeriod() {
		return effectPeriod;
	}
	
	

}