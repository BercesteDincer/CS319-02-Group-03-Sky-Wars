
public class CollisionPolicy {
	
	public enum CollisionPolicies{
		userPlaneDestroyed(0), userPlaneHit(1), targetHit(2), bonusPackageCollected(3);
		int value;
		private CollisionPolicies(int value){
			this.value = value;
		}
	}
	
	private int currentPolicy;
	private LevelManager levelManager;
	
	public CollisionPolicy( LevelManager levelManager){
		this.levelManager = levelManager;
		currentPolicy = 0;
	}
	
	public int getPolicy(){
		return currentPolicy;
	}
	
	public void setPolicy(int policy){
		currentPolicy = policy;
		if( currentPolicy == CollisionPolicies.userPlaneDestroyed.value ){
			levelManager.setCollisionManager(new UserPlaneDestroyedCollisionManager(levelManager));
		}
		else if( currentPolicy == CollisionPolicies.userPlaneHit.value ){
			levelManager.setCollisionManager(new UserPlaneHitCollisionManager(levelManager));
		}
		else if( currentPolicy == CollisionPolicies.targetHit.value ){
			levelManager.setCollisionManager(new TargetHitCollisionManager(levelManager));
		}
		else{
			levelManager.setCollisionManager(new BonusPackageCollisionManager(levelManager));
		}
		
	}
	

}
