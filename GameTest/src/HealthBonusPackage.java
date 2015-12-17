import java.awt.Graphics;
import java.awt.Rectangle;

public class HealthBonusPackage extends PresentBonusPackage {

	private int healthAmount;

	public HealthBonusPackage (int health, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.healthAmount = health;
	}

	public int getHealthAmount() {
		return healthAmount;
	}

}