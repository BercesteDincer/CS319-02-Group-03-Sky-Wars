import java.awt.Graphics;

public class UserPlaneDestroyedCollisionManager extends CollisionManager {
	
	public UserPlaneDestroyedCollisionManager(LevelManager levelManager) {
		super(levelManager);
	}

	public void handleCollision(GameObject obj1, GameObject obj2, Graphics g) {
			levelManager.playSound(SoundManager.GAME_OVER_SOUND).start();
			explosions.add(scaledExplosionImage);
			explosionXs.add(obj1.getPositionX());
			explosionYs.add(obj1.getPositionY());
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