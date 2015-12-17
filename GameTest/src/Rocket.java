import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 *Rocket class represents targets that give area damage when destroyed
 */

public class Rocket extends Target{
	
	private static final int ROCKET_SIZE = 200;
	private int damage; //the damage rocket gives to other objects
	private int damageArea; //the area rocket damage affects
	
	//Constructor of target plane
	public Rocket(int damage, int damageArea, int health, int locationX, int locationY, int appearTime){
		super(ImageConstants.rocketImage, locationX, locationY, health, appearTime);
		this.damage = damage;
		this.damageArea = damageArea;
		setScaledImage(ROCKET_SIZE);
	}
	
	//Returns damage
	public int getDamage(){
		return damage;
	}
	
	//Returns damage area
	public int getDamageArea(){
		return damageArea;
	}
	
}
