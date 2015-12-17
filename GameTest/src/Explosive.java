import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Explosive class represents weapons with area damage 
 */

public class Explosive extends Weapon{
	
	private int damageArea; //the area explosive gives damage 
	
	//Constructor for explosive
	public Explosive( int damage, int damageArea, int locationX, int locationY, Image image){
		super( damage, locationX, locationY, image);
		this.damageArea = damageArea;
	}

	//Returns damage area
	public int getDamageArea() {
		return damageArea;
	}

}
