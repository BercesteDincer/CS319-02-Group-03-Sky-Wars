import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * PauseMenuPanel is a JPanel
 * which represents the Pause Menu screen 
 */
public class PauseMenuPanel extends JPanel{

	private GameFrame gameFrame; //reference to game frame pause menu belongs to 
	private Image scaledBackgroundImage; //background image
	private JLabel gameName; //title of game
	private JLabel pauseMenuTitle; //pause menu title
	private JButton continueButton; //jbutton to return to level
	private JButton quitButton; //jbutton to return to level map
	
	//Constructor of pause menu panel -it takes reference to game frame
	public PauseMenuPanel(GameFrame gameFrame) {
		setLayout(null);
		this.gameFrame = gameFrame;
		BufferedImage backgroundImage = ImageConstants.mainPageBackgroundImage;
		scaledBackgroundImage = backgroundImage.getScaledInstance(gameFrame.getWidth(), gameFrame.getHeight(), 
				      Image.SCALE_SMOOTH);
		createAndAddButtons();
		createAndAddActionListeners();
	}
	
	//Paints the panel
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(scaledBackgroundImage, 0, 0, null);
	}
		
	//Private call -creates and adds action listeners
	private void createAndAddActionListeners() {
		continueButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.resumeGame();
			}
		});
		
		quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displayLevelMap();
			}
		});
		
	}

	//Private call -creates and adds buttons
	private void createAndAddButtons() {
		gameName = new JLabel();
		gameName.setText("SKY WARS");
		gameName.setFont(new Font("ComicSans", Font.BOLD, 200));
		gameName.setBounds(1200,300,1500,200);
		
		pauseMenuTitle = new JLabel();
		pauseMenuTitle.setText("Pause Menu");
		pauseMenuTitle.setBounds(1650, 800, 1000, 200);
		pauseMenuTitle.setFont(new Font("ComicSans", Font.BOLD, 100));

		continueButton = new JButton();
		continueButton.setText("Continue");
		continueButton.setBounds(175, 1075, 1000, 200);
		continueButton.setFont(new Font("ComicSans", Font.BOLD, 100));
		continueButton.setOpaque(false);
		continueButton.setContentAreaFilled(false);
		continueButton.setBorderPainted(false);
		
		quitButton = new JButton();
		quitButton.setText("Quit Game");
		quitButton.setBounds(900, 1400, 1000, 200);
		quitButton.setFont(new Font("ComicSans", Font.BOLD, 80));
		quitButton.setOpaque(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(false);
		
		add(gameName);
		add(pauseMenuTitle);
		add(continueButton);
		add(quitButton);
	}

}
