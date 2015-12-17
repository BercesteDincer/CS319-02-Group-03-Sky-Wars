import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * UserPlane class represents the plane user controls
 */

public class UserPlane extends GameObject{
	
	public static final int USERPLANE_SIZE = 200;
	public static final int ENLARGED_PLANE_SIZE = 400;
	private Pilot pilot;
	private int health; //health amount of the plane
	private int shootDamage; //the damage the plane gives to targets
	private int shootType; //the shooting type of user plane 
	
	//Constructor of user plane
	public UserPlane(Image image, int health, int locationY, int shootDamage, int shootType, int speed){
		super(image, 100, locationY, 0, speed);
		this.health = health;
		this.shootDamage = shootDamage;
		this.shootType = shootType;
		setScaledImage(USERPLANE_SIZE);
		pilot = new Pilot( 10);
	}

	//Returns health
	public int getHealth() {
		return health;
	}
	
	//Updates health
	public void setHealth(int health) {
		this.health = health;
	}
	
	//Returns shootDamage
	public int getShootDamage() {
		return shootDamage;
	}
	
	//Returns shoot type
	public int getShootType() {
		return shootType;
	}
	
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	
	//Moves the user plane in the specified direction
	public void move(int direction) {
		if(direction == 0){
			if( getPositionY() < 1500 ){
				setPositionY( getPositionY() +  getSpeedY());
			}
		}	
		else{
			if( getPositionY() > 100 ){
				setPositionY( getPositionY() - getSpeedY() );
			}
			
		}	
	}
	
	//Draws the user plane image
	public void draw(Graphics g) {
		 g.drawImage(getScaledImage(), 100, getPositionY(), null);
	}
	
	//Returns borders of the user plane image 
	public Rectangle getBorders() {
		Rectangle rectangle = new Rectangle(getPositionX(), getPositionY(), getScaledImage().getWidth(null),  getScaledImage().getHeight(null));
		return rectangle;
	}

	
	
}
