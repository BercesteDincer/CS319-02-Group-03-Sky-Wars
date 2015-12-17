import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * LevelPanel is a JPanel
 * which represents the Level screen 
 */
public class LevelPanel extends JPanel implements GameManagerObserver{
	
	private GameFrame gameFrame; //reference to game frame the panel belongs to
	private GameManager gameManager; //reference to game manager
	private JPanel labelsPanel; //panel that holds all labels
	private JLabel timeLabel; //label that denotes time
	private JLabel healthLabel; //label that denotes health
	private JLabel pointsLabel; //label that denotes points
	private int timeInSeconds; //time passed in level
	private Timer timer; //timer for keeping level time
	private boolean isGameOver; //represents whether game is over or not 
	private boolean isGamePaused; //represents whether game is paused or not 
	private JButton pauseButton; //jbutton for pausing the game
	private Timer gameOverTimer; //timer for counting time of game over label displays
	private JLabel gameOverLabel; //label for "Game Over" title 
	private JLabel levelPassedLabel; //label for indicating end of level status
	private JLabel totalPointsLabel; //label for total points collected
	private JLabel totalCoinsLabel; //label for total coins collected
	private JLabel metalBallLabel; //label for number of metal balls
	private JLabel flameGunLabel; //label for number of flameGuns
	private JLabel frostLaserLabel; //label for number of frostLasers
	private JLabel laserLabel; //label  for number of lasers
	private JLabel bombLabel; //label for number of bombs
	private JLabel missileLabel; //label for number of missiles
	private Image scaledBackgroundImage;  //background image of panel
	private Image scaledBackgroundImage2;  //background image of panel
	
	//Constructor of level panel - it takes reference to game frame
	public LevelPanel( GameFrame menu){
		super(null);
		this.gameFrame = menu;
		gameManager = menu.getGameManager();
		gameManager.createObjects(menu.getWidth());
		setFocusable(true);
		isGameOver = false;
		isGamePaused = false;
		
		BufferedImage backgroundImage = null;
		BufferedImage backgroundImage2 = null;
		
		if( gameManager.getLevelManager().getCurrentLevelId() == 1){
			backgroundImage = ImageConstants.level1BackgroundImage;
			backgroundImage2 = ImageConstants.level1BackgroundImage2;
		}
		else if( gameManager.getLevelManager().getCurrentLevelId() == 2){
			backgroundImage = ImageConstants.level2BackgroundImage;
			backgroundImage2 = ImageConstants.level2BackgroundImage2;
		}
		else if( gameManager.getLevelManager().getCurrentLevelId() == 3){
			backgroundImage = ImageConstants.level3BackgroundImage;
			backgroundImage2 = ImageConstants.level3BackgroundImage2;
		}
		else if( gameManager.getLevelManager().getCurrentLevelId() == 4){
			backgroundImage = ImageConstants.level4BackgroundImage;
			backgroundImage2 = ImageConstants.level4BackgroundImage2;
		}
		else{
			backgroundImage = ImageConstants.level5BackgroundImage;
			backgroundImage2 = ImageConstants.level5BackgroundImage2;
		}
		
		scaledBackgroundImage = backgroundImage.getScaledInstance(menu.getWidth(), menu.getHeight(), 
				      Image.SCALE_SMOOTH);	
		scaledBackgroundImage2 = backgroundImage2.getScaledInstance(menu.getWidth(), menu.getHeight(), 
			      Image.SCALE_SMOOTH);	
		setLayout(null);
		createAndAddTimers();
		createAndAddLabels();
		addActionListeners();
		gameOverTimer = new Timer(5000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameOverTimer.stop();
				isGameOver = true;
				remove(levelPassedLabel);
				remove(totalPointsLabel);
				remove(totalCoinsLabel);
				remove(gameOverLabel);
				gameFrame.displayLevelMap();
			}
		});
		gameManager.subscribe(this);
		x1 = gameFrame.getWidth();
		x = 0;
		y = 0;
		y1 = 0;
	}
	
	int x;
	int y;
	int x1;
	int y1;
	
	//Paints the panel
	@Override   
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//g.drawImage(scaledBackgroundImage, 0, 0, null);
		// Draw the image onto the Graphics reference
        g.drawImage(scaledBackgroundImage, x, y, null);
        g.drawImage(scaledBackgroundImage2, x1, y1, null);
        
        // Move the x position left for next time
        x -= 2;
        x1 -= 2;
  
        // Check to see if the image has gone off stage left
        if (x <= -1 * scaledBackgroundImage.getWidth(null) ) {
 
            // If it has, line it back up so that its left edge is
            // lined up to the right side of the other background image
        	x = x + scaledBackgroundImage.getWidth(null) * 2;
        }
        if (x1 <= -1 * scaledBackgroundImage2.getWidth(null) ) {
        	 
            // If it has, line it back up so that its left edge is
            // lined up to the right side of the other background image
        	x1 = x1 + scaledBackgroundImage2.getWidth(null) * 2;
        }
        
		if( !isGameOver && !isGamePaused ){
			gameManager.drawUserPlane(g);
			moveObjects(g);
			gameManager.drawUserWeapons(g);
			checkCollision();
			drawExplosions(g);
			updateLabels();
		}
	}
		
	//Ends the game 
	public void gameOver() {
		createAndAddGameOverLabels();
		isGameOver = true;
		repaint();	
	}
	
	//Resumes the game
	public void resumeGame() {
		isGamePaused = false;
		timer.start();
		repaint();
	}
		
	//Initializes the level
	public void initializeGame(int levelId){
		gameOverTimer.stop();
		isGamePaused = false;
		isGameOver = false;
		timeInSeconds = 0;
		x1 = gameFrame.getWidth();
		x = 0;
		y = 0;
		y1 = 0;
		gameManager.initializeLevel(levelId);
		
		BufferedImage backgroundImage = null;
		BufferedImage backgroundImage2 = null;
		
		if( gameManager.getLevelManager().getCurrentLevelId() == 1){
			backgroundImage = ImageConstants.level1BackgroundImage;
			backgroundImage2 = ImageConstants.level1BackgroundImage2;
		}
		else if( gameManager.getLevelManager().getCurrentLevelId() == 2){
			backgroundImage = ImageConstants.level2BackgroundImage;
			backgroundImage2 = ImageConstants.level2BackgroundImage2;
		}
		else if( gameManager.getLevelManager().getCurrentLevelId() == 3){
			backgroundImage = ImageConstants.level3BackgroundImage;
			backgroundImage2 = ImageConstants.level3BackgroundImage2;
		}
		else if( gameManager.getLevelManager().getCurrentLevelId() == 4){
			backgroundImage = ImageConstants.level4BackgroundImage;
			backgroundImage2 = ImageConstants.level4BackgroundImage2;
		}
		else{
			backgroundImage = ImageConstants.level5BackgroundImage;
			backgroundImage2 = ImageConstants.level5BackgroundImage2;
		}
		
		scaledBackgroundImage = backgroundImage.getScaledInstance(gameFrame.getWidth(), gameFrame.getHeight(), 
				      Image.SCALE_SMOOTH);	
		scaledBackgroundImage2 = backgroundImage2.getScaledInstance(gameFrame.getWidth(), gameFrame.getHeight(), 
			      Image.SCALE_SMOOTH);	
		
		timer.start();
		repaint();
	}

	@Override
	public void update() {
		repaint();
	}
	
	//Private call - adds timers
	private void createAndAddTimers() {
		timer = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeInSeconds++;
				gameManager.createObjects(timeInSeconds, gameFrame.getWidth());
			}
			
		});
		Timer timer2 = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gameManager.getLevelManager().removeExplosions();
			}
		});
		timer2.start();
	}
	
	//Private call -adds action listeners
	private void addActionListeners() {
		addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) { 
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameManager.moveUserPlane(0);
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                	gameManager.moveUserPlane(1);
                    repaint();
                    
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                	gameManager.shoot(getGraphics());
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_C) {
                	gameManager.changeWeapon(getGraphics());
                    repaint();
                }
            }
        });
		pauseButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pauseGame();
			}
		});
	}
	
	//Private call -pauses the game
	private void pauseGame(){
		isGamePaused = true;
		timer.stop();
		gameFrame.displayPauseMenu();
		
	}
	
	//Private call -adds labels
	private void createAndAddLabels() {
		labelsPanel = new JPanel(new FlowLayout());
		labelsPanel.setBounds(0, 0, gameFrame.getWidth(), 100 );
		labelsPanel.setOpaque(false);
		add(labelsPanel);
		
		timeLabel = new JLabel();
		timeLabel.setText("Time: " + timeInSeconds);
		timeLabel.setFont(new Font("ComicSans", Font.BOLD, 50));
		labelsPanel.add(timeLabel);
		
		healthLabel = new JLabel();
		healthLabel.setText("Health: " + gameManager.getLevelManager().getLevel().getUserPlane().getHealth() + "");
		healthLabel.setFont(new Font("ComicSans", Font.BOLD, 50));
		labelsPanel.add(healthLabel);
		
		pointsLabel = new JLabel();
		pointsLabel.setText("Points: " + gameManager.getLevelManager().getLevel().getPoints());
		pointsLabel.setFont(new Font("ComicSans", Font.BOLD, 50));
		labelsPanel.add(pointsLabel);
		
		pauseButton = new JButton();
		Image pauseIcon = ImageConstants.pauseIconImage;
		pauseButton.setIcon(new ImageIcon(pauseIcon));
		pauseButton.setBounds(50, 50, 50, 50);
		pauseButton.setOpaque(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setBorderPainted(false);
		add(pauseButton);
		
		JLabel metalBallImageLabel = new JLabel();
		metalBallImageLabel.setIcon(new ImageIcon(ImageConstants.metalBallImage.getScaledInstance(80,80, Image.SCALE_SMOOTH)));
		labelsPanel.add(metalBallImageLabel);
		
		metalBallLabel = new JLabel();
		metalBallLabel.setText("" + gameManager.getPurchasedWeapons().get(0));
		metalBallLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
		labelsPanel.add(metalBallLabel);
		
		JLabel flameGunImageLabel = new JLabel();
		flameGunImageLabel.setIcon(new ImageIcon(ImageConstants.flameGunImage.getScaledInstance(80,80, Image.SCALE_SMOOTH)));
		labelsPanel.add( flameGunImageLabel);
		
		flameGunLabel = new JLabel();
		flameGunLabel.setText("" + gameManager.getPurchasedWeapons().get(1));
		flameGunLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
		labelsPanel.add(flameGunLabel);
		
		JLabel frostLaserImageLabel = new JLabel();
		frostLaserImageLabel.setIcon(new ImageIcon(ImageConstants.frostLaserImage.getScaledInstance(80,80, Image.SCALE_SMOOTH)));
		labelsPanel.add( frostLaserImageLabel);
		
		frostLaserLabel = new JLabel();
		frostLaserLabel.setText("" + gameManager.getPurchasedWeapons().get(2));
		frostLaserLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
		labelsPanel.add(frostLaserLabel);
		
		JLabel laserImageLabel = new JLabel();
		laserImageLabel.setIcon(new ImageIcon(ImageConstants.laserImage.getScaledInstance(80,80, Image.SCALE_SMOOTH)));
		labelsPanel.add( laserImageLabel);
		
		laserLabel = new JLabel();
		laserLabel.setText("" + gameManager.getPurchasedWeapons().get(3));
		laserLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
		labelsPanel.add(laserLabel);
		
		JLabel bombImageLabel = new JLabel();
		bombImageLabel.setIcon(new ImageIcon(ImageConstants.bombImage.getScaledInstance(80,80, Image.SCALE_SMOOTH)));
		labelsPanel.add( bombImageLabel);
		
		bombLabel = new JLabel();
		bombLabel.setText("" + gameManager.getPurchasedWeapons().get(4));
		bombLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
		labelsPanel.add(bombLabel);
		
		JLabel missileImageLabel = new JLabel();
		missileImageLabel.setIcon(new ImageIcon(ImageConstants.missileImage.getScaledInstance(80,80, Image.SCALE_SMOOTH)));
		labelsPanel.add( missileImageLabel);
		
		missileLabel = new JLabel();
		missileLabel.setText("" + gameManager.getPurchasedWeapons().get(5));
		missileLabel.setFont(new Font("Comic Sans", Font.BOLD, 50));
		labelsPanel.add(missileLabel);
		
	}
	
	//Private call-updates labels
	private void updateLabels() {
		pointsLabel.setText("Points: " + gameManager.getLevelManager().getLevel().getPoints());
	    updateTimeLevel();
	    healthLabel.setText("Health: " + gameManager.getLevelManager().getLevel().getUserPlane().getHealth() + "");
	    metalBallLabel.setText("" + gameManager.getPurchasedWeapons().get(0));
		flameGunLabel.setText("" + gameManager.getPurchasedWeapons().get(1));
		frostLaserLabel.setText("" + gameManager.getPurchasedWeapons().get(2));
		laserLabel.setText("" + gameManager.getPurchasedWeapons().get(3));
		bombLabel.setText("" + gameManager.getPurchasedWeapons().get(4));
		missileLabel.setText("" + gameManager.getPurchasedWeapons().get(5));
	}

	//Private call-draws explosions
	private void drawExplosions(Graphics g) {
		gameManager.drawExplosions(g);
		repaint();
	}
	
	//Private call-updates time label
	private void updateTimeLevel() {
		int timeNow = gameManager.getLevelManager().getLevel().getLevelTimePeriod()- timeInSeconds;
		if( timeNow == 0 ){
			gameOver();
		}
		int seconds = (timeNow % 60);
		String secondText;
		if( seconds < 10 )
			secondText = "0" + seconds;
		else
			secondText = seconds + "";
	    timeLabel.setText("Time: " + (timeNow / 60) + ":" + secondText);
	}

	//private call-checks collisions
	private void checkCollision() {
		gameManager.checkCollisions(getGraphics());
		repaint();
	}
	
	//private call- moves objects
	private void moveObjects(Graphics g) {
		gameManager.drawObjects(g);
		repaint();
	} 

	//Private call-updates game over labels
	private void createAndAddGameOverLabels() {
		gameOverLabel = new JLabel();
		if( gameManager.levelPassed() ){
			gameOverLabel.setText("LEVEL PASSED");
		}
		else{
			gameOverLabel.setText("GAME OVER");
		}
		gameOverLabel.setFont(new Font("ComicSans", Font.BOLD, 200));
		gameOverLabel.setBounds(800,300,2000,200);
		
		totalPointsLabel = new JLabel();
		totalPointsLabel.setText("Total Points: " + gameManager.getPoints());
		totalPointsLabel.setFont(new Font("ComicSans", Font.BOLD, 50));
		totalPointsLabel.setBounds(800,600,1500,200);
		
		totalCoinsLabel = new JLabel();
		totalCoinsLabel.setText("Total Coins: " + gameManager.turnPointsIntoCoins(gameManager.getPoints()));
		totalCoinsLabel.setFont(new Font("ComicSans", Font.BOLD, 50));
		totalCoinsLabel.setBounds(800,800,1500,200);
		
		levelPassedLabel = new JLabel();
		levelPassedLabel.setText(gameManager.levelPassedText());
		levelPassedLabel.setFont(new Font("ComicSans", Font.BOLD, 50));
		levelPassedLabel.setBounds(800,1000,1500,200);
		
		if( gameManager.levelPassed() ){
			gameManager.addPassedLevel(gameManager.getLevelManager().getLevel().getLevelId());
			gameManager.playSound(SoundManager.PASSED_LEVEL_SOUND).start();
		}
		else{
			gameManager.playSound(SoundManager.GAME_OVER_SOUND).start();
		}
		add(levelPassedLabel);
		add(totalPointsLabel);
		add(totalCoinsLabel);
		add(gameOverLabel);
		
		gameOverTimer.start();
	}

}
