
public interface GameObjectInterface {
	public void subscribe(GameManagerObserver observer);
	public void notifyViews();
}
