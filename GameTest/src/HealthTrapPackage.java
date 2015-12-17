import java.awt.Graphics;
import java.awt.Rectangle;

public class HealthTrapPackage extends TrapBonusPackage {

	private int healthAmount;

	public HealthTrapPackage (int health, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.healthAmount = health;
	}

	public int getHealthAmount() {
		return healthAmount;
	}

}