import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class UserPlaneHitCollisionManager extends CollisionManager {
	
	public UserPlaneHitCollisionManager(LevelManager levelManager) {
		super(levelManager);
	}

	public void handleCollision(GameObject obj1, GameObject obj2, Graphics g) {
		
		if( obj1 instanceof UserPlane && obj2 instanceof Shoot){
			levelManager.playSound(SoundManager.USER_PLANE_SHOT_SOUND).start();
			explosions.add(scaledExplosionImage);
			explosionXs.add(obj1.getPositionX());
			explosionYs.add(obj1.getPositionY());
		}
		else if( obj1 instanceof Explosive){
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
