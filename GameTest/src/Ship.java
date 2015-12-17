import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *Ship class represents targets that appear in bonus missions
 */
public class Ship extends Target{

	private static final int SHIP_SIZE = 300;
	
	//Constructor of target plane
	public Ship( int health, int locationX, int locationY, int appearTime){
		super(ImageConstants.shipImage, locationX, locationY, health, appearTime);
		setScaledImage(SHIP_SIZE);
	}
	
}
