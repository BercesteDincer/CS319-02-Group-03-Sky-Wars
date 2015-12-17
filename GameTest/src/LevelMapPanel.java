import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * LevelMapPanel is a JPanel
 * which represents the Level Map screen 
 */
public class LevelMapPanel extends JPanel{

	private GameFrame gameFrame; //reference to game frame level map panel belongs to
	private JButton mainMenuButton; //jbutton to return to main menu
	private List<JButton> levelButtons; //list of buttons that access levels
	private Image scaledBackgroundImage; //background image of level map panel
	private JButton bonusMissionButton;
	
	//Constructor of Level Map panel - it takes a game frame reference which is its creator
	public LevelMapPanel( GameFrame frame){
		super();
		this.gameFrame = frame;
		levelButtons = new ArrayList<JButton>();
		BufferedImage backgroundImage = ImageConstants.levelMapBackgroundImage;
		scaledBackgroundImage = backgroundImage.getScaledInstance(frame.getWidth(), frame.getHeight(), 
				      Image.SCALE_SMOOTH);
		setLayout(null);
		createAndAddLabels();
		addActionListeners();
	}
	
	//Private call-adds action listeners
	private void addActionListeners() {
		
		for( int i = 0; i < levelButtons.size(); i++ ){
			final int k = i + 1;
			levelButtons.get(i).addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					gameFrame.displayLevel(k);
				}
			});
		}
		mainMenuButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gameFrame.displayMainMenu();
			}
		});
	}

	//private call - adds labels
	private void createAndAddLabels(){
		JButton level1Button = new JButton();
		level1Button.setText("Level 1");
		level1Button.setFont(new Font("ComicSans", Font.BOLD, 70));
		level1Button.setBounds(250,1350,800,200);
		level1Button.setOpaque(false);
		level1Button.setContentAreaFilled(false);
		level1Button.setBorderPainted(false);
		levelButtons.add(level1Button);
		
		JButton level2Button = new JButton();
		level2Button.setText("Level 2");
		level2Button.setFont(new Font("ComicSans", Font.BOLD, 85));
		level2Button.setBounds(1100,1200,800,200);
		level2Button.setOpaque(false);
		level2Button.setContentAreaFilled(false);
		level2Button.setBorderPainted(false);
		levelButtons.add(level2Button);
		
		JButton level3Button = new JButton();
		level3Button.setText("Level 3");
		level3Button.setFont(new Font("ComicSans", Font.BOLD, 85));
		level3Button.setBounds(1800,850,800,200);
		level3Button.setOpaque(false);
		level3Button.setContentAreaFilled(false);
		level3Button.setBorderPainted(false);
		levelButtons.add(level3Button);
		
		JButton level4Button = new JButton();
		level4Button.setText("Level 4");
		level4Button.setFont(new Font("ComicSans", Font.BOLD, 100));
		level4Button.setBounds(550,700,800,200);
		level4Button.setOpaque(false);
		level4Button.setContentAreaFilled(false);
		level4Button.setBorderPainted(false);
		levelButtons.add(level4Button);
		
		JButton level5Button = new JButton();
		level5Button.setText("Level 5");
		level5Button.setFont(new Font("ComicSans", Font.BOLD, 150));
		level5Button.setBounds(870,300,800,200);
		level5Button.setOpaque(false);
		level5Button.setContentAreaFilled(false);
		level5Button.setBorderPainted(false);
		levelButtons.add(level5Button);
		
		for( int i = 0; i < levelButtons.size(); i++ ){
			if( gameFrame.getGameManager().getPassedLevelIds().contains(i) ){
				add(levelButtons.get(i));
			}
				
		}
		
		mainMenuButton = new JButton();
		Image mainMenuIcon = ImageConstants.homeIconImage;
		mainMenuButton.setIcon(new ImageIcon(mainMenuIcon));
		mainMenuButton.setBounds(50, 50, 200, 200);
		mainMenuButton.setOpaque(false);
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBorderPainted(false);
		add(mainMenuButton);
	}
	
	//Paints the panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	    g.drawImage(scaledBackgroundImage, 0, 0, null); 
	    updateLabel();
	}
	
	//Private call-updates levels
	private void updateLabel() {
		for( int i = 0; i < gameFrame.getGameManager().getPassedLevelIds().size(); i++ )
			System.out.println("PASSED LEVEL IDS" + gameFrame.getGameManager().getPassedLevelIds().get(i));
		for( int i = 0; i < levelButtons.size(); i++ ){
			
			if( gameFrame.getGameManager().getPassedLevelIds().contains(i) )
				add(levelButtons.get(i));
		}
	}

	//Returns game frame
	public GameFrame getFrame() {
		return gameFrame;
	}
	
}
