import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * CreditsPanel is a JPanel
 * which represents the credits screen
 */
public class CreditsPanel extends JPanel{

	private GameFrame gameFrame; //reference to game frame credit panel belongs to
	private Image scaledBackgroundImage; //background image
	private JButton mainMenuButton; //button that references user back to main menu
	
	//Constructor of CreditsPanel that takes a reference to GameFrame
	public CreditsPanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setLayout(null);
		BufferedImage backgroundImage = ImageConstants.creditsBackgroundImage;
		scaledBackgroundImage = backgroundImage.getScaledInstance(gameFrame.getWidth(), gameFrame.getHeight(), 
				      Image.SCALE_SMOOTH);
		
		Image  mainMenuIcon = ImageConstants.homeIconImage;
		mainMenuButton = new JButton();
		mainMenuButton.setIcon(new ImageIcon(mainMenuIcon));
		mainMenuButton.setBounds(50, 50, 200, 200);
		mainMenuButton.setOpaque(false);
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBorderPainted(false);
		add(mainMenuButton);
		
		mainMenuButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrame.displayMainMenu();
			}
		});
		
	}
	//Paints the panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	    g.drawImage(scaledBackgroundImage, 0, 0, null);
	}

}
