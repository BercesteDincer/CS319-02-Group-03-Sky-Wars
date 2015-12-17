import java.awt.Graphics;
import java.awt.Rectangle;

public class CoinPackage extends PresentBonusPackage {

	private int coinAmount;

	public CoinPackage (int coin, int positionX, int positionY, int appearTime){
		super( positionX, positionY, appearTime);
		this.coinAmount = coin;
	}

	public int getCoinAmount() {
		return coinAmount;
	}
	

}