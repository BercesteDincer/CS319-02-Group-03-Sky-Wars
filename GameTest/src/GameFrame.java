import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * GameFrame class is a JFrame which contains all panels of the game
 */
public class GameFrame extends JFrame{
	
	private GameManager  gameManager; //reference to GameManager
	private CardLayout cl; //card layout of the frame
	private JPanel cardPanel; //jpanel which keeps and arranges all panels
	private MainMenuPanel mainMenuPanel; //Main Menu Screen panel
	private LevelMapPanel levelMapPanel; //Level Map Screen panel
	private LevelPanel levelPanel; //Level Screen panel
	private PauseMenuPanel pauseMenuPanel; //Pause Menu Screen panel
	private StorePanel storePanel; //Store Screen panel
	private CollectionPanel collectionPanel; //Collection Screen panel
	private SettingsPanel settingsPanel; //Settings Screen panel
	private HelpPanel helpPanel; //Help Screen panel
	private CreditsPanel creditsPanel; //Credits Screen panel
	
	//Constructor of GameFrame
	public GameFrame(){
		//Setting the JFrame
		super("Sky Wars");
		//setUndecorated(true);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		gameManager = new GameManager(this); //Create new gameManager
		addPanels(); //Create and add panels, labels
		saveOnClose();
	}
	
	//Displays Main Menu Screen
	public void displayMainMenu(){
		cl.show(cardPanel, "1");
		mainMenuPanel.requestFocus();
	}
	
	//Displays Pause Menu Screen
	public void displayPauseMenu(){
		cl.show(cardPanel, "4");
		pauseMenuPanel.requestFocus();
	}
		
	//Displays Level Screen with the given number
	public void displayLevel(int levelId){
		levelPanel.initializeGame(levelId);
		cl.show(cardPanel, "3");
	    levelPanel.requestFocus();
	}

	//Displays Level Map Screen
	public void displayLevelMap(){
		cl.show(cardPanel, "2");
		levelMapPanel.requestFocus();
	}
	
	//Displays Store Screen
	public void displayStore(){
		storePanel.update();
		cl.show(cardPanel, "5");
		storePanel.requestFocus();
	}
	
	//Displays Collection Screen
	public void displayCollection(){
		collectionPanel.update();
		cl.show(cardPanel, "6");
	    collectionPanel.requestFocus();
	}
	
	//Displays Settings Screen
	public void displaySettings(){
		cl.show(cardPanel, "7");
		settingsPanel.requestFocus();
	}
	
	//Displays Help screen
	public void displayHelp(){
		cl.show(cardPanel, "9");
		helpPanel.requestFocus();
	}
	
	//Displays Credits screen
	public void displayCredits(){
		cl.show(cardPanel, "8");
		creditsPanel.requestFocus();
	}
	
	//Returns game manager
	public GameManager getGameManager() {
		return gameManager;
	}
		
	//Resumes Level screen after paused and resumed
	public void resumeGame() {
		cl.show(cardPanel, "3");
	    levelPanel.requestFocus();
		levelPanel.resumeGame();
	}

	//Sets store view by locking/unlocking items
	public void setStore() {
		storePanel.repaint();
	}

	//Updates Level screen
	public void updateLevelView() {
		levelPanel.repaint();
	}

	//Ends the game by telling it to level panel
	public void gameOver() {
		levelPanel.gameOver();
	}
	
	//Private method call-adds panels
		private void addPanels() {
			mainMenuPanel = new MainMenuPanel(this);
			levelMapPanel = new LevelMapPanel(this);
			levelPanel = new LevelPanel(this);
			pauseMenuPanel = new PauseMenuPanel(this);
			storePanel = new StorePanel(this, gameManager);
			collectionPanel = new CollectionPanel(this);
			settingsPanel = new SettingsPanel(this);
			creditsPanel = new CreditsPanel(this);
			helpPanel = new HelpPanel(this);
			cl = new CardLayout();
			cardPanel = new JPanel(cl);
			cardPanel.add(mainMenuPanel, "1");
			cardPanel.add(levelMapPanel, "2");
			cardPanel.add(levelPanel, "3");
			cardPanel.add(pauseMenuPanel, "4");
			cardPanel.add(storePanel, "5");
			cardPanel.add(collectionPanel, "6");
			cardPanel.add(settingsPanel, "7");
			cardPanel.add(creditsPanel, "8");
			cardPanel.add(helpPanel, "9");
			add(cardPanel);
			cl.show(cardPanel, "1");
		}
		
		private void saveOnClose() {
			addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			  
			        	Writer writer = null;

						try {
						    writer = new BufferedWriter(new OutputStreamWriter(
						          new FileOutputStream("save.txt"), "utf-8"));
						    writer.write( gameManager.getCoins() + "\r\n");
						    writer.write( gameManager.getCollectionManager().getUserPlaneSelection() + "\r\n");
						    writer.write( gameManager.getCollectionManager().getPilotSelection() + "\r\n");
						    for( int i = 0; i < 5; i++ ){
						    	if( gameManager.getCollectionManager().purchasedPlanesContains(i))
						    		writer.write( i + "\r\n");
						    	else
						    		writer.write( -1 + "\r\n");
						    }
						    for( int i = 0; i < 5; i++ ){
						    	if( gameManager.getCollectionManager().purchasedPilotsContains(i))
						    		writer.write( i + "\r\n");
						    	else
						    		writer.write( -1 + "\r\n");
						    }
						    for( int i = 0; i < 6; i++ ){
						    	writer.write( gameManager.getCollectionManager().getPurchasedWeapons().get(i)  + "\r\n");
						    }
						    for( int i = 0; i < 5; i++ ){
						    	if( gameManager.getPassedLevelIds().contains(i))
						    		writer.write( i + "\r\n");
						    	else
						    		writer.write( -1 + "\r\n");
						    }
						    
						} catch (IOException ex) {
						  // report
						} finally {
						   try {writer.close();} catch (Exception ex) {/*ignore*/}
						}
			        	System.exit(0);
			        }
			    
			});
			
		}
		
		//MAIN METHOD
		public static void main(String[] args){
			new ImageConstants();
			new GameFrame();
		}
}