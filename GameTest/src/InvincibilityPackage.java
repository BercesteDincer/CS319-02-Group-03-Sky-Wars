
public class InvincibilityPackage extends PresentBonusPackage {

	private int effectPeriod;

	public InvincibilityPackage (int period, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.effectPeriod = period;
	}
	
	public int getEffectPeriod() {
		return effectPeriod;
	}
	
	

}