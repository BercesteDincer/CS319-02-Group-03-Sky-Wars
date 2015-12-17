import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class CollisionManager {

	protected LevelManager levelManager;
	protected List<Image> explosions = new ArrayList<Image>();
	protected List<Integer> explosionXs = new ArrayList<Integer>();
	protected List<Integer> explosionYs = new ArrayList<Integer>();
	protected Image scaledExplosionImage;
	
	public CollisionManager(LevelManager levelManager) {
		this.levelManager = levelManager;
		BufferedImage explosionImage = ImageConstants.explosionImage;
		scaledExplosionImage = explosionImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	}

	public abstract void  handleCollision(GameObject obj1, GameObject obj2, Graphics g);
	
	public abstract void drawExplosions(Graphics g);
		
	public abstract void removeExplosions();

}
