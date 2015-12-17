import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * TargetPlane class represents targets in enemy plane form that can shoot
 */

public class TargetPlane extends Target{
	
	public static final int TARGETPLANE_SIZE = 200;
	private List<Shoot> shoots; //list of shoots of target plane
	
	//Constructor of target plane
	public TargetPlane(Image image, int health, int locationX, int locationY, int appearTime, ShootEnum shootEnum){
		super(image, locationX, locationY, health, appearTime);
		setImage( image);
		shoots = new ArrayList<Shoot>(5);
		for( int i = 0; i < 5; i++ ){
			Shoot shoot = new Shoot(shootEnum.damage(), locationX, locationY + 100, shootEnum.image());
			shoots.add(shoot);
		}
		setScaledImage(TARGETPLANE_SIZE);
	}
	
	//Returns list of shoots
	public List<Shoot> getShoots() {
		return shoots;
	}
	
	//Updates the specified shoot from the list of shoots
	public void setShoot(int i, int locationX){
		shoots.get(i).setPositionX(locationX);
	}
	
	//Removes a shoot form list of shoots
	public void removeShoot(int i) {
		shoots.remove(i);
	}
	
}
