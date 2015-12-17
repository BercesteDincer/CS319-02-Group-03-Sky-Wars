import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

/**
 * Level is the class that holds all level detail data
 * and game objects within level
 */
public class Level {
	private LevelManager levelManager; //reference to level manager which controls the level
	private UserPlane userPlane; //user plane object
	private List<TargetPlane> targetPlanes; //list of target planes in game
	private List<Target> targets; //list of targets in game
	private List<Target> createdTargets;  //list of targets read from file
	private List<Obstacle> obstacles; //list of obstacles in game
	private List<Obstacle> createdObstacles;  //list of obstacles read from file
	private List<TargetPlane> createdTargetPlanes;  //list of target planes read from file
	private List<Weapon> userWeapons; //list of weapons sent by user plane
	private List<BonusPackage> bonusPackages; //list of bonus packages in game
	private List<BonusPackage> createdBonusPackages; //list of bonus packages read from file
	private int points; //total points user has collected in level
	private int levelTimePeriod;  //total time allocated for user plane
	private int levelPointThreshold; //point threshold for the level to be vieweved as successful
	private int coinCoefficient; //coin coefficient which represents points per coin 
	private int levelId; //id of the level
	private List<Integer> weapons; //list of weapons user has 
	private Image backGroundImage; //background image of the level
	
	//Constructor of level - it takes reference to its creator level manager and level id
	public Level(LevelManager levelManager, int levelId){
		targetPlanes = new ArrayList<TargetPlane>();
		targets = new ArrayList<Target>();
		obstacles = new ArrayList<Obstacle>();
		createdTargetPlanes = new ArrayList<TargetPlane>(); 
		createdTargets = new ArrayList<Target>(); 
		createdObstacles = new ArrayList<Obstacle>();
		userWeapons = new ArrayList<Weapon>(); 
		bonusPackages = new ArrayList<BonusPackage>();
		createdBonusPackages = new ArrayList<BonusPackage>();
		this.levelId = levelId;
		this.levelManager = levelManager;
		levelManager.setCurrentLevelId(levelId);
		createUserPlane();
		initializeWeapons();
	}
	
	private void createUserPlane() {
		if( levelManager.getGameManager().getCollectionManager().getPilotSelection() == 0){
			if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 0){
				this.userPlane = new UserPlane(ImageConstants.user11, UserPlaneEnum.ALDERAAN_CRUISER.health(), 
				 100, UserPlaneEnum.ALDERAAN_CRUISER.shootDamage(), UserPlaneEnum.ALDERAAN_CRUISER.shootType(), 
				 UserPlaneEnum.ALDERAAN_CRUISER.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 1){
				this.userPlane = new UserPlane(ImageConstants.user12, UserPlaneEnum.TOMCAT.health(), 
				 100, UserPlaneEnum.TOMCAT.shootDamage(), UserPlaneEnum.TOMCAT.shootType(), 
				 UserPlaneEnum.TOMCAT.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 2){
				this.userPlane = new UserPlane(ImageConstants.user13, UserPlaneEnum.F22_RAPTOR.health(), 
				 100, UserPlaneEnum.F22_RAPTOR.shootDamage(), UserPlaneEnum.F22_RAPTOR.shootType(), 
				 UserPlaneEnum.F22_RAPTOR.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 3){
				this.userPlane = new UserPlane(ImageConstants.user14, UserPlaneEnum.SAAB_GRIPEN.health(), 
				 100, UserPlaneEnum.SAAB_GRIPEN.shootDamage(), UserPlaneEnum.SAAB_GRIPEN.shootType(), 
				 UserPlaneEnum.SAAB_GRIPEN.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 4){
				this.userPlane = new UserPlane(ImageConstants.user15, UserPlaneEnum.WUNDERWAFFE.health(), 
				 100, UserPlaneEnum.WUNDERWAFFE.shootDamage(), UserPlaneEnum.WUNDERWAFFE.shootType(), 
				 UserPlaneEnum.WUNDERWAFFE.speed());
			}
			this.userPlane.setPilot(new Pilot( PilotEnum.NICK.speed()));
		}
		else if( levelManager.getGameManager().getCollectionManager().getPilotSelection() == 1){
			if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 0){
				this.userPlane = new UserPlane(ImageConstants.user21, UserPlaneEnum.ALDERAAN_CRUISER.health(), 
				 100, UserPlaneEnum.ALDERAAN_CRUISER.shootDamage(), UserPlaneEnum.ALDERAAN_CRUISER.shootType(), 
				 UserPlaneEnum.ALDERAAN_CRUISER.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 1){
				this.userPlane = new UserPlane(ImageConstants.user22, UserPlaneEnum.TOMCAT.health(), 
				 100, UserPlaneEnum.TOMCAT.shootDamage(), UserPlaneEnum.TOMCAT.shootType(), 
				 UserPlaneEnum.TOMCAT.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 2){
				this.userPlane = new UserPlane(ImageConstants.user23, UserPlaneEnum.F22_RAPTOR.health(), 
				 100, UserPlaneEnum.F22_RAPTOR.shootDamage(), UserPlaneEnum.F22_RAPTOR.shootType(), 
				 UserPlaneEnum.F22_RAPTOR.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 3){
				this.userPlane = new UserPlane(ImageConstants.user24, UserPlaneEnum.SAAB_GRIPEN.health(), 
				 100, UserPlaneEnum.SAAB_GRIPEN.shootDamage(), UserPlaneEnum.SAAB_GRIPEN.shootType(), 
				 UserPlaneEnum.SAAB_GRIPEN.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 4){
				this.userPlane = new UserPlane(ImageConstants.user25, UserPlaneEnum.WUNDERWAFFE.health(), 
				 100, UserPlaneEnum.WUNDERWAFFE.shootDamage(), UserPlaneEnum.WUNDERWAFFE.shootType(), 
				 UserPlaneEnum.WUNDERWAFFE.speed());
			}
			this.userPlane.setPilot(new Pilot( PilotEnum.PENNY.speed()));
		}
		else if( levelManager.getGameManager().getCollectionManager().getPilotSelection() == 2){
			if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 0){
				this.userPlane = new UserPlane(ImageConstants.user31, UserPlaneEnum.ALDERAAN_CRUISER.health(), 
				 100, UserPlaneEnum.ALDERAAN_CRUISER.shootDamage(), UserPlaneEnum.ALDERAAN_CRUISER.shootType(), 
				 UserPlaneEnum.ALDERAAN_CRUISER.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 1){
				this.userPlane = new UserPlane(ImageConstants.user32, UserPlaneEnum.TOMCAT.health(), 
				 100, UserPlaneEnum.TOMCAT.shootDamage(), UserPlaneEnum.TOMCAT.shootType(), 
				 UserPlaneEnum.TOMCAT.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 2){
				this.userPlane = new UserPlane(ImageConstants.user33, UserPlaneEnum.F22_RAPTOR.health(), 
				 100, UserPlaneEnum.F22_RAPTOR.shootDamage(), UserPlaneEnum.F22_RAPTOR.shootType(), 
				 UserPlaneEnum.F22_RAPTOR.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 3){
				this.userPlane = new UserPlane(ImageConstants.user34, UserPlaneEnum.SAAB_GRIPEN.health(), 
				 100, UserPlaneEnum.SAAB_GRIPEN.shootDamage(), UserPlaneEnum.SAAB_GRIPEN.shootType(), 
				 UserPlaneEnum.SAAB_GRIPEN.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 4){
				this.userPlane = new UserPlane(ImageConstants.user35, UserPlaneEnum.WUNDERWAFFE.health(), 
				 100, UserPlaneEnum.WUNDERWAFFE.shootDamage(), UserPlaneEnum.WUNDERWAFFE.shootType(), 
				 UserPlaneEnum.WUNDERWAFFE.speed());
			}
			this.userPlane.setPilot(new Pilot( PilotEnum.MIKE.speed()));
		}
		else if( levelManager.getGameManager().getCollectionManager().getPilotSelection() == 3){
			if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 0){
				this.userPlane = new UserPlane(ImageConstants.user41, UserPlaneEnum.ALDERAAN_CRUISER.health(), 
				 100, UserPlaneEnum.ALDERAAN_CRUISER.shootDamage(), UserPlaneEnum.ALDERAAN_CRUISER.shootType(), 
				 UserPlaneEnum.ALDERAAN_CRUISER.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 1){
				this.userPlane = new UserPlane(ImageConstants.user42, UserPlaneEnum.TOMCAT.health(), 
				 100, UserPlaneEnum.TOMCAT.shootDamage(), UserPlaneEnum.TOMCAT.shootType(), 
				 UserPlaneEnum.TOMCAT.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 2){
				this.userPlane = new UserPlane(ImageConstants.user43, UserPlaneEnum.F22_RAPTOR.health(), 
				 100, UserPlaneEnum.F22_RAPTOR.shootDamage(), UserPlaneEnum.F22_RAPTOR.shootType(), 
				 UserPlaneEnum.F22_RAPTOR.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 3){
				this.userPlane = new UserPlane(ImageConstants.user44, UserPlaneEnum.SAAB_GRIPEN.health(), 
				 100, UserPlaneEnum.SAAB_GRIPEN.shootDamage(), UserPlaneEnum.SAAB_GRIPEN.shootType(), 
				 UserPlaneEnum.SAAB_GRIPEN.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 4){
				this.userPlane = new UserPlane(ImageConstants.user45, UserPlaneEnum.WUNDERWAFFE.health(), 
				 100, UserPlaneEnum.WUNDERWAFFE.shootDamage(), UserPlaneEnum.WUNDERWAFFE.shootType(), 
				 UserPlaneEnum.WUNDERWAFFE.speed());
			}
			this.userPlane.setPilot(new Pilot( PilotEnum.EVA.speed()));
		}
		else if( levelManager.getGameManager().getCollectionManager().getPilotSelection() == 4){
			if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 0){
				this.userPlane = new UserPlane(ImageConstants.user51, UserPlaneEnum.ALDERAAN_CRUISER.health(), 
				 100, UserPlaneEnum.ALDERAAN_CRUISER.shootDamage(), UserPlaneEnum.ALDERAAN_CRUISER.shootType(), 
				 UserPlaneEnum.ALDERAAN_CRUISER.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 1){
				this.userPlane = new UserPlane(ImageConstants.user52, UserPlaneEnum.TOMCAT.health(), 
				 100, UserPlaneEnum.TOMCAT.shootDamage(), UserPlaneEnum.TOMCAT.shootType(), 
				 UserPlaneEnum.TOMCAT.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 2){
				this.userPlane = new UserPlane(ImageConstants.user53, UserPlaneEnum.F22_RAPTOR.health(), 
				 100, UserPlaneEnum.F22_RAPTOR.shootDamage(), UserPlaneEnum.F22_RAPTOR.shootType(), 
				 UserPlaneEnum.F22_RAPTOR.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 3){
				this.userPlane = new UserPlane(ImageConstants.user54, UserPlaneEnum.SAAB_GRIPEN.health(), 
				 100, UserPlaneEnum.SAAB_GRIPEN.shootDamage(), UserPlaneEnum.SAAB_GRIPEN.shootType(), 
				 UserPlaneEnum.SAAB_GRIPEN.speed());
			}
			else if( levelManager.getGameManager().getCollectionManager().getUserPlaneSelection() == 4){
				this.userPlane = new UserPlane(ImageConstants.user55, UserPlaneEnum.WUNDERWAFFE.health(), 
				 100, UserPlaneEnum.WUNDERWAFFE.shootDamage(), UserPlaneEnum.WUNDERWAFFE.shootType(), 
				 UserPlaneEnum.WUNDERWAFFE.speed());
			}
			this.userPlane.setPilot(new Pilot( PilotEnum.NEO.speed()));
		}
	}

	//private call-initializes weapons from collection
	private void initializeWeapons() {
		weapons = new ArrayList<Integer>();
		for( int i = 0; i < levelManager.getPurchasedWeapons().size(); i++ ){
			weapons.add(i, levelManager.getPurchasedWeapons().get(i));
		}
	}
	
	//Returns list of user weapons
	public List<Weapon> getUserWeapons() {
		return userWeapons;
	}

	//Returns level point threshold
	public int getLevelPointThreshold() {
		return levelPointThreshold;
	}

	//Changes level point threshold
	public void setLevelPointThreshold(int levelPointThreshold) {
		this.levelPointThreshold = levelPointThreshold;
	}
	
	//Returns time period allocated for level
	public int getLevelTimePeriod() {
		return levelTimePeriod;
	}
	
	//Changes time period allocated for level
	public void setLevelTimePeriod(int levelTimePeriod) {
		this.levelTimePeriod = levelTimePeriod;
	}
	
	//Return points
	public int getPoints() {
		return points;
	}
	
	//Updates points by specified amount
	public void updatePoints( int amount){
		points += amount;
		if( points <= 0)
			points = 0;
	}

	
	//Returns user plane
	public UserPlane getUserPlane() {
		return userPlane;
	}
	
	//Create objects according to time of level and appearance time of objects
	public void createObjects(int timeInSeconds, int frameWidth) {
		for( int i = 0; i < createdTargetPlanes.size(); i++ ){
			if( createdTargetPlanes.get(i).getAppearTime() == timeInSeconds ){
				targetPlanes.add(createdTargetPlanes.get(i));
				createdTargetPlanes.remove(i);
				levelManager.updateTargetPlanes(targetPlanes);
			}
		}
		for( int i = 0; i < createdTargets.size(); i++ ){
			if( createdTargets.get(i).getAppearTime() == timeInSeconds ){
				targets.add(createdTargets.get(i));
				createdTargets.remove(i);
				levelManager.updateTargets(targets);
			}
		}
		for( int i = 0; i < createdObstacles.size(); i++ ){
			if( createdObstacles.get(i).getAppearTime() == timeInSeconds ){
				obstacles.add(createdObstacles.get(i));
				createdObstacles.remove(i);
				levelManager.updateObstacles(obstacles);
			}
		}
		for( int i = 0; i < createdBonusPackages.size(); i++ ){
			if( createdBonusPackages.get(i).getAppearTime() == timeInSeconds ){
				bonusPackages.add(createdBonusPackages.get(i));
				createdBonusPackages.remove(i);
				levelManager.updateBonusPackages(bonusPackages);
			}
		}
		
	}
	
	//Returns end of level status text
	public String levelPassedText() {
		if( userPlane.getHealth() <= 0 ){
			return "LEVEL FAILED - HEALTH DEPLETED";
		}
		else{
			if( points >= levelPointThreshold )
				return "LEVEL PASSED";
			else
				return "LEVEL FAILED - YOU DID NOT COLLECT " + levelPointThreshold + " POINTS";
		}
		
	}

	//Returns coin coefficient 
	public int getCoinCoefficient() {
		return coinCoefficient;
	}

	//Changes coin coefficient
	public void setCoinCoefficient(int coinCoefficient) {
		this.coinCoefficient = coinCoefficient;
	}

	//Returns level id 
	public int getLevelId() {
		return levelId;
	}

	//Given points turns points to coins according to coin coefficient and returns
	public int turnPointsIntoCoins(int points) {
		levelManager.addCoins(points / coinCoefficient);
		return points / coinCoefficient;
	}

	//Changes created target planes
	public void setCreatedTargetPlanes(List<TargetPlane> targetPlanes) {
		this.createdTargetPlanes = targetPlanes;
	}

	//Returns whether level is passed or not
	public boolean levelPassed() {
		if( userPlane.getHealth() <= 0 ){
			return false;
		}
		else{
			if( points >= levelPointThreshold )
				return true;
			else
				return false;
		}
	}
	
	//Returns list of target planes in level
	public List<TargetPlane> getTargetPlanes() {
		return targetPlanes;
	}
	
	//Updates list of target planes in level
	public void setTargetPlanes(List<TargetPlane> tps) {
		this.targetPlanes = tps;
	}
	
	//Returns list of weapons in level 
	public List<Integer> getWeapons() {
		return weapons;
	}
	
	//Updates set of weapons in level
	public void setWeapons(List<Integer> weapons) {
		this.weapons = weapons;
	}
	
	//Updates user plane
	public void updateUserPlane(UserPlane userPlane) {
		this.userPlane = userPlane;
		
	}

	//Sets created targets
	public void setCreatedTargets(List<Target> targets) {
		this.createdTargets = targets;
	}

	//Returns list of targets
	public List<Target> getTargets() {
		return targets;
	}

	//Returns list of obstacles in game
	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setCreatedObstacles(List<Obstacle> obstacles) {
		this.createdObstacles = obstacles;
	}

	public void setCreatedBonusPackages(List<BonusPackage> bonusPackages) {
		this.createdBonusPackages = bonusPackages;
	}

	public List<BonusPackage> getBonusPackages() {
		return bonusPackages;
	}
	
}
