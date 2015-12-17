import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * BonusPackage class is the abstract class that represents all bonus packages
 */
public abstract class BonusPackage extends GameObject{
	
	public static int PACKAGE_SIZE = 100;
	public static int PACKAGE_SPEED = 5;
	private int appearTime; //the time bonus package appears on the screen
	
	//Constructor of target
	public BonusPackage(Image image, int positionX, int positionY, int appearTime){
		super( image, positionX, positionY, PACKAGE_SPEED, 0);
		this.appearTime = appearTime;
		setScaledImage(PACKAGE_SIZE);
	}

	//Returns appear time
	public int getAppearTime() {
		return appearTime;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(getScaledImage(), getPositionX(), getPositionY(), null);
	}

	@Override
	public Rectangle getBorders() {
		Rectangle r;
		r = new Rectangle(getPositionX(), getPositionY(), getScaledImage().getWidth(null), getScaledImage().getHeight(null));
		return r;
	}
	
}
