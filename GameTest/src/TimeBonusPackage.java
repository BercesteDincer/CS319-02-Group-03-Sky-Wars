import java.awt.Graphics;
import java.awt.Rectangle;

public class TimeBonusPackage extends PresentBonusPackage {

	private int timeAmount;

	public TimeBonusPackage (int time,int period, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.timeAmount = time;
	}

	public int getTimeAmount() {
		return timeAmount;
	}
	

}