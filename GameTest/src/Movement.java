/**
 * Movement class represents the motional characters of game objects
 * such as coordinates and speeds
 */
public class Movement {
	
	private int positionX; //position of object in x axis
	private int positionY; //position of object in y axis
	private int speedX; //speed of object in x axis
	private int speedY; //Speed of object in y axis
	
	//Constructor of Movement
	public Movement(int positionX, int positionY, int speedX, int speedY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.speedX = speedX;
		this.speedY = speedY;
	}

	
	//Returns x position
	public int getPositionX() {
		return positionX;
	}

	
	//Changes x position
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	
	//Returns y position 
	public int getPositionY() {
		return positionY;
	}

	
	//Changes y position
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	
	//Returns speed in x axis
	public int getSpeedX() {
		return speedX;
	}

	
	//Changes speed in x axis 
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	//Returns speed in y axis
	public int getSpeedY() {
		return speedY;
	}

	//Changes speed in y axis
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}
