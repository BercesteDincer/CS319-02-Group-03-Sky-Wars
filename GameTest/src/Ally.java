import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *Ally class represents targets that deduce points from user when shot
 */

public class Ally extends Target{

	private static final int ALLY_SIZE = 200;
	
	//Constructor of target plane
	public Ally(Image image, int health, int locationX, int locationY, int appearTime){
		super(image, locationX, locationY, health, appearTime);
		setScaledImage(ALLY_SIZE);
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
