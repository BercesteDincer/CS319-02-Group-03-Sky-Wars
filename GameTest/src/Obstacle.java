import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * Obstacle class represents obstacles that kill user when collided
 */
public class Obstacle extends GameObject{

	private static final int OBSTACLE_SIZE = 900;
	private static final int OBSTACLE_SPEED = 5;
	private int appearTime;
	
	//Constructor of Obstacle
	public Obstacle( Image image, int positionX, int positionY, int appearTime ){
		super(image, positionX, positionY, OBSTACLE_SPEED, 0);
		this.appearTime = appearTime;
		setScaledImage(OBSTACLE_SIZE);
	}
	
	//Returns appear time of obstacle
	public int getAppearTime() {
		return appearTime;
	}

	//Draws obstacle image on screen
	@Override
	public void draw(Graphics g) {
		g.drawImage(getScaledImage(), getPositionX(), getPositionY(), null);
	}

	//Returns borders of the obstacle image
	@Override
	public Rectangle getBorders() {
		Rectangle rectangle = new Rectangle(getPositionX(), getPositionY(), getScaledImage().getWidth(null), getScaledImage().getHeight(null));
		return rectangle;
	}

}
