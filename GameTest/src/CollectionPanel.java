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
 * CollectionPanel is a JPanel
 * which represents the collection screen
 */

public class CollectionPanel extends JPanel implements GameManagerObserver{
	
	private GameManager gameManager;
	private GameFrame gameFrame; //reference to game frame which holds this panel
	private JLabel planesTitle; //"Planes" title
	private JLabel pilotsTitle; //"Pilots" title
	private JPanel planesPanel; //Panel that holds user planes in collection
	private JPanel pilotsPanel; //Panel that holds pilots in collection
	private List<JButton> allPlaneButtons; //List of user plane buttons
	private List<JButton> allPilotButtons;  //List of pilot weapons
	private JLabel coinLabel; //Label that shows user coins
	private JButton mainMenuButton; //Button that directs user to main menu
	private Image scaledBackgroundImage; //background image 
	
	
	//Constructor of CollectionPanel which has a reference to gameFrame it belongs to
	public CollectionPanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		gameManager = gameFrame.getGameManager();
		setLayout(null);
		setLayout( new BoxLayout(this, BoxLayout.Y_AXIS));
		
		BufferedImage backgroundImage = ImageConstants.emptyBackgroundImage;
		scaledBackgroundImage = backgroundImage.getScaledInstance(gameFrame.getWidth(), gameFrame.getHeight(), 
				      Image.SCALE_SMOOTH);
		
		coinLabel = new JLabel("COINS " + gameFrame.getGameManager().getCoins());
		coinLabel.setFont(new Font("ComicSans", Font.BOLD, 30));
		coinLabel.setBounds(50,50, 1000, 100);
		add(coinLabel);
		
		createAndAddTitles();
		allPlaneButtons = new ArrayList<JButton>();
		allPilotButtons = new ArrayList<JButton>();
		
		planesPanel = new JPanel(new FlowLayout());
		planesPanel.setOpaque(false);
		pilotsPanel = new JPanel(new FlowLayout());
		pilotsPanel.setOpaque(false);
		
		placePlanes();
		placePilots();
		
		add(planesTitle);
		add(planesPanel);
		add(pilotsTitle);
		add(pilotsPanel);
		
		mainMenuButton = new JButton();
		mainMenuButton.setIcon(new ImageIcon(ImageConstants.homeIconImage));
		mainMenuButton.setBounds(50, 50, 200, 200);
		mainMenuButton.setOpaque(false);
		mainMenuButton.setContentAreaFilled(false);
		mainMenuButton.setBorderPainted(false);
		add(mainMenuButton);

		addActionListeners();
		gameManager.subscribe(this);
	}

	//Private method call - adds action listeners
	private void addActionListeners() {
		mainMenuButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame.displayMainMenu();
			}
		});
		for( int i = 0; i < allPlaneButtons.size(); i++ ){
			final int k = i;
			allPlaneButtons.get(i).addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gameFrame.getGameManager().getCollectionManager().setUserPlaneSelection(k);
					repaint();
				}
			});
		}
		for( int i = 0; i < allPilotButtons.size(); i++ ){
			final int k = i;
			allPilotButtons.get(i).addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gameFrame.getGameManager().getCollectionManager().setPilotSelection(k);
					repaint();
				}
			});
		}
	}

	//Private method call - adds titles
	private void createAndAddTitles() {
		planesTitle = new JLabel();
		planesTitle.setText("PLANES");
		planesTitle.setFont(new Font("ComicSans", Font.BOLD, 30));
		pilotsTitle = new JLabel();
		pilotsTitle.setText("PILOTS");
		pilotsTitle.setFont(new Font("ComicSans", Font.BOLD, 30));
		
	}

	//Private method call - adds pilot buttons
	private void placePilots() {
		Image image = ImageConstants.nickPilotImage;
		JButton nickPilot = new JButton();
		nickPilot.setIcon(new ImageIcon( image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		nickPilot.setPreferredSize(new Dimension(400, 500));
		nickPilot.setOpaque(false);
		nickPilot.setContentAreaFilled(false);
		nickPilot.setBorderPainted(false);
		pilotsPanel.add(nickPilot);
		
		image = ImageConstants.pennyPilotImage;
		JButton pennyPilot = new JButton();
		pennyPilot.setIcon(new ImageIcon( image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		pennyPilot.setPreferredSize(new Dimension(400, 500));
		pennyPilot.setOpaque(false);
		pennyPilot.setContentAreaFilled(false);
		pennyPilot.setBorderPainted(false);
		pilotsPanel.add(pennyPilot);
		
		image = ImageConstants.mikePilotImage;
		JButton mikePilot = new JButton();
		mikePilot.setIcon(new ImageIcon( image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		mikePilot.setPreferredSize(new Dimension(400, 500));
		mikePilot.setOpaque(false);
		mikePilot.setContentAreaFilled(false);
		mikePilot.setBorderPainted(false);
		pilotsPanel.add(mikePilot);
		
		image = ImageConstants.evaPilotImage;
		JButton evaPilot = new JButton();
		evaPilot.setIcon(new ImageIcon( image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		evaPilot.setPreferredSize(new Dimension(400, 500));
		evaPilot.setOpaque(false);
		evaPilot.setContentAreaFilled(false);
		evaPilot.setBorderPainted(false);
		pilotsPanel.add(evaPilot);
		
		image = ImageConstants.neoPilotImage;
		JButton neoPilot = new JButton();
		neoPilot.setIcon(new ImageIcon( image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		neoPilot.setPreferredSize(new Dimension(400, 500));
		neoPilot.setOpaque(false);
		neoPilot.setContentAreaFilled(false);
		neoPilot.setBorderPainted(false);
		pilotsPanel.add(neoPilot);
		
		allPilotButtons.add(nickPilot);
		allPilotButtons.add(pennyPilot);
		allPilotButtons.add(mikePilot);
		allPilotButtons.add(evaPilot);
		allPilotButtons.add(neoPilot);
		
	}

	//Private method call - adds plane buttons
	private void placePlanes() {
		Image image = ImageConstants.alderaanCruiserUserPlaneImage;
		JButton alderaanCruiserPlane = new JButton();
		alderaanCruiserPlane.setIcon(new ImageIcon( image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		alderaanCruiserPlane.setPreferredSize(new Dimension(400, 500));
		alderaanCruiserPlane.setOpaque(false);
		alderaanCruiserPlane.setContentAreaFilled(false);
		alderaanCruiserPlane.setBorderPainted(false);
		planesPanel.add(alderaanCruiserPlane);
		
		image = ImageConstants.tomcatUserPlaneImage;
		JButton tomcatPlane = new JButton();
		tomcatPlane.setIcon(new ImageIcon(image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		tomcatPlane.setPreferredSize(new Dimension(400, 500));
		tomcatPlane.setOpaque(false);
		tomcatPlane.setContentAreaFilled(false);
		tomcatPlane.setBorderPainted(false);
		planesPanel.add(tomcatPlane);
		
		image = ImageConstants.f22RaptorUserPlaneImage;
		JButton f22RaptorPlane = new JButton();
		f22RaptorPlane.setIcon(new ImageIcon(image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		f22RaptorPlane.setPreferredSize(new Dimension(400, 500));
		f22RaptorPlane.setOpaque(false);
		f22RaptorPlane.setContentAreaFilled(false);
		f22RaptorPlane.setBorderPainted(false);
		planesPanel.add(f22RaptorPlane);
		
		image = ImageConstants.saabGripenUserPlaneImage;
		JButton saabGripenPlane = new JButton();
		saabGripenPlane.setIcon(new ImageIcon(image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		saabGripenPlane.setPreferredSize(new Dimension(400, 500));
		saabGripenPlane.setOpaque(false);
		saabGripenPlane.setContentAreaFilled(false);
		saabGripenPlane.setBorderPainted(false);
		planesPanel.add(saabGripenPlane);
		
		image = ImageConstants.wunderwaffeUserPlaneImage;
		JButton wunderWaffePlane = new JButton();
		wunderWaffePlane.setIcon(new ImageIcon(image.getScaledInstance(400, 500, Image.SCALE_SMOOTH)));
		wunderWaffePlane.setPreferredSize(new Dimension(400, 500));
		wunderWaffePlane.setOpaque(false);
		wunderWaffePlane.setContentAreaFilled(false);
		wunderWaffePlane.setBorderPainted(false);
		planesPanel.add(wunderWaffePlane);
		
		
		allPlaneButtons.add(alderaanCruiserPlane);
		allPlaneButtons.add(tomcatPlane);
		allPlaneButtons.add(f22RaptorPlane);
		allPlaneButtons.add(saabGripenPlane);
		allPlaneButtons.add(wunderWaffePlane);
	}
	
	//Paints components to screen to update coin label and enable/disable buttons
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(scaledBackgroundImage, 0, 0, null);
		coinLabel.setText("COINS " + gameFrame.getGameManager().getCoins());
		for( int i = 0; i < allPlaneButtons.size(); i++ ){
			if ( gameFrame.getGameManager().getCollectionManager().getPurchasedUserPlanes().contains(i) )
				allPlaneButtons.get(i).setEnabled(true);
			else
				allPlaneButtons.get(i).setEnabled(false);
			if( gameManager.getCollectionManager().getUserPlaneSelection() == i){
				BufferedImage image = ImageConstants.tickIconImage;
				Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				g.drawImage(scaledImage, allPlaneButtons.get(i).getX() + 60, allPlaneButtons.get(i).getY() + 120, null);
			}
		}
		for( int i = 0; i < allPilotButtons.size(); i++ ){
			if ( gameFrame.getGameManager().getCollectionManager().getPurchasedPilots().contains(i) )
				allPilotButtons.get(i).setEnabled(true);
			else
				allPilotButtons.get(i).setEnabled(false);
			
			if( gameManager.getCollectionManager().getPilotSelection() == i){
				BufferedImage image = ImageConstants.tickIconImage;
				Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				g.drawImage(scaledImage, allPilotButtons.get(i).getX() + 60, allPilotButtons.get(i).getY() + 750, null);
			}
		}
	}

	//Updates collection view by repainting it
	public void update() {
		repaint();
	}
}
