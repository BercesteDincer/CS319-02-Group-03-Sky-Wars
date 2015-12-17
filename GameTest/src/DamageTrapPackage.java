import java.awt.Graphics;
import java.awt.Rectangle;

public class DamageTrapPackage extends TrapBonusPackage {

	private int damageAmount;
	private int effectPeriod;

	public DamageTrapPackage (int damage,int period, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.damageAmount = damage;
		this.effectPeriod = period;
	}

	public int getDamageAmount() {
		return damageAmount;
	}

	public int getEffectPeriod() {
		return effectPeriod;
	}
	
	

}