import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *Carriage class represents enemy planes which do not shoot
 */
public class Carriage extends Target{

	private static final int CARRIAGE_SIZE = 300;
	
	//Constructor of target plane
	public Carriage(int health, int locationX, int locationY, int appearTime){
		super(ImageConstants.carriageImage, locationX, locationY, health, appearTime);
		setScaledImage(CARRIAGE_SIZE);
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
