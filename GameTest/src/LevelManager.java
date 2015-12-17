import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Clip;
 

/**
 * LevelManager is the controller class that handles all level operations
 */
public class LevelManager {
	
	private CollisionManager collisionManager; //reference to collision manager created within
	private CollisionPolicy collisionPolicy;
	private GameManager gameManager; //reference to game manager which creates level manager
	private FileManager fileManager; //reference to file manager created within
	private int currentLevelId; //current level number
	private UserPlane userPlane; //reference to user plane in level
	private List<Target> targets; //list of targets in game
	private List<TargetPlane> targetPlanes; //reference to list of targets in level
	private List<Obstacle> obstacles; //list of obstacles in game
	private List<Weapon> userWeapons; //reference to list of user weapons in level
	private List<BonusPackage> bonusPackages; //reference to list of bonus packages in level
	private List<Integer> weapons; //reference to list of available weapons
	private int currentWeaponId; //reference to current weapon
	private Level level; //reference to current level
	
	//Constructor of game manager 
	public LevelManager(GameManager gameManager){
		targetPlanes = new ArrayList<TargetPlane>();
		userWeapons = new ArrayList<Weapon>();
		targets = new ArrayList<Target>();
		obstacles = new ArrayList<Obstacle>();
		bonusPackages = new ArrayList<BonusPackage>();
		collisionManager = new UserPlaneHitCollisionManager(this);
		this.gameManager = gameManager;
		this.fileManager = new FileManager(this);
		level = new Level(this, 1);
		currentLevelId = 1;
		userPlane = level.getUserPlane();
		targetPlanes = level.getTargetPlanes();
		userWeapons = level.getUserWeapons();
		weapons = level.getWeapons();
		targets = level.getTargets();
		obstacles = level.getObstacles();
		bonusPackages = level.getBonusPackages(); 
		currentWeaponId = 0;
		collisionPolicy = new CollisionPolicy(this);
	}
	
	//Returns game manager
	public GameManager getGameManager() {
		return gameManager;
	}

	//Returns current level
	public Level getLevel() {
		return level;
	}
	
	//Updates current level
	public void setLevel(Level level) {
		this.level = level;
	}
	
	//Moves the user plane in the specified direction
	public void moveUserPlane(int direction) {
		userPlane.move(direction); 
	}
	
	//Returns y coordinate of user plane
	public int getUserPlaneY() {
		return userPlane.getPositionY();
	}
	
	//Draws user plane on screen
	public void drawUserPlane(Graphics g) {
		userPlane.draw(g);
	}
	
	//Implements shoot operation
	public void shoot(Graphics g) {
		Shoot shoot = null;
		if( currentWeaponId == 0){
			shoot = new Shoot(ShootEnum.BULLET.damage(), 200, userPlane.getPositionY() + 100, ShootEnum.BULLET.image());
			userWeapons.add(shoot);
		}
		if( currentWeaponId == 1){
			if( weapons.get(currentWeaponId - 1) > 0 ){
				shoot = new Shoot(ShootEnum.METALBALL.damage(), 200, userPlane.getPositionY() + 100, ShootEnum.METALBALL.image());
				userWeapons.add(shoot);
				updateWeapon( currentWeaponId - 1);
			}
		}
		if( currentWeaponId == 2){
			if( weapons.get(currentWeaponId - 1) > 0 ){
				shoot = new Shoot(ShootEnum.FLAMEGUN.damage(), 200, userPlane.getPositionY() + 100, ShootEnum.FLAMEGUN.image());
				userWeapons.add(shoot);
				updateWeapon( currentWeaponId - 1);
			}	
		}
		if( currentWeaponId == 3){
			if( weapons.get(currentWeaponId - 1) > 0 ){
				shoot = new Shoot(ShootEnum.FROSTLASER.damage(), 200, userPlane.getPositionY() + 100, ShootEnum.FROSTLASER.image());
				userWeapons.add(shoot);
				updateWeapon( currentWeaponId - 1);
			}	
		}
		if( currentWeaponId == 4){
			if( weapons.get(currentWeaponId - 1) > 0 )
			{
				shoot = new Shoot(ShootEnum.LASER.damage(), 200, userPlane.getPositionY() + 100, ShootEnum.LASER.image());
				userWeapons.add(shoot);
				updateWeapon( currentWeaponId - 1);
			}
		}
		if( currentWeaponId == 5){
			if( weapons.get(currentWeaponId - 1) > 0 )
			{
				Explosive explosive = new Explosive(ExplosiveEnum.BOMB.damage(), ExplosiveEnum.BOMB.damageArea(), 200, userPlane.getPositionY() + 100, ExplosiveEnum.BOMB.image() );
				userWeapons.add(explosive);
				updateWeapon( currentWeaponId - 1);
			}
		}
		if( currentWeaponId == 6 ){
			if( weapons.get(currentWeaponId - 1) > 0 )
			{
				Explosive explosive = new Explosive(ExplosiveEnum.MISSILE.damage(), ExplosiveEnum.MISSILE.damageArea(), 200, userPlane.getPositionY() + 100, ExplosiveEnum.MISSILE.image() );
				userWeapons.add(explosive);
				updateWeapon( currentWeaponId - 1);
			}
		}
	}
	
	//Draws all game objects on screen
	public void drawObjects(Graphics g) {
		for( int i = 0; i < targetPlanes.size(); i++ ){
				
			if( targetPlanes.get(i).getPositionX() > -200){
				g.drawImage(targetPlanes.get(i).getScaledImage(), targetPlanes.get(i).getPositionX(), targetPlanes.get(i).getPositionY(), null);
				targetPlanes.get(i).setPositionX(targetPlanes.get(i).getPositionX() - 5);
			}
			else
				targetPlanes.remove(i);
			if( !targetPlanes.isEmpty() && !targetPlanes.get(i).getShoots().isEmpty() ){
				if(targetPlanes.get(i).getShoots().get(0).getPositionX() > -10){
					g.drawImage(targetPlanes.get(i).getShoots().get(0).getScaledImage(), targetPlanes.get(i).getShoots().get(0).getPositionX(), targetPlanes.get(i).getShoots().get(0).getPositionY(), null);
					targetPlanes.get(i).getShoots().get(0).setPositionX(targetPlanes.get(i).getShoots().get(0).getPositionX() - 10);
				}
				else{
					targetPlanes.get(i).removeShoot(0);
					if( !targetPlanes.get(i).getShoots().isEmpty() ){
						targetPlanes.get(i).setShoot(0, targetPlanes.get(i).getPositionX());
					}
				}
			}
			
		}	
		for( int i = 0; i < targets.size(); i++ ){
				if( targets.get(i).getPositionX() > -200){
					g.drawImage(targets.get(i).getScaledImage(), targets.get(i).getPositionX(), targets.get(i).getPositionY(), null);
					targets.get(i).setPositionX(targets.get(i).getPositionX() - targets.get(i).getSpeedX());
				}
				else
					targets.remove(i);
			
		}
		for( int i = 0; i < obstacles.size(); i++ ){
			if( obstacles.get(i).getPositionX() > -200){
				g.drawImage(obstacles.get(i).getScaledImage(), obstacles.get(i).getPositionX(), obstacles.get(i).getPositionY(), null);
				obstacles.get(i).setPositionX(obstacles.get(i).getPositionX() - obstacles.get(i).getSpeedX());
			}
			else
				obstacles.remove(i);
		}
		
		for( int i = 0; i < bonusPackages.size(); i++ ){
			if( bonusPackages.get(i).getPositionX() > -200){
				g.drawImage(bonusPackages.get(i).getScaledImage(), bonusPackages.get(i).getPositionX(), bonusPackages.get(i).getPositionY(), null);
				bonusPackages.get(i).setPositionX(bonusPackages.get(i).getPositionX() - bonusPackages.get(i).getSpeedX());
			}
			else
				bonusPackages.remove(i);
		}
		
	}
	
	//Calls level to create objects if the seconds match
	public void createObjects(int timeInSeconds, int frameWidth) {
		level.createObjects(timeInSeconds,frameWidth);
	}
	
	//Draws all user weapons to screen
	public void drawUserWeapons(Graphics g) {
		for( int i = 0; i < userWeapons.size(); i++ ){
			if( userWeapons.get(i).getPositionX() < 4000 ){
				g.drawImage(userWeapons.get(i).getScaledImage(), userWeapons.get(i).getPositionX(), userWeapons.get(i).getPositionY(), null);
				userWeapons.get(i).setPositionX(userWeapons.get(i).getPositionX() + userWeapons.get(i).getSpeedX());
			}
			else{
				userWeapons.remove(i);
			}
				
		}
	}
	
	//Checks collisions and tells collision manager to handle them
	public void checkCollisions(Graphics g) {
		Rectangle userPlaneBorders = userPlane.getBorders();
		for( int i = 0; i < targetPlanes.size(); i++ ){
			Rectangle targetBorders = targetPlanes.get(i).getBorders();
			if( userPlaneBorders.intersects(targetBorders)){
				collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.userPlaneDestroyed.value);
				collisionManager.handleCollision(userPlane, targetPlanes.get(i), g);
				userPlane.setHealth(0);
				level.updateUserPlane(userPlane);
				gameOver();
			}
			if( !targetPlanes.isEmpty() && !targetPlanes.get(i).getShoots().isEmpty() ){
				Rectangle enemyWeaponBorders = targetPlanes.get(i).getShoots().get(0).getBorders();
				if( userPlaneBorders.intersects(enemyWeaponBorders)){
					collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.userPlaneHit.value);
					collisionManager.handleCollision(userPlane, targetPlanes.get(i).getShoots().get(0), g);
					userPlane.setHealth(userPlane.getHealth() - targetPlanes.get(i).getShoots().get(0).getDamage());
					level.updateUserPlane(userPlane);
					updatePoints((-1)* targetPlanes.get(i).getShoots().get(0).getDamage());
					targetPlanes.get(i).removeShoot(0);
					if( !targetPlanes.get(i).getShoots().isEmpty() ){
						targetPlanes.get(i).setShoot(0, targetPlanes.get(i).getPositionX());
					}
				}
			}	
		}
		for( int i = 0; i < userWeapons.size(); i++ ){
			if( userWeapons.get(i) instanceof Explosive )
				handleExplosion(g, i);
			else{
				Rectangle weaponBorders = userWeapons.get(i).getBorders();
				for( int j = 0; j < targetPlanes.size(); j++ ){
					Rectangle targetBorders = targetPlanes.get(j).getBorders();
					if( weaponBorders.intersects(targetBorders)){
						collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.targetHit.value);
						collisionManager.handleCollision(userWeapons.get(i), targetPlanes.get(j), g);
						updatePoints(userWeapons.get(i).getDamage());
						targetPlanes.get(j).setHealth(targetPlanes.get(j).getHealth() - userWeapons.get(i).getDamage());
						userWeapons.remove(i);
						if( targetPlanes.get(j).getHealth() <= 0 ){
							targetPlanes.remove(j);
						}
					}
				}
				
				for( int j = 0; j < targets.size(); j++ ){
					Rectangle targetBorders = targets.get(j).getBorders();
					if( ! userWeapons.isEmpty()){
						if( weaponBorders.intersects(targetBorders) && targets.get(j) instanceof Carriage){
							collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.targetHit.value);
							collisionManager.handleCollision(userWeapons.get(i), targets.get(j), g);
							updatePoints(userWeapons.get(i).getDamage());
							targets.get(j).setHealth(targets.get(j).getHealth() - userWeapons.get(i).getDamage());
							userWeapons.remove(i);
							if( targets.get(j).getHealth() <= 0 ){
								targets.remove(j);
							}
						}
						else if( weaponBorders.intersects(targetBorders) && targets.get(j) instanceof Rocket){
							collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.targetHit.value);
							collisionManager.handleCollision(userWeapons.get(i), targets.get(j), g);
							updatePoints(userWeapons.get(i).getDamage());
							targets.get(j).setHealth(targets.get(j).getHealth() - userWeapons.get(i).getDamage());
							userWeapons.remove(i);
							if( targets.get(j).getHealth() <= 0 ){
								collisionManager.handleCollision(null, targets.get(j), g);
								Rectangle rocketExplosionBorders = new Rectangle( 
										targets.get(j).getPositionX(), 
										targets.get(j).getPositionY(),
										((Rocket) targets.get(j)).getDamageArea(), 
										((Rocket) targets.get(j)).getDamageArea() );
								for( int k = 0; k < targets.size(); k++ ){
									if( rocketExplosionBorders.intersects(targets.get(k).getBorders())){
										targets.get(k).setHealth( targets.get(k).getHealth() - ((Rocket) targets.get(j)).getDamage() );
										updatePoints( ((Rocket) targets.get(j)).getDamage());
									}
								}
								for( int k = 0; k < targetPlanes.size(); k++ ){
									if( rocketExplosionBorders.intersects(targetPlanes.get(k).getBorders())){
										targetPlanes.get(k).setHealth( targetPlanes.get(k).getHealth() - ((Rocket) targets.get(j)).getDamage() );
										updatePoints( ((Rocket) targets.get(j)).getDamage());
									} 
								}
								if( rocketExplosionBorders.intersects(userPlaneBorders)){
									userPlane.setHealth(userPlane.getHealth() - ((Rocket) targets.get(j)).getDamage() );
									updatePoints( ((Rocket) targets.get(j)).getDamage());
								}
								targets.remove(j);
							}
						}
						else if( weaponBorders.intersects(targetBorders) && targets.get(j) instanceof Ally){
							collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.targetHit.value);
							collisionManager.handleCollision(userWeapons.get(i), targets.get(j), g);
							updatePoints(-1 * userWeapons.get(i).getDamage());
							targets.get(j).setHealth(targets.get(j).getHealth() - userWeapons.get(i).getDamage());
							userWeapons.remove(i);
							if( targets.get(j).getHealth() <= 0 ){
								targets.remove(j);
							}
						}
					}
					}
					
			}
			
		}
		
		for( int i = 0; i < targets.size(); i++ ){
			Rectangle targetBorders = targets.get(i).getBorders();
			if( userPlaneBorders.intersects(targetBorders)){
				collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.userPlaneDestroyed.value);
				collisionManager.handleCollision(userPlane, targets.get(i), g);
				userPlane.setHealth(0);
				level.updateUserPlane(userPlane);
				gameOver();
			}
		}
		for( int i = 0; i < obstacles.size(); i++ ){
			Rectangle obstacleBorders = obstacles.get(i).getBorders();
			if( userPlaneBorders.intersects(obstacleBorders)){
				collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.userPlaneDestroyed.value);
				collisionManager.handleCollision(userPlane, obstacles.get(i), g);
				userPlane.setHealth(0);
				level.updateUserPlane(userPlane);
				gameOver();
			}
		}
		for( int i = 0; i < bonusPackages.size(); i++ ){
			Rectangle bonusPackageBorders = bonusPackages.get(i).getBorders();
			if( userPlaneBorders.intersects(bonusPackageBorders)){
				collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.bonusPackageCollected.value);
				if( bonusPackages.get(i) instanceof CoinPackage){
					playSound(SoundManager.PRESENT_BONUS_PACKAGE_SOUND).start();
					gameManager.addCoins(((CoinPackage) bonusPackages.get(i)).getCoinAmount());
					bonusPackages.remove(i);
				}
				else if( bonusPackages.get(i) instanceof HealthBonusPackage){
					playSound(SoundManager.PRESENT_BONUS_PACKAGE_SOUND).start();
					userPlane.setHealth(userPlane.getHealth() + ((HealthBonusPackage) bonusPackages.get(i)).getHealthAmount());
					bonusPackages.remove(i);
				}
				else if( bonusPackages.get(i) instanceof HealthTrapPackage){
					playSound(SoundManager.TRAP_BONUS_PACKAGE_SOUND).start();
					userPlane.setHealth(userPlane.getHealth() - ((HealthTrapPackage) bonusPackages.get(i)).getHealthAmount());
					bonusPackages.remove(i);
				}
			}
		}
		
	}
	
	private void handleExplosion(Graphics g, int i) {
		Rectangle weaponBorders = userWeapons.get(i).getBorders();
		Rectangle explosionBorders = new Rectangle( 
				userWeapons.get(i).getPositionX(), 
				userWeapons.get(i).getPositionY(),
				((Explosive) userWeapons.get(i)).getDamageArea(), 
				((Explosive) userWeapons.get(i)).getDamageArea() );
		for( int j = 0; j < targetPlanes.size(); j++ ){
			Rectangle targetBorders = targetPlanes.get(j).getBorders();
			if( weaponBorders.intersects(targetBorders)){
				collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.targetHit.value);
				collisionManager.handleCollision(userWeapons.get(i), targetPlanes.get(j), g);
				updatePoints(userWeapons.get(i).getDamage());
				targetPlanes.get(j).setHealth(targetPlanes.get(j).getHealth() - userWeapons.get(i).getDamage());
				for( int k = 0; k < targets.size(); k++ ){
					if( explosionBorders.intersects(targets.get(k).getBorders())){
						targets.get(k).setHealth( targets.get(k).getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
						updatePoints(userWeapons.get(i).getDamage());
					}
				}
				for( int k = 0; k < targetPlanes.size(); k++ ){
					if( explosionBorders.intersects(targetPlanes.get(k).getBorders())){
						targetPlanes.get(k).setHealth( targetPlanes.get(k).getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
						updatePoints(userWeapons.get(i).getDamage());
					} 
				}
				if( explosionBorders.intersects(userPlane.getBorders())){
					userPlane.setHealth(userPlane.getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
					updatePoints(userWeapons.get(i).getDamage());
				}
				userWeapons.remove(i);
				if( targetPlanes.get(j).getHealth() <= 0 ){
					targetPlanes.remove(j);
				}
			}
		}
		
		for( int j = 0; j < targets.size(); j++ ){
			Rectangle targetBorders = targets.get(j).getBorders();
			if( weaponBorders.intersects(targetBorders) && targets.get(j) instanceof Carriage){
				collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.targetHit.value);
				collisionManager.handleCollision(userWeapons.get(i), targets.get(j), g);
				updatePoints(userWeapons.get(i).getDamage());
				targets.get(j).setHealth(targets.get(j).getHealth() - userWeapons.get(i).getDamage());
				for( int k = 0; k < targets.size(); k++ ){
					if( explosionBorders.intersects(targets.get(k).getBorders())){
						targets.get(k).setHealth( targets.get(k).getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
						updatePoints(userWeapons.get(i).getDamage());
					}
				}
				for( int k = 0; k < targetPlanes.size(); k++ ){
					if( explosionBorders.intersects(targetPlanes.get(k).getBorders())){
						targetPlanes.get(k).setHealth( targetPlanes.get(k).getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
						updatePoints(userWeapons.get(i).getDamage());
					} 
				}
				if( explosionBorders.intersects(userPlane.getBorders())){
					userPlane.setHealth(userPlane.getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
					updatePoints(userWeapons.get(i).getDamage());
				}
				userWeapons.remove(i);
				if( targets.get(j).getHealth() <= 0 ){
					targets.remove(j);
				}
			}
			else if( weaponBorders.intersects(targetBorders) && targets.get(j) instanceof Rocket){
				collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.targetHit.value);
				collisionManager.handleCollision(userWeapons.get(i), targets.get(j), g);
				updatePoints(userWeapons.get(i).getDamage());
				targets.get(j).setHealth(targets.get(j).getHealth() - userWeapons.get(i).getDamage());
				if( targets.get(j).getHealth() <= 0 ){
					Rectangle rocketExplosionBorders = new Rectangle( 
							targets.get(j).getPositionX(), 
							targets.get(j).getPositionY(),
							((Rocket) targets.get(j)).getDamageArea(), 
							((Rocket) targets.get(j)).getDamageArea() );
					for( int k = 0; k < targets.size(); k++ ){
						if( rocketExplosionBorders.intersects(targets.get(k).getBorders())){
							targets.get(k).setHealth( targets.get(k).getHealth() - ((Rocket) targets.get(j)).getDamage() );
						}
					}
					for( int k = 0; k < targetPlanes.size(); k++ ){
						if( rocketExplosionBorders.intersects(targetPlanes.get(k).getBorders())){
							targetPlanes.get(k).setHealth( targetPlanes.get(k).getHealth() - ((Rocket) targets.get(j)).getDamage() );
						} 
					}
					if( rocketExplosionBorders.intersects(userPlane.getBorders())){
						userPlane.setHealth(userPlane.getHealth() - ((Rocket) targets.get(j)).getDamage() );
					}
					targets.remove(j);
				}
				userWeapons.remove(i);
			}
			else if( weaponBorders.intersects(targetBorders) && targets.get(j) instanceof Ally){
				collisionPolicy.setPolicy(CollisionPolicy.CollisionPolicies.targetHit.value);
				collisionManager.handleCollision(userWeapons.get(i), targets.get(j), g);
				updatePoints(-1 * userWeapons.get(i).getDamage());
				targets.get(j).setHealth(targets.get(j).getHealth() - userWeapons.get(i).getDamage());
				for( int k = 0; k < targets.size(); k++ ){
					if( explosionBorders.intersects(targets.get(k).getBorders())){
						targets.get(k).setHealth( targets.get(k).getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
						updatePoints(userWeapons.get(i).getDamage());
					}
				}
				for( int k = 0; k < targetPlanes.size(); k++ ){
					if( explosionBorders.intersects(targetPlanes.get(k).getBorders())){
						targetPlanes.get(k).setHealth( targetPlanes.get(k).getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
						updatePoints(userWeapons.get(i).getDamage());
					} 
				}
				if( explosionBorders.intersects(userPlane.getBorders())){
					userPlane.setHealth(userPlane.getHealth() - ((Explosive) userWeapons.get(i)).getDamage() );
					updatePoints(userWeapons.get(i).getDamage());
				}
				if( targets.get(j).getHealth() <= 0 ){
					targets.remove(j);
				}
				userWeapons.remove(i);
			}
		
		}
	}
		

	//Ends the game 
	public void gameOver() {
		gameManager.gameOver();
	}
	
	//Draws all explosions
	public void drawExplosions(Graphics g) {
		collisionManager.drawExplosions(g);
	}
	
	public void removeExplosions() {
		collisionManager.removeExplosions();
	}
	
	//Returns level over status text
	public String levelPassedText() {
		return level.levelPassedText();
	}
	
	//Tells level to create objects
	public void initiateLevel(int frameWidth) {
		fileManager.createLevelFromFile( frameWidth, currentLevelId);
	}
	
	//Turns points to coins at the end of the level 
	public int turnPointsIntoCoins(int points) {
		return level.turnPointsIntoCoins(points);
	}
	
	//Returns points collected 
	public int getPoints() {
		return level.getPoints();
	}
	
	//Initializes a new level
	public void initializeLevel(int levelId) {
		Level newLevel = new Level(this, levelId);
		setLevel(newLevel);
		currentLevelId = levelId;
		initiateLevel(gameManager.getGameFrame().getWidth());
		userPlane = level.getUserPlane();
		targetPlanes = level.getTargetPlanes();
		userWeapons = level.getUserWeapons();
		weapons = level.getWeapons();
		currentWeaponId = 0;
		targets = level.getTargets();
		obstacles = level.getObstacles();
		bonusPackages = level.getBonusPackages(); 
	}
	
	//Initializes target objects from file manager
	public void setCreatedTargetPlanes(List<TargetPlane> targetPlanes) {
		level.setCreatedTargetPlanes(targetPlanes);
	}
	
	//Initializes target objects from file manager
	public void setCreatedTargets(List<Target> targets) {
		level.setCreatedTargets(targets);
	}
	
	//Returns whether level is passed
	public boolean levelPassed() {
		return level.levelPassed();
	}
	
	//Returns current levelId
	public int getCurrentLevelId() {
		return currentLevelId;
	}
	
	//Changes time period of the level
	public void setLevelTimePeriod(int i) {
		level.setLevelTimePeriod(i);
	}
	
	//Changes point threshold of the level
	public void setLevelPointThreshold(int i) {
		level.setLevelPointThreshold(i);
	}
	
	//Changes coin coefficient of level
	public void setCoinCoefficient(int i) {
		level.setCoinCoefficient(i);
	}
	
	//Returns sound clip to play sounds
	public Clip playSound( int soundId) {
		// TODO Auto-generated method stub
		return gameManager.playSound( soundId);
	}
	
	//increases amount of coins at the end of the level
	public void addCoins(int i) {
		gameManager.addCoins(i);
	}
	
	//Returns list of purchased weapons at the end of the level
	public List<Integer> getPurchasedWeapons() {
		return gameManager.getPurchasedWeapons();
	}
	
	//Changes the current weapon
	public void changeWeapon(Graphics graphics) {
		if( currentWeaponId == 6)
			currentWeaponId = 0;
		else
			currentWeaponId++;
		
		if( currentWeaponId != 0 ){
			while( currentWeaponId != 0 && weapons.get(currentWeaponId - 1) == 0 ){
				if( currentWeaponId == 6)
					currentWeaponId = 0;
				else
					currentWeaponId++;
			}
		}
		
	}
	
	//Updates level screen to view changes
	public void updateLevelView() {
		gameManager.updateLevelView();
	}
	
	//Private method call - updates number of weapons after shooting
	private void updateWeapon(int currentWeaponId) {
		int i = weapons.get(currentWeaponId);
		i--;
		weapons.set(currentWeaponId, i);
		updateWeaponInCollection(currentWeaponId);
		
	}
	
	//Updates user collection weapons when the user plane shoots
	public void updateWeaponInCollection(int currentWeaponId) {
		gameManager.updateWeapon(currentWeaponId);
		
	}

	//Updates target planes from level
	public void updateTargetPlanes(List<TargetPlane> tps) {
		this.targetPlanes = tps;
	}

	//Updates points in level
	public void updatePoints(int points) {
		level.updatePoints(points);
	}

	public void updateTargets(List<Target> targets) {
		this.targets = targets;
	}

	public void setCreatedObstacles(List<Obstacle> obstacles) {
		level.setCreatedObstacles(obstacles);
	}

	public void updateObstacles(List<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public void setCreatedBonusPackages(List<BonusPackage> bonusPackages) {
		level.setCreatedBonusPackages(bonusPackages);
	}

	public void updateBonusPackages(List<BonusPackage> bonusPackages) {
		this.bonusPackages = bonusPackages;
	}

	public void setCurrentLevelId(int levelId) {
		currentLevelId = levelId;
	}

	public void setCollisionManager(CollisionManager collisionManager) {
		this.collisionManager = collisionManager; 
	}
	
}
