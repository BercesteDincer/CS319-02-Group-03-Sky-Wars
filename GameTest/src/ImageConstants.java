import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ImageConstants class contains all images of the game
 */
public class ImageConstants {
	
	//USERS
	static BufferedImage user11;
	static BufferedImage user12;
	static BufferedImage user13;
	static BufferedImage user14;
	static BufferedImage user15;
	
	static BufferedImage user21;
	static BufferedImage user22;
	static BufferedImage user23;
	static BufferedImage user24;
	static BufferedImage user25;
	
	static BufferedImage user31;
	static BufferedImage user32;
	static BufferedImage user33;
	static BufferedImage user34;
	static BufferedImage user35;
	
	static BufferedImage user41;
	static BufferedImage user42;
	static BufferedImage user43;
	static BufferedImage user44;
	static BufferedImage user45;
	
	static BufferedImage user51;
	static BufferedImage user52;
	static BufferedImage user53;
	static BufferedImage user54;
	static BufferedImage user55;
	
	//OBSTACLES
	static BufferedImage iceObstacleImage;
	
	//TARGETS
	static BufferedImage rocketImage;
	static BufferedImage bonusMissionTargetImage;
	static BufferedImage carriageImage;
	static BufferedImage shipImage;
	
	//ALLIES
	static BufferedImage alderaanCruiserAllyImage;
	static BufferedImage tomcatAllyImage;
	static BufferedImage f22RaptorAllyImage;
	static BufferedImage saabGripenAllyImage;
	static BufferedImage wunderWaffeAllyImage;
	
	//TARGET PLANES
	static BufferedImage f16TargetPlaneImage;
	static BufferedImage republicAttackTargetPlaneImage;
	static BufferedImage imperialShuttleTargetPlaneImage;
	static BufferedImage havocMarauderTargetPlaneImage;
	static BufferedImage bossTargetPlaneImage;
	
	//USER PLANES
	static BufferedImage alderaanCruiserUserPlaneImage;
	static BufferedImage f22RaptorUserPlaneImage;
	static BufferedImage tomcatUserPlaneImage;
	static BufferedImage saabGripenUserPlaneImage;
	static BufferedImage wunderwaffeUserPlaneImage;
	
	//PILOTS
	static BufferedImage nickPilotImage;
	static BufferedImage pennyPilotImage;
	static BufferedImage mikePilotImage;
	static BufferedImage evaPilotImage;
	static BufferedImage neoPilotImage;
	
	//LOCKS
	static BufferedImage damagePackageImage;
	static BufferedImage healthPackageImage;		
	static BufferedImage invisibilityPackageImage;
	static BufferedImage shieldPackageImage;
	static BufferedImage speedPackageImage;
	
	//SHOOTS
	static BufferedImage bulletImage;
	static BufferedImage metalBallImage;
	static BufferedImage flameGunImage;
	static BufferedImage frostLaserImage;
	static BufferedImage laserImage;
	
	//EXPLOSIVES
	static BufferedImage bombImage;
	static BufferedImage missileImage;
	
	//ICONS 
	public static BufferedImage creditsIconImage;
	public static BufferedImage helpIconImage;
	public static BufferedImage homeIconImage;
	public static BufferedImage pauseIconImage;
	public static BufferedImage settingsIconImage;
	public static BufferedImage tickIconImage;
	public static BufferedImage quitIconImage;
	
	//BACKGROUNDS
	public static BufferedImage level1BackgroundImage;
	public static BufferedImage level2BackgroundImage;
	public static BufferedImage level3BackgroundImage;
	public static BufferedImage level4BackgroundImage;
	public static BufferedImage level5BackgroundImage;
	public static BufferedImage level1BackgroundImage2;
	public static BufferedImage level2BackgroundImage2;
	public static BufferedImage level3BackgroundImage2;
	public static BufferedImage level4BackgroundImage2;
	public static BufferedImage level5BackgroundImage2;
	
	public static BufferedImage levelMapBackgroundImage;
	public static BufferedImage mainPageBackgroundImage;
	public static BufferedImage emptyBackgroundImage;
	public static BufferedImage creditsBackgroundImage;
	
	//EXPLOSION
	public static BufferedImage explosionImage;

	public static BufferedImage presentBonusPackageImage;
	public static BufferedImage trapBonusPackageImage;
	
	public static BufferedImage sandObstacleImage;
	public static BufferedImage cityObstacleImage; 
	public static BufferedImage cityObstacleImage2; 
	public static BufferedImage fieldObstacleImage; 
	
	//Instantiates all objects from the folder
	public ImageConstants(){
		try {
			explosionImage = ImageIO.read(getClass().getResource("/explosion.png"));
			homeIconImage = ImageIO.read(getClass().getResource("/home.png"));
			creditsIconImage = ImageIO.read(getClass().getResource("/credits.png"));
			helpIconImage = ImageIO.read(getClass().getResource("/help.png"));
			settingsIconImage = ImageIO.read(getClass().getResource("/settings.png"));
			levelMapBackgroundImage = ImageIO.read(getClass().getResource("/LevelMap.jpg"));
			mainPageBackgroundImage = ImageIO.read(getClass().getResource("/MainPage.png"));
			pauseIconImage = ImageIO.read(getClass().getResource("/pause.png"));
			tickIconImage = ImageIO.read(getClass().getResource("/tick.png"));
			quitIconImage = ImageIO.read(getClass().getResource("/quit.png"));
			
			alderaanCruiserUserPlaneImage = ImageIO.read(getClass().getResource("/AlderaanCruiserUserplane.png"));
			f22RaptorUserPlaneImage = ImageIO.read(getClass().getResource("/F22RaptorUserplane.png"));
			tomcatUserPlaneImage = ImageIO.read(getClass().getResource("/TomcatUserplane.png"));
			saabGripenUserPlaneImage = ImageIO.read(getClass().getResource("/SaabGripenUserplane.png"));
			wunderwaffeUserPlaneImage = ImageIO.read(getClass().getResource("/WunderWaffeUserplane.png"));
			
			nickPilotImage = ImageIO.read(getClass().getResource("/PilotNick.png"));
			pennyPilotImage = ImageIO.read(getClass().getResource("/PilotPenny.png"));
			mikePilotImage = ImageIO.read(getClass().getResource("/PilotMike.png"));
			evaPilotImage = ImageIO.read(getClass().getResource("/PilotEva.png"));
			neoPilotImage = ImageIO.read(getClass().getResource("/PilotNeo.png"));
			
			bulletImage = ImageIO.read(getClass().getResource("/Bullet.png"));
			metalBallImage = ImageIO.read(getClass().getResource("/Metalball.png"));
			flameGunImage = ImageIO.read(getClass().getResource("/Flamegun.png"));
			frostLaserImage = ImageIO.read(getClass().getResource("/Frostlaser.png"));
			laserImage = ImageIO.read(getClass().getResource("/Laser.png"));
			
			bombImage = ImageIO.read(getClass().getResource("/Bomb.png"));
			missileImage = ImageIO.read(getClass().getResource("/Missile.png"));
			
			alderaanCruiserAllyImage =  ImageIO.read(getClass().getResource("/alderaanCruiserAlly.png"));
			tomcatAllyImage =  ImageIO.read(getClass().getResource("/tomcatAlly.png"));
			f22RaptorAllyImage =  ImageIO.read(getClass().getResource("/f22Ally.png"));
			saabGripenAllyImage =  ImageIO.read(getClass().getResource("/saabGripenAlly.png"));
			wunderWaffeAllyImage =  ImageIO.read(getClass().getResource("/wunderWaffeAlly.png"));
			
			f16TargetPlaneImage =  ImageIO.read(getClass().getResource("/E1.png"));
			republicAttackTargetPlaneImage =  ImageIO.read(getClass().getResource("/E2.png"));
			imperialShuttleTargetPlaneImage =  ImageIO.read(getClass().getResource("/E3.png"));
			havocMarauderTargetPlaneImage  =  ImageIO.read(getClass().getResource("/E4.png"));
			bossTargetPlaneImage =  ImageIO.read(getClass().getResource("/boss.png"));
			
	        rocketImage = ImageIO.read(getClass().getResource("/Rocket.png"));
	        carriageImage = ImageIO.read(getClass().getResource("/Carriage.png"));
	        
	        iceObstacleImage =  ImageIO.read(getClass().getResource("/IceObs.png")); 
	        sandObstacleImage =  ImageIO.read(getClass().getResource("/sandObs.png")); 
	        cityObstacleImage =  ImageIO.read(getClass().getResource("/cityObs.png")); 
	        cityObstacleImage2 =  ImageIO.read(getClass().getResource("/cityObs2.png")); 
	        fieldObstacleImage =  ImageIO.read(getClass().getResource("/fieldObs1.png")); 
	        
	        presentBonusPackageImage = ImageIO.read(getClass().getResource("/PlusPack.png"));
	    	trapBonusPackageImage = ImageIO.read(getClass().getResource("/NegPack.png"));
	    	
	    	user11 = ImageIO.read(getClass().getResource("/1_1.png"));
	    	user12 = ImageIO.read(getClass().getResource("/1_2.png"));
	    	user13 = ImageIO.read(getClass().getResource("/1_3.png"));
	    	user14 = ImageIO.read(getClass().getResource("/1_4.png"));
	    	user15 = ImageIO.read(getClass().getResource("/1_5.png"));
	    	
	    	user21 = ImageIO.read(getClass().getResource("/2_1.png"));
	    	user22 = ImageIO.read(getClass().getResource("/2_2.png"));
	    	user23 = ImageIO.read(getClass().getResource("/2_3.png"));
	    	user24 = ImageIO.read(getClass().getResource("/2_4.png"));
	    	user25 = ImageIO.read(getClass().getResource("/2_5.png"));
	        
	    	user31 = ImageIO.read(getClass().getResource("/3_1.png"));
	    	user32 = ImageIO.read(getClass().getResource("/3_2.png"));
	    	user33 = ImageIO.read(getClass().getResource("/3_3.png"));
	    	user34 = ImageIO.read(getClass().getResource("/3_4.png"));
	    	user35 = ImageIO.read(getClass().getResource("/3_5.png"));
	    	
	    	user41 = ImageIO.read(getClass().getResource("/4_1.png"));
	    	user42 = ImageIO.read(getClass().getResource("/4_2.png"));
	    	user43 = ImageIO.read(getClass().getResource("/4_3.png"));
	    	user44 = ImageIO.read(getClass().getResource("/4_4.png"));
	    	user45 = ImageIO.read(getClass().getResource("/4_5.png"));
	    	
	    	user51 = ImageIO.read(getClass().getResource("/5_1.png"));
	    	user52 = ImageIO.read(getClass().getResource("/5_2.png"));
	    	user53 = ImageIO.read(getClass().getResource("/5_3.png"));
	    	user54 = ImageIO.read(getClass().getResource("/5_4.png"));
	    	user55 = ImageIO.read(getClass().getResource("/5_5.png"));
	    	
	    	emptyBackgroundImage = ImageIO.read(getClass().getResource("/emptyBackground.png"));
	    	creditsBackgroundImage = ImageIO.read(getClass().getResource("/CreditsBackground.png"));
	    	
	    	level1BackgroundImage = ImageIO.read(getClass().getResource("/Level1Bck.png"));
	    	level1BackgroundImage2 = ImageIO.read(getClass().getResource("/Level1Bck2.png"));
	    	level2BackgroundImage = ImageIO.read(getClass().getResource("/Level2Bck.png"));
	    	level2BackgroundImage2 = ImageIO.read(getClass().getResource("/Level2Bck2.png"));
	    	level3BackgroundImage = ImageIO.read(getClass().getResource("/Level3Bck.png"));
	    	level3BackgroundImage2 = ImageIO.read(getClass().getResource("/Level3Bck2.png"));
	    	level4BackgroundImage = ImageIO.read(getClass().getResource("/Level4Bck.png"));
	    	level4BackgroundImage2 = ImageIO.read(getClass().getResource("/Level4Bck2.png"));
	    	level5BackgroundImage = ImageIO.read(getClass().getResource("/Level5Bck.png"));
	    	level5BackgroundImage2 = ImageIO.read(getClass().getResource("/Level5Bck2.png"));
	    	
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
