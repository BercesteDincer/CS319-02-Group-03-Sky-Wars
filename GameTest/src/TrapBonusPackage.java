/**
 * TrapBonusPackage class represents all bonus packages that harm user
 */
public abstract class TrapBonusPackage extends BonusPackage{
	
	//Constructor of target
	public TrapBonusPackage(int positionX, int positionY, int appearTime){
		super( ImageConstants.trapBonusPackageImage, positionX, positionY, appearTime);
		
	}
}
