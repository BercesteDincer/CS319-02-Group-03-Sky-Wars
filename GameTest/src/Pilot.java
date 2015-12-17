import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *Pilot class represents pilot of the user plane 
 */

public class Pilot extends GameObject{
	
	//Constructor for shoot
	public Pilot( int speed){
		super( ImageConstants.nickPilotImage, 0, 0, speed, 0);
		setScaledImage(100);
	}
	
	//Returns borders of the scaled image
	public Rectangle getBorders() {
		Rectangle rectangle = new Rectangle(getPositionX(), getPositionY(), getScaledImage().getWidth(null), getScaledImage().getWidth(null));
		return rectangle;
	}

	//Draws the scaled image
	@Override
	public void draw(Graphics g) {
		g.drawImage(getScaledImage(), getPositionX(), getPositionY(), null);
	}
	
}
