import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Weapon class is an abstract class represents shoots and explosives
 */

public class Weapon extends GameObject{
	
	public static final int WEAPON_SIZE = 30;
	public static final int WEAPON_SPEED = 10;
	private int damage; //damage of the weapon
	
	//Constructor for shoot
	public Weapon( int damage, int locationX, int locationY, Image image){
		super( image, locationX, locationY, WEAPON_SPEED, 0);
		this.damage = damage;
		setScaledImage(WEAPON_SIZE);
	}
	
	//Returns damage
	public int getDamage() {
		return damage;
	}

	//Changes damage
	public void setDamage(int damage) {
		this.damage = damage;
	}

	//Returns borders of the weapon image
	public Rectangle getBorders() {
		Rectangle rectangle = new Rectangle(getPositionX(), getPositionY(), getScaledImage().getWidth(null), getScaledImage().getWidth(null));
		return rectangle;
	}

	//Draws the weapon image
	@Override
	public void draw(Graphics g) {
		g.drawImage(getScaledImage(), getPositionX(), getPositionY(), null);
	}
	
}
