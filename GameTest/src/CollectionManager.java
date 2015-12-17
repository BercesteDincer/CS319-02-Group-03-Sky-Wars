import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CollectionManager class is the class that holds user collection details 
 * and handles collection operations
 */
public class CollectionManager {
	
	private GameManager gameManager; //reference to gameManager
	private int coins; //the amount of user coins
	private int userPlaneSelection; //the current selection of user plane
	private int pilotSelection; //the current selection of pilot
	private List<Integer> purchasedUserPlanes; //list of ids of purchased user planes
	private List<Integer> purchasedPilots; //list of ids of purchased pilots
	private List<Integer> purchasedPackageLocks; //list of levels of purchased package locks
	private List<Integer> purchasedWeapons; //list of total amounts of purchased weapons
	
	//Constructor of CollectionManager-it takes a reference to GameManager that creates CollectionManager
	public CollectionManager( GameManager gameManager){
		this.gameManager = gameManager;
		purchasedUserPlanes = new ArrayList<Integer>();
		purchasedPilots = new ArrayList<Integer>();
		purchasedPackageLocks= new ArrayList<Integer>(5);
		for( int i = 0; i < 5; i++ )
			purchasedPackageLocks.add(0);
		purchasedWeapons = new ArrayList<Integer>(6);
		for( int i = 0; i < 6; i++ )
			purchasedWeapons.add(0);
		
		try (BufferedReader br = new BufferedReader(new FileReader("save.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	coins = Integer.parseInt(line);
		    	line = br.readLine();
		    	userPlaneSelection = Integer.parseInt(line);
		    	line = br.readLine();
		    	pilotSelection = Integer.parseInt(line);
		    	for( int i = 0; i < 5; i++ ){
		    		line = br.readLine();
		    		if( Integer.parseInt(line) != -1)
		    			purchasedUserPlanes.add(i);
			    }
		    	for( int i = 0; i < 5; i++ ){
		    		line = br.readLine();
		    		if( Integer.parseInt(line) != -1)
		    			purchasedPilots.add(i);
			    }
		    	for( int i = 0; i < 6; i++ ){
		    		line = br.readLine();
		    		purchasedWeapons.set(i, Integer.parseInt(line));
			    }
		    	for( int i = 0; i < 5; i++ ){
		    		line = br.readLine();
		    		if( Integer.parseInt(line) != -1)
		    			gameManager.addPassedLevel(i);
			    }
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Returns amount of coins
	public int getCoins() {
		return coins;
	}

	//Increments coins by new amount
	public void addCoins(int coins) {
		this.coins += coins;
	}
	
	//Returns user plane selection
	public int getUserPlaneSelection() {
		return userPlaneSelection;
	}

	//Changes user plane selection
	public void setUserPlaneSelection(int userPlaneSelection) {
		this.userPlaneSelection = userPlaneSelection;
	}

	//Returns pilot selection
	public int getPilotSelection() {
		return pilotSelection;
	}

	//Changes pilot selection
	public void setPilotSelection(int pilotSelection) {
		this.pilotSelection = pilotSelection;
	}

	//Returns purchased user planes 
	public List<Integer> getPurchasedUserPlanes() {
		return purchasedUserPlanes;
	}

	//Returns purchased pilots
	public List<Integer> getPurchasedPilots() {
		return purchasedPilots;
	}

	//Returns purchased weapons
	public List<Integer> getPurchasedWeapons() {
		return purchasedWeapons;
	}
	
	//Returns purchased package locks
	public List<Integer> getPurchasedPackageLocks() {
		return purchasedPackageLocks;
	}

	//Returns game manager
	public GameManager getGameManager() {
		return gameManager;
	}
	
	//Handles purchase by updating item list and coins
	public void purchaseItem(int id, int price) {
		coins -= price;
		gameManager.setStore();
		if( -1 < id && id < 5){
			purchasedUserPlanes.add(id);
		}
		else if( 4 < id && id < 10){
			purchasedPilots.add(id - 5);
		}
		else{
			purchasedWeapons.set(id - 10, purchasedWeapons.get(id -10) + 50);
		}
		
	}

	//Updates number of corresponding weapons
	public void updateWeapon(int currentWeaponId) {
		int k = purchasedWeapons.get(currentWeaponId);
		k--;
		purchasedWeapons.set(currentWeaponId, k);
		
	}

	public boolean purchasedPlanesContains(int i) {
		return purchasedUserPlanes.contains(i);
	}

	//Returns whether purchased pilots contains i 
	public boolean purchasedPilotsContains(int i) {
		return purchasedPilots.contains(i);
	}
}
