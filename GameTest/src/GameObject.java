import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * GameObject class is an abstract class which represents all objects
 * of the game
 */

public abstract class GameObject {
	
	private Image image; //name of the image of the object
	private Image scaledImage; //name of the scaled image of the object
	private Movement movement; //reference to movement
	
	//Constructor that initializes image name and movement details
	public GameObject( Image image, int positionX, int positionY, int speedX, int speedY){
		this.image = image;
		movement = new Movement(positionX, positionY, speedX, speedY);
	}

	//Empty constructor
	public GameObject() {
	}

	//Returns image 
	public Image getImage() {
		return image;
	}

	//Sets image 
	public void setImage(Image image) {
		this.image = image;
	}
	
	//Returns scaled image
	public Image getScaledImage() {
		return scaledImage;
	}

	//Sets scaled image with given size
	public void setScaledImage(int size) {
		scaledImage = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
	}
		
	//Abstract method for draw operation
	public abstract void draw(Graphics g);

	//Abstract method for getting borders of image
	public abstract Rectangle getBorders();
		
	//Returns x coordinate of the object
	public int getPositionX(){
		return movement.getPositionX();
	}
	
	//Changes x coordinate of the object
	public void setPositionX( int positionX){
		movement.setPositionX(positionX);
	}
	
	//Returns y coordinate of the object
	public int getPositionY(){
		return movement.getPositionY();		
	}
		
	//Changes y coordinate of the object
	public void setPositionY( int positionY){
		movement.setPositionY(positionY);
	}
	
	//Returns speed of the object in x coordinate
	public int getSpeedX(){
		return movement.getSpeedX();
	}
		
	//Changes speed of the object in x coordinate
	public void setSpeedX( int speedX){
		movement.setSpeedX(speedX);
	}
	
	//Returns speed of the object in y coordinate
	public int getSpeedY(){
		return movement.getSpeedY();
	}
			
	//Changes speed of the object in y coordinate
	public void setSpeedY( int speedY){
		movement.setSpeedY(speedY);
	}

}
