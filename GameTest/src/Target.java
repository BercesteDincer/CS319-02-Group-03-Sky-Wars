import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * Target class is the abstract class that represents all items
 */
public abstract class Target extends GameObject{
	
	public static int TARGET_SPEED = 5;
	private int health; //health of the target -when depleted it is destroyed
	private int appearTime; //health of the target -when depleted it is destroyed
	
	//Constructor of target
	public Target(Image image, int positionX, int positionY, int health, int appearTime){
		super( image, positionX, positionY, TARGET_SPEED, 0);
		this.health = health;
		this.appearTime = appearTime;
	}

	//Returns health
	public int getHealth() {
		return health;
	}

	//Changes health
	public void setHealth(int health) {
		this.health = health;
	}

	//Returns appear time
	public int getAppearTime() {
		return appearTime;
	}

	//Changes appear time
	public void setAppearTime(int appearTime) {
		this.appearTime = appearTime;
	}
	
	//Returns borders of the scaled image
	public Rectangle getBorders() {
		Rectangle rectangle = new Rectangle(getPositionX(), getPositionY(), getScaledImage().getWidth(null), getScaledImage().getHeight(null));
		return rectangle;
	}
		
	//Draws the scaled image on screen
	@Override
	public void draw(Graphics g) {
		g.drawImage(getScaledImage(), getPositionX(), getPositionY(), null );
	}
		
}
