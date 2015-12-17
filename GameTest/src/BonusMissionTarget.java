import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * BonusMissionTarget class represents targets that give access to bonus mission
 */

public class BonusMissionTarget extends Target{
	
	private static final int BONUS_TARGET_SIZE = 400;
	private int bonusMissionId;
	
	//Constructor of target plane
	public BonusMissionTarget(int bonusMissionId, int health, int locationX, int locationY, int appearTime){
		super(ImageConstants.bonusMissionTargetImage, locationX, locationY, health, appearTime);
		this.bonusMissionId = bonusMissionId;
		setScaledImage(BONUS_TARGET_SIZE);
	}
	
	//Returns bonus mission id
	public int getBonusMissionId(){
		return bonusMissionId;
	}
	
}
