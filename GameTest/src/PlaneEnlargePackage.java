import java.awt.Graphics;
import java.awt.Rectangle;

public class PlaneEnlargePackage extends TrapBonusPackage {

	private int effectPeriod;

	public PlaneEnlargePackage (int period, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.effectPeriod = period;
	}

	public int getEffectPeriod() {
		return effectPeriod;
	}
	
}