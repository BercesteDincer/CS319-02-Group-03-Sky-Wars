import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Clip;

/**
 * GameManager class which handles all game related operations
 * It contains all other managers and communicates with game frame
 */
public class GameManager implements GameObjectInterface{
	
	private GameFrame gameFrame; //reference to game frame to learn user actions
	private LevelManager levelManager; //reference to LevelManager created by GameManager
	private int currentLevelId; //indicates which level is currently played
	private List<Integer> passedLevelIds; //list of levels that user has passed
	private boolean musicOn; //indicates whether the music in on or not
	private SoundManager soundManager; //reference to SoundManager created by GameManager
	private CollectionManager collectionManager; //reference to CollectionManager created by GameManager
	private List<GameManagerObserver> observers;
	
	//Constructor of GameManager which takes game frame
	public GameManager( GameFrame gameFrame ){
		passedLevelIds = new ArrayList<Integer>();
		this.gameFrame = gameFrame;
		collectionManager = new CollectionManager(this);
		levelManager = new LevelManager(this);
		musicOn = true;
		currentLevelId = levelManager.getCurrentLevelId();
		soundManager = new SoundManager();
		observers = new ArrayList<GameManagerObserver>();
	}

	//Returns game frame
	public GameFrame getGameFrame() {
		return gameFrame;
	}

	//Returns current level id
	public int getCurrentLevelId() {
		return currentLevelId;
	}

	//Updates current level id
	public void setCurrentLevelId(int levelId) {
		this.currentLevelId = levelId;
		notifyViews();
	}

	//Returns list of passed level ids
	public List<Integer> getPassedLevelIds() {
		return passedLevelIds;
	}

	//Returns level manager
	public LevelManager getLevelManager() {
		return levelManager;
	}

	//Moves user plane in the specified direction by telling it to level manager
	public void moveUserPlane(int direction) {
		levelManager.moveUserPlane(direction);
	}

	//Returns y coordinate of user plane  by telling it to level manager
	public int getUserPlaneY() {
		return levelManager.getUserPlaneY();
	}

	//Draws user plane on screen  by telling it to level manager
	public void drawUserPlane(Graphics g) {
		levelManager.drawUserPlane(g);
	}

	//Shoots, fires weapons  by telling it to level manager
	public void shoot(Graphics g) {
		levelManager.shoot(g);
	}

	//Draws all game objects by telling it to level manager
	public void drawObjects(Graphics g) {
		levelManager.drawObjects(g);
	}

	//Creates all objects that should appear in the specified time and places them to screen according to frameWidth  by telling it to level manager 
	public void createObjects(int timeInSeconds, int frameWidth) {
		levelManager.createObjects(timeInSeconds, frameWidth);
	}

	//Draws all user weapons to screen by telling it to level manager
	public void drawUserWeapons(Graphics g) {
		levelManager.drawUserWeapons(g);
	}

	//Checks collisions by telling it to level manager
	public void checkCollisions(Graphics g) {
		levelManager.checkCollisions(g);
	}

	//Ends game by updating Level Panel
	public void gameOver() {
		gameFrame.gameOver();
		notifyViews();
	}

	//Draws all explosions to screen by telling it to level manager
	public void drawExplosions(Graphics g) {
		levelManager.drawExplosions(g);
	}

	//Returns text about whether level is passed or failed by asking it from level manager
	public String levelPassedText() {
		return levelManager.levelPassedText();
	}

	//Creates initial game objects at the beginning of level by telling it to level manager
	public void createObjects(int frameWidth) {
		levelManager.initiateLevel(frameWidth);
	}

	//Turns level points to coins//Draws all user weapons to screen by telling it to level manager
	public int turnPointsIntoCoins(int points){
		return levelManager.turnPointsIntoCoins(points);
	}

	//Returns level points by asking it from level manager
	public int getPoints() {
		return levelManager.getPoints();
	}
	
	//Returns collection manager
	public CollectionManager getCollectionManager() {
		return collectionManager;
	}

	//Initializes corresponding level//Draws all user weapons to screen by telling it to level manager
	public void initializeLevel(int levelId) {
		levelManager.initializeLevel(levelId);
	}

	//Returns whether level is passed or not by asking to level manager
	public boolean levelPassed() {
		return levelManager.levelPassed();
	}

	//If the current level is passed, adds current level to passed levels by telling it to level manager
	public void addPassedLevel(int currentLevelId) {
		passedLevelIds.add(currentLevelId);
	}

	//Requests sound manager to return the sound clip
	public Clip playSound(int soundId) {
		return soundManager.playSound(soundId);
	}

	//Increases user coins by telling it to collection manager
	public void addCoins(int coins) {
		collectionManager.addCoins(coins );
	}

	//Returns coins by asking it from collection manager 
	public int getCoins() {
		return collectionManager.getCoins();
	}

	//Updates the store
	public void setStore() {
		gameFrame.setStore();
	}

	//Returns list of purchased weapons
	public List<Integer> getPurchasedWeapons() {
		return collectionManager.getPurchasedWeapons();
	}

	//Changes weapon by telling it to level manager
	public void changeWeapon(Graphics graphics) {
		levelManager.changeWeapon(graphics);
	}

	//Updates level view
	public void updateLevelView() {
		gameFrame.updateLevelView();
	}

	//Updates weapon number in screen when weapons are used
	public void updateWeapon(int currentWeaponId) {
		collectionManager.updateWeapon(currentWeaponId);
	}

	//Returns whether purchased planes contain a particular item by asking it from collection manager
	public boolean purchasedPlanesContains(int i) {
		return collectionManager.purchasedPlanesContains(i);
	}

	//Returns whether purchased pilots contain a particular item by asking it from collection manager
	public boolean purchasedPilotsContains(int i) {
		return collectionManager.purchasedPilotsContains(i);
	}

	//Purchases an item by telling it to collection manager
	public void purchaseItem(int id, int price) {
		collectionManager.purchaseItem(id, price);
	}
	
	//Turns the music on or off
	public void setMusicOn(boolean on){
		musicOn = on;
	}

	@Override
	public void subscribe(GameManagerObserver observer) {
		observers.add(observer);
	}

	@Override
	public void notifyViews() {
		for( int i = 0; i < observers.size(); i++ ){
			observers.get(i).update();
		}
	}

}
