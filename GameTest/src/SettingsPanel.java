import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CreditsPanel is a JPanel
 * which represents the credits screen
 */
public class SettingsPanel extends JPanel{

	private GameFrame gameFrame; //reference to game frame settings panel belongs to
	private Image scaledBackgroundImage; //background image
	private JButton mainMenuButton; //button that references user back to main menu
	private JButton turnVolumeOnButton; 
	
	//Constructor of SettingsPanel that takes a reference to GameFrame
	public SettingsPanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setLayout(null);
		BufferedImage backgroundImage = ImageConstants.mainPageBackgroundImage;
		scaledBackgroundImage = backgroundImage.getScaledInstance(gameFrame.getWidth(), gameFrame.getHeight(), 
				      Image.SCALE_SMOOTH);
		
		Image mainMenuIcon = ImageConstants.homeIconImage;
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
		
		JLabel gameName = new JLabel();
		gameName.setText("SKY WARS");
		gameName.setFont(new Font("ComicSans", Font.BOLD, 200));
		gameName.setBounds(1200,300,1500,200);
		add( gameName);
		
		JLabel settingsTitle = new JLabel();
		settingsTitle.setText("Settings");
		settingsTitle.setBounds(1850, 800, 1000, 200);
		settingsTitle.setFont(new Font("ComicSans", Font.BOLD, 100));
		add(settingsTitle);
	}

	//Paints the panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(scaledBackgroundImage, 0, 0, null);
	}
}