import java.awt.Image;

/**
 * PresentBonusPackage class represents all bonus packages that help user
 */
public abstract class PresentBonusPackage extends BonusPackage{
	
	//Constructor of target
	public PresentBonusPackage(int positionX, int positionY, int appearTime){
		super( ImageConstants.presentBonusPackageImage, positionX, positionY, appearTime);
	}
}
