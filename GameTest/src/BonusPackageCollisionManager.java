import java.awt.Graphics;


public class BonusPackageCollisionManager extends CollisionManager {

	public BonusPackageCollisionManager(LevelManager levelManager) {
		super(levelManager);
	}

	public void handleCollision(GameObject obj1, GameObject obj2, Graphics g) {
		
	}
	
	//Draws all explosions
	public void drawExplosions(Graphics g) {
		for( int i = 0; i < explosions.size(); i++ ){
			g.drawImage(explosions.get(i),  explosionXs.get(i), explosionYs.get(i), null);	
		}
	}
		
	public void removeExplosions() {
		if(!explosions.isEmpty()){
			explosions.clear();
			explosionXs.clear();
			explosionYs.clear();
		}		
	}

}