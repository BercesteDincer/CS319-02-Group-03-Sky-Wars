import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class TargetHitCollisionManager extends CollisionManager {

	public TargetHitCollisionManager(LevelManager levelManager) {
		super(levelManager);
	}

	public void handleCollision(GameObject obj1, GameObject obj2, Graphics g) {

		if( obj1 instanceof Explosive){
			levelManager.playSound(SoundManager.EXPLOSION_SOUND).start();
			BufferedImage explosionImage = ImageConstants.explosionImage;
			Image newImage = explosionImage.getScaledInstance( ((Explosive) obj1).getDamageArea(), ((Explosive) obj1).getDamageArea(), Image.SCALE_SMOOTH);
			explosions.add(newImage);
			explosionXs.add(obj1.getPositionX() - 50);
			explosionYs.add(obj1.getPositionY() - 50);
		}
		else if( obj2 instanceof Rocket && ((Rocket) obj2).getHealth() == 0 ){
				levelManager.playSound(SoundManager.EXPLOSION_SOUND).start();
				BufferedImage explosionImage = ImageConstants.explosionImage;
				Image newImage = explosionImage.getScaledInstance(((Rocket) obj2).getDamageArea(), ((Rocket) obj2).getDamageArea(), Image.SCALE_SMOOTH);
				explosions.add(newImage);
				explosionXs.add(obj2.getPositionX() - 50);
				explosionYs.add(obj2.getPositionY() - 50);
		}
		else if( obj1 instanceof Shoot && obj2 instanceof Target){
			levelManager.playSound(SoundManager.TARGET_HIT_SOUND).start();
			explosions.add(scaledExplosionImage);
			explosionXs.add(obj2.getPositionX());
			explosionYs.add(obj2.getPositionY());
		}
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