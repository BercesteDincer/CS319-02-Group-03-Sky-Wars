import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * StorePanel is a JPanel
 * which represents the store screen
 */

public class StorePanel extends JPanel implements GameManagerObserver{
	
	private GameFrame gameFrame; //reference to game frame the panel belongs to
	private GameManager gameManager; //reference to game manager
	
	//Titles of item groups
	private JLabel storeTitle;
	private JLabel planesTitle;
	private JLabel pilotsTitle;
	private JLabel locksTitle;
	private JLabel shootsTitle;
	private JLabel explosivesTitle;
		
	private JPanel planesPanel; //panel that holds planes
	private JPanel pilotsPanel; //panel that holds pilots
	private JPanel locksPanel; //panel that holds locks
	private JPanel shootsPanel; //panel that holds shoots
	private JPanel explosivesPanel; //panel that holds explosives
		
	private JPanel planesPricePanel; //panel that holds plane prices
	private JPanel pilotsPricePanel; //panel that holds pilot prices
	private JPanel locksPricePanel; //panel that holds lock prices
	private JPanel shootsPricePanel; //panel that holds shoot prices
	private JPanel explosivesPricePanel; ////panel that holds explosive prices
		
	private JLabel coinLabel; //label for showing amount of coins
	private JButton mainMenuButton; //jbutton to go back to main menu
		
	private List<JButton> allButtons; //
	private List<Integer> prices;
	private Image scaledBackgroundImage; //background image 
	
	//PRICE CONSTANTS OF ITEMS
	private final int alderaanCruiserPlanePrice = 0;
	private final int tomcatPlanePrice = 250;
	private final int f22RaptorPlanePrice = 500;
	private final int saabGripenPlanePrice = 1000;
	private final int wunderWaffePlanePrice = 1500;
	private final int nickPilotPrice = 0;
	private final int pennyPilotPrice = 100;
	private final int mikePilotPrice = 100;
	private final int evaPilotPrice = 500;
	private final int neoPilotPrice = 500;
	private final int damageLockPrice = 100;
	private final int healthLockPrice = 100;
	private final int invisibilityLockPrice = 100;
	private final int shieldLockPrice = 100;
	private final int speedLockPrice = 100;
	private final int metalballPrice = 100;
	private final int flamegunPrice = 100;
	private final int frostlaserPrice = 100;
	private final int laserPrice = 100;
	private final int bombPrice = 100;
	private final int missilePrice = 100;
	
	public StorePanel(GameFrame gameFrame, GameManager gameManager) {
		this.gameFrame = gameFrame;
		this.gameManager = gameManager;
		setLayout(null);
		setLayout( new BoxLayout(this, BoxLayout.Y_AXIS));
		
		BufferedImage backgroundImage = ImageConstants.emptyBackgroundImage;
		scaledBackgroundImage = backgroundImage.getScaledInstance(gameFrame.getWidth(), gameFrame.getHeight(), 
				      Image.SCALE_SMOOTH);
		
		coinLabel = new JLabel("COINS " + gameManager.getCoins());
		coinLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		coinLabel.setBounds(50,50, 1000, 100);
		add(coinLabel);
		
		createAndAddTitles();
		
		planesPanel = new JPanel(new FlowLayout());
		planesPanel.setOpaque(false);
		pilotsPanel = new JPanel(new FlowLayout());
		pilotsPanel.setOpaque(false);
		//locksPanel = new JPanel(new FlowLayout());
		//locksPanel.setOpaque(false);
		shootsPanel = new JPanel(new FlowLayout());
		shootsPanel.setOpaque(false);
		explosivesPanel = new JPanel(new FlowLayout());
		explosivesPanel.setOpaque(false);
		
		FlowLayout flow = new FlowLayout();
		flow.setHgap(50);
		planesPricePanel = new JPanel(flow);
		planesPricePanel.setOpaque(false);
		pilotsPricePanel = new JPanel(flow);
		pilotsPricePanel.setOpaque(false);
		//locksPricePanel = new JPanel(flow);	
		//locksPricePanel.setOpaque(false);
		shootsPricePanel = new JPanel(flow);
		shootsPricePanel.setOpaque(false);
		explosivesPricePanel = new JPanel(flow);
		explosivesPricePanel.setOpaque(false);
		
		placePlanes();
		placePilots();
		//placeLocks();
		placeShoots();
		placeExplosives();
		
		add(planesTitle);
		add(planesPanel);
		add(planesPricePanel);
		add(pilotsTitle);
		add(pilotsPanel);
		add(pilotsPricePanel);
		//add(locksTitle);
		//add(locksPanel);
		add(shootsTitle);
		add(shootsPanel);
		add(shootsPricePanel);
		add(explosivesTitle);
		add(explosivesPanel);
		add(explosivesPricePanel);
		
		mainMenuButton = new JButton();
		mainMenuButton.setIcon(new ImageIcon(ImageConstants.homeIconImage));
		mainMenuButton.setBounds(50, 50, 200, 200);
		mainMenuButton.setOpaque(false);
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBorderPainted(false);
		add(mainMenuButton);
		
		prices = new ArrayList<Integer>();
		prices.add(alderaanCruiserPlanePrice);
		prices.add( tomcatPlanePrice);
		prices.add(f22RaptorPlanePrice);
		prices.add(saabGripenPlanePrice);
		prices.add(wunderWaffePlanePrice);
		
		prices.add(nickPilotPrice);
		prices.add(pennyPilotPrice);
		prices.add(mikePilotPrice);
		prices.add(evaPilotPrice);
		prices.add(neoPilotPrice);
		
		prices.add( metalballPrice);
		prices.add(flamegunPrice);
		prices.add(frostlaserPrice);
		prices.add(laserPrice);
		
		prices.add(bombPrice);
		prices.add(missilePrice);
		
		addActionListeners();
		
		gameManager.subscribe(this);
	}


	private void addActionListeners() {
		mainMenuButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displayMainMenu();
			}
		});
		
		for( int i = 0; i < allButtons.size(); i++ ){
			final int k = i;
			allButtons.get(i).addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
				
					if( prices.get(k) <= gameFrame.getGameManager().getCoins()){
						gameManager.purchaseItem(k, prices.get(k));
						repaint();
					}
				}
			});
		}
		
	}


	private void createAndAddTitles() {
		planesTitle = new JLabel();
		planesTitle.setText("PLANES");
		planesTitle.setFont(new Font("ComicSans", Font.BOLD, 30));
		pilotsTitle = new JLabel();
		pilotsTitle.setText("PILOTS");
		pilotsTitle.setFont(new Font("ComicSans", Font.BOLD, 30));
		//locksTitle = new JLabel();
		//locksTitle.setText("BONUS PACKAGE LOCKS");
		//locksTitle.setFont(new Font("ComicSans", Font.BOLD, 30));
		shootsTitle = new JLabel();
		shootsTitle.setText("SHOOTS");
		shootsTitle.setFont(new Font("ComicSans", Font.BOLD, 30));
		explosivesTitle = new JLabel();
		explosivesTitle.setText("EXPLOSIVES");
		explosivesTitle.setFont(new Font("ComicSans", Font.BOLD, 30));
		
	}


	private void placeExplosives() {
		Image image = ImageConstants.bombImage;
		JButton bomb = new JButton();
		bomb.setIcon(new ImageIcon( image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		bomb.setPreferredSize(new Dimension(200, 200));
		bomb.setOpaque(false);
		bomb.setContentAreaFilled(false);
		bomb.setBorderPainted(false);
	    explosivesPanel.add(bomb);
	  
	    image = ImageConstants.missileImage;
	    JButton missile = new JButton();
	    missile.setIcon(new ImageIcon( image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
	    missile.setPreferredSize(new Dimension(200, 200));
	    missile.setOpaque(false);
	    missile.setContentAreaFilled(false);
	    missile.setBorderPainted(false);
	    explosivesPanel.add(missile);
	    
	    JLabel bombLabel = new JLabel("PRICE " + bombPrice);
	    bombLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    explosivesPricePanel.add(bombLabel);
	    JLabel missileLabel = new JLabel("PRICE " + missilePrice);
	    missileLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    explosivesPricePanel.add(missileLabel);  
	    
		allButtons.add(bomb);
		allButtons.add(missile);
	}


	private void placeShoots() {
		
		Image image = ImageConstants.metalBallImage;
		JButton metalball = new JButton();
		metalball.setIcon(new ImageIcon( image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		metalball.setPreferredSize(new Dimension(200, 200));
		metalball.setOpaque(false);
		metalball.setContentAreaFilled(false);
		metalball.setBorderPainted(false);
	    shootsPanel.add(metalball);
		
	    image = ImageConstants.flameGunImage;
	    JButton flamegun = new JButton();
		flamegun.setIcon(new ImageIcon( image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		flamegun.setPreferredSize(new Dimension(200, 200));
		flamegun.setOpaque(false);
		flamegun.setContentAreaFilled(false);
		flamegun.setBorderPainted(false);
	    shootsPanel.add(flamegun);
	    
	    image = ImageConstants.frostLaserImage;
	    JButton frostlaser = new JButton();
		frostlaser.setIcon(new ImageIcon( image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		frostlaser.setPreferredSize(new Dimension(200, 200));
		frostlaser.setOpaque(false);
		frostlaser.setContentAreaFilled(false);
		frostlaser.setBorderPainted(false);
	    shootsPanel.add(frostlaser);
	    
	    image = ImageConstants.laserImage;
	    JButton laser = new JButton();
	    laser.setIcon(new ImageIcon( image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
	    laser.setPreferredSize(new Dimension(200, 200));
	    laser.setOpaque(false);
	    laser.setContentAreaFilled(false);
		laser.setBorderPainted(false);
		shootsPanel.add(laser);
		
	    JLabel metalballLabel = new JLabel("PRICE " + metalballPrice);
		metalballLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    shootsPricePanel.add(metalballLabel);
	    
		JLabel flamegunLabel = new JLabel("PRICE " + flamegunPrice);
		flamegunLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    shootsPricePanel.add(flamegunLabel);
	    
	    JLabel frostlaserLabel = new JLabel("PRICE " +  frostlaserPrice);
	    frostlaserLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    shootsPricePanel.add(frostlaserLabel);
	    
	    JLabel laserLabel = new JLabel("PRICE " +  laserPrice);
	    laserLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    shootsPricePanel.add(laserLabel);
	    
	    allButtons.add( metalball);
		allButtons.add(flamegun);
		allButtons.add(frostlaser);
		allButtons.add(laser);
	    
	}


	private void placeLocks() {
		Image image = ImageConstants.damagePackageImage;
		JButton damageLock = new JButton();
		damageLock.setIcon(new ImageIcon( image.getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
		damageLock.setPreferredSize(new Dimension(200, 200));
		damageLock.setOpaque(false);
		damageLock.setContentAreaFilled(false);
		damageLock.setBorderPainted(false);
		locksPanel.add(damageLock);
		
		image = ImageConstants.healthPackageImage;
		JButton healthLock = new JButton();
		healthLock.setIcon(new ImageIcon( image.getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
		healthLock.setPreferredSize(new Dimension(200, 200));
		healthLock.setOpaque(false);
		healthLock.setContentAreaFilled(false);
		healthLock.setBorderPainted(false);
		locksPanel.add(healthLock);
		
		image = ImageConstants.invisibilityPackageImage;
		JButton invisibilityLock = new JButton();
		invisibilityLock.setIcon(new ImageIcon( image.getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
		invisibilityLock.setPreferredSize(new Dimension(200, 200));
		invisibilityLock.setOpaque(false);
		invisibilityLock.setContentAreaFilled(false);
		invisibilityLock.setBorderPainted(false);
		locksPanel.add(invisibilityLock);
		
		image = ImageConstants.shieldPackageImage;
		JButton shieldLock = new JButton();
		shieldLock.setIcon(new ImageIcon( image.getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
		shieldLock.setPreferredSize(new Dimension(200, 200));
		shieldLock.setOpaque(false);
		shieldLock.setContentAreaFilled(false);
		shieldLock.setBorderPainted(false);
		locksPanel.add(shieldLock);
		
		image = ImageConstants.speedPackageImage;
		JButton speedLock = new JButton();
		speedLock.setIcon(new ImageIcon( image.getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
		speedLock.setPreferredSize(new Dimension(200, 200));
		speedLock.setOpaque(false);
		speedLock.setContentAreaFilled(false);
		speedLock.setBorderPainted(false);
		locksPanel.add(speedLock);
		
		JLabel damageLockLabel = new JLabel("PRICE " + damageLockPrice);
		damageLockLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    locksPricePanel.add(damageLockLabel);
	    
	    JLabel healthLockLabel = new JLabel("PRICE " + healthLockPrice);
	    healthLockLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    locksPricePanel.add( healthLockLabel);
	    
	    JLabel invisibilityLockLabel = new JLabel("PRICE " +  invisibilityLockPrice);
	    invisibilityLockLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    locksPricePanel.add( invisibilityLockLabel);
	    
	    JLabel shieldLockLabel = new JLabel("PRICE " + shieldLockPrice);
	    shieldLockLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    locksPricePanel.add(shieldLockLabel);
	    
	    JLabel speedLockLabel = new JLabel("PRICE " +  speedLockPrice);
	    speedLockLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
	    locksPricePanel.add( speedLockLabel);
	    
	}


	private void placePilots() {
		Image image = ImageConstants.nickPilotImage;
		JButton nickPilot = new JButton();
		nickPilot.setIcon(new ImageIcon( image.getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
		nickPilot.setPreferredSize(new Dimension(200, 200));
		nickPilot.setOpaque(false);
		nickPilot.setContentAreaFilled(false);
		nickPilot.setBorderPainted(false);
		pilotsPanel.add(nickPilot);
		
		image = ImageConstants.pennyPilotImage;
		JButton pennyPilot = new JButton();
		pennyPilot.setIcon(new ImageIcon( image.getScaledInstance(100, 200, Image.SCALE_SMOOTH)));
		pennyPilot.setPreferredSize(new Dimension(200, 200));
		pennyPilot.setOpaque(false);
		pennyPilot.setContentAreaFilled(false);
		pennyPilot.setBorderPainted(false);
		pilotsPanel.add(pennyPilot);
		
		image = ImageConstants.mikePilotImage;
		JButton mikePilot = new JButton();
		mikePilot.setIcon(new ImageIcon( image.getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
		mikePilot.setPreferredSize(new Dimension(200, 200));
		mikePilot.setOpaque(false);
		mikePilot.setContentAreaFilled(false);
		mikePilot.setBorderPainted(false);
		pilotsPanel.add(mikePilot);
		
		image = ImageConstants.evaPilotImage;
		JButton evaPilot = new JButton();
		evaPilot.setIcon(new ImageIcon( image.getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
		evaPilot.setPreferredSize(new Dimension(200, 200));
		evaPilot.setOpaque(false);
		evaPilot.setContentAreaFilled(false);
		evaPilot.setBorderPainted(false);
		pilotsPanel.add(evaPilot);
		
		image = ImageConstants.neoPilotImage;
		JButton neoPilot = new JButton();
		neoPilot.setIcon(new ImageIcon( image.getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
		neoPilot.setPreferredSize(new Dimension(200, 200));
		neoPilot.setOpaque(false);
		neoPilot.setContentAreaFilled(false);
		neoPilot.setBorderPainted(false);
		pilotsPanel.add(neoPilot);
		
		JLabel nickPilotLabel = new JLabel("PRICE " +  nickPilotPrice);
		nickPilotLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		pilotsPricePanel.add( nickPilotLabel);
		
		JLabel pennyPilotLabel = new JLabel("PRICE " +  pennyPilotPrice);
		pennyPilotLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		pilotsPricePanel.add( pennyPilotLabel);
		
		JLabel mikePilotLabel = new JLabel("PRICE " +  mikePilotPrice);
		mikePilotLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		pilotsPricePanel.add( mikePilotLabel);
		
		JLabel evaPilotLabel = new JLabel("PRICE " + evaPilotPrice);
		evaPilotLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		pilotsPricePanel.add( evaPilotLabel);
		
		JLabel neoPilotLabel = new JLabel("PRICE " +  neoPilotPrice);
		neoPilotLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		pilotsPricePanel.add( neoPilotLabel);
		
		allButtons.add(nickPilot);
		allButtons.add(pennyPilot);
		allButtons.add(mikePilot);
		allButtons.add(evaPilot);
		allButtons.add(neoPilot);
		
	}


	private void placePlanes() {
		Image image = ImageConstants.alderaanCruiserUserPlaneImage;
		JButton alderaanCruiserPlane = new JButton();
		alderaanCruiserPlane.setIcon(new ImageIcon( image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		alderaanCruiserPlane.setPreferredSize(new Dimension(200, 200));
		alderaanCruiserPlane.setOpaque(false);
		alderaanCruiserPlane.setContentAreaFilled(false);
		alderaanCruiserPlane.setBorderPainted(false);
		planesPanel.add(alderaanCruiserPlane);
		
		image = ImageConstants.tomcatUserPlaneImage;
		JButton tomcatPlane = new JButton();
		tomcatPlane.setIcon(new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		tomcatPlane.setPreferredSize(new Dimension(200, 200));
		tomcatPlane.setOpaque(false);
		tomcatPlane.setContentAreaFilled(false);
		tomcatPlane.setBorderPainted(false);
		planesPanel.add(tomcatPlane);
		
		image = ImageConstants.f22RaptorUserPlaneImage;
		JButton f22RaptorPlane = new JButton();
		f22RaptorPlane.setIcon(new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		f22RaptorPlane.setPreferredSize(new Dimension(200, 200));
		f22RaptorPlane.setOpaque(false);
		f22RaptorPlane.setContentAreaFilled(false);
		f22RaptorPlane.setBorderPainted(false);
		planesPanel.add(f22RaptorPlane);
		
		image = ImageConstants.saabGripenUserPlaneImage;
		JButton saabGripenPlane = new JButton();
		saabGripenPlane.setIcon(new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		saabGripenPlane.setPreferredSize(new Dimension(200, 200));
		saabGripenPlane.setOpaque(false);
		saabGripenPlane.setContentAreaFilled(false);
		saabGripenPlane.setBorderPainted(false);
		planesPanel.add(saabGripenPlane);
		
		image = ImageConstants.wunderwaffeUserPlaneImage;
		JButton wunderWaffePlane = new JButton();
		wunderWaffePlane.setIcon(new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		wunderWaffePlane.setPreferredSize(new Dimension(200, 200));
		wunderWaffePlane.setOpaque(false);
		wunderWaffePlane.setContentAreaFilled(false);
		wunderWaffePlane.setBorderPainted(false);
		planesPanel.add(wunderWaffePlane);
		
		JLabel alderaanCruiserPlaneLabel = new JLabel("PRICE " +  alderaanCruiserPlanePrice);
		alderaanCruiserPlaneLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		planesPricePanel.add( alderaanCruiserPlaneLabel);
		
		JLabel tomcatPlaneLabel = new JLabel("PRICE " +  tomcatPlanePrice);
		tomcatPlaneLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		planesPricePanel.add(tomcatPlaneLabel);
		
		JLabel f22RaptorPlaneLabel = new JLabel("PRICE " +  f22RaptorPlanePrice);
		f22RaptorPlaneLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		planesPricePanel.add( f22RaptorPlaneLabel);
		
		JLabel saabGripenPlaneLabel = new JLabel("PRICE " +  saabGripenPlanePrice);
		saabGripenPlaneLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		planesPricePanel.add( saabGripenPlaneLabel);
		
		JLabel wunderWaffePlaneLabel = new JLabel("PRICE " +  wunderWaffePlanePrice);
		wunderWaffePlaneLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		planesPricePanel.add( wunderWaffePlaneLabel);
		
		allButtons = new ArrayList<JButton>();
		allButtons.add(alderaanCruiserPlane);
		allButtons.add( tomcatPlane);
		allButtons.add(f22RaptorPlane);
		allButtons.add(saabGripenPlane);
		allButtons.add(wunderWaffePlane);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(scaledBackgroundImage, 0, 0, null);
		coinLabel.setText("COINS " + gameFrame.getGameManager().getCoins());

		for( int i = 0; i < allButtons.size(); i++ ){
			if( prices.get(i) > gameManager.getCoins()){
				allButtons.get(i).setEnabled(false);
			}
			if( prices.get(i) <= gameManager.getCoins()){
				allButtons.get(i).setEnabled(true);
			}
			if(  gameManager.purchasedPlanesContains(i))
				allButtons.get(i).setEnabled(false);
			if(   gameManager.purchasedPilotsContains(i-5) )
			{
				allButtons.get(i).setEnabled(false);
			}
		}
	}
	
	public void update(){
		repaint();
	}
}
