import java.awt.Graphics;
import java.awt.Rectangle;

public class ObstacleInvisibilityPackage extends PresentBonusPackage {

	private int effectPeriod;

	public ObstacleInvisibilityPackage (int period, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.effectPeriod = period;
	}

	public int getEffectPeriod() {
		return effectPeriod;
	}
	
	

}