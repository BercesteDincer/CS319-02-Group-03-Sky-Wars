import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Shoot class represents weapons with direct damage 
 */

public class Shoot extends Weapon{
	
	//Constructor for shoot
	public Shoot( int damage, int locationX, int locationY, Image image){
		super( damage, locationX, locationY, image);
	}
}
