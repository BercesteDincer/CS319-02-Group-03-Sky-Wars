import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * MainMenuPanel is a JPanel
 * which represents the Main Menu screen 
 */
public class MainMenuPanel extends JPanel{
	
	private GameFrame gameFrame; //reference to game frame which holds the panel
	private JLabel gameName; //label of game title
	private JButton levelMapButton; //jbutton to go to level map
	private JButton storeButton;  //jbutton to go to store
	private JButton collectionButton; //jbutton to go to collection
	private JButton settingsButton; //jbutton to go to settings
	private JButton helpButton;  //jbutton to go to help
	private JButton creditsButton; //jbutton to go to credits	
	private Image scaledBackgroundImage; //background image 
	
	//Constructor of main menu panel -it takes a reference to game frame 
	public MainMenuPanel( GameFrame frame){
		super();
		this.gameFrame = frame;
		//Drawing background image
		BufferedImage backgroundImage = ImageConstants.mainPageBackgroundImage;
		scaledBackgroundImage = backgroundImage.getScaledInstance(frame.getWidth(), frame.getHeight(), 
				      Image.SCALE_SMOOTH);
		setLayout(null);
		createAndAddLabels();
		addActionListeners();
	}
	
	//Private call-adds labels
	private void addActionListeners() {
		levelMapButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displayLevelMap();
			}
		});
		storeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displayStore();
			}
		});
		collectionButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displayCollection();
			}
		});
		settingsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displaySettings();
			}
		});
		helpButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displayHelp();
			}
		});
		creditsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displayCredits();
			}
		});
		
	}
	
	//Private call-adds labels
	private void createAndAddLabels(){
		gameName = new JLabel();
		gameName.setText("SKY WARS");
		gameName.setFont(new Font("ComicSans", Font.BOLD, 200));
		gameName.setBounds(1200,300,1500,200);
		
		levelMapButton = new JButton();
		levelMapButton.setText("Level Map");
		levelMapButton.setBounds(1650, 800, 1000, 200);
		levelMapButton.setFont(new Font("ComicSans", Font.BOLD, 100));
		levelMapButton.setOpaque(false);
		levelMapButton.setContentAreaFilled(false);
		levelMapButton.setBorderPainted(false);

		storeButton = new JButton();
		storeButton.setText("Store");
		storeButton.setBounds(175, 1075, 1000, 200);
		storeButton.setFont(new Font("ComicSans", Font.BOLD, 100));
		storeButton.setOpaque(false);
		storeButton.setContentAreaFilled(false);
		storeButton.setBorderPainted(false);
		
		collectionButton = new JButton();
		collectionButton.setText("Collection");
		collectionButton.setBounds(900, 1400, 1000, 200);
		collectionButton.setFont(new Font("ComicSans", Font.BOLD, 80));
		collectionButton.setOpaque(false);
		collectionButton.setContentAreaFilled(false);
		collectionButton.setBorderPainted(false);
		
		settingsButton = new JButton();
		settingsButton.setIcon(new ImageIcon(ImageConstants.settingsIconImage));
		settingsButton.setBounds(545, 610, 300, 300);
		settingsButton.setOpaque(false);
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorderPainted(false);
		
		helpButton = new JButton();
		helpButton.setIcon(new ImageIcon(ImageConstants.helpIconImage));
		helpButton.setBounds(220, 335, 200, 200);
		helpButton.setOpaque(false);
		helpButton.setContentAreaFilled(false);
		helpButton.setBorderPainted(false);
		
		creditsButton = new JButton();
		creditsButton.setIcon(new ImageIcon(ImageConstants.creditsIconImage));
		creditsButton.setBounds(385, 1495, 200, 200);
		creditsButton.setOpaque(false);
		creditsButton.setContentAreaFilled(false);
		creditsButton.setBorderPainted(false);
		
		add(gameName);
		add(levelMapButton);
		add(storeButton);
		add(collectionButton);
		add(settingsButton);
		add(helpButton);
		add(creditsButton);
		
	}
	
	//Returns game frame 
	public JFrame getGameFrame() {
		return gameFrame;
	}

	//Paints the panel
	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(scaledBackgroundImage, 0, 0, null);
	}
	
	
}
